// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.allinone.free.dialog.AboutCustomDialog;
import com.allinone.free.dialog.DownloadpathCustomDialog;
import com.allinone.free.dialog.DownloadsettingDialog;
import com.allinone.free.dialog.HelpusShareDialog;
import com.allinone.free.dialog.NoupdareversionDialog;
import com.allinone.free.dialog.UpdateDialogVerison;
import com.allinone.free.model.GameInfosVersionModel;
import com.allinone.free.utils.Myutils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.example.CustomActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class MySettingsActivity extends Activity
    implements android.view.View.OnClickListener
{
    class MyAsyncTask extends AsyncTask
    {

        private ProgressDialog mProgressDialog;
        final MySettingsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            delFolder((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("webcache").toString());
            Log.v("hjhj", (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("webcache").toString());
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
            Toast.makeText(getApplicationContext(), "done", 1).show();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(MySettingsActivity.this, null, getString(0x7f0b0048));
        }

        MyAsyncTask()
        {
            this$0 = MySettingsActivity.this;
            super();
        }
    }

    class MyAsyncTaskVersion extends AsyncTask
    {

        private ProgressDialog mProgressDialog;
        final MySettingsActivity this$0;

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
                        handler.sendMessage(handler.obtainMessage(564, gameinfosversionmodel));
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
            mProgressDialog = ProgressDialog.show(MySettingsActivity.this, null, "Loading......");
        }

        MyAsyncTaskVersion()
        {
            this$0 = MySettingsActivity.this;
            super();
        }
    }


    public static final int UPDATE_TAG = 564;
    private static Typeface typeFace = null;
    private RelativeLayout aboutus;
    private RelativeLayout checkforupdate;
    private RelativeLayout cleancache;
    private RelativeLayout contactus;
    private DownloadsettingDialog downloadingdialog;
    private RelativeLayout downloadpath;
    private RelativeLayout downloadsetting;
    private ImageView fan;
    Handler handler;
    private RelativeLayout helpus;
    private ImageLoader imageLoader;
    private TextView mysettingtv;
    private String newVersionUrl;
    private SharedPreferences spnetwork;
    private UpdateDialogVerison updateDialog;
    private ToggleButton wifi_download;

    public MySettingsActivity()
    {
        handler = new Handler() {

            final MySettingsActivity this$0;

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
                updateDialog = new UpdateDialogVerison(MySettingsActivity.this, 0x7f0c0066, message);
                updateDialog.show();
                updateDialog.setTvTitle((new StringBuilder("Update Time: ")).append(Myutils.timezhuanhua(System.currentTimeMillis())).append(DateFormat.format(" dd, yyyy", System.currentTimeMillis())).toString());
                return;
                message = new NoupdareversionDialog(MySettingsActivity.this, 0x7f0c0064);
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
                this$0 = MySettingsActivity.this;
                super();
            }
        };
        imageLoader = ImageLoader.getInstance();
        newVersionUrl = "";
    }

    private void buildListerrn()
    {
        fan.setOnClickListener(this);
        downloadsetting.setOnClickListener(this);
        cleancache.setOnClickListener(this);
        checkforupdate.setOnClickListener(this);
        contactus.setOnClickListener(this);
        aboutus.setOnClickListener(this);
        downloadpath.setOnClickListener(this);
        helpus.setOnClickListener(this);
    }

    private void init()
    {
        spnetwork = getSharedPreferences("network", 0);
        fan = (ImageView)findViewById(0x7f0600d8);
        mysettingtv = (TextView)findViewById(0x7f0601ed);
        downloadsetting = (RelativeLayout)findViewById(0x7f0601ee);
        cleancache = (RelativeLayout)findViewById(0x7f0601ef);
        checkforupdate = (RelativeLayout)findViewById(0x7f0601f0);
        contactus = (RelativeLayout)findViewById(0x7f0601f1);
        aboutus = (RelativeLayout)findViewById(0x7f0601f2);
        downloadpath = (RelativeLayout)findViewById(0x7f0601f3);
        helpus = (RelativeLayout)findViewById(0x7f0601f4);
    }

    public void delAllFile(String s)
    {
        File file;
        file = new File(s);
        break MISSING_BLOCK_LABEL_9;
        if (file.exists() && file.isDirectory())
        {
            String as[] = file.list();
            int i = 0;
            while (i < as.length) 
            {
                File file1;
                if (s.endsWith(File.separator))
                {
                    file1 = new File((new StringBuilder(String.valueOf(s))).append(as[i]).toString());
                } else
                {
                    file1 = new File((new StringBuilder(String.valueOf(s))).append(File.separator).append(as[i]).toString());
                }
                if (file1.isFile())
                {
                    file1.delete();
                }
                if (file1.isDirectory())
                {
                    delAllFile((new StringBuilder(String.valueOf(s))).append("/").append(as[i]).toString());
                    delFolder((new StringBuilder(String.valueOf(s))).append("/").append(as[i]).toString());
                }
                i++;
            }
        }
        return;
    }

    public void delFolder(String s)
    {
        try
        {
            delAllFile(s);
            (new File(s.toString())).delete();
            getSharedPreferences("Data", 0).edit().clear();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void onClick(final View dialog)
    {
        dialog.getId();
        JVM INSTR lookupswitch 8: default 80
    //                   2131099864: 81
    //                   2131100142: 86
    //                   2131100143: 238
    //                   2131100144: 262
    //                   2131100145: 279
    //                   2131100146: 295
    //                   2131100147: 338
    //                   2131100148: 381;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        return;
_L2:
        finish();
        return;
_L3:
        downloadingdialog = new DownloadsettingDialog(this, 0x7f0c0064);
        downloadingdialog.setCanceledOnTouchOutside(false);
        downloadingdialog.show();
        wifi_download = (ToggleButton)downloadingdialog.findViewById(0x7f06010d);
        if (!spnetwork.getBoolean("isopen", false)) goto _L11; else goto _L10
_L10:
        wifi_download.setChecked(true);
_L12:
        wifi_download.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final MySettingsActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    spnetwork.edit().putBoolean("isopen", true).commit();
                    return;
                } else
                {
                    spnetwork.edit().putBoolean("isopen", false).commit();
                    return;
                }
            }

            
            {
                this$0 = MySettingsActivity.this;
                super();
            }
        });
        dialog = (Button)downloadingdialog.findViewById(0x7f06010f);
        Button button = (Button)downloadingdialog.findViewById(0x7f06010e);
        dialog.setOnClickListener(new android.view.View.OnClickListener() {

            final MySettingsActivity this$0;

            public void onClick(View view)
            {
                downloadingdialog.dismiss();
            }

            
            {
                this$0 = MySettingsActivity.this;
                super();
            }
        });
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final MySettingsActivity this$0;

            public void onClick(View view)
            {
                downloadingdialog.dismiss();
            }

            
            {
                this$0 = MySettingsActivity.this;
                super();
            }
        });
        return;
