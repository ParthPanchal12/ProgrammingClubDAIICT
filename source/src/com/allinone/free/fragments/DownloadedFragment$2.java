// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

// Referenced classes of package com.allinone.free.fragments:
//            DownloadedFragment

class this._cls0 extends TimerTask
{

    final DownloadedFragment this$0;

    public void run()
    {
        Message message = new Message();
        message.what = 5656;
        handler.sendMessage(message);
    }

    ()
    {
        this$0 = DownloadedFragment.this;
        super();
    }
}
