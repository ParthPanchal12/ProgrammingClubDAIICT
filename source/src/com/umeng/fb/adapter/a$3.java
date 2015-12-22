// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.adapter;

import android.os.Handler;
import android.os.Message;
import com.umeng.fb.audio.AudioAgent;

// Referenced classes of package com.umeng.fb.adapter:
//            a

class  extends Handler
{

    final a a;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 29
    //                   1 70;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        com.umeng.fb.adapter.a.b(a);
        if (com.umeng.fb.adapter.a.c(a) != null && com.umeng.fb.adapter.a.c(a).getPlayStatus())
        {
            com.umeng.fb.adapter.a.c(a).stopPlayer();
            return;
        }
          goto _L1
_L3:
        a.notifyDataSetChanged();
        return;
    }

    gent(a a1)
    {
        a = a1;
        super();
    }
}
