// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import com.google.ads.internal.d;
import com.google.ads.internal.g;
import com.google.ads.internal.h;
import com.google.ads.util.a;
import com.google.ads.util.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.ads:
//            c, n, h, m, 
//            a, f, AdRequest

public class e
{

    private final d a;
    private com.google.ads.h b;
    private final Object c;
    private Thread d;
    private final Object e;
    private boolean f;
    private final Object g;

    protected e()
    {
        b = null;
        c = new Object();
        d = null;
        e = new Object();
        f = false;
        g = new Object();
        a = null;
    }

    public e(d d1)
    {
        b = null;
        c = new Object();
        d = null;
        e = new Object();
        f = false;
        g = new Object();
        com.google.ads.util.a.b(d1);
        a = d1;
    }

    static Object a(e e1)
    {
        return e1.e;
    }

    static Thread a(e e1, Thread thread)
    {
        e1.d = thread;
        return thread;
    }

    static void a(e e1, c c1, AdRequest adrequest)
    {
        e1.b(c1, adrequest);
    }

    public static boolean a(c c1, d d1)
    {
        if (c1.j() == null)
        {
            return true;
        }
        if (d1.i().b())
        {
            if (!c1.j().a())
            {
                com.google.ads.util.b.e("InterstitialAd received a mediation response corresponding to a non-interstitial ad. Make sure you specify 'interstitial' as the ad-type in the mediation UI.");
                return false;
            } else
            {
                return true;
            }
        }
        d1 = ((h)d1.i().g.a()).c();
        if (c1.j().a())
        {
            com.google.ads.util.b.e((new StringBuilder()).append("AdView received a mediation response corresponding to an interstitial ad. Make sure you specify the banner ad size corresponding to the AdSize you used in your AdView  (").append(d1).append(") in the ad-type field in the mediation UI.").toString());
            return false;
        }
        c1 = c1.j().c();
        if (c1 != d1)
        {
            com.google.ads.util.b.e((new StringBuilder()).append("Mediation server returned ad size: '").append(c1).append("', while the AdView was created with ad size: '").append(d1).append("'. Using the ad-size passed to the AdView on creation.").toString());
            return false;
        } else
        {
            return true;
        }
    }

    static boolean a(e e1, com.google.ads.h h1)
    {
        return e1.e(h1);
    }

    private boolean a(com.google.ads.h h1, String s)
    {
        if (e() != h1)
        {
            com.google.ads.util.b.c((new StringBuilder()).append("GWController: ignoring callback to ").append(s).append(" from non showing ambassador with adapter class: '").append(h1.h()).append("'.").toString());
            return false;
        } else
        {
            return true;
        }
    }

    private boolean a(String s, Activity activity, AdRequest adrequest, f f1, HashMap hashmap, long l)
    {
        adrequest = new com.google.ads.h(this, (h)a.i().g.a(), f1, s, adrequest, hashmap);
        adrequest;
        JVM INSTR monitorenter ;
        adrequest.a(activity);
_L1:
        if (adrequest.c() || l <= 0L)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        long l1;
        long l2;
        l1 = SystemClock.elapsedRealtime();
        adrequest.wait(l);
        l2 = SystemClock.elapsedRealtime();
        l -= l2 - l1;
          goto _L1
        activity;
        com.google.ads.util.b.a((new StringBuilder()).append("Interrupted while waiting for ad network to load ad using adapter class: ").append(s).toString());
        a.n().a(adrequest.e());
        if (!adrequest.c() || !adrequest.d())
        {
            break MISSING_BLOCK_LABEL_187;
        }
        if (!a.i().b())
        {
            break MISSING_BLOCK_LABEL_179;
        }
        s = null;
_L2:
        ((Handler)com.google.ads.m.a().c.a()).post(new Runnable(adrequest, s, f1) {

            final com.google.ads.h a;
            final View b;
            final f c;
            final e d;

            public void run()
            {
                if (com.google.ads.e.a(d, a))
                {
                    com.google.ads.util.b.a("Trying to switch GWAdNetworkAmbassadors, but GWController().destroy() has been called. Destroying the new ambassador and terminating mediation.");
                    return;
                } else
                {
                    com.google.ads.e.b(d).a(b, a, c, false);
                    return;
                }
            }

            
            {
                d = e.this;
                a = h1;
                b = view;
                c = f1;
                super();
            }
        });
        adrequest;
        JVM INSTR monitorexit ;
        return true;
        s = adrequest.f();
          goto _L2
        if (!adrequest.c())
        {
            com.google.ads.util.b.a((new StringBuilder()).append("Timeout occurred in adapter class: ").append(adrequest.h()).toString());
        }
        adrequest.b();
        adrequest;
        JVM INSTR monitorexit ;
        return false;
        s;
        adrequest;
        JVM INSTR monitorexit ;
        throw s;
    }

