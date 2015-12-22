// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.Myutils;
import java.util.List;

// Referenced classes of package com.allinone.free.adapter:
//            WidgetPaidGridviewAdapter

class val.position
    implements android.view.iewAdapter._cls2
{

    final WidgetPaidGridviewAdapter this$0;
    private final int val$position;

    public void onClick(View view)
    {
        view = new ComponentName("com.allinone.free", "com.allinone.free.activity.AppDetailsActivity");
        Intent intent = new Intent();
        intent.putExtra("myid", ((DownloadMovieItem)WidgetPaidGridviewAdapter.access$4(WidgetPaidGridviewAdapter.this).get(val$position)).getId());
        Myutils.iswidget = false;
        intent.addFlags(0x10000000);
        intent.setComponent(view);
        WidgetPaidGridviewAdapter.access$0(WidgetPaidGridviewAdapter.this).startActivity(intent);
    }

    ()
    {
        this$0 = final_widgetpaidgridviewadapter;
        val$position = I.this;
        super();
    }
}
