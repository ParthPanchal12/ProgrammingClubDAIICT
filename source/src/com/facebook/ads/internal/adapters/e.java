// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.internal.util.g;

public class e
{
    public static interface a
    {

        public abstract void a();
    }


    private final Context a;
    private final View b;
    private final int c;
    private final a d;
    private final Handler e = new Handler();
    private final Runnable f = new Runnable() {

        final e a;

        public void run()
        {
            if (e.a(a))
            {
                return;
            }
            if (com.facebook.ads.internal.util.g.a(e.b(a), e.c(a), e.d(a)))
            {
                e.e(a).a();
                e.a(a, true);
                return;
            } else
            {
                com.facebook.ads.internal.adapters.e.g(a).postDelayed(e.f(a), 1000L);
                return;
            }
        }

            
            {
                a = e.this;
                super();
            }
    };
    private boolean g;

    public e(Context context, View view, int i, a a1)
    {
        a = context;
        b = view;
        c = i;
        d = a1;
    }

    static boolean a(e e1)
    {
        return e1.g;
    }

    static boolean a(e e1, boolean flag)
    {
        e1.g = flag;
        return flag;
    }

    static Context b(e e1)
    {
        return e1.a;
    }

    static View c(e e1)
    {
        return e1.b;
    }

    static int d(e e1)
    {
        return e1.c;
    }

    static a e(e e1)
    {
        return e1.d;
    }

    static Runnable f(e e1)
    {
        return e1.f;
    }

    static Handler g(e e1)
    {
        return e1.e;
    }

    public void a()
    {
        e.postDelayed(f, 1000L);
    }

    public void b()
    {
        e.removeCallbacks(f);
    }
}