    static d b(e e1)
    {
        return e1.a;
    }

    private void b(c c1, AdRequest adrequest)
    {
        HashMap hashmap;
        String s;
        Object obj2;
        long l;
        synchronized (e)
        {
            com.google.ads.util.a.a(Thread.currentThread(), d);
        }
        obj = c1.f();
        Iterator iterator;
        Object obj1;
        String s1;
        if (c1.a())
        {
            l = c1.b();
        } else
        {
            l = 10000L;
        }
        iterator = ((List) (obj)).iterator();
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_284;
        }
        obj2 = (com.google.ads.a)iterator.next();
        com.google.ads.util.b.a((new StringBuilder()).append("Looking to fetch ads from network: ").append(((com.google.ads.a) (obj2)).b()).toString());
        obj1 = ((com.google.ads.a) (obj2)).c();
        hashmap = ((com.google.ads.a) (obj2)).e();
        obj = ((com.google.ads.a) (obj2)).d();
        s = ((com.google.ads.a) (obj2)).a();
        obj2 = ((com.google.ads.a) (obj2)).b();
        s1 = c1.c();
        if (obj == null)
        {
            obj = c1.g();
        }
        obj = new f(s, ((String) (obj2)), s1, ((List) (obj)), c1.h(), c1.i());
        obj1 = ((List) (obj1)).iterator();
_L6:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        s = (String)((Iterator) (obj1)).next();
        obj2 = (Activity)a.i().c.a();
        if (obj2 != null) goto _L2; else goto _L1
_L1:
        com.google.ads.util.b.a("Activity is null while mediating.  Terminating mediation thread.");
_L4:
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
_L2:
        a.n().c();
        if (a(s, ((Activity) (obj2)), adrequest, ((f) (obj)), hashmap, l)) goto _L4; else goto _L3
_L3:
        if (!d()) goto _L6; else goto _L5
_L5:
        com.google.ads.util.b.a("GWController.destroy() called. Terminating mediation thread.");
        return;
        ((Handler)com.google.ads.m.a().c.a()).post(new Runnable(c1) {

            final c a;
            final e b;

            public void run()
            {
                com.google.ads.e.b(b).b(a);
            }

            
            {
                b = e.this;
                a = c1;
                super();
            }
        });
        return;
    }

    static com.google.ads.h c(e e1)
    {
        return e1.b;
    }

    private boolean d()
    {
        boolean flag;
        synchronized (g)
        {
            flag = f;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private com.google.ads.h e()
    {
        com.google.ads.h h1;
        synchronized (c)
        {
            h1 = b;
        }
        return h1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean e(com.google.ads.h h1)
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        if (!d())
        {
            break MISSING_BLOCK_LABEL_22;
        }
        h1.b();
        return true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        h1;
        obj;
        JVM INSTR monitorexit ;
        throw h1;
    }

    public void a(c c1, AdRequest adrequest)
    {
label0:
        {
            synchronized (e)
            {
                if (!a())
                {
                    break label0;
                }
                com.google.ads.util.b.c("Mediation thread is not done executing previous mediation  request. Ignoring new mediation request");
            }
            return;
        }
        if (!c1.d()) goto _L2; else goto _L1
_L1:
        a.a(c1.e());
        if (!a.t())
        {
            a.g();
        }
_L4:
        a(c1, a);
        d = new Thread(new Runnable(c1, adrequest) {

            final c a;
            final AdRequest b;
            final e c;

            public void run()
            {
                com.google.ads.e.a(c, a, b);
                synchronized (com.google.ads.e.a(c))
                {
                    com.google.ads.e.a(c, null);
                }
                return;
                exception;
                obj1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = e.this;
                a = c1;
                b = adrequest;
                super();
            }
        });
        d.start();
        obj;
        JVM INSTR monitorexit ;
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
_L2:
        if (!a.t()) goto _L4; else goto _L3
_L3:
        a.f();
          goto _L4
    }

    public void a(com.google.ads.h h1)
    {
        if (!a(h1, "onPresentScreen"))
        {
            return;
        } else
        {
            ((Handler)com.google.ads.m.a().c.a()).post(new Runnable() {

                final e a;

                public void run()
                {
                    com.google.ads.e.b(a).v();
                }

            
            {
                a = e.this;
                super();
            }
            });
            return;
        }
    }

    public void a(com.google.ads.h h1, View view)
    {
        if (e() != h1)
        {
            com.google.ads.util.b.c((new StringBuilder()).append("GWController: ignoring onAdRefreshed() callback from non-showing ambassador (adapter class name is '").append(h1.h()).append("').").toString());
            return;
        } else
        {
            a.n().a(com.google.ads.g.a.a);
            h1 = b.a();
            ((Handler)com.google.ads.m.a().c.a()).post(new Runnable(view, h1) {

                final View a;
                final f b;
                final e c;

                public void run()
                {
                    com.google.ads.e.b(c).a(a, e.c(c), b, true);
                }

            
            {
                c = e.this;
                a = view;
                b = f1;
                super();
            }
            });
            return;
        }
    }

    public void a(com.google.ads.h h1, boolean flag)
    {
        if (!a(h1, "onAdClicked()"))
        {
            return;
        } else
        {
            h1 = h1.a();
            ((Handler)com.google.ads.m.a().c.a()).post(new Runnable(h1, flag) {

                final f a;
                final boolean b;
                final e c;

                public void run()
                {
                    com.google.ads.e.b(c).a(a, b);
                }

            
            {
                c = e.this;
                a = f1;
                b = flag;
                super();
            }
            });
            return;
        }
    }

    public boolean a()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (d != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        f = true;
        d(null);
        synchronized (e)
        {
            if (d != null)
            {
                d.interrupt();
            }
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(com.google.ads.h h1)
    {
        if (!a(h1, "onDismissScreen"))
        {
            return;
        } else
        {
            ((Handler)com.google.ads.m.a().c.a()).post(new Runnable() {

                final e a;

                public void run()
                {
                    com.google.ads.e.b(a).u();
                }

            
            {
                a = e.this;
                super();
            }
            });
            return;
        }
    }

    public void c(com.google.ads.h h1)
    {
        if (!a(h1, "onLeaveApplication"))
        {
            return;
        } else
        {
            ((Handler)com.google.ads.m.a().c.a()).post(new Runnable() {

                final e a;

                public void run()
                {
                    com.google.ads.e.b(a).w();
                }

            
            {
                a = e.this;
                super();
            }
            });
            return;
        }
    }

    public boolean c()
    {
        com.google.ads.util.a.a(a.i().b());
        com.google.ads.h h1 = e();
        if (h1 != null)
        {
            h1.g();
            return true;
        } else
        {
            com.google.ads.util.b.b("There is no ad ready to show.");
            return false;
        }
    }

    public void d(com.google.ads.h h1)
    {
        synchronized (c)
        {
            if (b != h1)
            {
                if (b != null)
                {
                    b.b();
                }
                b = h1;
            }
        }
        return;
        h1;
        obj;
        JVM INSTR monitorexit ;
        throw h1;
    }
}
