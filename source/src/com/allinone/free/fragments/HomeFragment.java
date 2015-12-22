// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.activity.AdultActivity;
import com.allinone.free.activity.AppActivity;
import com.allinone.free.activity.AppDetailsActivity;
import com.allinone.free.activity.GameActivity;
import com.allinone.free.activity.MiniGamectivity;
import com.allinone.free.activity.PaidforFreeActivity;
import com.allinone.free.activity.TodaysPickActivity;
import com.allinone.free.adapter.AppGridviewAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.dialog.NointentDialog;
import com.allinone.free.dialog.UpdateDialogVerison;
import com.allinone.free.dialog.UpdateDialogVerison2;
import com.allinone.free.dialog.WebFirstDialog;
import com.allinone.free.model.GameInfosVersionModel;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.service.MyService;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.OverScrollView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.fragments:
//            BaseFragment

public class HomeFragment extends BaseFragment
    implements android.view.View.OnClickListener
{
    class Mya1 extends AsyncTask
    {

        final HomeFragment this$0;

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
            list = new ArrayList();
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
            return list;
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
            list.add(downloadmovieitem);
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
            apphomegvrecomadapter = new AppGridviewAdapter(getActivity(), arraylist, "appgvhome");
            apphomegvrecom.setAdapter(apphomegvrecomadapter);
            progressWheel.setVisibility(8);
            apphomegvrecomadapter.notifyDataSetChanged();
            tvrecom.setVisibility(0);
            if (run_time != 1) goto _L1; else goto _L3
_L3:
            Object obj;
            TextView textview;
            TextView textview1;
            RatingBar ratingbar;
            Button button;
            Button button1;
            Object obj1;
            obj1 = new WebFirstDialog(getActivity(), 0x7f0c0064);
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
                    if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(getActivity()) != 1)
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
            this$0 = HomeFragment.this;
            super();
        }
    }

    class Myagv1 extends AsyncTask
    {

        final HomeFragment this$0;

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
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        Myagv1()
        {
            this$0 = HomeFragment.this;
            super();
        }
    }

    class Myagv2 extends AsyncTask
    {

        final HomeFragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            String s = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_ad_2");
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
                ShowResult2(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        Myagv2()
        {
            this$0 = HomeFragment.this;
            super();
        }
    }

    class Myagv3 extends AsyncTask
    {

        final HomeFragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            String s = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_ad_3");
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
                ShowResult3(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        Myagv3()
        {
            this$0 = HomeFragment.this;
            super();
        }
    }


    public static final int UPDATE_TAG = 564;
    private AdView adView;
    private AppGridviewAdapter adaptergv1;
    private AppGridviewAdapter adaptergv2;
    private AppGridviewAdapter adaptergv3;
    private MyApplcation app;
    private GridView apphomegv1;
    private GridView apphomegv2;
    private GridView apphomegv3;
    private GridView apphomegvrecom;
    private AppGridviewAdapter apphomegvrecomadapter;
    private LinearLayout appline;
    private String banner_type_name;
    private LinearLayout bannerfacebook;
    private LinearLayout datingline;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private LinearLayout gameline;
    private LinearLayout gvline1;
    private LinearLayout gvline2;
    private LinearLayout gvline3;
    private ArrayList gvlist1;
    private ArrayList gvlist2;
    private ArrayList gvlist3;
    Handler handler;
    Handler handlertimer;
    Handler handlerversoin;
    private LinearLayout havetryline;
    private BroadcastReceiver hidehomeapp;
    public int in_control;
    GameInfosVersionModel info;
    android.view.View.OnClickListener itemsOnClick2;
    private ArrayList list;
    private ImageView mAnimImageView;
    private Animation mAnimation;
    private String newVersionUrl;
    private BroadcastReceiver numbertip;
    PackageInfo packageInfo;
    private LinearLayout paidline;
    private LinearLayout playnowline;
    private DownloadMovieItem ppmodel;
    private ProgressWheel progressWheel;
    private publicTools publictools;
    private String recommendurl;
    private int run_time;
    private OverScrollView scrollview;
    private BroadcastReceiver showhomeapp;
    private SharedPreferences sp_config;
    private SharedPreferences spnetworkre;
    public int status;
    private RelativeLayout topre1;
    private RelativeLayout topre2;
    private RelativeLayout topre3;
    private TextView tvrecom;
    private Typeface typeFace;
    UpdateDialogVerison updateDialogVersion;
    UpdateDialogVerison2 updateDialogVersion2;
    private String url_id;
    private boolean windowFocus;

    public HomeFragment()
    {
        showhomeapp = new BroadcastReceiver() {

            final HomeFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        };
        hidehomeapp = new BroadcastReceiver() {

            final HomeFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
            }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        };
        windowFocus = false;
        newVersionUrl = "";
        updateDialogVersion = null;
        updateDialogVersion2 = null;
        sp_config = null;
        banner_type_name = "";
        handlerversoin = new Handler() {

            final HomeFragment this$0;

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

                            final _cls3 this$1;

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
                this$1 = _cls3.this;
                super();
            }
                        };
                        updateDialogVersion = new UpdateDialogVerison(getActivity(), 0x7f0c0066, onclicklistener);
                        updateDialogVersion.setCanceledOnTouchOutside(false);
                        updateDialogVersion.show();
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
                            packageInfo = getActivity().getPackageManager().getPackageInfo(message, 0);
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

                                final _cls3 this$1;
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
                this$1 = final__pcls3;
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
                this$0 = HomeFragment.this;
                super();
            }
        };
        handlertimer = new Handler() {

            final HomeFragment this$0;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR lookupswitch 2: default 32
            //                           20: 233
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
                        updateDialogVersion2 = new UpdateDialogVerison2(getActivity(), 0x7f0c0066, itemsOnClick2);
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

                        final _cls4 this$1;

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
                            updateDialogVersion2 = new UpdateDialogVerison2(getActivity(), 0x7f0c0066, itemsOnClick2);
                            updateDialogVersion2.setCanceledOnTouchOutside(false);
                            updateDialogVersion2.show();
                            updateDialogVersion2.setTvTitle(info.getNtTitle());
                            updateDialogVersion2.setTvContent(info.getNtMsg());
                            updateDialogVersion2.setImgIcon(info.getPicPath());
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    }).execute(new Void[0]);
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (windowFocus)
                {
                    (new AsyncTask() {

                        final _cls4 this$1;

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
                this$1 = _cls4.this;
                super();
            }
                    }).execute(new Void[0]);
                }
                if (true) goto _L1; else goto _L4
