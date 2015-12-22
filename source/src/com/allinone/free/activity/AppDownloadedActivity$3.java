// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.allinone.free.adapter.AppDownloadedAdapter;

// Referenced classes of package com.allinone.free.activity:
//            AppDownloadedActivity

class this._cls0 extends BroadcastReceiver
{

    final AppDownloadedActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        AppDownloadedActivity.access$2(AppDownloadedActivity.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = AppDownloadedActivity.this;
        super();
    }
}
