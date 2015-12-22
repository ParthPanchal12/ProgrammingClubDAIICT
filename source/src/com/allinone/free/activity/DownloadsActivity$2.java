// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;
import com.allinone.free.utils.Myutils;

// Referenced classes of package com.allinone.free.activity:
//            DownloadsActivity, MyMainActivity, ChapingActivity

class this._cls0
    implements android.view.
{

    final DownloadsActivity this$0;

    public void onClick(View view)
    {
        if (Myutils.iswidget2)
        {
            startActivity(new Intent(DownloadsActivity.this, com/allinone/free/activity/MyMainActivity));
            return;
        } else
        {
            view = new Intent(getApplicationContext(), com/allinone/free/activity/ChapingActivity);
            view.setFlags(0x10000000);
            startActivity(view);
            moveTaskToBack(true);
            return;
        }
    }

    ()
    {
        this$0 = DownloadsActivity.this;
        super();
    }
}
