// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.allinone.free.mydownload.DownloadMovieItem;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity

class this._cls0
    implements android.widget.ckListener
{

    final AppDetailsActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(AppDetailsActivity.this, com/allinone/free/activity/AppDetailsActivity);
        adapterview.putExtra("myid", ((DownloadMovieItem)AppDetailsActivity.access$36(AppDetailsActivity.this).get(i)).getId());
        startActivity(adapterview);
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
