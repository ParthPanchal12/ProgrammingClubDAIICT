// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.adapter.Home_Listview_Adapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.dialog.NewUpdateDialog;
import com.allinone.free.dialog.NointentDialog;
import com.allinone.free.dialog.NoupdareversionDialog;
import com.allinone.free.dialog.UpdateDialogVerison;
import com.allinone.free.dialog.UpdateDialogVerison2;
import com.allinone.free.dialog.WebFirstDialog;
import com.allinone.free.model.GameInfosVersionModel;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.service.MyService;
import com.allinone.free.utils.ImageUtil;
import com.allinone.free.utils.MD5;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.BadgeView;
import com.allinone.free.views.LDrawerButton;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import com.thin.downloadmanager.DownloadRequest;
import com.thin.downloadmanager.DownloadStatusListener;
import com.thin.downloadmanager.ThinDownloadManager;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.example.CustomActivity;
import com.yeahmobi.android.interfaces.AdInterfaces;
import com.yeahmobi.android.shuffle.AdShuffle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.activity:
//            PaidforFreeActivity, AppActivity, GameActivity, AppRecommendKeywordsActivity, 
//            DownloadsActivity, AdultActivity, FunActivity, TodaysPickActivity, 
//            MiniGamectivity, VideoActivity, Mp3Activity, RingtoneActivity, 
//            MySettingsActivity, AppDetailsActivity, WidgeGametActivity, WidgePaidActivity

