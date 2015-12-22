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

class b
    implements android.content.OnClickListener
{

    final android.webkit.ssions.Callback a;
    final String b;
    final llback c;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        a.invoke(b, false, false);
    }

    llback(llback llback, android.webkit.ssions.Callback callback, String s)
    {
        c = llback;
        a = callback;
        b = s;
        super();
    }

    // Unreferenced inner class com/inmobi/re/container/IMWebView$11

/* anonymous class */
    class IMWebView._cls11 extends WebChromeClient
    {

        final IMWebView a;

        public void onGeolocationPermissionsShowPrompt(String s, android.webkit.GeolocationPermissions.Callback callback)
        {
            try
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(IMWebView.i(a));
                builder.setTitle("Locations access");
                builder.setMessage("Allow location access").setCancelable(true).setPositiveButton("Accept", new IMWebView._cls11._cls2(callback, s)).setNegativeButton("Decline", new IMWebView._cls11._cls10(this, callback, s));
                builder.create().show();
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
            (new android.app.AlertDialog.Builder(webview)).setTitle(s).setMessage(s1).setPositiveButton(0x104000a, new IMWebView._cls11._cls1(jsresult)).setCancelable(false).create().show();
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
            webview = (new android.app.AlertDialog.Builder(webview)).setTitle(s).setMessage(s1).setPositiveButton(0x104000a, new IMWebView._cls11._cls3(jsresult));
            webview.setNegativeButton(0x1040000, new IMWebView._cls11._cls4(jsresult));
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

        public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            IMWebView.a(a, view);
            IMWebView.a(a, customviewcallback);
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("onShowCustomView ******************************").append(view).toString());
            IMWebView.a(a, IMWebView.h(a), new IMWebView._cls11._cls5());
            IMWebView.h(a).setOnTouchListener(new IMWebView._cls11._cls6());
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
            IMWebView.k(a).setOnFocusChangeListener(new IMWebView._cls11._cls7());
            customviewcallback.addView(IMWebView.h(a), new android.widget.AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
            Log.debug("[InMobi]-[RE]-4.5.5", "Registering");
            IMWebView.a(a, IMWebView.h(a), new IMWebView._cls11._cls8());
            return;
            view = view.getContext();
            if (true) goto _L2; else goto _L1
_L1:
            try
            {
                IMWebView.a(a, view);
                view.setBackgroundColor(0xff000000);
                Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("adding ").append(view).toString());
                customviewcallback.addView(view, new android.widget.AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
                IMWebView.h(a).requestFocus();
                IMWebView.a(a, IMWebView.h(a), new IMWebView._cls11._cls9());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "IMWebview onShowCustomView exception ", view);
            }
        }

            
            {
                a = imwebview;
                super();
            }

        // Unreferenced inner class com/inmobi/re/container/IMWebView$11$1

/* anonymous class */
        class IMWebView._cls11._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inmobi/re/container/IMWebView$11$2

/* anonymous class */
        class IMWebView._cls11._cls2
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inmobi/re/container/IMWebView$11$3

/* anonymous class */
        class IMWebView._cls11._cls3
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inmobi/re/container/IMWebView$11$4

/* anonymous class */
        class IMWebView._cls11._cls4
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inmobi/re/container/IMWebView$11$5

/* anonymous class */
        class IMWebView._cls11._cls5
            implements android.view.View.OnTouchListener
        {

            final IMWebView._cls11 a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return false;
            }

                    
                    {
                        a = IMWebView._cls11.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inmobi/re/container/IMWebView$11$6

/* anonymous class */
        class IMWebView._cls11._cls6
            implements android.view.View.OnTouchListener
        {

            final IMWebView._cls11 a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

                    
                    {
                        a = IMWebView._cls11.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inmobi/re/container/IMWebView$11$7

/* anonymous class */
        class IMWebView._cls11._cls7
            implements android.view.View.OnFocusChangeListener
        {

            final IMWebView._cls11 a;

            public void onFocusChange(View view, boolean flag)
            {
                IMWebView.k(a.a).requestFocus();
            }

                    
                    {
                        a = IMWebView._cls11.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inmobi/re/container/IMWebView$11$8

/* anonymous class */
        class IMWebView._cls11._cls8
            implements android.view.View.OnKeyListener
        {

            final IMWebView._cls11 a;

            public boolean onKey(View view, int i, KeyEvent keyevent)
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
        }


        // Unreferenced inner class com/inmobi/re/container/IMWebView$11$9

/* anonymous class */
        class IMWebView._cls11._cls9
            implements android.view.View.OnKeyListener
        {

            final IMWebView._cls11 a;

            public boolean onKey(View view, int i, KeyEvent keyevent)
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
        }

    }

}
