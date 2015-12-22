// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.format.Formatter;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.allinone.free.cleaner.RubActivity;
import com.allinone.free.dialog.CleanerDialog;
import com.allinone.free.fragments.DownloadedFragment;
import com.allinone.free.fragments.DownloadingFragment;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.SyncHorizontalScrollView;
import com.umeng.analytics.MobclickAgent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity, ChapingActivity, AppRecommendKeywordsActivity

public class DownloadsActivity extends SherlockFragmentActivity
{
    public class TabFragmentPagerAdapter extends FragmentPagerAdapter
    {

        final DownloadsActivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
        }

        public int getCount()
        {
            return DownloadsActivity.tabTitle.length;
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
            obj = new DownloadingFragment();
            continue; /* Loop/switch isn't completed */
_L3:
            obj = new DownloadedFragment();
            if (true) goto _L1; else goto _L4
_L4:
        }

        public TabFragmentPagerAdapter(FragmentManager fragmentmanager)
        {
            this$0 = DownloadsActivity.this;
            super(fragmentmanager);
        }
    }


    public static final String tabTitle[] = {
        "Downloading", "Downloaded"
    };
    private File PRO_DIR;
    private double aa;
    private FrameLayout addlayout;
    private ImageView appfan;
    private double bb;
    private ProgressBar cleanerpb;
    private RelativeLayout cleanerre;
    private int currentIndicatorLeft;
    private int currentfragment_id;
    private long hadmemroy;
    private String id;
    private int indicatorWidth;
    private ImageView iv_nav_indicator;
    private TabFragmentPagerAdapter mAdapter;
    private SyncHorizontalScrollView mHsv;
    private LayoutInflater mInflater;
    private ViewPager mViewPager;
    private Map map;
    private TextView memorydec;
    publicTools pubTools;
    private RadioGroup rg_nav_content;
    private ImageView searchimg;
    private TextView totalmemory;
    View view;

    public DownloadsActivity()
    {
        view = null;
        currentIndicatorLeft = 0;
        currentfragment_id = 0;
        pubTools = null;
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
    }

    private void bindListeners()
    {
        cleanerre.setOnClickListener(new android.view.View.OnClickListener() {

            final DownloadsActivity this$0;

            public void onClick(View view1)
            {
                view1 = new CleanerDialog(DownloadsActivity.this, 0x7f0c0064);
                view1.setCanceledOnTouchOutside(false);
                view1.show();
                Button button = (Button)view1.findViewById(0x7f0600e6);
                Button button1 = (Button)view1.findViewById(0x7f0600e7);
                ((TextView)view1.findViewById(0x7f060081)).setText(Html.fromHtml("Activate <font color='#3261b4'> <b>AIO Cleaner</b></font> function to remove more old junk files and system cache."));
                button.setOnClickListener(view1. new android.view.View.OnClickListener() {

                    final _cls1 this$1;
                    private final CleanerDialog val$dialog1;

                    public void onClick(View view1)
                    {
                        view1 = new Intent(getApplicationContext(), com/allinone/free/cleaner/RubActivity);
                        startActivity(view1);
                        dialog1.dismiss();
                    }

            
            {
                this$1 = final__pcls1;
                dialog1 = CleanerDialog.this;
                super();
            }
                });
                button1.setOnClickListener(view1. new android.view.View.OnClickListener() {

                    final _cls1 this$1;
                    private final CleanerDialog val$dialog1;

                    public void onClick(View view1)
                    {
                        view1 = null;
                        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                        view1 = packageinfo;
_L1:
                        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                        if (view1 == null)
                        {
                            installApk();
                        } else
                        {
                            view1 = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                            startActivity(view1);
                        }
                        dialog1.dismiss();
                        return;
                        namenotfoundexception;
                        namenotfoundexception.printStackTrace();
                          goto _L1
                    }

            
            {
                this$1 = final__pcls1;
                dialog1 = CleanerDialog.this;
                super();
            }
                });
            }


            
            {
                this$0 = DownloadsActivity.this;
                super();
            }
        });
        appfan.setOnClickListener(new android.view.View.OnClickListener() {

            final DownloadsActivity this$0;

            public void onClick(View view1)
            {
                if (Myutils.iswidget2)
                {
                    startActivity(new Intent(DownloadsActivity.this, com/allinone/free/activity/MyMainActivity));
                    return;
                } else
                {
                    view1 = new Intent(getApplicationContext(), com/allinone/free/activity/ChapingActivity);
                    view1.setFlags(0x10000000);
                    startActivity(view1);
                    moveTaskToBack(true);
                    return;
                }
            }

            
            {
                this$0 = DownloadsActivity.this;
                super();
            }
        });
        searchimg.setOnClickListener(new android.view.View.OnClickListener() {

            final DownloadsActivity this$0;

            public void onClick(View view1)
            {
                startActivity(new Intent(DownloadsActivity.this, com/allinone/free/activity/AppRecommendKeywordsActivity));
            }

            
            {
                this$0 = DownloadsActivity.this;
                super();
            }
        });
        mViewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final DownloadsActivity this$0;

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
                this$0 = DownloadsActivity.this;
                super();
            }
        });
        rg_nav_content.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final DownloadsActivity this$0;

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
                this$0 = DownloadsActivity.this;
                super();
            }
        });
    }

    private void buildComponents()
    {
        appfan = (ImageView)findViewById(0x7f06004f);
        searchimg = (ImageView)findViewById(0x7f0600ee);
        pubTools = new publicTools(this);
        rg_nav_content = (RadioGroup)findViewById(0x7f0600c9);
        mViewPager = (ViewPager)findViewById(0x7f0600cc);
        mHsv = (SyncHorizontalScrollView)findViewById(0x7f0600c7);
        iv_nav_indicator = (ImageView)findViewById(0x7f0600ca);
        map = new HashMap();
    }

    public static long getmem_TOLAL()
    {
        Object obj;
        Object obj2;
        Object obj4;
        String s;
        Object obj5;
        obj4 = null;
        obj2 = null;
        obj5 = null;
        obj = null;
        s = null;
        Object obj1 = new BufferedReader(new FileReader("/proc/meminfo"), 8);
        s = ((BufferedReader) (obj1)).readLine();
        Object obj3;
        obj = obj2;
        if (s != null)
        {
            obj = s;
        }
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((IOException) (obj1)).printStackTrace();
            }
        }
        return (long)Integer.parseInt(((String) (obj)).substring(((String) (obj)).indexOf(':') + 1, ((String) (obj)).indexOf('k')).trim());
        obj3;
        obj1 = s;
