// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.allinone.free.utils.ProgressWheel;

// Referenced classes of package com.allinone.free.activity:
//            TodaysPickActivity

class this._cls0 extends BroadcastReceiver
{

    final TodaysPickActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        TodaysPickActivity.access$0(TodaysPickActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = TodaysPickActivity.this;
        super();
    }
}
