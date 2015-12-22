// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import info.androidhive.proclubDaiict.service.Blog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

// Referenced classes of package info.androidhive.proclubDaiict:
//            MySQLiteHelper, CardArrayAdapter, Card

public class CategoryListView extends Activity
{
    public class asyncex extends AsyncTask
    {

        final CategoryListView this$0;

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
            this$0 = CategoryListView.this;
            super();
        }
    }


    public CategoryListView()
    {
    }

    protected void onCreate(final Bundle listView)
    {
        super.onCreate(listView);
        setContentView(0x7f030007);
        Object obj = getIntent().getExtras().getString("category");
        listView = (ListView)findViewById(0x7f0a0011);
        final MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(this);
        obj = mySQLiteHelper.getBlogCategory(((String) (obj)));
        CardArrayAdapter cardarrayadapter = new CardArrayAdapter(getApplicationContext(), 0x7f03000d);
        for (int i = 0; i < ((List) (obj)).size(); i++)
        {
            cardarrayadapter.add(new Card((String)((List) (obj)).get(i), ""));
        }

        listView.setAdapter(cardarrayadapter);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final CategoryListView this$0;
            final ListView val$listView;
            final MySQLiteHelper val$mySQLiteHelper;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                adapterview = new Intent("info.androidhive.slidingmenu.BLOGVIEW");
                Blog blog = mySQLiteHelper.getBlog(((Card)listView.getItemAtPosition(j)).getLine1());
                view = new Bundle();
                view.putString("Author", blog.getUsrername());
                view.putString("Title", blog.getTitle());
                view.putString("Content", blog.getContent());
                try
                {
                    view.putString("comment", (String)(new asyncex()).execute(new String[] {
                        (new StringBuilder()).append("https://public-api.wordpress.com/rest/v1.1/sites/proclubdaiict.wordpress.com/posts/").append(blog.getId()).append("/replies/").toString()
                    }).get());
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
                catch (ExecutionException executionexception)
                {
                    executionexception.printStackTrace();
                }
                adapterview.putExtras(view);
                startActivity(adapterview);
            }

            
            {
                this$0 = CategoryListView.this;
                mySQLiteHelper = mysqlitehelper;
                listView = listview;
                super();
            }
        });
    }
}
