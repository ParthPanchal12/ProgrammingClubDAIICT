// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.allinone.free.activity.AppDetailsActivity;
import com.allinone.free.adapter.AppListviewAdapter;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

public class PaidNewAppsFragment extends Fragment
    implements com.allinone.free.refresh.PullableListView.OnLoadListener, OnDismissCallback, ContentValue, AdListener
{
    class Mya1 extends AsyncTask
    {

        final PaidNewAppsFragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_new_app&page=")).append(page).toString());
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
                isshow = false;
                return;
            } else
            {
                ShowResult(s);
                isshow = true;
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
            this$0 = PaidNewAppsFragment.this;
            super();
        }
    }


    private AppListviewAdapter adapter;
    private BroadcastReceiver hidepaid3;
    private boolean isfa;
    private boolean isshow;
    private ArrayList list;
    private PullableListView listView;
    private NativeAd nativeAd;
    private int next;
    private int page;
    private ProgressWheel progressWheel;
    private BroadcastReceiver showpaid3;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

    public PaidNewAppsFragment()
    {
        showpaid3 = new BroadcastReceiver() {

            final PaidNewAppsFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = PaidNewAppsFragment.this;
                super();
            }
        };
        hidepaid3 = new BroadcastReceiver() {

            final PaidNewAppsFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
            }

            
            {
                this$0 = PaidNewAppsFragment.this;
                super();
            }
        };
        list = new ArrayList();
        progressWheel = null;
        page = 1;
        next = 1;
        isfa = false;
        isshow = false;
    }

    private void ApppopulistViewbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)listView.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50F));
        listView.setLayoutParams(layoutparams);
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parseApplist(s));
        if (page == 1)
        {
            adapter = new AppListviewAdapter(getActivity(), list, "paid3");
            listView.setAdapter(adapter);
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void facebookad()
    {
        View view = View.inflate(getActivity(), 0x7f030027, null);
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

    private void failfile()
    {
        publicTools.app_popular_handler = new Handler() {

            private String content;
            private String id;
            private String size;
            final PaidNewAppsFragment this$0;

            public void handleMessage(Message message)
            {
                id = message.getData().getString("id");
                size = message.getData().getString("size");
                content = message.getData().getString("content");
                message.what;
                JVM INSTR tableswitch 1212 1212: default 60
            //                           1212 66;
                   goto _L1 _L2
_L1:
                super.handleMessage(message);
                return;
_L2:
                (new Thread(new Runnable() {

                    final _cls3 this$1;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=action=download_invalid&type=app&id=")).append(id).append("&size=").append(size).append("&content=").append(content).toString());
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                })).start();
                if (true) goto _L1; else goto _L3
_L3:
            }




            
            {
                this$0 = PaidNewAppsFragment.this;
                super();
            }
        };
    }

    private void init(View view)
    {
        progressWheel = (ProgressWheel)view.findViewById(0x7f060075);
        listView = (PullableListView)view.findViewById(0x7f060073);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        (new Mya1()).execute(new Void[0]);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PaidNewAppsFragment this$0;

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/allinone/free/activity/AppDetailsActivity);
                if (!isfa)
                {
                    break MISSING_BLOCK_LABEL_62;
                }
                adapterview.putExtra("myid", ((DownloadMovieItem)list.get(i - 1)).getId());
_L1:
                startActivity(adapterview);
                return;
                try
                {
                    adapterview.putExtra("myid", ((DownloadMovieItem)list.get(i)).getId());
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    return;
                }
                  goto _L1
            }

            
            {
                this$0 = PaidNewAppsFragment.this;
                super();
            }
        });
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAd == null || nativeAd != ad)
        {
            return;
        }
        nativeAd.unregisterView();
        try
        {
            if (isshow)
            {
                facebookad();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Ad ad) { }
        isfa = true;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030024, null, false);
        Myutils.getInstance();
        Myutils.type_current = "app_popular";
        init(layoutinflater);
        failfile();
        ApppopulistViewbottom();
        viewgroup = new IntentFilter();
        viewgroup.addAction("showpaid3");
        getActivity().registerReceiver(showpaid3, viewgroup);
        viewgroup = new IntentFilter();
        viewgroup.addAction("hidepaid3");
        getActivity().registerReceiver(hidepaid3, viewgroup);
        nativeAd = new NativeAd(getActivity(), "340186902832477_388101491374351");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        return layoutinflater;
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
        MobclickAgent.onPause(getActivity());
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }






}
