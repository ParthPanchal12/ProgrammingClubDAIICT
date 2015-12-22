// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.common.message.Log;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.umeng.message:
//            MsgLogStore

public class BootBroadcastReceiver extends BroadcastReceiver
{

    private static final String b = "BootBroadcastReceiver";
    private static final String c = "android.intent.action.BOOT_COMPLETED";
    Runnable a;
    private Context d;

    public BootBroadcastReceiver()
    {
        a = new Runnable() {

            final BootBroadcastReceiver a;

            public void run()
            {
                Iterator iterator = MsgLogStore.getInstance(BootBroadcastReceiver.a(a)).getMsgLogIdTypes().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    MsgLogStore.MsgLogIdType msglogidtype = (MsgLogStore.MsgLogIdType)iterator.next();
                    if (MsgLogStore.getInstance(BootBroadcastReceiver.a(a)).getMsgLog(msglogidtype.msgId) == null && msglogidtype.msgType.equals("notification"))
                    {
                        MsgLogStore.getInstance(BootBroadcastReceiver.a(a)).addLog(msglogidtype.msgId, 2, System.currentTimeMillis());
                    }
                } while (true);
            }

            
            {
                a = BootBroadcastReceiver.this;
                super();
            }
        };
    }

    static Context a(BootBroadcastReceiver bootbroadcastreceiver)
    {
        return bootbroadcastreceiver.d;
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.c("BootBroadcastReceiver", "Boot this system , BootBroadcastReceiver onReceive()");
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            d = context;
            (new Thread(a)).start();
        }
    }
}
