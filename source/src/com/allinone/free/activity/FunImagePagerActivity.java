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
import android.widget.TextView;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.pager.JazzyViewPager;
import com.allinone.free.pager.OutlineContainer;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

public class FunImagePagerActivity extends Activity
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{
    private class MyPageAdapter extends PagerAdapter
    {

        static final boolean $assertionsDisabled;
        ArrayList list;
        final FunImagePagerActivity this$0;

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
            }
            ImageView imageview = (ImageView)view.findViewById(0x7f060173);
            tv_detail_jingdu.setText((new StringBuilder(String.valueOf(i))).append("/").append(detailcount).toString());
            if (detailcount == 1)
            {
                tv_detail_jingdu.setText("1/1");
            }
            Log.e("www", (new StringBuilder("++++++list.get(position)=")).append((String)list.get(i)).toString());
            app.asyncLoadImage((String)list.get(i), imageview);
            ((JazzyViewPager)viewgroup).addView(view, -1, -1);
            viewPager.setObjectForPosition(view, i);
            return view;
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
            if (!com/allinone/free/activity/FunImagePagerActivity.desiredAssertionStatus())
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
            this$0 = FunImagePagerActivity.this;
            super();
            list = arraylist;
            inflater = getLayoutInflater();
        }
    }


    private MyApplcation app;
    private int detailcount;
    private String detailtitle;
    private LayoutInflater inflater;
    private ArrayList list;
    private int screenshotpos;
    private TextView tv_detail_jingdu;
    private TextView tv_detail_title;
    private JazzyViewPager viewPager;

    public FunImagePagerActivity()
    {
    }

    private void init()
    {
        app = (MyApplcation)getApplicationContext();
        viewPager = (JazzyViewPager)findViewById(0x7f0600d2);
        tv_detail_title = (TextView)findViewById(0x7f0600d4);
        tv_detail_jingdu = (TextView)findViewById(0x7f0600d5);
        ((ImageView)findViewById(0x7f0600d3)).setOnClickListener(new android.view.View.OnClickListener() {

            final FunImagePagerActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
        });
        tv_detail_title.setText(detailtitle);
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
        detailtitle = getIntent().getStringExtra("detailtitle");
        detailcount = getIntent().getIntExtra("detailcount", 0);
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
