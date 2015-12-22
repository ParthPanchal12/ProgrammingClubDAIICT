// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.mydownload;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import android.widget.RemoteViews;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.utils.publicTools;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.mydownload:
//            DownloadTask, DownloadMovieItem

class this._cls1 extends AsyncTask
{

    final anager this$1;

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

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        void1 = new Notification();
        void1.flags = 16;
        void1.icon = 0x7f020115;
        Object obj = new Intent(DownloadTask.access$3(cess._mth2(this._cls1.this)), com/allinone/free/activity/DownloadsActivity);
        ((Intent) (obj)).setFlags(0x10000000);
        void1.contentIntent = PendingIntent.getActivity(DownloadTask.access$3(cess._mth2(this._cls1.this)), 110, ((Intent) (obj)), 0x8000000);
        obj = new RemoteViews(DownloadTask.access$3(cess._mth2(this._cls1.this)).getPackageName(), 0x7f030079);
        DownloadTask.access$11(cess._mth2(this._cls1.this), DownloadTask.access$9(cess._mth2(this._cls1.this)).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
        ((RemoteViews) (obj)).setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(DownloadTask.access$12(cess._mth2(this._cls1.this)).size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
        ((RemoteViews) (obj)).setTextViewText(0x7f0601f6, DateFormat.format("kk:mm", System.currentTimeMillis()));
        void1.contentView = ((RemoteViews) (obj));
        DownloadTask.mNotificationManager.notify(110, void1);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
