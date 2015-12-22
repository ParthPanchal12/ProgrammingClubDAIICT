// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.inmobi.commons.internal:
//            ActivityRecognitionManager

public class ActivityRecognitionSampler
{
    public static class ActivitySample
    {

        private long a;
        private int b;

        public int getActivity()
        {
            return b;
        }

        public long getTimestamp()
        {
            return a;
        }

        public ActivitySample(int i, long l)
        {
            b = i;
            a = l;
        }
    }


    static HandlerThread a;
    static Looper b;
    static Handler c;
    static List d = new ArrayList();

    public ActivityRecognitionSampler()
    {
    }

    static void a()
    {
        b();
    }

    private static void b()
    {
        if (AnalyticsInitializer.getConfigParams().getThinIceConfig().isActivityDetectionEnabled())
        {
            Message message = c.obtainMessage(1);
            c.sendMessageDelayed(message, AnalyticsInitializer.getConfigParams().getThinIceConfig().getActivityDetectionInterval());
        }
    }

    public static List getCollectedList()
    {
        if (AnalyticsInitializer.getConfigParams().getThinIceConfig().isActivityDetectionEnabled())
        {
            return d;
        } else
        {
            return Collections.emptyList();
        }
    }

    public static void start()
    {
        if (c.hasMessages(1))
        {
            return;
        } else
        {
            c.sendEmptyMessage(1);
            return;
        }
    }

    public static void stop()
    {
        c.removeMessages(1);
        d.clear();
    }

    static 
    {
        a = new HandlerThread("ActivityDetectionSampler");
        a.start();
        b = a.getLooper();
        c = new Handler(b) {

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 1 1: default 24
            //                           1 25;
                   goto _L1 _L2
_L1:
                return;
_L2:
                int i = ActivityRecognitionManager.getDetectedActivity();
                if (i == -1)
                {
                    break; /* Loop/switch isn't completed */
                }
                if ((long)ActivityRecognitionSampler.d.size() > AnalyticsInitializer.getConfigParams().getThinIceConfig().getActivityDetectionMaxSize())
                {
                    continue; /* Loop/switch isn't completed */
                }
                ActivityRecognitionSampler.d.add(new ActivitySample(i, System.currentTimeMillis()));
                break; /* Loop/switch isn't completed */
                if (true) goto _L1; else goto _L3
_L3:
                ActivityRecognitionSampler.a();
                return;
            }

        };
    }
}
