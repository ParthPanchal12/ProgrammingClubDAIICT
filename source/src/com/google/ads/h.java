// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.util.a;
import com.google.ads.util.b;
import java.util.HashMap;

// Referenced classes of package com.google.ads:
//            m, i, f, e, 
//            AdRequest

public class h
{

    final com.google.ads.internal.h a;
    private final f b;
    private boolean c;
    private boolean d;
    private g.a e;
    private final e f;
    private MediationAdapter g;
    private boolean h;
    private boolean i;
    private View j;
    private final String k;
    private final AdRequest l;
    private final HashMap m;

    public h(e e1, com.google.ads.internal.h h1, f f1, String s, AdRequest adrequest, HashMap hashmap)
    {
        com.google.ads.util.a.b(TextUtils.isEmpty(s));
        f = e1;
        a = h1;
        b = f1;
        k = s;
        l = adrequest;
        m = hashmap;
        c = false;
        d = false;
        e = null;
        g = null;
        h = false;
        i = false;
        j = null;
    }

    static MediationAdapter a(h h1)
    {
        return h1.g;
    }

    public f a()
    {
        return b;
    }

    public void a(Activity activity)
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.a.b(h, "startLoadAdTask has already been called.");
        h = true;
        ((Handler)com.google.ads.m.a().c.a()).post(new i(this, activity, k, l, m));
        this;
        JVM INSTR monitorexit ;
        return;
        activity;
        throw activity;
    }

    void a(View view)
    {
        this;
        JVM INSTR monitorenter ;
        j = view;
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    void a(MediationAdapter mediationadapter)
    {
        this;
        JVM INSTR monitorenter ;
        g = mediationadapter;
        this;
        JVM INSTR monitorexit ;
        return;
        mediationadapter;
        throw mediationadapter;
    }

    void a(boolean flag, g.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        d = flag;
        c = true;
        e = a1;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        a1;
        throw a1;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.a.a(h, "destroy() called but startLoadAdTask has not been called.");
        ((Handler)com.google.ads.m.a().c.a()).post(new Runnable() {

            final h a;

            public void run()
            {
                if (a.l())
                {
                    com.google.ads.util.a.b(com.google.ads.h.a(a));
                    try
                    {
                        com.google.ads.h.a(a).destroy();
                    }
                    catch (Throwable throwable)
                    {
                        com.google.ads.util.b.b((new StringBuilder()).append("Error while destroying adapter (").append(a.h()).append("):").toString(), throwable);
                        return;
                    }
                    com.google.ads.util.b.a((new StringBuilder()).append("Called destroy() for adapter with class: ").append(com.google.ads.h.a(a).getClass().getName()).toString());
                }
            }

            
            {
                a = h.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = c;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        com.google.ads.util.a.a(c, "isLoadAdTaskSuccessful() called when isLoadAdTaskDone() is false.");
        flag = d;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public g.a e()
    {
        this;
        JVM INSTR monitorenter ;
        if (e != null) goto _L2; else goto _L1
_L1:
        g.a a1 = g.a.d;
_L4:
        this;
        JVM INSTR monitorexit ;
        return a1;
_L2:
        a1 = e;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public View f()
    {
        this;
        JVM INSTR monitorenter ;
        View view;
        com.google.ads.util.a.a(c, "getAdView() called when isLoadAdTaskDone() is false.");
        view = j;
        this;
        JVM INSTR monitorexit ;
        return view;
        Exception exception;
        exception;
        throw exception;
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        com.google.ads.util.a.a(a.a());
        MediationInterstitialAdapter mediationinterstitialadapter = (MediationInterstitialAdapter)g;
        ((Handler)com.google.ads.m.a().c.a()).post(new Runnable(mediationinterstitialadapter) {

            final MediationInterstitialAdapter a;
            final h b;

            public void run()
            {
                try
                {
                    a.showInterstitial();
                    return;
                }
                catch (Throwable throwable)
                {
                    com.google.ads.util.b.b((new StringBuilder()).append("Error while telling adapter (").append(b.h()).append(") ad to show interstitial: ").toString(), throwable);
                }
            }

            
            {
                b = h.this;
                a = mediationinterstitialadapter;
                super();
            }
        });
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        com.google.ads.util.b.b("In Ambassador.show(): ambassador.adapter does not implement the MediationInterstitialAdapter interface.", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public String h()
    {
        this;
        JVM INSTR monitorenter ;
        if (g == null) goto _L2; else goto _L1
_L1:
        String s = g.getClass().getName();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = "\"adapter was not created.\"";
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    MediationAdapter i()
    {
        this;
        JVM INSTR monitorenter ;
        MediationAdapter mediationadapter = g;
        this;
        JVM INSTR monitorexit ;
        return mediationadapter;
        Exception exception;
        exception;
        throw exception;
    }

    e j()
    {
        return f;
    }

    void k()
    {
        this;
        JVM INSTR monitorenter ;
        i = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    boolean l()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = i;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }
}
