// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.c;
import com.google.ads.internal.d;
import com.google.ads.internal.i;
import com.google.ads.m;
import com.google.ads.n;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

// Referenced classes of package com.google.ads.util:
//            b, AdUtil

public class g
{
    public static class a extends WebChromeClient
    {

        private final n a;

        private static void a(android.app.AlertDialog.Builder builder, Context context, String s, String s1, JsPromptResult jspromptresult)
        {
            LinearLayout linearlayout = new LinearLayout(context);
            linearlayout.setOrientation(1);
            TextView textview = new TextView(context);
            textview.setText(s);
            context = new EditText(context);
            context.setText(s1);
            linearlayout.addView(textview);
            linearlayout.addView(context);
            builder.setView(linearlayout).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(jspromptresult, context) {

                final JsPromptResult a;
                final EditText b;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    a.confirm(b.getText().toString());
                }

            
            {
                a = jspromptresult;
                b = edittext;
                super();
            }
            }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener(jspromptresult) {

                final JsPromptResult a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    a.cancel();
                }

            
            {
                a = jspromptresult;
                super();
            }
            }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(jspromptresult) {

                final JsPromptResult a;

                public void onCancel(DialogInterface dialoginterface)
                {
                    a.cancel();
                }

            
            {
                a = jspromptresult;
                super();
            }
            }).create().show();
        }

        private static void a(android.app.AlertDialog.Builder builder, String s, JsResult jsresult)
        {
            builder.setMessage(s).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(jsresult) {

                final JsResult a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    a.confirm();
                }

            
            {
                a = jsresult;
                super();
            }
            }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener(jsresult) {

                final JsResult a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    a.cancel();
                }

            
            {
                a = jsresult;
                super();
            }
            }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(jsresult) {

                final JsResult a;

                public void onCancel(DialogInterface dialoginterface)
                {
                    a.cancel();
                }

            
            {
                a = jsresult;
                super();
            }
            }).create().show();
        }

        private static boolean a(WebView webview, String s, String s1, String s2, JsResult jsresult, JsPromptResult jspromptresult, boolean flag)
        {
            if (webview instanceof AdWebView)
            {
                webview = ((AdWebView)webview).i();
                if (webview != null)
                {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(webview);
                    builder.setTitle(s);
                    if (flag)
                    {
                        a(builder, ((Context) (webview)), s1, s2, jspromptresult);
                    } else
                    {
                        a(builder, s1, jsresult);
                    }
                    return true;
                }
            }
            return false;
        }

        public void onCloseWindow(WebView webview)
        {
            if (webview instanceof AdWebView)
            {
                ((AdWebView)webview).f();
            }
        }

        public boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            String s = (new StringBuilder()).append("JS: ").append(consolemessage.message()).append(" (").append(consolemessage.sourceId()).append(":").append(consolemessage.lineNumber()).append(")").toString();
            static class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[android.webkit.ConsoleMessage.MessageLevel.values().length];
                    try
                    {
                        a[android.webkit.ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        a[android.webkit.ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[android.webkit.ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[android.webkit.ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[android.webkit.ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1.a[consolemessage.messageLevel().ordinal()];
            JVM INSTR tableswitch 1 5: default 96
        //                       1 102
        //                       2 109
        //                       3 116
        //                       4 116
        //                       5 123;
               goto _L1 _L2 _L3 _L4 _L4 _L5
_L1:
            return super.onConsoleMessage(consolemessage);
_L2:
            com.google.ads.util.b.b(s);
            continue; /* Loop/switch isn't completed */
_L3:
            com.google.ads.util.b.e(s);
            continue; /* Loop/switch isn't completed */
_L4:
            com.google.ads.util.b.c(s);
            continue; /* Loop/switch isn't completed */
_L5:
            com.google.ads.util.b.a(s);
            if (true) goto _L1; else goto _L6
_L6:
        }

        public void onExceededDatabaseQuota(String s, String s1, long l, long l1, long l2, android.webkit.WebStorage.QuotaUpdater quotaupdater)
        {
            s = (com.google.ads.m.a)((m)a.d.a()).b.a();
            long l3 = ((Long)((com.google.ads.m.a) (s)).l.a()).longValue() - l2;
            if (l3 <= 0L)
            {
                quotaupdater.updateQuota(l);
                return;
            }
            if (l == 0L)
            {
                if (l1 > l3 || l1 > ((Long)((com.google.ads.m.a) (s)).m.a()).longValue())
                {
                    l1 = 0L;
                }
            } else
            if (l1 == 0L)
            {
                l1 = Math.min(Math.min(((Long)((com.google.ads.m.a) (s)).n.a()).longValue(), l3) + l, ((Long)((com.google.ads.m.a) (s)).m.a()).longValue());
            } else
            {
                l2 = l;
                if (l1 <= Math.min(((Long)((com.google.ads.m.a) (s)).m.a()).longValue() - l, l3))
                {
                    l2 = l + l1;
                }
                l1 = l2;
            }
            quotaupdater.updateQuota(l1);
        }

        public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            return a(webview, s, s1, null, jsresult, null, false);
        }

        public boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
        {
            return a(webview, s, s1, null, jsresult, null, false);
        }

        public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
        {
            return a(webview, s, s1, null, jsresult, null, false);
        }

        public boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
        {
            return a(webview, s, s1, s2, null, jspromptresult, true);
        }

        public void onReachedMaxAppCacheSize(long l, long l1, android.webkit.WebStorage.QuotaUpdater quotaupdater)
        {
            com.google.ads.m.a a1 = (com.google.ads.m.a)((m)a.d.a()).b.a();
            long l2 = ((Long)a1.k.a()).longValue();
            l = ((Long)a1.j.a()).longValue() + l;
            if (l2 - l1 < l)
            {
                quotaupdater.updateQuota(0L);
                return;
            } else
            {
                quotaupdater.updateQuota(l);
                return;
            }
        }

        public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            customviewcallback.onCustomViewHidden();
        }

        public a(n n1)
        {
            a = n1;
        }
    }

    public static class b extends i
    {

        private static WebResourceResponse a(String s, Context context)
            throws IOException
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
            AdUtil.a(s, context.getApplicationContext());
            s.connect();
            context = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(AdUtil.a(new InputStreamReader(s.getInputStream())).getBytes("UTF-8")));
            s.disconnect();
            return context;
            context;
            s.disconnect();
            throw context;
        }

        public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
        {
            if (!"mraid.js".equalsIgnoreCase((new File(s)).getName())) goto _L2; else goto _L1
_L1:
            Object obj = a.k();
            if (obj == null) goto _L4; else goto _L3
_L3:
            ((c) (obj)).c(true);
_L8:
            obj = (com.google.ads.m.a)((m)a.i().d.a()).b.a();
            if (a.i().b()) goto _L6; else goto _L5
_L5:
            if (b)
            {
                obj = (String)((com.google.ads.m.a) (obj)).f.a();
                com.google.ads.util.b.a((new StringBuilder()).append("shouldInterceptRequest(").append(((String) (obj))).append(")").toString());
                return a(((String) (obj)), webview.getContext());
            }
              goto _L7
_L4:
            a.a(true);
              goto _L8
            obj;
            com.google.ads.util.b.d("IOException fetching MRAID JS.", ((Throwable) (obj)));
_L2:
            return super.shouldInterceptRequest(webview, s);
_L7:
            obj = (String)((com.google.ads.m.a) (obj)).e.a();
            com.google.ads.util.b.a((new StringBuilder()).append("shouldInterceptRequest(").append(((String) (obj))).append(")").toString());
            return a(((String) (obj)), webview.getContext());
_L6:
            obj = (String)((com.google.ads.m.a) (obj)).g.a();
            com.google.ads.util.b.a((new StringBuilder()).append("shouldInterceptRequest(").append(((String) (obj))).append(")").toString());
            obj = a(((String) (obj)), webview.getContext());
            return ((WebResourceResponse) (obj));
            Throwable throwable;
            throwable;
            com.google.ads.util.b.d("An unknown error occurred fetching MRAID JS.", throwable);
            if (true) goto _L2; else goto _L9
_L9:
        }

        public b(d d1, Map map, boolean flag, boolean flag1)
        {
            super(d1, map, flag, flag1);
        }
    }


    public static void a(View view)
    {
        view.setLayerType(1, null);
    }

    public static void a(Window window)
    {
        window.setFlags(0x1000000, 0x1000000);
    }

    public static void a(WebSettings websettings, n n1)
    {
        Context context = (Context)n1.f.a();
        n1 = (com.google.ads.m.a)((m)n1.d.a()).b.a();
        websettings.setAppCacheEnabled(true);
        websettings.setAppCacheMaxSize(((Long)((com.google.ads.m.a) (n1)).i.a()).longValue());
        websettings.setAppCachePath((new File(context.getCacheDir(), "admob")).getAbsolutePath());
        websettings.setDatabaseEnabled(true);
        websettings.setDatabasePath(context.getDatabasePath("admob").getAbsolutePath());
        websettings.setDomStorageEnabled(true);
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        websettings.setDisplayZoomControls(false);
    }

    public static void b(View view)
    {
        view.setLayerType(0, null);
    }
}