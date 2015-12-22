// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.message.proguard.aJ;
import org.android.agoo.service.IElectionService;

// Referenced classes of package org.android.agoo.client:
//            BaseIntentService, AgooSettings

class a
    implements ServiceConnection
{

    final BaseIntentService a;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        aJ.c("BaseIntentService", (new StringBuilder()).append("electionConnection pack[").append(componentname.getPackageName()).append("]").toString());
        try
        {
            componentname = a.getApplicationContext();
            BaseIntentService.a(a, org.android.agoo.service.b.asInterface(ibinder));
            if (BaseIntentService.a(a) != null)
            {
                BaseIntentService.a(a).election(componentname.getPackageName(), AgooSettings.getAgooReleaseTime(), "token");
                BaseIntentService.a(a, componentname);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            aJ.d("BaseIntentService", "onServiceConnected", componentname);
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        aJ.c("BaseIntentService", (new StringBuilder()).append("electionDisconnected pack[").append(componentname.getPackageName()).append("]").toString());
        BaseIntentService.a(a, null);
    }

    ub(BaseIntentService baseintentservice)
    {
        a = baseintentservice;
        super();
    }
}