_L6:
        obj = obj1;
        ((FileNotFoundException) (obj3)).printStackTrace();
        obj = obj4;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = obj4;
            break MISSING_BLOCK_LABEL_55;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_55;
        obj3;
        obj1 = obj5;
_L4:
        obj = obj1;
        ((IOException) (obj3)).printStackTrace();
        obj = obj4;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = obj4;
            break MISSING_BLOCK_LABEL_55;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_55;
        obj1;
_L2:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw obj1;
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L2; else goto _L1
_L1:
        obj3;
        if (true) goto _L4; else goto _L3
_L3:
        obj3;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void init()
    {
        cleanerpb = (ProgressBar)findViewById(0x7f0600f3);
        totalmemory = (TextView)findViewById(0x7f0600f2);
        memorydec = (TextView)findViewById(0x7f0600f4);
        cleanerre = (RelativeLayout)findViewById(0x7f0600ef);
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

    private void installApk()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    public static Double roundDouble(double d, int i)
    {
        double d1 = i;
        try
        {
            d1 = Math.pow(10D, d1);
            d = Math.floor(d * d1 + 0.5D) / d1;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return Double.valueOf(d);
    }

    public String getSdAvailableSize(Context context)
    {
        StatFs statfs = new StatFs("/mnt/sdcard");
        return Formatter.formatFileSize(context, (long)statfs.getBlockSize() * (long)(statfs.getBlockCount() - statfs.getAvailableBlocks()));
    }

    public String getSdTotalSize(Context context)
    {
        StatFs statfs = new StatFs("/mnt/sdcard");
        return Formatter.formatFileSize(context, (long)statfs.getBlockSize() * (long)statfs.getBlockCount());
    }

    public long getmem_UNUSED(Context context)
    {
        context = (ActivityManager)context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        context.getMemoryInfo(memoryinfo);
        return memoryinfo.availMem / 1024L;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!Myutils.iswidget2)
        {
            startActivity(new Intent(this, com/allinone/free/activity/MyMainActivity));
            overridePendingTransition(0x7f04000a, 0x7f04000f);
            Myutils.iswidget = true;
        }
        setContentView(0x7f03003a);
        buildComponents();
        init();
        bindListeners();
        bundle = getSdTotalSize(this);
        String s = getSdAvailableSize(this);
        Log.e("www", (new StringBuilder("sdAvailableSize=")).append(s).append("sdTotalSize=").append(bundle).toString());
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (Myutils.iswidget2)
            {
                startActivity(new Intent(this, com/allinone/free/activity/MyMainActivity));
                return true;
            } else
            {
                keyevent = new Intent(getApplicationContext(), com/allinone/free/activity/ChapingActivity);
                keyevent.setFlags(0x10000000);
                startActivity(keyevent);
                moveTaskToBack(true);
                return true;
            }
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
        String s;
        String s1;
        long l;
        if (publicTools.cleanertag)
        {
            memorydec.setVisibility(0);
            int i = (int)(Math.random() * 50D + 150D);
            memorydec.setText((new StringBuilder(String.valueOf(i))).append(" MB junk files found, get rid of them by one click!").toString());
        } else
        {
            memorydec.setVisibility(8);
            publicTools.cleanertag = true;
        }
        l = getmem_TOLAL();
        hadmemroy = l - getmem_UNUSED(getApplicationContext());
        aa = roundDouble((double)l / 1024D / 1024D, 2).doubleValue();
        bb = roundDouble((double)hadmemroy / 1024D / 1024D, 2).doubleValue();
        s = getSdTotalSize(this);
        s1 = getSdAvailableSize(this);
        totalmemory.setText((new StringBuilder(String.valueOf(s1))).append("/").append(s).toString());
        cleanerpb.setProgress((int)((bb / aa) * 100D));
    }










}
