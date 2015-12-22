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
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.adapter.AppListviewAdapter;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.BadgeView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import com.umeng.analytics.MobclickAgent;
import com.yeahmobi.android.interfaces.AdInterfaces;
import com.yeahmobi.android.shuffle.AdShuffle;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity, DownloadsActivity, AppDetailsActivity

public class AppSearchResultActivity extends Activity
    implements com.allinone.free.refresh.PullableListView.OnLoadListener, OnDismissCallback, android.view.View.OnClickListener, ContentValue, AdListener
{
    class Mya1 extends AsyncTask
    {

        final AppSearchResultActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            try
            {
                searchkeywords = URLEncoder.encode(searchkeywords);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword=")).append(searchkeywords).append("&page=").append(page).toString());
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
            this$0 = AppSearchResultActivity.this;
            super();
        }
    }


    private AdShuffle adShuffle;
    private AppListviewAdapter adapter;
    private RelativeLayout appsearchtop;
    private BadgeView badgedownimg;
    private FinalDBChen db;
    private List ds;
    private BroadcastReceiver hideappsearch;
    private String imbdownurl;
    private boolean isfbshow;
    private boolean isshowinmobi;
    private ArrayList list;
    private PullableListView listView;
    private ImageView mAnimImageView;
    private Animation mAnimation;
    private IMNative nativeAdaio;
    private NativeAd nativeAdfb;
    private int next;
    private int page;
    private ProgressWheel progressWheel;
    private ImageView resultsearchimg;
    private ImageView resulttodown;
    private ImageView resulttopgift;
    private ImageView searchfan;
    private String searchkeywords;
    private TextView searchtitle;
    private BroadcastReceiver showappsearch;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

    public AppSearchResultActivity()
    {
        showappsearch = new BroadcastReceiver() {

            final AppSearchResultActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
        };
        hideappsearch = new BroadcastReceiver() {

            final AppSearchResultActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
                try
                {
                    db = new FinalDBChen(AppSearchResultActivity.this, getDatabasePath("download2.db").getAbsolutePath());
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
                    (new AsyncTask() {

                        final _cls2 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient String doInBackground(Void avoid[])
                        {
                            return String.valueOf(ds.size());
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((String)obj);
                        }

                        protected void onPostExecute(String s)
                        {
                            super.onPostExecute(s);
                            mAnimImageView.setVisibility(0);
                            mAnimImageView.startAnimation(mAnimation);
                            badgedownimg.setText(s);
                            badgedownimg.show();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return;
                }
            }


            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
        };
        list = new ArrayList();
        progressWheel = null;
        page = 1;
        next = 1;
        searchkeywords = "";
        isfbshow = false;
        isshowinmobi = false;
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parseApplist(s));
        if (page == 1)
        {
            adapter = new AppListviewAdapter(this, list, "appsearch");
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void buildListener()
    {
        searchfan.setOnClickListener(this);
        resultsearchimg.setOnClickListener(this);
        resulttopgift.setOnClickListener(this);
        resulttodown.setOnClickListener(this);
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(resulttopgift);
    }

    private void init()
    {
        mAnimImageView = (ImageView)findViewById(0x7f060076);
        resulttodown = (ImageView)findViewById(0x7f060260);
        mAnimation = AnimationUtils.loadAnimation(this, 0x7f040006);
        badgedownimg = new BadgeView(getApplicationContext(), resulttodown);
        searchtitle = (TextView)findViewById(0x7f06025c);
        searchfan = (ImageView)findViewById(0x7f0601d7);
        resultsearchimg = (ImageView)findViewById(0x7f06025e);
        resulttopgift = (ImageView)findViewById(0x7f06025f);
        resulttodown = (ImageView)findViewById(0x7f060260);
        searchkeywords = getIntent().getStringExtra("searchkeywords");
        searchtitle.setText(searchkeywords);
        progressWheel = (ProgressWheel)findViewById(0x7f060075);
        listView = (PullableListView)findViewById(0x7f060073);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final AppSearchResultActivity this$0;

            public void onAnimationEnd(Animation animation)
            {
                mAnimImageView.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
        });
        (new Mya1()).execute(new Void[0]);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppSearchResultActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(AppSearchResultActivity.this, com/allinone/free/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)list.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
        });
        appsearchtop = (RelativeLayout)findViewById(0x7f0601d6);
    }

    private void inmobgift()
    {
        nativeAdaio = new IMNative("dd15bc6e28814b60a1b162840af80d88", new IMNativeListener() {

            final AppSearchResultActivity this$0;

            public void onNativeRequestFailed(IMErrorCode imerrorcode)
            {
                isshowinmobi = false;
            }

            public void onNativeRequestSucceeded(IMNative imnative)
            {
                nativeAdaio = imnative;
                Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
                if (imnative != null)
                {
                    imnative.attachToView(appsearchtop);
                }
                imnative = imnative.getContent();
                isshowinmobi = true;
                try
                {
                    imnative = new JSONObject(imnative);
                    imbdownurl = imnative.getString("landingURL");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (IMNative imnative)
                {
                    imnative.printStackTrace();
                }
            }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
        });
        nativeAdaio.loadAd();
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAdfb == null || nativeAdfb != ad)
        {
            return;
        } else
        {
            nativeAdfb.unregisterView();
            facebookad();
            isfbshow = true;
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
            finish();
            return;

        case 2131100254: 
            startActivity(new Intent(this, com/allinone/free/activity/AppRecommendKeywordsActivity));
            return;

        case 2131100255: 
            if (isfbshow)
            {
                Toast.makeText(getApplicationContext(), "facebook", 1).show();
                return;
            } else
            {
                Toast.makeText(getApplicationContext(), "Loading...", 1).show();
                adShuffle.loadAds(false);
                return;
            }

        case 2131100256: 
            startActivity(new Intent(this, com/allinone/free/activity/DownloadsActivity));
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030090);
        init();
        buildListener();
        bundle = new IntentFilter();
        bundle.addAction("showappsearch");
        registerReceiver(showappsearch, bundle);
        bundle = new IntentFilter();
        bundle.addAction("hideappsearch");
        registerReceiver(hideappsearch, bundle);
        AdInterfaces.setAppInfo("779", "1237");
        adShuffle = AdInterfaces.getAdShffle(this);
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onError(Ad ad, AdError aderror)
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
            listView.setHasMoreData(false);
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
        MobclickAgent.onResume(this);
        db = new FinalDBChen(this, getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
        int i = ds.size();
        if (i != 0)
        {
            badgedownimg.setText(String.valueOf(i));
            badgedownimg.show();
        } else
        if (i == 0)
        {
            badgedownimg.hide();
            return;
        }
    }

















}
