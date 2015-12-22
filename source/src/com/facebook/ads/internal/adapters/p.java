// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.Map;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            AdAdapter, q

public abstract class p
    implements AdAdapter
{

    public p()
    {
    }

    public abstract void a(int i1);

    public abstract void a(Context context, q q, Map map);

    public abstract void a(Map map);

    public abstract boolean a();

    public abstract com.facebook.ads.NativeAd.Image b();

    public abstract void b(Map map);

    public abstract com.facebook.ads.NativeAd.Image c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public final AdPlacementType getPlacementType()
    {
        return AdPlacementType.NATIVE;
    }

    public abstract String h();

    public abstract com.facebook.ads.NativeAd.Rating i();

    public abstract String j();

    public abstract com.facebook.ads.NativeAd.Image k();

    public abstract String l();

    public abstract boolean m();
}
