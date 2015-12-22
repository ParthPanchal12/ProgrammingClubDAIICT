// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.allinone.free.mydownload.DownloadMovieItem;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.fragments:
//            DownloadingFragment

class this._cls0 extends Handler
{

    final DownloadingFragment this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 100: // 'd'
            DownloadingFragment.access$1(DownloadingFragment.this, DownloadingFragment.access$0(DownloadingFragment.this).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
            break;
        }
        if (DownloadingFragment.access$2(DownloadingFragment.this).size() != 0)
        {
            DownloadingFragment.access$3(DownloadingFragment.this).setVisibility(8);
            return;
        } else
        {
            DownloadingFragment.access$3(DownloadingFragment.this).setVisibility(0);
            return;
        }
    }

    ()
    {
        this$0 = DownloadingFragment.this;
        super();
    }
}
