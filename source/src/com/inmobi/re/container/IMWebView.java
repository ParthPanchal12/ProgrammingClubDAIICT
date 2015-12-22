// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.container.mraidimpl.MRAIDBasic;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.container.mraidimpl.MRAIDResizeController;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import com.inmobi.re.controller.JSUtilityController;
import com.inmobi.re.controller.util.AVPlayer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.re.container:
//            CustomView

public class IMWebView extends WebView
    implements Serializable
{
    public static interface IMWebViewListener
    {

        public abstract void onDismissAdScreen();

        public abstract void onDisplayFailed();

        public abstract void onError();

        public abstract void onExpand();

        public abstract void onExpandClose();

        public abstract void onIncentCompleted(Map map);

        public abstract void onLeaveApplication();

        public abstract void onResize(ResizeDimensions resizedimensions);

        public abstract void onResizeClose();

        public abstract void onShowAdScreen();

        public abstract void onUserInteraction(Map map);
    }

    public static interface IMWebViewPlayableListener
    {

        public abstract void onPlayableSettingsReceived(Map map);
    }

    public static interface InstantVideoCallbackCallback
    {

        public abstract void postFailed(int i1);

        public abstract void postSuccess();
    }

    public static final class ViewState extends Enum
    {

        public static final ViewState DEFAULT;
        public static final ViewState EXPANDED;
        public static final ViewState EXPANDING;
        public static final ViewState HIDDEN;
        public static final ViewState LOADING;
        public static final ViewState RESIZED;
        public static final ViewState RESIZING;
        private static final ViewState a[];

        public static ViewState valueOf(String s1)
        {
            return (ViewState)Enum.valueOf(com/inmobi/re/container/IMWebView$ViewState, s1);
        }

        public static ViewState[] values()
        {
            return (ViewState[])a.clone();
        }

        static 
        {
            LOADING = new ViewState("LOADING", 0);
            DEFAULT = new ViewState("DEFAULT", 1);
            RESIZED = new ViewState("RESIZED", 2);
            EXPANDED = new ViewState("EXPANDED", 3);
            EXPANDING = new ViewState("EXPANDING", 4);
            HIDDEN = new ViewState("HIDDEN", 5);
            RESIZING = new ViewState("RESIZING", 6);
            a = (new ViewState[] {
                LOADING, DEFAULT, RESIZED, EXPANDED, EXPANDING, HIDDEN, RESIZING
            });
        }

        private ViewState(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    class a extends AsyncTask
    {

        File a;
        String b;
        String c;
        int d;
        String e;
        final IMWebView f;

        public String a()
        {
            return c;
        }

        protected transient String a(Void avoid[])
        {
            int i1;
            avoid = IMWebView.i(f).getPackageManager();
            boolean flag;
            if (avoid.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", avoid.getNameForUid(Binder.getCallingUid())) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                d = b.j.ordinal();
                return "failure";
            }
            if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
            {
                d = b.i.ordinal();
                return "failure";
            }
            if (!c.matches("[A-Za-z0-9]+") || c.equals(""))
            {
                d = b.c.ordinal();
                return "failure";
            }
            if (b.equals("") || !URLUtil.isValidUrl(b))
            {
                d = b.d.ordinal();
                return "failure";
            }
            avoid = Initializer.getConfigParams().getAllowedContentType().replace("\\", "");
            avoid = avoid.substring(1, avoid.length() - 1);
            Object obj;
            String s1;
            int j1;
            long l2;
            if (avoid.contains(","))
            {
                avoid = avoid.split(",");
            } else
            {
                avoid = (new String[] {
                    avoid
                });
            }
            j1 = Initializer.getConfigParams().getMaxSaveContentSize();
            byte abyte0[];
            long l1;
            try
            {
                l2 = System.currentTimeMillis();
                obj = (HttpURLConnection)(new URL(b)).openConnection();
                ((HttpURLConnection) (obj)).setRequestMethod("GET");
                ((HttpURLConnection) (obj)).setConnectTimeout(5000);
                s1 = ((HttpURLConnection) (obj)).getContentType();
                android.util.Log.i("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("contentType_url: ").append(s1).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "SocketTimeoutException");
                d = b.i.ordinal();
                return "failure";
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "FileNotFoundException");
                d = b.e.ordinal();
                return "failure";
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "MalformedURLException");
                d = b.d.ordinal();
                return "failure";
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "ProtocolException");
                d = b.i.ordinal();
                return "failure";
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "IOException");
                d = b.a.ordinal();
                return "failure";
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "JSONException");
                d = b.a.ordinal();
                return "failure";
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "Unknown Exception");
                d = b.a.ordinal();
                return "failure";
            }
            i1 = 0;
            if (i1 >= avoid.length)
            {
                break MISSING_BLOCK_LABEL_835;
            }
            if (!avoid[i1].substring(1, avoid[i1].length() - 1).equals(s1)) goto _L2; else goto _L1
_L1:
            i1 = 1;
_L7:
            if (i1 != 0) goto _L4; else goto _L3
_L3:
            d = b.g.ordinal();
            return "failure";
_L2:
            i1++;
            break MISSING_BLOCK_LABEL_267;