public class MyMainActivity extends BaseActivity
    implements android.view.View.OnClickListener, com.allinone.free.refresh.PullableListView.OnLoadListener, OnDismissCallback, ContentValue, AdListener, InterstitialAdListener
{
    class MyAsyncTaskVersion extends AsyncTask
    {

        private ProgressDialog mProgressDialog;
        final MyMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            Object obj;
            Thread.sleep(1000L);
            obj = (HttpURLConnection)(new URL((new StringBuilder("http://app.loveitsomuch.com/gonglue_xilie/ping.php?id=")).append(Myutils.packagename2).append("&version=").append("3.0.9").toString())).openConnection();
            ((HttpURLConnection) (obj)).setConnectTimeout(5000);
            ((HttpURLConnection) (obj)).setRequestMethod("GET");
            Log.v("ggg", (new StringBuilder(String.valueOf(((HttpURLConnection) (obj)).getResponseCode()))).toString());
            if (((HttpURLConnection) (obj)).getResponseCode() != 200)
            {
                break MISSING_BLOCK_LABEL_212;
            }
            avoid = new StringBuffer();
            obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L1:
            String s = ((BufferedReader) (obj)).readLine();
            if (s == null)
            {
                try
                {
                    avoid = new JSONObject(avoid.toString());
                    if (avoid.getInt("status") == 1)
                    {
                        GameInfosVersionModel gameinfosversionmodel = new GameInfosVersionModel();
                        gameinfosversionmodel.setUpdatePath(avoid.getString("update_url"));
                        handlerversion.sendMessage(handlerversion.obtainMessage(564, gameinfosversionmodel));
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
                break MISSING_BLOCK_LABEL_212;
            }
            avoid.append(s);
              goto _L1
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            if (mProgressDialog != null && mProgressDialog.isShowing())
            {
                mProgressDialog.dismiss();
                mProgressDialog = null;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(MyMainActivity.this, null, "Loading......");
        }

        MyAsyncTaskVersion()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class MyDownloadListner
        implements DownloadStatusListener
    {

        final MyMainActivity this$0;

        public void onDownloadComplete(int i)
        {
            Log.i("jone", "download completed");
            if (i == downloadId1)
            {
                NewUpdateDialog newupdatedialog = new NewUpdateDialog(MyMainActivity.this, 0x7f0c0064);
                newupdatedialog.setCanceledOnTouchOutside(false);
                newupdatedialog.show();
                Button button = (Button)newupdatedialog.findViewById(0x7f0600e9);
                Button button1 = (Button)newupdatedialog.findViewById(0x7f0600ea);
                button.setOnClickListener(newupdatedialog. new android.view.View.OnClickListener() {

                    final MyDownloadListner this$1;
                    private final NewUpdateDialog val$dialog;

                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }

            
            {
                this$1 = final_mydownloadlistner;
                dialog = NewUpdateDialog.this;
                super();
            }
                });
                button1.setOnClickListener(newupdatedialog. new android.view.View.OnClickListener() {

                    final MyDownloadListner this$1;
                    private final NewUpdateDialog val$dialog;

                    public void onClick(View view)
                    {
                        updateaioApk();
                        dialog.dismiss();
                    }

            
            {
                this$1 = final_mydownloadlistner;
                dialog = NewUpdateDialog.this;
                super();
            }
                });
            }
        }

        public void onDownloadFailed(int i, int j, String s)
        {
            Log.i("jone", "DownloadFailed");
            if (i == downloadId1)
            {
                mProgress1.setProgress(0);
            }
        }

        public void onProgress(int i, long l, long l1, int j)
        {
            Log.i("jone", (new StringBuilder(String.valueOf(j))).toString());
            if (i == downloadId1)
            {
                mProgress1.setProgress(j);
            }
        }


        MyDownloadListner()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya1 extends AsyncTask
    {

        final MyMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient ArrayList doInBackground(Void avoid[])
        {
            String s = null;
            avoid = publicTools.getUrl(recommendurl);
label0:
            {
                s = avoid;
                if (avoid == null)
                {
                    return null;
                }
                break label0;
            }
            avoid;
            list2 = new ArrayList();
            if (s == null) goto _L2; else goto _L1
_L1:
            avoid = new JSONObject(s);
            if (avoid.getInt("status") != 1) goto _L2; else goto _L3
_L3:
            ppmodel = new DownloadMovieItem();
            int i;
            int j;
            try
            {
                if (run_time == 1 && !avoid.isNull("pdt"))
                {
                    JSONObject jsonobject = avoid.getJSONObject("pdt");
                    ppmodel.setId(jsonobject.getString("id"));
                    ppmodel.setIcon(jsonobject.getString("icon"));
                    ppmodel.setTitle(jsonobject.getString("title"));
                    ppmodel.setAuthor_title(jsonobject.getString("author_title"));
                    ppmodel.setShort_desc(jsonobject.getString("short_desc"));
                    ppmodel.setRating(Float.valueOf(Float.parseFloat(jsonobject.getString("rating"))));
                    ppmodel.setSerial(jsonobject.getInt("serial"));
                    ppmodel.setHas_apk(jsonobject.getString("has_apk"));
                    ppmodel.setIs_official(jsonobject.getString("is_official"));
                }
            }
            catch (Exception exception) { }
            avoid = avoid.getJSONArray("list");
            i = 0;
_L5:
            j = avoid.length();
            if (i < j) goto _L4; else goto _L2
_L2:
            return list2;
_L4:
            DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
            JSONObject jsonobject1 = avoid.getJSONObject(i);
            downloadmovieitem.setId(jsonobject1.getString("id"));
            downloadmovieitem.setSerial(jsonobject1.getInt("serial"));
            downloadmovieitem.setTitle(jsonobject1.getString("title"));
            downloadmovieitem.setAuthor_title(jsonobject1.getString("author_title"));
            downloadmovieitem.setIcon(jsonobject1.getString("icon"));
            downloadmovieitem.setSize(jsonobject1.getString("size"));
            downloadmovieitem.setRating(Float.valueOf(Float.parseFloat(jsonobject1.getString("rating"))));
            downloadmovieitem.setPrice(jsonobject1.getString("price"));
            downloadmovieitem.setHas_apk(jsonobject1.getString("has_apk"));
            downloadmovieitem.setIs_official(jsonobject1.getString("is_official"));
            list2.add(downloadmovieitem);
            i++;
              goto _L5
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
            return;
_L2:
            if (run_time != 1) goto _L1; else goto _L3
_L3:
            Object obj;
            TextView textview;
            TextView textview1;
            RatingBar ratingbar;
            Button button;
            Button button1;
            Object obj1;
            obj1 = new WebFirstDialog(MyMainActivity.this, 0x7f0c0064);
            ((WebFirstDialog) (obj1)).setCanceledOnTouchOutside(true);
            ((WebFirstDialog) (obj1)).show();
            obj = (ImageView)((WebFirstDialog) (obj1)).findViewById(0x7f060217);
            textview = (TextView)((WebFirstDialog) (obj1)).findViewById(0x7f060218);
            textview1 = (TextView)((WebFirstDialog) (obj1)).findViewById(0x7f06021b);
            arraylist = (TextView)((WebFirstDialog) (obj1)).findViewById(0x7f06021a);
            ratingbar = (RatingBar)((WebFirstDialog) (obj1)).findViewById(0x7f06021c);
            button = (Button)((WebFirstDialog) (obj1)).findViewById(0x7f06021d);
            button1 = (Button)((WebFirstDialog) (obj1)).findViewById(0x7f06021e);
            button.setOnClickListener(((_cls1) (obj1)). new android.view.View.OnClickListener() {

                final Mya1 this$1;
                private final WebFirstDialog val$dialog1;

                public void onClick(View view)
                {
                    if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(_fld0) != 1)
                    {
                        downwifi();
                        return;
                    }
                    if (dbUtils.queryfile(ppmodel.getId()) == null)
                    {
                        MydownloadApk(ppmodel.getId(), ppmodel.getTitle(), ppmodel.getIcon(), ppmodel.getSerial());
                    } else
                    {
                        Mydialog();
                    }
                    dialog1.dismiss();
                }

            
            {
                this$1 = final_mya1;
                dialog1 = WebFirstDialog.this;
                super();
            }
            });
            button1.setOnClickListener(((_cls2) (obj1)). new android.view.View.OnClickListener() {

                final Mya1 this$1;
                private final WebFirstDialog val$dialog1;

                public void onClick(View view)
                {
                    view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(ppmodel.getId()).toString()));
                    startActivity(view);
                    dialog1.dismiss();
                }

            
            {
                this$1 = final_mya1;
                dialog1 = WebFirstDialog.this;
                super();
            }
            });
            obj1 = ppmodel.getHas_apk();
            if (!((String) (obj1)).equals("1")) goto _L5; else goto _L4
_L4:
            button.setVisibility(0);
_L7:
            app.asyncLoadImage(ppmodel.getIcon(), ((ImageView) (obj)));
            textview.setText(ppmodel.getTitle());
            textview1.setText(ppmodel.getAuthor_title());
            ratingbar.setRating(ppmodel.getRating().floatValue());
            obj = ppmodel.getIs_official();
            if (((String) (obj)).equals("1"))
            {
                arraylist.setVisibility(0);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (((String) (obj1)).equals("0"))
            {
                button1.setVisibility(0);
            }
            if (true) goto _L7; else goto _L6
_L6:
            if (!((String) (obj)).equals("0")) goto _L1; else goto _L8
_L8:
            arraylist.setVisibility(8);
            return;
            arraylist;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }


        Mya1()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya2 extends AsyncTask
    {

        final MyMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=home&page=")).append(page).toString());
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

        Mya2()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya3 extends AsyncTask
    {

        final MyMainActivity this$0;

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
            this$0 = MyMainActivity.this;
            super();
        }
    }


    private static final int DOWNLOAD_THREAD_POOL_SIZE = 4;
    private static final String FILE1 = "http://tinyurl.com/allinone-downloader";
    public static final int UPDATE_TAG = 564;
    public static DrawerLayout mDrawerLayout;
    private File AIOUPDATEFILE;
    private File PRO_DIR;
    private AdShuffle adShuffle;
    private AdView adView;
    private Home_Listview_Adapter adapter;
    private MyApplcation app;
    private LinearLayout appline;
    private BadgeView badgedownimg;
    private BadgeView badgedowntv;
    private TextView badgetv;
    private String banner_type_name;
    private Bitmap bitmap;
    private LinearLayout datingline;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private int dianliang;
    private int downloadId1;
    private ThinDownloadManager downloadManager;
    private RelativeLayout downrelelativetv;
    private LDrawerButton drawerButtonLeft;
    private List ds;
    android.content.SharedPreferences.Editor editor;
    private LinearLayout facebookbanner;
    private LinearLayout gameline;
    private int h;
    Handler handler;
    Handler handlertimer;
    Handler handlerversion;
    Handler handlerversoin;
    private LinearLayout havetryline;
    private BroadcastReceiver hidehomeapp;
    private BroadcastReceiver homeapp;
    private String id;
    private String imbdownurl;
    private ImageView imginmobibanner;
    public int in_control;
    GameInfosVersionModel info;
    private LinearLayout inmobbanner;
    private InterstitialAd interstitialAd;
    private boolean isfbshow;
    private boolean isshowinmobi;
    android.view.View.OnClickListener itemsOnClick2;
    private LinearLayout leftapp;
    private TextView leftapptv;
    private LinearLayout leftdown;
    private TextView leftdowntv;
    private LinearLayout leftfd;
    private TextView leftfeedbacktv;
    private LinearLayout leftgame;
    private TextView leftgametv;
    private LinearLayout leftmini;
    private TextView leftminitv;
    private LinearLayout leftmusic;
    private TextView leftmusictv;
    private LinearLayout leftringtone;
    private TextView leftringtonetv;
    private TextView leftseetingtv;
    private LinearLayout leftsetting;
    private LinearLayout leftshare;
    private TextView leftsharetv;
    private LinearLayout leftupdate;
    private TextView leftupdatetv;
    private LinearLayout leftvideo;
    private TextView leftvideotv;
    private ArrayList list;
    private ArrayList list2;
    ArrayList list3;
    private PullableListView listView;
    ArrayList list_fun;
    private android.view.ViewGroup.LayoutParams lp;
    private ImageView mAnimImageView;
    private Animation mAnimation;
    private BroadcastReceiver mBatInfoReceiver;
    private View mLeftGravityView;
    private NotificationManager mNotificationManager;
    private NotificationManager mNotificationManager1;
    private NotificationManager mNotificationManager2;
    private NotificationManager mNotificationManager3;
    private ProgressBar mProgress1;
    private RelativeLayout main_tab_top;
    private MyDownloadListner myDownloadStatusListener;
    private IMNative nativeAdaio;
    private IMNative nativeAdaio2;
    private NativeAd nativeAdfb;
    private int neicui;
    private String newVersionUrl;
    private int next;
    private int not_paid;
    private BroadcastReceiver numbertip;
    PackageInfo packageInfo;
    private int page;
    private LinearLayout paidline;
    private RelativeLayout playnowline;
    private DownloadMovieItem ppmodel;
    private ProgressWheel progressWheel;
    private publicTools publictools;
    private String recommendurl;
    private DownloadRequest request1;
    private int run_time;
    SharedPreferences sharedPreferences;
    private BroadcastReceiver showhomeapp;
    private SharedPreferences sp_config;
    private SharedPreferences spnetworkre;
    public int status;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
    private RadioButton tab_app;
    private RadioButton tab_down;
    private RadioButton tab_game;
    private RadioButton tab_gift;
    private RadioGroup tab_group;
    private RadioButton tab_search;
    private String todayid;
    private Typeface typeFace;
    private UpdateDialogVerison updateDialog;
    UpdateDialogVerison updateDialogVersion;
    UpdateDialogVerison2 updateDialogVersion2;
    private String urlPath;
    private String url_id;
    private int w;
    private boolean windowFocus;

    public MyMainActivity()
    {
        myDownloadStatusListener = new MyDownloadListner();
        downloadId1 = 0;
        handlerversion = new Handler() {

            final MyMainActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.what != 564)
                {
                    break MISSING_BLOCK_LABEL_126;
                }
                message = (GameInfosVersionModel)message.obj;
                newVersionUrl = message.getUpdatePath();
                if (newVersionUrl.equals(""))
                {
                    break MISSING_BLOCK_LABEL_127;
                }
                message = new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view)
                    {
                        updateDialog.dismiss();
                        switch (view.getId())
                        {
                        case 2131099881: 
                        default:
                            return;

                        case 2131099882: 
                            view = new Intent("android.intent.action.VIEW", Uri.parse(newVersionUrl));
                            break;
                        }
                        startActivity(view);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                };
                updateDialog = new UpdateDialogVerison(MyMainActivity.this, 0x7f0c0066, message);
                updateDialog.show();
                updateDialog.setTvTitle((new StringBuilder("Update Time: ")).append(Myutils.timezhuanhua(System.currentTimeMillis())).append(DateFormat.format(" dd, yyyy", System.currentTimeMillis())).toString());
                return;
                message = new NoupdareversionDialog(MyMainActivity.this, 0x7f0c0064);
                message.setCanceledOnTouchOutside(false);
                message.show();
                ((TextView)message.findViewById(0x7f060189)).setText("Current version: 3.0.9 is the latest version.");
                ((Button)message.findViewById(0x7f06020e)).setOnClickListener(message. new android.view.View.OnClickListener() {

                    final _cls1 this$1;
                    private final NoupdareversionDialog val$dialog;

                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }

            
            {
                this$1 = final__pcls1;
                dialog = NoupdareversionDialog.this;
                super();
            }
                });
                return;
                message;
            }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        homeapp = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                try
                {
                    db = new FinalDBChen(MyMainActivity.this, getDatabasePath("download2.db").getAbsolutePath());
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
                            badgedownimg.setText(s);
                            badgedownimg.show();
                            badgedowntv.setText(String.valueOf(s));
                            badgedowntv.show();
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
                this$0 = MyMainActivity.this;
                super();
            }
        };
        showhomeapp = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        hidehomeapp = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        windowFocus = false;
        newVersionUrl = "";
        updateDialogVersion = null;
        updateDialogVersion2 = null;
        sp_config = null;
        banner_type_name = "";
        list_fun = new ArrayList();
        handlerversoin = new Handler() {

            final MyMainActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.what == 564 && windowFocus)
                {
                    info = (GameInfosVersionModel)message.obj;
                    message = info.getNtId();
                    newVersionUrl = info.getUpdatePath();
                    if (!newVersionUrl.equals(""))
                    {
                        Log.v("version", "777777");
                        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

                            final _cls5 this$1;

                            public void onClick(View view)
                            {
                                switch (view.getId())
                                {
                                default:
                                    return;

                                case 2131099881: 
                                    updateDialogVersion.dismiss();
                                    return;

                                case 2131099882: 
                                    view = new Intent("android.intent.action.VIEW", Uri.parse(newVersionUrl));
                                    break;
                                }
                                updateDialogVersion.dismiss();
                                startActivity(view);
                            }

            
            {
                this$1 = _cls5.this;
                super();
            }
                        };
                        updateDialogVersion = new UpdateDialogVerison(MyMainActivity.this, 0x7f0c0066, onclicklistener);
                        updateDialogVersion.setCanceledOnTouchOutside(false);
                        try
                        {
                            updateDialogVersion.setTvTitle((new StringBuilder("Update Time: ")).append(Myutils.timezhuanhua(System.currentTimeMillis())).append(DateFormat.format(" dd, yyyy", System.currentTimeMillis())).toString());
                        }
                        catch (Exception exception) { }
                    }
                    if (message != null && !"".equals(message))
                    {
                        try
                        {
                            packageInfo = getPackageManager().getPackageInfo(message, 0);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Message message)
                        {
                            packageInfo = null;
                            message.printStackTrace();
                        }
                        message = info.getNtPath();
                        if (packageInfo == null && message != null && !"".equals(message))
                        {
                            itemsOnClick2 = message. new android.view.View.OnClickListener() {

                                final _cls5 this$1;
                                private final String val$ntPath;

                                public void onClick(View view)
                                {
                                    switch (view.getId())
                                    {
                                    default:
                                        return;

                                    case 2131099884: 
                                        updateDialogVersion2.dismiss();
                                        return;

                                    case 2131099885: 
                                        view = new Intent("android.intent.action.VIEW", Uri.parse(ntPath));
                                        break;
                                    }
                                    updateDialogVersion2.dismiss();
                                    startActivity(view);
                                }

            
            {
                this$1 = final__pcls5;
                ntPath = String.this;
                super();
            }
                            };
                            message = new Message();
                            message.what = 10000;
                            handlertimer.sendMessageDelayed(message, 5000L);
                            Log.v("ppp", "10000");
                        }
                    }
                }
            }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        handlertimer = new Handler() {

            final MyMainActivity this$0;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR lookupswitch 2: default 32
            //                           20: 230
            //                           10000: 38;
                   goto _L1 _L2 _L3
_L1:
                super.handleMessage(message);
                return;
_L3:
                try
                {
                    if (System.currentTimeMillis() - Myutils.setting_json.getLong("neitui_time") > 0x2932e00L)
                    {
                        updateDialogVersion2 = new UpdateDialogVerison2(MyMainActivity.this, 0x7f0c0066, itemsOnClick2);
                        updateDialogVersion2.setCanceledOnTouchOutside(false);
                        updateDialogVersion2.show();
                        updateDialogVersion2.setTvTitle(info.getNtTitle());
                        updateDialogVersion2.setTvContent(info.getNtMsg());
                        updateDialogVersion2.setImgIcon(info.getPicPath());
                        Myutils.setting_json.put("neitui_time", System.currentTimeMillis());
                        Myutils.saveSetting();
                    }
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                    try
                    {
                        Myutils.setting_json.put("neitui_time", System.currentTimeMillis());
                        Myutils.saveSetting();
                    }
                    catch (JSONException jsonexception1)
                    {
                        jsonexception1.printStackTrace();
                    }
                    (new AsyncTask() {

                        final _cls6 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            try
                            {
                                Thread.sleep(40000L);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void avoid[])
                            {
                                avoid.printStackTrace();
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
                            updateDialogVersion2 = new UpdateDialogVerison2(_fld0, 0x7f0c0066, itemsOnClick2);
                            updateDialogVersion2.setCanceledOnTouchOutside(false);
                            updateDialogVersion2.show();
                            updateDialogVersion2.setTvTitle(info.getNtTitle());
                            updateDialogVersion2.setTvContent(info.getNtMsg());
                            updateDialogVersion2.setImgIcon(info.getPicPath());
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    }).execute(new Void[0]);
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (windowFocus)
                {
                    (new AsyncTask() {

                        final _cls6 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            try
                            {
                                Thread.sleep(20000L);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void avoid[])
                            {
                                avoid.printStackTrace();
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
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    }).execute(new Void[0]);
                }
                if (true) goto _L1; else goto _L4
_L4:
            }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        numbertip = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
                mAnimImageView.setVisibility(0);
                mAnimImageView.startAnimation(mAnimation);
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        handler = new Handler() {

            final MyMainActivity this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR lookupswitch 4: default 52
            //                           1: 53
            //                           2: 67
            //                           3: 75
            //                           250: 168;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return;
_L2:
                Toast.makeText(MyMainActivity.this, "Failed to connect server.", 0).show();
                return;
_L3:
                Mydialog();
                return;
_L4:
                Toast.makeText(MyMainActivity.this, (new StringBuilder("'")).append(ppmodel.getTitle()).append("' is added to download queue.").toString(), 0).show();
                message = new Intent();
                message.setAction("homeapp");
                sendBroadcast(message);
                mAnimImageView.setVisibility(0);
                mAnimImageView.startAnimation(mAnimation);
                return;
_L5:
                message = message.obj.toString();
                Log.e("www", message);
                try
                {
                    message = new JSONObject(message);
                    message.getInt("has_next_page");
                    if (message.getInt("status") == 1)
                    {
                        Object obj4 = message.getJSONArray("list");
                        Object obj = ((JSONArray) (obj4)).getJSONObject(0);
                        message = ((JSONObject) (obj)).getString("icon");
                        obj = ((JSONObject) (obj)).getString("price");
                        Object obj1 = ((JSONArray) (obj4)).getJSONObject(1);
                        String s = ((JSONObject) (obj1)).getString("icon");
                        obj1 = ((JSONObject) (obj1)).getString("price");
                        Object obj2 = ((JSONArray) (obj4)).getJSONObject(2);
                        String s1 = ((JSONObject) (obj2)).getString("icon");
                        obj2 = ((JSONObject) (obj2)).getString("price");
                        Object obj3 = ((JSONArray) (obj4)).getJSONObject(3);
                        String s2 = ((JSONObject) (obj3)).getString("icon");
                        obj3 = ((JSONObject) (obj3)).getString("price");
                        Object obj5 = ((JSONArray) (obj4)).getJSONObject(4);
                        String s3 = ((JSONObject) (obj5)).getString("icon");
                        obj5 = ((JSONObject) (obj5)).getString("price");
                        Object obj6 = ((JSONArray) (obj4)).getJSONObject(5);
                        String s4 = ((JSONObject) (obj6)).getString("icon");
                        obj6 = ((JSONObject) (obj6)).getString("price");
                        Object obj7 = ((JSONArray) (obj4)).getJSONObject(6);
                        String s5 = ((JSONObject) (obj7)).getString("icon");
                        obj7 = ((JSONObject) (obj7)).getString("price");
                        Object obj8 = ((JSONArray) (obj4)).getJSONObject(7);
                        obj4 = ((JSONObject) (obj8)).getString("icon");
                        ((JSONObject) (obj8)).getString("price");
                        obj8 = new Notification();
                        obj8.flags = 16;
                        obj8.icon = 0x7f020115;
                        Object obj9 = new Intent("android.intent.action.VIEW");
                        ((Intent) (obj9)).setClass(getApplicationContext(), com/allinone/free/activity/PaidforFreeActivity);
                        obj8.contentIntent = PendingIntent.getActivity(MyMainActivity.this, 54, ((Intent) (obj9)), 0x8000000);
                        obj9 = new RemoteViews(getPackageName(), 0x7f03007c);
                        ((RemoteViews) (obj9)).setTextViewText(0x7f0601ff, ((CharSequence) (obj)));
                        ((RemoteViews) (obj9)).setImageViewBitmap(0x7f0601fe, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(message)).toString()));
                        ((RemoteViews) (obj9)).setTextViewText(0x7f060201, ((CharSequence) (obj1)));
                        ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060200, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s)).toString()));
                        ((RemoteViews) (obj9)).setTextViewText(0x7f060203, ((CharSequence) (obj2)));
                        ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060202, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s1)).toString()));
                        ((RemoteViews) (obj9)).setTextViewText(0x7f060205, ((CharSequence) (obj3)));
                        ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060204, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s2)).toString()));
                        ((RemoteViews) (obj9)).setTextViewText(0x7f060207, ((CharSequence) (obj5)));
                        ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060206, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s3)).toString()));
                        ((RemoteViews) (obj9)).setTextViewText(0x7f060209, ((CharSequence) (obj6)));
                        ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060208, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s4)).toString()));
                        ((RemoteViews) (obj9)).setTextViewText(0x7f06020b, ((CharSequence) (obj7)));
                        ((RemoteViews) (obj9)).setImageViewBitmap(0x7f06020a, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s5)).toString()));
                        ((RemoteViews) (obj9)).setTextViewText(0x7f06020d, ((CharSequence) (obj7)));
                        ((RemoteViews) (obj9)).setImageViewBitmap(0x7f06020c, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(((String) (obj4)))).toString()));
                        obj8.contentView = ((RemoteViews) (obj9));
                        mNotificationManager2.notify(54, ((Notification) (obj8)));
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    message.printStackTrace();
                    return;
                }
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        progressWheel = null;
        url_id = "";
        recommendurl = "";
        run_time = 1;
        typeFace = null;
        dbUtils = null;
        publictools = null;
        not_paid = 0;
        list = new ArrayList();
        page = 1;
        next = 1;
        dianliang = 0;
        neicui = 0;
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        mBatInfoReceiver = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                int i;
                intent.getAction();
                i = intent.getIntExtra("level", 0);
                Log.e("qqq", (new StringBuilder("intLevel=")).append(i).toString());
                if (i >= 35 || dianliang != 0) goto _L2; else goto _L1
