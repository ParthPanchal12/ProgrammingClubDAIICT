// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.adapter.AppGridviewAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.start_welcome.MainActivity;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.BadgeView;
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
import java.io.File;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity, AppActivity, DownloadsActivity, ImagePagerActivity, 
//            MyMainActivity

public class AppDetailsActivity extends BaseActivity
    implements android.view.View.OnClickListener, AdListener
{
    private class ImageGalleryAdapter extends BaseAdapter
    {

        private Context ctx;
        final AppDetailsActivity this$0;

        public int getCount()
        {
            return list.size();
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = (ImageView)view;
            view = viewgroup;
            if (viewgroup == null)
            {
                view = (ImageView)getLayoutInflater().inflate(0x7f03005b, null, false);
            }
            try
            {
                view.setLayoutParams(new android.widget.Gallery.LayoutParams(DisplayUtil.dip2px(AppDetailsActivity.this, 150F), DisplayUtil.dip2px(AppDetailsActivity.this, 260F)));
                app.asyncLoadImage(((DownloadMovieItem)list.get(i)).getScreenshots(), view);
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                return view;
            }
            return view;
        }

        public ImageGalleryAdapter(Context context)
        {
            this$0 = AppDetailsActivity.this;
            super();
            ctx = context;
        }
    }

    class Mya1 extends AsyncTask
    {

        final AppDetailsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient ArrayList doInBackground(Void avoid[])
        {
            avoid = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id=")).append(id).toString();
            Log.e("www", avoid);
            avoid = publicTools.getUrl(avoid);
            if (avoid == null)
            {
                return null;
            }
            list = new ArrayList();
            avoid = new JSONObject(avoid);
            if (avoid.getInt("status") != 1) goto _L2; else goto _L1
_L1:
            model = new DownloadMovieItem();
            avoid = avoid.getJSONObject("pdt");
            model.setId(avoid.getString("id"));
            model.setTitle(avoid.getString("title"));
            model.setAuthor_title(avoid.getString("author_title"));
            model.setIcon(avoid.getString("icon"));
            model.setRating(Float.valueOf(Float.parseFloat(avoid.getString("rating"))));
            model.setVersion(avoid.getString("version"));
            model.setRelease_date(avoid.getString("release_date"));
            model.setDownloads(avoid.getString("downloads"));
            model.setSize(avoid.getString("size"));
            model.setPrice(avoid.getString("price"));
            model.setDetail(avoid.getString("detail"));
            model.setHas_apk(avoid.getString("has_apk"));
            model.setIs_official(avoid.getString("is_official"));
            model.setSerial(avoid.getInt("serial"));
            avoid = avoid.getJSONArray("screenshots");
            int i = 0;
_L4:
            int j = avoid.length();
            if (i < j) goto _L3; else goto _L2
_L2:
            return list;
_L3:
            DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
            downloadmovieitem.setScreenshots(avoid.getString(i));
            list.add(downloadmovieitem);
            i++;
              goto _L4
            avoid;
            avoid.printStackTrace();
              goto _L2
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ArrayList)obj);
        }

        protected void onPostExecute(ArrayList arraylist)
        {
            super.onPostExecute(arraylist);
            if (arraylist != null) goto _L2; else goto _L1
_L1:
            progress_wheel.setVisibility(8);
_L8:
            return;
_L2:
            detailtoprel.setVisibility(0);
            desctv.setVisibility(0);
            view1.setVisibility(0);
            view2.setVisibility(0);
            view3.setVisibility(0);
            view4.setVisibility(0);
            app.asyncLoadImage(model.getIcon(), appdetailicon);
            appdetailtitle.setText(model.getTitle());
            appdetailauthortitle.setText(model.getAuthor_title());
            appdetailratingbar.setRating(model.getRating().floatValue());
            version.setText((new StringBuilder("Version:")).append(model.getVersion()).toString());
            date.setText(model.getRelease_date());
            device.setText(model.getSize());
            downloads.setText((new StringBuilder("Downloads:")).append(model.getDownloads()).toString());
            detail.setText((new StringBuilder(String.valueOf(model.getDetail()))).append("\n").toString());
            appdetailtitle.setTypeface(typeFace);
            appdetailauthortitle.setTypeface(typeFace2);
            arraylist = model.getIs_official();
            if (!arraylist.equals("1")) goto _L4; else goto _L3
_L3:
            detailplaytop.setVisibility(0);
_L6:
            try
            {
                mygallery.setAdapter(new ImageGalleryAdapter(AppDetailsActivity.this));
                mygallery.setSelection(1);
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist) { }
            progress_wheel.setVisibility(8);
            if (model.getHas_apk().equals("1"))
            {
                downloadapk.setVisibility(0);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (!arraylist.equals("0")) goto _L6; else goto _L5
_L5:
            detailplaytop.setVisibility(8);
              goto _L6
            arraylist;
              goto _L6
            if (!model.getHas_apk().equals("0")) goto _L8; else goto _L7
_L7:
            googleplay.setVisibility(0);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel.setVisibility(0);
        }

        Mya1()
        {
            this$0 = AppDetailsActivity.this;
            super();
        }
    }

    class Myagv extends AsyncTask
    {

        final AppDetailsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            String s = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_ad_1");
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
                detailline.setVisibility(0);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel.setVisibility(0);
        }

        Myagv()
        {
            this$0 = AppDetailsActivity.this;
            super();
        }
    }


    public static CookieManager cookieManager;
    public static final String secret = "this_is_mobile_2014";
    private AdShuffle adShuffle;
    private AdView adView;
    private AppGridviewAdapter adapter;
    private MyApplcation app;
    private BroadcastReceiver appdetail;
    private TextView appdetailauthortitle;
    private ImageView appdetaildown;
    private GridView appdetailgv;
    private ImageView appdetailicon;
    private RatingBar appdetailratingbar;
    private ImageView appdetailsearch;
    private TextView appdetailtitle;
    private RelativeLayout appdetailtop;
    private BadgeView badgedownimg;
    private LinearLayout banner;
    private String banner_type_name;
    private TextView date;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private TextView desctv;
    private TextView detail;
    private TextView detailback;
    private ImageView detailfan;
    private LinearLayout detailline;
    private ImageView detailplaytop;
    private ScrollView detailscroll;
    private ImageView detailtogift;
    private RelativeLayout detailtoprel;
    private TextView device;
    private Button downloadapk;
    private TextView downloads;
    private List ds;
    private Button googleplay;
    private ArrayList gvlist;
    Handler handler;
    private BroadcastReceiver hidegvappdetail;
    private String id;
    private String imbdownurl;
    private boolean isfbshow;
    private boolean isshowinmobi;
    private ArrayList list;
    private ImageView mAnimImageView;
    private Animation mAnimation;
    private DownloadMovieItem model;
    private Gallery mygallery;
    private IMNative nativeAdaio;
    private NativeAd nativeAdfb;
    private ProgressWheel progress_wheel;
    private publicTools publictools;
    private boolean shoufengqing;
    private BroadcastReceiver showgvappdetail;
    private SharedPreferences sp_config;
    private SharedPreferences spnetworkre;
    private RelativeLayout topredetail;
    private Boolean tuijianboolean;
    private Typeface typeFace;
    private Typeface typeFace2;
    private TextView version;
    private View view1;
    private View view2;
    private View view3;
    private View view4;
    private boolean widgetdetailfan;

    public AppDetailsActivity()
    {
        showgvappdetail = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progress_wheel.setVisibility(0);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        hidegvappdetail = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progress_wheel.setVisibility(8);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        appdetail = new BroadcastReceiver() {

            final AppDetailsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                try
                {
                    db = new FinalDBChen(AppDetailsActivity.this, getDatabasePath("download2.db").getAbsolutePath());
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
                    (new AsyncTask() {

                        final _cls3 this$1;

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
                            badgedownimg.setText(s);
                            badgedownimg.show();
                        }

            
            {
                this$1 = _cls3.this;
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
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        handler = new Handler() {

            final AppDetailsActivity this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR tableswitch 1 3: default 36
            //                           1 37
            //                           2 51
            //                           3 59;
                   goto _L1 _L2 _L3 _L4
_L1:
                return;
_L2:
                Toast.makeText(AppDetailsActivity.this, "Failed to connect server.", 0).show();
                return;
_L3:
                Mydialog();
                return;
_L4:
                Toast.makeText(AppDetailsActivity.this, (new StringBuilder("'")).append(model.getTitle()).append("' is added to download queue.").toString(), 0).show();
                message = new Intent();
                message.setAction("appdetail");
                sendBroadcast(message);
                if (!Myutils.iswidget)
                {
                    message = new Intent(AppDetailsActivity.this, com/allinone/free/activity/DownloadsActivity);
                    startActivity(message);
                    Myutils.iswidget2 = true;
                    finish();
                    return;
                }
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
        tuijianboolean = Boolean.valueOf(false);
        publictools = null;
        dbUtils = null;
        sp_config = null;
        shoufengqing = true;
        typeFace = null;
        widgetdetailfan = false;
        isfbshow = false;
        isshowinmobi = false;
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b003e)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        }).show();
    }

    private void ShowResult(String s)
    {
        gvlist = new ArrayList();
        gvlist.addAll(Myutils.parseApplist(s));
        adapter = new AppGridviewAdapter(getApplicationContext(), gvlist, "appgvdetail");
        appdetailgv.setAdapter(adapter);
        apprecentlistViewbottom();
    }

    private void apprecentlistViewbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)detailscroll.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(getApplicationContext(), 50F));
        detailscroll.setLayoutParams(layoutparams);
    }

    private void buildListener()
    {
        topredetail.setOnClickListener(this);
        detailtogift.setOnClickListener(this);
        appdetailsearch.setOnClickListener(this);
        appdetaildown.setOnClickListener(this);
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final AppDetailsActivity this$0;

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
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(this, 0x7f0c0064);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f06018a);
        Button button1 = (Button)dialog.findViewById(0x7f06018b);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = AppDetailsActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = AppDetailsActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(detailtogift);
    }

    private void failfile()
    {
        publicTools.app_detail_handler = new Handler() {

            private String content;
            private String id;
            private String size;
            final AppDetailsActivity this$0;
            private String type;

            public void handleMessage(Message message)
            {
                type = message.getData().getString("type");
                id = message.getData().getString("id");
                content = message.getData().getString("content");
                size = message.getData().getString("size");
                message.what;
                JVM INSTR tableswitch 1212 1212: default 76
            //                           1212 82;
                   goto _L1 _L2
_L1:
                super.handleMessage(message);
                return;
_L2:
                (new Thread(new Runnable() {

                    final _cls5 this$1;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=action=download_invalid&type=app&id=")).append(id).append("&size=").append(size).append("&content=").append(content).toString());
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                })).start();
                if (true) goto _L1; else goto _L3
_L3:
            }




            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        };
    }

    private void init()
    {
        widgetdetailfan = getIntent().getBooleanExtra("widgetdetailfan", false);
        detailtoprel = (RelativeLayout)findViewById(0x7f06008a);
        detailline = (LinearLayout)findViewById(0x7f060094);
        desctv = (TextView)findViewById(0x7f0600a2);
        view1 = findViewById(0x7f060093);
        view2 = findViewById(0x7f06009a);
        view3 = findViewById(0x7f0600a1);
        view4 = findViewById(0x7f0600a4);
        desctv.setTypeface(typeFace);
        topredetail = (RelativeLayout)findViewById(0x7f060095);
        detailtogift = (ImageView)findViewById(0x7f060087);
        detailscroll = (ScrollView)findViewById(0x7f060089);
        appdetailgv = (GridView)findViewById(0x7f060099);
        appdetailsearch = (ImageView)findViewById(0x7f060086);
        appdetaildown = (ImageView)findViewById(0x7f060088);
        mAnimImageView = (ImageView)findViewById(0x7f060076);
        mAnimation = AnimationUtils.loadAnimation(this, 0x7f040006);
        badgedownimg = new BadgeView(getApplicationContext(), appdetaildown);
        publictools = new publicTools(this);
        detailfan = (ImageView)findViewById(0x7f060084);
        banner = (LinearLayout)findViewById(0x7f060067);
        sp_config = getSharedPreferences("banner_type", 0);
        detailfan.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                if (tuijianboolean.booleanValue())
                {
                    startActivity(new Intent(AppDetailsActivity.this, com/allinone/free/activity/MyMainActivity));
                    finish();
                } else
                {
                    finish();
                }
                if (widgetdetailfan && !Myutils.detail_save)
                {
                    startActivity(new Intent(AppDetailsActivity.this, com/allinone/free/start_welcome/MainActivity));
                    finish();
                    return;
                } else
                {
                    finish();
                    return;
                }
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        detailback = (TextView)findViewById(0x7f060085);
        default_options = new HashMap();
        default_options.put("save_cookie", Integer.valueOf(0));
        default_options.put("send_cookie", Integer.valueOf(0));
        default_options.put("show_header", Integer.valueOf(0));
        default_options.put("redirect", Integer.valueOf(1));
        try
        {
            db = new FinalDBChen(getmContext(), getDatabasePath("download2.db").getAbsolutePath());
            ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
        }
        catch (Exception exception1) { }
        spnetworkre = getSharedPreferences("network", 0);
        try
        {
            if (dbUtils == null)
            {
                dbUtils = new TypeDbUtils(this);
            }
        }
        catch (Exception exception) { }
        app = (MyApplcation)getApplicationContext();
        progress_wheel = (ProgressWheel)findViewById(0x7f060075);
        appdetailicon = (ImageView)findViewById(0x7f06008b);
        appdetailtitle = (TextView)findViewById(0x7f06008c);
        detailplaytop = (ImageView)findViewById(0x7f06008d);
        device = (TextView)findViewById(0x7f0600a0);
        appdetailauthortitle = (TextView)findViewById(0x7f06008e);
        appdetailratingbar = (RatingBar)findViewById(0x7f06008f);
        version = (TextView)findViewById(0x7f06009c);
        date = (TextView)findViewById(0x7f06009d);
        downloads = (TextView)findViewById(0x7f06009f);
        detail = (TextView)findViewById(0x7f0600a3);
        mygallery = (Gallery)findViewById(0x7f060092);
        downloadapk = (Button)findViewById(0x7f060090);
        googleplay = (Button)findViewById(0x7f060091);
        downloadapk.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                (new AsyncTask() {

                    final _cls9 this$1;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        try
                        {
                            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(id).append("&from=apk").toString());
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[]) { }
                        return null;
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                }).execute(new Void[0]);
                if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
                {
                    downwifi();
                    return;
                }
                if (dbUtils.queryfile(model.getId()) == null)
                {
                    MydownloadApk(model.getId(), model.getTitle(), model.getIcon(), model.getSerial());
                    return;
                } else
                {
                    Mydialog();
                    return;
                }
            }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        googleplay.setOnClickListener(new android.view.View.OnClickListener() {

            final AppDetailsActivity this$0;

            public void onClick(View view)
            {
                (new Thread(new Runnable() {

                    final _cls10 this$1;

                    public void run()
                    {
                        try
                        {
                            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(model.getId()).append("&from=google").toString());
                            return;
                        }
                        catch (Exception exception)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                })).start();
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(model.getId()).toString()));
                startActivity(view);
            }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        appdetailtop = (RelativeLayout)findViewById(0x7f060083);
    }

    private void inmobgift()
    {
        nativeAdaio = new IMNative("dd15bc6e28814b60a1b162840af80d88", new IMNativeListener() {

            final AppDetailsActivity this$0;

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
                    imnative.attachToView(appdetailtop);
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
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        nativeAdaio.loadAd();
    }

    public void MydownloadApk(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final AppDetailsActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*********").toString());
                    if (TextUtils.isEmpty(avoid))
                    {
                        avoid = new Message();
                        avoid.what = 1;
                        handler.sendMessage(avoid);
                        if (content.length() > 100)
                        {
                            avoid = content.substring(0, 100);
                        } else
                        {
                            avoid = content;
                        }
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id=")).append(id).append("&status=fail_get_url&version=").append("3.0.9").append("&content=").append(avoid).toString());
                    } else
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                    } else
                    {
                        String s1 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(avoid);
                        d.setFilePath(s1);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("app");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 3;
                        handler.sendMessage(avoid);
                    }
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progress_wheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progress_wheel.setVisibility(0);
                }

            
            {
                this$0 = AppDetailsActivity.this;
                id = s;
                title = s2;
                icon = s3;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.0.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void initView()
    {
        super.initView();
        try
        {
            new FinalDBChen(getmContext(), "download2.db", new DownloadMovieItem(), "downloadtask2", null);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
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

        case 2131099782: 
            startActivity(new Intent(this, com/allinone/free/activity/AppRecommendKeywordsActivity));
            return;

        case 2131099783: 
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

        case 2131099797: 
            startActivity(new Intent(this, com/allinone/free/activity/AppActivity));
            return;

        case 2131099784: 
            startActivity(new Intent(this, com/allinone/free/activity/DownloadsActivity));
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030023);
        setmContext(this);
        Myutils.getInstance();
        Myutils.type_current = "app_detail";
        bundle = new IntentFilter();
        bundle.addAction("appdetail");
        registerReceiver(appdetail, bundle);
        bundle = new IntentFilter();
        bundle.addAction("showgvappdetail");
        registerReceiver(showgvappdetail, bundle);
        bundle = new IntentFilter();
        bundle.addAction("hidegvappdetail");
        registerReceiver(hidegvappdetail, bundle);
        init();
        buildListener();
        try
        {
            initView();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        try
        {
            id = getIntent().getStringExtra("myid");
            tuijianboolean = Boolean.valueOf(getIntent().getBooleanExtra("tuijianboolean", false));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        if (publicTools.isNetworkAvailable(getApplicationContext()))
        {
            (new Mya1()).execute(new Void[0]);
            (new Myagv()).execute(new Void[0]);
        }
        failfile();
        banner_type_name = sp_config.getString("banner_type", "admob");
        if (banner_type_name.equals("admob"))
        {
            adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-1054623928013334/2142631400");
            banner.addView(adView);
            adView.loadAd(new AdRequest());
        }
        mygallery.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppDetailsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                Log.e("www", (new StringBuilder("(Serializable) list")).append(list).toString());
                adapterview = new Intent(AppDetailsActivity.this, com/allinone/free/activity/ImagePagerActivity);
                adapterview.putExtra("screenshotlist", list);
                adapterview.putExtra("screenshotpos", i);
                startActivity(adapterview);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        appdetailgv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppDetailsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(AppDetailsActivity.this, com/allinone/free/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)gvlist.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
        });
        AdInterfaces.setAppInfo("779", "1237");
        adShuffle = AdInterfaces.getAdShffle(this);
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        try
        {
            typeFace = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
            typeFace2 = Typeface.createFromAsset(getAssets(), "Roboto-Condensed.ttf");
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
            if (widgetdetailfan && !Myutils.detail_save)
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
        int i;
        db = new FinalDBChen(this, getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
        i = ds.size();
        if (i != 0)
        {
            try
            {
                badgedownimg.setText(String.valueOf(i));
                badgedownimg.show();
                return;
            }
            catch (Exception exception) { }
            break MISSING_BLOCK_LABEL_96;
        }
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        badgedownimg.hide();
        return;
    }

    public void toDownload(DownloadMovieItem downloadmovieitem)
    {
        downloadmovieitem.setDownloadState(Integer.valueOf(7));
        getMyApp().setStartDownloadMovieItem(downloadmovieitem);
        sendBroadcast((new Intent()).setAction("download"));
        if (db.findItemsByWhereAndWhereValue("movieName", downloadmovieitem.getMovieName(), com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
        {
            db.insertObject(downloadmovieitem, "downloadtask2");
            return;
        } else
        {
            db.updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                downloadmovieitem.getMovieName()
            }, downloadmovieitem);
            return;
        }
    }

















































}
