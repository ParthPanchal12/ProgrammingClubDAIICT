// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerNetworkInterface, AdTrackerRequestResponseBuilder

public class AdTrackerWebViewLoader
{
    protected final class AdTrackerWebViewClient extends WebViewClient
    {

        final AdTrackerWebViewLoader a;

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            webview = AdTrackerNetworkInterface.c();
            if (webview != null && webview.hasMessages(9))
            {
                webview.removeMessages(9);
                Log.internal("[InMobi]-[AdTracker]-4.5.5", "Webview Received Error");
                s = Message.obtain();
                s.what = 10;
                s.arg2 = i;
                s.obj = AdTrackerWebViewLoader.c(a);
                webview.sendMessage(s);
            }
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            webview = AdTrackerNetworkInterface.c();
            if (webview.hasMessages(9))
            {
                webview.removeMessages(9);
                Log.internal("[InMobi]-[AdTracker]-4.5.5", "Webview Received SSL Error");
                sslerrorhandler = Message.obtain();
                sslerrorhandler.what = 10;
                sslerrorhandler.arg2 = sslerror.getPrimaryError();
                sslerrorhandler.obj = AdTrackerWebViewLoader.c(a);
                webview.sendMessage(sslerrorhandler);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            Handler handler = AdTrackerNetworkInterface.c();
            if (handler.hasMessages(9))
            {
                handler.removeMessages(9);
                AdTrackerWebViewLoader.b(a, System.currentTimeMillis() - AdTrackerWebViewLoader.b(a));
                if (s.contains("iat"))
                {
                    Object obj = s.substring(7);
                    obj = AdTrackerWebViewLoader.a(a, ((String) (obj)));
                    FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "errcode", Integer.toString(a.a(((a) (obj)))));
                    Message message = Message.obtain();
                    message.what = 10;
                    message.arg2 = a.a(((a) (obj)));
                    message.obj = AdTrackerWebViewLoader.c(a);
                    Bundle bundle = new Bundle();
                    bundle.putString("appId", AdTrackerWebViewLoader.d(a));
                    message.setData(bundle);
                    if (5000 == a.a(((a) (obj))))
                    {
                        int i = AdTrackerWebViewLoader.b(a, a.b(((a) (obj))));
                        if (6000 == i)
                        {
                            message.what = 8;
                            message.arg2 = (int)AdTrackerWebViewLoader.e(a);
                        } else
                        {
                            message.arg2 = i;
                        }
                    }
                    handler.sendMessage(message);
                }
            }
            webview.loadUrl(s);
            return true;
        }

        protected AdTrackerWebViewClient()
        {
            a = AdTrackerWebViewLoader.this;
            super();
        }
    }

    protected static class JSInterface
    {

        public String getParams()
        {
            String s2 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
            String s1 = AdTrackerRequestResponseBuilder.getWebViewRequestParam();
            String s = s1;
            if (s2 != null)
            {
                s = (new StringBuilder()).append(s1).append("&referrer=").append(s2).toString();
            }
            Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Request param for webview").append(s).toString());
            return s;
        }

        protected JSInterface()
        {
        }
    }

    private static class a
    {

        private int a;
        private String b;

        static int a(a a1)
        {
            return a1.a;
        }

        static int a(a a1, int i)
        {
            a1.a = i;
            return i;
        }

        static String a(a a1, String s)
        {
            a1.b = s;
            return s;
        }

        static String b(a a1)
        {
            return a1.b;
        }

        public a()
        {
            a = 0;
            b = null;
        }
    }


    private WebView a;
    private Goal b;
    private String c;
    private long d;
    private long e;

    public AdTrackerWebViewLoader()
    {
        d = 0L;
        e = 0L;
        AdTrackerNetworkInterface.getUIHandler().post(new Runnable() {

            final AdTrackerWebViewLoader a;

            public void run()
            {
                AdTrackerWebViewLoader.a(a, new WebView(InternalSDKUtil.getContext()));
                AdTrackerWebViewLoader.a(a).setWebViewClient(a. new AdTrackerWebViewClient());
                AdTrackerWebViewLoader.a(a).getSettings().setJavaScriptEnabled(true);
                AdTrackerWebViewLoader.a(a).getSettings().setCacheMode(2);
                AdTrackerWebViewLoader.a(a).addJavascriptInterface(new JSInterface(), "iatsdk");
            }

            
            {
                a = AdTrackerWebViewLoader.this;
                super();
            }
        });
    }

    static long a(AdTrackerWebViewLoader adtrackerwebviewloader, long l)
    {
        adtrackerwebviewloader.d = l;
        return l;
    }

    static WebView a(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        return adtrackerwebviewloader.a;
    }

    static WebView a(AdTrackerWebViewLoader adtrackerwebviewloader, WebView webview)
    {
        adtrackerwebviewloader.a = webview;
        return webview;
    }

    static a a(AdTrackerWebViewLoader adtrackerwebviewloader, String s)
    {
        return adtrackerwebviewloader.a(s);
    }

    private a a(String s)
    {
        a a1;
        int i;
        int j;
        int k;
        int l;
        String as[] = null;
        a1 = new a();
        String as1[];
        try
        {
            as1 = s.split("&");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Check content Exception", s);
            return a1;
        }
        i = 0;
        j = 0;
        s = as;
_L9:
        if (i >= as1.length) goto _L2; else goto _L1
_L1:
        as = as1[i].split("=");
        k = 0;
_L7:
        if (k >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!"err".equals(as[k])) goto _L4; else goto _L3
_L3:
        l = Integer.parseInt(as[k + 1]);
          goto _L5
_L4:
        l = j;
        if ("res".equals(as[k]))
        {
            s = as[k + 1];
            l = j;
        }
          goto _L5
_L2:
        a.a(a1, j);
        a.a(a1, s);
        if (5003 != j)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Webview Timeout ").append(s).toString());
        break; /* Loop/switch isn't completed */
        if (5001 != j)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Invalid params passed ").append(s).toString());
        break; /* Loop/switch isn't completed */
        if (5002 != j)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("XMLHTTP request not supported ").append(s).toString());
        break; /* Loop/switch isn't completed */
        if (5005 != j)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Invalid JSON Response ").append(s).toString());
        break; /* Loop/switch isn't completed */
        if (5004 != j)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Webview Server Error ").append(s).toString());
        break; /* Loop/switch isn't completed */
        if (5000 != j)
        {
            break; /* Loop/switch isn't completed */
        }
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Webview response ").append(URLDecoder.decode(s, "utf-8")).toString());
        break; /* Loop/switch isn't completed */
