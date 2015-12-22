// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.allinone.free.cleaner:
//            KaijishijianActivity

public class BootBroadcastReceiver extends BroadcastReceiver
{

    public BootBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            intent = new Intent(context, com/allinone/free/cleaner/KaijishijianActivity);
            intent.addFlags(0x10000000);
            context.startActivity(intent);
        }
    }
}
