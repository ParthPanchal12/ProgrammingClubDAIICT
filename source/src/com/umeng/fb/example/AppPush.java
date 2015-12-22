// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.content.Context;
import android.content.Intent;
import com.umeng.fb.push.FBMessage;
import com.umeng.fb.push.FeedbackPush;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

// Referenced classes of package com.umeng.fb.example:
//            CustomActivity

public class AppPush
{

    private static AppPush mAppPush;
    private Context context;
    public UmengMessageHandler mMessageHandler;

    public AppPush(Context context1)
    {
        context = context1;
    }

    public static AppPush getInstance(Context context1)
    {
        if (mAppPush == null)
        {
            mAppPush = new AppPush(context1);
        }
        return mAppPush;
    }

    public void init()
    {
        mMessageHandler = new UmengMessageHandler() {

            final AppPush this$0;

            public void dealWithCustomMessage(Context context1, UMessage umessage)
            {
                if (FeedbackPush.getInstance(context1).dealFBMessage(new FBMessage(umessage.custom)))
                {
                    return;
                } else
                {
                    context1.startActivity(new Intent(context1, com/umeng/fb/example/CustomActivity));
                    return;
                }
            }

            
            {
                this$0 = AppPush.this;
                super();
            }
        };
        PushAgent.getInstance(context).setMessageHandler(mMessageHandler);
    }
}