_L5:
        k++;
        j = l;
        if (true) goto _L7; else goto _L6
_L6:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        return a1;
    }

    static int b(AdTrackerWebViewLoader adtrackerwebviewloader, String s)
    {
        return adtrackerwebviewloader.b(s);
    }

    private int b(String s)
    {
        JSONObject jsonobject;
        String s1;
        int i;
        int j;
        s = new JSONObject(URLDecoder.decode(s, "utf-8"));
        jsonobject = s.getJSONObject("iat_ids");
        s1 = s.getString("errmsg");
        j = s.getInt("timetoLive");
        i = s.getInt("errcode");
        if (i == 6000)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Failed to upload goal in webview").append(s1).toString());
        return i;
        s = jsonobject.toString();
        if (i == 6001)
        {
            s = null;
        }
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids", s);
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "timetoLive", Integer.toString(j));
        return i;
        s;
_L4:
        s.printStackTrace();
        return i;
        s;
        i = 6000;
_L2:
        s.printStackTrace();
        return i;
        s;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        i = 6000;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static long b(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        return adtrackerwebviewloader.d;
    }

    static long b(AdTrackerWebViewLoader adtrackerwebviewloader, long l)
    {
        adtrackerwebviewloader.e = l;
        return l;
    }

    static Goal c(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        return adtrackerwebviewloader.b;
    }

    static String d(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        return adtrackerwebviewloader.c;
    }

    static long e(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        return adtrackerwebviewloader.e;
    }

    public void deinit(int i)
    {
        AdTrackerNetworkInterface.getUIHandler().postDelayed(new Runnable() {

            final AdTrackerWebViewLoader a;

            public void run()
            {
                if (AdTrackerWebViewLoader.a(a) != null)
                {
                    AdTrackerWebViewLoader.a(a).stopLoading();
                    AdTrackerWebViewLoader.a(a).destroy();
                }
            }

            
            {
                a = AdTrackerWebViewLoader.this;
                super();
            }
        }, i);
    }

    public boolean loadWebview(String s, Goal goal)
    {
        b = goal;
        c = s;
        AdTrackerNetworkInterface.getUIHandler().post(new Runnable() {

            final AdTrackerWebViewLoader a;

            public void run()
            {
                AdTrackerWebViewLoader.a(a, System.currentTimeMillis());
                Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Load Webview: ").append(AdTrackerNetworkInterface.b()).toString());
                AdTrackerWebViewLoader.a(a).loadUrl(AdTrackerNetworkInterface.b());
            }

            
            {
                a = AdTrackerWebViewLoader.this;
                super();
            }
        });
        return true;
    }
}
