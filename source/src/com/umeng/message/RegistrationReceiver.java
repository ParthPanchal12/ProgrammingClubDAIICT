// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import org.android.agoo.client.BaseBroadcastReceiver;

// Referenced classes of package com.umeng.message:
//            PushAgent

public class RegistrationReceiver extends BaseBroadcastReceiver
{

    public RegistrationReceiver()
    {
    }

    protected String a(Context context)
    {
        return PushAgent.getInstance(context).getPushIntentServiceClass();
    }
}