_L4:
            }


            
            {
                this$0 = HomeFragment.this;
                super();
            }
        };
        numbertip = new BroadcastReceiver() {

            final HomeFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
                mAnimImageView.setVisibility(0);
                mAnimImageView.startAnimation(mAnimation);
            }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        };
        handler = new Handler() {

            final HomeFragment this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    Toast.makeText(getActivity(), "Failed to connect server.", 0).show();
                    return;

                case 2: // '\002'
                    Mydialog();
                    return;

                case 3: // '\003'
                    Toast.makeText(getActivity(), (new StringBuilder("'")).append(ppmodel.getTitle()).append("' is added to download queue.").toString(), 0).show();
                    break;
                }
                message = new Intent();
                message.setAction("homeapp");
                getActivity().sendBroadcast(message);
                mAnimImageView.setVisibility(0);
                mAnimImageView.startAnimation(mAnimation);
            }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        };
        dbUtils = null;
        publictools = null;
        url_id = "";
        recommendurl = "";
        progressWheel = null;
        run_time = 1;
        typeFace = null;
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(getActivity())).setTitle(getString(0x7f0b003e)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final HomeFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = HomeFragment.this;
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
        gvlist1 = new ArrayList();
        gvlist1.addAll(Myutils.parseApplist(s));
        adaptergv1 = new AppGridviewAdapter(getActivity(), gvlist1, "appgvhome");
        apphomegv1.setAdapter(adaptergv1);
        gvline1.setVisibility(0);
    }

    private void ShowResult2(String s)
    {
        gvlist2 = new ArrayList();
        gvlist2.addAll(Myutils.parseApplist(s));
        adaptergv2 = new AppGridviewAdapter(getActivity(), gvlist2, "appgvhome");
        apphomegv2.setAdapter(adaptergv2);
        gvline2.setVisibility(0);
    }

    private void ShowResult3(String s)
    {
        gvlist3 = new ArrayList();
        gvlist3.addAll(Myutils.parseApplist(s));
        adaptergv3 = new AppGridviewAdapter(getActivity(), gvlist3, "appgvhome");
        apphomegv3.setAdapter(adaptergv3);
        gvline3.setVisibility(0);
    }

    private void buildListener()
    {
        topre1.setOnClickListener(this);
        topre2.setOnClickListener(this);
        topre3.setOnClickListener(this);
        appline.setOnClickListener(this);
        gameline.setOnClickListener(this);
        paidline.setOnClickListener(this);
        datingline.setOnClickListener(this);
        playnowline.setOnClickListener(this);
        havetryline.setOnClickListener(this);
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final HomeFragment this$0;

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
                this$0 = HomeFragment.this;
                super();
            }
        });
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(getActivity(), 0x7f0c0064);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f06018a);
        Button button1 = (Button)dialog.findViewById(0x7f06018b);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeFragment this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = HomeFragment.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeFragment this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = HomeFragment.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    private void init(View view)
    {
        tvrecom = (TextView)view.findViewById(0x7f060171);
        tvrecom.setTypeface(typeFace);
        topre1 = (RelativeLayout)view.findViewById(0x7f060164);
        topre2 = (RelativeLayout)view.findViewById(0x7f060168);
        topre3 = (RelativeLayout)view.findViewById(0x7f06016d);
        gvline1 = (LinearLayout)view.findViewById(0x7f060163);
        gvline2 = (LinearLayout)view.findViewById(0x7f060167);
        gvline3 = (LinearLayout)view.findViewById(0x7f06016c);
        apphomegv1 = (GridView)view.findViewById(0x7f060166);
        apphomegv2 = (GridView)view.findViewById(0x7f06016b);
        apphomegv3 = (GridView)view.findViewById(0x7f060170);
        scrollview = (OverScrollView)view.findViewById(0x7f06015a);
        FragmentActivity fragmentactivity = getActivity();
        getActivity();
        sp_config = fragmentactivity.getSharedPreferences("banner_type", 0);
        mAnimation = AnimationUtils.loadAnimation(getActivity(), 0x7f040007);
        mAnimImageView = (ImageView)view.findViewById(0x7f060076);
        appline = (LinearLayout)view.findViewById(0x7f06015c);
        gameline = (LinearLayout)view.findViewById(0x7f06015d);
        paidline = (LinearLayout)view.findViewById(0x7f06015e);
        datingline = (LinearLayout)view.findViewById(0x7f06015f);
        playnowline = (LinearLayout)view.findViewById(0x7f060161);
        havetryline = (LinearLayout)view.findViewById(0x7f060162);
        app = (MyApplcation)getActivity().getApplicationContext();
        progressWheel = (ProgressWheel)view.findViewById(0x7f060075);
        apphomegvrecom = (GridView)view.findViewById(0x7f060172);
        publictools = new publicTools(getActivity());
        default_options = new HashMap();
        default_options.put("save_cookie", Integer.valueOf(0));
        default_options.put("send_cookie", Integer.valueOf(0));
        default_options.put("show_header", Integer.valueOf(0));
        default_options.put("redirect", Integer.valueOf(1));
        try
        {
            db = new FinalDBChen(getmContext(), getActivity().getDatabasePath("download2.db").getAbsolutePath());
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        view = getActivity();
        getActivity();
        spnetworkre = view.getSharedPreferences("network", 0);
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(getActivity());
        }
    }

    private void neiTui()
    {
        (new Thread(new Runnable() {

            final HomeFragment this$0;

            public void run()
            {
                Log.v("version", "11111111getversion");
                Object obj;
                Object obj1;
                obj = (new StringBuilder("http://app.loveitsomuch.com/gonglue_xilie/ping.php?id=")).append(Myutils.packagename2).append("&version=").append("3.0.9").toString();
                Log.v("path", ((String) (obj)));
                obj1 = (HttpURLConnection)(new URL(((String) (obj)))).openConnection();
                ((HttpURLConnection) (obj1)).setConnectTimeout(60000);
                ((HttpURLConnection) (obj1)).setRequestMethod("GET");
                if (((HttpURLConnection) (obj1)).getResponseCode() != 200)
                {
                    break MISSING_BLOCK_LABEL_677;
                }
                obj = new StringBuffer();
                obj1 = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getInputStream()));
_L1:
                Object obj2 = ((BufferedReader) (obj1)).readLine();
                if (obj2 != null)
                {
                    break MISSING_BLOCK_LABEL_656;
                }
                JSONObject jsonobject;
                GameInfosVersionModel gameinfosversionmodel;
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
                Log.v("aaaa", (new StringBuilder("22222222status:")).append(status).toString());
                Log.v("aaaa", (new StringBuilder("3333333in_control")).append(in_control).toString());
                if (status != 1 || in_control != 0)
                {
                    break MISSING_BLOCK_LABEL_677;
                }
                gameinfosversionmodel = new GameInfosVersionModel();
                gameinfosversionmodel.setUpdatePath(jsonobject.getString("update_url"));
                Myutils.big_ad_interval = Integer.parseInt(jsonobject.getString("big_ad_interval")) * 1000;
                Log.v("fdfd", (new StringBuilder("dd")).append(Myutils.big_ad_interval).toString());
                if (!jsonobject.getString("big_ad_interval").equals("0"))
                {
                    (new Timer()).schedule(new TimerTask() {

                        final _cls19 this$1;

                        public void run()
                        {
                            Message message = new Message();
                            message.what = 20;
                            handlertimer.sendMessage(message);
                        }

            
            {
                this$1 = _cls19.this;
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
                    break MISSING_BLOCK_LABEL_551;
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
                    break MISSING_BLOCK_LABEL_606;
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
                break MISSING_BLOCK_LABEL_677;
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
                  goto _L1
            }


            
            {
                this$0 = HomeFragment.this;
                super();
            }
        })).start();
    }

    public void MydownloadApk(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(getActivity(), "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final HomeFragment this$0;
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
                        String s1 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getActivity().getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
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
                this$0 = HomeFragment.this;
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
        new FinalDBChen(getmContext(), "download2.db", new DownloadMovieItem(), "downloadtask2", null);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131100000: 
        case 2131100003: 
        case 2131100005: 
        case 2131100006: 
        case 2131100007: 
        case 2131100009: 
        case 2131100010: 
        case 2131100011: 
        case 2131100012: 
        default:
            return;

        case 2131100004: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/AppActivity));
            return;

        case 2131100008: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/GameActivity));
            return;

        case 2131100013: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/AppActivity));
            return;

        case 2131099996: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/AppActivity));
            return;

        case 2131099997: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/GameActivity));
            return;

        case 2131099998: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/PaidforFreeActivity));
            return;

        case 2131099999: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/AdultActivity));
            return;

        case 2131100001: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/MiniGamectivity));
            return;

        case 2131100002: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/TodaysPickActivity));
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup dialog, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030056, null, false);
        setmContext(getActivity());
        Myutils.packagename = getActivity().getPackageName();
        publicTools.make_path_ready((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).toString());
        Myutils.recoverSetting();
        Myutils.record_run_times();
        Myutils.saveSetting();
        try
        {
            if (!publicTools.isNetworkAvailable(getActivity()))
            {
                dialog = new NointentDialog(getActivity(), 0x7f0c0064);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                bundle = (Button)dialog.findViewById(0x7f06018a);
                Button button = (Button)dialog.findViewById(0x7f06018b);
                bundle.setOnClickListener(new android.view.View.OnClickListener() {

                    final HomeFragment this$0;
                    private final NointentDialog val$dialog;

                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }

            
            {
                this$0 = HomeFragment.this;
                dialog = nointentdialog;
                super();
            }
                });
                button.setOnClickListener(new android.view.View.OnClickListener() {

                    final HomeFragment this$0;
                    private final NointentDialog val$dialog;

                    public void onClick(View view)
                    {
                        startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                        dialog.dismiss();
                    }

            
            {
                this$0 = HomeFragment.this;
                dialog = nointentdialog;
                super();
            }
                });
            }
        }
        // Misplaced declaration of an exception variable
        catch (final ViewGroup dialog) { }
        try
        {
            if (publicTools.isNetworkAvailable(getActivity()))
            {
                publicTools.set_a_random_user_agent();
            }
        }
        // Misplaced declaration of an exception variable
        catch (final ViewGroup dialog) { }
        try
        {
            run_time = Myutils.setting_json.getInt("run_times");
        }
        // Misplaced declaration of an exception variable
        catch (final ViewGroup dialog)
        {
            dialog.printStackTrace();
        }
        Recommed_Url();
        init(layoutinflater);
        initView();
        buildListener();
        (new Mya1()).execute(new Void[0]);
        (new Myagv1()).execute(new Void[0]);
        (new Myagv2()).execute(new Void[0]);
        (new Myagv3()).execute(new Void[0]);
        apphomegvrecom.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/allinone/free/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)list.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        });
        apphomegv1.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/allinone/free/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)gvlist1.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        });
        apphomegv2.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/allinone/free/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)gvlist2.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        });
        apphomegv3.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/allinone/free/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)gvlist3.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
        });
        dialog = new IntentFilter();
        dialog.addAction("homeapp");
        getActivity().registerReceiver(numbertip, dialog);
        dialog = new IntentFilter();
        dialog.addAction("showhomeapp");
        getActivity().registerReceiver(showhomeapp, dialog);
        dialog = new IntentFilter();
        dialog.addAction("hidehomeapp");
        getActivity().registerReceiver(hidehomeapp, dialog);
        neiTui();
        dialog = new Intent(getActivity(), com/allinone/free/service/MyService);
        getActivity().startService(dialog);
        try
        {
            typeFace = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Light.ttf");
        }
        // Misplaced declaration of an exception variable
        catch (final ViewGroup dialog) { }
        try
        {
            bannerfacebook = (LinearLayout)layoutinflater.findViewById(0x7f06015b);
            adView = new AdView(getActivity(), "340186902832477_388101398041027", AdSize.RECTANGLE_HEIGHT_250);
            adView.setAdListener(new AdListener() {

                final HomeFragment this$0;

                public void onAdClicked(Ad ad)
                {
                }

                public void onAdLoaded(Ad ad)
                {
                    bannerfacebook.addView(adView);
                }

                public void onError(Ad ad, AdError aderror)
                {
                    Log.v("rtrtr", (new StringBuilder()).append(aderror).toString());
                }

            
            {
                this$0 = HomeFragment.this;
                super();
            }
            });
            adView.loadAd();
        }
        // Misplaced declaration of an exception variable
        catch (final ViewGroup dialog)
        {
            return layoutinflater;
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        adView.destroy();
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(getActivity());
        windowFocus = false;
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(getActivity());
        windowFocus = true;
        try
        {
            publicTools.getKey();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void toDownload(DownloadMovieItem downloadmovieitem)
    {
        downloadmovieitem.setDownloadState(Integer.valueOf(7));
        getMyApp().setStartDownloadMovieItem(downloadmovieitem);
        getActivity().sendBroadcast((new Intent()).setAction("download"));
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
