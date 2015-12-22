// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package org.android.agoo.client:
//            BaseBroadcastReceiver

class b
    implements Runnable
{

    final Context a;
    final Intent b;
    final BaseBroadcastReceiver c;

    public void run()
    {
        try
        {
            c.a(a, b);
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    (BaseBroadcastReceiver basebroadcastreceiver, Context context, Intent intent)
    {
        c = basebroadcastreceiver;
        a = context;
        b = intent;
        super();
    }
}
