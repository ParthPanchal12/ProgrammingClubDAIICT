// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import com.allinone.free.adapter.RingtoneDownloadedAdapter;
import com.allinone.free.utils.Myutils;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            RingtoneDownloadedActivity

class this._cls0 extends BroadcastReceiver
{

    final RingtoneDownloadedActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = RingtoneDownloadedActivity.access$0(RingtoneDownloadedActivity.this);
        Myutils.getInstance();
        context.add(Myutils.successItem);
        RingtoneDownloadedActivity.access$4(RingtoneDownloadedActivity.this).setAdapter(RingtoneDownloadedActivity.access$2(RingtoneDownloadedActivity.this));
        RingtoneDownloadedActivity.access$2(RingtoneDownloadedActivity.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = RingtoneDownloadedActivity.this;
        super();
    }
}
