// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import android.widget.ImageView;
import com.allinone.free.utils.Player;

// Referenced classes of package com.allinone.free.activity:
//            Mp3DownloadedActivity

class this._cls0
    implements android.view.dedActivity._cls7
{

    final Mp3DownloadedActivity this$0;

    public void onClick(View view)
    {
        if (Mp3DownloadedActivity.access$11(Mp3DownloadedActivity.this).booleanValue())
        {
            Mp3DownloadedActivity.access$3(Mp3DownloadedActivity.this).pause();
            Mp3DownloadedActivity.access$12(Mp3DownloadedActivity.this).setBackgroundResource(0x7f020177);
            Mp3DownloadedActivity.access$13(Mp3DownloadedActivity.this, Boolean.valueOf(false));
            return;
        } else
        {
            Mp3DownloadedActivity.access$3(Mp3DownloadedActivity.this).play();
            Mp3DownloadedActivity.access$12(Mp3DownloadedActivity.this).setBackgroundResource(0x7f020179);
            Mp3DownloadedActivity.access$13(Mp3DownloadedActivity.this, Boolean.valueOf(true));
            return;
        }
    }

    ()
    {
        this$0 = Mp3DownloadedActivity.this;
        super();
    }
}
