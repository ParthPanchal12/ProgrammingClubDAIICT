// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.Ad;
import com.google.ads.AdActivity;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.AppEventListener;
import com.google.ads.InterstitialAd;
import com.google.ads.SwipeableAdListener;
import com.google.ads.ae;
import com.google.ads.af;
import com.google.ads.at;
import com.google.ads.b;
import com.google.ads.c;
import com.google.ads.doubleclick.SwipeableDfpAdView;
import com.google.ads.e;
import com.google.ads.f;
import com.google.ads.g;
import com.google.ads.h;
import com.google.ads.l;
import com.google.ads.m;
import com.google.ads.n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.a;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.ads.internal:
//            g, h, e, c, 
//            AdWebView, a, i, ActivationOverlay

public class d
{

    private static final Object a = new Object();
    private String A;
    private String B;
    private final n b;
    private com.google.ads.internal.c c;
    private AdRequest d;
    private com.google.ads.internal.g e;
    private AdWebView f;
    private i g;
    private boolean h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private SharedPreferences o;
    private long p;
    private af q;
    private boolean r;
    private LinkedList s;
    private LinkedList t;
    private LinkedList u;
    private int v;
    private Boolean w;
    private com.google.ads.d x;
    private e y;
    private f z;

    public d(Ad ad, Activity activity, AdSize adsize, String s1, ViewGroup viewgroup, boolean flag)
    {
        h = false;
        v = -1;
        A = null;
        B = null;
        r = flag;
        e = new com.google.ads.internal.g();
        c = null;
        d = null;
        k = false;
        p = 60000L;
        l = false;
        n = false;
        m = true;
        if (adsize == null)
        {
            adsize = com.google.ads.internal.h.a;
        } else
        {
            adsize = com.google.ads.internal.h.a(adsize, activity.getApplicationContext());
        }
        if (ad instanceof SwipeableDfpAdView)
        {
            adsize.a(true);
        }
        if (activity == null)
        {
            m m1 = com.google.ads.m.a();
            InterstitialAd interstitialad;
            if (ad instanceof AdView)
            {
                activity = (AdView)ad;
            } else
            {
                activity = null;
            }
            if (ad instanceof InterstitialAd)
            {
                interstitialad = (InterstitialAd)ad;
            } else
            {
                interstitialad = null;
            }
            b = new n(m1, ad, activity, interstitialad, s1, null, null, viewgroup, adsize, this);
            return;
        }
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        o = activity.getApplicationContext().getSharedPreferences("GoogleAdMobAdsPrefs", 0);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        long l1 = o.getLong((new StringBuilder()).append("Timeout").append(s1).toString(), -1L);
        if (l1 >= 0L) goto _L2; else goto _L1
_L1:
        i = 5000L;
_L3:
        obj;
        JVM INSTR monitorexit ;
        m m2 = com.google.ads.m.a();
        InterstitialAd interstitialad1;
        if (ad instanceof AdView)
        {
            obj = (AdView)ad;
        } else
        {
            obj = null;
        }
        if (ad instanceof InterstitialAd)
        {
            interstitialad1 = (InterstitialAd)ad;
        } else
        {
            interstitialad1 = null;
        }
        b = new n(m2, ad, ((AdView) (obj)), interstitialad1, s1, activity, activity.getApplicationContext(), viewgroup, adsize, this);
        q = new af(this);
        s = new LinkedList();
        t = new LinkedList();
        u = new LinkedList();
        a();
        AdUtil.h((Context)b.f.a());
        x = new com.google.ads.d();
        y = new e(this);
        w = null;
        z = null;
        return;
_L2:
        i = l1;
          goto _L3
        ad;
        obj;
        JVM INSTR monitorexit ;
        throw ad;
        i = 60000L;
          goto _L3
    }

