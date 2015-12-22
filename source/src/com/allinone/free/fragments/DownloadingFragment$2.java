// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.DownloadTask;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.publicTools;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.fragments:
//            DownloadingFragment

class this._cls0 extends BroadcastReceiver
{

    final DownloadingFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = getMyApp().getStartDownloadMovieItem();
        intent = getActivity().getLayoutInflater().inflate(0x7f030061, null);
        ImageView imageview = (ImageView)intent.findViewById(0x7f060193);
        String s = context.getMovieHeadImagePath();
        DownloadingFragment.access$4(DownloadingFragment.this).asyncLoadImage(s, imageview);
        context.setDownloadState(Integer.valueOf(7));
        DownloadingFragment.access$5(DownloadingFragment.this).addView(intent);
        (new DownloadTask(getmContext(), intent, context, false)).setOnDeleteTaskListener(new leteTask(DownloadingFragment.this, DownloadingFragment.access$5(DownloadingFragment.this)));
        if (context.getType().equals("app"))
        {
            context = new Notification();
            context.flags = 16;
            context.icon = 0x7f020115;
            intent = new Intent(getActivity(), com/allinone/free/activity/DownloadsActivity);
            intent.setFlags(0x10000000);
            context.contentIntent = PendingIntent.getActivity(getActivity(), 110, intent, 0x8000000);
            intent = new RemoteViews(getActivity().getPackageName(), 0x7f030079);
            DownloadingFragment.access$1(DownloadingFragment.this, DownloadingFragment.access$0(DownloadingFragment.this).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
            intent.setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(DownloadingFragment.access$2(DownloadingFragment.this).size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
            intent.setTextViewText(0x7f0601f6, DateFormat.format("kk:mm", System.currentTimeMillis()));
            context.contentView = intent;
            DownloadingFragment.mNotificationManager.notify(110, context);
        }
    }

    leteTask()
    {
        this$0 = DownloadingFragment.this;
        super();
    }
}
