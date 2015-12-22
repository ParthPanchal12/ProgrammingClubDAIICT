// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.content.Context;
import android.content.Intent;
import com.umeng.common.message.Log;
import com.umeng.message.UmengBaseIntentService;
import com.umeng.message.entity.UMessage;
import org.json.JSONObject;

public class MyPushIntentService extends UmengBaseIntentService
{

    private static final String TAG = com/umeng/fb/example/MyPushIntentService.getName();

    public MyPushIntentService()
    {
    }

    protected void onMessage(Context context, Intent intent)
    {
        super.onMessage(context, intent);
        try
        {
            context = intent.getStringExtra("body");
            intent = new UMessage(new JSONObject(context));
            Log.e("aaa", (new StringBuilder(String.valueOf(context))).append("-----------").append(((UMessage) (intent)).custom).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, context.getMessage());
        }
    }

}
