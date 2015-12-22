// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import info.androidhive.proclubDaiict.service.ScheduleClient;
import java.util.ArrayList;
import java.util.Calendar;

// Referenced classes of package info.androidhive.proclubDaiict:
//            Events, MainActivity, MyReceiver

class this._cls0
    implements android.widget.ew.OnItemClickListener
{

    final Events this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        (new ScheduleClient(getActivity())).doBindService();
        String as[] = ((String)listView.getItemAtPosition(i)).split("\n");
        adapterview = as[3].split(" ");
        view = Calendar.getInstance();
        String as1[] = adapterview[0].split("-");
        view.set(Integer.parseInt(as1[0]), Integer.parseInt(as1[1]) - 1, Integer.parseInt(as1[2]));
        as1 = adapterview[1].split(":");
        view.set(11, Integer.parseInt(as1[0]));
        view.set(12, Integer.parseInt(as1[1]));
        view.set(13, Integer.parseInt(as1[2]));
        MainActivity.timeList.add(view);
        MainActivity.listEvents.add(as[0]);
        Object obj = new Intent(getActivity(), info/androidhive/proclubDaiict/MyReceiver);
        obj = PendingIntent.getBroadcast(getActivity(), 0, ((Intent) (obj)), 0);
        Activity activity = getActivity();
        getActivity();
        ((AlarmManager)activity.getSystemService("alarm")).set(0, view.getTimeInMillis(), ((PendingIntent) (obj)));
        Toast.makeText(getActivity(), (new StringBuilder()).append("Notification set for: ").append(Integer.parseInt(adapterview[3])).append("/").append(Integer.parseInt(adapterview[4])).append("/").append(Integer.parseInt(adapterview[5])).toString(), 0).show();
    }

    r()
    {
        this$0 = Events.this;
        super();
    }
}
