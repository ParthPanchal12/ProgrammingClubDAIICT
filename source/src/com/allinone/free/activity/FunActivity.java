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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.allinone.free.fragments.FunTrendingFragment;
import com.allinone.free.fragments.FunadultFragment;
import com.allinone.free.fragments.FunallFragment;
import com.allinone.free.fragments.FungagFragment;
import com.allinone.free.fragments.FungifFragment;
import com.allinone.free.fragments.FunpopularFragment;
import com.allinone.free.fragments.FunvideoFragment;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.SyncHorizontalScrollView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
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
//            MyMainActivity, AppRecommendKeywordsActivity

public class FunActivity extends SherlockFragmentActivity
    implements ContentValue, AdListener
{
    public class TabFragmentPagerAdapter extends FragmentPagerAdapter
    {

        final FunActivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
        }

        public int getCount()
        {
            return FunActivity.tabTitle.length;
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
            JVM INSTR tableswitch 0 6: default 68
        //                       0 88
        //                       1 99
        //                       2 110
        //                       3 121
        //                       4 132
        //                       5 143
        //                       6 154;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            map.put(Integer.valueOf(i), obj);
            return ((Fragment) (obj));
_L2:
            obj = new FunallFragment();
            continue; /* Loop/switch isn't completed */
_L3:
            obj = new FunadultFragment();
            continue; /* Loop/switch isn't completed */
_L4:
            obj = new FungagFragment();
            continue; /* Loop/switch isn't completed */
_L5:
            obj = new FungifFragment();
            continue; /* Loop/switch isn't completed */
_L6:
            obj = new FunvideoFragment();
            continue; /* Loop/switch isn't completed */
_L7:
            obj = new FunpopularFragment();
            continue; /* Loop/switch isn't completed */
_L8:
            obj = new FunTrendingFragment();
            if (true) goto _L1; else goto _L9
_L9:
        }

        public TabFragmentPagerAdapter(FragmentManager fragmentmanager)
        {
            this$0 = FunActivity.this;
            super(fragmentmanager);
        }
    }


    public static final String tabTitle[] = {
        "All", "Adult", "Gag", "Gif", "Video", "Popular", "Trending"
    };
    private static Typeface typeFace = null;
    private AdShuffle adShuffle;
    private AdView adView;
    private ImageView adulttopgift;
    private ImageView adulttopsearch;
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
    private TextView listtitle;
    private TabFragmentPagerAdapter mAdapter;
    private SyncHorizontalScrollView mHsv;
    private LayoutInflater mInflater;
    private ViewPager mViewPager;
    private Map map;
    private IMNative nativeAdaio;
    private NativeAd nativeAdfb;
    publicTools pubTools;
    private RadioGroup rg_nav_content;
    private SharedPreferences sp_config;
    private View view;

    public FunActivity()
    {
        view = null;
        currentIndicatorLeft = 0;
        currentfragment_id = 0;
        pubTools = null;
        sp_config = null;
        isfbshow = false;
        isshowinmobi = false;
    }

    private void bindListeners()
    {
        appfan.setOnClickListener(new android.view.View.OnClickListener() {

            final FunActivity this$0;

            public void onClick(View view1)
            {
                finish();
            }

            
            {
                this$0 = FunActivity.this;
                super();
            }
        });
        adulttopsearch.setOnClickListener(new android.view.View.OnClickListener() {

            final FunActivity this$0;

            public void onClick(View view1)
            {
                startActivity(new Intent(FunActivity.this, com/allinone/free/activity/AppRecommendKeywordsActivity));
            }

            
            {
                this$0 = FunActivity.this;
                super();
            }
        });
        adulttopgift.setOnClickListener(new android.view.View.OnClickListener() {

            final FunActivity this$0;

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
                this$0 = FunActivity.this;
                super();
            }
        });
        mViewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final FunActivity this$0;

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
                this$0 = FunActivity.this;
                super();
            }
        });
        rg_nav_content.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final FunActivity this$0;

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
                this$0 = FunActivity.this;
                super();
            }
        });
    }

    private void buildComponents()
    {
        appfan = (ImageView)findViewById(0x7f06004f);
        appbanner = (LinearLayout)findViewById(0x7f0600ce);
        sp_config = getSharedPreferences("banner_type", 0);
        pubTools = new publicTools(this);
        banner_type_name = sp_config.getString("banner_type", "admob");
        if (banner_type_name.equals("admob"))
        {
            adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-1054623928013334/2142631400");
            appbanner.addView(adView);
            adView.loadAd(new AdRequest());
        }
        rg_nav_content = (RadioGroup)findViewById(0x7f0600c9);
        mViewPager = (ViewPager)findViewById(0x7f0600cc);
        mHsv = (SyncHorizontalScrollView)findViewById(0x7f0600c7);
        iv_nav_indicator = (ImageView)findViewById(0x7f0600ca);
        map = new HashMap();
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(adulttopgift);
    }

    private void init()
    {
        listtitle = (TextView)findViewById(0x7f0600c1);
        listtitle.setText("Funny");
        adulttopsearch = (ImageView)findViewById(0x7f0600c2);
        adulttopgift = (ImageView)findViewById(0x7f0600c3);
        Object obj = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        indicatorWidth = ((DisplayMetrics) (obj)).widthPixels / 7 + DisplayUtil.dip2px(getApplicationContext(), 46F);
        obj = iv_nav_indicator.getLayoutParams();
        obj.width = indicatorWidth;
        iv_nav_indicator.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mInflater = (LayoutInflater)getSystemService("layout_inflater");
        initNavigationHSV();
        mAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        rg_nav_content.getChildAt(0).performClick();
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

            final FunActivity this$0;

            public void onNativeRequestFailed(IMErrorCode imerrorcode)
            {
                isshowinmobi = false;
            }

            public void onNativeRequestSucceeded(IMNative imnative)
            {
                nativeAdaio = imnative;
                Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
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
                this$0 = FunActivity.this;
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
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
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
