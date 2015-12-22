// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.allinone.free.adapter.Home_Listview_Adapter;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.ImageUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public class GameFeaturedFragment extends Fragment
    implements com.allinone.free.refresh.PullableListView.OnLoadListener, OnDismissCallback, ContentValue
{
    class Mya1 extends AsyncTask
    {

        final GameFeaturedFragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=game&page=")).append(page).toString());
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
            this$0 = GameFeaturedFragment.this;
            super();
        }
    }

    class Mya3 extends AsyncTask
    {

        final GameFeaturedFragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl("http://welaf.com/fun/list.php?recommend=1&page=1");
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
                ShowResult1(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya3()
        {
            this$0 = GameFeaturedFragment.this;
            super();
        }
    }


    private AdView adView;
    private Home_Listview_Adapter adapter;
    private Bitmap bitmap;
    private LinearLayout facebookbanner;
    private int h;
    private BroadcastReceiver hideapp1;
    private ImageView imginmobibanner;
    private LinearLayout inmobbanner;
    private ArrayList list;
    private PullableListView listView;
    ArrayList list_fun;
    private IMNative nativeAdaio;
    private int next;
    private int page;
    private ProgressWheel progressWheel;
    private BroadcastReceiver showapp1;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
    private int w;

    public GameFeaturedFragment()
    {
        showapp1 = new BroadcastReceiver() {

            final GameFeaturedFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = GameFeaturedFragment.this;
                super();
            }
        };
        hideapp1 = new BroadcastReceiver() {

            final GameFeaturedFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
            }

            
            {
                this$0 = GameFeaturedFragment.this;
                super();
            }
        };
        list = new ArrayList();
        progressWheel = null;
        page = 1;
        next = 1;
        list_fun = new ArrayList();
    }

    private void ApppopulistViewbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)listView.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50F));
        listView.setLayoutParams(layoutparams);
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parsefeatured(s));
        adapter = new Home_Listview_Adapter(getActivity(), list, "gamefeatured", list_fun);
        if (page == 1)
        {
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void ShowResult1(String s)
    {
        list_fun.addAll(Myutils.funList(s));
    }

    private void facebookbanner()
    {
        View view = View.inflate(getActivity(), 0x7f030044, null);
        facebookbanner = (LinearLayout)view.findViewById(0x7f060114);
        listView.addHeaderView(view, null, false);
        try
        {
            adView = new AdView(getActivity(), "340186902832477_388101398041027", AdSize.RECTANGLE_HEIGHT_250);
            facebookbanner.addView(adView);
            adView.setAdListener(new AdListener() {

                final GameFeaturedFragment this$0;

                public void onAdClicked(Ad ad)
                {
                }

                public void onAdLoaded(Ad ad)
                {
                }

                public void onError(Ad ad, AdError aderror)
                {
                    Log.e("rtrtr", (new StringBuilder()).append(aderror).toString());
                }

            
            {
                this$0 = GameFeaturedFragment.this;
                super();
            }
            });
            adView.loadAd();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void init(View view)
    {
        progressWheel = (ProgressWheel)view.findViewById(0x7f060075);
        listView = (PullableListView)view.findViewById(0x7f060073);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        (new Mya3()).execute(new Void[0]);
        (new Mya1()).execute(new Void[0]);
    }

    private void inmobibanner()
    {
        View view = View.inflate(getActivity(), 0x7f030059, null);
        if (getResources().getConfiguration().locale.getCountry().equals("US") || getResources().getConfiguration().locale.getCountry().equals("ID"))
        {
            listView.addHeaderView(view, null, false);
            inmobbanner = (LinearLayout)view.findViewById(0x7f06015b);
            imginmobibanner = (ImageView)view.findViewById(0x7f060174);
        }
    }

    private void inmoblist()
    {
        nativeAdaio = new IMNative("bf34144de1cf4616bca0c4acbdd94860", new IMNativeListener() {

            private String downloadurl;
            final GameFeaturedFragment this$0;

            public void onNativeRequestFailed(IMErrorCode imerrorcode)
            {
                try
                {
                    inmobbanner.setVisibility(8);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (IMErrorCode imerrorcode)
                {
                    return;
                }
            }

            public void onNativeRequestSucceeded(IMNative imnative)
            {
                try
                {
                    inmobbanner.setVisibility(0);
                }
                catch (Exception exception) { }
                nativeAdaio = imnative;
                if (imnative != null)
                {
                    imnative.attachToView(inmobbanner);
                }
                imnative = imnative.getContent();
                try
                {
                    imnative = new JSONObject(imnative);
                    String s = imnative.getString("screenshots");
                    downloadurl = imnative.getString("landingURL");
                    imnative = (new JSONObject(s)).getString("url");
                    if (!imnative.equals(""))
                    {
                        String s1 = ImageUtil.getCacheImgPath().concat(ImageUtil.md5(imnative));
                        bitmap = ImageUtil.loadImage(s1, imnative, new com.allinone.free.utils.ImageUtil.ImageCallback() {

                            final _cls4 this$1;

                            public void loadImage(Bitmap bitmap1, String s)
                            {
                                if (imginmobibanner != null)
                                {
                                    w = bitmap1.getWidth();
                                    h = bitmap1.getHeight();
                                    s = new android.widget.LinearLayout.LayoutParams(-1, getHeight(w, h));
                                    imginmobibanner.setLayoutParams(s);
                                    imginmobibanner.setImageBitmap(bitmap1);
                                }
                            }

            
            {
                this$1 = _cls4.this;
                super();
            }
                        }, 0);
                        if (bitmap != null)
                        {
                            w = bitmap.getWidth();
                            h = bitmap.getHeight();
                            imnative = new android.widget.LinearLayout.LayoutParams(-1, getHeight(w, h));
                            imginmobibanner.setLayoutParams(imnative);
                            imginmobibanner.setImageBitmap(bitmap);
                        }
                    }
                    imginmobibanner.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(View view)
                        {
                            view = new Intent("android.intent.action.VIEW", Uri.parse(downloadurl));
                            startActivity(view);
                            if (nativeAdaio != null)
                            {
                                nativeAdaio.handleClick(null);
                            }
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (IMNative imnative)
                {
                    imnative.printStackTrace();
                }
            }



            
            {
                this$0 = GameFeaturedFragment.this;
                super();
            }
        });
        nativeAdaio.loadAd();
    }

    public int getHeight(int i, int j)
    {
        return (getActivity().getResources().getDisplayMetrics().widthPixels * j) / i;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030025, null, false);
        init(layoutinflater);
        ApppopulistViewbottom();
        viewgroup = new IntentFilter();
        viewgroup.addAction("showgamefeatured");
        getActivity().registerReceiver(showapp1, viewgroup);
        viewgroup = new IntentFilter();
        viewgroup.addAction("hidegamefeatured");
        getActivity().registerReceiver(hideapp1, viewgroup);
        facebookbanner();
        return layoutinflater;
    }

    public void onDestroy()
    {
        adView.destroy();
        super.onDestroy();
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onLoad(PullableListView pullablelistview)
    {
        if (list.size() > 0)
        {
            next = ((DownloadMovieItem)((ArrayList)list.get(list.size() - 1)).get(0)).getHas_next_page();
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
