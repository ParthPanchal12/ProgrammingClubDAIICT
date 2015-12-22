// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;

import android.content.Intent;
import android.view.View;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.cleaner:
//            ShowCleanActivity_Rub

class this._cls0
    implements android.view.tivity_Rub._cls4
{

    final ShowCleanActivity_Rub this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/allinone/free/activity/DownloadsActivity);
        startActivity(view);
        publicTools.cleanertag = false;
        finish();
    }

    ()
    {
        this$0 = ShowCleanActivity_Rub.this;
        super();
    }
}
