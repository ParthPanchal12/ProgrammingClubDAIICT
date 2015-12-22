// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package info.androidhive.proclubDaiict.service:
//            ScheduleClient

class this._cls0
    implements ServiceConnection
{

    final ScheduleClient this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        ScheduleClient.access$002(ScheduleClient.this, ((erviceBinder)ibinder).getService());
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        ScheduleClient.access$002(ScheduleClient.this, null);
    }

    erviceBinder()
    {
        this$0 = ScheduleClient.this;
        super();
    }
}
