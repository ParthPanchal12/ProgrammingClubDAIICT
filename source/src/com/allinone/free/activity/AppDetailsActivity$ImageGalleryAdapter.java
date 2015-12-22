// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.DisplayUtil;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity

private class ctx extends BaseAdapter
{

    private Context ctx;
    final AppDetailsActivity this$0;

    public int getCount()
    {
        return AppDetailsActivity.access$11(AppDetailsActivity.this).size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (ImageView)view;
        view = viewgroup;
        if (viewgroup == null)
        {
            view = (ImageView)getLayoutInflater().inflate(0x7f03005b, null, false);
        }
        try
        {
            view.setLayoutParams(new android.widget.tInflater(DisplayUtil.dip2px(AppDetailsActivity.this, 150F), DisplayUtil.dip2px(AppDetailsActivity.this, 260F)));
            AppDetailsActivity.access$18(AppDetailsActivity.this).asyncLoadImage(((DownloadMovieItem)AppDetailsActivity.access$11(AppDetailsActivity.this).get(i)).getScreenshots(), view);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            return view;
        }
        return view;
    }

    public (Context context)
    {
        this$0 = AppDetailsActivity.this;
        super();
        ctx = context;
    }
}
