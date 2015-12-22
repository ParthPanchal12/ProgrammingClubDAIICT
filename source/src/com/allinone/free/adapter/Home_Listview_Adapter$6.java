// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.allinone.free.activity.FunImagePagerActivity;
import com.allinone.free.model.FunModel;
import com.allinone.free.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.adapter:
//            Home_Listview_Adapter

class val.ppp
    implements android.view.ew_Adapter._cls6
{

    final Home_Listview_Adapter this$0;
    private final int val$ppp;

    public void onClick(View view)
    {
        Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getFunlist()).toString());
        view = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getSerial()).append("&type=hit").toString();
        Log.e("www", (new StringBuilder("url=+")).append(view).toString());
        publicTools.getUrl(view);
        view = new Intent(Home_Listview_Adapter.access$0(Home_Listview_Adapter.this), com/allinone/free/activity/FunImagePagerActivity);
        view.putExtra("screenshotlist", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getFunlist());
        view.putExtra("detailtitle", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getTitle());
        view.putExtra("detailcount", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getImg_count());
        Home_Listview_Adapter.access$0(Home_Listview_Adapter.this).startActivity(view);
    }

    ()
    {
        this$0 = final_home_listview_adapter;
        val$ppp = I.this;
        super();
    }
}
