// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.util.Log;
import android.view.ViewGroup;

// Referenced classes of package com.inmobi.monetization.internal:
//            NativeAd, e

class c
    implements Runnable
{

    final ViewGroup a;
    final String b;
    final String c;
    final NativeAd d;

    public void run()
    {
        try
        {
            d.b = new e(a.getContext(), b, c);
            a.addView(d.b);
            return;
        }
        catch (Exception exception)
        {
            Log.e("[InMobi]-[Monetization]", "Failed to attach the view");
        }
        NativeAd.a(d, e);
    }

    (NativeAd nativead, ViewGroup viewgroup, String s, String s1)
    {
        d = nativead;
        a = viewgroup;
        b = s;
        c = s1;
        super();
    }
}
