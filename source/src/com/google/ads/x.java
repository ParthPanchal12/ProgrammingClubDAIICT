// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.d;
import com.google.ads.internal.h;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.g;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            o, n, m, al

public class x
    implements o
{

    public x()
    {
    }

    private void a(HashMap hashmap, String s, com.google.ads.util.i.c c1)
    {
        try
        {
            hashmap = (String)hashmap.get(s);
            if (!TextUtils.isEmpty(hashmap))
            {
                c1.a(Integer.valueOf(hashmap));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            com.google.ads.util.b.a((new StringBuilder()).append("Could not parse \"").append(s).append("\" constant.").toString());
        }
    }

    private void b(HashMap hashmap, String s, com.google.ads.util.i.c c1)
    {
        try
        {
            hashmap = (String)hashmap.get(s);
            if (!TextUtils.isEmpty(hashmap))
            {
                c1.a(Long.valueOf(hashmap));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            com.google.ads.util.b.a((new StringBuilder()).append("Could not parse \"").append(s).append("\" constant.").toString());
        }
    }

    private void c(HashMap hashmap, String s, com.google.ads.util.i.c c1)
    {
        hashmap = (String)hashmap.get(s);
        if (!TextUtils.isEmpty(hashmap))
        {
            c1.a(hashmap);
        }
    }

    public void a(d d1, HashMap hashmap, WebView webview)
    {
        n n1 = d1.i();
        m.a a1 = (m.a)((m)n1.d.a()).b.a();
        c(hashmap, "as_domains", a1.a);
        c(hashmap, "bad_ad_report_path", a1.h);
        a(hashmap, "min_hwa_banner", a1.b);
        a(hashmap, "min_hwa_activation_overlay", a1.c);
        a(hashmap, "min_hwa_overlay", a1.d);
        c(hashmap, "mraid_banner_path", a1.e);
        c(hashmap, "mraid_expanded_banner_path", a1.f);
        c(hashmap, "mraid_interstitial_path", a1.g);
        b(hashmap, "ac_max_size", a1.i);
        b(hashmap, "ac_padding", a1.j);
        b(hashmap, "ac_total_quota", a1.k);
        b(hashmap, "db_total_quota", a1.l);
        b(hashmap, "db_quota_per_origin", a1.m);
        b(hashmap, "db_quota_step_size", a1.n);
        d1 = d1.l();
        if (AdUtil.a >= 11)
        {
            g.a(d1.getSettings(), n1);
            g.a(webview.getSettings(), n1);
        }
        boolean flag;
        boolean flag1;
        if (!((h)n1.g.a()).a())
        {
            flag1 = d1.k();
            if (AdUtil.a < ((Integer)a1.b.a()).intValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && flag1)
            {
                com.google.ads.util.b.a("Re-enabling hardware acceleration for a banner after reading constants.");
                d1.h();
            } else
            if (flag && !flag1)
            {
                com.google.ads.util.b.a("Disabling hardware acceleration for a banner after reading constants.");
                d1.g();
            }
        }
        d1 = (ActivationOverlay)n1.e.a();
        if (!((h)n1.g.a()).b() && d1 != null)
        {
            flag1 = d1.k();
            if (AdUtil.a < ((Integer)a1.c.a()).intValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && flag1)
            {
                com.google.ads.util.b.a("Re-enabling hardware acceleration for an activation overlay after reading constants.");
                d1.h();
            } else
            if (flag && !flag1)
            {
                com.google.ads.util.b.a("Disabling hardware acceleration for an activation overlay after reading constants.");
                d1.g();
            }
        }
        d1 = (String)a1.a.a();
        hashmap = (al)n1.s.a();
        if (hashmap != null && !TextUtils.isEmpty(d1))
        {
            hashmap.a(d1);
        }
        a1.o.a(Boolean.valueOf(true));
    }
}
