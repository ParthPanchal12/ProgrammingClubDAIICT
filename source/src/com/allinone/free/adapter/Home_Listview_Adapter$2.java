// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.allinone.free.activity.AppDetailsActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.adapter:
//            Home_Listview_Adapter

class val.list
    implements android.widget.istener
{

    final Home_Listview_Adapter this$0;
    private final ArrayList val$list;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(Home_Listview_Adapter.access$0(Home_Listview_Adapter.this), com/allinone/free/activity/AppDetailsActivity);
        adapterview.putExtra("myid", ((DownloadMovieItem)val$list.get(i)).getId());
        Home_Listview_Adapter.access$0(Home_Listview_Adapter.this).startActivity(adapterview);
    }

    ()
    {
        this$0 = final_home_listview_adapter;
        val$list = ArrayList.this;
        super();
    }
}
