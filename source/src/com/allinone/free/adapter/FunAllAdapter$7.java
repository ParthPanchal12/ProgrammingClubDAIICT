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
import java.util.List;

// Referenced classes of package com.allinone.free.adapter:
//            FunAllAdapter

class val.position
    implements android.view.ener
{

    final FunAllAdapter this$0;
    private final int val$position;

    public void onClick(View view)
    {
        Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getFunlist()).toString());
        view = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getSerial()).append("&type=hit").toString();
        Log.e("www", (new StringBuilder("url=+")).append(view).toString());
        publicTools.getUrl(view);
        view = new Intent(FunAllAdapter.access$1(FunAllAdapter.this), com/allinone/free/activity/FunImagePagerActivity);
        view.putExtra("screenshotlist", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getFunlist());
        view.putExtra("detailtitle", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getTitle());
        view.putExtra("detailcount", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getImg_count());
        FunAllAdapter.access$1(FunAllAdapter.this).startActivity(view);
    }

    tivity()
    {
        this$0 = final_funalladapter;
        val$position = I.this;
        super();
    }
}
