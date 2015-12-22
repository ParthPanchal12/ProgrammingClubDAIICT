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
//            AppSearchResultActivity, AppDetailsActivity

class this._cls0
    implements android.widget.tener
{

    final AppSearchResultActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(AppSearchResultActivity.this, com/allinone/free/activity/AppDetailsActivity);
        adapterview.putExtra("myid", ((DownloadMovieItem)AppSearchResultActivity.access$12(AppSearchResultActivity.this).get(i)).getId());
        startActivity(adapterview);
    }

    ()
    {
        this$0 = AppSearchResultActivity.this;
        super();
    }
}
