// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import info.androidhive.proclubDaiict.service.ScheduleClient;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package info.androidhive.proclubDaiict:
//            Event, MainActivity, MyReceiver

public class Events extends Fragment
{
    public class asyncex extends AsyncTask
    {

        final Events this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            int i;
            arr = new ArrayList();
            as = new URL("https://www.hackerrank.com/calendar/feed.rss");
            xmlFactoryObject = XmlPullParserFactory.newInstance();
            myparser = xmlFactoryObject.newPullParser();
            myparser.setInput(as.openConnection().getInputStream(), "UTF_8");
            i = myparser.getEventType();
            boolean flag1;
            flag1 = false;
            as = null;
_L7:
            myparser;
            if (i == 1) goto _L2; else goto _L1
_L1:
            myparser;
            if (i != 2) goto _L4; else goto _L3
_L3:
            if (!myparser.getName().equalsIgnoreCase("item")) goto _L6; else goto _L5
_L5:
            boolean flag = true;
            Object obj = new Event();
_L11:
            i = myparser.next();
            as = ((String []) (obj));
            flag1 = flag;
              goto _L7
_L6:
            if (!myparser.getName().equalsIgnoreCase("title")) goto _L9; else goto _L8
_L8:
            obj = as;
            flag = flag1;
            if (!flag1) goto _L11; else goto _L10
_L10:
            as.setTitle(myparser.nextText());
            obj = as;
            flag = flag1;
              goto _L11
            as;
            as.printStackTrace();
_L2:
            return null;
_L9:
            if (!myparser.getName().equalsIgnoreCase("description"))
            {
                break MISSING_BLOCK_LABEL_296;
            }
            obj = as;
            flag = flag1;
            if (!flag1) goto _L11; else goto _L12
_L12:
            as.setDescription(myparser.nextText());
            obj = as;
            flag = flag1;
              goto _L11
            as;
            as.printStackTrace();
              goto _L2
            if (!myparser.getName().equalsIgnoreCase("url"))
            {
                break MISSING_BLOCK_LABEL_358;
            }
            obj = as;
            flag = flag1;
            if (!flag1) goto _L11; else goto _L13
_L13:
            as.setUrl(myparser.nextText());
            obj = as;
            flag = flag1;
              goto _L11
            as;
            as.printStackTrace();
              goto _L2
            if (!myparser.getName().equalsIgnoreCase("startTime"))
            {
                break MISSING_BLOCK_LABEL_412;
            }
            obj = as;
            flag = flag1;
            if (!flag1) goto _L11; else goto _L14
_L14:
            as.setStartTime(myparser.nextText());
            obj = as;
            flag = flag1;
              goto _L11
            obj = as;
            flag = flag1;
            if (!myparser.getName().equalsIgnoreCase("endTime")) goto _L11; else goto _L15
_L15:
            obj = as;
            flag = flag1;
            if (!flag1) goto _L11; else goto _L16
_L16:
            as.setEndTime(myparser.nextText());
            obj = as;
            flag = flag1;
              goto _L11
_L4:
            obj = as;
            flag = flag1;
            if (i != 3) goto _L11; else goto _L17
_L17:
            obj = as;
            flag = flag1;
            if (!myparser.getName().equalsIgnoreCase("item")) goto _L11; else goto _L18
_L18:
            flag = false;
            arr.add(0, as);
            obj = as;
              goto _L11
        }

        public asyncex()
        {
            this$0 = Events.this;
            super();
        }
    }


    String TableName;
    public ArrayList arr;
    JSONArray jArray;
    ListView listView;
    SQLiteDatabase myDB;
    private XmlPullParser myparser;
    private PendingIntent pendingIntent;
    ScheduleClient scheduleClient;
    int u;
    ArrayList values;
    private XmlPullParserFactory xmlFactoryObject;

    public Events()
    {
        myDB = null;
        jArray = null;
        TableName = "EVENTS2";
        u = 0;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030008, viewgroup, false);
        values = new ArrayList();
        listView = (ListView)layoutinflater.findViewById(0x7f0a0012);
        viewgroup = new asyncex();
        bundle = new String[3];
        viewgroup = (String)viewgroup.execute(new String[0]).get();
        int i = 0;
