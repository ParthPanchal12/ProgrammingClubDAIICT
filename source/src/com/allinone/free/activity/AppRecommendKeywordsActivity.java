// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.adapter.AppListviewAdapter;
import com.allinone.free.adapter.ApprecommendkeywordAdapter;
import com.allinone.free.adapter.AppsearchpromitAdapter;
import com.allinone.free.model.SearcherPromitModel;
import com.allinone.free.model.SearchkeywordModel;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.refresh.PullToRefreshLayout;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.DeletableEditText;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity

public class AppRecommendKeywordsActivity extends Activity
    implements android.view.View.OnClickListener, com.allinone.free.refresh.PullableListView.OnLoadListener, OnDismissCallback, AdListener
{
    class Mya1 extends AsyncTask
    {

        private String jsonData;
        final AppRecommendKeywordsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            try
            {
                appkeywords = URLEncoder.encode(appkeywords);
                jsonData = publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword=")).append(appkeywords).append("&page=").append(page).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            return jsonData;
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
            }
            try
            {
                ShowResult(s);
                ((RelativeLayout)listView.findViewById(0x7f0601a6)).setVisibility(0);
                listView.setVisibility(0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pomitlv.setVisibility(8);
            serchgridview.setVisibility(8);
            pulltoresult.setVisibility(0);
            progressheel.setVisibility(0);
        }

        Mya1()
        {
            this$0 = AppRecommendKeywordsActivity.this;
            super();
        }
    }

    class loadingSearchKeywords extends AsyncTask
    {

        final AppRecommendKeywordsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            list = new ArrayList();
            if (publicTools.isNetworkAvailable(AppRecommendKeywordsActivity.this))
            {
                return publicTools.getUrl("http://android.downloadatoz.com/_201409/market/top_keywords.php");
            } else
            {
                return null;
            }
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
            }
            try
            {
                list.addAll(Myutils.parseSearchKeywords(s));
                adapter = new ApprecommendkeywordAdapter(getApplicationContext(), list);
                serchgridview.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressheel.setVisibility(8);
                search_view.setHint(((SearchkeywordModel)list.get(0)).getKeyword());
                Myutils.getInstance();
                Myutils.hint = ((SearchkeywordModel)list.get(0)).getKeyword();
                Myutils.getInstance();
                Myutils.hintid = ((SearchkeywordModel)list.get(0)).getId();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressheel.setVisibility(0);
        }

        loadingSearchKeywords()
        {
            this$0 = AppRecommendKeywordsActivity.this;
            super();
        }
    }

    class loadpromittv extends AsyncTask
    {

        final AppRecommendKeywordsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            list2 = new ArrayList();
            if (publicTools.isNetworkAvailable(AppRecommendKeywordsActivity.this))
            {
                return publicTools.getUrl((new StringBuilder("https://market.android.com/suggest/SuggRequest?json=1&c=0&query=")).append(URLEncoder.encode(search_view.getText().toString())).append("&hl=en").toString());
            } else
            {
                return null;
            }
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
                list2.addAll(Myutils.parsearchpromitlist(s));
                adapterpromit = new AppsearchpromitAdapter(getApplicationContext(), list2);
                pomitlv.setAdapter(adapterpromit);
                adapterpromit.notifyDataSetChanged();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        loadpromittv()
        {
            this$0 = AppRecommendKeywordsActivity.this;
            super();
        }
    }


    private ApprecommendkeywordAdapter adapter;
    private AppsearchpromitAdapter adapterpromit;
    private AppListviewAdapter adapterresult;
    private String appkeywords;
    private BroadcastReceiver hideappsearch;
    private boolean isfa;
    private List list;
    private List list2;
    private PullableListView listView;
    private ArrayList listresult;
    private NativeAd nativeAd;
    private int next;
    private int page;
    private ListView pomitlv;
    private ProgressWheel progressheel;
    private PullToRefreshLayout pulltoresult;
    private DeletableEditText search_view;
    private ImageView searchfan;
    private ImageView searchimg;
    private GridView serchgridview;
    private BroadcastReceiver showappsearch;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

    public AppRecommendKeywordsActivity()
    {
        showappsearch = new BroadcastReceiver() {

            final AppRecommendKeywordsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressheel.setVisibility(0);
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        };
        hideappsearch = new BroadcastReceiver() {

            final AppRecommendKeywordsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressheel.setVisibility(8);
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        };
        appkeywords = "";
        listresult = new ArrayList();
        page = 1;
        next = 1;
        isfa = false;
    }

    private void ShowResult(String s)
    {
        listresult.addAll(Myutils.parseApplist(s));
        if (page == 1)
        {
            adapterresult = new AppListviewAdapter(this, listresult, "appsearch");
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapterresult);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        adapterresult.notifyDataSetChanged();
        progressheel.setVisibility(8);
    }

    private void buildListener()
    {
        searchfan.setOnClickListener(this);
        serchgridview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppRecommendKeywordsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                try
                {
                    (new Thread(i. new Runnable() {

                        final _cls4 this$1;
                        private final int val$position;

                        public void run()
                        {
                            String s = URLEncoder.encode(((SearchkeywordModel)list.get(position)).getKeyword());
                            publicTools.getUrl((new StringBuilder(String.valueOf("http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=app&title="))).append(s).toString());
                        }

            
            {
                this$1 = final__pcls4;
                position = I.this;
                super();
            }
                    })).start();
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview) { }
                adapterview = new Intent(AppRecommendKeywordsActivity.this, com/allinone/free/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((SearchkeywordModel)list.get(i)).getId());
                startActivity(adapterview);
            }


            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        pomitlv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppRecommendKeywordsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                try
                {
                    listresult.clear();
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview) { }
                try
                {
                    ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
                    appkeywords = ((SearcherPromitModel)list2.get(i)).getS();
                    ((RelativeLayout)listView.findViewById(0x7f0601a6)).setVisibility(8);
                    (new Mya1()).execute(new Void[0]);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    return;
                }
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        search_view.setOnKeyListener(new android.view.View.OnKeyListener() {

            final AppRecommendKeywordsActivity this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                try
                {
                    listresult.clear();
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                if (keyevent.getAction() != 0 || i != 66) goto _L2; else goto _L1
_L1:
                try
                {
                    ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                if (TextUtils.isEmpty(search_view.getText()))
                {
                    break MISSING_BLOCK_LABEL_153;
                }
                appkeywords = search_view.getText().toString();
                ((RelativeLayout)listView.findViewById(0x7f0601a6)).setVisibility(8);
                (new Mya1()).execute(new Void[0]);
_L3:
                try
                {
                    (new Thread(new Runnable() {

                        final _cls6 this$1;

                        public void run()
                        {
                            String s = URLEncoder.encode(search_view.getText().toString());
                            publicTools.getUrl((new StringBuilder(String.valueOf("http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=app&title="))).append(s).toString());
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    })).start();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return false;
                }
_L2:
                return false;
                try
                {
                    view = new Intent(AppRecommendKeywordsActivity.this, com/allinone/free/activity/AppDetailsActivity);
                    view.putExtra("myid", ((SearchkeywordModel)list.get(0)).getId());
                    startActivity(view);
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                  goto _L3
            }


            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        searchimg.setOnClickListener(new android.view.View.OnClickListener() {

            final AppRecommendKeywordsActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    listresult.clear();
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                try
                {
                    ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                try
                {
                    if (!TextUtils.isEmpty(search_view.getText()))
                    {
                        appkeywords = search_view.getText().toString();
                        ((RelativeLayout)listView.findViewById(0x7f0601a6)).setVisibility(8);
                        (new Mya1()).execute(new Void[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                view = new Intent(AppRecommendKeywordsActivity.this, com/allinone/free/activity/AppDetailsActivity);
                view.putExtra("myid", ((SearchkeywordModel)list.get(0)).getId());
                startActivity(view);
                return;
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        search_view.addTextChangedListener(new TextWatcher() {

            final AppRecommendKeywordsActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                Log.v("changetv", "333");
                if (TextUtils.isEmpty(search_view.getText()))
                {
                    serchgridview.setVisibility(0);
                    pomitlv.setVisibility(8);
                    pulltoresult.setVisibility(8);
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                Log.v("changetv", "111");
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                Log.v("changetv", "222");
                serchgridview.setVisibility(8);
                pulltoresult.setVisibility(8);
                (new loadpromittv()).execute(new Void[0]);
                pomitlv.setVisibility(0);
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
    }

    private void facebookad()
    {
        View view = getLayoutInflater().inflate(0x7f030027, null);
        listView.addHeaderView(view, null, false);
        Object obj = (ImageView)view.findViewById(0x7f0600b6);
        TextView textview = (TextView)view.findViewById(0x7f0600b7);
        Object obj1 = (TextView)view.findViewById(0x7f0600bd);
        obj1 = (TextView)view.findViewById(0x7f0600bb);
        TextView textview1 = (TextView)view.findViewById(0x7f0600b8);
        obj1 = (RatingBar)view.findViewById(0x7f0600b9);
        Object obj2 = (Button)view.findViewById(0x7f0600ba);
        obj2 = (TextView)view.findViewById(0x7f0600bc);
        textview.setText(nativeAd.getAdTitle());
        textview1.setText(nativeAd.getAdBody());
        NativeAd.downloadAndDisplayImage(nativeAd.getAdIcon(), ((ImageView) (obj)));
        obj = nativeAd.getAdStarRating();
        if (obj != null)
        {
            ((RatingBar) (obj1)).setVisibility(0);
            ((RatingBar) (obj1)).setNumStars((int)((com.facebook.ads.NativeAd.Rating) (obj)).getScale());
            ((RatingBar) (obj1)).setRating((float)((com.facebook.ads.NativeAd.Rating) (obj)).getValue());
        } else
        {
            ((RatingBar) (obj1)).setVisibility(8);
        }
        nativeAd.registerViewForInteraction(view);
    }

    private void init()
    {
        pomitlv = (ListView)findViewById(0x7f06025d);
        searchfan = (ImageView)findViewById(0x7f0601d7);
        serchgridview = (GridView)findViewById(0x7f0601d9);
        progressheel = (ProgressWheel)findViewById(0x7f060075);
        search_view = (DeletableEditText)findViewById(0x7f0601d8);
        searchimg = (ImageView)findViewById(0x7f0600ee);
        pulltoresult = (PullToRefreshLayout)findViewById(0x7f060060);
        listView = (PullableListView)findViewById(0x7f060073);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAd == null || nativeAd != ad)
        {
            return;
        } else
        {
            nativeAd.unregisterView();
            facebookad();
            isfa = true;
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131100119: 
            break;
        }
        if (pulltoresult.getVisibility() == 0)
        {
            pulltoresult.setVisibility(8);
            pomitlv.setVisibility(8);
            search_view.setText("");
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
        setContentView(0x7f03008d);
        init();
        buildListener();
        (new loadingSearchKeywords()).execute(new Void[0]);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppRecommendKeywordsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(AppRecommendKeywordsActivity.this, com/allinone/free/activity/AppDetailsActivity);
                if (!isfa)
                {
                    break MISSING_BLOCK_LABEL_59;
                }
                adapterview.putExtra("myid", ((DownloadMovieItem)listresult.get(i - 1)).getId());
_L1:
                startActivity(adapterview);
                return;
                try
                {
                    adapterview.putExtra("myid", ((DownloadMovieItem)listresult.get(i)).getId());
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    return;
                }
                  goto _L1
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        nativeAd = new NativeAd(this, "340186902832477_388101491374351");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        bundle = new IntentFilter();
        bundle.addAction("showappsearch");
        registerReceiver(showappsearch, bundle);
        bundle = new IntentFilter();
        bundle.addAction("hideappsearch");
        registerReceiver(hideappsearch, bundle);
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    public void onLoad(PullableListView pullablelistview)
    {
        if (listresult.size() > 0)
        {
            next = ((DownloadMovieItem)listresult.get(listresult.size() - 1)).getHas_next_page();
        }
        if (next == 1)
        {
            page = page + 1;
            (new Mya1()).execute(new Void[0]);
            return;
        } else
        {
            listView.setHasMoreData(false);
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
