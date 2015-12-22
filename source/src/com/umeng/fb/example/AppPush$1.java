// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.content.Context;
import android.content.Intent;
import com.umeng.fb.push.FBMessage;
import com.umeng.fb.push.FeedbackPush;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

// Referenced classes of package com.umeng.fb.example:
//            AppPush, CustomActivity

class andler extends UmengMessageHandler
{

    final AppPush this$0;

    public void dealWithCustomMessage(Context context, UMessage umessage)
    {
        if (FeedbackPush.getInstance(context).dealFBMessage(new FBMessage(umessage.custom)))
        {
            return;
        } else
        {
            context.startActivity(new Intent(context, com/umeng/fb/example/CustomActivity));
            return;
        }
    }

    ge()
    {
        this$0 = AppPush.this;
        super();
    }
}
