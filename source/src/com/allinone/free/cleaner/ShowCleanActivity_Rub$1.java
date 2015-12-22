// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.cleaner:
//            ShowCleanActivity_Rub

class this._cls0 extends Handler
{

    final ShowCleanActivity_Rub this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            Toast.makeText(ShowCleanActivity_Rub.this, "Failed to connect server.", 0).show();
            return;

        case 2: // '\002'
            ShowCleanActivity_Rub.access$0(ShowCleanActivity_Rub.this);
            return;

        case 3: // '\003'
            Toast.makeText(ShowCleanActivity_Rub.this, "'AIO Cleaner' is added to download queue.", 0).show();
            break;
        }
        finish();
        message = new Intent(ShowCleanActivity_Rub.this, com/allinone/free/activity/DownloadsActivity);
        message.setFlags(0x10000000);
        startActivity(message);
        publicTools.cleanertag = false;
    }

    ()
    {
        this$0 = ShowCleanActivity_Rub.this;
        super();
    }
}
