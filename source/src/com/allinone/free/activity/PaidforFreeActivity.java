// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.allinone.free.fragments.PaidFeaturedFragment;
import com.allinone.free.fragments.PaidHotAppsFragment;
import com.allinone.free.fragments.PaidHotGamesFragment;
import com.allinone.free.fragments.PaidNewAppsFragment;
import com.allinone.free.fragments.PaidNewGamesFragment;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.start_welcome.MainActivity;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.BadgeView;
import com.allinone.free.views.SyncHorizontalScrollView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.NativeAd;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import com.umeng.analytics.MobclickAgent;
import com.yeahmobi.android.interfaces.AdInterfaces;
import com.yeahmobi.android.shuffle.AdShuffle;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity, DownloadsActivity

public class PaidforFreeActivity extends SherlockFragmentActivity
    implements ContentValue, AdListener
{
    public class TabFragmentPagerAdapter extends FragmentPagerAdapter
    {

        final PaidforFreeActivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
        }

        public int getCount()
        {
            return PaidforFreeActivity.tabTitle.length;
        }

        public Fragment getItem(int i)
        {
            Object obj;
            obj = (Fragment)map.get(Integer.valueOf(i));
            if (obj != null)
            {
                return ((Fragment) (obj));
            }
            i;
            JVM INSTR tableswitch 0 4: default 60
        //                       0 80
        //                       1 91
        //                       2 102
        //                       3 113
        //                       4 124;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            map.put(Integer.valueOf(i), obj);
            return ((Fragment) (obj));
_L2:
            obj = new PaidFeaturedFragment();
            continue; /* Loop/switch isn't completed */
_L3:
            obj = new PaidHotAppsFragment();
            continue; /* Loop/switch isn't completed */
_L4:
            obj = new PaidNewAppsFragment();
            continue; /* Loop/switch isn't completed */
_L5:
            obj = new PaidHotGamesFragment();
            continue; /* Loop/switch isn't completed */
_L6:
            obj = new PaidNewGamesFragment();
            if (true) goto _L1; else goto _L7
_L7:
        }

        public TabFragmentPagerAdapter(FragmentManager fragmentmanager)
        {
            this$0 = PaidforFreeActivity.this;
            super(fragmentmanager);
        }
    }


    public static final String tabTitle[] = {
        "FEATURED", "HOT APPS", "NEW APPS", "HOT GAMES", "NEW GAMES"
    };
    private static Typeface typeFace = null;
    private AdShuffle adShuffle;
    private AdView adView;
    private LinearLayout appbanner;
    private ImageView appfan;
    private ImageView apptodown;
    private BadgeView badgedownimg;
    private String banner_type_name;
    private int currentIndicatorLeft;
    private int currentfragment_id;
    private FinalDBChen db;
    private List ds;
    private String imbdownurl;
    private int indicatorWidth;
    private boolean isfbshow;
    private boolean isshowinmobi;
    private ImageView iv_nav_indicator;
    private TextView listtitle;
    private TabFragmentPagerAdapter mAdapter;
    private ImageView mAnimImageView;
    private Animation mAnimation;
    private SyncHorizontalScrollView mHsv;
    private LayoutInflater mInflater;
    private ViewPager mViewPager;
    private Map map;
    private IMNative nativeAdaio;
    private NativeAd nativeAdfb;
    private BroadcastReceiver paid;
    private boolean paidfan;
    private ImageView paidtopgift;
    private ImageView paidtopsearch;
    publicTools pubTools;
    private RadioGroup rg_nav_content;
    private SharedPreferences sp_config;
    private RelativeLayout top;
    View view;

    public PaidforFreeActivity()
    {
        paid = new BroadcastReceiver() {

            final PaidforFreeActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                try
                {
                    db = new FinalDBChen(PaidforFreeActivity.this, getDatabasePath("download2.db").getAbsolutePath());
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
                    (new AsyncTask() {

                        final _cls1 this$1;

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
                this$1 = _cls1.this;
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
                this$0 = PaidforFreeActivity.this;
                super();
            }
        };
        view = null;
        currentIndicatorLeft = 0;
        currentfragment_id = 0;
        pubTools = null;
        sp_config = null;
        paidfan = false;
        isshowinmobi = false;
        isfbshow = false;
    }

    private void bindListeners()
    {
        appfan.setOnClickListener(new android.view.View.OnClickListener() {

            final PaidforFreeActivity this$0;

            public void onClick(View view1)
            {
                if (paidfan)
                {
                    startActivity(new Intent(PaidforFreeActivity.this, com/allinone/free/start_welcome/MainActivity));
                    finish();
                    return;
                } else
                {
                    finish();
                    return;
                }
            }

            
            {
                this$0 = PaidforFreeActivity.this;
                super();
            }
        });
        paidtopsearch.setOnClickListener(new android.view.View.OnClickListener() {

            final PaidforFreeActivity this$0;

            public void onClick(View view1)
            {
                startActivity(new Intent(PaidforFreeActivity.this, com/allinone/free/activity/AppRecommendKeywordsActivity));
            }

            
            {
                this$0 = PaidforFreeActivity.this;
                super();
            }
        });
        paidtopgift.setOnClickListener(new android.view.View.OnClickListener() {

            final PaidforFreeActivity this$0;

            public void onClick(View view1)
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
                this$0 = PaidforFreeActivity.this;
                super();
            }
        });
        apptodown.setOnClickListener(new android.view.View.OnClickListener() {

            final PaidforFreeActivity this$0;

            public void onClick(View view1)
            {
                startActivity(new Intent(PaidforFreeActivity.this, com/allinone/free/activity/DownloadsActivity));
            }

            
            {
                this$0 = PaidforFreeActivity.this;
                super();
            }
        });
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final PaidforFreeActivity this$0;

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
                this$0 = PaidforFreeActivity.this;
                super();
            }
        });
        mViewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final PaidforFreeActivity this$0;

            public void onPageScrollStateChanged(int i)
            {
            }

            public void onPageScrolled(int i, float f, int j)
            {
            }

            public void onPageSelected(int i)
            {
                currentfragment_id = i;
                if (rg_nav_content != null && rg_nav_content.getChildCount() > i)
                {
                    ((RadioButton)rg_nav_content.getChildAt(i)).performClick();
                }
            }

            
            {
                this$0 = PaidforFreeActivity.this;
                super();
            }
        });
        rg_nav_content.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final PaidforFreeActivity this$0;

            public void onCheckedChanged(RadioGroup radiogroup, int i)
            {
                currentfragment_id = i;
                if (rg_nav_content.getChildAt(i) != null)
                {
                    radiogroup = new TranslateAnimation(currentIndicatorLeft, ((RadioButton)rg_nav_content.getChildAt(i)).getLeft(), 0.0F, 0.0F);
                    radiogroup.setInterpolator(new LinearInterpolator());
                    radiogroup.setDuration(100L);
                    radiogroup.setFillAfter(true);
                    iv_nav_indicator.startAnimation(radiogroup);
                    mViewPager.setCurrentItem(i);
                    currentIndicatorLeft = ((RadioButton)rg_nav_content.getChildAt(i)).getLeft();
                    radiogroup = mHsv;
                    if (i > 1)
                    {
                        i = ((RadioButton)rg_nav_content.getChildAt(i)).getLeft();
                    } else
                    {
                        i = 0;
                    }
                    radiogroup.smoothScrollTo(i - ((RadioButton)rg_nav_content.getChildAt(1)).getLeft(), 0);
                }
            }

            
            {
                this$0 = PaidforFreeActivity.this;
                super();
            }
        });
    }

    private void buildComponents()
    {
        mAnimImageView = (ImageView)findViewById(0x7f060076);
        apptodown = (ImageView)findViewById(0x7f0600c4);
        mAnimation = AnimationUtils.loadAnimation(this, 0x7f040006);
        badgedownimg = new BadgeView(getApplicationContext(), apptodown);
        appfan = (ImageView)findViewById(0x7f06004f);
        appbanner = (LinearLayout)findViewById(0x7f0600ce);
        sp_config = getSharedPreferences("banner_type", 0);
        pubTools = new publicTools(this);
        banner_type_name = sp_config.getString("banner_type", "admob");
        rg_nav_content = (RadioGroup)findViewById(0x7f0600c9);
        mViewPager = (ViewPager)findViewById(0x7f0600cc);
        mHsv = (SyncHorizontalScrollView)findViewById(0x7f0600c7);
        iv_nav_indicator = (ImageView)findViewById(0x7f0600ca);
        map = new HashMap();
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(paidtopgift);
    }

    private void init()
    {
        paidfan = getIntent().getBooleanExtra("paidfan", false);
        listtitle = (TextView)findViewById(0x7f0600c1);
        listtitle.setText("Crack");
        paidtopsearch = (ImageView)findViewById(0x7f0600c2);
        paidtopgift = (ImageView)findViewById(0x7f0600c3);
        Object obj = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        indicatorWidth = ((DisplayMetrics) (obj)).widthPixels / 5 + DisplayUtil.dip2px(getApplicationContext(), 46F);
        obj = iv_nav_indicator.getLayoutParams();
        obj.width = indicatorWidth;
        iv_nav_indicator.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mInflater = (LayoutInflater)getSystemService("layout_inflater");
        initNavigationHSV();
        mAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        rg_nav_content.getChildAt(0).performClick();
        top = (RelativeLayout)findViewById(0x7f06004e);
    }

    private void initNavigationHSV()
    {
        rg_nav_content.removeAllViews();
        int i = 0;
        do
        {
            if (i >= tabTitle.length)
            {
                return;
            }
            RadioButton radiobutton = (RadioButton)mInflater.inflate(0x7f030074, null);
            radiobutton.setId(i);
            radiobutton.setText(tabTitle[i]);
            radiobutton.setLayoutParams(new android.view.ViewGroup.LayoutParams(indicatorWidth, -1));
            rg_nav_content.addView(radiobutton);
            i++;
        } while (true);
    }

    private void inmobgift()
    {
        nativeAdaio = new IMNative("dd15bc6e28814b60a1b162840af80d88", new IMNativeListener() {

            final PaidforFreeActivity this$0;

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
                    imnative.attachToView(top);
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
                this$0 = PaidforFreeActivity.this;
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

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002a);
        buildComponents();
        init();
        bindListeners();
        AdInterfaces.setAppInfo("779", "1237");
        adShuffle = AdInterfaces.getAdShffle(this);
        bundle = new IntentFilter();
        bundle.addAction("paid");
        registerReceiver(paid, bundle);
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        try
        {
            adView = new AdView(this, "340186902832477_407365439447956", AdSize.BANNER_HEIGHT_50);
            appbanner.addView(adView);
            adView.setAdListener(new AdListener() {

                final PaidforFreeActivity this$0;

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
                this$0 = PaidforFreeActivity.this;
                super();
            }
            });
            adView.loadAd();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return;
        }
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (paidfan)
            {
                startActivity(new Intent(this, com/allinone/free/start_welcome/MainActivity));
                finish();
            } else
            {
                finish();
            }
        }
        return super.onKeyDown(i, keyevent);
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
