// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Calendar;

// Referenced classes of package info.androidhive.proclubDaiict.service:
//            ScheduleService

public class ScheduleClient
{

    private ScheduleService mBoundService;
    private ServiceConnection mConnection;
    private Context mContext;
    private boolean mIsBound;

    public ScheduleClient(Context context)
    {
        mConnection = new ServiceConnection() {

            final ScheduleClient this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                mBoundService = ((ScheduleService.ServiceBinder)ibinder).getService();
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mBoundService = null;
            }

            
            {
                this$0 = ScheduleClient.this;
                super();
            }
        };
        mContext = context;
    }

    public void doBindService()
    {
        mContext.bindService(new Intent(mContext, info/androidhive/proclubDaiict/service/ScheduleService), mConnection, 1);
        mIsBound = true;
    }

    public void doUnbindService()
    {
        if (mIsBound)
        {
            mContext.unbindService(mConnection);
            mIsBound = false;
        }
    }

    public void setAlarmForNotification(Calendar calendar, String s)
    {
        mBoundService.setAlarm(calendar, s);
    }


/*
    static ScheduleService access$002(ScheduleClient scheduleclient, ScheduleService scheduleservice)
    {
        scheduleclient.mBoundService = scheduleservice;
        return scheduleservice;
    }

*/
}
