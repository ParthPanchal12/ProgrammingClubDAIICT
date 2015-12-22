// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;

import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.commons.metric:
//            EventLog

public class Queuer
{

    private StringBuffer a;
    private long b;

    public Queuer()
    {
        a = new StringBuffer();
        b = 0L;
    }

    long a()
    {
        return b;
    }

    public String get()
    {
        Log.internal("[InMobi]-4.5.5", "Reading from queue");
        String s;
        synchronized (a)
        {
            s = a.toString();
        }
        return s;
        exception;
        stringbuffer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void log(EventLog eventlog)
    {
        synchronized (a)
        {
            a.append(eventlog.toString()).append(',');
            b = b + 1L;
        }
        return;
        eventlog;
        stringbuffer;
        JVM INSTR monitorexit ;
        throw eventlog;
    }

    public void reset()
    {
        Log.internal("[InMobi]-4.5.5", "Resetting queue");
        synchronized (a)
        {
            a = new StringBuffer();
            b = 0L;
        }
        return;
        exception;
        stringbuffer;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
