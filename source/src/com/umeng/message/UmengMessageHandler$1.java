// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.os.PowerManager;

// Referenced classes of package com.umeng.message:
//            UmengMessageHandler

class a
{

    final PowerManager a;
    final UmengMessageHandler b;

    boolean a()
    {
        return a.isScreenOn();
    }

    (UmengMessageHandler umengmessagehandler, PowerManager powermanager)
    {
        b = umengmessagehandler;
        a = powermanager;
        super();
    }
}
