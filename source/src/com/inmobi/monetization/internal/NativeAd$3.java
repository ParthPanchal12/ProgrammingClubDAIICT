// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.Log;
import java.util.HashMap;

// Referenced classes of package com.inmobi.monetization.internal:
//            NativeAd, e

class a
    implements Runnable
{

    final HashMap a;
    final NativeAd b;

    public void run()
    {
        try
        {
            b.b.a(a);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Monetization]", "Failed to track click");
        }
    }

    (NativeAd nativead, HashMap hashmap)
    {
        b = nativead;
        a = hashmap;
        super();
    }
}