    private void a(f f1, Boolean boolean1)
    {
        Object obj1 = f1.d();
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new ArrayList();
            ((List) (obj)).add("http://e.admob.com/imp?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@&adt=@gw_adt@&aec=@gw_aec@");
        }
        obj1 = f1.b();
        a(((List) (obj)), f1.a(), ((String) (obj1)), f1.c(), boolean1, e.d(), e.e());
    }

    private void a(List list, String s1)
    {
        if (list == null)
        {
            list = new ArrayList();
            list.add("http://e.admob.com/nofill?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&adt=@gw_adt@&aec=@gw_aec@");
        }
        a(list, null, null, s1, null, e.d(), e.e());
    }

    private void a(List list, String s1, String s2, String s3, Boolean boolean1, String s4, String s5)
    {
        String s6 = AdUtil.a((Context)b.f.a());
        Object obj = com.google.ads.b.a();
        String s7 = ((b) (obj)).b().toString();
        obj = ((b) (obj)).c().toString();
        for (list = list.iterator(); list.hasNext(); (new Thread(new ae(com.google.ads.g.a((String)list.next(), (String)b.h.a(), boolean1, s6, s1, s2, s3, s7, ((String) (obj)), s4, s5), (Context)b.f.a()))).start()) { }
        e.b();
    }

    private void b(f f1, Boolean boolean1)
    {
        Object obj1 = f1.e();
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new ArrayList();
            ((List) (obj)).add("http://e.admob.com/clk?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@");
        }
        obj1 = f1.b();
        a(((List) (obj)), f1.a(), ((String) (obj1)), f1.c(), boolean1, null, null);
    }

    public void A()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = h;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (!b.a())
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (!((AdView)b.j.a()).isShown() || !AdUtil.d())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        com.google.ads.util.b.c("Refreshing ad.");
        a(d);
_L3:
        if (!n)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        f();
          goto _L1
        Exception exception;
        exception;
        throw exception;
        com.google.ads.util.b.a("Not refreshing because the ad is not visible.");
          goto _L3
        ((Handler)com.google.ads.m.a().c.a()).postDelayed(q, p);
          goto _L1
        com.google.ads.util.b.a("Tried to refresh an ad that wasn't an AdView.");
          goto _L1
        com.google.ads.util.b.a("Tried to refresh before calling loadAd().");
          goto _L1
    }

    public void B()
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.a.a(b.b());
        if (!k)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        k = false;
        if (w != null) goto _L2; else goto _L1
