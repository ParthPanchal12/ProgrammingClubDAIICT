// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.lang.ref.WeakReference;

public class af
    implements Runnable
{

    private WeakReference a;

    public af(d d1)
    {
        a = new WeakReference(d1);
    }

    public void run()
    {
        d d1 = (d)a.get();
        if (d1 == null)
        {
            b.a("The ad must be gone, so cancelling the refresh timer.");
            return;
        } else
        {
            d1.A();
            return;
        }
    }
}
