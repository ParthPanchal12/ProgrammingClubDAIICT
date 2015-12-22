// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.pager.JazzyViewPager;
import com.allinone.free.pager.OutlineContainer;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.activity:
//            FunImagePagerActivity

private class ter extends PagerAdapter
{

    static final boolean $assertionsDisabled;
    ArrayList list;
    final FunImagePagerActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView(FunImagePagerActivity.access$1(FunImagePagerActivity.this).findViewFromObject(i));
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
        View view = FunImagePagerActivity.access$2(FunImagePagerActivity.this).inflate(0x7f030058, viewgroup, false);
        if (!$assertionsDisabled && view == null)
        {
            throw new AssertionError();
        }
        ImageView imageview = (ImageView)view.findViewById(0x7f060173);
        FunImagePagerActivity.access$3(FunImagePagerActivity.this).setText((new StringBuilder(String.valueOf(i))).append("/").append(FunImagePagerActivity.access$4(FunImagePagerActivity.this)).toString());
        if (FunImagePagerActivity.access$4(FunImagePagerActivity.this) == 1)
        {
            FunImagePagerActivity.access$3(FunImagePagerActivity.this).setText("1/1");
        }
        Log.e("www", (new StringBuilder("++++++list.get(position)=")).append((String)list.get(i)).toString());
        FunImagePagerActivity.access$5(FunImagePagerActivity.this).asyncLoadImage((String)list.get(i), imageview);
        ((JazzyViewPager)viewgroup).addView(view, -1, -1);
        FunImagePagerActivity.access$1(FunImagePagerActivity.this).setObjectForPosition(view, i);
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

    public (ArrayList arraylist)
    {
        this$0 = FunImagePagerActivity.this;
        super();
        list = arraylist;
        FunImagePagerActivity.access$0(FunImagePagerActivity.this, getLayoutInflater());
    }
}
