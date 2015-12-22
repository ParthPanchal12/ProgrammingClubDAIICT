// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.proc;

import android.content.Context;
import android.util.Log;

// Referenced classes of package org.android.agoo.proc:
//            d

class ServiceProtect
{

    private static final String a = "ServiceProtect";
    private static volatile boolean b = false;

    ServiceProtect()
    {
    }

    private static int a(String s, String s1, String s2, int i)
    {
        if (!b)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        i = start(s, s1, s2, i);
        return i;
        s;
        Log.e("ServiceProtect", "startp", s);
        return -1;
    }

    static void a(Context context)
    {
        if (d.a(context).b().a())
        {
            d.a(context).a();
            d.a(context).c();
        }
        b = true;
    }

    static void a(Context context, String s, String s1, String s2, int i)
    {
        if (c())
        {
            a(s, s1, s2, i);
        }
    }

    static boolean a()
    {
        return b;
    }

    static void b()
    {
        if (!b)
        {
            break MISSING_BLOCK_LABEL_9;
        }
        stop();
        return;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        return;
    }

    static boolean c()
    {
        if (!b)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        int i = hasRted();
_L1:
        Throwable throwable;
        return i == 1;
        throwable;
        throwable.printStackTrace();
        i = 0;
          goto _L1
    }

    private static native int hasRted();

    private static native int start(String s, String s1, String s2, int i);

    private static native void startTest(String s, String s1, String s2, int i);

    private static native void stop();

}
