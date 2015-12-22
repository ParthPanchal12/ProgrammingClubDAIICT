// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.allinone.free.activity:
//            RingtoneActivity, MyMainActivity

class this._cls0
    implements android.view.r
{

    final RingtoneActivity this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(RingtoneActivity.this, com/allinone/free/activity/MyMainActivity));
    }

    ()
    {
        this$0 = RingtoneActivity.this;
        super();
    }
}