_L1:
                context = MyMainActivity.this;
                context.dianliang = ((MyMainActivity) (context)).dianliang + 1;
                context = null;
                intent = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                context = intent;
_L3:
                if (context == null)
                {
                    context = new Notification();
                    context.flags = 16;
                    context.icon = 0x7f020115;
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                    context.contentIntent = PendingIntent.getActivity(MyMainActivity.this, 52, intent, 0x8000000);
                    context.contentView = new RemoteViews(getPackageName(), 0x7f030077);
                    mNotificationManager.notify(52, context);
                }
                return;
                intent;
                intent.printStackTrace();
                if (true) goto _L3; else goto _L2
_L2:
                mNotificationManager.cancel(52);
                return;
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        list3 = new ArrayList();
        isshowinmobi = false;
        isfbshow = false;
        AIOUPDATEFILE = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOUPDATE").toString());
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b003e)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final MyMainActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        }).show();
    }

    private void Recommed_Url()
    {
        try
        {
            InputStream inputstream = getResources().openRawResource(0x7f050000);
            byte abyte0[] = new byte[inputstream.available()];
            inputstream.read(abyte0);
            inputstream.close();
            url_id = new String(abyte0);
            recommendurl = (new StringBuilder("http://android.downloadatoz.com/_201409/market/recommend_list_more.php?id=")).append(url_id).toString();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parsefeatured(s));
        Log.e("eee", (new StringBuilder("page=")).append(page).toString());
        adapter = new Home_Listview_Adapter(this, list, "homefeatured", list_fun);
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

    private void buildlistener()
    {
        leftdown.setOnClickListener(this);
        leftapp.setOnClickListener(this);
        leftgame.setOnClickListener(this);
        leftmini.setOnClickListener(this);
        leftvideo.setOnClickListener(this);
        leftmusic.setOnClickListener(this);
        leftringtone.setOnClickListener(this);
        leftfd.setOnClickListener(this);
        leftsetting.setOnClickListener(this);
        leftshare.setOnClickListener(this);
        leftupdate.setOnClickListener(this);
        tab_group.setOnClickListener(this);
        tab_app.setOnClickListener(this);
        tab_game.setOnClickListener(this);
        tab_gift.setOnClickListener(this);
        tab_search.setOnClickListener(this);
        tab_down.setOnClickListener(this);
        mDrawerLayout.setDrawerListener(new android.support.v4.widget.DrawerLayout.DrawerListener() {

            final MyMainActivity this$0;

            public void onDrawerClosed(View view)
            {
            }

            public void onDrawerOpened(View view)
            {
            }

            public void onDrawerSlide(View view, float f)
            {
                if (view == mLeftGravityView)
                {
                    drawerButtonLeft.onDrag(MyMainActivity.mDrawerLayout.isDrawerOpen(3), f);
                }
            }

            public void onDrawerStateChanged(int i)
            {
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        });
    }

    private void count()
    {
        int i = sharedPreferences.getInt("first", 0);
        if (i != 0) goto _L2; else goto _L1
_L1:
        PackageInfo packageinfo;
        publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=uninstall_click");
        packageinfo = null;
        PackageInfo packageinfo1 = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        packageinfo = packageinfo1;
_L4:
        if (packageinfo == null)
        {
            Notification notification = new Notification();
            notification.flags = 16;
            notification.icon = 0x7f020115;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
            notification.contentIntent = PendingIntent.getActivity(this, 55, intent, 0x8000000);
            notification.contentView = new RemoteViews(getPackageName(), 0x7f030076);
            mNotificationManager3.notify(55, notification);
        }
_L2:
        editor.putInt("first", i + 1);
        editor.commit();
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(this, 0x7f0c0064);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f06018a);
        Button button1 = (Button)dialog.findViewById(0x7f06018b);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = MyMainActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = MyMainActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(tab_gift);
    }

    private String getBytesDownloaded(int i, long l)
    {
        long l1 = ((long)i * l) / 100L;
        if (l >= 0xf4240L)
        {
            return (new StringBuilder()).append(String.format("%.1f", new Object[] {
                Float.valueOf((float)l1 / 1000000F)
            })).append("/").append(String.format("%.1f", new Object[] {
                Float.valueOf((float)l / 1000000F)
            })).append("MB").toString();
        }
        if (l >= 1000L)
        {
            return (new StringBuilder()).append(String.format("%.1f", new Object[] {
                Float.valueOf((float)l1 / 1000F)
            })).append("/").append(String.format("%.1f", new Object[] {
                Float.valueOf((float)l / 1000F)
            })).append("Kb").toString();
        } else
        {
            return (new StringBuilder()).append(l1).append("/").append(l).toString();
        }
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
            break MISSING_BLOCK_LABEL_56;
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
            break MISSING_BLOCK_LABEL_56;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_56;
        obj3;
        obj1 = obj5;
_L4:
        obj = obj1;
        ((IOException) (obj3)).printStackTrace();
        obj = obj4;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_56;
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
            break MISSING_BLOCK_LABEL_56;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_56;
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
        listView = (PullableListView)findViewById(0x7f060073);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        downrelelativetv = (RelativeLayout)findViewById(0x7f060071);
        leftdowntv = (TextView)findViewById(0x7f0601ad);
        leftapptv = (TextView)findViewById(0x7f0601af);
        leftgametv = (TextView)findViewById(0x7f0601b1);
        leftminitv = (TextView)findViewById(0x7f0601b3);
        leftvideotv = (TextView)findViewById(0x7f0601b5);
        leftmusictv = (TextView)findViewById(0x7f0601b7);
        leftringtonetv = (TextView)findViewById(0x7f0601b9);
        leftfeedbacktv = (TextView)findViewById(0x7f0601bb);
        leftseetingtv = (TextView)findViewById(0x7f0601bd);
        leftsharetv = (TextView)findViewById(0x7f0601bf);
        leftupdatetv = (TextView)findViewById(0x7f0601c1);
        badgetv = (TextView)findViewById(0x7f06017f);
        leftdown = (LinearLayout)findViewById(0x7f0601ac);
        leftapp = (LinearLayout)findViewById(0x7f0601ae);
        leftgame = (LinearLayout)findViewById(0x7f0601b0);
        leftmini = (LinearLayout)findViewById(0x7f0601b2);
        leftvideo = (LinearLayout)findViewById(0x7f0601b4);
        leftmusic = (LinearLayout)findViewById(0x7f0601b6);
        leftringtone = (LinearLayout)findViewById(0x7f0601b8);
        leftfd = (LinearLayout)findViewById(0x7f0601ba);
        leftsetting = (LinearLayout)findViewById(0x7f0601bc);
        leftshare = (LinearLayout)findViewById(0x7f0601be);
        leftupdate = (LinearLayout)findViewById(0x7f0601c0);
        sp_config = getSharedPreferences("banner_type", 0);
        AdInterfaces.setAppInfo("779", "1237");
        adShuffle = AdInterfaces.getAdShffle(this);
        mAnimImageView = (ImageView)findViewById(0x7f060076);
        Display display;
        int i;
        int j;
        try
        {
            typeFace = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        }
        catch (Exception exception1) { }
        leftdowntv.setTypeface(typeFace);
        leftapptv.setTypeface(typeFace);
        leftgametv.setTypeface(typeFace);
        leftminitv.setTypeface(typeFace);
        leftvideotv.setTypeface(typeFace);
        leftmusictv.setTypeface(typeFace);
        leftringtonetv.setTypeface(typeFace);
        leftfeedbacktv.setTypeface(typeFace);
        leftseetingtv.setTypeface(typeFace);
        leftsharetv.setTypeface(typeFace);
        leftupdatetv.setTypeface(typeFace);
        progressWheel = (ProgressWheel)findViewById(0x7f060075);
        app = (MyApplcation)getApplicationContext();
        tab_group = (RadioGroup)findViewById(0x7f06006b);
        tab_app = (RadioButton)findViewById(0x7f06006c);
        tab_game = (RadioButton)findViewById(0x7f06006d);
        tab_gift = (RadioButton)findViewById(0x7f06006e);
        tab_search = (RadioButton)findViewById(0x7f06006f);
        tab_down = (RadioButton)findViewById(0x7f060070);
        mDrawerLayout = (DrawerLayout)findViewById(0x7f060068);
        drawerButtonLeft = (LDrawerButton)findViewById(0x7f06006a);
        drawerButtonLeft.setOnClickListener(this);
        mLeftGravityView = findViewById(0x7f060074);
        lp = mLeftGravityView.getLayoutParams();
        display = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        i = display.getHeight();
        j = display.getWidth();
        lp.width = (int)((double)j * 0.84999999999999998D);
        lp.height = i;
        mLeftGravityView.setLayoutParams(lp);
        mAnimation = AnimationUtils.loadAnimation(this, 0x7f040007);
        publictools = new publicTools(this);
        default_options = new HashMap();
        default_options.put("save_cookie", Integer.valueOf(0));
        default_options.put("send_cookie", Integer.valueOf(0));
        default_options.put("show_header", Integer.valueOf(0));
        default_options.put("redirect", Integer.valueOf(1));
        try
        {
            db = new FinalDBChen(getmContext(), getDatabasePath("download2.db").getAbsolutePath());
        }
        catch (Exception exception) { }
        spnetworkre = getSharedPreferences("network", 0);
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final MyMainActivity this$0;

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
                this$0 = MyMainActivity.this;
                super();
            }
        });
        badgedownimg = new BadgeView(this, downrelelativetv);
        badgedowntv = new BadgeView(this, badgetv);
        main_tab_top = (RelativeLayout)findViewById(0x7f060069);
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
    }

    private void initDownload()
    {
        try
        {
            Uri uri = Uri.parse("http://tinyurl.com/allinone-downloader");
            Uri uri1 = Uri.parse(urlPath);
            Log.i("jone", urlPath);
            request1 = (new DownloadRequest(uri)).setDestinationURI(uri1).setPriority(com.thin.downloadmanager.DownloadRequest.Priority.HIGH).setDownloadListener(myDownloadStatusListener);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void initupdate()
    {
        mProgress1 = (ProgressBar)findViewById(0x7f060077);
        mProgress1.setMax(100);
        mProgress1.setProgress(0);
        downloadManager = new ThinDownloadManager(4);
    }

    private void inmobgift()
    {
        nativeAdaio = new IMNative("dd15bc6e28814b60a1b162840af80d88", new IMNativeListener() {

            final MyMainActivity this$0;

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
                    imnative.attachToView(main_tab_top);
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
                this$0 = MyMainActivity.this;
                super();
            }
        });
        nativeAdaio.loadAd();
    }

    private void inmoblist()
    {
        nativeAdaio2 = new IMNative("bf34144de1cf4616bca0c4acbdd94860", new IMNativeListener() {

            private String downloadurl;
            final MyMainActivity this$0;

            public void onNativeRequestFailed(IMErrorCode imerrorcode)
            {
                Log.e("ppp", (new StringBuilder("errorCode=")).append(imerrorcode.name()).toString());
                inmobbanner.setVisibility(8);
            }

            public void onNativeRequestSucceeded(IMNative imnative)
            {
                if (getResources().getConfiguration().locale.getCountry().equals("US") || getResources().getConfiguration().locale.getCountry().equals("ID"))
                {
                    inmobbanner.setVisibility(0);
                }
                nativeAdaio2 = imnative;
                if (imnative != null)
                {
                    imnative.attachToView(inmobbanner);
                }
                imnative = imnative.getContent();
                Log.e("ppp", imnative);
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

                            final _cls15 this$1;

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
                this$1 = _cls15.this;
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

                        final _cls15 this$1;

                        public void onClick(View view)
                        {
                            view = new Intent("android.intent.action.VIEW", Uri.parse(downloadurl));
                            startActivity(view);
                            if (nativeAdaio2 != null)
                            {
                                nativeAdaio2.handleClick(null);
                            }
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (IMNative imnative)
                {
                    imnative.printStackTrace();
                }
                Log.e("ppp", "success");
            }



            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        });
        nativeAdaio2.loadAd();
    }

    private void loadInterstitialAd()
    {
        interstitialAd = new InterstitialAd(this, "340186902832477_401798000004700");
        interstitialAd.setAdListener(this);
        interstitialAd.loadAd();
    }

    private void neiTui()
    {
        (new Thread(new Runnable() {

            final MyMainActivity this$0;

            public void run()
            {
                Log.v("version", "11111111getversion");
                Object obj1;
                String s = (new StringBuilder("http://app.loveitsomuch.com/gonglue_xilie/ping.php?id=")).append(Myutils.packagename2).append("&version=").append("3.0.9").toString();
                Log.e("path", s);
                obj1 = (HttpURLConnection)(new URL(s)).openConnection();
                ((HttpURLConnection) (obj1)).setConnectTimeout(60000);
                ((HttpURLConnection) (obj1)).setRequestMethod("GET");
                if (((HttpURLConnection) (obj1)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
                Object obj;
                obj = new StringBuffer();
                obj1 = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getInputStream()));
_L12:
                Object obj2 = ((BufferedReader) (obj1)).readLine();
                if (obj2 != null) goto _L4; else goto _L3
_L3:
                JSONObject jsonobject;
                jsonobject = new JSONObject(((StringBuffer) (obj)).toString());
                status = jsonobject.getInt("status");
                in_control = jsonobject.getInt("in_control");
                banner_type_name = jsonobject.getString("ad_banner");
                if (banner_type_name.equals("admob"))
                {
                    obj = new Message();
                    obj.what = 10;
                    handlertimer.sendMessage(((Message) (obj)));
                }
                sp_config.edit().putString("banner_type", banner_type_name).commit();
                Log.e("aaaa", (new StringBuilder("22222222status:")).append(status).toString());
                Log.e("aaaa", (new StringBuilder("3333333in_control")).append(in_control).toString());
                if (status != 1 || in_control != 0) goto _L2; else goto _L5
_L5:
                GameInfosVersionModel gameinfosversionmodel;
                gameinfosversionmodel = new GameInfosVersionModel();
                gameinfosversionmodel.setUpdatePath(jsonobject.getString("update_url"));
                if (gameinfosversionmodel.getUpdatePath().equals("")) goto _L7; else goto _L6
_L6:
                if (!AIOUPDATEFILE.exists()) goto _L9; else goto _L8
_L8:
                Log.e("www", "eeeeee");
                (new File((new StringBuilder()).append(AIOUPDATEFILE).append(File.separator).append("aioupdate.apk").toString())).delete();
_L10:
                if (downloadManager.query(downloadId1) == 32)
                {
                    downloadId1 = downloadManager.add(request1);
                }
_L7:
                Myutils.big_ad_interval = Integer.parseInt(jsonobject.getString("big_ad_interval")) * 1000;
                Log.v("fdfd", (new StringBuilder("dd")).append(Myutils.big_ad_interval).toString());
                if (!jsonobject.getString("big_ad_interval").equals("0"))
                {
                    (new Timer()).schedule(new TimerTask() {

                        final _cls23 this$1;

                        public void run()
                        {
                            Message message = new Message();
                            message.what = 20;
                            handlertimer.sendMessage(message);
                        }

            
            {
                this$1 = _cls23.this;
                super();
            }
                    }, 0L, Myutils.big_ad_interval);
                }
                obj2 = Boolean.valueOf(false);
                Boolean boolean1;
                boolean1 = Boolean.valueOf(false);
                obj = obj2;
                JSONArray jsonarray = jsonobject.getJSONArray("neitui_list");
                obj1 = obj2;
                obj = obj2;
                if (jsonarray.length() <= 0)
                {
                    break MISSING_BLOCK_LABEL_681;
                }
                obj = obj2;
                obj1 = Boolean.valueOf(true);
                obj = obj1;
                obj2 = jsonarray.getJSONObject(0);
                obj = obj1;
                gameinfosversionmodel.setNtTitle(((JSONObject) (obj2)).getString("headline"));
                obj = obj1;
                gameinfosversionmodel.setNtMsg(((JSONObject) (obj2)).getString("description"));
                obj = obj1;
                gameinfosversionmodel.setPicPath(((JSONObject) (obj2)).getString("thumb_url"));
                obj = obj1;
                gameinfosversionmodel.setNtPath(((JSONObject) (obj2)).getString("url"));
                obj = obj1;
                gameinfosversionmodel.setNtId(((JSONObject) (obj2)).getString("url_scheme"));
                obj = obj1;
                try
                {
                    Log.v("version", "44444");
                }
                catch (Exception exception)
                {
                    exception = ((Exception) (obj));
                }
                obj = boolean1;
                if (((Boolean) (obj1)).booleanValue())
                {
                    break MISSING_BLOCK_LABEL_735;
                }
                obj = boolean1;
                if (!jsonobject.getString("update_url").equals(""))
                {
                    obj = Boolean.valueOf(true);
                    gameinfosversionmodel.setNtPath(jsonobject.getString("update_url"));
                    Log.v("version", "55555");
                }
                if (((Boolean) (obj1)).booleanValue() || ((Boolean) (obj)).booleanValue())
                {
                    handlerversoin.sendMessage(handlerversoin.obtainMessage(564, gameinfosversionmodel));
                    Log.v("version", "66666");
                    return;
                }
                  goto _L2
_L4:
                try
                {
                    ((StringBuffer) (obj)).append(((String) (obj2)));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((Exception) (obj)).printStackTrace();
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L9:
                Log.e("www", "nnnnn");
                  goto _L10
_L2:
                return;
                if (true) goto _L12; else goto _L11
_L11:
            }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        })).start();
    }

    private void tongzhi()
    {
        Notification notification = new Notification();
        notification.flags = 16;
        notification.icon = 0x7f020115;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(getApplicationContext(), com/allinone/free/activity/PaidforFreeActivity);
        notification.contentIntent = PendingIntent.getActivity(this, 54, intent, 0x8000000);
        notification.contentView = new RemoteViews(getPackageName(), 0x7f03007c);
        mNotificationManager2.notify(54, notification);
    }

    private void updateaioApk()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOUPDATEFILE).append(File.separator).append("aioupdate.apk").toString()), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    private void viewtop()
    {
        View view = View.inflate(this, 0x7f030068, null);
        listView.addHeaderView(view, null, false);
        facebookbanner = (LinearLayout)view.findViewById(0x7f0601c2);
        appline = (LinearLayout)view.findViewById(0x7f06015c);
        gameline = (LinearLayout)view.findViewById(0x7f06015d);
        paidline = (LinearLayout)view.findViewById(0x7f06015e);
        datingline = (LinearLayout)view.findViewById(0x7f06015f);
        playnowline = (RelativeLayout)view.findViewById(0x7f060161);
        havetryline = (LinearLayout)view.findViewById(0x7f060162);
        appline.setOnClickListener(this);
        gameline.setOnClickListener(this);
        paidline.setOnClickListener(this);
        datingline.setOnClickListener(this);
        playnowline.setOnClickListener(this);
        havetryline.setOnClickListener(this);
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
                final MyMainActivity this$0;
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
                    Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*****").toString());
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
                    progressWheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progressWheel.setVisibility(0);
                }

            
            {
                this$0 = MyMainActivity.this;
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

    public String createSDCardDir(String s)
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/AIOUPDATE").toString());
            if (!file.exists())
            {
                file.mkdirs();
            }
            s = new File((new StringBuilder()).append(file).append(File.separator).append(s).toString());
            if (!s.exists())
            {
                try
                {
                    s.createNewFile();
                }
                catch (Exception exception) { }
                urlPath = s.getPath();
            }
        }
        return urlPath;
    }

    public void finish()
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(0x10000000);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    public int getHeight(int i, int j)
    {
        return (getResources().getDisplayMetrics().widthPixels * j) / i;
    }

    public long getmem_UNUSED(Context context)
    {
        context = (ActivityManager)context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        context.getMemoryInfo(memoryinfo);
        return memoryinfo.availMem / 1024L;
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
        view.getId();
        JVM INSTR lookupswitch 26: default 224
    //                   2131099754: 463
    //                   2131099756: 225
    //                   2131099757: 241
    //                   2131099758: 257
    //                   2131099759: 287
    //                   2131099760: 303
    //                   2131099996: 367
    //                   2131099997: 383
    //                   2131099998: 399
    //                   2131099999: 415
    //                   2131100001: 431
    //                   2131100002: 447
    //                   2131100004: 319
    //                   2131100008: 335
    //                   2131100013: 351
    //                   2131100076: 506
    //                   2131100078: 522
    //                   2131100080: 538
    //                   2131100082: 554
    //                   2131100084: 570
    //                   2131100086: 586
    //                   2131100088: 602
    //                   2131100090: 618
    //                   2131100092: 634
    //                   2131100094: 650
    //                   2131100096: 691;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27
_L1:
        return;
_L3:
        startActivity(new Intent(this, com/allinone/free/activity/AppActivity));
        return;
_L4:
        startActivity(new Intent(this, com/allinone/free/activity/GameActivity));
        return;
_L5:
        if (!isfbshow)
        {
            Toast.makeText(getApplicationContext(), "Loading...", 1).show();
            adShuffle.loadAds(false);
            return;
        }
          goto _L1
_L6:
        startActivity(new Intent(this, com/allinone/free/activity/AppRecommendKeywordsActivity));
        return;
_L7:
        startActivity(new Intent(this, com/allinone/free/activity/DownloadsActivity));
        return;
_L14:
        startActivity(new Intent(this, com/allinone/free/activity/AppActivity));
        return;
_L15:
        startActivity(new Intent(this, com/allinone/free/activity/GameActivity));
        return;
_L16:
        startActivity(new Intent(this, com/allinone/free/activity/AppActivity));
        return;
_L8:
        startActivity(new Intent(this, com/allinone/free/activity/AppActivity));
        return;
_L9:
        startActivity(new Intent(this, com/allinone/free/activity/GameActivity));
        return;
_L10:
        startActivity(new Intent(this, com/allinone/free/activity/PaidforFreeActivity));
        return;
_L11:
        startActivity(new Intent(this, com/allinone/free/activity/AdultActivity));
        return;
_L12:
        startActivity(new Intent(this, com/allinone/free/activity/FunActivity));
        return;
_L13:
        startActivity(new Intent(this, com/allinone/free/activity/TodaysPickActivity));
        return;
_L2:
        if (mDrawerLayout.isDrawerOpen(5))
        {
            mDrawerLayout.closeDrawer(5);
        }
        if (mDrawerLayout.isDrawerOpen(3))
        {
            mDrawerLayout.closeDrawer(3);
            return;
        } else
        {
            mDrawerLayout.openDrawer(3);
            return;
        }
_L17:
        startActivity(new Intent(this, com/allinone/free/activity/DownloadsActivity));
        return;
_L18:
        startActivity(new Intent(this, com/allinone/free/activity/AppActivity));
        return;
_L19:
        startActivity(new Intent(this, com/allinone/free/activity/GameActivity));
        return;
_L20:
        startActivity(new Intent(this, com/allinone/free/activity/MiniGamectivity));
        return;
_L21:
        startActivity(new Intent(this, com/allinone/free/activity/VideoActivity));
        return;
_L22:
        startActivity(new Intent(this, com/allinone/free/activity/Mp3Activity));
        return;
_L23:
        startActivity(new Intent(this, com/allinone/free/activity/RingtoneActivity));
        return;
_L24:
        startActivity(new Intent(this, com/umeng/fb/example/CustomActivity));
        return;
_L25:
        startActivity(new Intent(this, com/allinone/free/activity/MySettingsActivity));
        return;
_L26:
        view = new Intent("android.intent.action.SEND");
        view.setType("text/plain");
        view.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
        startActivity(Intent.createChooser(view, "AIO Downloaded"));
        return;
_L27:
        (new MyAsyncTaskVersion()).execute(new Void[0]);
        return;
    }

    protected void onCreate(final Bundle dialog)
    {
        super.onCreate(dialog);
        setContentView(0x7f03001d);
        setmContext(this);
        sharedPreferences = getSharedPreferences("countName_first", 0);
        editor = sharedPreferences.edit();
        sharedPreferences.getInt("first", 0);
        Myutils.iswidget = true;
        dialog = new Time();
        dialog.setToNow();
        int i = ((Time) (dialog)).hour;
        int j = ((Time) (dialog)).minute;
        double d;
        double d1;
        double d2;
        Object obj;
        Object obj2;
        if (i == 10 && j == 0 && not_paid == 0)
        {
            not_paid = not_paid + 1;
            (new Thread() {

                final MyMainActivity this$0;

                public void run()
                {
                    super.run();
                    StringBuffer stringbuffer;
                    Object obj3;
                    InputStream inputstream;
                    InputStreamReader inputstreamreader;
                    BufferedReader bufferedreader;
                    obj3 = (HttpURLConnection)(new URL("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_featured&page=1")).openConnection();
                    ((HttpURLConnection) (obj3)).setRequestMethod("GET");
                    ((HttpURLConnection) (obj3)).setConnectTimeout(5000);
                    ((HttpURLConnection) (obj3)).setReadTimeout(5000);
                    if (((HttpURLConnection) (obj3)).getResponseCode() != 200)
                    {
                        break MISSING_BLOCK_LABEL_174;
                    }
                    inputstream = ((HttpURLConnection) (obj3)).getInputStream();
                    inputstreamreader = new InputStreamReader(inputstream);
                    bufferedreader = new BufferedReader(inputstreamreader);
                    stringbuffer = new StringBuffer();
_L1:
                    String s = bufferedreader.readLine();
                    if (s == null)
                    {
                        try
                        {
                            bufferedreader.close();
                            inputstreamreader.close();
                            inputstream.close();
                            ((HttpURLConnection) (obj3)).disconnect();
                            obj3 = handler.obtainMessage();
                            obj3.what = 250;
                            obj3.obj = stringbuffer.toString();
                            handler.sendMessage(((Message) (obj3)));
                            return;
                        }
                        catch (MalformedURLException malformedurlexception)
                        {
                            malformedurlexception.printStackTrace();
                            return;
                        }
                        catch (IOException ioexception)
                        {
                            ioexception.printStackTrace();
                        }
                        break MISSING_BLOCK_LABEL_174;
                    }
                    stringbuffer.append(s);
                      goto _L1
                }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
            }).start();
        } else
        if (not_paid == 0 && i > 10 && i < 11)
        {
            not_paid = not_paid + 1;
            (new Thread() {

                final MyMainActivity this$0;

                public void run()
                {
                    super.run();
                    StringBuffer stringbuffer;
                    Object obj3;
                    InputStream inputstream;
                    InputStreamReader inputstreamreader;
                    BufferedReader bufferedreader;
                    obj3 = (HttpURLConnection)(new URL("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_featured&page=1")).openConnection();
                    ((HttpURLConnection) (obj3)).setRequestMethod("GET");
                    ((HttpURLConnection) (obj3)).setConnectTimeout(5000);
                    ((HttpURLConnection) (obj3)).setReadTimeout(5000);
                    if (((HttpURLConnection) (obj3)).getResponseCode() != 200)
                    {
                        break MISSING_BLOCK_LABEL_174;
                    }
                    inputstream = ((HttpURLConnection) (obj3)).getInputStream();
                    inputstreamreader = new InputStreamReader(inputstream);
                    bufferedreader = new BufferedReader(inputstreamreader);
                    stringbuffer = new StringBuffer();
_L1:
                    String s = bufferedreader.readLine();
                    if (s == null)
                    {
                        try
                        {
                            bufferedreader.close();
                            inputstreamreader.close();
                            inputstream.close();
                            ((HttpURLConnection) (obj3)).disconnect();
                            obj3 = handler.obtainMessage();
                            obj3.what = 250;
                            obj3.obj = stringbuffer.toString();
                            handler.sendMessage(((Message) (obj3)));
                            return;
                        }
                        catch (MalformedURLException malformedurlexception)
                        {
                            malformedurlexception.printStackTrace();
                            return;
                        }
                        catch (IOException ioexception)
                        {
                            ioexception.printStackTrace();
                        }
                        break MISSING_BLOCK_LABEL_174;
                    }
                    stringbuffer.append(s);
                      goto _L1
                }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
            }).start();
        }
        registerReceiver(mBatInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        mNotificationManager = (NotificationManager)getSystemService("notification");
        mNotificationManager1 = (NotificationManager)getSystemService("notification");
        mNotificationManager2 = (NotificationManager)getSystemService("notification");
        mNotificationManager3 = (NotificationManager)getSystemService("notification");
        d = getmem_TOLAL();
        d1 = getmem_UNUSED(getApplicationContext());
        d2 = d - d1;
        i = (int)((d2 / d) * 100D);
        Log.e("qqq", (new StringBuilder("total=")).append(d2 / d).append("totalwu=").append(d1).append("pen_mem=").append(i).toString());
        if (i <= 70 || neicui != 0) goto _L2; else goto _L1
_L1:
        neicui = neicui + 1;
        dialog = null;
        obj = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        dialog = ((Bundle) (obj));
_L3:
        if (dialog == null)
        {
            dialog = new Notification();
            dialog.flags = 16;
            dialog.icon = 0x7f020115;
            obj = new Intent("android.intent.action.VIEW");
            ((Intent) (obj)).setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
            dialog.contentIntent = PendingIntent.getActivity(this, 53, ((Intent) (obj)), 0x8000000);
            dialog.contentView = new RemoteViews(getPackageName(), 0x7f030078);
            mNotificationManager1.notify(53, dialog);
        }
_L4:
        Object obj1;
        try
        {
            todayid = getIntent().getStringExtra("todayid");
            id = getIntent().getStringExtra("myid");
            Log.v("rtrt", (new StringBuilder(String.valueOf(id))).append("3333333333333").toString());
            if (id != null)
            {
                dialog = new Intent(this, com/allinone/free/activity/AppDetailsActivity);
                dialog.putExtra("tuijianboolean", true);
                dialog.putExtra("myid", id);
                startActivity(dialog);
            }
            if (todayid != null)
            {
                dialog = new Intent(this, com/allinone/free/activity/TodaysPickActivity);
                dialog.putExtra("todayboolean", true);
                dialog.putExtra("todayid", todayid);
                startActivity(dialog);
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog) { }
        Myutils.packagename = getPackageName();
        publicTools.make_path_ready((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).toString());
        Myutils.recoverSetting();
        Myutils.record_run_times();
        Myutils.saveSetting();
        Myutils.detail_save = true;
        Myutils.today_save = true;
        try
        {
            if (!publicTools.isNetworkAvailable(this))
            {
                dialog = new NointentDialog(this, 0x7f0c0064);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                obj = (Button)dialog.findViewById(0x7f06018a);
                obj2 = (Button)dialog.findViewById(0x7f06018b);
                ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final MyMainActivity this$0;
                    private final NointentDialog val$dialog;

                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }

            
            {
                this$0 = MyMainActivity.this;
                dialog = nointentdialog;
                super();
            }
                });
                ((Button) (obj2)).setOnClickListener(new android.view.View.OnClickListener() {

                    final MyMainActivity this$0;
                    private final NointentDialog val$dialog;

                    public void onClick(View view)
                    {
                        startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                        dialog.dismiss();
                    }

            
            {
                this$0 = MyMainActivity.this;
                dialog = nointentdialog;
                super();
            }
                });
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog) { }
        try
        {
            if (publicTools.isNetworkAvailable(this))
            {
                publicTools.set_a_random_user_agent();
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog) { }
        try
        {
            run_time = Myutils.setting_json.getInt("run_times");
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        initView();
        init();
        buildlistener();
        neiTui();
        Recommed_Url();
        (new Mya3()).execute(new Void[0]);
        (new Mya2()).execute(new Void[0]);
        (new Mya1()).execute(new Void[0]);
        dialog = new IntentFilter();
        dialog.addAction("homeapp");
        registerReceiver(numbertip, dialog);
        dialog = new IntentFilter();
        dialog.addAction("showhomefeatured");
        registerReceiver(showhomeapp, dialog);
        dialog = new IntentFilter();
        dialog.addAction("hidehomefeatured");
        registerReceiver(hidehomeapp, dialog);
        dialog = new IntentFilter();
        dialog.addAction("homeapp");
        registerReceiver(homeapp, dialog);
        startService(new Intent(this, com/allinone/free/service/MyService));
        viewtop();
        try
        {
            adView = new AdView(this, "340186902832477_388101398041027", AdSize.RECTANGLE_HEIGHT_250);
            facebookbanner.addView(adView);
            adView.setAdListener(new AdListener() {

                final MyMainActivity this$0;

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
                this$0 = MyMainActivity.this;
                super();
            }
            });
            adView.loadAd();
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog) { }
        if (Myutils.setting_json.getBoolean("shotcut"))
        {
            if (Myutils.getVersionName(this).equals("3.0.9"))
            {
                break MISSING_BLOCK_LABEL_1318;
            }
            Myutils.setting_json.put("shotcut", false);
            Myutils.saveSetting();
        }
_L5:
        try
        {
            if (!Myutils.setting_json.getBoolean("shotcut"))
            {
                dialog = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                obj = android.content.Intent.ShortcutIconResource.fromContext(this, 0x7f020113);
                obj2 = new Intent(this, com/allinone/free/activity/WidgeGametActivity);
                dialog.putExtra("android.intent.extra.shortcut.NAME", getString(0x7f0b000e));
                dialog.putExtra("duplicate", false);
                dialog.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ((android.os.Parcelable) (obj)));
                dialog.putExtra("android.intent.extra.shortcut.INTENT", ((android.os.Parcelable) (obj2)));
                sendBroadcast(dialog);
                dialog = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                obj = android.content.Intent.ShortcutIconResource.fromContext(this, 0x7f020114);
                obj2 = new Intent(this, com/allinone/free/activity/WidgePaidActivity);
                dialog.putExtra("android.intent.extra.shortcut.NAME", getString(0x7f0b000f));
                dialog.putExtra("duplicate", false);
                dialog.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ((android.os.Parcelable) (obj)));
                dialog.putExtra("android.intent.extra.shortcut.INTENT", ((android.os.Parcelable) (obj2)));
                sendBroadcast(dialog);
                Myutils.setting_json.put("shotcut", true);
                Myutils.saveSetting();
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        createSDCardDir("aioupdate.apk");
        initupdate();
        initDownload();
        count();
        return;
        obj1;
        ((android.content.pm.PackageManager.NameNotFoundException) (obj1)).printStackTrace();
          goto _L3
_L2:
        mNotificationManager1.cancel(53);
          goto _L4
        try
        {
            Myutils.setting_json.put("shotcut", true);
            Myutils.saveSetting();
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            try
            {
                Myutils.setting_json.put("shotcut", false);
                Myutils.saveSetting();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((JSONException) (obj1)).printStackTrace();
            }
            dialog.printStackTrace();
        }
          goto _L5
    }

    protected void onDestroy()
    {
        adView.destroy();
        super.onDestroy();
        downloadManager.release();
        if (interstitialAd != null)
        {
            interstitialAd.destroy();
        }
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onError(Ad ad, AdError aderror)
    {
        Log.e("www", (new StringBuilder("error")).append(aderror.getErrorMessage()).toString());
    }

    public void onInterstitialDismissed(Ad ad)
    {
    }

    public void onInterstitialDisplayed(Ad ad)
    {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return super.onKeyDown(i, keyevent);
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
            (new Mya2()).execute(new Void[0]);
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
        windowFocus = false;
        Log.e("www", "onPause");
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
        windowFocus = true;
        int i;
        try
        {
            publicTools.getKey();
        }
        catch (Exception exception) { }
        db = new FinalDBChen(this, getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
        i = ds.size();
        if (i != 0)
        {
            badgedownimg.setText(String.valueOf(i));
            badgedownimg.show();
            badgedowntv.setText(String.valueOf(i));
            badgedowntv.show();
        } else
        if (i == 0)
        {
            badgedownimg.hide();
            badgedowntv.hide();
            return;
        }
    }

    protected void onStop()
    {
        super.onStop();
        publicTools.tagtanchuang = false;
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
