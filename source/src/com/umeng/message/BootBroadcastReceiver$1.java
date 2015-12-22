// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.umeng.message:
//            BootBroadcastReceiver, MsgLogStore

class a
    implements Runnable
{

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
              = ()iterator.next();
            if (MsgLogStore.getInstance(BootBroadcastReceiver.a(a)).getMsgLog(.msgId) == null && .msgType.equals("notification"))
            {
                MsgLogStore.getInstance(BootBroadcastReceiver.a(a)).addLog(.msgId, 2, System.currentTimeMillis());
            }
        } while (true);
    }

    (BootBroadcastReceiver bootbroadcastreceiver)
    {
        a = bootbroadcastreceiver;
        super();
    }
}
