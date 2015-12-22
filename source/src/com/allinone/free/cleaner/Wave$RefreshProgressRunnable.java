// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;


// Referenced classes of package com.allinone.free.cleaner:
//            Wave

private class <init>
    implements Runnable
{

    final Wave this$0;

    public void run()
    {
        Wave wave = Wave.this;
        wave;
        JVM INSTR monitorenter ;
        Wave wave1;
        long l2;
        long l = System.currentTimeMillis();
        Wave.access$0(Wave.this);
        invalidate();
        l2 = 16L - System.currentTimeMillis() - l;
        wave1 = Wave.this;
        long l1;
        l1 = l2;
        if (l2 < 0L)
        {
            l1 = 0L;
        }
        wave1.postDelayed(this, l1);
        wave;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        wave;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ()
    {
        this$0 = Wave.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
