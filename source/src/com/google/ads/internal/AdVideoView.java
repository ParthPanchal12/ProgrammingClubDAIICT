// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.ads.m;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.ads.internal:
//            a, AdWebView

public class AdVideoView extends FrameLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{
    private static class a
        implements Runnable
    {

        private final WeakReference a;

        public void a()
        {
            ((Handler)m.a().c.a()).postDelayed(this, 250L);
        }

        public void run()
        {
            AdVideoView advideoview = (AdVideoView)a.get();
            if (advideoview == null)
            {
                com.google.ads.util.b.d("The video must be gone, so cancelling the timeupdate task.");
                return;
            } else
            {
                advideoview.f();
                ((Handler)m.a().c.a()).postDelayed(this, 250L);
                return;
            }
        }

        public a(AdVideoView advideoview)
        {
            a = new WeakReference(advideoview);
        }
    }


    private static final com.google.ads.internal.a b;
    public MediaController a;
    private final WeakReference c;
    private final AdWebView d;
    private long e;
    private final VideoView f;
    private String g;

    public AdVideoView(Activity activity, AdWebView adwebview)
    {
        super(activity);
        c = new WeakReference(activity);
        d = adwebview;
        f = new VideoView(activity);
        activity = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
        addView(f, activity);
        a = null;
        g = null;
        e = 0L;
        a();
        f.setOnCompletionListener(this);
        f.setOnPreparedListener(this);
        f.setOnErrorListener(this);
    }

    protected void a()
    {
        (new a(this)).a();
    }

    public void a(int i)
    {
        f.seekTo(i);
    }

    public void a(MotionEvent motionevent)
    {
        f.onTouchEvent(motionevent);
    }

    public void b()
    {
        if (!TextUtils.isEmpty(g))
        {
            f.setVideoPath(g);
            return;
        } else
        {
            b.a(d, "onVideoEvent", "{'event': 'error', 'what': 'no_src'}");
            return;
        }
    }

    public void c()
    {
        f.pause();
    }

    public void d()
    {
        f.start();
    }

    public void e()
    {
        f.stopPlayback();
    }

    void f()
    {
        long l = f.getCurrentPosition();
        if (e != l)
        {
            float f1 = (float)l / 1000F;
            b.a(d, "onVideoEvent", (new StringBuilder()).append("{'event': 'timeupdate', 'time': ").append(f1).append("}").toString());
            e = l;
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        b.a(d, "onVideoEvent", "{'event': 'ended'}");
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        com.google.ads.util.b.e((new StringBuilder()).append("Video threw error! <what:").append(i).append(", extra:").append(j).append(">").toString());
        b.a(d, "onVideoEvent", (new StringBuilder()).append("{'event': 'error', 'what': '").append(i).append("', 'extra': '").append(j).append("'}").toString());
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        float f1 = (float)f.getDuration() / 1000F;
        b.a(d, "onVideoEvent", (new StringBuilder()).append("{'event': 'canplaythrough', 'duration': '").append(f1).append("'}").toString());
    }

    public void setMediaControllerEnabled(boolean flag)
    {
        Activity activity = (Activity)c.get();
        if (activity == null)
        {
            com.google.ads.util.b.e("adActivity was null while trying to enable controls on a video.");
            return;
        }
        if (flag)
        {
            if (a == null)
            {
                a = new MediaController(activity);
            }
            f.setMediaController(a);
            return;
        }
        if (a != null)
        {
            a.hide();
        }
        f.setMediaController(null);
    }

    public void setSrc(String s)
    {
        g = s;
    }

    static 
    {
        b = (com.google.ads.internal.a)com.google.ads.internal.a.a.b();
    }
}
