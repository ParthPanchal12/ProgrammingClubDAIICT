// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.allinone.free.activity.MyMainActivity;

// Referenced classes of package com.umeng.fb.example:
//            CustomActivity

class this._cls0
    implements android.view.ner
{

    final CustomActivity this$0;

    public void onClick(View view)
    {
        CustomActivity.access$3(CustomActivity.this, getIntent().getStringExtra("jpush"));
        if (TextUtils.isEmpty(CustomActivity.access$4(CustomActivity.this)))
        {
            finish();
            return;
        } else
        {
            startActivity(new Intent(CustomActivity.this, com/allinone/free/activity/MyMainActivity));
            finish();
            return;
        }
    }

    ity()
    {
        this$0 = CustomActivity.this;
        super();
    }
}
