// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.mydownload;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.umeng.message.PushAgent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.allinone.free.mydownload:
//            DownloadMovieItem

public class MyApplcation extends Application
{
    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener
    {

        static final List displayedImages = Collections.synchronizedList(new LinkedList());

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
        }

        AnimateFirstDisplayListener(AnimateFirstDisplayListener animatefirstdisplaylistener)
        {
            this();
        }
    }


    public static final boolean DEVELOPER_MODE = false;
    private static final String TAG = com/allinone/free/mydownload/MyApplcation.getName();
    private ImageLoadingListener animateFirstListener;
    private List downloadItems;
    private DownloadMovieItem downloadSuccess;
    private ImageLoader imageLoader;
    private List list;
    private PushAgent mPushAgent;
    private DisplayImageOptions options;
    private ViewPager pager;
    private DownloadMovieItem startDownloadMovieItem;
    private DownloadMovieItem stopOrStartDownloadMovieItem;

    public MyApplcation()
    {
        downloadItems = new ArrayList();
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheOnDisc().showStubImage(0x7f0200c0).build();
        imageLoader = ImageLoader.getInstance();
        animateFirstListener = new AnimateFirstDisplayListener(null);
    }

    public static void initImageLoader(Context context)
    {
        context = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(context)).threadPriority(3).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).enableLogging().build();
        ImageLoader.getInstance().init(context);
    }

    public void asyncLoadImage(String s, ImageView imageview)
    {
        imageLoader.displayImage(s, imageview, options, animateFirstListener);
    }

    public List getDownloadItems()
    {
        return downloadItems;
    }

    public DownloadMovieItem getDownloadSuccess()
    {
        return downloadSuccess;
    }

    public List getListData()
    {
        return list;
    }

    public ViewPager getPager()
    {
        return pager;
    }

    public DownloadMovieItem getStartDownloadMovieItem()
    {
        return startDownloadMovieItem;
    }

    public DownloadMovieItem getStopOrStartDownloadMovieItem()
    {
        return stopOrStartDownloadMovieItem;
    }

    public void onCreate()
    {
        super.onCreate();
        list = new ArrayList();
        initImageLoader(getApplicationContext());
        mPushAgent = PushAgent.getInstance(this);
    }

    public void setDownloadItems(List list1)
    {
        downloadItems = list1;
    }

    public void setDownloadSuccess(DownloadMovieItem downloadmovieitem)
    {
        downloadSuccess = downloadmovieitem;
    }

    public void setListData(List list1)
    {
        list = list1;
    }

    public void setPager(ViewPager viewpager)
    {
        pager = viewpager;
    }

    public void setStartDownloadMovieItem(DownloadMovieItem downloadmovieitem)
    {
        startDownloadMovieItem = downloadmovieitem;
    }

    public void setStopOrStartDownloadMovieItem(DownloadMovieItem downloadmovieitem)
    {
        stopOrStartDownloadMovieItem = downloadmovieitem;
    }

}
