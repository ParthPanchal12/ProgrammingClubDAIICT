// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.os.Handler;
import android.os.Message;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.BadgeView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.allinone.free.fragments:
//            DownloadedFragment

class this._cls0 extends Handler
{

    final DownloadedFragment this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        message.what;
        JVM INSTR tableswitch 5656 5656: default 28
    //                   5656 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        DownloadedFragment.access$1(DownloadedFragment.this, DownloadedFragment.access$0(DownloadedFragment.this).queryApk("app", "timesort"));
        if (DownloadedFragment.access$2(DownloadedFragment.this) == null)
        {
            DownloadedFragment.access$1(DownloadedFragment.this, new ArrayList());
        }
        publicTools.noticomplete = DownloadedFragment.access$2(DownloadedFragment.this).size();
        DownloadedFragment.access$3(DownloadedFragment.this).setText(String.valueOf(DownloadedFragment.access$2(DownloadedFragment.this).size()));
        DownloadedFragment.access$3(DownloadedFragment.this).show();
        if (DownloadedFragment.access$2(DownloadedFragment.this).size() == 0)
        {
            DownloadedFragment.access$3(DownloadedFragment.this).toggle();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    ()
    {
        this$0 = DownloadedFragment.this;
        super();
    }
}
