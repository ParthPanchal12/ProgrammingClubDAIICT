// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;
import com.allinone.free.start_welcome.MainActivity;
import com.allinone.free.utils.Myutils;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity, MyMainActivity

class this._cls0
    implements android.view.ilsActivity._cls8
{

    final AppDetailsActivity this$0;

    public void onClick(View view)
    {
        if (AppDetailsActivity.access$37(AppDetailsActivity.this).booleanValue())
        {
            startActivity(new Intent(AppDetailsActivity.this, com/allinone/free/activity/MyMainActivity));
            finish();
        } else
        {
            finish();
        }
        if (AppDetailsActivity.access$38(AppDetailsActivity.this) && !Myutils.detail_save)
        {
            startActivity(new Intent(AppDetailsActivity.this, com/allinone/free/start_welcome/MainActivity));
            finish();
            return;
        } else
        {
            finish();
            return;
        }
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
