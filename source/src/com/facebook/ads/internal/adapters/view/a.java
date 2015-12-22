// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.adapters.e;
import com.facebook.ads.internal.adapters.l;
import com.facebook.ads.internal.adapters.m;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.h;
import com.facebook.ads.internal.view.b;

// Referenced classes of package com.facebook.ads.internal.adapters.view:
//            b

public class a
    implements com.facebook.ads.internal.adapters.view.b
{

    private static final String a = com/facebook/ads/internal/adapters/view/a.getSimpleName();
    private b.a b;
    private b c;
    private l d;
    private m e;
    private e f;
    private long g;
    private long h;
    private com.facebook.ads.internal.util.b.a i;

    public a(InterstitialAdActivity interstitialadactivity, b.a a1)
    {
        b = a1;
        g = System.currentTimeMillis();
        c = new b(interstitialadactivity, new com.facebook.ads.internal.view.b.a(interstitialadactivity) {

            final InterstitialAdActivity a;
            final a b;

            public void a()
            {
                com.facebook.ads.internal.adapters.view.a.b(b).c();
            }

            public void a(int j)
            {
            }

            public void a(String s)
            {
                s = Uri.parse(s);
                if ("fbad".equals(s.getScheme()) && "close".equals(s.getAuthority()))
                {
                    a.finish();
                } else
                {
                    a.a(b).a("com.facebook.ads.interstitial.clicked");
                    s = com.facebook.ads.internal.action.b.a(a, s);
                    if (s != null)
                    {
                        try
                        {
                            a.a(b, s.a());
                            a.a(b, System.currentTimeMillis());
                            s.b();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            Log.e(a.d(), "Error executing action", s);
                        }
                        return;
                    }
                }
            }

            
            {
                b = a.this;
                a = interstitialadactivity;
                super();
            }
        });
        c.setId(0x186a1);
        c.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        e = new m(interstitialadactivity, c, new com.facebook.ads.internal.adapters.c() {

            final a a;

            public void b()
            {
                a.a(a).a("com.facebook.ads.interstitial.impression.logged");
            }

            
            {
                a = a.this;
                super();
            }
        });
        e.d();
        f = new e(interstitialadactivity, c, 1, new com.facebook.ads.internal.adapters.e.a() {

            final a a;

            public void a()
            {
                com.facebook.ads.internal.adapters.view.a.b(a).a();
            }

            
            {
                a = a.this;
                super();
            }
        });
        f.a();
        a1.a(c);
    }

    static long a(a a1, long l1)
    {
        a1.h = l1;
        return l1;
    }

    static b.a a(a a1)
    {
        return a1.b;
    }

    static com.facebook.ads.internal.util.b.a a(a a1, com.facebook.ads.internal.util.b.a a2)
    {
        a1.i = a2;
        return a2;
    }

    static m b(a a1)
    {
        return a1.e;
    }

    static String d()
    {
        return a;
    }

    public void a()
    {
        if (c != null)
        {
            c.onPause();
        }
    }

    public void a(Intent intent, Bundle bundle)
    {
        if (bundle != null && bundle.containsKey("dataModel"))
        {
            d = l.a(bundle.getBundle("dataModel"));
            if (d != null)
            {
                c.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), d.d(), "text/html", "utf-8", null);
            }
        } else
        {
            d = l.b(intent);
            if (d != null)
            {
                e.a(d);
                c.loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), d.d(), "text/html", "utf-8", null);
                return;
            }
        }
    }

    public void a(Bundle bundle)
    {
        if (d != null)
        {
            bundle.putBundle("dataModel", d.j());
        }
    }

    public void b()
    {
        if (h > 0L && i != null)
        {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(h, i, d.i()));
        }
        if (c != null)
        {
            c.onResume();
        }
    }

    public void c()
    {
        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(g, com.facebook.ads.internal.util.b.a.c, d.i()));
        if (f != null)
        {
            f.b();
            f = null;
        }
        if (c != null)
        {
            com.facebook.ads.internal.util.h.a(c);
            c.destroy();
            c = null;
        }
    }

}
