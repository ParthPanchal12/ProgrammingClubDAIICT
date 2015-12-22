// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.mydownload.DownloadFile;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.publicTools;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.fragments:
//            DownloadingFragment

class val.down
    implements android.content.eleteTask._cls2
{

    final Manager this$1;
    private final DownloadMovieItem val$down;
    private final View val$taskView;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        cess._mth0(this._cls1.this).removeView(val$taskView);
        dialoginterface = val$down.getDownloadFile();
        if (dialoginterface != null)
        {
            dialoginterface.stopDownload();
        }
        dialoginterface = new File(val$down.getFilePath());
        if (dialoginterface.exists())
        {
            dialoginterface.delete();
        }
        (new FinalDBChen(cess._mth1(this._cls1.this).getmContext(), "download2.db")).deleteItem("downloadtask2", "movieName=?", new String[] {
            val$down.getMovieName()
        });
        dialoginterface = new Notification();
        dialoginterface.flags = 16;
        dialoginterface.icon = 0x7f020112;
        Object obj = new Intent(cess._mth1(this._cls1.this).getActivity(), com/allinone/free/activity/DownloadsActivity);
        ((Intent) (obj)).setFlags(0x10000000);
        dialoginterface.contentIntent = PendingIntent.getActivity(cess._mth1(this._cls1.this).getActivity(), 110, ((Intent) (obj)), 0x8000000);
        obj = new RemoteViews(cess._mth1(this._cls1.this).getActivity().getPackageName(), 0x7f030079);
        DownloadingFragment.access$1(cess._mth1(this._cls1.this), DownloadingFragment.access$0(cess._mth1(this._cls1.this)).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
        ((RemoteViews) (obj)).setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(DownloadingFragment.access$2(cess._mth1(this._cls1.this)).size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
        dialoginterface.contentView = ((RemoteViews) (obj));
        DownloadingFragment.mNotificationManager.notify(110, dialoginterface);
    }

    ()
    {
        this$1 = final_;
        val$taskView = view;
        val$down = DownloadMovieItem.this;
        super();
    }
}
