// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.pager.JazzyViewPager;
import com.allinone.free.pager.OutlineContainer;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

public class ImagePagerActivity extends Activity
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{
    private class MyPageAdapter extends PagerAdapter
    {

        static final boolean $assertionsDisabled;
        ArrayList list;
        final ImagePagerActivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            viewgroup.removeView(viewPager.findViewFromObject(i));
        }

        public int getCount()
        {
            if (list == null || list.size() == 0)
            {
                return list.size();
            } else
            {
                return list.size();
            }
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            View view = inflater.inflate(0x7f030058, viewgroup, false);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            } else
            {
                ImageView imageview = (ImageView)view.findViewById(0x7f060173);
                Log.e("www", (new StringBuilder("list.get(position).getScreenshots()=")).append(((DownloadMovieItem)list.get(i)).getScreenshots()).toString());
                app.asyncLoadImage(((DownloadMovieItem)list.get(i)).getScreenshots(), imageview);
                ((JazzyViewPager)viewgroup).addView(view, -1, -1);
                viewPager.setObjectForPosition(view, i);
                return view;
            }
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            if (!(view instanceof OutlineContainer)) goto _L2; else goto _L1
_L1:
            if (((OutlineContainer)view).getChildAt(0) != obj) goto _L4; else goto _L3
_L3:
            return true;
_L4:
            return false;
_L2:
            if (view != obj)
            {
                return false;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        static 
        {
            boolean flag;
            if (!com/allinone/free/activity/ImagePagerActivity.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            $assertionsDisabled = flag;
        }

        public MyPageAdapter(ArrayList arraylist)
        {
            this$0 = ImagePagerActivity.this;
            super();
            list = arraylist;
            inflater = getLayoutInflater();
        }
    }


    private MyApplcation app;
    private LayoutInflater inflater;
    private ArrayList list;
    private int screenshotpos;
    private JazzyViewPager viewPager;

    public ImagePagerActivity()
    {
    }

    private void init()
    {
        app = (MyApplcation)getApplicationContext();
        viewPager = (JazzyViewPager)findViewById(0x7f0600d2);
        com.allinone.free.pager.JazzyViewPager.TransitionEffect transitioneffect = com.allinone.free.pager.JazzyViewPager.TransitionEffect.Tablet;
        viewPager.setTransitionEffect(transitioneffect);
        viewPager.setOnPageChangeListener(this);
        viewPager.setAdapter(new MyPageAdapter(list));
        viewPager.setCurrentItem(screenshotpos);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002d);
        list = (ArrayList)getIntent().getSerializableExtra("screenshotlist");
        screenshotpos = getIntent().getIntExtra("screenshotpos", 0);
        init();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            finish();
        }
        return super.onKeyDown(i, keyevent);
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        screenshotpos = i;
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }




}
