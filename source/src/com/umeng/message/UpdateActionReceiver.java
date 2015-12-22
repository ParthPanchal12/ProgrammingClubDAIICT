// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.umeng.message.entity.UMessage;

// Referenced classes of package com.umeng.message:
//            PushAgent, UmengMessageHandler

public class UpdateActionReceiver extends BroadcastReceiver
{

    private UMessage a;

    public UpdateActionReceiver(UMessage umessage)
    {
        a = umessage;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (PushAgent.getInstance(context).isIncludesUmengUpdateSDK())
        {
            intent = intent.getBundleExtra("UpdateListener");
            if (intent.getInt("UpdateStatus") == 0)
            {
                intent = intent.getSerializable("UpdateResponse");
                PushAgent.getInstance(context).setUpdateResponse(intent);
                intent = (UmengMessageHandler)PushAgent.getInstance(context).getMessageHandler();
                if (intent != null)
                {
                    intent.dealWithNotificationMessage(context, a);
                }
            }
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
        }
    }
}
