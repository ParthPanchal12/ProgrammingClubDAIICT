// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.BannerAd;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.RequestResponseManager;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMErrorCode, IMBannerListener

public final class IMBanner extends RelativeLayout
{

    public static final int INMOBI_AD_UNIT_120X600 = 13;
    public static final int INMOBI_AD_UNIT_300X250 = 10;
    public static final int INMOBI_AD_UNIT_320X48 = 9;
    public static final int INMOBI_AD_UNIT_320X50 = 15;
    public static final int INMOBI_AD_UNIT_468X60 = 12;
    public static final int INMOBI_AD_UNIT_728X90 = 11;
    public static final int REFRESH_INTERVAL_MINIMUM = 0;
    public static final int REFRESH_INTERVAL_OFF = -1;
    IMAdListener a = new IMAdListener() {

        final IMBanner a;

        public void onAdInteraction(Map map)
        {
            IMBanner.a(a, 105, null, map);
        }

        public void onAdRequestFailed(AdErrorCode aderrorcode)
        {
            IMBanner.a(a, 101, aderrorcode, null);
        }

        public void onAdRequestSucceeded()
        {
            IMBanner.a(a, 100, null, null);
        }

        public void onDismissAdScreen()
        {
            IMBanner.a(a, 103, null, null);
        }

        public void onIncentCompleted(Map map)
        {
        }

        public void onLeaveApplication()
        {
            IMBanner.a(a, 104, null, null);
        }

        public void onShowAdScreen()
        {
            IMBanner.a(a, 102, null, null);
        }

            
            {
                a = IMBanner.this;
                super();
            }
    };
    private BannerAd b;
    private IMBannerListener c;
    private boolean d;
    private Activity e;
    private String f;
    private long g;
    private int h;

    public IMBanner(Activity activity, long l)
    {
        super(activity);
        d = true;
        f = null;
        g = -1L;
        h = 15;
        e = activity;
        g = l;
        a();
    }

    public IMBanner(Activity activity, String s, int i)
    {
        super(activity);
        d = true;
        f = null;
        g = -1L;
        h = 15;
        f = s;
        h = i;
        e = activity;
        a();
    }

