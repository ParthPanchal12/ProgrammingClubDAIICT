// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.mydownload;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.utils.MD5;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import com.stericson.RootTools.RootTools;
import java.io.File;
import java.io.IOException;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import net.tsz.afinal.http.AjaxCallBack;

// Referenced classes of package com.allinone.free.mydownload:
//            DownloadTask, DownloadMovieItem, MyApplcation

class stop_download_bt extends AjaxCallBack
{

    private int cu;
    private TextView current_progress;
    private DownloadMovieItem down;
    private TextView kb;
    private TextView movie_name_item;
    private ProgressBar p;
    private Button stop_download_bt;
    final DownloadTask this$0;
    private TextView totalSize;
    private View view;

    public void onFailure(Throwable throwable, String s)
    {
        (new Thread(new Runnable() {

            final DownloadTask.CallBackFuc this$1;

            public void run()
            {
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&action=retry_fail&id=")).append(down.getFile_id()).append("&size=").append(down.getCurrentProgress()).toString());
            }

            
            {
                this$1 = DownloadTask.CallBackFuc.this;
                super();
            }
        })).start();
        if (TextUtils.isEmpty(down.getFileSize()))
        {
            down.setFileSize("0.0B");
        }
        down.setDownloadState(Integer.valueOf(5));
        throwable = DownloadTask.access$9(DownloadTask.this);
        String s1 = down.getMovieName();
        DownloadMovieItem downloadmovieitem = down;
        throwable.updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
            s1
        }, downloadmovieitem);
        if (!TextUtils.isEmpty(s) && s.contains("416"))
        {
            throwable = new Intent();
            throwable.putExtra("downloadType", 6);
            throwable.setAction("downloadType");
            ((MyApplcation)DownloadTask.access$3(DownloadTask.this).getApplicationContext()).setDownloadSuccess(down);
            DownloadTask.access$3(DownloadTask.this).sendBroadcast(throwable);
            throwable = Formatter.formatFileSize(DownloadTask.access$3(DownloadTask.this), (new File(down.getFilePath())).length());
            if (view != null)
            {
                kb.setVisibility(4);
                totalSize.setText(throwable);
                current_progress.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b0030));
                p.setMax(100);
                p.setProgress(100);
                stop_download_bt.setVisibility(0);
                stop_download_bt.setBackgroundResource(0x7f0201ae);
                stop_download_bt.setOnClickListener(new nit>(DownloadTask.this, 6, down, stop_download_bt));
            }
        } else
        if (view != null)
        {
            kb.setVisibility(4);
            if (stop_download_bt.getVisibility() == 4)
            {
                stop_download_bt.setVisibility(0);
            }
            stop_download_bt.setBackgroundResource(0x7f020098);
            stop_download_bt.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b0031));
            stop_download_bt.setTextColor(Color.parseColor("#333333"));
            current_progress.setTextColor(Color.parseColor("#f39801"));
            current_progress.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b0032));
            throwable = new nit>(DownloadTask.this, 5, down, stop_download_bt);
            throwable.tCurrent_progress(current_progress);
            stop_download_bt.setOnClickListener(throwable);
            throwable = DownloadTask.this;
            DownloadTask.access$14(throwable, DownloadTask.access$13(throwable) + 1);
            if (DownloadTask.access$13(DownloadTask.this) < 4)
            {
                stop_download_bt.performClick();
                Toast.makeText(DownloadTask.access$3(DownloadTask.this), (new StringBuilder("Failed to download '")).append(down.getMovieName()).append("'. Please try again.").toString(), 0).show();
                return;
            } else
            {
                DownloadTask.access$14(DownloadTask.this, 0);
                throwable = new Notification();
                throwable.flags = 16;
                throwable.icon = 0x7f020115;
                s = new Intent(DownloadTask.access$3(DownloadTask.this), com/allinone/free/activity/DownloadsActivity);
                s.setFlags(0x10000000);
                throwable.contentIntent = PendingIntent.getActivity(DownloadTask.access$3(DownloadTask.this), down.getSerial(), s, 0x8000000);
                s = new RemoteViews(DownloadTask.access$3(DownloadTask.this).getPackageName(), 0x7f03007a);
                DownloadTask.access$11(DownloadTask.this, DownloadTask.access$9(DownloadTask.this).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
                s.setTextViewText(0x7f0601f9, "Incomplete Task");
                s.setTextViewText(0x7f0601fa, DateFormat.format("kk:mm", System.currentTimeMillis()));
                s.setImageViewBitmap(0x7f0601f8, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(down.getMovieHeadImagePath())).toString()));
                throwable.contentView = s;
                DownloadTask.mNotificationManager.notify(down.getSerial(), throwable);
                return;
            }
        }
    }

    public void onLoading(long l, long l1)
    {
        int i = 0;
        if (l1 > (long)cu)
        {
            i = (int)(l1 - (long)cu);
            cu = (int)l1;
        }
        Object obj = (new StringBuilder(String.valueOf(Formatter.formatFileSize(DownloadTask.access$3(DownloadTask.this), i)))).append("/s").toString();
        i = (int)((100L * l1) / l);
        if (view != null)
        {
            String s = Formatter.formatFileSize(DownloadTask.access$3(DownloadTask.this), l1);
            current_progress.setText((new StringBuilder(String.valueOf(i))).append("%").toString());
            down.setPercentage((new StringBuilder(String.valueOf(i))).append("%").toString());
            down.setProgressCount(Long.valueOf(l));
            down.setCurrentProgress(Long.valueOf(l1));
            Object obj1 = Formatter.formatFileSize(DownloadTask.access$3(DownloadTask.this), l);
            down.setFileSize(String.valueOf(l));
            totalSize.setText((new StringBuilder(String.valueOf(s))).append("/").append(((String) (obj1))).toString());
            kb.setText(((CharSequence) (obj)));
            if (kb.getVisibility() == 4)
            {
                kb.setVisibility(0);
            }
            p.setMax((int)l);
            p.setProgress((int)l1);
            if (stop_download_bt.getVisibility() == 4)
            {
                stop_download_bt.setVisibility(0);
                stop_download_bt.setText("");
                stop_download_bt.setBackgroundResource(0x7f0201a9);
            }
            down.setDownloadState(Integer.valueOf(2));
            obj = DownloadTask.access$9(DownloadTask.this);
            s = down.getMovieName();
            obj1 = down;
            ((FinalDBChen) (obj)).updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                s
            }, obj1);
        }
    }

    public void onStart()
    {
        down.setDownloadState(Integer.valueOf(7));
        Object obj = DownloadTask.access$9(DownloadTask.this);
        String s = down.getMovieName();
        DownloadMovieItem downloadmovieitem = down;
        ((FinalDBChen) (obj)).updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
            s
        }, downloadmovieitem);
        obj = new Intent();
        ((Intent) (obj)).putExtra("downloadType", 7);
        ((Intent) (obj)).setAction("downloadType");
        ((MyApplcation)DownloadTask.access$3(DownloadTask.this).getApplicationContext()).setDownloadSuccess(down);
        DownloadTask.access$3(DownloadTask.this).sendBroadcast(((Intent) (obj)));
        super.onStart();
    }

    public void onSuccess(File file)
    {
label0:
        {
            {
                (new Thread(new Runnable() {

                    final DownloadTask.CallBackFuc this$1;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id=")).append(down.getFile_id()).append("&status=success&size=").append(down.getFileSize()).toString());
                    }

            
            {
                this$1 = DownloadTask.CallBackFuc.this;
                super();
            }
                })).start();
                if (view != null)
                {
                    kb.setVisibility(4);
                    current_progress.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b0030));
                    stop_download_bt.setBackgroundResource(0x7f0201ae);
                    stop_download_bt.setOnClickListener(new nit>(DownloadTask.this, 6, down, stop_download_bt));
                }
                down.setDownloadState(Integer.valueOf(6));
                Object obj = DownloadTask.access$9(DownloadTask.this);
                Object obj1 = down.getMovieName();
                Object obj2 = down;
                ((FinalDBChen) (obj)).updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                    obj1
                }, obj2);
                obj = new Intent();
                Myutils.getInstance();
                Myutils.successItem = down;
                Log.v("erer", (new StringBuilder("11111111")).append(down.getType()).append(down.getFile_id()).toString());
                obj2 = (MyApplcation)DownloadTask.access$3(DownloadTask.this).getApplicationContext();
                ((Intent) (obj)).setAction("successful");
                obj1 = new Intent();
                if (down.getType().equals("mp3"))
                {
                    ((Intent) (obj1)).setAction("mp3successful");
                } else
                if (down.getType().equals("ringtone"))
                {
                    ((Intent) (obj1)).setAction("ringtonesuccessful");
                } else
                if (down.getType().equals("app"))
                {
                    ((Intent) (obj1)).setAction("appsuccessful");
                } else
                if (down.getType().equals("video"))
                {
                    ((Intent) (obj1)).setAction("videosuccessful");
                }
                if (!is_valid_file().booleanValue())
                {
                    break label0;
                }
                ((MyApplcation) (obj2)).setDownloadSuccess(down);
                obj2 = (LinearLayout)view.getParent();
                IOException ioexception;
                try
                {
                    ((LinearLayout) (obj2)).removeView(view);
                }
                catch (Exception exception) { }
                DownloadTask.access$3(DownloadTask.this).sendBroadcast(((Intent) (obj)));
                DownloadTask.access$3(DownloadTask.this).sendBroadcast(((Intent) (obj1)));
                if (down.getType().equals("app"))
                {
                    publicTools.toptoast = false;
                    publicTools.openimgpath = down.getMovieHeadImagePath();
                    publicTools.opentitle = down.getTitle();
                    publicTools.openid = down.getFile_id();
                    if (RootTools.isRootAvailable())
                    {
                        (new Thread(new Runnable() {

                            final DownloadTask.CallBackFuc this$1;

                            public void run()
                            {
                                String s = (new StringBuilder(String.valueOf("pm install -r "))).append(down.getFilePath()).toString();
                                excuteSuCMD(s);
                            }

            
            {
                this$1 = DownloadTask.CallBackFuc.this;
                super();
            }
                        })).start();
                    } else
                    {
                        obj = new Intent("android.intent.action.VIEW");
                        ((Intent) (obj)).setDataAndType(Uri.parse((new StringBuilder("file://")).append(down.getFilePath()).toString()), "application/vnd.android.package-archive");
                        DownloadTask.access$3(DownloadTask.this).startActivity(((Intent) (obj)));
                    }
                    DownloadTask.access$10(DownloadTask.this, 0x7f020115, (new StringBuilder("'")).append(down.getTitle()).append("' Download Complete. Click to install").toString());
                    obj = new Intent();
                    ((Intent) (obj)).setAction("jingmoanzhuang");
                    DownloadTask.access$3(DownloadTask.this).sendBroadcast(((Intent) (obj)));
                    (new AsyncTask() {

                        final DownloadTask.CallBackFuc this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            try
                            {
                                Thread.sleep(2000L);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void avoid[])
                            {
                                avoid.printStackTrace();
                            }
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj3)
                        {
                            onPostExecute((Void)obj3);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            void1 = new Notification();
                            void1.flags = 16;
                            void1.icon = 0x7f020115;
                            Object obj3 = new Intent(DownloadTask.access$3(this$0), com/allinone/free/activity/DownloadsActivity);
                            ((Intent) (obj3)).setFlags(0x10000000);
                            void1.contentIntent = PendingIntent.getActivity(DownloadTask.access$3(this$0), 110, ((Intent) (obj3)), 0x8000000);
                            obj3 = new RemoteViews(DownloadTask.access$3(this$0).getPackageName(), 0x7f030079);
                            DownloadTask.access$11(this$0, DownloadTask.access$9(this$0).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
                            ((RemoteViews) (obj3)).setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(DownloadTask.access$12(this$0).size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
                            ((RemoteViews) (obj3)).setTextViewText(0x7f0601f6, DateFormat.format("kk:mm", System.currentTimeMillis()));
                            void1.contentView = ((RemoteViews) (obj3));
                            DownloadTask.mNotificationManager.notify(110, void1);
                        }

            
            {
                this$1 = DownloadTask.CallBackFuc.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            super.onSuccess(file);
            return;
        }
        obj2 = new Message();
        obj2.what = 1212;
        ((Message) (obj2)).getData().putString("type", down.getType());
        ((Message) (obj2)).getData().putString("id", down.getFile_id());
        ((Message) (obj2)).getData().putString("size", down.getFileSize());
        obj = "";
        obj1 = BufferedReader(down.getFilePath());
        obj = obj1;
        Log.v("tyty", (new StringBuilder("content===")).append(((String) (obj1))).toString());
        obj = obj1;
_L4:
        if (((String) (obj)).length() > 100)
        {
            ((Message) (obj2)).getData().putString("content", ((String) (obj)).substring(1, 100));
        } else
        {
            ((Message) (obj2)).getData().putString("content", ((String) (obj)));
        }
        if (!down.getType().equals("app")) goto _L2; else goto _L1
_L1:
        Myutils.getInstance();
        if (!Myutils.type_current.equals("app_recent")) goto _L2; else goto _L3
_L3:
        publicTools.app_recent_handler.sendMessage(((Message) (obj2)));
_L5:
        current_progress.setText("Invalid");
        current_progress.setTextColor(Color.parseColor("#f39801"));
        kb.setVisibility(0);
        kb.setText("0KB/s");
        break MISSING_BLOCK_LABEL_478;
        ioexception;
        ioexception.printStackTrace();
          goto _L4
_L2:
label1:
        {
            if (!down.getType().equals("app"))
            {
                break label1;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("app_popular"))
            {
                break label1;
            }
            publicTools.app_popular_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
label2:
        {
            if (!down.getType().equals("app"))
            {
                break label2;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("app_search"))
            {
                break label2;
            }
            publicTools.app_search_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
label3:
        {
            if (!down.getType().equals("app"))
            {
                break label3;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("app_detail"))
            {
                break label3;
            }
            publicTools.app_detail_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
label4:
        {
            if (!down.getType().equals("game"))
            {
                break label4;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("game_recent"))
            {
                break label4;
            }
            publicTools.game_recent_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
label5:
        {
            if (!down.getType().equals("game"))
            {
                break label5;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("game_popular"))
            {
                break label5;
            }
            publicTools.game_popular_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
label6:
        {
            if (!down.getType().equals("mp3"))
            {
                break label6;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("mp3_recent"))
            {
                break label6;
            }
            publicTools.mp3_recent_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
label7:
        {
            if (!down.getType().equals("mp3"))
            {
                break label7;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("mp3_popular"))
            {
                break label7;
            }
            publicTools.mp3_popular_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
label8:
        {
            if (!down.getType().equals("mp3"))
            {
                break label8;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("mp3_search"))
            {
                break label8;
            }
            publicTools.mp3_search_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
label9:
        {
            if (!down.getType().equals("ringtone"))
            {
                break label9;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("ringtone_recent"))
            {
                break label9;
            }
            publicTools.ringtone_recent_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
label10:
        {
            if (!down.getType().equals("ringtone"))
            {
                break label10;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("ringtone_popular"))
            {
                break label10;
            }
            publicTools.ringtone_popular_handler.sendMessage(((Message) (obj2)));
        }
          goto _L5
        if (down.getType().equals("ringtone"))
        {
            Myutils.getInstance();
            if (Myutils.type_current.equals("ringtone_search"))
            {
                publicTools.ringtone_search_handler.sendMessage(((Message) (obj2)));
            }
        }
          goto _L5
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((File)obj);
    }



    public _cls4.this._cls1(View view1, DownloadMovieItem downloadmovieitem)
    {
        this$0 = DownloadTask.this;
        super();
        down = downloadmovieitem;
        view = view1;
        if (view1 != null)
        {
            p = (ProgressBar)view1.findViewById(0x7f060196);
            DownloadTask.access$5(DownloadTask.this, DownloadTask.access$3(DownloadTask.this).getResources().getDisplayMetrics().widthPixels);
            if (DownloadTask.access$6(DownloadTask.this) < 500)
            {
                android.view.ask ask = p.getLayoutParams();
                ask.dth = 186;
                p.setLayoutParams(ask);
            }
            kb = (TextView)view1.findViewById(0x7f060197);
            totalSize = (TextView)view1.findViewById(0x7f060195);
            stop_download_bt = (Button)view1.findViewById(0x7f060199);
            stop_download_bt.setBackgroundResource(0x7f0201a9);
            current_progress = (TextView)view1.findViewById(0x7f060198);
            movie_name_item = (TextView)view1.findViewById(0x7f060194);
            stop_download_bt.setVisibility(4);
            stop_download_bt.setBackgroundResource(0x7f0201a9);
            movie_name_item.setText(downloadmovieitem.getMovieName());
            movie_name_item.setTypeface(DownloadTask.access$7(DownloadTask.this));
            current_progress.setTextColor(Color.parseColor("#cccccc"));
            current_progress.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b002c));
            DownloadTask.access$8(DownloadTask.this, new nit>(DownloadTask.this, 7, downloadmovieitem, stop_download_bt));
            DownloadTask.access$0(DownloadTask.this).tCurrent_progress(current_progress);
            stop_download_bt.setOnClickListener(DownloadTask.access$0(DownloadTask.this));
        }
    }
}