_L2:
        if (i >= arr.size())
        {
            break; /* Loop/switch isn't completed */
        }
        System.out.println(((Event)arr.get(i)).getTitle());
        i++;
        if (true) goto _L2; else goto _L1
        viewgroup;
        viewgroup.printStackTrace();
_L1:
        try
        {
            myDB = getActivity().openOrCreateDatabase("PROCLUBDAIICT1", 0, null);
            myDB.execSQL("CREATE TABLE IF NOT EXISTS EVENTS2 ( TITLE VARCHAR ,DESCRIPTION VARCHAR, LINK VARCHAR , STARTTIME VARCHAR,ENDTIME VARCHAR);");
            viewgroup = myDB.rawQuery((new StringBuilder()).append("SELECT * FROM ").append(TableName).toString(), null);
            i = viewgroup.getColumnIndex("TITLE");
            int j = viewgroup.getColumnIndex("DESCRIPTION");
            int l = viewgroup.getColumnIndex("LINK");
            int i1 = viewgroup.getColumnIndex("STARTTIME");
            int j1 = viewgroup.getColumnIndex("ENDTIME");
            viewgroup.moveToFirst();
            String s;
            String s1;
            String s2;
            String s3;
            for (; viewgroup.moveToNext(); values.add((new StringBuilder()).append(bundle).append("\n").append(s).append("\n").append(s1).append("\nStart Time: ").append(s2).append("\nEnd Time: ").append(s3).toString()))
            {
                bundle = viewgroup.getString(i);
                s = viewgroup.getString(j);
                s1 = viewgroup.getString(l);
                s2 = viewgroup.getString(i1);
                s3 = viewgroup.getString(j1);
            }

        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        i = 0;
_L3:
        int k;
        boolean flag1;
        if (i >= arr.size())
        {
            break MISSING_BLOCK_LABEL_745;
        }
        flag1 = false;
        k = 0;
_L4:
        boolean flag = flag1;
        if (k < values.size())
        {
            if (!((String)values.get(k)).split("\n")[0].equals(((Event)arr.get(i)).getTitle()))
            {
                break MISSING_BLOCK_LABEL_736;
            }
            flag = true;
        }
        if (!flag)
        {
            values.add((new StringBuilder()).append(((Event)arr.get(i)).getTitle()).append("\n").append(((Event)arr.get(i)).getDescription()).append("\n").append(((Event)arr.get(i)).getUrl()).append("\nStart Time: ").append(((Event)arr.get(i)).getStartTime()).append("\nEnd Time: ").append(((Event)arr.get(i)).getEndTime()).toString());
            myDB.execSQL((new StringBuilder()).append("INSERT INTO ").append(TableName).append(" (TITLE,DESCRIPTION,LINK,STARTTIME,ENDTIME)").append(" VALUES ('").append(((Event)arr.get(i)).getTitle()).append("', '").append(((Event)arr.get(i)).getDescription()).append("', '").append(((Event)arr.get(i)).getUrl()).append("', '").append(((Event)arr.get(i)).getStartTime()).append("', '").append(((Event)arr.get(i)).getEndTime()).append("');").toString());
        }
        i++;
          goto _L3
        viewgroup;
        viewgroup.printStackTrace();
          goto _L1
        k++;
          goto _L4
        viewgroup = new ArrayAdapter(getActivity(), 0x1090003, 0x1020014, values);
        listView.setAdapter(viewgroup);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Events this$0;

            public void onItemClick(AdapterView adapterview, View view, int k1, long l1)
            {
                (new ScheduleClient(getActivity())).doBindService();
                String as[] = ((String)listView.getItemAtPosition(k1)).split("\n");
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

            
            {
                this$0 = Events.this;
                super();
            }
        });
        return layoutinflater;
          goto _L3
    }



/*
    static XmlPullParserFactory access$002(Events events, XmlPullParserFactory xmlpullparserfactory)
    {
        events.xmlFactoryObject = xmlpullparserfactory;
        return xmlpullparserfactory;
    }

*/



/*
    static XmlPullParser access$102(Events events, XmlPullParser xmlpullparser)
    {
        events.myparser = xmlpullparser;
        return xmlpullparser;
    }

*/
}
