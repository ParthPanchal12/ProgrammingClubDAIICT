// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.allinone.free.adapter.TodaypickListviewAdapter;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity, AppDetailsActivity

public class TodaysPickActivity extends BaseActivity
    implements android.view.View.OnClickListener, com.allinone.free.refresh.PullableListView.OnLoadListener, OnDismissCallback, ContentValue
{
    class Mya1 extends AsyncTask
    {

        final TodaysPickActivity this$0;
        private String url;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            if (todayid != null)
            {
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=rs&id=")).append(todayid).append("&page=").append(page).toString();
            } else
            {
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=")).append(page).toString();
            }
            return publicTools.getUrl(url);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (s == null)
            {
                return;
            } else
            {
                ShowResult(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya1()
        {
            this$0 = TodaysPickActivity.this;
            super();
        }
    }


    private TodaypickListviewAdapter adapter;
    private BroadcastReceiver hidetodayapp;
    private ArrayList list;
    private int next;
    private int page;
    private ProgressWheel progressWheel;
    private BroadcastReceiver showtodayapp;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
    private Boolean todayboolean;
    private ImageView todayfan;
    private String todayid;
    private PullableListView todaypicklv;

    public TodaysPickActivity()
    {
        progressWheel = null;
        page = 1;
        next = 1;
        list = new ArrayList();
        todayboolean = Boolean.valueOf(false);
        showtodayapp = new BroadcastReceiver() {

            final TodaysPickActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        };
        hidetodayapp = new BroadcastReceiver() {

            final TodaysPickActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        };
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parsetodaypick(s));
        if (page == 1)
        {
            adapter = new TodaypickListviewAdapter(this, list, "todaypick");
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(todaypicklv);
            todaypicklv.setAdapter(swingBottomInAnimationAdapter);
        }
        todaypicklv.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void buildListener()
    {
        todayfan.setOnClickListener(this);
    }

    private void init()
    {
        todayfan = (ImageView)findViewById(0x7f060264);
        todaypicklv = (PullableListView)findViewById(0x7f060265);
        progressWheel = (ProgressWheel)findViewById(0x7f060075);
        todaypicklv.setOnLoadListener(this);
        todaypicklv.setHasMoreData(false);
        (new Mya1()).execute(new Void[0]);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131100260: 
            break;
        }
        if (todayboolean.booleanValue())
        {
            startActivity(new Intent(this, com/allinone/free/activity/MyMainActivity));
            finish();
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030093);
        try
        {
            todayid = getIntent().getStringExtra("todayid");
            todayboolean = Boolean.valueOf(getIntent().getBooleanExtra("todayboolean", false));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        init();
        buildListener();
        bundle = new IntentFilter();
        bundle.addAction("showtodayapp");
        registerReceiver(showtodayapp, bundle);
        bundle = new IntentFilter();
        bundle.addAction("hidetodayapp");
        registerReceiver(hidetodayapp, bundle);
        todaypicklv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final TodaysPickActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(TodaysPickActivity.this, com/allinone/free/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)list.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        });
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onLoad(PullableListView pullablelistview)
    {
        if (list.size() > 0)
        {
            next = ((DownloadMovieItem)list.get(list.size() - 1)).getHas_next_page();
        }
        if (next == 1)
        {
            page = page + 1;
            (new Mya1()).execute(new Void[0]);
            return;
        } else
        {
            todaypicklv.setHasMoreData(false);
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }





}
