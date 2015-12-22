// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.allinone.free.utils.ProgressWheel;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class this._cls0 extends BroadcastReceiver
{

    final MyMainActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        MyMainActivity.access$10(MyMainActivity.this).setVisibility(8);
        MyMainActivity.access$12(MyMainActivity.this).setVisibility(0);
        MyMainActivity.access$12(MyMainActivity.this).startAnimation(MyMainActivity.access$13(MyMainActivity.this));
    }

    ()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
