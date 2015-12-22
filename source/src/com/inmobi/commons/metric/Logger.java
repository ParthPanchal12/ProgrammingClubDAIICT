// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;


// Referenced classes of package com.inmobi.commons.metric:
//            MetricConfigParams, Queuer, Storage, EventLog

public class Logger
{
    public static interface MetricsCallback
    {

        public abstract void dataCollected(EventLog eventlog);

        public abstract void movedMetricDataToFileMemory(String s);

        public abstract void reportingFailure();

        public abstract void reportingStartedWithRequest(String s);

        public abstract void reportingSuccess();
    }


    private MetricConfigParams a;
    private Integer b;
    private Storage c;
    private Queuer d;
    private MetricsCallback e;

    public Logger(int i, String s)
    {
        a = new MetricConfigParams();
        b = Integer.valueOf(0x7ffffffe);
        c = null;
        d = new Queuer();
        e = null;
        c = new Storage(i, s, d, a);
    }

    public Logger(int i, String s, Storage.PreProcessor preprocessor)
    {
        a = new MetricConfigParams();
        b = Integer.valueOf(0x7ffffffe);
        c = null;
        d = new Queuer();
        e = null;
        c = new Storage(i, s, d, a, preprocessor);
    }

    static Storage a(Logger logger)
    {
        return logger.c;
    }

    protected void finalize()
        throws Throwable
    {
        c.saveToLatest();
        super.finalize();
    }

    public void logEvent(EventLog eventlog)
    {
        c.readNumberOfEventsAndTimeStampFromPersistent();
        if (e != null)
        {
            e.dataCollected(eventlog);
        }
        d.log(eventlog);
        if (d.a() >= (long)a.getDumpThreshhold())
        {
            c.saveLocalCache();
        }
        if (c.getEvents() >= (long)a.getMaxInQueue() || c.getTimestamp() + (long)a.getNextRetryInterval() <= System.currentTimeMillis() / 1000L)
        {
            (new Thread(new Runnable() {

                final Logger a;

                public void run()
                {
                    Logger.a(a).sendFile();
                }

            
            {
                a = Logger.this;
                super();
            }
            })).start();
        }
    }

    public void setCallback(MetricsCallback metricscallback)
    {
        e = metricscallback;
        c.setCallback(metricscallback);
    }

    public void setMetricConfigParams(MetricConfigParams metricconfigparams)
    {
        if (metricconfigparams != null)
        {
            a = metricconfigparams;
            c.a = metricconfigparams;
        }
    }

    public boolean startNewSample()
    {
        Integer integer = b;
        integer;
        JVM INSTR monitorenter ;
        Integer integer1 = b;
        b = Integer.valueOf(b.intValue() + 1);
        if (b.intValue() < a.getSamplingFactor())
        {
            break MISSING_BLOCK_LABEL_57;
        }
        b = Integer.valueOf(0);
        return true;
        integer;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        integer;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