_L4:
            l1 = ((HttpURLConnection) (obj)).getContentLength();
            if (l1 < 0L)
            {
                break MISSING_BLOCK_LABEL_444;
            }
            android.util.Log.e("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("content size: ").append(l1).toString());
            android.util.Log.e("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("max size: ").append(j1 * 1024 * 1024).toString());
            if (l1 <= (long)(j1 * 1024 * 1024))
            {
                break MISSING_BLOCK_LABEL_444;
            }
            d = b.h.ordinal();
            return "failure";
            ((HttpURLConnection) (obj)).connect();
            avoid = new FileOutputStream(a);
            obj = ((HttpURLConnection) (obj)).getInputStream();
            abyte0 = new byte[1024];
            l1 = 0L;
_L5:
            i1 = ((InputStream) (obj)).read(abyte0);
            if (i1 <= 0)
            {
                break MISSING_BLOCK_LABEL_557;
            }
            l1 += i1;
            if (l1 <= (long)(j1 * 1024 * 1024))
            {
                break MISSING_BLOCK_LABEL_524;
            }
            d = b.h.ordinal();
            return "failure";
            avoid.write(abyte0, 0, i1);
              goto _L5
            avoid.close();
            l1 = System.currentTimeMillis();
            avoid = (new StringBuilder()).append("file://").append(a.getAbsolutePath()).toString();
            Log.internal("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("file path of video: ").append(avoid).toString());
            obj = new JSONObject();
            ((JSONObject) (obj)).put("url", b);
            ((JSONObject) (obj)).put("saved_url", avoid);
            ((JSONObject) (obj)).put("size_in_bytes", a.length());
            ((JSONObject) (obj)).put("download_started_at", l2);
            ((JSONObject) (obj)).put("download_ended_at", l1);
            e = ((JSONObject) (obj)).toString().replace("\"", "\\\"");
            return "success";
            i1 = 0;
            if (true) goto _L7; else goto _L6
_L6:
        }

        protected void a(String s1)
        {
            if (!s1.equals("success")) goto _L2; else goto _L1
_L1:
            f.injectJavaScript((new StringBuilder()).append("window.mraid.sendSaveContentResult(\"saveContent_").append(c).append("\", 'success', \"").append(e).append("\");").toString());
            if (f.c != null)
            {
                f.c.postSuccess();
            }
_L4:
            super.onPostExecute(s1);
            return;
_L2:
            Object obj = new JSONObject();
            try
            {
                ((JSONObject) (obj)).put("url", b);
                ((JSONObject) (obj)).put("reason", d);
                obj = ((JSONObject) (obj)).toString().replace("\"", "\\\"");
                f.injectJavaScript((new StringBuilder()).append("window.mraid.sendSaveContentResult(\"saveContent_").append(c).append("\", 'failure', \"").append(((String) (obj))).append("\");").toString());
                if (f.c != null)
                {
                    f.c.postFailed(d);
                }
            }
            catch (JSONException jsonexception) { }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
        }

        protected void onPostExecute(Object obj)
        {
            a((String)obj);
        }

        a(File file, String s1, String s2)
        {
            f = IMWebView.this;
            super();
            d = -1;
            e = "";
            a = file;
            c = s1;
            b = s2;
            if (IMWebView.q(IMWebView.this) == null)
            {
                IMWebView.a(IMWebView.this, new ArrayList());
            }
            IMWebView.q(IMWebView.this).add(this);
        }
    }

    private static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final b g;
        public static final b h;
        public static final b i;
        public static final b j;
        public static final b k;
        private static final b l[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/inmobi/re/container/IMWebView$b, s1);
        }

        public static b[] values()
        {
            return (b[])l.clone();
        }

        static 
        {
            a = new b("UNKNOWN_ERROR", 0);
            b = new b("MISSING_PARAMETER", 1);
            c = new b("CONETNT_ID_ERROR", 2);
            d = new b("CONTENT_URL_ERROR", 3);
            e = new b("CONTENT_URL_NOT_FOUND", 4);
            f = new b("NOT_SUPPORTED_SDK", 5);
            g = new b("CONTENT_TYPE_NOT_SUPPORTED", 6);
            h = new b("CONTENT_SIZE_NOT_SUPPORTED", 7);
            i = new b("NETWORK_ERROR", 8);
            j = new b("PERMISSION_ERROR", 9);
            k = new b("SD_CARD_ERROR", 10);
            l = (new b[] {
                a, b, c, d, e, f, g, h, i, j, 
                k
            });
        }

        private b(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    static class c extends Handler
    {

        private final WeakReference a;
        private final WeakReference b;
        private final WeakReference c;
        private final WeakReference d;
        private final WeakReference e;
        private final WeakReference f;

        public void handleMessage(Message message)
        {
            Object obj;
            IMWebView imwebview;
            Object obj1;
            Object obj2;
            MRAIDExpandController mraidexpandcontroller;
            MRAIDResizeController mraidresizecontroller;
            MRAIDInterstitialController mraidinterstitialcontroller;
            try
            {
                imwebview = (IMWebView)a.get();
                obj2 = (MRAIDBasic)d.get();
                mraidexpandcontroller = (MRAIDExpandController)b.get();
                mraidresizecontroller = (MRAIDResizeController)c.get();
                mraidinterstitialcontroller = (MRAIDInterstitialController)e.get();
                obj = (MRAIDAudioVideoController)f.get();
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "Webview Handle Message Exception ", message);
                return;
            }
            if (imwebview == null) goto _L2; else goto _L1
_L1:
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView->handleMessage: msg: ").append(message).toString());
            obj1 = message.getData();
            message.what;
            JVM INSTR tableswitch 1001 1035: default 1267
        //                       1001 318
        //                       1002 408
        //                       1003 423
        //                       1004 457
        //                       1005 299
        //                       1006 510
        //                       1007 485
        //                       1008 1020
        //                       1009 1083
        //                       1010 535
        //                       1011 682
        //                       1012 750
        //                       1013 764
        //                       1014 834
        //                       1015 948
        //                       1016 961
        //                       1017 999
        //                       1018 974
        //                       1019 564
        //                       1020 593
        //                       1021 622
        //                       1022 658
        //                       1023 1097
        //                       1024 1104
        //                       1025 1120
        //                       1026 1141
        //                       1027 1149
        //                       1028 1164
        //                       1029 1183
        //                       1030 437
        //                       1031 270
        //                       1032 1191
        //                       1033 1199
        //                       1034 1233
        //                       1035 1090;
               goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37
_L2:
            super.handleMessage(message);
            return;
_L33:
            if (imwebview.mListener == null) goto _L2; else goto _L38
_L38:
            imwebview.mListener.onResizeClose();
              goto _L2
_L7:
            if (imwebview.mListener == null) goto _L2; else goto _L39
_L39:
            imwebview.mListener.onExpandClose();
              goto _L2
_L3:
            static class _cls7
            {

                static final int a[];

                static 
                {
                    a = new int[ViewState.values().length];
                    try
                    {
                        a[ViewState.RESIZING.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        a[ViewState.RESIZED.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        a[ViewState.EXPANDING.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[ViewState.EXPANDED.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[ViewState.HIDDEN.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[ViewState.DEFAULT.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls7.a[IMWebView.b(imwebview).ordinal()];
            JVM INSTR tableswitch 1 5: default 1270
        //                       1 379
        //                       2 379
        //                       3 387
        //                       4 387
        //                       5 264;
               goto _L40 _L41 _L41 _L42 _L42 _L2
_L40:
            if (!imwebview.mIsInterstitialAd) goto _L44; else goto _L43
_L43:
            mraidinterstitialcontroller.resetContentsForInterstitials();
              goto _L2
_L41:
            mraidresizecontroller.closeResized();
              goto _L2
_L42:
            mraidexpandcontroller.closeExpanded();
            mraidexpandcontroller.mIsExpandUrlValid = false;
              goto _L2
_L44:
            imwebview.hide();
              goto _L2
_L4:
            imwebview.setVisibility(4);
            imwebview.setState(ViewState.HIDDEN);
              goto _L2
_L5:
            imwebview.injectJavaScript("window.mraidview.fireChangeEvent({ state: 'default' });");
            imwebview.setVisibility(0);
              goto _L2
_L32:
            if (IMWebView.b(imwebview) != ViewState.RESIZING) goto _L2; else goto _L45
_L45:
            mraidresizecontroller.doResize(((Bundle) (obj1)));
              goto _L2
_L6:
            if (IMWebView.b(imwebview) == ViewState.EXPANDING)
            {
                mraidexpandcontroller.doExpand(((Bundle) (obj1)));
            }
            IMWebView.n(imwebview).setWebViewClosed(false);
              goto _L2
_L9:
            ((MRAIDAudioVideoController) (obj)).playAudioImpl(((Bundle) (obj1)), IMWebView.i(imwebview));
              goto _L2
            obj;
            Log.debug("[InMobi]-[RE]-4.5.5", "Play audio failed ", ((Throwable) (obj)));
              goto _L2
_L8:
            ((MRAIDAudioVideoController) (obj)).playVideoImpl(((Bundle) (obj1)), IMWebView.i(imwebview));
              goto _L2
            obj;
            Log.debug("[InMobi]-[RE]-4.5.5", "Play video failed ", ((Throwable) (obj)));
              goto _L2
_L12:
            obj = (AVPlayer)((MRAIDAudioVideoController) (obj)).audioPlayerList.get(((Bundle) (obj1)).getString("aplayerref"));
            if (obj == null) goto _L2; else goto _L46
_L46:
            ((AVPlayer) (obj)).pause();
              goto _L2
_L21:
            obj = (AVPlayer)((MRAIDAudioVideoController) (obj)).audioPlayerList.get(((Bundle) (obj1)).getString("aplayerref"));
            if (obj == null) goto _L2; else goto _L47
_L47:
            ((AVPlayer) (obj)).mute();
              goto _L2
_L22:
            obj = (AVPlayer)((MRAIDAudioVideoController) (obj)).audioPlayerList.get(((Bundle) (obj1)).getString("aplayerref"));
            if (obj == null) goto _L2; else goto _L48
_L48:
            ((AVPlayer) (obj)).unMute();
              goto _L2
_L23:
            obj = (AVPlayer)((MRAIDAudioVideoController) (obj)).audioPlayerList.get(((Bundle) (obj1)).getString("aplayerref"));
            if (obj == null) goto _L2; else goto _L49
_L49:
            ((AVPlayer) (obj)).setVolume(((Bundle) (obj1)).getInt("vol"));
              goto _L2
_L24:
            ((AVPlayer)message.obj).seekPlayer(((Bundle) (obj1)).getInt("seekaudio") * 1000);
              goto _L2
_L13:
            obj = ((MRAIDAudioVideoController) (obj)).getVideoPlayer(((Bundle) (obj1)).getString("pid"));
            if (obj != null) goto _L51; else goto _L50
_L50:
            obj = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"pauseVideo\")";
_L71:
            imwebview.injectJavaScript(((String) (obj)));
              goto _L2
_L51:
            if (((AVPlayer) (obj)).getState() == com.inmobi.re.controller.util.AVPlayer.playerState.PLAYING) goto _L53; else goto _L52
_L52:
            if (((AVPlayer) (obj)).getState() != com.inmobi.re.controller.util.AVPlayer.playerState.INIT) goto _L55; else goto _L54
_L54:
            if (!((AVPlayer) (obj)).isPrepared())
            {
                ((AVPlayer) (obj)).setAutoPlay(false);
            }
              goto _L2
_L53:
            ((AVPlayer) (obj)).pause();
            return;
_L14:
            ((AVPlayer)message.obj).releasePlayer(false);
              goto _L2
_L15:
            obj1 = ((Bundle) (obj1)).getString("pid");
            obj2 = ((MRAIDAudioVideoController) (obj)).getVideoPlayer(((String) (obj1)));
            if (obj2 != null) goto _L57; else goto _L56
_L56:
            obj = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"hideVideo\")";
_L60:
            imwebview.injectJavaScript(((String) (obj)));
              goto _L2
_L57:
            if (((AVPlayer) (obj2)).getState() != com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED) goto _L59; else goto _L58
_L58:
            obj = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"hideVideo\")";
              goto _L60
_L59:
            ((MRAIDAudioVideoController) (obj)).videoPlayerList.put(obj1, obj2);
            ((AVPlayer) (obj2)).hide();
            return;
_L16:
            obj1 = ((Bundle) (obj1)).getString("pid");
            obj2 = ((MRAIDAudioVideoController) (obj)).getVideoPlayer(((String) (obj1)));
            if (obj2 != null) goto _L62; else goto _L61
_L61:
            obj = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"showVideo\")";
_L65:
            imwebview.injectJavaScript(((String) (obj)));
              goto _L2
_L62:
            if (((AVPlayer) (obj2)).getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || ((AVPlayer) (obj2)).getState() == com.inmobi.re.controller.util.AVPlayer.playerState.HIDDEN) goto _L64; else goto _L63
_L63:
            obj = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"showVideo\")";
              goto _L65
_L64:
            if (((MRAIDAudioVideoController) (obj)).videoPlayer == null || ((MRAIDAudioVideoController) (obj)).videoPlayer.getPropertyID().equalsIgnoreCase(((String) (obj1)))) goto _L67; else goto _L66
_L66:
            obj = "window.mraid.broadcastEvent('error',\"Show failed. There is already a video playing\", \"showVideo\")";
              goto _L65
_L67:
            ((MRAIDAudioVideoController) (obj)).videoPlayerList.remove(obj1);
            obj.videoPlayer = ((AVPlayer) (obj2));
            ((AVPlayer) (obj2)).show();
            return;
_L17:
            ((AVPlayer)message.obj).mute();
              goto _L2
_L18:
            ((AVPlayer)message.obj).unMute();
              goto _L2
_L20:
            ((AVPlayer)message.obj).seekPlayer(((Bundle) (obj1)).getInt("seek") * 1000);
              goto _L2
_L19:
            ((AVPlayer)message.obj).setVolume(((Bundle) (obj1)).getInt("volume"));
              goto _L2
_L10:
            obj = ((Bundle) (obj1)).getString("message");
            obj1 = ((Bundle) (obj1)).getString("action");
            imwebview.injectJavaScript((new StringBuilder()).append("window.mraid.broadcastEvent('error',\"").append(((String) (obj))).append("\", \"").append(((String) (obj1))).append("\")").toString());
              goto _L2
_L11:
            imwebview.setCloseButton();
              goto _L2
_L37:
            imwebview.disableCloseRegion();
              goto _L2
_L25:
            ((MRAIDAudioVideoController) (obj)).hidePlayers();
              goto _L2
_L26:
            ((MRAIDBasic) (obj2)).open(((Bundle) (obj1)).getString("expand_url"));
              goto _L2
_L27:
            obj = ((Bundle) (obj1)).getString("injectMessage");
            if (obj == null) goto _L2; else goto _L68
_L68:
            imwebview.injectJavaScript(((String) (obj)));
              goto _L2
_L28:
            mraidinterstitialcontroller.handleOrientationForInterstitial();
              goto _L2
_L29:
            if (imwebview.mIsInterstitialAd) goto _L2; else goto _L69
_L69:
            mraidresizecontroller.onOrientationChange();
              goto _L2
_L30:
            if (imwebview.mListener == null) goto _L2; else goto _L70
_L70:
            imwebview.mListener.onDismissAdScreen();
              goto _L2
_L31:
            ((MRAIDBasic) (obj2)).getCurrentPosition();
              goto _L2
_L34:
            ((MRAIDBasic) (obj2)).getDefaultPosition();
              goto _L2
_L35:
            obj = (HashMap)message.getData().getSerializable("map");
            if (imwebview.mListener != null)
            {
                imwebview.mListener.onUserInteraction(((Map) (obj)));
            }
              goto _L2
_L36:
            obj = (HashMap)message.getData().getSerializable("incent_ad_map");
            if (imwebview.mListener != null)
            {
                imwebview.mListener.onIncentCompleted(((Map) (obj)));
            }
              goto _L2
_L55:
            obj = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"pauseVideo\")";
              goto _L71
        }

        public c(IMWebView imwebview, MRAIDBasic mraidbasic, MRAIDExpandController mraidexpandcontroller, MRAIDInterstitialController mraidinterstitialcontroller, MRAIDAudioVideoController mraidaudiovideocontroller, MRAIDResizeController mraidresizecontroller)
        {
            a = new WeakReference(imwebview);
            b = new WeakReference(mraidexpandcontroller);
            d = new WeakReference(mraidbasic);
            e = new WeakReference(mraidinterstitialcontroller);
            f = new WeakReference(mraidaudiovideocontroller);
            c = new WeakReference(mraidresizecontroller);
        }
    }


    public static final String DIMENSIONS = "expand_dimensions";
    public static final String EXPAND_URL = "expand_url";
    private static Class G = null;
    protected static final int IMWEBVIEW_INTERSTITIAL_ID = 117;
    public static final String PLAYER_PROPERTIES = "player_properties";
    private static int d[] = {
        0x101011f, 0x1010120
    };
    private static final long serialVersionUID = 0x6282f5dae34d0336L;
    public static boolean userInitiatedClose = false;
    private c A;
    private ArrayList B;
    private AtomicBoolean C;
    private ViewParent D;
    private int E;
    private boolean F;
    private WebViewClient H = new WebViewClient() {

        final IMWebView a;

        public void onLoadResource(WebView webview, String s1)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> onLoadResource:").append(s1).toString());
            try
            {
                if (IMWebView.a(a) != null)
                {
                    IMWebView.a(a).onLoadResource(webview, s1);
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "Cannot load resource", webview);
                return;
            }
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_178;
            }
            if (s1.contains("/mraid.js") && !a.getUrl().equals("about:blank") && !a.getUrl().startsWith("file:"))
            {
                Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> onLoadResource:Hippy, Mraid ad alert!...injecting mraid and mraidview object at ").append(webview.getUrl()).toString());
                webview = a.getUrl();
                if (!IMWebView.e(a).contains(webview))
                {
                    IMWebView.e(a).add(webview);
                }
                if (!a.mraidLoaded)
                {
                    a.injectJavaScript(Initializer.getMRAIDString());
                }
                a.mraidLoaded = true;
            }
        }

        public void onPageFinished(WebView webview, String s1)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> onPageFinished, url: ").append(s1).toString());
            if (IMWebView.a(a) != null)
            {
                IMWebView.a(a).onPageFinished(webview, s1);
            }
            if (!IMWebView.d(a)) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (IMWebView.e(a).contains(s1) && !a.mraidLoaded)
            {
                a.injectJavaScript(Initializer.getMRAIDString());
            }
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> Current State:").append(IMWebView.b(a)).toString());
            if (IMWebView.b(a) != ViewState.LOADING)
            {
                continue; /* Loop/switch isn't completed */
            }
            a.injectJavaScript("window.mraid.broadcastEvent('ready');");
            a.injectJavaScript("window._im_imai.broadcastEvent('ready');");
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> Firing ready event at ").append(webview).toString());
            if (a.mOriginalWebviewForExpandUrl == null)
            {
                break; /* Loop/switch isn't completed */
            }
            a.setState(ViewState.EXPANDED);
_L4:
            if ((!a.mIsInterstitialAd || a.mWebViewIsBrowserActivity) && a.getVisibility() == 4)
            {
                a.setVisibility(0);
            }
            if (IMWebView.f(a) != null && !IMWebView.c(a).get())
            {
                IMWebView.f(a).sendToTarget();
            }
            if (IMWebView.g(a) != null)
            {
                IMWebView.g(a).sendToTarget();
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
            try
            {
                a.setState(ViewState.DEFAULT);
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Log.debug("[InMobi]-[RE]-4.5.5", "Exception in onPageFinished ", webview);
                return;
            }
              goto _L4
            if (true) goto _L1; else goto _L5
_L5:
        }

        public void onPageStarted(WebView webview, String s1, Bitmap bitmap)
        {
            a.setState(ViewState.LOADING);
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> onPageStarted url: ").append(s1).append(" p ").append(a.getParent()).toString());
            if (a.getParent() == null)
            {
                IMWebView.a(a, true);
            }
            if (IMWebView.a(a) != null)
            {
                IMWebView.a(a).onPageStarted(webview, s1, bitmap);
            }
            a.mraidLoaded = false;
        }

        public void onReceivedError(WebView webview, int i1, String s1, String s2)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> error: ").append(s1).toString());
            if (IMWebView.a(a) != null)
            {
                IMWebView.a(a).onReceivedError(webview, i1, s1, s2);
            }
            try
            {
                if (IMWebView.b(a) == ViewState.LOADING && a.mListener != null && !IMWebView.c(a).get())
                {
                    a.mListener.onError();
                }
                IMWebView.a(a, null);
                IMWebView.b(a, true);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Log.debug("[InMobi]-[RE]-4.5.5", "Exception in webview loading ", webview);
            }
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            IMWebView.a(a, sslerrorhandler, sslerror);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s1)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> shouldOverrideUrlLoading, url:").append(s1).append("webview id").append(webview).toString());
            if (!a.mWebViewIsBrowserActivity)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            if (!s1.startsWith("http:") && !s1.startsWith("https:"))
            {
                break MISSING_BLOCK_LABEL_70;
            }
            a.doHidePlayers();
            return false;
            try
            {
                IMWebView.a(a, s1);
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "Should override exception", webview);
                return false;
            }
            return true;
            IMWebView.a(a, s1);
            return true;
        }

            
            {
                a = IMWebView.this;
                super();
            }
    };
    private WebChromeClient I = new WebChromeClient() {

        final IMWebView a;

        public void onGeolocationPermissionsShowPrompt(String s1, android.webkit.GeolocationPermissions.Callback callback)
        {
            try
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(IMWebView.i(a));
                builder.setTitle("Locations access");
                builder.setMessage("Allow location access").setCancelable(true).setPositiveButton("Accept", new android.content.DialogInterface.OnClickListener(this, callback, s1) {

                    final android.webkit.GeolocationPermissions.Callback a;
                    final String b;
                    final _cls11 c;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        a.invoke(b, true, false);
                    }

            
            {
                c = _pcls11;
                a = callback;
                b = s1;
                super();
            }
                }).setNegativeButton("Decline", new android.content.DialogInterface.OnClickListener(this, callback, s1) {

                    final android.webkit.GeolocationPermissions.Callback a;
                    final String b;
                    final _cls11 c;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        a.invoke(b, false, false);
                    }

            
            {
                c = _pcls11;
                a = callback;
                b = s1;
                super();
            }
                });
                builder.create().show();
                super.onGeolocationPermissionsShowPrompt(s1, callback);
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "Exception while accessing location from creative ", exception);
            }
            callback.invoke(s1, false, false);
        }

        public void onHideCustomView()
        {
            IMWebView.m(a);
            super.onHideCustomView();
        }

        public boolean onJsAlert(WebView webview, String s1, String s2, JsResult jsresult)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> onJsAlert, ").append(s2).toString());
            if (!a.isExpanded() && !a.mIsInterstitialAd) goto _L2; else goto _L1
_L1:
            webview = a.getExpandedActivity();
_L4:
            (new android.app.AlertDialog.Builder(webview)).setTitle(s1).setMessage(s2).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(this, jsresult) {

                final JsResult a;
                final _cls11 b;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    a.confirm();
                }

            
            {
                b = _pcls11;
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

        public boolean onJsConfirm(WebView webview, String s1, String s2, JsResult jsresult)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("IMWebView-> onJsConfirm, ").append(s2).toString());
            if (!a.isExpanded() && !a.mIsInterstitialAd) goto _L2; else goto _L1
_L1:
            webview = a.getExpandedActivity();
_L4:
            webview = (new android.app.AlertDialog.Builder(webview)).setTitle(s1).setMessage(s2).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(this, jsresult) {

                final JsResult a;
                final _cls11 b;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    a.confirm();
                }

            
            {
                b = _pcls11;
                a = jsresult;
                super();
            }
            });
            webview.setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener(this, jsresult) {

                final JsResult a;
                final _cls11 b;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    a.cancel();
                }

            
            {
                b = _pcls11;
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

        public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            IMWebView.a(a, view);
            IMWebView.a(a, customviewcallback);
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("onShowCustomView ******************************").append(view).toString());
            IMWebView.a(a, IMWebView.h(a), new android.view.View.OnTouchListener(this) {

                final _cls11 a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return false;
                }

            
            {
                a = _pcls11;
                super();
            }
            });
            IMWebView.h(a).setOnTouchListener(new android.view.View.OnTouchListener(this) {

                final _cls11 a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    return true;
                }

            
            {
                a = _pcls11;
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
            IMWebView.k(a).setOnFocusChangeListener(new android.view.View.OnFocusChangeListener(this) {

                final _cls11 a;

                public void onFocusChange(View view, boolean flag)
                {
                    IMWebView.k(a.a).requestFocus();
                }

            
            {
                a = _pcls11;
                super();
            }
            });
            customviewcallback.addView(IMWebView.h(a), new android.widget.AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
            Log.debug("[InMobi]-[RE]-4.5.5", "Registering");
            IMWebView.a(a, IMWebView.h(a), new android.view.View.OnKeyListener(this) {

                final _cls11 a;

                public boolean onKey(View view, int i1, KeyEvent keyevent)
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
                a = _pcls11;
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
                customviewcallback.addView(view, new android.widget.AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
                IMWebView.h(a).requestFocus();
                IMWebView.a(a, IMWebView.h(a), new android.view.View.OnKeyListener(this) {

                    final _cls11 a;

                    public boolean onKey(View view, int i1, KeyEvent keyevent)
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
                a = _pcls11;
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

            
            {
                a = IMWebView.this;
                super();
            }
    };
    private android.media.MediaPlayer.OnCompletionListener J = new android.media.MediaPlayer.OnCompletionListener() {

        final IMWebView a;

        public void onCompletion(MediaPlayer mediaplayer)
        {
            try
            {
                mediaplayer.stop();
                IMWebView.j(a).setVisibility(8);
                IMWebView.m(a);
                IMWebView.i(a).setContentView(IMWebView.o(a));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MediaPlayer mediaplayer)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "Media Player onCompletion", mediaplayer);
            }
        }

            
            {
                a = IMWebView.this;
                super();
            }
    };
    private boolean K;
    double a;
    public AtomicBoolean acqMutexcPos;
    public AtomicBoolean acqMutexdPos;
    AtomicBoolean b;
    InstantVideoCallbackCallback c;
    public JSONObject curPosition;
    public JSONObject defPosition;
    public AtomicBoolean doNotFireVisibilityChanged;
    private boolean e;
    private boolean f;
    private JSUtilityController g;
    private float h;
    private int i;
    public AtomicBoolean isMutexAquired;
    public boolean isTablet;
    private int j;
    private ViewState k;
    private IMWebViewPlayableListener l;
    private VideoView m;
    public MRAIDAudioVideoController mAudioVideoController;
    public MRAIDExpandController mExpandController;
    public MRAIDInterstitialController mInterstitialController;
    public boolean mIsInterstitialAd;
    public boolean mIsViewable;
    public IMWebViewListener mListener;
    public MRAIDBasic mMraidBasic;
    public IMWebView mOriginalWebviewForExpandUrl;
    public MRAIDResizeController mResizeController;
    public boolean mWebViewIsBrowserActivity;
    protected boolean mraidLoaded;
    public Object mutex;
    public Object mutexcPos;
    public Object mutexdPos;
    private View n;
    private android.webkit.WebChromeClient.CustomViewCallback o;
    private ViewGroup p;
    public int publisherOrientation;
    private FrameLayout q;
    private ArrayList r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Message w;
    public String webviewUserAgent;
    private Message x;
    private Activity y;
    private WebViewClient z;

    public IMWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        doNotFireVisibilityChanged = new AtomicBoolean(false);
        f = false;
        k = ViewState.LOADING;
        o = null;
        s = false;
        mIsInterstitialAd = false;
        isTablet = false;
        mOriginalWebviewForExpandUrl = null;
        mWebViewIsBrowserActivity = false;
        t = false;
        u = false;
        mutex = new Object();
        mutexcPos = new Object();
        mutexdPos = new Object();
        isMutexAquired = new AtomicBoolean(false);
        acqMutexcPos = new AtomicBoolean(true);
        acqMutexdPos = new AtomicBoolean(true);
        B = new ArrayList();
        C = new AtomicBoolean();
        F = false;
        mIsViewable = false;
        a = -1D;
        b = new AtomicBoolean(false);
        K = true;
        c = null;
        y = (Activity)context;
        b();
        getContext().obtainStyledAttributes(attributeset, d).recycle();
    }

    public IMWebView(Context context, IMWebViewListener imwebviewlistener)
    {
        super(context);
        doNotFireVisibilityChanged = new AtomicBoolean(false);
        f = false;
        k = ViewState.LOADING;
        o = null;
        s = false;
        mIsInterstitialAd = false;
        isTablet = false;
        mOriginalWebviewForExpandUrl = null;
        mWebViewIsBrowserActivity = false;
        t = false;
        u = false;
        mutex = new Object();
        mutexcPos = new Object();
        mutexdPos = new Object();
        isMutexAquired = new AtomicBoolean(false);
        acqMutexcPos = new AtomicBoolean(true);
        acqMutexdPos = new AtomicBoolean(true);
        B = new ArrayList();
        C = new AtomicBoolean();
        F = false;
        mIsViewable = false;
        a = -1D;
        b = new AtomicBoolean(false);
        K = true;
        c = null;
        mListener = imwebviewlistener;
        y = (Activity)context;
        b();
    }

    public IMWebView(Context context, IMWebViewListener imwebviewlistener, boolean flag, boolean flag1)
    {
        super(context);
        doNotFireVisibilityChanged = new AtomicBoolean(false);
        f = false;
        k = ViewState.LOADING;
        o = null;
        s = false;
        mIsInterstitialAd = false;
        isTablet = false;
        mOriginalWebviewForExpandUrl = null;
        mWebViewIsBrowserActivity = false;
        t = false;
        u = false;
        mutex = new Object();
        mutexcPos = new Object();
        mutexdPos = new Object();
        isMutexAquired = new AtomicBoolean(false);
        acqMutexcPos = new AtomicBoolean(true);
        acqMutexdPos = new AtomicBoolean(true);
        B = new ArrayList();
        C = new AtomicBoolean();
        F = false;
        mIsViewable = false;
        a = -1D;
        b = new AtomicBoolean(false);
        K = true;
        c = null;
        y = (Activity)context;
        mIsInterstitialAd = flag;
        mWebViewIsBrowserActivity = flag1;
        if (mIsInterstitialAd)
        {
            setId(117);
        }
        mListener = imwebviewlistener;
        b();
    }

    private int a(Activity activity)
    {
        Iterator iterator = activity.getPackageManager().queryIntentActivities(new Intent(activity, activity.getClass()), 0x10000).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
        if (!resolveinfo.activityInfo.name.contentEquals(activity.getClass().getName())) goto _L4; else goto _L3
_L3:
        activity = resolveinfo;
_L6:
        return ((ResolveInfo) (activity)).activityInfo.configChanges;
_L2:
        activity = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static Message a(IMWebView imwebview, Message message)
    {
        imwebview.w = message;
        return message;
    }

    static View a(IMWebView imwebview, View view)
    {
        imwebview.n = view;
        return view;
    }

    static android.webkit.WebChromeClient.CustomViewCallback a(IMWebView imwebview, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        imwebview.o = customviewcallback;
        return customviewcallback;
    }

    static WebViewClient a(IMWebView imwebview)
    {
        return imwebview.z;
    }

    static FrameLayout a(IMWebView imwebview, FrameLayout framelayout)
    {
        imwebview.q = framelayout;
        return framelayout;
    }

    static VideoView a(IMWebView imwebview, VideoView videoview)
    {
        imwebview.m = videoview;
        return videoview;
    }

    static ArrayList a(IMWebView imwebview, ArrayList arraylist)
    {
        imwebview.r = arraylist;
        return arraylist;
    }

    private void a(int i1, int j1)
    {
        injectJavaScript((new StringBuilder()).append("window.mraid.broadcastEvent('sizeChange',").append(i1).append(",").append(j1).append(");").toString());
    }

    private void a(View view, android.view.View.OnKeyListener onkeylistener)
    {
        view.setOnKeyListener(onkeylistener);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int i1 = 0;
            for (int j1 = view.getChildCount(); i1 < j1; i1++)
            {
                a(view.getChildAt(i1), onkeylistener);
            }

        }
    }

    private void a(View view, android.view.View.OnTouchListener ontouchlistener)
    {
        view.setOnTouchListener(ontouchlistener);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            int i1 = 0;
            for (int j1 = view.getChildCount(); i1 < j1; i1++)
            {
                a(view.getChildAt(i1), ontouchlistener);
            }

        }
    }

    private void a(SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(y);
        builder.setPositiveButton("Continue", new android.content.DialogInterface.OnClickListener(sslerrorhandler) {

            final SslErrorHandler a;
            final IMWebView b;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.cancel();
                a.proceed();
            }

            
            {
                b = IMWebView.this;
                a = sslerrorhandler;
                super();
            }
        });
        builder.setNegativeButton("Go Back", new android.content.DialogInterface.OnClickListener(sslerrorhandler) {

            final SslErrorHandler a;
            final IMWebView b;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.cancel();
                a.cancel();
            }

            
            {
                b = IMWebView.this;
                a = sslerrorhandler;
                super();
            }
        });
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            builder.setNeutralButton("Open Browser", new android.content.DialogInterface.OnClickListener(sslerror) {

                final SslError a;
                final IMWebView b;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.cancel();
                    IMWebView.a(b, WrapperFunctions.getSSLErrorUrl(a));
                }

            
            {
                b = IMWebView.this;
                a = sslerror;
                super();
            }
            });
        }
        builder.setTitle("Security Warning");
        builder.setMessage("There are problems with the security certificate for this site.");
        sslerrorhandler = builder.create();
        try
        {
            sslerrorhandler.show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SslErrorHandler sslerrorhandler)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Dialog could not be shown due to an exception.", sslerrorhandler);
        }
    }

    static void a(IMWebView imwebview, View view, android.view.View.OnKeyListener onkeylistener)
    {
        imwebview.a(view, onkeylistener);
    }

    static void a(IMWebView imwebview, View view, android.view.View.OnTouchListener ontouchlistener)
    {
        imwebview.a(view, ontouchlistener);
    }

    static void a(IMWebView imwebview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        imwebview.a(sslerrorhandler, sslerror);
    }

    static void a(IMWebView imwebview, String s1)
    {
        imwebview.c(s1);
    }

    private void a(String s1)
    {
        super.loadUrl(s1);
    }

    private void a(boolean flag)
    {
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Viewable:").append(flag).toString());
        injectJavaScript((new StringBuilder()).append("window.mraid.broadcastEvent('viewableChange',").append(isViewable()).append(");").toString());
    }

    static boolean a(IMWebView imwebview, boolean flag)
    {
        imwebview.F = flag;
        return flag;
    }

    static ViewState b(IMWebView imwebview)
    {
        return imwebview.k;
    }

    private void b()
    {
        b = new AtomicBoolean(false);
        userInitiatedClose = false;
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        webviewUserAgent = getSettings().getUserAgentString();
        InternalSDKUtil.getUserAgent();
        setBackgroundColor(Initializer.getConfigParams().getWebviewBgColor());
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        h = y.getResources().getDisplayMetrics().density;
        e = false;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setGeolocationEnabled(true);
        g = new JSUtilityController(this, getContext());
        addJavascriptInterface(g, "utilityController");
        setWebViewClient(H);
        setWebChromeClient(I);
        mExpandController = new MRAIDExpandController(this, y);
        mResizeController = new MRAIDResizeController(this, y);
        mMraidBasic = new MRAIDBasic(this, y);
        mInterstitialController = new MRAIDInterstitialController(this, y);
        mAudioVideoController = new MRAIDAudioVideoController(this);
        A = new c(this, mMraidBasic, mExpandController, mInterstitialController, mAudioVideoController, mResizeController);
        mExpandController.mSensorDisplay = ((WindowManager)y.getSystemService("window")).getDefaultDisplay();
        mAudioVideoController.videoValidateWidth = y.getResources().getDisplayMetrics().widthPixels;
        try
        {
            addJavascriptInterface(G.getDeclaredConstructor(new Class[] {
                com/inmobi/re/container/IMWebView
            }).newInstance(new Object[] {
                this
            }), "imaiController");
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Error adding js interface imai controller");
        }
        g.setWebViewClosed(false);
    }

    private void b(String s1)
    {
        evaluateJavascript(s1, null);
    }

    static boolean b(IMWebView imwebview, boolean flag)
    {
        imwebview.f = flag;
        return flag;
    }

    static AtomicBoolean c(IMWebView imwebview)
    {
        return imwebview.C;
    }

    private void c()
    {
        Log.debug("[InMobi]-[RE]-4.5.5", "IMWebView-> initStates");
        k = ViewState.LOADING;
        C.set(false);
    }

    private void c(String s1)
    {
        s1 = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        s1.addFlags(0x10000000);
        y.startActivity(s1);
        fireOnLeaveApplication();
    }

    private void d()
    {
        if (n == null)
        {
            return;
        }
        if (o != null)
        {
            o.onCustomViewHidden();
        }
        o = null;
        if (n != null && n.getParent() != null)
        {
            ((ViewGroup)n.getParent()).removeView(n);
        }
        n = null;
    }

    static boolean d(IMWebView imwebview)
    {
        return imwebview.f;
    }

    static ArrayList e(IMWebView imwebview)
    {
        return imwebview.B;
    }

    private boolean e()
    {
        return b.get();
    }

    static Message f(IMWebView imwebview)
    {
        return imwebview.w;
    }

    static Message g(IMWebView imwebview)
    {
        return imwebview.x;
    }

    static View h(IMWebView imwebview)
    {
        return imwebview.n;
    }

    static Activity i(IMWebView imwebview)
    {
        return imwebview.y;
    }

    static FrameLayout j(IMWebView imwebview)
    {
        return imwebview.q;
    }

    static VideoView k(IMWebView imwebview)
    {
        return imwebview.m;
    }

    static android.media.MediaPlayer.OnCompletionListener l(IMWebView imwebview)
    {
        return imwebview.J;
    }

    static void m(IMWebView imwebview)
    {
        imwebview.d();
    }

    static JSUtilityController n(IMWebView imwebview)
    {
        return imwebview.g;
    }

    static ViewGroup o(IMWebView imwebview)
    {
        return imwebview.p;
    }

    static void p(IMWebView imwebview)
    {
        imwebview.WebView.destroy();
    }

    static ArrayList q(IMWebView imwebview)
    {
        return imwebview.r;
    }

    public static void setIMAIController(Class class1)
    {
        G = class1;
    }

    void a()
    {
        if (r == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        if (i1 >= r.size()) goto _L4; else goto _L3
_L3:
        a a1 = (a)r.get(i1);
        if (a1.getStatus() == android.os.AsyncTask.Status.RUNNING)
        {
            a1.cancel(true);
        }
          goto _L5
_L4:
        r.clear();
        r = null;
_L2:
        InternalSDKUtil.clearSdkCacheDirectory(InternalSDKUtil.getSdkCacheDirectory(y), String.valueOf(hashCode()));
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.5.5", "Exception deleting saved content dirs and stopping download task");
        return;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void addJavascriptObject(Object obj, String s1)
    {
        addJavascriptInterface(obj, s1);
    }

    public void broadcastEventIMraid(String s1, Object obj)
    {
        try
        {
            y.runOnUiThread(new Runnable(obj, s1) {

                final Object a;
                final String b;
                final IMWebView c;

                public void run()
                {
                    if (a != null)
                    {
                        c.injectJavaScript((new StringBuilder()).append("window.imraid.broadcastEvent('").append(b).append("',").append(a).append(");").toString());
                        return;
                    } else
                    {
                        c.injectJavaScript((new StringBuilder()).append("window.imraid.broadcastEvent('").append(b).append("');").toString());
                        return;
                    }
                }

            
            {
                c = IMWebView.this;
                a = obj;
                b = s1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception broadcasting events", s1);
        }
    }

    public void broadcastEventIMraid(String s1, String s2)
    {
        try
        {
            y.runOnUiThread(new Runnable(s2, s1) {

                final String a;
                final String b;
                final IMWebView c;

                public void run()
                {
                    if (a != null)
                    {
                        c.injectJavaScript((new StringBuilder()).append("window.imraid.broadcastEvent('").append(b).append("','").append(a).append("');").toString());
                        return;
                    } else
                    {
                        c.injectJavaScript((new StringBuilder()).append("window.imraid.broadcastEvent('").append(b).append("');").toString());
                        return;
                    }
                }

            
            {
                c = IMWebView.this;
                a = s1;
                b = s2;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception broadcasting events", s1);
        }
    }

    public void cancelLoad()
    {
        C.set(true);
    }

    public void cancelSaveContent(String s1)
    {
        if (r == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        if (i1 >= r.size()) goto _L2; else goto _L3
_L3:
        a a1 = (a)r.get(i1);
        if (!a1.a().equals(s1) || a1.getStatus() != android.os.AsyncTask.Status.RUNNING) goto _L5; else goto _L4
_L4:
        a1.cancel(true);
_L2:
        return;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void close()
    {
        try
        {
            g.setWebViewClosed(true);
            if (!A.hasMessages(1001))
            {
                A.sendEmptyMessage(1001);
            }
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception closing webview. Webview not initialized properly", exception);
        }
    }

    public void closeExpanded()
    {
        A.sendEmptyMessage(1005);
    }

    protected void closeOpened(View view)
    {
        ((ViewGroup)((Activity)getContext()).getWindow().getDecorView()).removeView(view);
        requestLayout();
    }

    public void closeResized()
    {
        A.sendEmptyMessage(1031);
    }

    public void closeVideo(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getVideoPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "closeVideo");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "closeVideo");
            return;
        } else
        {
            mAudioVideoController.videoPlayerList.remove(s1);
            s1 = A.obtainMessage(1012);
            s1.obj = avplayer;
            A.sendMessage(s1);
            return;
        }
    }

    public void deinit()
    {
        if (getStateVariable() == ViewState.EXPANDED || getStateVariable() == ViewState.EXPANDING)
        {
            close();
        }
    }

    public void destroy()
    {
        Log.debug("[InMobi]-[RE]-4.5.5", "IMWebView: Destroy called.");
        close();
        postInHandler(new Runnable() {

            final IMWebView a;

            public void run()
            {
                a.b.set(true);
                a.removeAllViews();
                ViewGroup viewgroup = (ViewGroup)a.getParent();
                if (viewgroup != null)
                {
                    viewgroup.removeView(a);
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    a.removeJavascriptInterface("utilityController");
                    a.removeJavascriptInterface("displayController");
                    a.removeJavascriptInterface("imaiController");
                }
                a.a();
                IMWebView.p(a);
            }

            
            {
                a = IMWebView.this;
                super();
            }
        });
    }

    public void disableCloseRegion()
    {
        CustomView customview = (CustomView)((ViewGroup)getRootView()).findViewById(226);
        if (customview != null)
        {
            customview.disableView(u);
        }
    }

    public void disableHardwareAcceleration()
    {
        K = false;
        Log.internal("[InMobi]-[RE]-4.5.5", "disableHardwareAcceleration called.");
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            WrapperFunctions.disableHardwareAccl(this);
            mExpandController.disableEnableHardwareAccelerationForExpandWithURLView();
        }
    }

    public void doHidePlayers()
    {
        A.sendEmptyMessage(1023);
    }

    public void expand(String s1, com.inmobi.re.controller.JSController.ExpandProperties expandproperties)
    {
        setState(ViewState.EXPANDING);
        mExpandController.mIsExpandUrlValid = false;
        isMutexAquired.set(true);
        Message message = A.obtainMessage(1004);
        Bundle bundle = new Bundle();
        bundle.putString("expand_url", s1);
        message.setData(bundle);
        mExpandController.expandProperties = expandproperties;
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Dimensions: {").append(mExpandController.expandProperties.x).append(" ,").append(mExpandController.expandProperties.y).append(" ,").append(mExpandController.expandProperties.width).append(" ,").append(mExpandController.expandProperties.height).append("}").toString());
        mExpandController.tempExpPropsLock = mExpandController.expandProperties.lockOrientation;
        A.sendMessage(message);
    }

    public void fireOnDismissAdScreen()
    {
        if (mListener != null)
        {
            mListener.onDismissAdScreen();
        }
    }

    public void fireOnLeaveApplication()
    {
        if (mListener != null)
        {
            mListener.onLeaveApplication();
        }
    }

    public void fireOnShowAdScreen()
    {
        if (mListener != null && getStateVariable() == ViewState.DEFAULT && !mIsInterstitialAd)
        {
            IMBrowserActivity.requestOnAdDismiss(A.obtainMessage(1028));
            mListener.onShowAdScreen();
        }
    }

    public Activity getActivity()
    {
        return y;
    }

    public int getAudioVolume(String s1)
    {
        s1 = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "getAudioVolume");
            return -1;
        } else
        {
            return s1.getVolume();
        }
    }

    public String getCurrentRotation(int i1)
    {
        switch (i1)
        {
        default:
            return "-1";

        case 0: // '\0'
            return "0";

        case 1: // '\001'
            return "90";

        case 2: // '\002'
            return "180";

        case 3: // '\003'
            return "270";
        }
    }

    public boolean getCustomClose()
    {
        return t;
    }

    public float getDensity()
    {
        return h;
    }

    public boolean getDisableCloseRegion()
    {
        return u;
    }

    public int getDismissMessage()
    {
        return 1028;
    }

    public Activity getExpandedActivity()
    {
        return y;
    }

    public int getIntegerCurrentRotation()
    {
        int i1 = DeviceInfo.getDisplayRotation(((WindowManager)y.getSystemService("window")).getDefaultDisplay());
        int j1 = i1;
        if (DeviceInfo.isDefOrientationLandscape(i1, y.getResources().getDisplayMetrics().widthPixels, y.getResources().getDisplayMetrics().heightPixels))
        {
            j1 = i1 + 1;
            i1 = j1;
            if (j1 > 3)
            {
                i1 = 0;
            }
            j1 = i1;
            if (DeviceInfo.isTablet(y.getApplicationContext()))
            {
                isTablet = true;
                j1 = i1;
            }
        }
        return j1;
    }

    public double getLastGoodKnownMicValue()
    {
        return a;
    }

    public ArrayList getMRAIDUrls()
    {
        return B;
    }

    public int getOriginalIndex()
    {
        return E;
    }

    public ViewParent getOriginalParent()
    {
        if (D == null)
        {
            saveOriginalViewParent();
        }
        return D;
    }

    public String getPlacementType()
    {
        if (mIsInterstitialAd)
        {
            return "interstitial";
        } else
        {
            return "inline";
        }
    }

    public IMWebViewPlayableListener getPlayableListener()
    {
        return l;
    }

    public String getSize()
    {
        return (new StringBuilder()).append("{ width: ").append((int)((float)getWidth() / h)).append(", ").append("height: ").append((int)((float)getHeight() / h)).append("}").toString();
    }

    public String getState()
    {
        return k.toString().toLowerCase(Locale.ENGLISH);
    }

    public ViewState getStateVariable()
    {
        return k;
    }

    public int getVideoVolume(String s1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "getVideoVolume");
            return -1;
        } else
        {
            return s1.getVolume();
        }
    }

    public ViewState getViewState()
    {
        return k;
    }

    public Handler getWebviewHandler()
    {
        return A;
    }

    public void hide()
    {
        A.sendEmptyMessage(1002);
    }

    public void hideVideo(String s1)
    {
        Message message = A.obtainMessage(1013);
        Bundle bundle = new Bundle();
        bundle.putString("pid", s1);
        message.setData(bundle);
        A.sendMessage(message);
    }

    public void incentCompleted(HashMap hashmap)
    {
        Message message = A.obtainMessage(1034);
        Bundle bundle = new Bundle();
        bundle.putSerializable("incent_ad_map", hashmap);
        message.setData(bundle);
        message.sendToTarget();
    }

    public void injectJavaScript(String s1)
    {
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s1 = (new StringBuilder()).append("javascript:try{").append(s1).append("}catch(e){}").toString();
        if (s1.length() < 400)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Injecting JavaScript: ").append(s1).toString());
        }
        if (e())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            a(s1);
            return;
        }
        try
        {
            b(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Error injecting javascript ", s1);
        }
    }

    public boolean isAudioMuted(String s1)
    {
        s1 = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "isAudioMuted");
            return false;
        } else
        {
            return s1.isMediaMuted();
        }
    }

    public boolean isBusy()
    {
        return s;
    }

    public boolean isConfigChangesListed(Activity activity)
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        int j1 = a(activity);
        boolean flag;
        if ((j1 & 0x10) == 0 || (j1 & 0x20) == 0 || (j1 & 0x80) == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (i1 >= 13 && ((j1 & 0x400) == 0 || (j1 & 0x800) == 0))
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        return flag && i1;
    }

    public boolean isEnabledHardwareAcceleration()
    {
        return K;
    }

    public boolean isExpanded()
    {
        return k == ViewState.EXPANDED;
    }

    public boolean isLandscapeSyncOrientation(int i1)
    {
        return i1 == 1 || i1 == 3;
    }

    public boolean isModal()
    {
        return mIsInterstitialAd || k == ViewState.EXPANDED;
    }

    public boolean isPageFinished()
    {
        return e;
    }

    public boolean isPortraitSyncOrientation(int i1)
    {
        return i1 == 0 || i1 == 2;
    }

    public boolean isVideoMuted(String s1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "isVideoMuted");
            return false;
        } else
        {
            return s1.isMediaMuted();
        }
    }

    public boolean isViewable()
    {
        return mIsViewable;
    }

    public void loadData(String s1, String s2, String s3)
    {
        f = false;
        super.loadData(s1, s2, s3);
    }

    public void loadDataWithBaseURL(String s1, String s2, String s3, String s4, String s5)
    {
        f = false;
        if (k == ViewState.EXPANDED)
        {
            return;
        } else
        {
            c();
            super.loadDataWithBaseURL(s1, s2, s3, s4, s5);
            return;
        }
    }

    public void loadUrl(String s1)
    {
        f = false;
        if (k == ViewState.EXPANDED)
        {
            return;
        } else
        {
            c();
            super.loadUrl(s1);
            return;
        }
    }

    public void lockExpandOrientation(Activity activity, boolean flag, String s1)
    {
        int i1;
        try
        {
            if (!isConfigChangesListed(activity))
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Exception handling the orientation ", activity);
            return;
        }
        i1 = activity.getRequestedOrientation();
        if (i1 == 0 || i1 == 1)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        if (android.os.Build.VERSION.SDK_INT >= 9 && (i1 == 8 || i1 == 9 || i1 == 6 || i1 == 7))
        {
            break MISSING_BLOCK_LABEL_236;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        i1 = getIntegerCurrentRotation();
        mExpandController.initialExpandOrientation = activity.getRequestedOrientation();
        if (s1.equalsIgnoreCase("portrait"))
        {
            mExpandController.useLockOrient = true;
            activity.setRequestedOrientation(WrapperFunctions.getParamPortraitOrientation(i1));
            return;
        }
        if (s1.equalsIgnoreCase("landscape"))
        {
            mExpandController.useLockOrient = true;
            activity.setRequestedOrientation(WrapperFunctions.getParamLandscapeOrientation(i1));
            return;
        }
        mExpandController.useLockOrient = true;
        if (activity.getResources().getConfiguration().orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "In allowFalse, none mode dev orientation:ORIENTATION_LANDSCAPE");
            activity.setRequestedOrientation(0);
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.5", "In allowFalse, none mode dev orientation:ORIENTATION_PORTRAIT");
        activity.setRequestedOrientation(1);
        return;
        if (activity.getResources().getConfiguration().orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "In allow true,  device orientation:ORIENTATION_LANDSCAPE");
            return;
        }
        Log.internal("[InMobi]-[RE]-4.5.5", "In allow true,  device orientation:ORIENTATION_PORTRAIT");
    }

    public void mediaPlayerReleased(AVPlayer avplayer)
    {
        mAudioVideoController.mediaPlayerReleased(avplayer);
    }

    public void muteAudio(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "muteAudio");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "muteAudio");
            return;
        } else
        {
            Message message = A.obtainMessage(1019);
            Bundle bundle = new Bundle();
            bundle.putString("aplayerref", s1);
            message.setData(bundle);
            message.sendToTarget();
            return;
        }
    }

    public void muteVideo(String s1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "muteVideo");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
        {
            raiseError("Invalid player state", "muteVideo");
            return;
        } else
        {
            Message message = A.obtainMessage(1015);
            message.obj = s1;
            A.sendMessage(message);
            return;
        }
    }

    protected void onAttachedToWindow()
    {
        Log.debug("[InMobi]-[RE]-4.5.5", "IMWebView-> onAttachedToWindow");
        saveOriginalViewParent();
        if (!v)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            i = layoutparams.height;
            j = layoutparams.width;
            v = true;
        }
        g.registerBroadcastListener();
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow()
    {
        Log.debug("[InMobi]-[RE]-4.5.5", "IMWebView-> onDetatchedFromWindow");
        g.stopAllListeners();
        B.clear();
        g.unRegisterBroadcastListener();
        if (mIsInterstitialAd && !mWebViewIsBrowserActivity)
        {
            mInterstitialController.handleInterstitialClose();
        }
        super.onDetachedFromWindow();
    }

    protected void onIMWebviewVisibilityChanged(boolean flag)
    {
        if (mIsViewable != flag)
        {
            mIsViewable = flag;
            if (!doNotFireVisibilityChanged.get())
            {
                a(flag);
                return;
            }
        }
    }

    public void onOrientationEventChange()
    {
        A.sendEmptyMessage(1027);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != 0 && j1 != 0)
        {
            if (!F)
            {
                a((int)((float)i1 / getDensity()), (int)((float)j1 / getDensity()));
            }
            F = false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        requestFocus();
        return super.onTouchEvent(motionevent);
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
        boolean flag;
        if (i1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        onIMWebviewVisibilityChanged(flag);
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (g.supports("vibrate"))
        {
            ((Vibrator)y.getSystemService("vibrator")).cancel();
        }
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.5.5", "Failed to cancel existing vibration", exception);
        return;
    }

    public void openExternal(String s1)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s1));
        intent.addFlags(0x10000000);
        try
        {
            getContext().startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            raiseError("Request must specify a valid URL", "openExternal");
            return;
        }
        if (mListener != null)
        {
            mListener.onLeaveApplication();
        }
    }

    public void openURL(String s1)
    {
        if (!isViewable())
        {
            raiseError("Cannot open URL.Ad is not viewable yet", "openURL");
            return;
        } else
        {
            Message message = A.obtainMessage(1024);
            Bundle bundle = new Bundle();
            bundle.putString("expand_url", s1);
            message.setData(bundle);
            A.sendMessage(message);
            return;
        }
    }

    public void pageFinishedCallbackForAdCreativeTesting(Message message)
    {
        x = message;
    }

    public void pauseAudio(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "pauseAudio");
        } else
        {
            if (avplayer.getState() != com.inmobi.re.controller.util.AVPlayer.playerState.PLAYING)
            {
                if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT && !avplayer.isPrepared())
                {
                    avplayer.setAutoPlay(false);
                    return;
                } else
                {
                    raiseError("Invalid player state", "pauseAudio");
                    return;
                }
            }
            if (avplayer.isPlaying())
            {
                Message message = A.obtainMessage(1010);
                Bundle bundle = new Bundle();
                bundle.putString("aplayerref", s1);
                message.setData(bundle);
                message.sendToTarget();
                return;
            }
        }
    }

    public void pauseVideo(String s1)
    {
        Message message = A.obtainMessage(1011);
        Bundle bundle = new Bundle();
        bundle.putString("pid", s1);
        message.setData(bundle);
        A.sendMessage(message);
    }

    public void playAudio(String s1, boolean flag, boolean flag1, boolean flag2, String s2, String s3, String s4)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag3 = isMutexAquired.get();
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mutex.wait();
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (!mIsInterstitialAd && k != ViewState.EXPANDED)
        {
            raiseError("Cannot play audio.Ad is not in an expanded state", "playAudio");
            return;
        }
        break MISSING_BLOCK_LABEL_84;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.debug("[InMobi]-[RE]-4.5.5", "mutex failed ", interruptedexception);
          goto _L1
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
        if (!isViewable())
        {
            raiseError("Cannot play audio.Ad is not viewable yet", "playAudio");
            return;
        } else
        {
            com.inmobi.re.controller.JSController.PlayerProperties playerproperties = new com.inmobi.re.controller.JSController.PlayerProperties();
            playerproperties.setProperties(false, flag, flag1, flag2, s2, s3, s4);
            s2 = new Bundle();
            s2.putString("expand_url", s1);
            s2.putParcelable("player_properties", playerproperties);
            s1 = A.obtainMessage(1007);
            s1.setData(s2);
            A.sendMessage(s1);
            return;
        }
    }

    public void playVideo(String s1, boolean flag, boolean flag1, boolean flag2, boolean flag3, com.inmobi.re.controller.JSController.Dimensions dimensions, String s2, 
            String s3, String s4)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag4 = isMutexAquired.get();
        if (!flag4)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mutex.wait();
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (!mIsInterstitialAd && k != ViewState.EXPANDED)
        {
            raiseError("Cannot play video.Ad is not in an expanded state", "playVideo");
            return;
        }
        break MISSING_BLOCK_LABEL_84;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.debug("[InMobi]-[RE]-4.5.5", "mutex failed ", interruptedexception);
          goto _L1
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
        if (!isViewable())
        {
            raiseError("Cannot play video.Ad is not viewable yet", "playVideo");
            return;
        }
        if (!mAudioVideoController.videoPlayerList.isEmpty() && mAudioVideoController.videoPlayerList.size() >= 5 && !mAudioVideoController.videoPlayerList.containsKey(s4))
        {
            raiseError("Player Error. Exceeding permissible limit for saved play instances", "playVideo");
            return;
        } else
        {
            Message message = A.obtainMessage(1006);
            com.inmobi.re.controller.JSController.PlayerProperties playerproperties = new com.inmobi.re.controller.JSController.PlayerProperties();
            playerproperties.setProperties(flag, flag1, flag2, flag3, s2, s3, s4);
            s2 = new Bundle();
            s2.putString("expand_url", s1);
            s2.putParcelable("player_properties", playerproperties);
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Before validation dimension: (").append(dimensions.x).append(", ").append(dimensions.y).append(", ").append(dimensions.width).append(", ").append(dimensions.height).append(")").toString());
            mAudioVideoController.validateVideoDimensions(dimensions);
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("After validation dimension: (").append(dimensions.x).append(", ").append(dimensions.y).append(", ").append(dimensions.width).append(", ").append(dimensions.height).append(")").toString());
            s2.putParcelable("expand_dimensions", dimensions);
            message.setData(s2);
            A.sendMessage(message);
            return;
        }
    }

    public void postInHandler(Runnable runnable)
    {
        A.post(runnable);
    }

    public void postInjectJavaScript(String s1)
    {
        if (s1 != null)
        {
            Message message = A.obtainMessage(1025);
            Bundle bundle = new Bundle();
            bundle.putString("injectMessage", s1);
            message.setData(bundle);
            message.sendToTarget();
        }
    }

    public void raiseCameraPictureCapturedEvent(String s1, int i1, int j1)
    {
        s1 = (new StringBuilder()).append("window.mraidview.fireCameraPictureCatpturedEvent('").append(s1).append("'").append(",").append("'").append(i1).append("','").append(j1).append("')").toString();
        if (y != null)
        {
            y.runOnUiThread(new Runnable(s1) {

                final String a;
                final IMWebView b;

                public void run()
                {
                    b.injectJavaScript(a);
                }

            
            {
                b = IMWebView.this;
                a = s1;
                super();
            }
            });
        }
    }

    public void raiseError(String s1, String s2)
    {
        Message message = A.obtainMessage(1008);
        Bundle bundle = new Bundle();
        bundle.putString("message", s1);
        bundle.putString("action", s2);
        message.setData(bundle);
        A.sendMessage(message);
    }

    public void raiseGalleryImageSelectedEvent(String s1, int i1, int j1)
    {
        s1 = (new StringBuilder()).append("window.mraidview.fireGalleryImageSelectedEvent('").append(s1).append("'").append(",").append("'").append(i1).append("','").append(j1).append("')").toString();
        if (y != null)
        {
            y.runOnUiThread(new Runnable(s1) {

                final String a;
                final IMWebView b;

                public void run()
                {
                    b.injectJavaScript(a);
                }

            
            {
                b = IMWebView.this;
                a = s1;
                super();
            }
            });
        }
    }

    public void raiseMicEvent(double d1)
    {
        a = d1;
        String s1 = (new StringBuilder()).append("window.mraid.broadcastEvent('micIntensityChange',").append(d1).append(")").toString();
        if (y != null)
        {
            y.runOnUiThread(new Runnable(s1) {

                final String a;
                final IMWebView b;

                public void run()
                {
                    b.injectJavaScript(a);
                }

            
            {
                b = IMWebView.this;
                a = s1;
                super();
            }
            });
        }
    }

    public void raiseVibrateCompleteEvent()
    {
        if (y != null)
        {
            y.runOnUiThread(new Runnable() {

                final IMWebView a;

                public void run()
                {
                    try
                    {
                        a.injectJavaScript("window.mraid.broadcastEvent('vibrateComplete')");
                        return;
                    }
                    catch (Exception exception)
                    {
                        Log.internal("[InMobi]-[RE]-4.5.5", "Exception giviing vibration complete callback", exception);
                    }
                }

            
            {
                a = IMWebView.this;
                super();
            }
            });
        }
    }

    public void requestOnInterstitialClosed(Message message)
    {
        mInterstitialController.mMsgOnInterstitialClosed = message;
    }

    public void requestOnInterstitialShown(Message message)
    {
        mInterstitialController.mMsgOnInterstitialShown = message;
    }

    public void resetLayout()
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        if (v)
        {
            layoutparams.height = i;
            layoutparams.width = j;
        }
        setVisibility(0);
        requestLayout();
    }

    public void resetMraid()
    {
        mExpandController.reset();
        mResizeController.reset();
        g.reset();
    }

    public void resize(com.inmobi.re.controller.JSController.ResizeProperties resizeproperties)
    {
        setState(ViewState.RESIZING);
        isMutexAquired.set(true);
        Message message = A.obtainMessage(1030);
        mResizeController.resizeProperties = resizeproperties;
        A.sendMessage(message);
    }

    public void saveFile(String s1, String s2)
    {
        Object obj = new File(InternalSDKUtil.getSdkCacheDirectory(y), String.valueOf(hashCode()));
        if (!((File) (obj)).mkdirs() && !((File) (obj)).isDirectory())
        {
            Log.debug(com/inmobi/re/container/IMWebView.getSimpleName(), "Cannot create temp directory to save ");
            obj = new JSONObject();
            try
            {
                ((JSONObject) (obj)).put("url", s2);
                ((JSONObject) (obj)).put("reason", b.j.ordinal());
            }
            // Misplaced declaration of an exception variable
            catch (String s2)
            {
                s2.printStackTrace();
            }
            s2 = ((JSONObject) (obj)).toString().replace("\"", "\\\"");
            y.runOnUiThread(new Runnable(s1, s2) {

                final String a;
                final String b;
                final IMWebView c;

                public void run()
                {
                    String s3 = (new StringBuilder()).append("sendSaveContentResult(\"saveContent_").append(a).append("\", 'failure', \"").append(b).append("\");").toString();
                    c.injectJavaScript(s3);
                    if (c.c != null)
                    {
                        c.c.postFailed(b.j.ordinal());
                    }
                }

            
            {
                c = IMWebView.this;
                a = s1;
                b = s2;
                super();
            }
            });
            return;
        } else
        {
            (new a(new File(((File) (obj)), UUID.randomUUID().toString()), s1, s2)).execute(new Void[0]);
            return;
        }
    }

    public void saveOriginalViewParent()
    {
        if (D == null)
        {
            D = getParent();
            if (D != null)
            {
                int j1 = ((ViewGroup)D).getChildCount();
                int i1 = 0;
                do
                {
                    if (i1 >= j1 || ((ViewGroup)D).getChildAt(i1) == this)
                    {
                        E = i1;
                        return;
                    }
                    i1++;
                } while (true);
            }
        }
    }

    public void seekAudio(String s1, int i1)
    {
        s1 = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "seekAudio");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "seekAudio");
            return;
        } else
        {
            Message message = A.obtainMessage(1022);
            Bundle bundle = new Bundle();
            bundle.putInt("seekaudio", i1);
            message.setData(bundle);
            message.obj = s1;
            message.sendToTarget();
            return;
        }
    }

    public void seekVideo(String s1, int i1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "seekVideo");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
        {
            raiseError("Invalid player state", "seekVideo");
            return;
        } else
        {
            Message message = A.obtainMessage(1018);
            Bundle bundle = new Bundle();
            bundle.putInt("seek", i1);
            message.setData(bundle);
            message.obj = s1;
            A.sendMessage(message);
            return;
        }
    }

    public void sendToCPHandler()
    {
        A.sendEmptyMessage(1029);
    }

    public void sendToDPHandler()
    {
        A.sendEmptyMessage(1032);
    }

    public void sendasyncPing(String s1)
    {
        g.asyncPing(s1);
    }

    public void setActivity(Activity activity)
    {
        y = activity;
    }

    public void setAudioVolume(String s1, int i1)
    {
        if (mAudioVideoController.getCurrentAudioPlayer(s1) == null)
        {
            raiseError("Invalid property ID", "setAudioVolume");
            return;
        } else
        {
            Message message = A.obtainMessage(1021);
            Bundle bundle = new Bundle();
            bundle.putInt("vol", i1);
            bundle.putString("aplayerref", s1);
            message.setData(bundle);
            message.sendToTarget();
            return;
        }
    }

    public void setBrowserActivity(Activity activity)
    {
        if (activity != null)
        {
            y = (IMBrowserActivity)activity;
        }
    }

    public void setBusy(boolean flag)
    {
        s = flag;
    }

    public void setCallBack(InstantVideoCallbackCallback instantvideocallbackcallback)
    {
        c = instantvideocallbackcallback;
    }

    public void setCloseButton()
    {
        CustomView customview;
        byte byte0;
        try
        {
            customview = (CustomView)((ViewGroup)getRootView()).findViewById(225);
        }
        catch (Exception exception)
        {
            return;
        }
        if (customview == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        if (getCustomClose())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        customview.setVisibility(byte0);
    }

    public void setCustomClose(boolean flag)
    {
        t = flag;
        Message message = A.obtainMessage(1009);
        A.sendMessage(message);
    }

    public void setDisableCloseRegion(boolean flag)
    {
        u = flag;
        Message message = A.obtainMessage(1035);
        A.sendMessage(message);
    }

    public void setExpandPropertiesForInterstitial(boolean flag, boolean flag1, String s1)
    {
        setCustomClose(flag);
        mInterstitialController.orientationValueForInterstitial = s1;
        mInterstitialController.lockOrientationValueForInterstitial = flag1;
        if (mWebViewIsBrowserActivity)
        {
            mExpandController.handleOrientationFor2Piece();
        }
        if (isViewable() && mIsInterstitialAd)
        {
            A.sendEmptyMessage(1026);
        }
    }

    public void setExternalWebViewClient(WebViewClient webviewclient)
    {
        z = webviewclient;
    }

    public void setOrientationPropertiesForInterstitial(boolean flag, String s1)
    {
        mInterstitialController.orientationValueForInterstitial = s1;
        mInterstitialController.lockOrientationValueForInterstitial = flag;
        if (mWebViewIsBrowserActivity)
        {
            mExpandController.handleOrientationFor2Piece();
        }
        if (isViewable() && mIsInterstitialAd)
        {
            A.sendEmptyMessage(1026);
        }
    }

    public void setOriginalParent(ViewParent viewparent)
    {
        D = viewparent;
    }

    public void setPlayableListener(IMWebViewPlayableListener imwebviewplayablelistener)
    {
        l = imwebviewplayablelistener;
    }

    public void setState(ViewState viewstate)
    {
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("State changing from ").append(k).append(" to ").append(viewstate).toString());
        k = viewstate;
        if (viewstate != ViewState.EXPANDING && viewstate != ViewState.RESIZING)
        {
            injectJavaScript((new StringBuilder()).append("window.mraid.broadcastEvent('stateChange','").append(getState()).append("');").toString());
        }
    }

    public void setVideoVolume(String s1, int i1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "setVideoVolume");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "setVideoVolume");
            return;
        } else
        {
            Message message = A.obtainMessage(1017);
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i1);
            message.setData(bundle);
            message.obj = s1;
            A.sendMessage(message);
            return;
        }
    }

    public void show()
    {
        A.sendEmptyMessage(1003);
    }

    public void showVideo(String s1)
    {
        Message message = A.obtainMessage(1014);
        Bundle bundle = new Bundle();
        bundle.putString("pid", s1);
        message.setData(bundle);
        A.sendMessage(message);
    }

    public void unMuteAudio(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "unmuteAudio");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "unmuteAudio");
            return;
        } else
        {
            Message message = A.obtainMessage(1020);
            Bundle bundle = new Bundle();
            bundle.putString("aplayerref", s1);
            message.setData(bundle);
            message.sendToTarget();
            return;
        }
    }

    public void unMuteVideo(String s1)
    {
        s1 = mAudioVideoController.getVideoPlayer(s1);
        if (s1 == null)
        {
            raiseError("Invalid property ID", "unMuteVideo");
            return;
        }
        if (s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || s1.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
        {
            raiseError("Invalid player state", "unMuteVideo");
            return;
        } else
        {
            Message message = A.obtainMessage(1016);
            message.obj = s1;
            A.sendMessage(message);
            return;
        }
    }

    public void userInteraction(HashMap hashmap)
    {
        Message message = A.obtainMessage(1033);
        Bundle bundle = new Bundle();
        bundle.putSerializable("map", hashmap);
        message.setData(bundle);
        message.sendToTarget();
    }

}
