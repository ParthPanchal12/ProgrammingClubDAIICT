// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.umeng.message.entity.UMessage;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message:
//            UmengBaseIntentService, PushAgent, UHandler

public class UmengIntentService extends UmengBaseIntentService
{

    private static final String a = com/umeng/message/UmengIntentService.getName();

    public UmengIntentService()
    {
    }

    protected void onMessage(Context context, Intent intent)
    {
        super.onMessage(context, intent);
        try
        {
            context = new UMessage(new JSONObject(intent.getStringExtra("body")));
            intent = PushAgent.getInstance(getApplicationContext()).getMessageHandler();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(a, context.getMessage());
            return;
        }
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        intent.handleMessage(getApplicationContext(), context);
    }

}
