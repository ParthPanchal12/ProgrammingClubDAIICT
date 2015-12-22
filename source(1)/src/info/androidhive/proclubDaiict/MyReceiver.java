// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;

// Referenced classes of package info.androidhive.proclubDaiict:
//            notifyService, MainActivity

public class MyReceiver extends BroadcastReceiver
{

    public MyReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "Action: ", 0).show();
        Object obj = intent.getExtras();
        intent = new notifyService();
        System.out.print(((Bundle) (obj)).getString("contest_name"));
        obj = Calendar.getInstance();
        int i = 0;
        do
        {
label0:
            {
                if (i < MainActivity.listEvents.size())
                {
                    if (((Calendar)MainActivity.timeList.get(i)).compareTo(((Calendar) (obj))) > 0)
                    {
                        break label0;
                    }
                    intent.creteNotification(context, (String)MainActivity.listEvents.get(i));
                    MainActivity.listEvents.remove(i);
                    MainActivity.timeList.remove(i);
                }
                return;
            }
            i++;
        } while (true);
    }
}
