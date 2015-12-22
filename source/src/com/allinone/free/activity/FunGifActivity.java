// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.MD5;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.ant.liao.GifImageType;
import com.ant.liao.GifView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FunGifActivity extends Activity
    implements android.view.View.OnClickListener, android.view.GestureDetector.OnGestureListener
{
    private class AnimateFirstDisplayListener extends SimpleImageLoadingListener
    {

        final List displayedImages;
        final FunGifActivity this$0;

        public void onLoadingComplete(String s, View view, Bitmap bitmap)
        {
            if (bitmap != null)
            {
                view = (ImageView)view;
                boolean flag;
                if (displayedImages.contains(s))
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (flag)
                {
                    FadeInBitmapDisplayer.animate(view, 500);
                    displayedImages.add(s);
                }
            }
        }

        private AnimateFirstDisplayListener()
        {
            this$0 = FunGifActivity.this;
            super();
            displayedImages = Collections.synchronizedList(new LinkedList());
        }

        AnimateFirstDisplayListener(AnimateFirstDisplayListener animatefirstdisplaylistener)
        {
            this();
        }
    }


    public static final int GIF_LOAD_FINISH = 291;
    private ImageLoadingListener animateFirstListener;
    private String apath;
    private MyApplcation app;
    private int detailcount;
    private String detailtitle;
    private String fullPath;
    private GifView gifView;
    private Handler handler;
    private ImageLoader imageLoader;
    private ImageView iv_gif;
    private DisplayImageOptions options;
    android.view.ViewGroup.LayoutParams para;
    private ProgressWheel progress_wheel_gif;
    private TextView tv_detail_title;
    private ViewTreeObserver viewTreeObserver;
    private int window_height;
    private int window_width;

    public FunGifActivity()
    {
        imageLoader = ImageLoader.getInstance();
        animateFirstListener = new AnimateFirstDisplayListener(null);
        handler = new Handler() {

            final FunGifActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.what == 291)
                {
                    progress_wheel_gif.setVisibility(8);
                    iv_gif.setVisibility(8);
                    message = (File)message.obj;
                    gifView.setGifImage(message.getAbsolutePath());
                    viewTreeObserver = gifView.getViewTreeObserver();
                }
            }

            
            {
                this$0 = FunGifActivity.this;
                super();
            }
        };
    }

    private void initDatas()
    {
        fullPath = getIntent().getStringExtra("fullpath");
        apath = getIntent().getStringExtra("apath");
        app.asyncLoadImage(apath, iv_gif);
        Log.e("www", (new StringBuilder("fullPath=")).append(fullPath).toString());
        gifView.setLoopAnimation();
        gifView.setGifImageType(GifImageType.COVER);
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheOnDisc().showStubImage(0x7f0200c0).showImageOnFail(0x7f0200c0).build();
        if (fullPath.endsWith(".gif"))
        {
            (new Thread(new Runnable() {

                final FunGifActivity this$0;

                public void run()
                {
                    File file = new File(new File(Myutils.cachePath), MD5.getMd5Name(fullPath));
                    if (!file.exists()) goto _L2; else goto _L1
_L1:
                    handler.sendMessage(handler.obtainMessage(291, file));
_L4:
                    return;
_L2:
                    Object obj;
                    obj = (HttpURLConnection)(new URL(fullPath)).openConnection();
                    ((HttpURLConnection) (obj)).setConnectTimeout(60000);
                    ((HttpURLConnection) (obj)).setRequestMethod("GET");
                    if (((HttpURLConnection) (obj)).getResponseCode() != 200) goto _L4; else goto _L3
_L3:
                    FileOutputStream fileoutputstream;
                    byte abyte0[];
                    fileoutputstream = new FileOutputStream(file);
                    obj = ((HttpURLConnection) (obj)).getInputStream();
                    abyte0 = new byte[1024];
_L5:
                    int i = ((InputStream) (obj)).read(abyte0);
                    if (i == -1)
                    {
                        try
                        {
                            ((InputStream) (obj)).close();
                            fileoutputstream.close();
                            handler.sendMessage(handler.obtainMessage(291, file));
                            return;
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                        return;
                    }
                    fileoutputstream.write(abyte0, 0, i);
                      goto _L5
                }

            
            {
                this$0 = FunGifActivity.this;
                super();
            }
            })).start();
        }
    }

    private void setListener()
    {
        gifView.setOnClickListener(this);
        (new GestureDetector(this, this)).setOnDoubleTapListener(new android.view.GestureDetector.OnDoubleTapListener() {

            final FunGifActivity this$0;

            public boolean onDoubleTap(MotionEvent motionevent)
            {
                return false;
            }

            public boolean onDoubleTapEvent(MotionEvent motionevent)
            {
                return false;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                finish();
                return false;
            }

            
            {
                this$0 = FunGifActivity.this;
                super();
            }
        });
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131099949: 
            finish();
            break;
        }
        overridePendingTransition(0, 0);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030050);
        gifView = (GifView)findViewById(0x7f06012d);
        progress_wheel_gif = (ProgressWheel)findViewById(0x7f06012f);
        tv_detail_title = (TextView)findViewById(0x7f0600d4);
        ((ImageView)findViewById(0x7f0600d3)).setOnClickListener(new android.view.View.OnClickListener() {

            final FunGifActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = FunGifActivity.this;
                super();
            }
        });
        progress_wheel_gif.setVisibility(0);
        iv_gif = (ImageView)findViewById(0x7f06012e);
        bundle = getWindowManager();
        window_width = bundle.getDefaultDisplay().getWidth();
        window_height = bundle.getDefaultDisplay().getHeight();
        try
        {
            app = (MyApplcation)getApplicationContext();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        initDatas();
        setListener();
        detailtitle = getIntent().getStringExtra("detailtitle");
        detailcount = getIntent().getIntExtra("detailcount", 0);
        tv_detail_title.setText(detailtitle);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            finish();
            overridePendingTransition(0, 0);
        }
        return super.onKeyDown(i, keyevent);
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        finish();
        return false;
    }






}
