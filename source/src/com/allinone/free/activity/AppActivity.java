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
import com.allinone.free.fragments.AppFeaturedFragment;
import com.allinone.free.fragments.AppGlobalNewFragment;
import com.allinone.free.fragments.AppGlobalTopFragment;
import com.allinone.free.fragments.AppIndiaNewFragment;
import com.allinone.free.fragments.AppIndiaTopFragment;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
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
import com.umeng.analytics.MobclickAgent;
import com.yeahmobi.android.interfaces.AdInterfaces;
import com.yeahmobi.android.shuffle.AdShuffle;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity, AppRecommendKeywordsActivity, DownloadsActivity

public class AppActivity extends SherlockFragmentActivity
    implements ContentValue
{
    public class TabFragmentPagerAdapter extends FragmentPagerAdapter
    {

        final AppActivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
        }

        public int getCount()
        {
            return AppActivity.tabTitle.length;
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
        //                       1 113
        //                       2 124
        //                       3 91
        //                       4 102;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            map.put(Integer.valueOf(i), obj);
            return ((Fragment) (obj));
_L2:
            obj = new AppFeaturedFragment();
            continue; /* Loop/switch isn't completed */
_L5:
            obj = new AppIndiaTopFragment();
            continue; /* Loop/switch isn't completed */
_L6:
            obj = new AppIndiaNewFragment();
            continue; /* Loop/switch isn't completed */
_L3:
            obj = new AppGlobalTopFragment();
            continue; /* Loop/switch isn't completed */
_L4:
            obj = new AppGlobalNewFragment();
            if (true) goto _L1; else goto _L7
_L7:
        }

        public TabFragmentPagerAdapter(FragmentManager fragmentmanager)
        {
            this$0 = AppActivity.this;
            super(fragmentmanager);
        }
    }


    public static final String tabTitle[] = {
        "FEATURED", "GLOAL TOP", "GLOBAL NEW", "LOCAL TOP", "LOCAL NEW"
    };
    private static Typeface typeFace = null;
    private AdShuffle adShuffle;
    private AdView adView;
    private BroadcastReceiver app;
    private LinearLayout appbanner;
    private ImageView appfan;
    private ImageView apptodown;
    private ImageView apptopgift;
    private ImageView apptopsearch;
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
    private NativeAd nativeAdfb;
    publicTools pubTools;
    private RadioGroup rg_nav_content;
    private SharedPreferences sp_config;
    private RelativeLayout top;
    View view;

    public AppActivity()
    {
        app = new BroadcastReceiver() {

            final AppActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                try
                {
                    db = new FinalDBChen(AppActivity.this, getDatabasePath("download2.db").getAbsolutePath());
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
                this$0 = AppActivity.this;
                super();
            }
        };
        view = null;
        currentIndicatorLeft = 0;
        currentfragment_id = 0;
        pubTools = null;
        sp_config = null;
        isshowinmobi = false;
        isfbshow = false;
    }

    private void bindListeners()
    {
        appfan.setOnClickListener(new android.view.View.OnClickListener() {

            final AppActivity this$0;

            public void onClick(View view1)
            {
                finish();
            }

            
            {
                this$0 = AppActivity.this;
                super();
            }
        });
        apptopsearch.setOnClickListener(new android.view.View.OnClickListener() {

            final AppActivity this$0;

            public void onClick(View view1)
            {
                startActivity(new Intent(AppActivity.this, com/allinone/free/activity/AppRecommendKeywordsActivity));
            }

            
            {
                this$0 = AppActivity.this;
                super();
            }
        });
        apptopgift.setOnClickListener(new android.view.View.OnClickListener() {

            final AppActivity this$0;

            public void onClick(View view1)
            {
                if (!isfbshow)
                {
                    Toast.makeText(getApplicationContext(), "Loading...", 1).show();
                    adShuffle.loadAds(false);
                }
            }

            
            {
                this$0 = AppActivity.this;
                super();
            }
        });
        apptodown.setOnClickListener(new android.view.View.OnClickListener() {

            final AppActivity this$0;

            public void onClick(View view1)
            {
                startActivity(new Intent(AppActivity.this, com/allinone/free/activity/DownloadsActivity));
            }

            
            {
                this$0 = AppActivity.this;
                super();
            }
        });
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final AppActivity this$0;

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
                this$0 = AppActivity.this;
                super();
            }
        });
        mViewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final AppActivity this$0;

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
                this$0 = AppActivity.this;
                super();
            }
        });
        rg_nav_content.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final AppActivity this$0;

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
                this$0 = AppActivity.this;
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
        listtitle = (TextView)findViewById(0x7f0600c1);
        listtitle.setText("App");
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
        nativeAdfb.registerViewForInteraction(apptopgift);
    }

    private void init()
    {
        apptopsearch = (ImageView)findViewById(0x7f0600c2);
        apptopgift = (ImageView)findViewById(0x7f0600c3);
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
        bundle.addAction("app");
        registerReceiver(app, bundle);
        try
        {
            adView = new AdView(this, "340186902832477_407365439447956", AdSize.BANNER_HEIGHT_50);
            appbanner.addView(adView);
            adView.setAdListener(new AdListener() {

                final AppActivity this$0;

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
                this$0 = AppActivity.this;
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
