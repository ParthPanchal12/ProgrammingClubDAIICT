// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.adapter.WidgetPaidGridviewAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import com.umeng.analytics.MobclickAgent;
import com.yeahmobi.android.interfaces.AdInterfaces;
import com.yeahmobi.android.shuffle.AdShuffle;
import java.util.ArrayList;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONObject;

public class WidgeGametActivity extends BaseActivity
    implements android.view.View.OnClickListener, AdListener
{
    class MyWidgetgv extends AsyncTask
    {

        final WidgeGametActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            String s = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_deskfold");
            avoid = s;
            if (s == null)
            {
                avoid = null;
            }
            return avoid;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
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
            progress_wheel.setVisibility(0);
            linetianchong.setVisibility(0);
        }

        MyWidgetgv()
        {
            this$0 = WidgeGametActivity.this;
            super();
        }
    }


    private AdShuffle adShuffle;
    private WidgetPaidGridviewAdapter adapter;
    private MyApplcation app;
    private TypeDbUtils dbUtils;
    private ImageView fbgvimg;
    private TextView fbgvtitle;
    private LinearLayout fbimbline;
    private LinearLayout fbline;
    private ArrayList gvlist;
    private String imbdownurl;
    private String imbdownurl2;
    private ImageView imbgvimg;
    private TextView imbgvtitle;
    private LinearLayout imbline;
    private boolean isfbshow;
    private boolean isshowfb;
    private boolean isshowimb;
    private boolean isshowinmobi;
    private LinearLayout linetianchong;
    private NativeAd nativeAd;
    private IMNative nativeAdaio;
    private IMNative nativeAdaio2;
    private NativeAd nativeAdfb;
    private ProgressWheel progress_wheel;
    private RelativeLayout rl_canshu;
    private Typeface typeFace;
    private ImageView widgetgamegift;
    private GridView widgetgv;
    private LinearLayout widgetjiasu;
    private LinearLayout widgetmoregame;

    public WidgeGametActivity()
    {
        dbUtils = null;
        isshowfb = false;
        isshowimb = false;
        typeFace = null;
        isfbshow = false;
        isshowinmobi = false;
    }

    private void ShowResult(String s)
    {
        gvlist = new ArrayList();
        gvlist.addAll(Myutils.parseApplist(s));
        adapter = new WidgetPaidGridviewAdapter(getApplicationContext(), gvlist, "aa");
        widgetgv.setAdapter(adapter);
        progress_wheel.setVisibility(8);
        linetianchong.setVisibility(8);
    }

    private void facebookad()
    {
        fbgvtitle.setText(nativeAd.getAdTitle());
        NativeAd.downloadAndDisplayImage(nativeAd.getAdIcon(), fbgvimg);
        nativeAd.registerViewForInteraction(fbline);
        nativeAdfb.registerViewForInteraction(widgetgamegift);
    }

    private void init()
    {
        try
        {
            typeFace = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        }
        catch (Exception exception1) { }
        widgetgamegift = (ImageView)findViewById(0x7f0602b0);
        widgetgamegift.setOnClickListener(new android.view.View.OnClickListener() {

            final WidgeGametActivity this$0;

            public void onClick(View view)
            {
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
            }

            
            {
                this$0 = WidgeGametActivity.this;
                super();
            }
        });
        fbimbline = (LinearLayout)findViewById(0x7f0602a8);
        try
        {
            if (dbUtils == null)
            {
                dbUtils = new TypeDbUtils(this);
            }
        }
        catch (Exception exception) { }
        fbline = (LinearLayout)findViewById(0x7f0602a9);
        imbline = (LinearLayout)findViewById(0x7f0602ac);
        app = (MyApplcation)getApplicationContext();
        fbgvimg = (ImageView)findViewById(0x7f0602aa);
        imbgvimg = (ImageView)findViewById(0x7f0602ad);
        fbgvtitle = (TextView)findViewById(0x7f0602ab);
        imbgvtitle = (TextView)findViewById(0x7f0602ae);
        widgetjiasu = (LinearLayout)findViewById(0x7f0602b3);
        widgetjiasu.setOnClickListener(this);
        widgetmoregame = (LinearLayout)findViewById(0x7f0602b4);
        widgetmoregame.setOnClickListener(this);
        linetianchong = (LinearLayout)findViewById(0x7f0602b1);
        widgetgv = (GridView)findViewById(0x7f0602b2);
        progress_wheel = (ProgressWheel)findViewById(0x7f060075);
        rl_canshu = (RelativeLayout)findViewById(0x7f0602af);
        ((TextView)findViewById(0x7f060142)).setTypeface(typeFace);
    }

    private void inmobgift()
    {
        nativeAdaio2 = new IMNative("dd15bc6e28814b60a1b162840af80d88", new IMNativeListener() {

            final WidgeGametActivity this$0;

            public void onNativeRequestFailed(IMErrorCode imerrorcode)
            {
                isshowinmobi = false;
            }

            public void onNativeRequestSucceeded(IMNative imnative)
            {
                nativeAdaio2 = imnative;
                Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
                if (imnative != null)
                {
                    imnative.attachToView(rl_canshu);
                }
                imnative = imnative.getContent();
                isshowinmobi = true;
                try
                {
                    imnative = new JSONObject(imnative);
                    imbdownurl2 = imnative.getString("landingURL");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (IMNative imnative)
                {
                    imnative.printStackTrace();
                }
            }

            
            {
                this$0 = WidgeGametActivity.this;
                super();
            }
        });
        nativeAdaio2.loadAd();
    }

    private void inmoblist()
    {
        nativeAdaio = new IMNative("cabf4e2618d24d6c84d7b2d7562f6b7d", new IMNativeListener() {

            final WidgeGametActivity this$0;

            public void onNativeRequestFailed(IMErrorCode imerrorcode)
            {
                imbline.setVisibility(8);
            }

            public void onNativeRequestSucceeded(IMNative imnative)
            {
                nativeAdaio = imnative;
                Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
                if (imnative != null)
                {
                    imnative.attachToView(imbline);
                }
                imnative = imnative.getContent();
                imbline.setVisibility(0);
                fbimbline.setVisibility(0);
                isshowimb = true;
                try
                {
                    imnative = new JSONObject(imnative);
                    imbgvtitle.setText(imnative.getString("title"));
                    imbdownurl = imnative.getString("landingURL");
                    imnative = imnative.getJSONObject("icon");
                    app.asyncLoadImage(imnative.getString("url"), imbgvimg);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (IMNative imnative)
                {
                    imnative.printStackTrace();
                }
            }

            
            {
                this$0 = WidgeGametActivity.this;
                super();
            }
        });
        nativeAdaio.loadAd();
    }

    public void initView()
    {
        super.initView();
        new FinalDBChen(getmContext(), "download2.db", new DownloadMovieItem(), "downloadtask2", null);
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAdfb != null && nativeAdfb == ad)
        {
            nativeAdfb.unregisterView();
            facebookad();
            isfbshow = true;
            if (nativeAd != null && nativeAd == ad)
            {
                nativeAd.unregisterView();
                try
                {
                    isshowfb = true;
                    fbline.setVisibility(0);
                    fbimbline.setVisibility(0);
                    facebookad();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Ad ad)
                {
                    return;
                }
            }
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131100339: 
            view = new ComponentName("com.allinone.free", "com.allinone.free.cleaner.RubActivity");
            Intent intent = new Intent();
            intent.putExtra("widgetdetailfan", true);
            intent.addFlags(0x10000000);
            intent.setComponent(view);
            startActivity(intent);
            return;

        case 2131100340: 
            view = new ComponentName("com.allinone.free", "com.allinone.free.activity.GameActivity");
            break;
        }
        Intent intent1 = new Intent();
        intent1.putExtra("gamefan", true);
        intent1.addFlags(0x10000000);
        intent1.setComponent(view);
        startActivity(intent1);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300ab);
        init();
        initView();
        (new MyWidgetgv()).execute(new Void[0]);
        nativeAd = new NativeAd(this, "340186902832477_394762884041545");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        imbline.setOnClickListener(new android.view.View.OnClickListener() {

            final WidgeGametActivity this$0;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.VIEW", Uri.parse(imbdownurl));
                startActivity(view);
                if (nativeAdaio != null)
                {
                    nativeAdaio.handleClick(null);
                }
            }

            
            {
                this$0 = WidgeGametActivity.this;
                super();
            }
        });
        AdInterfaces.setAppInfo("779", "1237");
        adShuffle = AdInterfaces.getAdShffle(this);
        InMobi.initialize(this, "dd15bc6e28814b60a1b162840af80d88");
        inmobgift();
        widgetgamegift.setOnClickListener(new android.view.View.OnClickListener() {

            final WidgeGametActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    view = new Intent("android.intent.action.VIEW", Uri.parse(imbdownurl2));
                    startActivity(view);
                    if (nativeAdaio2 != null)
                    {
                        nativeAdaio2.handleClick(null);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = WidgeGametActivity.this;
                super();
            }
        });
    }

    public void onError(Ad ad, AdError aderror)
    {
        fbline.setVisibility(8);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            moveTaskToBack(true);
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
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