_L11:
        try
        {
            wifi_download.setChecked(false);
        }
        // Misplaced declaration of an exception variable
        catch (final View dialog) { }
          goto _L12
_L4:
        (new MyAsyncTask()).execute(new Void[0]);
        imageLoader.clearDiscCache();
        return;
_L5:
        (new MyAsyncTaskVersion()).execute(new Void[0]);
        return;
_L6:
        startActivity(new Intent(this, com/umeng/fb/example/CustomActivity));
        return;
_L7:
        dialog = new AboutCustomDialog(this, 0x7f0c0064);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        ((Button)dialog.findViewById(0x7f06002b)).setOnClickListener(new android.view.View.OnClickListener() {

            final MySettingsActivity this$0;
            private final AboutCustomDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = MySettingsActivity.this;
                dialog = aboutcustomdialog;
                super();
            }
        });
        return;
_L8:
        dialog = new DownloadpathCustomDialog(this, 0x7f0c0064);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        ((Button)dialog.findViewById(0x7f06010c)).setOnClickListener(new android.view.View.OnClickListener() {

            final MySettingsActivity this$0;
            private final DownloadpathCustomDialog val$downloadpathCustomDialog;

            public void onClick(View view)
            {
                downloadpathCustomDialog.dismiss();
            }

            
            {
                this$0 = MySettingsActivity.this;
                downloadpathCustomDialog = downloadpathcustomdialog;
                super();
            }
        });
        return;
_L9:
        dialog = new HelpusShareDialog(this, 0x7f0c0064);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button1 = (Button)dialog.findViewById(0x7f060137);
        Button button2 = (Button)dialog.findViewById(0x7f060138);
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final MySettingsActivity this$0;
            private final HelpusShareDialog val$helpusShareDialog;

            public void onClick(View view)
            {
                helpusShareDialog.dismiss();
            }

            
            {
                this$0 = MySettingsActivity.this;
                helpusShareDialog = helpussharedialog;
                super();
            }
        });
        button2.setOnClickListener(new android.view.View.OnClickListener() {

            final MySettingsActivity this$0;
            private final HelpusShareDialog val$helpusShareDialog;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.SEND");
                view.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
                view.setType("text/plain");
                view.setFlags(0x10000000);
                startActivity(Intent.createChooser(view, "Share a free tool to download music & app..."));
                helpusShareDialog.dismiss();
            }

            
            {
                this$0 = MySettingsActivity.this;
                helpusShareDialog = helpussharedialog;
                super();
            }
        });
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030073);
        init();
        buildListerrn();
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
