// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.Myutils;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity, DownloadsActivity

class this._cls0 extends Handler
{

    final AppDetailsActivity this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        message.what;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 51
    //                   3 59;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        Toast.makeText(AppDetailsActivity.this, "Failed to connect server.", 0).show();
        return;
_L3:
        AppDetailsActivity.access$6(AppDetailsActivity.this);
        return;
_L4:
        Toast.makeText(AppDetailsActivity.this, (new StringBuilder("'")).append(AppDetailsActivity.access$7(AppDetailsActivity.this).getTitle()).append("' is added to download queue.").toString(), 0).show();
        message = new Intent();
        message.setAction("appdetail");
        sendBroadcast(message);
        if (!Myutils.iswidget)
        {
            message = new Intent(AppDetailsActivity.this, com/allinone/free/activity/DownloadsActivity);
            startActivity(message);
            Myutils.iswidget2 = true;
            finish();
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
