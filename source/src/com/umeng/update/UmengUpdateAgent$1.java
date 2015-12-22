// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.umeng.update:
//            UmengUpdateAgent, UpdateConfig, UpdateResponse, UmengUpdateListener

class  extends Handler
{

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (message.what == 0 && UpdateConfig.isUpdateAutoPopup())
        {
            UmengUpdateAgent.a(UmengUpdateAgent.a(), (UpdateResponse)message.obj, UpdateConfig.getStyle());
        }
        UmengUpdateAgent.a(null);
        if (UmengUpdateAgent.b() != null)
        {
            UmengUpdateAgent.b().onUpdateReturned(message.what, (UpdateResponse)message.obj);
        }
    }

    (Looper looper)
    {
        super(looper);
    }
}
