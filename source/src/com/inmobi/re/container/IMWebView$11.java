// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class  extends WebChromeClient
{

    final IMWebView a;

    public void onGeolocationPermissionsShowPrompt(String s, android.webkit.rmissions.Callback callback)
    {
        try
        {
            android.app.uilder uilder = new android.app.uilder(IMWebView.i(a));
            uilder.setTitle("Locations access");
            uilder.setMessage("Allow location access").setCancelable(true).setPositiveButton("Accept", new android.content.DialogInterface.OnClickListener(callback, s) {

                final android.webkit.GeolocationPermissions.Callback a;
                final String b;
                final IMWebView._cls11 c;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    a.invoke(b, true, false);
                }

            
            {
                c = IMWebView._cls11.this;
                a = callback;
                b = s;
                super();
            }
            }).setNegativeButton("Decline", new android.content.DialogInterface.OnClickListener(callback, s) {

                final android.webkit.GeolocationPermissions.Callback a;
                final String b;
                final IMWebView._cls11 c;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    a.invoke(b, false, false);
                }

            
            {
                c = IMWebView._cls11.this;
                a = callback;
                b = s;
                super();
            }
            });
            uilder.create().show();
            super.onGeolocationPermissionsShowPrompt(s, callback);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception while accessing location from creative ", exception);
        }
        callback.invoke(s, false, false);
    }

    public void onHideCustomView()
    {
        IMWebView.m(a);
        super.onHideCustomView();
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> onJsAlert, ").append(s1).toString());
        if (!a.isExpanded() && !a.mIsInterstitialAd) goto _L2; else goto _L1
_L1:
        webview = a.getExpandedActivity();
_L4:
        (new android.app.uilder(webview)).setTitle(s).setMessage(s1).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(jsresult) {

            final JsResult a;
            final IMWebView._cls11 b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.confirm();
            }

            
            {
                b = IMWebView._cls11.this;
                a = jsresult;
                super();
            }
        }).setCancelable(false).create().show();
        break MISSING_BLOCK_LABEL_113;
_L2:
        webview = webview.getContext();
        if (true) goto _L4; else goto _L3
_L3:
        webview;
        Log.internal("[InMobi]-[RE]-4.5.5", "webchrome client exception onJSAlert ", webview);
        return true;
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> onJsConfirm, ").append(s1).toString());
        if (!a.isExpanded() && !a.mIsInterstitialAd) goto _L2; else goto _L1
_L1:
        webview = a.getExpandedActivity();
_L4:
        webview = (new android.app.uilder(webview)).setTitle(s).setMessage(s1).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(jsresult) {

            final JsResult a;
            final IMWebView._cls11 b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.confirm();
            }

            
            {
                b = IMWebView._cls11.this;
                a = jsresult;
                super();
            }
        });
        webview.setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener(jsresult) {

            final JsResult a;
            final IMWebView._cls11 b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.cancel();
            }

            
            {
                b = IMWebView._cls11.this;
                a = jsresult;
                super();
            }
        });
        webview.setCancelable(false).create().show();
        break MISSING_BLOCK_LABEL_132;
_L2:
        webview = webview.getContext();
        if (true) goto _L4; else goto _L3
_L3:
        webview;
        Log.internal("[InMobi]-[RE]-4.5.5", "webchrome client exception onJSConfirm ", webview);
        return true;
    }

    public void onShowCustomView(View view, android.webkit.nt.CustomViewCallback customviewcallback)
    {
        IMWebView.a(a, view);
        IMWebView.a(a, customviewcallback);
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("onShowCustomView ******************************").append(view).toString());
        IMWebView.a(a, IMWebView.h(a), new android.view.View.OnTouchListener() {

            final IMWebView._cls11 a;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                return false;
            }

            
            {
                a = IMWebView._cls11.this;
                super();
            }
        });
        IMWebView.h(a).setOnTouchListener(new android.view.View.OnTouchListener() {

            final IMWebView._cls11 a;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = IMWebView._cls11.this;
                super();
            }
        });
        if (!(view instanceof FrameLayout))
        {
            break MISSING_BLOCK_LABEL_408;
        }
        IMWebView.a(a, (FrameLayout)view);
        customviewcallback = (FrameLayout)IMWebView.i(a).findViewById(0x1020002);
        if (!(IMWebView.j(a).getFocusedChild() instanceof VideoView))
        {
            break MISSING_BLOCK_LABEL_308;
        }
        IMWebView.a(a, (VideoView)IMWebView.j(a).getFocusedChild());
        if (!a.isExpanded() && !a.mIsInterstitialAd)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        view = a.getExpandedActivity();
_L2:
        IMWebView.k(a).setMediaController(new MediaController(view));
        IMWebView.j(a).setBackgroundColor(0xff000000);
        IMWebView.k(a).setOnCompletionListener(IMWebView.l(a));
        IMWebView.k(a).setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final IMWebView._cls11 a;

            public void onFocusChange(View view1, boolean flag)
            {
                IMWebView.k(a.a).requestFocus();
            }

            
            {
                a = IMWebView._cls11.this;
                super();
            }
        });
        customviewcallback.addView(IMWebView.h(a), new android.widget.t.LayoutParams(-1, -1, 0, 0));
        Log.debug("[InMobi]-[RE]-4.5.5", "Registering");
        IMWebView.a(a, IMWebView.h(a), new android.view.View.OnKeyListener() {

            final IMWebView._cls11 a;

            public boolean onKey(View view1, int i, KeyEvent keyevent)
            {
                if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
                {
                    Log.debug("[InMobi]-[RE]-4.5.5", "Back Button pressed when html5 video is playing");
                    IMWebView.k(a.a).stopPlayback();
                    IMWebView.m(a.a);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = IMWebView._cls11.this;
                super();
            }
        });
        return;
        view = view.getContext();
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            IMWebView.a(a, view);
            view.setBackgroundColor(0xff000000);
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("adding ").append(view).toString());
            customviewcallback.addView(view, new android.widget.t.LayoutParams(-1, -1, 0, 0));
            IMWebView.h(a).requestFocus();
            IMWebView.a(a, IMWebView.h(a), new android.view.View.OnKeyListener() {

                final IMWebView._cls11 a;

                public boolean onKey(View view1, int i, KeyEvent keyevent)
                {
                    if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
                    {
                        Log.debug("[InMobi]-[RE]-4.5.5", "Back Button pressed when html5 video is playing");
                        IMWebView.m(a.a);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            
            {
                a = IMWebView._cls11.this;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "IMWebview onShowCustomView exception ", view);
        }
    }

    _cls9.a(IMWebView imwebview)
    {
        a = imwebview;
        super();
    }
}
