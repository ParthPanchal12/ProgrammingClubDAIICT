// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.util.Log;

// Referenced classes of package com.inmobi.monetization.internal:
//            NativeAd, e

class a
    implements Runnable
{

    final NativeAd a;

    public void run()
    {
        if (a.b != null)
        {
            a.b.a();
            a.b = null;
            return;
        }
        try
        {
            Log.e("[InMobi]-[Monetization]", "Please attach the native ad view before calling detach");
            NativeAd.a(a, e);
            return;
        }
        catch (Exception exception)
        {
            NativeAd.a(a, e);
        }
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Failed to detach a view");
        return;
    }

    (NativeAd nativead)
    {
        a = nativead;
        super();
    }
}