    public IMBanner(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = true;
        f = null;
        g = -1L;
        h = 15;
        e = (Activity)context;
        try
        {
            g = Long.parseLong(attributeset.getAttributeValue(null, "slotId"));
            a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        try
        {
            h = Integer.parseInt(attributeset.getAttributeValue(null, "adSize"));
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        try
        {
            f = attributeset.getAttributeValue(null, "appId");
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        a();
    }

    static IMBannerListener a(IMBanner imbanner)
    {
        return imbanner.c;
    }

    private void a()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (g > 0L)
        {
            b = new BannerAd(e, this, g, 15);
        } else
        {
            b = new BannerAd(e, this, f, h);
        }
        b.setAdListener(a);
        setRefreshInterval(Initializer.getConfigParams().getDefaultRefreshRate());
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        addView(b.getView(), layoutparams);
    }

    private void a(int i, AdErrorCode aderrorcode, Map map)
    {
        if (!d)
        {
            Log.debug("[InMobi]-[Monetization]", "Banner not sending callback because the view is not added to any window.");
        } else
        if (c != null)
        {
            e.runOnUiThread(new Runnable(i, aderrorcode, map) {

                final int a;
                final AdErrorCode b;
                final Map c;
                final IMBanner d;

                public void run()
                {
                    a;
                    JVM INSTR tableswitch 100 105: default 180
                //                               100 57
                //                               101 84
                //                               102 125
                //                               103 108
                //                               104 142
                //                               105 159;
                       goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                    Log.debug("[InMobi]-[Monetization]", b.toString());
                    return;
_L2:
                    try
                    {
                        IMBanner.a(d).onBannerRequestSucceeded(d);
                        return;
                    }
                    catch (Exception exception)
                    {
                        Log.debug("[InMobi]-[Monetization]", "Exception giving callback to the publisher ", exception);
                    }
                    return;
_L3:
                    IMBanner.a(d).onBannerRequestFailed(d, IMErrorCode.a(b));
                    return;
_L5:
                    IMBanner.a(d).onDismissBannerScreen(d);
                    return;
_L4:
                    IMBanner.a(d).onShowBannerScreen(d);
                    return;
_L6:
                    IMBanner.a(d).onLeaveApplication(d);
                    return;
_L7:
                    IMBanner.a(d).onBannerInteraction(d, c);
                    return;
                }

            
            {
                d = IMBanner.this;
                a = i;
                b = aderrorcode;
                c = map;
                super();
            }
            });
            return;
        }
    }

    static void a(IMBanner imbanner, int i, AdErrorCode aderrorcode, Map map)
    {
        imbanner.a(i, aderrorcode, map);
    }

    private void b()
    {
        float f1;
        int j;
        j = 320;
        f1 = e.getResources().getDisplayMetrics().density;
        h;
        JVM INSTR tableswitch 9 15: default 64
    //                   9 117
    //                   10 123
    //                   11 134
    //                   12 144
    //                   13 154
    //                   14 64
    //                   15 164;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L7
_L1:
        int i;
        j = getLayoutParams().width;
        i = getLayoutParams().height;
_L9:
        j = (int)((float)j * f1);
        i = (int)((float)i * f1);
        getLayoutParams().height = i;
        getLayoutParams().width = j;
        setLayoutParams(getLayoutParams());
        return;
_L2:
        i = 48;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 300;
        i = 250;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 729;
        i = 90;
        continue; /* Loop/switch isn't completed */
_L5:
        j = 468;
        i = 60;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 120;
        i = 600;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 50;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void destroy()
    {
    }

    public void disableHardwareAcceleration()
    {
        if (b != null)
        {
            b.disableHardwareAcceleration();
        }
    }

    public void loadBanner()
    {
        if (b != null)
        {
            b.loadAd();
            return;
        } else
        {
            IMErrorCode imerrorcode = IMErrorCode.INVALID_REQUEST;
            imerrorcode.setMessage("Banner Ad instance not created with valid paramters");
            c.onBannerRequestFailed(this, imerrorcode);
            Log.verbose("[InMobi]-[Monetization]", "Banner Ad instance not created with valid paramters");
            return;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        b();
        Log.debug("[InMobi]-[Monetization]", "onAttachedToWindow");
        d = true;
    }

    protected void onDetachedFromWindow()
    {
        d = false;
        super.onDetachedFromWindow();
    }

    protected final void onWindowVisibilityChanged(int i)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        RequestResponseManager requestresponsemanager;
        try
        {
            ThinICE.start(e);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Cannot start ice. Activity is null");
        }
        if (b != null)
        {
            b.refreshAd();
        }
_L4:
        requestresponsemanager = new RequestResponseManager();
        requestresponsemanager.init();
        requestresponsemanager.processClick(e.getApplicationContext(), null);
        return;
_L2:
        if (b != null)
        {
            b.stopRefresh();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setAdSize(int i)
    {
        if (b != null)
        {
            b.setAdSize(i);
            h = i;
        }
    }

    public void setAnimationType(AnimationType animationtype)
    {
        if (b != null)
        {
            b.setAnimation(animationtype);
        }
    }

    public void setAppId(String s)
    {
        if (b != null)
        {
            b.setAppId(s);
        }
    }

    public void setIMBannerListener(IMBannerListener imbannerlistener)
    {
        c = imbannerlistener;
    }

    public void setKeywords(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.debug("[InMobi]-[Monetization]", "Keywords cannot be null or blank.");
        } else
        if (b != null)
        {
            b.setKeywords(s);
            return;
        }
    }

    public void setRefTagParam(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be null");
        } else
        {
            if (s.trim().equals("") || s1.trim().equals(""))
            {
                Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be empty");
                return;
            }
            HashMap hashmap = new HashMap();
            hashmap.put(s, s1);
            if (b != null)
            {
                b.setRequestParams(hashmap);
                return;
            }
        }
    }

    public void setRefreshInterval(int i)
    {
        if (b != null)
        {
            b.setRefreshInterval(i);
        }
    }

    public void setRequestParams(Map map)
    {
        if (map == null || map.isEmpty())
        {
            Log.debug("[InMobi]-[Monetization]", "Request params cannot be null or empty.");
        } else
        if (b != null)
        {
            b.setRequestParams(map);
            return;
        }
    }

    public void setSlotId(long l)
    {
        if (b != null)
        {
            b.setSlotId(l);
        }
    }

    public void stopLoading()
    {
        if (b != null)
        {
            b.stopLoading();
        }
    }
}
