// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import info.androidhive.proclubDaiict.service.Blog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package info.androidhive.proclubDaiict:
//            MySQLiteHelper, SpecialAdapter

public class Announcements extends Fragment
{
    public class asyncex extends AsyncTask
    {

        final Announcements this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            String as1[];
            as = "";
            as1 = as;
            Object obj = (HttpURLConnection)(new URL("https://public-api.wordpress.com/rest/v1.1/sites/proclubannouncementdaiict.wordpress.com/posts?number=30")).openConnection();
            as1 = as;
            ((HttpURLConnection) (obj)).setRequestMethod("GET");
            as1 = as;
            ((HttpURLConnection) (obj)).setRequestProperty("Accept", "text/json");
            as1 = as;
            ((HttpURLConnection) (obj)).getResponseCode();
            as1 = as;
            obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L2:
            as1 = as;
            String s = ((BufferedReader) (obj)).readLine();
            if (s == null)
            {
                break; /* Loop/switch isn't completed */
            }
            as1 = as;
            as = (new StringBuilder()).append(as).append(s).toString();
            if (true) goto _L2; else goto _L1
_L1:
            as1 = as;
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                as.printStackTrace();
                as = as1;
            }
            System.out.println("done");
            return as;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            System.out.println("post");
            super.onPostExecute(s);
            try
            {
                System.out.println("try");
                System.out.println((new StringBuilder()).append("yyyyyyyyy").append(jArray.length()).toString());
                u = 30;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }

        public asyncex()
        {
            this$0 = Announcements.this;
            super();
        }
    }


    String TableName;
    ArrayList arr;
    JSONArray jArray;
    ListView listView;
    SQLiteDatabase myDB;
    int u;
    ArrayList values;

    public Announcements()
    {
        myDB = null;
        jArray = null;
        TableName = "ANNOUNCEMETS";
        u = 0;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Object obj;
        final MySQLiteHelper mySQLiteHelper;
        mySQLiteHelper = new MySQLiteHelper(getActivity());
        obj = new asyncex();
        bundle = null;
        String as[] = new String[3];
        obj = (new JSONObject((String)((asyncex) (obj)).execute(new String[] {
            "https://public-api.wordpress.com/rest/v1.1/sites/proclubannouncementdaiict.wordpress.com/posts?number=100"
        }).get())).getJSONArray("posts");
        bundle = ((Bundle) (obj));
_L2:
        layoutinflater = layoutinflater.inflate(0x7f03000b, viewgroup, false);
        arr = new ArrayList();
        values = new ArrayList();
        listView = (ListView)layoutinflater.findViewById(0x7f0a0012);
        viewgroup = mySQLiteHelper.getAllAnnouncMent();
        for (int i = 0; i < viewgroup.size(); i++)
        {
            obj = ((Blog)viewgroup.get(i)).getTitle();
            ((Blog)viewgroup.get(i)).getContent();
            values.add(0, obj);
            arr.add(0, Integer.valueOf(0));
        }

        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Toast.makeText(getActivity().getApplicationContext(), "No Intenet Connection Please connect to Internet", 1).show();
        exception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        if (bundle == null) goto _L4; else goto _L3
_L3:
        int j = 0;
_L8:
        if (j >= bundle.length()) goto _L4; else goto _L5
_L5:
        viewgroup = Html.fromHtml(((JSONObject)bundle.get(j)).getString("content")).toString();
        exception = ((JSONObject)bundle.get(j)).getString("title");
        int k;
        boolean flag1;
        flag1 = false;
        k = 0;
_L6:
        boolean flag = flag1;
        if (k >= values.size())
        {
            break MISSING_BLOCK_LABEL_318;
        }
        if (!((String)values.get(k)).equals(exception))
        {
            break MISSING_BLOCK_LABEL_383;
        }
        flag = true;
        if (!flag)
        {
            try
            {
                values.add(0, exception);
                arr.add(0, Integer.valueOf(1));
                Blog blog = new Blog();
                blog.setContent(viewgroup);
                blog.setTitle(exception);
                mySQLiteHelper.createAnnouncement(blog);
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                viewgroup.printStackTrace();
            }
        }
        j++;
        continue; /* Loop/switch isn't completed */
        k++;
        if (true) goto _L6; else goto _L4
_L4:
        viewgroup = new SpecialAdapter(getActivity(), 0x1090003, 0x1020014, values);
        viewgroup.getData(arr);
        listView.setAdapter(viewgroup);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Announcements this$0;
            final MySQLiteHelper val$mySQLiteHelper;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                List list = mySQLiteHelper.getAllAnnouncMent();
                String s = (String)listView.getItemAtPosition(l);
                Object obj1 = "";
                Object obj2 = null;
                int i1 = 0;
                do
                {
label0:
                    {
                        view = obj2;
                        adapterview = ((AdapterView) (obj1));
                        if (!"".equals(s))
                        {
                            if (!s.equals(((Blog)list.get(i1)).getTitle()))
                            {
                                break label0;
                            }
                            adapterview = ((Blog)list.get(i1)).getTitle();
                            view = ((Blog)list.get(i1)).getContent();
                        }
                        obj1 = new Bundle();
                        ((Bundle) (obj1)).putString("Title", adapterview);
                        ((Bundle) (obj1)).putString("Content", view);
                        adapterview = new Intent("info.androidhive.slidingmenu.ANNOUNCEMENTVIEW");
                        adapterview.putExtras(((Bundle) (obj1)));
                        startActivity(adapterview);
                        Toast.makeText(getActivity().getApplicationContext(), (new StringBuilder()).append("Position :").append(l).append("  ListItem : ").append(s).toString(), 1).show();
                        return;
                    }
                    i1++;
                } while (true);
            }

            
            {
                this$0 = Announcements.this;
                mySQLiteHelper = mysqlitehelper;
                super();
            }
        });
        return layoutinflater;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
