// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.message.proguard.aJ;

// Referenced classes of package org.android.agoo.client:
//            BaseIntentService

class a
    implements ServiceConnection
{

    final BaseIntentService a;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        aJ.c("BaseIntentService", (new StringBuilder()).append("messageConnected pack[").append(componentname.getPackageName()).append("]").toString());
        BaseIntentService.a(a, true);
        BaseIntentService.a(a, org.android.agoo.service..asInterface(ibinder));
        componentname = a.getApplicationContext();
        BaseIntentService.b(a, componentname);
        BaseIntentService.c(a, componentname);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        aJ.c("BaseIntentService", (new StringBuilder()).append("messageDisconnected pack[").append(componentname.getPackageName()).append("]").toString());
    }

    b(BaseIntentService baseintentservice)
    {
        a = baseintentservice;
        super();
    }
}
