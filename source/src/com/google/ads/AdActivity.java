// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.internal.i;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.e;
import com.google.ads.util.f;
import com.google.ads.util.g;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.ads:
//            n, m

public class AdActivity extends Activity
    implements android.view.View.OnClickListener
{
    public static class StaticMethodWrapper
    {

        public boolean isShowing()
        {
            Object obj = com.google.ads.AdActivity.a();
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            boolean flag;
            if (com.google.ads.AdActivity.b() != null)
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

        public void launchAdActivity(d d1, com.google.ads.internal.e e1)
        {
            Object obj = com.google.ads.AdActivity.a();
            obj;
            JVM INSTR monitorenter ;
            if (com.google.ads.AdActivity.d() != null) goto _L2; else goto _L1
_L1:
            com.google.ads.AdActivity.b(d1);
_L4:
            d1 = (Activity)d1.i().c.a();
            if (d1 == null)
            {
                com.google.ads.util.b.e("activity was null while launching an AdActivity.");
                return;
            }
            break MISSING_BLOCK_LABEL_63;
_L2:
            if (com.google.ads.AdActivity.d() == d1) goto _L4; else goto _L3
_L3:
            com.google.ads.util.b.b("Tried to launch a new AdActivity with a different AdManager.");
            obj;
            JVM INSTR monitorexit ;
            return;
            d1;
            obj;
            JVM INSTR monitorexit ;
            throw d1;
            Intent intent = new Intent(d1.getApplicationContext(), com/google/ads/AdActivity);
            intent.putExtra("com.google.ads.AdOpener", e1.a());
            try
            {
                com.google.ads.util.b.a("Launching AdActivity.");
                d1.startActivity(intent);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (d d1)
            {
                com.google.ads.util.b.b("Activity not found.", d1);
            }
            return;
        }

        public boolean leftApplication()
        {
            Object obj = com.google.ads.AdActivity.a();
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            boolean flag;
            if (AdActivity.c() != null)
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

        public StaticMethodWrapper()
        {
        }
    }


    public static final String BASE_URL_PARAM = "baseurl";
    public static final String COMPONENT_NAME_PARAM = "c";
    public static final String CUSTOM_CLOSE_PARAM = "custom_close";
    public static final String HTML_PARAM = "html";
    public static final String INTENT_ACTION_PARAM = "i";
    public static final String INTENT_EXTRAS_PARAM = "e";
    public static final String INTENT_FLAGS_PARAM = "f";
    public static final String ORIENTATION_PARAM = "o";
    public static final String PACKAGE_NAME_PARAM = "p";
    public static final String TYPE_PARAM = "m";
    public static final String URL_PARAM = "u";
    private static final a a;
    private static final Object b = new Object();
    private static AdActivity c = null;
    private static d d = null;
    private static AdActivity e = null;
    private static AdActivity f = null;
    private static final StaticMethodWrapper g = new StaticMethodWrapper();
    private AdWebView h;
    private FrameLayout i;
    private int j;
    private ViewGroup k;
    private boolean l;
    private long m;
    private RelativeLayout n;
    private AdActivity o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private AdVideoView t;

    public AdActivity()
    {
        k = null;
        o = null;
    }

    private android.widget.RelativeLayout.LayoutParams a(int i1, int j1, int k1, int l1)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(k1, l1);
        layoutparams.setMargins(i1, j1, 0, 0);
        layoutparams.addRule(10);
        layoutparams.addRule(9);
        return layoutparams;
    }

    static Object a()
    {
        return b;
    }

    private void a(String s1)
    {
        com.google.ads.util.b.b(s1);
        finish();
    }

    private void a(String s1, Throwable throwable)
    {
        com.google.ads.util.b.b(s1, throwable);
        finish();
    }

    static AdActivity b()
    {
        return e;
    }

    static d b(d d1)
    {
        d = d1;
        return d1;
    }

    static AdActivity c()
    {
        return c;
    }

    static d d()
    {
        return d;
    }

    private void e()
    {
        if (l) goto _L2; else goto _L1
_L1:
        if (h == null) goto _L4; else goto _L3
_L3:
        a.b(h);
        h.setAdActivity(null);
        h.setIsExpandedMraid(false);
        if (q || n == null || k == null) goto _L4; else goto _L5
_L5:
        if (!r || s) goto _L7; else goto _L6
_L6:
        com.google.ads.util.b.a("Disabling hardware acceleration on collapsing MRAID WebView.");
        h.g();
_L13:
        n.removeView(h);
        k.addView(h);
_L4:
        if (t != null)
        {
            t.e();
            t = null;
        }
        if (this == c)
        {
            c = null;
        }
        f = o;
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (d != null && q && h != null)
        {
            if (h == d.l())
            {
                d.a();
            }
            h.stopLoading();
        }
        if (this != e) goto _L9; else goto _L8
_L8:
        e = null;
        if (d == null) goto _L11; else goto _L10
_L10:
        d.u();
        d = null;
_L9:
        l = true;
        com.google.ads.util.b.a("AdActivity is closing.");
_L2:
        return;
_L7:
        if (!r && s)
        {
            com.google.ads.util.b.a("Re-enabling hardware acceleration on collapsing MRAID WebView.");
            h.h();
        }
        continue; /* Loop/switch isn't completed */
_L11:
        com.google.ads.util.b.e("currentAdManager is null while trying to destroy AdActivity.");
          goto _L9
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public static boolean isShowing()
    {
        return g.isShowing();
    }

    public static void launchAdActivity(d d1, com.google.ads.internal.e e1)
    {
        g.launchAdActivity(d1, e1);
    }

    public static boolean leftApplication()
    {
        return g.leftApplication();
    }

    protected View a(int i1, boolean flag)
    {
        j = (int)TypedValue.applyDimension(1, i1, getResources().getDisplayMetrics());
        i = new FrameLayout(getApplicationContext());
        i.setMinimumWidth(j);
        i.setMinimumHeight(j);
        i.setOnClickListener(this);
        setCustomClose(flag);
        return i;
    }

    protected AdVideoView a(Activity activity)
    {
        return new AdVideoView(activity, h);
    }

    protected void a(AdWebView adwebview, boolean flag, int i1, boolean flag1, boolean flag2)
    {
label0:
        {
label1:
            {
                requestWindowFeature(1);
                Object obj = getWindow();
                ((Window) (obj)).setFlags(1024, 1024);
                if (AdUtil.a >= 11)
                {
                    if (r)
                    {
                        com.google.ads.util.b.a("Enabling hardware acceleration on the AdActivity window.");
                        com.google.ads.util.g.a(((Window) (obj)));
                    } else
                    {
                        com.google.ads.util.b.a("Disabling hardware acceleration on the AdActivity WebView.");
                        adwebview.g();
                    }
                }
                obj = adwebview.getParent();
                if (obj != null)
                {
                    if (!flag1)
                    {
                        break label0;
                    }
                    if (!(obj instanceof ViewGroup))
                    {
                        break label1;
                    }
                    k = (ViewGroup)obj;
                    k.removeView(adwebview);
                }
                if (adwebview.i() != null)
                {
                    a("Interstitial created with an AdWebView that is already in use by another AdActivity.");
                } else
                {
                    setRequestedOrientation(i1);
                    adwebview.setAdActivity(this);
                    View view;
                    android.widget.RelativeLayout.LayoutParams layoutparams;
                    if (flag1)
                    {
                        i1 = 50;
                    } else
                    {
                        i1 = 32;
                    }
                    view = a(i1, flag2);
                    n.addView(adwebview, -1, -1);
                    layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                    if (flag1)
                    {
                        layoutparams.addRule(10);
                        layoutparams.addRule(11);
                    } else
                    {
                        layoutparams.addRule(10);
                        layoutparams.addRule(9);
                    }
                    n.addView(view, layoutparams);
                    n.setKeepScreenOn(true);
                    setContentView(n);
                    n.getRootView().setBackgroundColor(0xff000000);
                    if (flag)
                    {
                        a.a(adwebview);
                        return;
                    }
                }
                return;
            }
            a("MRAID banner was not a child of a ViewGroup.");
            return;
        }
        a("Interstitial created with an AdWebView that has a parent.");
    }

    protected void a(d d1)
    {
        h = null;
        m = SystemClock.elapsedRealtime();
        p = true;
        synchronized (b)
        {
            if (c == null)
            {
                c = this;
                d1.w();
            }
        }
        return;
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
    }

    protected void a(HashMap hashmap, d d1)
    {
        Intent intent;
        Object obj;
        Object obj2;
        Object obj3;
        int i1;
        int j1;
        boolean flag = false;
        if (hashmap == null)
        {
            a("Could not get the paramMap in launchIntent()");
            return;
        }
        intent = new Intent();
        obj2 = (String)hashmap.get("u");
        obj3 = (String)hashmap.get("m");
        String s1 = (String)hashmap.get("i");
        String s2 = (String)hashmap.get("p");
        Object obj1 = (String)hashmap.get("c");
        obj = (String)hashmap.get("f");
        hashmap = (String)hashmap.get("e");
        if (!TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj3))))
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (i1 == 0 || j1 == 0) goto _L2; else goto _L1
_L1:
        intent.setDataAndType(Uri.parse(((String) (obj2))), ((String) (obj3)));
_L15:
        if (!TextUtils.isEmpty(s1))
        {
            intent.setAction(s1);
        } else
        if (i1 != 0)
        {
            intent.setAction("android.intent.action.VIEW");
        }
        if (!TextUtils.isEmpty(s2) && AdUtil.a >= 4)
        {
            com.google.ads.util.e.a(intent, s2);
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj2 = ((String) (obj1)).split("/");
            if (obj2.length < 2)
            {
                com.google.ads.util.b.e((new StringBuilder()).append("Warning: Could not parse component name from open GMSG: ").append(((String) (obj1))).toString());
            }
            intent.setClassName(obj2[0], obj2[1]);
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            try
            {
                i1 = Integer.parseInt(((String) (obj)));
            }
            catch (NumberFormatException numberformatexception)
            {
                com.google.ads.util.b.e((new StringBuilder()).append("Warning: Could not parse flags from open GMSG: ").append(((String) (obj))).toString());
                i1 = 0;
            }
            intent.addFlags(i1);
        }
        if (TextUtils.isEmpty(hashmap)) goto _L4; else goto _L3
_L3:
        obj = new JSONObject(hashmap);
        obj1 = ((JSONObject) (obj)).names();
        i1 = ((flag) ? 1 : 0);
_L12:
        if (i1 >= ((JSONArray) (obj1)).length()) goto _L4; else goto _L5
_L5:
        obj2 = ((JSONArray) (obj1)).getString(i1);
        obj3 = ((JSONObject) (obj)).getJSONObject(((String) (obj2)));
        j1 = ((JSONObject) (obj3)).getInt("t");
        j1;
        JVM INSTR tableswitch 1 5: default 689
    //                   1 507
    //                   2 572
    //                   3 590
    //                   4 608
    //                   5 626;
           goto _L6 _L7 _L8 _L9 _L10 _L11
_L6:
        com.google.ads.util.b.e((new StringBuilder()).append("Warning: Unknown type in extras from open GMSG: ").append(((String) (obj2))).append(" (type: ").append(j1).append(")").toString());
_L13:
        i1++;
          goto _L12
_L2:
        if (i1 != 0)
        {
            intent.setData(Uri.parse(((String) (obj2))));
        } else
        if (j1 != 0)
        {
            intent.setType(((String) (obj3)));
        }
        continue; /* Loop/switch isn't completed */
_L7:
        intent.putExtra(((String) (obj2)), ((JSONObject) (obj3)).getBoolean("v"));
          goto _L13
        JSONException jsonexception;
        jsonexception;
        com.google.ads.util.b.e((new StringBuilder()).append("Warning: Could not parse extras from open GMSG: ").append(hashmap).toString());
_L4:
        if (intent.filterEquals(new Intent()))
        {
            a("Tried to launch empty intent.");
            return;
        }
        try
        {
            com.google.ads.util.b.a((new StringBuilder()).append("Launching an intent from AdActivity: ").append(intent).toString());
            startActivity(intent);
            a(d1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            a(hashmap.getMessage(), ((Throwable) (hashmap)));
        }
        return;
        continue; /* Loop/switch isn't completed */
_L8:
        intent.putExtra(((String) (obj2)), ((JSONObject) (obj3)).getDouble("v"));
          goto _L13
_L9:
        intent.putExtra(((String) (obj2)), ((JSONObject) (obj3)).getInt("v"));
          goto _L13
_L10:
        intent.putExtra(((String) (obj2)), ((JSONObject) (obj3)).getLong("v"));
          goto _L13
_L11:
        intent.putExtra(((String) (obj2)), ((JSONObject) (obj3)).getString("v"));
          goto _L13
        if (true) goto _L15; else goto _L14
_L14:
    }

    public AdVideoView getAdVideoView()
    {
        return t;
    }

    public AdWebView getOpeningAdWebView()
    {
        if (o != null)
        {
            return o.h;
        }
        synchronized (b)
        {
            if (d != null)
            {
                break MISSING_BLOCK_LABEL_42;
            }
            com.google.ads.util.b.e("currentAdManager was null while trying to get the opening AdWebView.");
        }
        return null;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        AdWebView adwebview = d.l();
        if (adwebview != h)
        {
            return adwebview;
        }
        obj;
        JVM INSTR monitorexit ;
        return null;
    }

    public void moveAdVideoView(int i1, int j1, int k1, int l1)
    {
        if (t != null)
        {
            t.setLayoutParams(a(i1, j1, k1, l1));
            t.requestLayout();
        }
    }

    public void newAdVideoView(int i1, int j1, int k1, int l1)
    {
label0:
        {
            if (t != null)
            {
                break MISSING_BLOCK_LABEL_83;
            }
            t = a(this);
            n.addView(t, 0, a(i1, j1, k1, l1));
            synchronized (b)
            {
                if (d != null)
                {
                    break label0;
                }
                com.google.ads.util.b.e("currentAdManager was null while trying to get the opening AdWebView.");
            }
            return;
        }
        d.m().b(false);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onClick(View view)
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag3;
        flag3 = false;
        super.onCreate(bundle);
        l = false;
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        m.a a1;
        boolean flag4;
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        bundle = d;
        if (e == null)
        {
            e = this;
            bundle.v();
        }
        if (o == null && f != null)
        {
            o = f;
        }
        f = this;
        if (bundle.i().a() && e == this || bundle.i().b() && o == e)
        {
            bundle.x();
        }
        flag4 = bundle.r();
        a1 = (m.a)((m)bundle.i().d.a()).b.a();
        boolean flag;
        if (AdUtil.a >= ((Integer)a1.b.a()).intValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = flag;
        if (AdUtil.a >= ((Integer)a1.d.a()).intValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        r = flag;
        obj;
        JVM INSTR monitorexit ;
        n = null;
        p = false;
        q = true;
        t = null;
        obj = getIntent().getBundleExtra("com.google.ads.AdOpener");
        if (obj == null)
        {
            a("Could not get the Bundle used to create AdActivity.");
            return;
        }
        break MISSING_BLOCK_LABEL_265;
        a("Could not get currentAdManager.");
        obj;
        JVM INSTR monitorexit ;
        return;
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
        obj = new com.google.ads.internal.e(((Bundle) (obj)));
        Object obj1 = ((com.google.ads.internal.e) (obj)).b();
        obj = ((com.google.ads.internal.e) (obj)).c();
        if (((String) (obj1)).equals("intent"))
        {
            a(((HashMap) (obj)), bundle);
            return;
        }
        n = new RelativeLayout(getApplicationContext());
        if (((String) (obj1)).equals("webapp"))
        {
            h = new AdWebView(bundle.i(), null);
            obj1 = a.d;
            String s1;
            String s2;
            int i1;
            boolean flag1;
            if (!flag4)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj1 = com.google.ads.internal.i.a(bundle, ((java.util.Map) (obj1)), true, flag1);
            ((i) (obj1)).d(true);
            if (flag4)
            {
                ((i) (obj1)).a(true);
            }
            h.setWebViewClient(((android.webkit.WebViewClient) (obj1)));
            obj1 = (String)((HashMap) (obj)).get("u");
            s1 = (String)((HashMap) (obj)).get("baseurl");
            s2 = (String)((HashMap) (obj)).get("html");
            if (obj1 != null)
            {
                h.loadUrl(((String) (obj1)));
            } else
            if (s2 != null)
            {
                h.loadDataWithBaseURL(s1, s2, "text/html", "utf-8", null);
            } else
            {
                a("Could not get the URL or HTML parameter to show a web app.");
                return;
            }
            obj1 = (String)((HashMap) (obj)).get("o");
            if ("p".equals(obj1))
            {
                i1 = AdUtil.b();
            } else
            if ("l".equals(obj1))
            {
                i1 = AdUtil.a();
            } else
            if (this == e)
            {
                i1 = bundle.o();
            } else
            {
                i1 = -1;
            }
            bundle = h;
            if (obj != null && "1".equals(((HashMap) (obj)).get("custom_close")))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a(bundle, false, i1, flag4, flag1);
            return;
        }
        if (((String) (obj1)).equals("interstitial") || ((String) (obj1)).equals("expand"))
        {
            h = bundle.l();
            int j1 = bundle.o();
            boolean flag2;
            if (((String) (obj1)).equals("expand"))
            {
                h.setIsExpandedMraid(true);
                q = false;
                flag2 = flag3;
                if (obj != null)
                {
                    flag2 = flag3;
                    if ("1".equals(((HashMap) (obj)).get("custom_close")))
                    {
                        flag2 = true;
                    }
                }
                if (r && !s)
                {
                    com.google.ads.util.b.a("Re-enabling hardware acceleration on expanding MRAID WebView.");
                    h.h();
                }
            } else
            {
                flag2 = h.j();
            }
            a(h, true, j1, flag4, flag2);
            return;
        } else
        {
            a((new StringBuilder()).append("Unknown AdOpener, <action: ").append(((String) (obj1))).append(">").toString());
            return;
        }
    }

    public void onDestroy()
    {
        if (n != null)
        {
            n.removeAllViews();
        }
        if (isFinishing())
        {
            e();
            if (q && h != null)
            {
                h.stopLoading();
                h.destroy();
                h = null;
            }
        }
        super.onDestroy();
    }

    public void onPause()
    {
        if (isFinishing())
        {
            e();
        }
        super.onPause();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (p && flag && SystemClock.elapsedRealtime() - m > 250L)
        {
            com.google.ads.util.b.d("Launcher AdActivity got focus and is closing.");
            finish();
        }
        super.onWindowFocusChanged(flag);
    }

    public void setCustomClose(boolean flag)
    {
        if (i != null)
        {
            i.removeAllViews();
            if (!flag)
            {
                ImageButton imagebutton = new ImageButton(this);
                imagebutton.setImageResource(0x1080017);
                imagebutton.setBackgroundColor(0);
                imagebutton.setOnClickListener(this);
                imagebutton.setPadding(0, 0, 0, 0);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(j, j, 17);
                i.addView(imagebutton, layoutparams);
            }
        }
    }

    static 
    {
        a = (a)a.a.b();
    }
}