_L1:
        com.google.ads.util.b.b("isMediationFlag is null in show() with isReady() true. we should have an ad and know whether this is a mediation request or not. ");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!w.booleanValue())
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (y.c())
        {
            a(z, Boolean.valueOf(false));
        }
          goto _L3
        Exception exception;
        exception;
        throw exception;
        AdActivity.launchAdActivity(this, new com.google.ads.internal.e("interstitial"));
        y();
          goto _L3
        com.google.ads.util.b.c("Cannot show interstitial because it is not loaded and ready.");
          goto _L3
    }

    public void C()
    {
        this;
        JVM INSTR monitorenter ;
        if (c != null)
        {
            c.a();
            c = null;
        }
        if (f != null)
        {
            f.stopLoading();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void D()
    {
        this;
        JVM INSTR monitorenter ;
        Activity activity = (Activity)b.c.a();
        if (activity != null) goto _L2; else goto _L1
_L1:
        com.google.ads.util.b.e("activity was null while trying to ping click tracking URLs.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = u.iterator();
        while (iterator.hasNext()) 
        {
            (new Thread(new ae((String)iterator.next(), activity.getApplicationContext()))).start();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected void E()
    {
        this;
        JVM INSTR monitorenter ;
        AdListener adlistener;
        c = null;
        k = true;
        f.setVisibility(0);
        if (b.a())
        {
            a(f);
        }
        e.g();
        if (b.a())
        {
            y();
        }
        com.google.ads.util.b.c("onReceiveAd()");
        adlistener = (AdListener)b.o.a();
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        adlistener.onReceiveAd((Ad)b.a.a());
        b.l.a(b.m.a());
        b.m.a(null);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public LinkedList F()
    {
        return t;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = ((com.google.ads.internal.h)b.g.a()).c();
        if (AdUtil.a < 14)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        obj = new com.google.ads.util.IcsUtil.IcsAdWebView(b, ((AdSize) (obj)));
_L1:
        f = ((AdWebView) (obj));
        f.setVisibility(8);
        g = com.google.ads.internal.i.a(this, a.d, true, b.b());
        f.setWebViewClient(g);
        obj = (com.google.ads.m.a)((m)b.d.a()).b.a();
        if (AdUtil.a < ((Integer)((com.google.ads.m.a) (obj)).b.a()).intValue() && !((com.google.ads.internal.h)b.g.a()).a())
        {
            com.google.ads.util.b.a("Disabling hardware acceleration for a banner.");
            f.g();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        obj = new AdWebView(b, ((AdSize) (obj)));
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public void a(float f1)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = p;
        p = (long)(1000F * f1);
        if (t() && p != l1)
        {
            f();
            g();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        v = i1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        ActivationOverlay activationoverlay = (ActivationOverlay)b.e.a();
        Object obj = (Context)b.f.a();
        int i2;
        int j2;
        if (k1 < 0)
        {
            i2 = ((com.google.ads.internal.h)b.g.a()).c().getWidth();
        } else
        {
            i2 = k1;
        }
        j2 = AdUtil.a(((Context) (obj)), i2);
        obj = (Context)b.f.a();
        i2 = l1;
        if (l1 < 0)
        {
            i2 = ((com.google.ads.internal.h)b.g.a()).c().getHeight();
        }
        obj = new android.widget.FrameLayout.LayoutParams(j2, AdUtil.a(((Context) (obj)), i2));
        if (k1 < 0)
        {
            i1 = 0;
            j1 = 0;
        } else
        {
            k1 = j1;
            j1 = i1;
            i1 = k1;
        }
        if (j1 < 0)
        {
            j1 = ((ActivationOverlay)b.e.a()).d();
        }
        k1 = i1;
        if (i1 < 0)
        {
            k1 = ((ActivationOverlay)b.e.a()).c();
        }
        ((ActivationOverlay)b.e.a()).setXPosition(j1);
        ((ActivationOverlay)b.e.a()).setYPosition(k1);
        ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(AdUtil.a((Context)b.f.a(), j1), AdUtil.a((Context)b.f.a(), k1), 0, 0);
        activationoverlay.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public void a(long l1)
    {
        synchronized (a)
        {
            android.content.SharedPreferences.Editor editor = o.edit();
            editor.putLong((new StringBuilder()).append("Timeout").append(b.h).toString(), l1);
            editor.commit();
            if (r)
            {
                i = l1;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(View view)
    {
        ((ViewGroup)b.i.a()).setVisibility(0);
        ((ViewGroup)b.i.a()).removeAllViews();
        ((ViewGroup)b.i.a()).addView(view);
        if (((com.google.ads.internal.h)b.g.a()).b())
        {
            ((d)b.b.a()).a((l)b.l.a(), false, -1, -1, -1, -1);
            if (((ActivationOverlay)b.e.a()).a())
            {
                ((ViewGroup)b.i.a()).addView((View)b.e.a(), AdUtil.a((Context)b.f.a(), ((com.google.ads.internal.h)b.g.a()).c().getWidth()), AdUtil.a((Context)b.f.a(), ((com.google.ads.internal.h)b.g.a()).c().getHeight()));
            }
        }
    }

    public void a(View view, h h1, f f1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.b.a("AdManager.onReceiveGWhirlAd() called.");
        k = true;
        z = f1;
        if (b.a())
        {
            a(view);
            a(f1, Boolean.valueOf(flag));
        }
        y.d(h1);
        view = (AdListener)b.o.a();
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        view.onReceiveAd((Ad)b.a.a());
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    public void a(com.google.ads.AdRequest.ErrorCode errorcode)
    {
        this;
        JVM INSTR monitorenter ;
        c = null;
        if (errorcode == com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR)
        {
            a(60F);
            if (!t())
            {
                h();
            }
        }
        if (!b.b()) goto _L2; else goto _L1
_L1:
        if (errorcode != com.google.ads.AdRequest.ErrorCode.NO_FILL) goto _L4; else goto _L3
_L3:
        e.B();
_L2:
        AdListener adlistener;
        com.google.ads.util.b.c((new StringBuilder()).append("onFailedToReceiveAd(").append(errorcode).append(")").toString());
        adlistener = (AdListener)b.o.a();
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        adlistener.onFailedToReceiveAd((Ad)b.a.a(), errorcode);
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (errorcode != com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR) goto _L2; else goto _L5
_L5:
        e.z();
          goto _L2
        errorcode;
        throw errorcode;
    }

    public void a(AdRequest adrequest)
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.b.d("v6.4.1 RC00");
        if (!h) goto _L2; else goto _L1
_L1:
        com.google.ads.util.b.e("loadAd called after ad was destroyed.");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!q())
        {
            break MISSING_BLOCK_LABEL_45;
        }
        com.google.ads.util.b.e("loadAd called while the ad is already loading, so aborting.");
          goto _L3
        adrequest;
        throw adrequest;
        if (!AdActivity.isShowing()) goto _L5; else goto _L4
_L4:
        com.google.ads.util.b.e("loadAd called while an interstitial or landing page is displayed, so aborting");
          goto _L3
_L5:
        if (!AdUtil.c((Context)b.f.a()) || !AdUtil.b((Context)b.f.a())) goto _L3; else goto _L6
_L6:
        long l2 = o.getLong("GoogleAdMobDoritosLife", 60000L);
        if (at.a((Context)b.f.a(), l2))
        {
            at.a((Activity)b.c.a());
        }
        k = false;
        s.clear();
        t.clear();
        d = adrequest;
        if (!x.a())
        {
            break MISSING_BLOCK_LABEL_202;
        }
        y.a(x.b(), adrequest);
          goto _L3
        l l1 = new l(b);
        b.m.a(l1);
        c = (com.google.ads.internal.c)l1.b.a();
        c.a(adrequest);
          goto _L3
    }

    public void a(c c1)
    {
        this;
        JVM INSTR monitorenter ;
        c = null;
        y.a(c1, d);
        this;
        JVM INSTR monitorexit ;
        return;
        c1;
        throw c1;
    }

    public void a(f f1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.b.a(String.format(Locale.US, "AdManager.onGWhirlAdClicked(%b) called.", new Object[] {
            Boolean.valueOf(flag)
        }));
        b(f1, Boolean.valueOf(flag));
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        throw f1;
    }

    public void a(l l1, boolean flag, int i1, int j1, int k1, int i2)
    {
label0:
        {
            l1 = (ActivationOverlay)b.e.a();
            boolean flag1;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            l1.setOverlayActivated(flag1);
            a(i1, j1, k1, i2);
            if (b.q.a() != null)
            {
                if (!flag)
                {
                    break label0;
                }
                ((SwipeableAdListener)b.q.a()).onAdActivated((Ad)b.a.a());
            }
            return;
        }
        ((SwipeableAdListener)b.q.a()).onAdDeactivated((Ad)b.a.a());
    }

    public void a(String s1)
    {
        B = s1;
        Object obj = (new android.net.Uri.Builder()).encodedQuery(s1).build();
        s1 = new StringBuilder();
        obj = AdUtil.b(((android.net.Uri) (obj)));
        String s2;
        for (Iterator iterator = ((Map) (obj)).keySet().iterator(); iterator.hasNext(); s1.append(s2).append(" = ").append((String)((Map) (obj)).get(s2)).append("\n"))
        {
            s2 = (String)iterator.next();
        }

        A = s1.toString().trim();
        if (TextUtils.isEmpty(A))
        {
            A = null;
        }
    }

    public void a(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        AppEventListener appeventlistener = (AppEventListener)b.p.a();
        if (appeventlistener == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        appeventlistener.onAppEvent((Ad)b.a.a(), s1, s2);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    protected void a(LinkedList linkedlist)
    {
        this;
        JVM INSTR monitorenter ;
        String s1;
        for (Iterator iterator = linkedlist.iterator(); iterator.hasNext(); com.google.ads.util.b.a((new StringBuilder()).append("Adding a click tracking URL: ").append(s1).toString()))
        {
            s1 = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_57;
        linkedlist;
        throw linkedlist;
        u = linkedlist;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        j = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (y != null)
        {
            y.b();
        }
        b.o.a(null);
        b.p.a(null);
        C();
        f();
        if (f != null)
        {
            f.destroy();
        }
        h = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void b(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        o.edit().putLong("GoogleAdMobDoritosLife", l1).commit();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void b(c c1)
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.b.a("AdManager.onGWhirlNoFill() called.");
        a(c1.i(), c1.c());
        c1 = (AdListener)b.o.a();
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        c1.onFailedToReceiveAd((Ad)b.a.a(), com.google.ads.AdRequest.ErrorCode.NO_FILL);
        this;
        JVM INSTR monitorexit ;
        return;
        c1;
        throw c1;
    }

    protected void b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.b.a((new StringBuilder()).append("Adding a tracking URL: ").append(s1).toString());
        s.add(s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void b(boolean flag)
    {
        w = Boolean.valueOf(flag);
    }

    public String c()
    {
        return A;
    }

    protected void c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.b.a((new StringBuilder()).append("Adding a manual tracking URL: ").append(s1).toString());
        F().add(s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public String d()
    {
        return B;
    }

    public void e()
    {
        this;
        JVM INSTR monitorenter ;
        m = false;
        com.google.ads.util.b.a("Refreshing is no longer allowed on this AdView.");
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void f()
    {
        this;
        JVM INSTR monitorenter ;
        if (!l) goto _L2; else goto _L1
_L1:
        com.google.ads.util.b.a("Disabling refreshing.");
        ((Handler)com.google.ads.m.a().c.a()).removeCallbacks(q);
        l = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        com.google.ads.util.b.a("Refreshing is already disabled.");
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        n = false;
        if (!b.a())
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (!m) goto _L2; else goto _L1
_L1:
        if (l) goto _L4; else goto _L3
_L3:
        com.google.ads.util.b.a((new StringBuilder()).append("Enabling refreshing every ").append(p).append(" milliseconds.").toString());
        ((Handler)com.google.ads.m.a().c.a()).postDelayed(q, p);
        l = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        com.google.ads.util.b.a("Refreshing is already enabled.");
          goto _L5
        Exception exception;
        exception;
        throw exception;
_L2:
        com.google.ads.util.b.a("Refreshing disabled on this AdView");
          goto _L5
        com.google.ads.util.b.a("Tried to enable refreshing on something other than an AdView.");
          goto _L5
    }

    public void h()
    {
        g();
        n = true;
    }

    public n i()
    {
        return b;
    }

    public com.google.ads.d j()
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.d d1 = x;
        this;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    public com.google.ads.internal.c k()
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.internal.c c1 = c;
        this;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    public AdWebView l()
    {
        this;
        JVM INSTR monitorenter ;
        AdWebView adwebview = f;
        this;
        JVM INSTR monitorexit ;
        return adwebview;
        Exception exception;
        exception;
        throw exception;
    }

    public i m()
    {
        this;
        JVM INSTR monitorenter ;
        i i1 = g;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public com.google.ads.internal.g n()
    {
        return e;
    }

    public int o()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = v;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public long p()
    {
        return i;
    }

    public boolean q()
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.internal.c c1 = c;
        boolean flag;
        if (c1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean r()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = j;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean s()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = k;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean t()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = l;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void u()
    {
        this;
        JVM INSTR monitorenter ;
        AdListener adlistener;
        e.C();
        com.google.ads.util.b.c("onDismissScreen()");
        adlistener = (AdListener)b.o.a();
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        adlistener.onDismissScreen((Ad)b.a.a());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void v()
    {
        this;
        JVM INSTR monitorenter ;
        AdListener adlistener;
        com.google.ads.util.b.c("onPresentScreen()");
        adlistener = (AdListener)b.o.a();
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        adlistener.onPresentScreen((Ad)b.a.a());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void w()
    {
        this;
        JVM INSTR monitorenter ;
        AdListener adlistener;
        com.google.ads.util.b.c("onLeaveApplication()");
        adlistener = (AdListener)b.o.a();
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        adlistener.onLeaveApplication((Ad)b.a.a());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void x()
    {
        e.f();
        D();
    }

    public void y()
    {
        this;
        JVM INSTR monitorenter ;
        Activity activity = (Activity)b.c.a();
        if (activity != null) goto _L2; else goto _L1
_L1:
        com.google.ads.util.b.e("activity was null while trying to ping tracking URLs.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = s.iterator();
        while (iterator.hasNext()) 
        {
            (new Thread(new ae((String)iterator.next(), activity.getApplicationContext()))).start();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void z()
    {
        this;
        JVM INSTR monitorenter ;
        Activity activity = (Activity)b.c.a();
        if (activity != null) goto _L2; else goto _L1
_L1:
        com.google.ads.util.b.e("activity was null while trying to ping manual tracking URLs.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = t.iterator();
        while (iterator.hasNext()) 
        {
            (new Thread(new ae((String)iterator.next(), activity.getApplicationContext()))).start();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

}
