// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.content.Context;
import com.google.ads.AdSize;

public class h
{

    public static final h a = new h(null, true);
    private AdSize b;
    private boolean c;
    private final boolean d;

    private h(AdSize adsize, boolean flag)
    {
        b = adsize;
        d = flag;
    }

    public static h a(AdSize adsize)
    {
        return a(adsize, null);
    }

    public static h a(AdSize adsize, Context context)
    {
        return new h(AdSize.createAdSize(adsize, context), false);
    }

    public void a(boolean flag)
    {
        c = flag;
    }

    public boolean a()
    {
        return d;
    }

    public void b(AdSize adsize)
    {
        if (!d)
        {
            b = adsize;
        }
    }

    public boolean b()
    {
        return c;
    }

    public AdSize c()
    {
        return b;
    }

}
