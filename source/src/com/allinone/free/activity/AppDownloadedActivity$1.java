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
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.RemoteViews;
import com.allinone.free.adapter.AppDownloadedAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.activity:
//            AppDownloadedActivity, DownloadsActivity

class this._cls0 extends BroadcastReceiver
{

    private int pos;
    final AppDownloadedActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        pos = intent.getIntExtra("position", 0);
        (new android.app.t>(AppDownloadedActivity.this)).itle(getString(0x7f0b003e)).essage((new StringBuilder(String.valueOf(getString(0x7f0b0046)))).append(((DownloadMovieItem)AppDownloadedActivity.access$0(AppDownloadedActivity.this).get(pos)).getFilePath()).append("?").toString()).egativeButton(getString(0x7f0b0045), new android.content.DialogInterface.OnClickListener() {

            final AppDownloadedActivity._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = AppDownloadedActivity._cls1.this;
                super();
            }
        }).ositiveButton(getString(0x7f0b0046), new android.content.DialogInterface.OnClickListener() {

            final AppDownloadedActivity._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                AppDownloadedActivity.access$1(this$0).deletefile(((DownloadMovieItem)AppDownloadedActivity.access$0(this$0).get(pos)).getFile_id());
                dialoginterface = new File(((DownloadMovieItem)AppDownloadedActivity.access$0(this$0).get(pos)).getFilePath());
                Log.e("www", (new StringBuilder("listdd.get(pos).getFilePath()=")).append(((DownloadMovieItem)AppDownloadedActivity.access$0(this$0).get(pos)).getFilePath()).toString());
                if (dialoginterface.exists())
                {
                    dialoginterface.delete();
                }
                AppDownloadedActivity.access$0(this$0).remove(pos);
                AppDownloadedActivity.access$2(this$0).notifyDataSetChanged();
                AppDownloadedActivity.mNotificationManager = (NotificationManager)getSystemService("notification");
                dialoginterface = new Notification();
                dialoginterface.flags = 2;
                dialoginterface.icon = 0x7f020112;
                Object obj = new Intent(this$0, com/allinone/free/activity/DownloadsActivity);
                ((Intent) (obj)).setFlags(0x10000000);
                dialoginterface.contentIntent = PendingIntent.getActivity(this$0, 110, ((Intent) (obj)), 0x8000000);
                obj = new RemoteViews(getPackageName(), 0x7f030079);
                AppDownloadedActivity.access$4(this$0, AppDownloadedActivity.access$3(this$0).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
                ((RemoteViews) (obj)).setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(AppDownloadedActivity.access$5(this$0).size()).append(") & Completed").append("(").append(AppDownloadedActivity.access$0(this$0).size()).append(")").toString());
                ((RemoteViews) (obj)).setTextViewText(0x7f0601f6, DateFormat.format("kk:mm", System.currentTimeMillis()));
                dialoginterface.contentView = ((RemoteViews) (obj));
                AppDownloadedActivity.mNotificationManager.notify(110, dialoginterface);
            }

            
            {
                this$1 = AppDownloadedActivity._cls1.this;
                super();
            }
        }).();
    }



    _cls2.this._cls1()
    {
        this$0 = AppDownloadedActivity.this;
        super();
    }
}
