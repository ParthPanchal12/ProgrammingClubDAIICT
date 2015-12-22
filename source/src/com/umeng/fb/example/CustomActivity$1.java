// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import cn.jpush.android.api.JPushInterface;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.model.UserInfo;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.umeng.fb.example:
//            CustomActivity

class this._cls0
    implements Runnable
{

    final CustomActivity this$0;

    public void run()
    {
        UserInfo userinfo;
        Object obj;
        try
        {
            Thread.sleep(2000L);
            obj = CustomActivity.access$2(CustomActivity.this).getUserInfo();
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            return;
        }
        userinfo = ((UserInfo) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        userinfo = new UserInfo();
        userinfo.getContact();
        obj = new HashMap();
        ((Map) (obj)).put("user_id", JPushInterface.getRegistrationID(CustomActivity.this));
        userinfo.setContact(((Map) (obj)));
        CustomActivity.access$2(CustomActivity.this).setUserInfo(userinfo);
        CustomActivity.access$2(CustomActivity.this).updateUserInfo();
        return;
    }

    ()
    {
        this$0 = CustomActivity.this;
        super();
    }
}
