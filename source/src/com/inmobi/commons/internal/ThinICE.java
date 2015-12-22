// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.cache.RetryMechanism;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Timer;

// Referenced classes of package com.inmobi.commons.internal:
//            CommonsException, ApplicationFocusManager, InternalSDKUtil, ActivityRecognitionSampler, 
//            Log, JSONPayloadCreator

public final class ThinICE
{

    private static boolean a = false;
    private static boolean b = false;
    private static ThinICEListener c = new ThinICEListener() {

        public void onSamplingTerminated(List list)
        {
            ThinICE.a(list);
            IceDataCollector.stop();
            ActivityRecognitionSampler.stop();
        }

    };
    private static Timer d = new Timer();

    private ThinICE()
    {
    }

    static void a()
    {
        c();
    }

    private static void a(Context context)
        throws CommonsException
    {
        if (!a && context == null)
        {
            throw new CommonsException(1);
        }
        if (!a)
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                ApplicationFocusManager.init(context);
                ApplicationFocusManager.addFocusChangedListener(new ApplicationFocusManager.FocusChangedListener() {

                    public void onFocusChanged(boolean flag)
                    {
                        if (flag)
                        {
                            Log.internal("[InMobi]-4.5.5", "App comes in foreground");
                            ThinICE.a(true);
                            IceDataCollector.start(InternalSDKUtil.getContext());
                            return;
                        } else
                        {
                            Log.internal("[InMobi]-4.5.5", "App goes in background");
                            ThinICE.a(false);
                            ThinICE.a();
                            return;
                        }
                    }

                });
                IceDataCollector.start(context.getApplicationContext());
            } else
            {
                IceDataCollector.setListener(c);
            }
            a = true;
        }
        InternalSDKUtil.initialize(context.getApplicationContext());
        IceDataCollector.setIceDataCollectionListener(new com.inmobi.commons.thinICE.icedatacollector.IceDataCollector.ThinIceDataCollectedListener() {

            public void onDataCollected()
            {
                if (ThinICE.b())
                {
                    ThinICE.a(false);
                    ThinICE.a();
                    IceDataCollector.start(InternalSDKUtil.getContext());
                }
            }

        });
    }

    static void a(String s)
        throws IOException
    {
        b(s);
    }

    static void a(List list)
    {
        b(list);
    }

    static boolean a(boolean flag)
    {
        b = flag;
        return flag;
    }

    private static void b(String s)
        throws IOException
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(AnalyticsInitializer.getConfigParams().getThinIceConfig().getEndpointUrl())).openConnection();
        httpurlconnection.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setDoInput(false);
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(httpurlconnection.getOutputStream());
        outputstreamwriter.write(s);
        outputstreamwriter.flush();
        outputstreamwriter.close();
        httpurlconnection.getResponseCode();
    }

    private static void b(List list)
    {
        if (list.size() == 0 && ActivityRecognitionSampler.getCollectedList().size() == 0)
        {
            Log.internal("[InMobi]-4.5.5", "No ThinICE data is collected. NoOp.");
            return;
        }
        if (!AnalyticsInitializer.getConfigParams().getThinIceConfig().isEnabled())
        {
            Log.internal("[InMobi]-4.5.5", "ThisICE disabled. Not sending data. NoOp.");
            return;
        } else
        {
            RetryMechanism retrymechanism = new RetryMechanism((int)AnalyticsInitializer.getConfigParams().getThinIceConfig().getMaxRetry(), (int)AnalyticsInitializer.getConfigParams().getThinIceConfig().getRetryInterval() * 1000, d);
            String s = (new JSONPayloadCreator()).toPayloadString(list, ActivityRecognitionSampler.getCollectedList(), InternalSDKUtil.getContext());
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Sending ").append(list.size()).append(" ThinICE params to server ").append(s).toString());
            retrymechanism.rescheduleTimer(new com.inmobi.commons.cache.RetryMechanism.RetryRunnable(s) {

                final String a;

                public void completed()
                {
                }

                public void run()
                    throws Exception
                {
                    Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Sending ThinICE data to server ").append(AnalyticsInitializer.getConfigParams().getThinIceConfig().getEndpointUrl()).toString());
                    if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
                    {
                        ThinICE.a(a);
                        return;
                    } else
                    {
                        throw new Exception("Device not connected.");
                    }
                }

            
            {
                a = s;
                super();
            }
            });
            return;
        }
    }

    static boolean b()
    {
        return b;
    }

    private static void c()
    {
        List list = IceDataCollector.getData();
        IceDataCollector.stop();
        b(list);
        ActivityRecognitionSampler.stop();
    }

    public static void setConfig(ThinICEConfig thiniceconfig)
    {
        if (thiniceconfig != null)
        {
            ThinICEConfigSettings thiniceconfigsettings = new ThinICEConfigSettings();
            thiniceconfigsettings.setEnabled(thiniceconfig.isEnabled());
            thiniceconfigsettings.setSampleCellEnabled(thiniceconfig.isCellEnabled());
            thiniceconfigsettings.setSampleCellOperatorEnabled(thiniceconfig.isOperatorEnabled());
            thiniceconfigsettings.setSampleConnectedWifiEnabled(thiniceconfig.isConnectedWifiEnabled());
            thiniceconfigsettings.setSampleHistorySize(thiniceconfig.getSampleHistorySize());
            thiniceconfigsettings.setSampleInterval(thiniceconfig.getSampleInterval() * 1000L);
            thiniceconfigsettings.setSampleLocationEnabled(true);
            thiniceconfigsettings.setSampleVisibleWifiEnabled(thiniceconfig.isVisibleWifiEnabled());
            thiniceconfigsettings.setStopRequestTimeout(thiniceconfig.getStopRequestTimeout() * 1000L);
            thiniceconfigsettings.setWifiFlags(thiniceconfig.getWifiFlags());
            thiniceconfigsettings.setCellOpFlags(thiniceconfig.getCellOpsFlag());
            IceDataCollector.setConfig(thiniceconfigsettings);
        }
    }

    public static void start(Context context)
        throws CommonsException
    {
        if (!InternalSDKUtil.isInitializedSuccessfully(false))
        {
            return;
        }
        a(context);
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            IceDataCollector.start(context);
        }
        ActivityRecognitionSampler.start();
    }

    public static void stop(Context context)
        throws CommonsException
    {
        a(context);
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            c();
        }
    }

}
