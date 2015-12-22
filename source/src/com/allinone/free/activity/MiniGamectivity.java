// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
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
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.allinone.free.fragments.MiniGame_Popular_Fragment;
import com.allinone.free.fragments.MiniGame_Recent_Fragment;
import com.allinone.free.fragments.Mp3SearchFragment;
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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity, MinigameRecommendActivity

public class MiniGamectivity extends SherlockFragmentActivity
    implements AdListener
{
    public class TabFragmentPagerAdapter extends FragmentPagerAdapter
    {

        final MiniGamectivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
        }

        public int getCount()
        {
            return MiniGamectivity.tabTitle.length;
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
            JVM INSTR tableswitch 0 1: default 48
        //                       0 68
        //                       1 79;
               goto _L1 _L2 _L3
_L1:
            map.put(Integer.valueOf(i), obj);
            return ((Fragment) (obj));
_L2:
            obj = new MiniGame_Recent_Fragment();
            continue; /* Loop/switch isn't completed */
_L3:
            obj = new MiniGame_Popular_Fragment();
            if (true) goto _L1; else goto _L4
_L4:
        }

        public TabFragmentPagerAdapter(FragmentManager fragmentmanager)
        {
            this$0 = MiniGamectivity.this;
            super(fragmentmanager);
        }
    }

    private class TabFragmentPagerAdapter2 extends FragmentPagerAdapter
    {

        final MiniGamectivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
        }

        public int getCount()
        {
            return 1;
        }

        public Fragment getItem(int i)
        {
            Fragment fragment = (Fragment)map2.get(Integer.valueOf(i));
            if (fragment != null)
            {
                return fragment;
            } else
            {
                Mp3SearchFragment mp3searchfragment = new Mp3SearchFragment();
                map2.put(Integer.valueOf(i), mp3searchfragment);
                return mp3searchfragment;
            }
        }

        public TabFragmentPagerAdapter2(FragmentManager fragmentmanager)
        {
            this$0 = MiniGamectivity.this;
            super(fragmentmanager);
        }
    }


    public static final String tabTitle[] = {
        "RECENT", "POPULAR"
    };
    private static Typeface typeFace = null;
    private AdShuffle adShuffle;
    private AdView adView;
    private FrameLayout addlayout;
    private LinearLayout appbanner;
    private ImageView appfan;
    private String banner_type_name;
    private int currentIndicatorLeft;
    private int currentfragment_id;
    private String imbdownurl;
    private int indicatorWidth;
    private boolean isfbshow;
    private boolean isshowinmobi;
    private ImageView iv_nav_indicator;
    private TabFragmentPagerAdapter mAdapter;
    private TabFragmentPagerAdapter2 mAdapter2;
    private SyncHorizontalScrollView mHsv;
    private LayoutInflater mInflater;
    private ViewPager mViewPager;
    private ViewPager mViewPager2;
    private Map map;
    private Map map2;
    private ImageView minitopgift;
    private ImageView minitopsearch;
    private IMNative nativeAdaio;
    private NativeAd nativeAdfb;
    private RadioGroup rg_nav_content;
    private SharedPreferences sp_config;
    private RelativeLayout top;
    View view;

    public MiniGamectivity()
    {
        view = null;
        currentIndicatorLeft = 0;
        currentfragment_id = 0;
        sp_config = null;
        isshowinmobi = false;
        isfbshow = false;
    }

    private void bindListeners()
    {
        appfan.setOnClickListener(new android.view.View.OnClickListener() {

            final MiniGamectivity this$0;

            public void onClick(View view1)
            {
                startActivity(new Intent(MiniGamectivity.this, com/allinone/free/activity/MyMainActivity));
            }

            
            {
                this$0 = MiniGamectivity.this;
                super();
            }
        });
        minitopgift.setOnClickListener(new android.view.View.OnClickListener() {

            final MiniGamectivity this$0;

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
                this$0 = MiniGamectivity.this;
                super();
            }
        });
        minitopsearch.setOnClickListener(new android.view.View.OnClickListener() {

            final MiniGamectivity this$0;

            public void onClick(View view1)
            {
                startActivity(new Intent(MiniGamectivity.this, com/allinone/free/activity/MinigameRecommendActivity));
            }

            
            {
                this$0 = MiniGamectivity.this;
                super();
            }
        });
        mViewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final MiniGamectivity this$0;

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
                this$0 = MiniGamectivity.this;
                super();
            }
        });
        rg_nav_content.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final MiniGamectivity this$0;

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
                this$0 = MiniGamectivity.this;
                super();
            }
        });
    }

    private void buildComponents()
    {
        appfan = (ImageView)findViewById(0x7f06004f);
        appbanner = (LinearLayout)findViewById(0x7f0600ce);
        sp_config = getSharedPreferences("banner_type", 0);
        banner_type_name = sp_config.getString("banner_type", "admob");
        rg_nav_content = (RadioGroup)findViewById(0x7f0600c9);
        mViewPager = (ViewPager)findViewById(0x7f0600cc);
        mViewPager2 = (ViewPager)findViewById(0x7f0600cd);
        mHsv = (SyncHorizontalScrollView)findViewById(0x7f0600c7);
        iv_nav_indicator = (ImageView)findViewById(0x7f0600ca);
        map = new HashMap();
        map2 = new HashMap();
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(minitopgift);
    }

    private void init()
    {
        minitopsearch = (ImageView)findViewById(0x7f0600d0);
        minitopgift = (ImageView)findViewById(0x7f0600d1);
        addlayout = (FrameLayout)findViewById(0x7f0600cb);
        Object obj = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        indicatorWidth = ((DisplayMetrics) (obj)).widthPixels / 2;
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

            final MiniGamectivity this$0;

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
                this$0 = MiniGamectivity.this;
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
        setContentView(0x7f03002c);
        buildComponents();
        init();
        bindListeners();
        AdInterfaces.setAppInfo("779", "1237");
        adShuffle = AdInterfaces.getAdShffle(this);
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        try
        {
            adView = new AdView(this, "340186902832477_407365439447956", AdSize.BANNER_HEIGHT_50);
            appbanner.addView(adView);
            adView.setAdListener(new AdListener() {

                final MiniGamectivity this$0;

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
                this$0 = MiniGamectivity.this;
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
            startActivity(new Intent(this, com/allinone/free/activity/MyMainActivity));
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
    }
















}
