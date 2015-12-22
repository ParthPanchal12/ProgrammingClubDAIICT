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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package info.androidhive.proclubDaiict:
//            MySQLiteHelper, CardArrayAdapter, Card

public class BlogListView extends Fragment
{
    public class asyncex extends AsyncTask
    {

        final BlogListView this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            String s = "";
            as = as[0];
            Object obj = s;
            BufferedReader bufferedreader;
            try
            {
                as = (HttpURLConnection)(new URL(as)).openConnection();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                as.printStackTrace();
                return ((String) (obj));
            }
            obj = s;
            as.setRequestMethod("GET");
            obj = s;
            as.setRequestProperty("Accept", "text/json");
            obj = s;
            as.getResponseCode();
            obj = s;
            bufferedreader = new BufferedReader(new InputStreamReader(as.getInputStream()));
            as = s;
_L2:
            obj = as;
            s = bufferedreader.readLine();
            if (s == null)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = as;
            as = (new StringBuilder()).append(as).append(s).toString();
            if (true) goto _L2; else goto _L1
_L1:
            obj = as;
            bufferedreader.close();
            return as;
        }

        public asyncex()
        {
            this$0 = BlogListView.this;
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

    public BlogListView()
    {
        myDB = null;
        jArray = null;
        TableName = "BLOG2";
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
            "https://public-api.wordpress.com/rest/v1.1/sites/proclubdaiict.wordpress.com/posts?number=100"
        }).get())).getJSONArray("posts");
        bundle = ((Bundle) (obj));
_L2:
        layoutinflater = layoutinflater.inflate(0x7f030009, viewgroup, false);
        arr = new ArrayList();
        values = new ArrayList();
        listView = (ListView)layoutinflater.findViewById(0x7f0a0013);
        viewgroup = new CardArrayAdapter(getActivity().getApplicationContext(), 0x7f03000d);
        obj = mySQLiteHelper.getAllBlog();
        for (int i = 0; i < ((List) (obj)).size(); i++)
        {
            ((Blog)((List) (obj)).get(i)).getUsrername();
            Object obj1 = ((Blog)((List) (obj)).get(i)).getTitle();
            ((Blog)((List) (obj)).get(i)).getId();
            String s1 = ((Blog)((List) (obj)).get(i)).getContent();
            ((Blog)((List) (obj)).get(i)).getComment();
            ((Blog)((List) (obj)).get(i)).getTag();
            obj1 = new Card(((String) (obj1)), s1);
            values.add(0, obj1);
            viewgroup.add(((Card) (obj1)));
            arr.add(0, Integer.valueOf(0));
        }

        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Toast.makeText(getActivity().getApplicationContext(), "No Intenet Connection\n Please connect to Internet\n", 1).show();
        exception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        if (bundle == null) goto _L4; else goto _L3
_L3:
        int j = 0;
_L8:
        if (j >= bundle.length()) goto _L4; else goto _L5
_L5:
        String s;
        String s2;
        String s3;
        int l;
        exception = ((JSONObject)((JSONObject)bundle.get(j)).get("author")).getString("name");
        s = Html.fromHtml(((JSONObject)bundle.get(j)).getString("content")).toString();
        s2 = ((JSONObject)bundle.get(j)).getString("title");
        s3 = ((JSONObject)bundle.get(j)).getString("categories").split("\"")[1];
        l = Integer.parseInt(((JSONObject)bundle.get(j)).getString("ID"));
        int k;
        boolean flag1;
        flag1 = false;
        k = 0;
_L6:
        boolean flag = flag1;
        if (k >= values.size())
        {
            break MISSING_BLOCK_LABEL_493;
        }
        if (!((Card)values.get(k)).getLine1().equals(s2))
        {
            break MISSING_BLOCK_LABEL_599;
        }
        flag = true;
        if (!flag)
        {
            try
            {
                Object obj2 = new Card(s2, s);
                viewgroup.add(((Card) (obj2)));
                values.add(0, obj2);
                arr.add(0, Integer.valueOf(1));
                obj2 = new Blog();
                ((Blog) (obj2)).setUsrername(exception);
                ((Blog) (obj2)).setContent(s);
                ((Blog) (obj2)).setTitle(s2);
                ((Blog) (obj2)).setId(l);
                ((Blog) (obj2)).setTag(s3);
                mySQLiteHelper.createBlog(((Blog) (obj2)));
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        j++;
        continue; /* Loop/switch isn't completed */
        k++;
        if (true) goto _L6; else goto _L4
_L4:
        listView.setAdapter(viewgroup);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BlogListView this$0;
            final MySQLiteHelper val$mySQLiteHelper;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                List list = mySQLiteHelper.getAllBlog();
                Card card = (Card)listView.getItemAtPosition(i1);
                Object obj3 = "";
                String s5 = "";
                Object obj4 = null;
                boolean flag2 = false;
                int j1 = 0;
                do
                {
label0:
                    {
                        String s4 = obj4;
                        view = s5;
                        adapterview = ((AdapterView) (obj3));
                        int k1 = ((flag2) ? 1 : 0);
                        if (!"".equals(card.getLine1()))
                        {
                            if (!card.getLine1().equals(((Blog)list.get(j1)).getTitle()))
                            {
                                break label0;
                            }
                            adapterview = ((Blog)list.get(j1)).getUsrername();
                            view = ((Blog)list.get(j1)).getTitle();
                            k1 = ((Blog)list.get(j1)).getId();
                            s4 = ((Blog)list.get(j1)).getContent();
                            ((Blog)list.get(j1)).getComment();
                            ((Blog)list.get(j1)).getTag();
                        }
                        obj3 = new Bundle();
                        ((Bundle) (obj3)).putString("Author", adapterview);
                        ((Bundle) (obj3)).putString("Title", view);
                        ((Bundle) (obj3)).putString("Content", s4);
                        try
                        {
                            ((Bundle) (obj3)).putString("comment", (String)(new asyncex()).execute(new String[] {
                                (new StringBuilder()).append("https://public-api.wordpress.com/rest/v1.1/sites/proclubdaiict.wordpress.com/posts/").append(k1).append("/replies/").toString()
                            }).get());
                        }
                        // Misplaced declaration of an exception variable
                        catch (AdapterView adapterview)
                        {
                            adapterview.printStackTrace();
                        }
                        // Misplaced declaration of an exception variable
                        catch (AdapterView adapterview)
                        {
                            adapterview.printStackTrace();
                        }
                        adapterview = new Intent("info.androidhive.slidingmenu.BLOGVIEW");
                        adapterview.putExtras(((Bundle) (obj3)));
                        startActivity(adapterview);
                        Toast.makeText(getActivity().getApplicationContext(), (new StringBuilder()).append("Position :").append(i1).append("  ListItem : ").append(card).toString(), 1).show();
                        return;
                    }
                    j1++;
                } while (true);
            }

            
            {
                this$0 = BlogListView.this;
                mySQLiteHelper = mysqlitehelper;
                super();
            }
        });
        return layoutinflater;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
