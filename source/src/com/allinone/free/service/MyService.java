// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import com.allinone.free.db.TypeDbUtils;

public class MyService extends Service
{

    private TypeDbUtils dbUtils;
    AlarmManager mAlarmManager;
    PendingIntent mPendingIntent;

    public MyService()
    {
        mAlarmManager = null;
        mPendingIntent = null;
        dbUtils = null;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        Intent intent = new Intent(getApplicationContext(), com/allinone/free/service/MyService);
        mAlarmManager = (AlarmManager)getSystemService("alarm");
        mPendingIntent = PendingIntent.getService(this, 0, intent, 0x10000000);
        long l = System.currentTimeMillis();
        mAlarmManager.setInexactRepeating(1, l, 0x1499700L, mPendingIntent);
        super.onCreate();
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        (new AsyncTask() {

            final MyService this$0;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                try
                {
                    Thread.sleep(0x1499700L);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
                return null;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            protected void onPostExecute(Void void1)
            {
                super.onPostExecute(void1);
                dbUtils.queryfile2();
            }

            
            {
                this$0 = MyService.this;
                super();
            }
        }).execute(new Void[0]);
        return 1;
    }

}
