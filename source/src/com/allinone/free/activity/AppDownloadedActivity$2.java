// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import com.allinone.free.adapter.AppDownloadedAdapter;
import com.allinone.free.utils.Myutils;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            AppDownloadedActivity

class this._cls0 extends BroadcastReceiver
{

    final AppDownloadedActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = AppDownloadedActivity.access$0(AppDownloadedActivity.this);
        Myutils.getInstance();
        context.add(Myutils.successItem);
        AppDownloadedActivity.access$6(AppDownloadedActivity.this).setAdapter(AppDownloadedActivity.access$2(AppDownloadedActivity.this));
        AppDownloadedActivity.access$2(AppDownloadedActivity.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = AppDownloadedActivity.this;
        super();
    }
}
