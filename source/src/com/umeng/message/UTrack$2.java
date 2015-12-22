// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import com.umeng.common.message.Log;
import java.util.ArrayList;

// Referenced classes of package com.umeng.message:
//            UTrack, MsgLogStore

class a
    implements Runnable
{

    final UTrack a;

    public void run()
    {
        for (Object obj = MsgLogStore.getInstance(UTrack.a(a)).getMsgLogs(1); ((ArrayList) (obj)).size() > 0; obj = MsgLogStore.getInstance(UTrack.a(a)).getMsgLogs(1))
        {
            obj = (re.MsgLog)((ArrayList) (obj)).get(0);
            UTrack.a(a, ((re.MsgLog) (obj)).msgId, ((re.MsgLog) (obj)).actionType, ((re.MsgLog) (obj)).time);
        }

        Log.c(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
        UTrack.a(false);
        return;
        Object obj1;
        obj1;
        ((Throwable) (obj1)).printStackTrace();
        Log.c(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
        UTrack.a(false);
        return;
        obj1;
        Log.c(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
        UTrack.a(false);
        throw obj1;
    }

    g(UTrack utrack)
    {
        a = utrack;
        super();
    }
}
