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

class lin
    implements com.allinone.free.mydownload.er
{

    private LinearLayout lin;
    final DownloadingFragment this$0;

    public void onDelete(final View taskView, final DownloadMovieItem down, Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            lin.removeView(taskView);
            taskView = down.getDownloadFile();
            if (taskView != null)
            {
                taskView.stopDownload();
            }
            taskView = new File(down.getFilePath());
            if (taskView.exists())
            {
                taskView.delete();
            }
            (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "file_id=?", new String[] {
                down.getFile_id()
            });
            return;
        } else
        {
            (new android.app.tem.getFile_id(getmContext())).getmContext(getString(0x7f0b003e)).getString(getString(0x7f0b0044)).Button(getString(0x7f0b0045), new android.content.DialogInterface.OnClickListener() {

                final DownloadingFragment.DeleteTask this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            
            {
                this$1 = DownloadingFragment.DeleteTask.this;
                super();
            }
            }).Button(getString(0x7f0b0046), new android.content.DialogInterface.OnClickListener() {

                final DownloadingFragment.DeleteTask this$1;
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
                    DownloadingFragment.access$1(this$0, DownloadingFragment.access$0(this$0).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
                    ((RemoteViews) (obj)).setTextViewText(0x7f0601f7, (new StringBuilder("Downloading(")).append(DownloadingFragment.access$2(this$0).size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
                    dialoginterface.contentView = ((RemoteViews) (obj));
                    DownloadingFragment.mNotificationManager.notify(110, dialoginterface);
                }

            
            {
                this$1 = DownloadingFragment.DeleteTask.this;
                taskView = view;
                down = downloadmovieitem;
                super();
            }
            }).tem();
            return;
        }
    }



    public _cls2.val.down(LinearLayout linearlayout)
    {
        this$0 = DownloadingFragment.this;
        super();
        lin = linearlayout;
    }
}
