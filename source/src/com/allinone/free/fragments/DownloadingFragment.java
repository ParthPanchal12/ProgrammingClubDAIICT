// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadFile;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.DownloadTask;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.fragments:
//            BaseFragment

public class DownloadingFragment extends BaseFragment
    implements AdListener
{
    class DeleteTask
        implements com.allinone.free.mydownload.DownloadTask.OnDeleteTaskListener
    {

        private LinearLayout lin;
        final DownloadingFragment this$0;

        public void onDelete(final View taskView, DownloadMovieItem downloadmovieitem, Boolean boolean1)
        {
            if (boolean1.booleanValue())
            {
                lin.removeView(taskView);
                taskView = downloadmovieitem.getDownloadFile();
                if (taskView != null)
                {
                    taskView.stopDownload();
                }
                taskView = new File(downloadmovieitem.getFilePath());
                if (taskView.exists())
                {
                    taskView.delete();
                }
                (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "file_id=?", new String[] {
                    downloadmovieitem.getFile_id()
                });
                return;
            } else
            {
                (new android.app.AlertDialog.Builder(getmContext())).setTitle(getString(0x7f0b003e)).setMessage(getString(0x7f0b0044)).setNegativeButton(getString(0x7f0b0045), new android.content.DialogInterface.OnClickListener() {

                    final DeleteTask this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                    }

            
            {
                this$1 = DeleteTask.this;
                super();
            }
                }).setPositiveButton(getString(0x7f0b0046), downloadmovieitem. new android.content.DialogInterface.OnClickListener() {

                    final DeleteTask this$1;
                    private final DownloadMovieItem val$down;
                    private final View val$taskView;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        lin.removeView(taskView);
                        dialoginterface = down.getDownloadFile();
                        if (dialoginterface != null)
                        {
                            dialoginterface.stopDownload();
                        }
                        dialoginterface = new File(down.getFilePath());
                        if (dialoginterface.exists())
                        {
                            dialoginterface.delete();
                        }
                        (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "movieName=?", new String[] {
                            down.getMovieName()
                        });
                        dialoginterface = new Notification();
                        dialoginterface.flags = 16;
                        dialoginterface.icon = 0x7f020112;
                        Object obj = new Intent(getActivity(), com/allinone/free/activity/DownloadsActivity);
                        ((Intent) (obj)).setFlags(0x10000000);
                        dialoginterface.contentIntent = PendingIntent.getActivity(getActivity(), 110, ((Intent) (obj)), 0x8000000);
                        obj = new RemoteViews(getActivity().getPackageName(), 0x7f030079);
                        ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
                        ((RemoteViews) (obj)).setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(ds.size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
                        dialoginterface.contentView = ((RemoteViews) (obj));
                        DownloadingFragment.mNotificationManager.notify(110, dialoginterface);
                    }

            
            {
                this$1 = final_deletetask;
                taskView = view;
                down = DownloadMovieItem.this;
                super();
            }
                }).show();
                return;
            }
        }



        public DeleteTask(LinearLayout linearlayout)
        {
            this$0 = DownloadingFragment.this;
            super();
            lin = linearlayout;
        }
    }


    public static List downloadinglist = new ArrayList();
    public static NotificationManager mNotificationManager;
    private MyApplcation app;
    private Button app_download_bt;
    private RatingBar app_ratingbar;
    private TextView appauthortitle;
    private ImageView appicon;
    private TextView appprice;
    private TextView apptitle;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private DisplayMetrics displayMetrics;
    private TextView downloadingnotice;
    private List ds;
    private ArrayList gvlist;
    Handler handler;
    private String imgurl;
    private RelativeLayout inmobtop;
    private LinearLayout listview_lin;
    private BroadcastReceiver mBroadcastReceiver;
    private NativeAd nativeAd;
    private TextView official;
    private ProgressWheel progress_wheel;
    private int screenWidth;
    private BroadcastReceiver successful;
    private Typeface typeFace;
    private TextView xian;

    public DownloadingFragment()
    {
        handler = new Handler() {

            final DownloadingFragment this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 100: // 'd'
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
                    break;
                }
                if (ds.size() != 0)
                {
                    downloadingnotice.setVisibility(8);
                    return;
                } else
                {
                    downloadingnotice.setVisibility(0);
                    return;
                }
            }

            
            {
                this$0 = DownloadingFragment.this;
                super();
            }
        };
        mBroadcastReceiver = new BroadcastReceiver() {

            final DownloadingFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = getMyApp().getStartDownloadMovieItem();
                intent = getActivity().getLayoutInflater().inflate(0x7f030061, null);
                ImageView imageview = (ImageView)intent.findViewById(0x7f060193);
                String s = context.getMovieHeadImagePath();
                app.asyncLoadImage(s, imageview);
                context.setDownloadState(Integer.valueOf(7));
                listview_lin.addView(intent);
                (new DownloadTask(getmContext(), intent, context, false)).setOnDeleteTaskListener(new DeleteTask(listview_lin));
                if (context.getType().equals("app"))
                {
                    context = new Notification();
                    context.flags = 16;
                    context.icon = 0x7f020115;
                    intent = new Intent(getActivity(), com/allinone/free/activity/DownloadsActivity);
                    intent.setFlags(0x10000000);
                    context.contentIntent = PendingIntent.getActivity(getActivity(), 110, intent, 0x8000000);
                    intent = new RemoteViews(getActivity().getPackageName(), 0x7f030079);
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
                    intent.setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(ds.size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
                    intent.setTextViewText(0x7f0601f6, DateFormat.format("kk:mm", System.currentTimeMillis()));
                    context.contentView = intent;
                    DownloadingFragment.mNotificationManager.notify(110, context);
                }
            }

            
            {
                this$0 = DownloadingFragment.this;
                super();
            }
        };
        successful = new BroadcastReceiver() {

            final DownloadingFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                if (dbUtils == null)
                {
                    dbUtils = new TypeDbUtils(context);
                }
                (new Thread(new Runnable() {

                    final _cls3 this$1;

                    public void run()
                    {
                        Looper.prepare();
                        DownloadMovieItem downloadmovieitem = getMyApp().getDownloadSuccess();
                        dbUtils.insertApk(downloadmovieitem.getFile_id(), downloadmovieitem.getType(), downloadmovieitem.getMovieName(), downloadmovieitem.getMovieHeadImagePath(), downloadmovieitem.getFileSize(), downloadmovieitem.getFilePath(), downloadmovieitem.getSerial(), downloadmovieitem.getCreate_time());
                        (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "file_id=?", new String[] {
                            downloadmovieitem.getFile_id()
                        });
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                })).start();
            }


            
            {
                this$0 = DownloadingFragment.this;
                super();
            }
        };
        dbUtils = null;
        typeFace = null;
    }

    private void download_file()
    {
        if (ds.size() == 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = ds.iterator();
_L11:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        double d;
        double d1;
        Object obj;
        String s;
        String s1;
        DownloadMovieItem downloadmovieitem;
        View view;
        ProgressBar progressbar;
        TextView textview;
        TextView textview1;
        downloadmovieitem = (DownloadMovieItem)iterator.next();
        view = getActivity().getLayoutInflater().inflate(0x7f030061, null);
        listview_lin.addView(view);
        progressbar = (ProgressBar)view.findViewById(0x7f060196);
        displayMetrics = getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        if (screenWidth < 500)
        {
            android.view.ViewGroup.LayoutParams layoutparams = progressbar.getLayoutParams();
            layoutparams.width = 186;
            progressbar.setLayoutParams(layoutparams);
        }
        obj = (TextView)view.findViewById(0x7f060194);
        ((TextView) (obj)).setText(downloadmovieitem.getMovieName());
        ((TextView) (obj)).setTypeface(typeFace);
        s1 = downloadmovieitem.getFileSize();
        textview1 = (TextView)view.findViewById(0x7f060198);
        textview = (TextView)view.findViewById(0x7f060195);
        obj = (ImageView)view.findViewById(0x7f060193);
        imgurl = downloadmovieitem.getMovieHeadImagePath();
        app.asyncLoadImage(imgurl, ((ImageView) (obj)));
        d1 = 0.0D;
        d = d1;
        s = s1;
        obj = s1;
        if (s1.equals("")) goto _L5; else goto _L4
_L4:
        d = d1;
        s = s1;
        if (s1 == null) goto _L5; else goto _L6
_L6:
        obj = s1;
        if (!s1.contains("MB")) goto _L8; else goto _L7
_L7:
        obj = s1;
        s = s1.replace("MB", "").trim();
        obj = s;
        d = Double.parseDouble(s) * 1024D;
_L5:
        if (d >= 200D) goto _L10; else goto _L9
_L9:
        obj = s;
        textview1.setText("Invalid");
        obj = s;
        textview1.setTextColor(Color.parseColor("#f39801"));
        obj = s;
_L12:
        int i;
        long l = downloadmovieitem.getCurrentProgress().longValue();
        s1 = Formatter.formatFileSize(getmContext(), l);
        s = ((String) (obj));
        if (((String) (obj)).contains("null"))
        {
            s = "0.00B";
        }
        textview.setText((new StringBuilder(String.valueOf(s1))).append("/").append(s).toString());
        obj = (Button)view.findViewById(0x7f060199);
        progressbar.setMax((int)downloadmovieitem.getProgressCount().longValue());
        progressbar.setProgress((int)l);
        if (((Button) (obj)).getVisibility() == 4)
        {
            ((Button) (obj)).setVisibility(0);
        }
        obj = Boolean.valueOf(false);
        i = 0;
_L13:
        Myutils.getInstance();
        if (i < Myutils.list.size())
        {
            break MISSING_BLOCK_LABEL_600;
        }
        if (!((Boolean) (obj)).booleanValue())
        {
            (new DownloadTask(getmContext(), view, downloadmovieitem, true)).setOnDeleteTaskListener(new DeleteTask(listview_lin));
        }
          goto _L11
_L8:
        obj = s1;
        s = s1.replace("KB", "").trim();
        obj = s;
        d = Double.parseDouble(s);
          goto _L5
_L10:
        obj = s;
        textview1.setText(downloadmovieitem.getPercentage());
        obj = s;
          goto _L12
        Exception exception;
        exception;
          goto _L12
        Myutils.getInstance();
        if (((DownloadMovieItem)Myutils.list.get(i)).getDownloadUrl().equals(downloadmovieitem.getDownloadUrl()))
        {
            (new DownloadTask(getmContext(), view, downloadmovieitem, false)).setOnDeleteTaskListener(new DeleteTask(listview_lin));
            obj = Boolean.valueOf(true);
        }
        i++;
          goto _L13
    }

    private void facebookad()
    {
        apptitle.setText(nativeAd.getAdTitle());
        appauthortitle.setText(nativeAd.getAdBody());
        NativeAd.downloadAndDisplayImage(nativeAd.getAdIcon(), appicon);
        com.facebook.ads.NativeAd.Rating rating = nativeAd.getAdStarRating();
        if (rating != null)
        {
            app_ratingbar.setVisibility(0);
            app_ratingbar.setNumStars((int)rating.getScale());
            app_ratingbar.setRating((float)rating.getValue());
        } else
        {
            app_ratingbar.setVisibility(8);
        }
        nativeAd.registerViewForInteraction(inmobtop);
    }

    private void init(View view)
    {
        downloadingnotice = (TextView)view.findViewById(0x7f0600fb);
        progress_wheel = (ProgressWheel)view.findViewById(0x7f060075);
        listview_lin = (LinearLayout)view.findViewById(0x7f0600fd);
        view = getActivity();
        getActivity();
        mNotificationManager = (NotificationManager)view.getSystemService("notification");
        try
        {
            app = (MyApplcation)getActivity().getApplicationContext();
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        view = new IntentFilter();
        view.addAction("download");
        getActivity().registerReceiver(mBroadcastReceiver, view);
        view = new IntentFilter();
        view.addAction("successful");
        getActivity().registerReceiver(successful, view);
        db = new FinalDBChen(getmContext(), getActivity().getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(getActivity());
        }
    }

    public void initView()
    {
        super.initView();
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAd == null || nativeAd != ad)
        {
            return;
        }
        nativeAd.unregisterView();
        try
        {
            facebookad();
            inmobtop.setVisibility(0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Ad ad)
        {
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003e, null, false);
        setmContext(getActivity());
        init(layoutinflater);
        initView();
        download_file();
        (new Timer()).schedule(new TimerTask() {

            final DownloadingFragment this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 100;
                handler.sendMessage(message);
            }

            
            {
                this$0 = DownloadingFragment.this;
                super();
            }
        }, 0L, 1000L);
        appicon = (ImageView)layoutinflater.findViewById(0x7f0600b6);
        apptitle = (TextView)layoutinflater.findViewById(0x7f0600b7);
        official = (TextView)layoutinflater.findViewById(0x7f0600bd);
        appprice = (TextView)layoutinflater.findViewById(0x7f0600bb);
        appauthortitle = (TextView)layoutinflater.findViewById(0x7f0600b8);
        app_ratingbar = (RatingBar)layoutinflater.findViewById(0x7f0600b9);
        app_download_bt = (Button)layoutinflater.findViewById(0x7f0600ba);
        inmobtop = (RelativeLayout)layoutinflater.findViewById(0x7f0600b5);
        xian = (TextView)layoutinflater.findViewById(0x7f0600bc);
        try
        {
            typeFace = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Light.ttf");
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup) { }
        nativeAd = new NativeAd(getActivity(), "340186902832477_388101491374351");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        return layoutinflater;
    }

    public void onError(Ad ad, AdError aderror)
    {
        inmobtop.setVisibility(8);
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
