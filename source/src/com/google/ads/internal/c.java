// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.ak;
import com.google.ads.al;
import com.google.ads.d;
import com.google.ads.l;
import com.google.ads.m;
import com.google.ads.n;
import com.google.ads.searchads.SearchAdRequest;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

// Referenced classes of package com.google.ads.internal:
//            AdWebView, d, a, i, 
//            f, g, h, ActivationOverlay

public class com.google.ads.internal.c
    implements Runnable
{
    private static class a
        implements Runnable
    {

        private final com.google.ads.internal.d a;
        private final WebView b;
        private final f c;
        private final com.google.ads.AdRequest.ErrorCode d;
        private final boolean e;

        public void run()
        {
            if (b != null)
            {
                b.stopLoading();
                b.destroy();
            }
            if (c != null)
            {
                c.a();
            }
            if (e)
            {
                a.l().stopLoading();
                if (a.i().i.a() != null)
                {
                    ((ViewGroup)a.i().i.a()).setVisibility(8);
                }
            }
            a.a(d);
        }

        public a(com.google.ads.internal.d d1, WebView webview, f f1, com.google.ads.AdRequest.ErrorCode errorcode, boolean flag)
        {
            a = d1;
            b = webview;
            c = f1;
            d = errorcode;
            e = flag;
        }
    }

    private class b extends Exception
    {

        final com.google.ads.internal.c a;

        public b(String s1)
        {
            a = com.google.ads.internal.c.this;
            super(s1);
        }
    }

    private class c
        implements Runnable
    {

        final com.google.ads.internal.c a;
        private final String b;
        private final String c;
        private final WebView d;

        public void run()
        {
            com.google.ads.internal.c.b(a).c.a(Boolean.valueOf(com.google.ads.internal.c.a(a)));
            ((com.google.ads.internal.d)((n)com.google.ads.internal.c.b(a).a.a()).b.a()).l().a(com.google.ads.internal.c.a(a));
            if (((n)com.google.ads.internal.c.b(a).a.a()).e.a() != null)
            {
                ActivationOverlay activationoverlay = (ActivationOverlay)((n)com.google.ads.internal.c.b(a).a.a()).e.a();
                boolean flag;
                if (!com.google.ads.internal.c.a(a))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                activationoverlay.setOverlayEnabled(flag);
            }
            if (c != null)
            {
                d.loadDataWithBaseURL(b, c, "text/html", "utf-8", null);
                return;
            } else
            {
                d.loadUrl(b);
                return;
            }
        }

        public c(WebView webview, String s1, String s2)
        {
            a = com.google.ads.internal.c.this;
            super();
            d = webview;
            b = s1;
            c = s2;
        }
    }

    public static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        private static final d f[];
        public String e;

        public static d valueOf(String s1)
        {
            return (d)Enum.valueOf(com/google/ads/internal/c$d, s1);
        }

        public static d[] values()
        {
            return (d[])f.clone();
        }

        static 
        {
            a = new d("ONLINE_USING_BUFFERED_ADS", 0, "online_buffered");
            b = new d("ONLINE_SERVER_REQUEST", 1, "online_request");
            c = new d("OFFLINE_USING_BUFFERED_ADS", 2, "offline_buffered");
            d = new d("OFFLINE_EMPTY", 3, "offline_empty");
            f = (new d[] {
                a, b, c, d
            });
        }

        private d(String s1, int i1, String s2)
        {
            super(s1, i1);
            e = s2;
        }
    }

    private class e
        implements Runnable
    {

        final com.google.ads.internal.c a;
        private final com.google.ads.internal.d b;
        private final WebView c;
        private final LinkedList d;
        private final int e;
        private final boolean f;
        private final String g;
        private final AdSize h;

        public void run()
        {
            if (c != null)
            {
                c.stopLoading();
                c.destroy();
            }
            b.a(d);
            b.a(e);
            b.a(f);
            b.a(g);
            if (h != null)
            {
                ((h)((n)com.google.ads.internal.c.b(a).a.a()).g.a()).b(h);
                b.l().setAdSize(h);
            }
            b.E();
        }

        public e(com.google.ads.internal.d d1, WebView webview, LinkedList linkedlist, int i1, boolean flag, String s1, 
                AdSize adsize)
        {
            a = com.google.ads.internal.c.this;
            super();
            b = d1;
            c = webview;
            d = linkedlist;
            e = i1;
            f = flag;
            g = s1;
            h = adsize;
        }
    }


    boolean a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private f g;
    private AdRequest h;
    private WebView i;
    private l j;
    private String k;
    private String l;
    private LinkedList m;
    private String n;
    private AdSize o;
    private boolean p;
    private volatile boolean q;
    private boolean r;
    private com.google.ads.AdRequest.ErrorCode s;
    private boolean t;
    private int u;
    private Thread v;
    private boolean w;
    private d x;

    protected com.google.ads.internal.c()
    {
        p = false;
        x = com.google.ads.internal.d.b;
    }

    public com.google.ads.internal.c(l l1)
    {
        p = false;
        x = com.google.ads.internal.d.b;
        j = l1;
        k = null;
        b = null;
        c = null;
        d = null;
        m = new LinkedList();
        s = null;
        t = false;
        u = -1;
        f = false;
        r = false;
        n = null;
        o = null;
        if ((Activity)((n)l1.a.a()).c.a() != null)
        {
            i = new AdWebView((n)l1.a.a(), null);
            i.setWebViewClient(com.google.ads.internal.i.a((com.google.ads.internal.d)((n)l1.a.a()).b.a(), com.google.ads.internal.a.b, false, false));
            i.setVisibility(8);
            i.setWillNotDraw(true);
            g = new f(l1);
            return;
        } else
        {
            i = null;
            g = null;
            com.google.ads.util.b.e("activity was null while trying to create an AdLoader.");
            return;
        }
    }

    static void a(String s1, com.google.ads.c c1, com.google.ads.d d1)
    {
        while (s1 == null || s1.contains("no-store") || s1.contains("no-cache")) 
        {
            return;
        }
        Matcher matcher = Pattern.compile("max-age\\s*=\\s*(\\d+)").matcher(s1);
        if (matcher.find())
        {
            try
            {
                int i1 = Integer.parseInt(matcher.group(1));
                d1.a(c1, i1);
                com.google.ads.util.b.c(String.format(Locale.US, "Caching gWhirl configuration for: %d seconds", new Object[] {
                    Integer.valueOf(i1)
                }));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                com.google.ads.util.b.b("Caught exception trying to parse cache control directive. Overflow?", s1);
            }
            return;
        } else
        {
            com.google.ads.util.b.c((new StringBuilder()).append("Unrecognized cacheControlDirective: '").append(s1).append("'. Not caching configuration.").toString());
            return;
        }
    }

    static boolean a(com.google.ads.internal.c c1)
    {
        return c1.p;
    }

    static l b(com.google.ads.internal.c c1)
    {
        return c1.j;
    }

    private void b(String s1, String s2)
    {
        ((Handler)com.google.ads.m.a().c.a()).post(new c(i, s2, s1));
    }

    static String c(com.google.ads.internal.c c1)
    {
        return c1.l;
    }

    static WebView d(com.google.ads.internal.c c1)
    {
        return c1.i;
    }

    private String d()
    {
        if (h instanceof SearchAdRequest)
        {
            return "AFMA_buildAdURL";
        } else
        {
            return "AFMA_buildAdURL";
        }
    }

    private String e()
    {
        if (h instanceof SearchAdRequest)
        {
            return "AFMA_getSdkConstants();";
        } else
        {
            return "AFMA_getSdkConstants();";
        }
    }

    static String e(com.google.ads.internal.c c1)
    {
        return c1.n;
    }

    static AdSize f(com.google.ads.internal.c c1)
    {
        return c1.o;
    }

    private String f()
    {
        if (h instanceof SearchAdRequest)
        {
            return "http://www.gstatic.com/safa/";
        } else
        {
            return "http://media.admob.com/";
        }
    }

    private String g()
    {
        if (h instanceof SearchAdRequest)
        {
            return "<html><head><script src=\"http://www.gstatic.com/safa/sdk-core-v40.js\"></script><script>";
        } else
        {
            return "<html><head><script src=\"http://media.admob.com/sdk-core-v40.js\"></script><script>";
        }
    }

    private String h()
    {
        if (h instanceof SearchAdRequest)
        {
            return "</script></head><body></body></html>";
        } else
        {
            return "</script></head><body></body></html>";
        }
    }

    private void i()
    {
        AdWebView adwebview = ((com.google.ads.internal.d)((n)j.a.a()).b.a()).l();
        ((com.google.ads.internal.d)((n)j.a.a()).b.a()).m().c(true);
        ((com.google.ads.internal.d)((n)j.a.a()).b.a()).n().h();
        ((Handler)com.google.ads.m.a().c.a()).post(new c(adwebview, b, c));
    }

    private void j()
    {
        ((Handler)com.google.ads.m.a().c.a()).post(new e((com.google.ads.internal.d)((n)j.a.a()).b.a(), i, m, u, r, n, o));
    }

    public String a(Map map, Activity activity)
        throws b
    {
        boolean flag = false;
        Context context = activity.getApplicationContext();
        Object obj = ((com.google.ads.internal.d)((n)j.a.a()).b.a()).n();
        long l2 = ((g) (obj)).m();
        if (l2 > 0L)
        {
            map.put("prl", Long.valueOf(l2));
        }
        l2 = ((g) (obj)).n();
        if (l2 > 0L)
        {
            map.put("prnl", Long.valueOf(l2));
        }
        Object obj2 = ((g) (obj)).l();
        if (obj2 != null)
        {
            map.put("ppcl", obj2);
        }
        obj2 = ((g) (obj)).k();
        if (obj2 != null)
        {
            map.put("pcl", obj2);
        }
        l2 = ((g) (obj)).j();
        if (l2 > 0L)
        {
            map.put("pcc", Long.valueOf(l2));
        }
        map.put("preqs", Long.valueOf(((g) (obj)).o()));
        map.put("oar", Long.valueOf(((g) (obj)).p()));
        map.put("bas_on", Long.valueOf(((g) (obj)).s()));
        map.put("bas_off", Long.valueOf(((g) (obj)).v()));
        if (((g) (obj)).y())
        {
            map.put("aoi_timeout", "true");
        }
        if (((g) (obj)).A())
        {
            map.put("aoi_nofill", "true");
        }
        obj2 = ((g) (obj)).D();
        if (obj2 != null)
        {
            map.put("pit", obj2);
        }
        map.put("ptime", Long.valueOf(com.google.ads.internal.g.E()));
        ((g) (obj)).a();
        ((g) (obj)).i();
        n n1;
        int i1;
        if (((n)j.a.a()).b())
        {
            map.put("format", "interstitial_mb");
        } else
        {
            obj1 = ((h)((n)j.a.a()).g.a()).c();
            if (((AdSize) (obj1)).isFullWidth())
            {
                map.put("smart_w", "full");
            }
            if (((AdSize) (obj1)).isAutoHeight())
            {
                map.put("smart_h", "auto");
            }
            if (!((AdSize) (obj1)).isCustomAdSize())
            {
                map.put("format", ((AdSize) (obj1)).toString());
            } else
            {
                HashMap hashmap = new HashMap();
                hashmap.put("w", Integer.valueOf(((AdSize) (obj1)).getWidth()));
                hashmap.put("h", Integer.valueOf(((AdSize) (obj1)).getHeight()));
                map.put("ad_frame", hashmap);
            }
        }
        map.put("slotname", ((n)j.a.a()).h.a());
        map.put("js", "afma-sdk-a-v6.4.1");
        obj = context.getPackageName();
        try
        {
            obj = context.getPackageManager().getPackageInfo(((String) (obj)), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new b("NameNotFoundException");
        }
        i1 = ((PackageInfo) (obj)).versionCode;
        obj = AdUtil.f(context);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            map.put("mv", obj);
        }
        obj = (String)com.google.ads.m.a().a.a();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            map.put("imbf", obj);
        }
        map.put("msid", context.getPackageName());
        map.put("app_name", (new StringBuilder()).append(i1).append(".android.").append(context.getPackageName()).toString());
        map.put("isu", AdUtil.a(context));
        obj2 = AdUtil.d(context);
        obj = obj2;
        if (obj2 == null)
        {
            obj = "null";
        }
        map.put("net", obj);
        obj = AdUtil.e(context);
        if (obj != null && ((String) (obj)).length() != 0)
        {
            map.put("cap", obj);
        }
        map.put("u_audio", Integer.valueOf(AdUtil.g(context).ordinal()));
        obj = AdUtil.a(activity);
        map.put("u_sd", Float.valueOf(((DisplayMetrics) (obj)).density));
        map.put("u_h", Integer.valueOf(AdUtil.a(context, ((DisplayMetrics) (obj)))));
        map.put("u_w", Integer.valueOf(AdUtil.b(context, ((DisplayMetrics) (obj)))));
        map.put("hl", Locale.getDefault().getLanguage());
        n1 = (n)j.a.a();
        obj2 = (ak)n1.r.a();
        obj = obj2;
        if (obj2 == null)
        {
            obj = ak.a("afma-sdk-a-v6.4.1", activity);
            n1.r.a(obj);
            n1.s.a(new al(((com.google.ads.ai) (obj))));
        }
        map.put("ms", ((ak) (obj)).a(context));
        if (((n)j.a.a()).j != null && ((n)j.a.a()).j.a() != null)
        {
            activity = (AdView)((n)j.a.a()).j.a();
            if (activity.getParent() != null)
            {
                Object aobj[] = new int[2];
                activity.getLocationOnScreen(((int []) (aobj)));
                int k1 = aobj[0];
                int l1 = aobj[1];
                Object obj1 = ((Context)((n)j.a.a()).f.a()).getResources().getDisplayMetrics();
                int j1 = ((DisplayMetrics) (obj1)).widthPixels;
                int i2 = ((DisplayMetrics) (obj1)).heightPixels;
                AdSize adsize;
                if (activity.isShown() && activity.getWidth() + k1 > 0 && activity.getHeight() + l1 > 0 && k1 <= j1 && l1 <= i2)
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                obj1 = new HashMap();
                ((Map) (obj1)).put("x", Integer.valueOf(k1));
                ((Map) (obj1)).put("y", Integer.valueOf(l1));
                ((Map) (obj1)).put("width", Integer.valueOf(activity.getWidth()));
                ((Map) (obj1)).put("height", Integer.valueOf(activity.getHeight()));
                ((Map) (obj1)).put("visible", Integer.valueOf(j1));
                map.put("ad_pos", obj1);
            }
        }
        activity = new StringBuilder();
        obj1 = (AdSize[])((n)j.a.a()).n.a();
        if (obj1 != null)
        {
            k1 = obj1.length;
            for (j1 = ((flag) ? 1 : 0); j1 < k1; j1++)
            {
                adsize = obj1[j1];
                if (activity.length() != 0)
                {
                    activity.append("|");
                }
                activity.append((new StringBuilder()).append(adsize.getWidth()).append("x").append(adsize.getHeight()).toString());
            }

            map.put("sz", activity.toString());
        }
        activity = (TelephonyManager)context.getSystemService("phone");
        obj1 = activity.getNetworkOperator();
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            map.put("carrier", obj1);
        }
        map.put("pt", Integer.valueOf(activity.getPhoneType()));
        map.put("gnt", Integer.valueOf(activity.getNetworkType()));
        if (AdUtil.c())
        {
            map.put("simulator", Integer.valueOf(1));
        }
        map.put("session_id", com.google.ads.b.a().b().toString());
        map.put("seq_num", com.google.ads.b.a().c().toString());
        if (((h)((n)j.a.a()).g.a()).b())
        {
            map.put("swipeable", Integer.valueOf(1));
        }
        if (((Boolean)((n)j.a.a()).t.a()).booleanValue())
        {
            map.put("d_imp_hdr", Integer.valueOf(1));
        }
        map = AdUtil.a(map);
        if (((Boolean)((com.google.ads.m.a)((m)((n)j.a.a()).d.a()).b.a()).o.a()).booleanValue())
        {
            map = (new StringBuilder()).append(g()).append(d()).append("(").append(map).append(");").append(h()).toString();
        } else
        {
            map = (new StringBuilder()).append(g()).append(e()).append(d()).append("(").append(map).append(");").append(h()).toString();
        }
        com.google.ads.util.b.c((new StringBuilder()).append("adRequestUrlHtml: ").append(map).toString());
        return map;
    }

    protected void a()
    {
        com.google.ads.util.b.a("AdLoader cancelled.");
        if (i != null)
        {
            i.stopLoading();
            i.destroy();
        }
        if (v != null)
        {
            v.interrupt();
            v = null;
        }
        if (g != null)
        {
            g.a();
        }
        q = true;
    }

    public void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        u = i1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(com.google.ads.AdRequest.ErrorCode errorcode)
    {
        this;
        JVM INSTR monitorenter ;
        s = errorcode;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        errorcode;
        throw errorcode;
    }

    protected void a(com.google.ads.AdRequest.ErrorCode errorcode, boolean flag)
    {
        ((Handler)com.google.ads.m.a().c.a()).post(new a((com.google.ads.internal.d)((n)j.a.a()).b.a(), i, g, errorcode, flag));
    }

    protected void a(AdRequest adrequest)
    {
        h = adrequest;
        q = false;
        v = new Thread(this);
        v.start();
    }

    public void a(AdSize adsize)
    {
        this;
        JVM INSTR monitorenter ;
        o = adsize;
        this;
        JVM INSTR monitorexit ;
        return;
        adsize;
        throw adsize;
    }

    public void a(d d1)
    {
        this;
        JVM INSTR monitorenter ;
        x = d1;
        this;
        JVM INSTR monitorexit ;
        return;
        d1;
        throw d1;
    }

    protected void a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        m.add(s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    protected void a(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        b = s2;
        c = s1;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        p = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void b()
    {
        try
        {
            if (TextUtils.isEmpty(e))
            {
                com.google.ads.util.b.b("Got a mediation response with no content type. Aborting mediation.");
                a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
                return;
            }
        }
        catch (JSONException jsonexception)
        {
            com.google.ads.util.b.b("AdLoader can't parse gWhirl server configuration.", jsonexception);
            a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
            return;
        }
        if (!e.startsWith("application/json"))
        {
            com.google.ads.util.b.b((new StringBuilder()).append("Got a mediation response with a content type: '").append(e).append("'. Expected something starting with 'application/json'. Aborting mediation.").toString());
            a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
            return;
        }
        com.google.ads.c c1 = com.google.ads.c.a(c);
        a(d, c1, ((com.google.ads.internal.d)((n)j.a.a()).b.a()).j());
        ((Handler)com.google.ads.m.a().c.a()).post(new Runnable(c1) {

            final com.google.ads.c a;
            final com.google.ads.internal.c b;

            public void run()
            {
                if (com.google.ads.internal.c.d(b) != null)
                {
                    com.google.ads.internal.c.d(b).stopLoading();
                    com.google.ads.internal.c.d(b).destroy();
                }
                ((com.google.ads.internal.d)((n)com.google.ads.internal.c.b(b).a.a()).b.a()).a(com.google.ads.internal.c.e(b));
                if (com.google.ads.internal.c.f(b) != null)
                {
                    ((h)((n)com.google.ads.internal.c.b(b).a.a()).g.a()).b(com.google.ads.internal.c.f(b));
                }
                ((com.google.ads.internal.d)((n)com.google.ads.internal.c.b(b).a.a()).b.a()).a(a);
            }

            
            {
                b = com.google.ads.internal.c.this;
                a = c2;
                super();
            }
        });
        return;
    }

    protected void b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        e = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    protected void b(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        f = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void c()
    {
        this;
        JVM INSTR monitorenter ;
        t = true;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        d = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void c(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        r = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void d(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        k = s1;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void d(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        w = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void e(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        l = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void e(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        a = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void f(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        n = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        if (i != null && g != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        com.google.ads.util.b.e("adRequestWebView was null while trying to load an ad.");
        a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj = (Activity)((n)j.a.a()).c.a();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        com.google.ads.util.b.e("activity was null while forming an ad request.");
        a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        Map map;
        Object obj2;
        long l1;
        long l2;
        l1 = ((com.google.ads.internal.d)((n)j.a.a()).b.a()).p();
        l2 = SystemClock.elapsedRealtime();
        map = h.getRequestMap((Context)((n)j.a.a()).f.a());
        obj2 = map.get("extras");
        if (!(obj2 instanceof Map)) goto _L2; else goto _L1
_L1:
        Object obj3;
        obj2 = (Map)obj2;
        obj3 = ((Map) (obj2)).get("_adUrl");
        if (obj3 instanceof String)
        {
            b = (String)obj3;
        }
        obj3 = ((Map) (obj2)).get("_requestUrl");
        if (obj3 instanceof String)
        {
            k = (String)obj3;
        }
        obj3 = ((Map) (obj2)).get("_activationOverlayUrl");
        if (obj3 instanceof String)
        {
            l = (String)obj3;
        }
        obj3 = ((Map) (obj2)).get("_orientation");
        if (!(obj3 instanceof String)) goto _L4; else goto _L3
_L3:
        if (!obj3.equals("p")) goto _L6; else goto _L5
_L5:
        u = 1;
_L4:
        obj2 = ((Map) (obj2)).get("_norefresh");
        if ((obj2 instanceof String) && obj2.equals("t"))
        {
            ((com.google.ads.internal.d)((n)j.a.a()).b.a()).e();
        }
_L2:
        if (b != null) goto _L8; else goto _L7
_L7:
        obj2 = k;
        if (obj2 != null) goto _L10; else goto _L9
_L9:
        obj = a(map, ((Activity) (obj)));
        long l3;
        b(((String) (obj)), f());
        l3 = SystemClock.elapsedRealtime();
        l3 = l1 - (l3 - l2);
        if (l3 <= 0L)
        {
            break MISSING_BLOCK_LABEL_397;
        }
        wait(l3);
        boolean flag = q;
        if (!flag) goto _L12; else goto _L11
_L11:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        if (!obj3.equals("l")) goto _L4; else goto _L13
_L13:
        u = 0;
          goto _L4
        Object obj1;
        obj1;
        com.google.ads.util.b.b("An unknown error occurred in AdLoader.", ((Throwable) (obj1)));
        a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, true);
_L45:
        this;
        JVM INSTR monitorexit ;
        return;
        obj1;
        com.google.ads.util.b.c((new StringBuilder()).append("Caught internal exception: ").append(obj1).toString());
        a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
        obj1;
        com.google.ads.util.b.a((new StringBuilder()).append("AdLoader InterruptedException while getting the URL: ").append(obj1).toString());
        this;
        JVM INSTR monitorexit ;
        return;
_L12:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_530;
        }
        a(s, false);
        this;
        JVM INSTR monitorexit ;
        return;
        if (k != null)
        {
            break MISSING_BLOCK_LABEL_578;
        }
        com.google.ads.util.b.c((new StringBuilder()).append("AdLoader timed out after ").append(l1).append("ms while getting the URL.").toString());
        a(com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
        if (!((h)((n)j.a.a()).g.a()).b() || !TextUtils.isEmpty(l)) goto _L10; else goto _L14
_L14:
        com.google.ads.util.b.c("AdLoader doesn't have a URL for the activation overlay");
        a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
_L10:
        obj1 = ((com.google.ads.internal.d)((n)j.a.a()).b.a()).n();
        static class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[d.values().length];
                try
                {
                    a[com.google.ads.internal.d.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[d.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[d.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.google.ads.internal.d.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3.a[x.ordinal()];
        JVM INSTR tableswitch 1 4: default 1546
    //                   1 893
    //                   2 914
    //                   3 927
    //                   4 944;
           goto _L15 _L16 _L17 _L18 _L19
_L15:
        if (a) goto _L21; else goto _L20
_L20:
        com.google.ads.util.b.a("Not using loadUrl().");
        g.a(w);
        if (!((h)((n)j.a.a()).g.a()).b()) goto _L23; else goto _L22
_L22:
        obj1 = ((ActivationOverlay)((n)j.a.a()).e.a()).e();
        ((i) (obj1)).c(true);
        ((Handler)com.google.ads.m.a().c.a()).post(new Runnable() {

            final com.google.ads.internal.c a;

            public void run()
            {
                ((ActivationOverlay)((n)com.google.ads.internal.c.b(a).a.a()).e.a()).loadUrl(com.google.ads.internal.c.c(a));
            }

            
            {
                a = com.google.ads.internal.c.this;
                super();
            }
        });
_L46:
        g.a(k);
_L27:
        if (q || s != null || c != null) goto _L25; else goto _L24
_L24:
        l3 = l1 - (SystemClock.elapsedRealtime() - l2);
        if (l3 <= 0L) goto _L25; else goto _L26
_L26:
        wait(l3);
          goto _L27
        obj1;
        com.google.ads.util.b.a((new StringBuilder()).append("AdLoader InterruptedException while getting the ad server's response: ").append(obj1).toString());
        this;
        JVM INSTR monitorexit ;
        return;
_L16:
        ((g) (obj1)).r();
        ((g) (obj1)).u();
        ((g) (obj1)).x();
        com.google.ads.util.b.c("Request scenario: Online server request.");
          goto _L15
_L17:
        ((g) (obj1)).t();
        com.google.ads.util.b.c("Request scenario: Online using buffered ads.");
          goto _L15
_L18:
        ((g) (obj1)).w();
        ((g) (obj1)).q();
        com.google.ads.util.b.c("Request scenario: Offline using buffered ads.");
          goto _L15
_L19:
        ((g) (obj1)).q();
        com.google.ads.util.b.c("Request scenario: Offline with no buffered ads.");
        com.google.ads.util.b.c("Network is unavailable.  Aborting ad request.");
        a(com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
_L25:
        flag = q;
        if (!flag) goto _L29; else goto _L28
_L28:
        this;
        JVM INSTR monitorexit ;
        return;
_L29:
        if (s == null) goto _L31; else goto _L30
_L30:
        a(s, false);
        this;
        JVM INSTR monitorexit ;
        return;
_L31:
        if (c != null) goto _L33; else goto _L32
_L32:
        com.google.ads.util.b.c((new StringBuilder()).append("AdLoader timed out after ").append(l1).append("ms while waiting for the ad server's response.").toString());
        a(com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
_L21:
        b = k;
        com.google.ads.util.b.a((new StringBuilder()).append("Using loadUrl.  adBaseUrl: ").append(b).toString());
          goto _L8
_L33:
        if (a)
        {
            break MISSING_BLOCK_LABEL_1350;
        }
        if (!f) goto _L35; else goto _L34
_L34:
        ((com.google.ads.internal.d)((n)j.a.a()).b.a()).b(true);
        b();
        this;
        JVM INSTR monitorexit ;
        return;
_L35:
        if (e == null || !e.startsWith("application/json") && !e.startsWith("text/javascript")) goto _L37; else goto _L36
_L36:
        com.google.ads.util.b.b((new StringBuilder()).append("Expected HTML but received ").append(e).append(".").toString());
        a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
_L37:
        if (((n)j.a.a()).n.a() == null) goto _L39; else goto _L38
_L38:
        if (o != null) goto _L41; else goto _L40
_L40:
        com.google.ads.util.b.b("Multiple supported ad sizes were specified, but the server did not respond with a size.");
        a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
_L41:
        if (Arrays.asList((Object[])((n)j.a.a()).n.a()).contains(o))
        {
            break MISSING_BLOCK_LABEL_1350;
        }
        com.google.ads.util.b.b((new StringBuilder()).append("The ad server did not respond with a supported AdSize: ").append(o).toString());
        a(com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR, false);
        this;
        JVM INSTR monitorexit ;
        return;
_L39:
        if (o != null)
        {
            com.google.ads.util.b.e("adSize was expected to be null in AdLoader.");
            o = null;
        }
        ((com.google.ads.internal.d)((n)j.a.a()).b.a()).b(false);
        i();
_L42:
        if (q || t && (!((h)((n)j.a.a()).g.a()).b() || !((i) (obj1)).a()))
        {
            break MISSING_BLOCK_LABEL_1483;
        }
        l3 = l1 - (SystemClock.elapsedRealtime() - l2);
        if (l3 <= 0L)
        {
            break MISSING_BLOCK_LABEL_1483;
        }
        wait(l3);
          goto _L42
        obj1;
        com.google.ads.util.b.a((new StringBuilder()).append("AdLoader InterruptedException while loading the HTML: ").append(obj1).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        if (!t) goto _L44; else goto _L43
_L43:
        j();
          goto _L45
_L44:
        com.google.ads.util.b.c((new StringBuilder()).append("AdLoader timed out after ").append(l1).append("ms while loading the HTML.").toString());
        a(com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR, true);
          goto _L45
_L23:
        obj1 = null;
          goto _L46
_L8:
        obj1 = null;
          goto _L33
    }
}
