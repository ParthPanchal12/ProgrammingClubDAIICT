// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.dto.c;
import com.facebook.ads.internal.view.a;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            q, i, BannerAdapterListener, p

class a
    implements q
{

    final c a;
    final i b;

    public void a(p p)
    {
        NativeAdViewAttributes nativeadviewattributes = new NativeAdViewAttributes();
        nativeadviewattributes.setButtonTextColor(-1);
        nativeadviewattributes.setButtonBorderColor(0xff8bc615);
        nativeadviewattributes.setButtonColor(0xff8bc615);
        com.facebook.ads.internal.adapters.i.a(b, new a(i.b(b), new NativeAd(i.b(b), p, a), nativeadviewattributes, new com.facebook.ads.internal.view.a.a() {

            final i._cls3 a;

            public void a()
            {
                if (com.facebook.ads.internal.adapters.i.a(a.b) != null)
                {
                    com.facebook.ads.internal.adapters.i.a(a.b).onBannerAdLoaded(a.b, i.f(a.b));
                }
            }

            
            {
                a = i._cls3.this;
                super();
            }
        }));
    }

    public void a(p p, AdError aderror)
    {
        if (com.facebook.ads.internal.adapters.i.a(b) != null)
        {
            com.facebook.ads.internal.adapters.i.a(b).onBannerError(b, aderror);
        }
    }

    _cls1.a(i j, c c)
    {
        b = j;
        a = c;
        super();
    }
}
