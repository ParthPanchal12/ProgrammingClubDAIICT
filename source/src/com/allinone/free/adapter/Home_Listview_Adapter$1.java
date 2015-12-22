// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.allinone.free.activity.AppSearchResultActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.adapter:
//            Home_Listview_Adapter

class val.list
    implements android.view.ew_Adapter._cls1
{

    final Home_Listview_Adapter this$0;
    private final ArrayList val$list;

    public void onClick(View view)
    {
        view = new Intent(Home_Listview_Adapter.access$0(Home_Listview_Adapter.this), com/allinone/free/activity/AppSearchResultActivity);
        view.putExtra("searchkeywords", ((DownloadMovieItem)val$list.get(0)).getSearch_keyword());
        Home_Listview_Adapter.access$0(Home_Listview_Adapter.this).startActivity(view);
    }

    ()
    {
        this$0 = final_home_listview_adapter;
        val$list = ArrayList.this;
        super();
    }
}
