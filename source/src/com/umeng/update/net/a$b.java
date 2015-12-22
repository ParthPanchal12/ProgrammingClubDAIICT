// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import u.upd.b;

// Referenced classes of package com.umeng.update.net:
//            a, d

class  extends Handler
{

    final a a;

    public void handleMessage(Message message)
    {
        u.upd.b.c(com.umeng.update.net.a.b(), (new StringBuilder("DownloadAgent.handleMessage(")).append(message.what).append("): ").toString());
        message.what;
        JVM INSTR tableswitch 1 5: default 289
    //                   1 74
    //                   2 272
    //                   3 140
    //                   4 68
    //                   5 167;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        super.handleMessage(message);
        return;
_L2:
        try
        {
            if (com.umeng.update.net.a.k(a) != null)
            {
                com.umeng.update.net.a.k(a).d();
                return;
            }
            break; /* Loop/switch isn't completed */
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            u.upd.b.c(com.umeng.update.net.a.b(), (new StringBuilder("DownloadAgent.handleMessage(")).append(message.what).append("): ").append(exception.getMessage()).toString());
            return;
        }
_L4:
        if (com.umeng.update.net.a.k(a) != null)
        {
            com.umeng.update.net.a.k(a).a(message.arg1);
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        com.umeng.update.net.a.l(a).unbindService(com.umeng.update.net.a.m(a));
        if (com.umeng.update.net.a.k(a) == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (message.arg1 == 1 || message.arg1 == 3 || message.arg1 == 5)
        {
            com.umeng.update.net.a.k(a).a(message.arg1, message.arg2, message.getData().getString("filename"));
            return;
        }
        com.umeng.update.net.a.k(a).a(0, 0, null);
        u.upd.b.c(com.umeng.update.net.a.b(), "DownloadAgent.handleMessage(DownloadingService.DOWNLOAD_COMPLETE_FAIL): ");
        return;
_L3:
        com.umeng.update.net.a.k(a).b(message.arg1);
        return;
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
