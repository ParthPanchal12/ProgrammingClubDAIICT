// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            aJ

public class bz
{

    private static final String a = "ThreadUtil";
    private static int b;

    public bz()
    {
    }

    private static int a()
    {
        com/umeng/message/proguard/bz;
        JVM INSTR monitorenter ;
        int i;
        i = b;
        b = i + 1;
        com/umeng/message/proguard/bz;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static void a(Runnable runnable)
    {
        if (runnable == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        (new Thread(runnable, (new StringBuilder()).append("agoo-thread-").append(a()).toString())).start();
        return;
        runnable;
        aJ.e("ThreadUtil", "startTread", runnable);
        return;
    }
}
