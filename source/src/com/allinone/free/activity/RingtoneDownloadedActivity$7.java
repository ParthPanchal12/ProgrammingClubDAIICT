// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import android.widget.ImageView;
import com.allinone.free.utils.Player;

// Referenced classes of package com.allinone.free.activity:
//            RingtoneDownloadedActivity

class this._cls0
    implements android.view.dedActivity._cls7
{

    final RingtoneDownloadedActivity this$0;

    public void onClick(View view)
    {
        if (RingtoneDownloadedActivity.access$11(RingtoneDownloadedActivity.this).booleanValue())
        {
            RingtoneDownloadedActivity.access$3(RingtoneDownloadedActivity.this).pause();
            RingtoneDownloadedActivity.access$12(RingtoneDownloadedActivity.this).setBackgroundResource(0x7f020177);
            RingtoneDownloadedActivity.access$13(RingtoneDownloadedActivity.this, Boolean.valueOf(false));
            return;
        } else
        {
            RingtoneDownloadedActivity.access$3(RingtoneDownloadedActivity.this).play();
            RingtoneDownloadedActivity.access$12(RingtoneDownloadedActivity.this).setBackgroundResource(0x7f020179);
            RingtoneDownloadedActivity.access$13(RingtoneDownloadedActivity.this, Boolean.valueOf(true));
            return;
        }
    }

    ()
    {
        this$0 = RingtoneDownloadedActivity.this;
        super();
    }
}
