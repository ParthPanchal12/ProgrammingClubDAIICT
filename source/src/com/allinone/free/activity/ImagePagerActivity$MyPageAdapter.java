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
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.pager.JazzyViewPager;
import com.allinone.free.pager.OutlineContainer;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.activity:
//            ImagePagerActivity

private class ter extends PagerAdapter
{

    static final boolean $assertionsDisabled;
    ArrayList list;
    final ImagePagerActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView(ImagePagerActivity.access$1(ImagePagerActivity.this).findViewFromObject(i));
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
        View view = ImagePagerActivity.access$2(ImagePagerActivity.this).inflate(0x7f030058, viewgroup, false);
        if (!$assertionsDisabled && view == null)
        {
            throw new AssertionError();
        } else
        {
            ImageView imageview = (ImageView)view.findViewById(0x7f060173);
            Log.e("www", (new StringBuilder("list.get(position).getScreenshots()=")).append(((DownloadMovieItem)list.get(i)).getScreenshots()).toString());
            ImagePagerActivity.access$3(ImagePagerActivity.this).asyncLoadImage(((DownloadMovieItem)list.get(i)).getScreenshots(), imageview);
            ((JazzyViewPager)viewgroup).addView(view, -1, -1);
            ImagePagerActivity.access$1(ImagePagerActivity.this).setObjectForPosition(view, i);
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

    public A(ArrayList arraylist)
    {
        this$0 = ImagePagerActivity.this;
        super();
        list = arraylist;
        ImagePagerActivity.access$0(ImagePagerActivity.this, getLayoutInflater());
    }
}
