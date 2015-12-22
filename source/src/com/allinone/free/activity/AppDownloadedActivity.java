// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.allinone.free.adapter.AppDownloadedAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.DownloadpathCustomDialog;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.start_welcome.MainActivity;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.activity:
//            DownloadsActivity

public class AppDownloadedActivity extends BaseActivity
    implements android.view.View.OnClickListener, ContentValue
{

    public static NotificationManager mNotificationManager;
    private AppDownloadedAdapter adapter;
    private ListView app_lv;
    private ImageView appfan;
    private TextView appnotice;
    private BroadcastReceiver appsuccessful;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private List ds;
    private ImageView filemoreapp;
    private BroadcastReceiver jingmo;
    private RelativeLayout l1;
    private RelativeLayout l2;
    private RelativeLayout l3;
    private RelativeLayout l4;
    private List listdd;
    private BroadcastReceiver mBroadcastReceiver_delete;
    private PopupWindow mWindow;
    private publicTools publictools;
    private String saomiaoapk;

    public AppDownloadedActivity()
    {
        mBroadcastReceiver_delete = new BroadcastReceiver() {

            private int pos;
            final AppDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                pos = intent.getIntExtra("position", 0);
                (new android.app.AlertDialog.Builder(AppDownloadedActivity.this)).setTitle(getString(0x7f0b003e)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b0046)))).append(((DownloadMovieItem)listdd.get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b0045), new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).setPositiveButton(getString(0x7f0b0046), new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dbUtils.deletefile(((DownloadMovieItem)listdd.get(pos)).getFile_id());
                        dialoginterface = new File(((DownloadMovieItem)listdd.get(pos)).getFilePath());
                        Log.e("www", (new StringBuilder("listdd.get(pos).getFilePath()=")).append(((DownloadMovieItem)listdd.get(pos)).getFilePath()).toString());
                        if (dialoginterface.exists())
                        {
                            dialoginterface.delete();
                        }
                        listdd.remove(pos);
                        adapter.notifyDataSetChanged();
                        AppDownloadedActivity.mNotificationManager = (NotificationManager)getSystemService("notification");
                        dialoginterface = new Notification();
                        dialoginterface.flags = 2;
                        dialoginterface.icon = 0x7f020112;
                        Object obj = new Intent(_fld0, com/allinone/free/activity/DownloadsActivity);
                        ((Intent) (obj)).setFlags(0x10000000);
                        dialoginterface.contentIntent = PendingIntent.getActivity(_fld0, 110, ((Intent) (obj)), 0x8000000);
                        obj = new RemoteViews(getPackageName(), 0x7f030079);
                        ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
                        ((RemoteViews) (obj)).setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(ds.size()).append(") & Completed").append("(").append(listdd.size()).append(")").toString());
                        ((RemoteViews) (obj)).setTextViewText(0x7f0601f6, DateFormat.format("kk:mm", System.currentTimeMillis()));
                        dialoginterface.contentView = ((RemoteViews) (obj));
                        AppDownloadedActivity.mNotificationManager.notify(110, dialoginterface);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).show();
            }



            
            {
                this$0 = AppDownloadedActivity.this;
                super();
            }
        };
        appsuccessful = new BroadcastReceiver() {

            final AppDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = listdd;
                Myutils.getInstance();
                context.add(Myutils.successItem);
                app_lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            
            {
                this$0 = AppDownloadedActivity.this;
                super();
            }
        };
        jingmo = new BroadcastReceiver() {

            final AppDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                adapter.notifyDataSetChanged();
            }

            
            {
                this$0 = AppDownloadedActivity.this;
                super();
            }
        };
        adapter = null;
        dbUtils = null;
        saomiaoapk = "";
    }

    private void buildListener()
    {
        appfan.setOnClickListener(this);
        filemoreapp.setOnClickListener(this);
    }

    private void init()
    {
        db = new FinalDBChen(getmContext(), getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null);
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        listdd = dbUtils.queryApk("app", "timesort");
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        appnotice = (TextView)findViewById(0x7f0600c0);
        app_lv = (ListView)findViewById(0x7f0600bf);
        appfan = (ImageView)findViewById(0x7f06004f);
        filemoreapp = (ImageView)findViewById(0x7f0600be);
        adapter = new AppDownloadedAdapter(this, listdd);
        app_lv.setAdapter(adapter);
    }

    private void popuWindow()
    {
        Object obj = LayoutInflater.from(this).inflate(0x7f030046, null);
        l1 = (RelativeLayout)((View) (obj)).findViewById(0x7f060109);
        l2 = (RelativeLayout)((View) (obj)).findViewById(0x7f06010a);
        l3 = (RelativeLayout)((View) (obj)).findViewById(0x7f06010b);
        l4 = (RelativeLayout)((View) (obj)).findViewById(0x7f060119);
        l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
        l4.setOnClickListener(this);
        mWindow = new PopupWindow(((View) (obj)));
        getWindowManager().getDefaultDisplay().getHeight();
        int i = getWindowManager().getDefaultDisplay().getWidth();
        mWindow.setWidth(i / 2 + 50);
        mWindow.setHeight(-2);
        mWindow.setFocusable(true);
        mWindow.setAnimationStyle(0x7f0c0067);
        obj = new ColorDrawable(0);
        mWindow.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
    }

    public void AppSort(String s)
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        listdd = dbUtils.queryApk("app", s);
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        app_lv = (ListView)findViewById(0x7f0600bf);
        adapter = new AppDownloadedAdapter(this, listdd);
        app_lv.setAdapter(adapter);
    }

    public void Appdeletall()
    {
        dbUtils.deleteallfile("app");
        int i = 0;
        do
        {
            if (i >= listdd.size())
            {
                listdd.removeAll(listdd);
                adapter.notifyDataSetChanged();
                return;
            }
            File file = new File(((DownloadMovieItem)listdd.get(i)).getFilePath());
            if (file.exists())
            {
                file.delete();
            }
            i++;
        } while (true);
    }

    public void initView()
    {
        super.initView();
        new FinalDBChen(getmContext(), "download2.db", new DownloadMovieItem(), "downloadtask2", null);
    }

    public void onClick(final View downloadpathCustomDialog)
    {
        switch (downloadpathCustomDialog.getId())
        {
        default:
            return;

        case 2131099727: 
            if (saomiaoapk.equals("ok"))
            {
                startActivity(new Intent(this, com/allinone/free/start_welcome/MainActivity));
                saomiaoapk = "no";
                return;
            } else
            {
                moveTaskToBack(true);
                return;
            }

        case 2131099838: 
            popuWindow();
            mWindow.showAsDropDown(downloadpathCustomDialog);
            return;

        case 2131099913: 
            AppSort("timesort");
            mWindow.dismiss();
            return;

        case 2131099914: 
            AppSort("zimusort");
            mWindow.dismiss();
            return;

        case 2131099915: 
            (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b003e)).setMessage(getString(0x7f0b004b)).setPositiveButton(getString(0x7f0b0046), new android.content.DialogInterface.OnClickListener() {

                final AppDownloadedActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    Appdeletall();
                }

            
            {
                this$0 = AppDownloadedActivity.this;
                super();
            }
            }).setNegativeButton(getString(0x7f0b0045), new android.content.DialogInterface.OnClickListener() {

                final AppDownloadedActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            
            {
                this$0 = AppDownloadedActivity.this;
                super();
            }
            }).show();
            mWindow.dismiss();
            return;

        case 2131099929: 
            downloadpathCustomDialog = new DownloadpathCustomDialog(this, 0x7f0c0064);
            downloadpathCustomDialog.setCanceledOnTouchOutside(false);
            downloadpathCustomDialog.show();
            ((Button)downloadpathCustomDialog.findViewById(0x7f06010c)).setOnClickListener(new android.view.View.OnClickListener() {

                final AppDownloadedActivity this$0;
                private final DownloadpathCustomDialog val$downloadpathCustomDialog;

                public void onClick(View view)
                {
                    downloadpathCustomDialog.dismiss();
                }

            
            {
                this$0 = AppDownloadedActivity.this;
                downloadpathCustomDialog = downloadpathcustomdialog;
                super();
            }
            });
            mWindow.dismiss();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030029);
        setmContext(this);
        publictools = new publicTools(getApplicationContext());
        initView();
        try
        {
            saomiaoapk = getIntent().getExtras().getString("saomiao");
            Log.v("erere", (new StringBuilder(String.valueOf(saomiaoapk))).append("********").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        bundle = new IntentFilter();
        bundle.addAction("delete");
        registerReceiver(mBroadcastReceiver_delete, bundle);
        bundle = new IntentFilter();
        bundle.addAction("appsuccessful");
        registerReceiver(appsuccessful, bundle);
        bundle = new IntentFilter();
        bundle.addAction("jingmoanzhuang");
        registerReceiver(jingmo, bundle);
        init();
        buildListener();
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
        MobclickAgent.onPause(this);
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
        if (listdd.size() > 0)
        {
            appnotice.setVisibility(8);
        }
        adapter.notifyDataSetChanged();
    }







}
