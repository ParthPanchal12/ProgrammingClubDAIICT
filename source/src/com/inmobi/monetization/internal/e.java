// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.re.container.IMWebView;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

class e extends View
{

    WebViewClient a;
    private IMWebView b;
    private boolean c;
    private String d;
    private ArrayList e;
    private boolean f;

    public e(Context context, String s, String s1)
    {
        super(context);
        c = false;
        e = null;
        f = false;
        a = new WebViewClient() {

            final e a;

            public void onPageFinished(WebView webview, String s2)
            {
                Log.internal("[InMobi]-[Monetization]", "Native ad context code loaded");
                e.a(a, true);
                if (e.a(a) != null && !e.a(a).isEmpty())
                {
                    for (int i = 0; i < e.a(a).size(); i++)
                    {
                        a.b((String)e.a(a).get(i));
                    }

                    e.a(a).clear();
                    e.a(a, null);
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
        if (s == null || s1 == null)
        {
            return;
        } else
        {
            d = s1;
            s1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            s1.addRule(10);
            setLayoutParams(s1);
            setBackgroundColor(0);
            IMWebView.setIMAIController(com/inmobi/monetization/internal/imai/IMAIController);
            b = new IMWebView(context, null, false, false);
            b.getSettings().setJavaScriptEnabled(true);
            b.getSettings().setCacheMode(2);
            b.setWebViewClient(a);
            b.loadData(s, "text/html", "UTF-8");
            e = new ArrayList();
            setId(999);
            return;
        }
    }

    static ArrayList a(e e1)
    {
        return e1.e;
    }

    static ArrayList a(e e1, ArrayList arraylist)
    {
        e1.e = arraylist;
        return arraylist;
    }

    static boolean a(e e1, boolean flag)
    {
        e1.f = flag;
        return flag;
    }

    private String b()
    {
        return (new StringBuilder()).append(d).append("recordEvent(18)").toString();
    }

    private String b(HashMap hashmap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (hashmap == null || hashmap.isEmpty())
        {
            stringbuilder.append((new StringBuilder()).append(d).append("recordEvent(8)").toString());
            return stringbuilder.toString();
        } else
        {
            stringbuilder.append((new StringBuilder()).append(d).append("recordEvent(8, ").toString());
            stringbuilder.append((new JSONObject(hashmap)).toString());
            stringbuilder.append(")");
            return stringbuilder.toString();
        }
    }

    private void c(String s)
    {
        b.loadUrl(s);
    }

    private void d(String s)
    {
        b.evaluateJavascript(s, null);
    }

    public void a()
    {
        if (b != null)
        {
            b.destroy();
            b = null;
        }
        if (e != null)
        {
            e.clear();
            e = null;
        }
        c = false;
        f = false;
    }

    public void a(String s)
    {
        Log.debug("[InMobi]-[Monetization]", "Handle Impression");
        b(s);
    }

    public void a(HashMap hashmap)
    {
        Log.debug("[InMobi]-[Monetization]", "Handle Click");
        hashmap = b(hashmap);
        if (f)
        {
            b(hashmap);
        } else
        if (e != null)
        {
            e.add(hashmap);
            return;
        }
    }

    public void b(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (s.length() < 400)
        {
            Log.internal("[InMobi]-[Monetization]", s);
        }
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        s = (new StringBuilder()).append("javascript:try{").append(s).append("}catch(e){}").toString();
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            c(s);
            return;
        }
        try
        {
            d(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        if (i == 0 && !c)
        {
            c = true;
            if (f)
            {
                a(b());
            } else
            if (e != null)
            {
                e.add(b());
                return;
            }
        }
    }
}
