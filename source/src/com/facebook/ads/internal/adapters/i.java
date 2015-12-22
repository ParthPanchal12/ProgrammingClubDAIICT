// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.dto.c;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.util.h;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            BannerAdapter, l, BannerAdapterListener, m, 
//            k, c, q, p

public class i extends BannerAdapter
{

    private static final String a = com/facebook/ads/internal/adapters/i.getSimpleName();
    private b b;
    private m c;
    private BannerAdapterListener d;
    private Map e;
    private k f;
    private a g;
    private Context h;
    private long i;
    private com.facebook.ads.internal.util.b.a j;

    public i()
    {
    }

    static long a(i i1, long l1)
    {
        i1.i = l1;
        return l1;
    }

    static BannerAdapterListener a(i i1)
    {
        return i1.d;
    }

    static com.facebook.ads.internal.util.b.a a(i i1, com.facebook.ads.internal.util.b.a a1)
    {
        i1.j = a1;
        return a1;
    }

    static a a(i i1, a a1)
    {
        i1.g = a1;
        return a1;
    }

    static String a()
    {
        return a;
    }

    static Context b(i i1)
    {
        return i1.h;
    }

    private void b()
    {
        i = 0L;
        j = null;
        l l1 = com.facebook.ads.internal.adapters.l.a("com.facebook.ads.internal.FacebookBannerAdapter", (JSONObject)e.get("data"));
        if (com.facebook.ads.internal.util.f.a(h, l1))
        {
            d.onBannerError(this, AdError.NO_FILL);
        } else
        {
            b = new b(h, new com.facebook.ads.internal.view.b.a(l1) {

                final l a;
                final i b;

                public void a()
                {
                    com.facebook.ads.internal.adapters.i.c(b).c();
                }

                public void a(int i1)
                {
                    if (i1 == 0 && i.d(b) > 0L && i.e(b) != null)
                    {
                        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(i.d(b), i.e(b), a.i()));
                        com.facebook.ads.internal.adapters.i.a(b, 0L);
                        com.facebook.ads.internal.adapters.i.a(b, null);
                    }
                }

                public void a(String s)
                {
                    if (com.facebook.ads.internal.adapters.i.a(b) != null)
                    {
                        com.facebook.ads.internal.adapters.i.a(b).onBannerAdClicked(b);
                    }
                    s = Uri.parse(s);
                    s = com.facebook.ads.internal.action.b.a(com.facebook.ads.internal.adapters.i.b(b), s);
                    if (s == null)
                    {
                        break MISSING_BLOCK_LABEL_74;
                    }
                    com.facebook.ads.internal.adapters.i.a(b, s.a());
                    com.facebook.ads.internal.adapters.i.a(b, System.currentTimeMillis());
                    s.b();
                    return;
                    s;
                    Log.e(com.facebook.ads.internal.adapters.i.a(), "Error executing action", s);
                    return;
                }

            
            {
                b = i.this;
                a = l1;
                super();
            }
            });
            c = new m(h, b, new com.facebook.ads.internal.adapters.c() {

                final i a;

                public void b()
                {
                    if (com.facebook.ads.internal.adapters.i.a(a) != null)
                    {
                        com.facebook.ads.internal.adapters.i.a(a).onBannerLoggingImpression(a);
                    }
                }

            
            {
                a = i.this;
                super();
            }
            });
            c.a(l1);
            b.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), l1.d(), "text/html", "utf-8", null);
            if (d != null)
            {
                d.onBannerAdLoaded(this, b);
                return;
            }
        }
    }

    static m c(i i1)
    {
        return i1.c;
    }

    private void c()
    {
        c c1 = (c)e.get("definition");
        f = new k();
        f.a(h, new q(c1) {

            final c a;
            final i b;

            public void a(p p)
            {
                NativeAdViewAttributes nativeadviewattributes = new NativeAdViewAttributes();
                nativeadviewattributes.setButtonTextColor(-1);
                nativeadviewattributes.setButtonBorderColor(0xff8bc615);
                nativeadviewattributes.setButtonColor(0xff8bc615);
                com.facebook.ads.internal.adapters.i.a(b, new a(com.facebook.ads.internal.adapters.i.b(b), new NativeAd(com.facebook.ads.internal.adapters.i.b(b), p, a), nativeadviewattributes, new com.facebook.ads.internal.view.a.a(this) {

                    final _cls3 a;

                    public void a()
                    {
                        if (com.facebook.ads.internal.adapters.i.a(a.b) != null)
                        {
                            com.facebook.ads.internal.adapters.i.a(a.b).onBannerAdLoaded(a.b, com.facebook.ads.internal.adapters.i.f(a.b));
                        }
                    }

            
            {
                a = _pcls3;
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

            
            {
                b = i.this;
                a = c1;
                super();
            }
        }, e);
    }

    static long d(i i1)
    {
        return i1.i;
    }

    static com.facebook.ads.internal.util.b.a e(i i1)
    {
        return i1.j;
    }

    static a f(i i1)
    {
        return i1.g;
    }

    public void loadBannerAd(Context context, AdSize adsize, BannerAdapterListener banneradapterlistener, Map map)
    {
        h = context;
        d = banneradapterlistener;
        e = map;
        if (adsize == AdSize.RECTANGLE_HEIGHT_250)
        {
            c();
            return;
        } else
        {
            b();
            return;
        }
    }

    public void onDestroy()
    {
        if (b != null)
        {
            com.facebook.ads.internal.util.h.a(b);
            b.destroy();
            b = null;
        }
        if (g != null)
        {
            g.b();
            g = null;
        }
        if (f != null)
        {
            f.onDestroy();
            f = null;
        }
    }

    public void onViewableImpression()
    {
        if (c != null)
        {
            c.a();
        } else
        if (f != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("mil", Boolean.valueOf(false));
            f.a(hashmap);
            return;
        }
    }

}
