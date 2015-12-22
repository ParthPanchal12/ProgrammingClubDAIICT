// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.android.agoo.net.mtop.MtopHttpChunked;

// Referenced classes of package com.umeng.message.proguard:
//            aS, aJ, bf

class b extends BroadcastReceiver
{

    final aS a;
    private volatile int b;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if (!TextUtils.equals(context, "android.intent.action.SCREEN_ON")) goto _L2; else goto _L1
_L1:
        aJ.c("MessagePush", "screen_on");
        intent = aS.a(a).readyState();
        if (intent == bf.b || intent == bf.a) goto _L2; else goto _L3
_L3:
        aS.a(a, aS.b(a), "screen_on_connect");
_L5:
        return;
_L2:
        if (TextUtils.equals(context, "android.net.conn.CONNECTIVITY_CHANGE"))
        {
            b = b + 1;
            if (b > 1)
            {
                aJ.c("MessagePush", "network_change");
                aS.a(a, aS.c(a), "network_change_connect");
                return;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    tpChunked(aS as)
    {
        a = as;
        super();
        b = 0;
    }
}
