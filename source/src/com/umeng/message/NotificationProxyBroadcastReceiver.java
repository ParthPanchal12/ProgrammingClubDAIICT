// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.common.message.Log;
import com.umeng.message.entity.UMessage;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message:
//            UTrack, PushAgent, UHandler

public class NotificationProxyBroadcastReceiver extends BroadcastReceiver
{

    public static final int EXTRA_ACTION_CLICK = 10;
    public static final int EXTRA_ACTION_DISMISS = 11;
    public static final int EXTRA_ACTION_NOT_EXIST = -1;
    public static final String EXTRA_KEY_ACTION = "ACTION";
    public static final String EXTRA_KEY_MSG = "MSG";
    private static final String a = com/umeng/message/NotificationProxyBroadcastReceiver.getName();
    private UHandler b;

    public NotificationProxyBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getStringExtra("MSG");
        int i;
        i = intent.getIntExtra("ACTION", -1);
        Log.c(a, String.format("onReceive[msg=%s, action=%d]", new Object[] {
            s, Integer.valueOf(i)
        }));
        intent = new UMessage(new JSONObject(s));
        i;
        JVM INSTR tableswitch 10 11: default 159
    //                   10 107
    //                   11 84;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        Log.c(a, "click notification");
        UTrack.getInstance(context).trackMsgClick(intent);
        b = PushAgent.getInstance(context).getNotificationClickHandler();
        if (b != null)
        {
            b.handleMessage(context, intent);
            return;
        }
        break; /* Loop/switch isn't completed */
_L3:
        try
        {
            Log.c(a, "dismiss notification");
            UTrack.getInstance(context).trackMsgDismissed(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
    }

}
