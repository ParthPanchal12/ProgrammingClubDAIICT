// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.allinone.free.adapter.VideoDownloadedAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import java.io.File;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            VideoDownloadedActivity

class this._cls1
    implements android.content.ner
{

    final DataSetChanged this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        VideoDownloadedActivity.access$1(_fld0).deletefile(((DownloadMovieItem)VideoDownloadedActivity.access$0(_fld0).get(s)).getFile_id());
        dialoginterface = new File(((DownloadMovieItem)VideoDownloadedActivity.access$0(_fld0).get(s)).getFilePath());
        if (dialoginterface.exists())
        {
            dialoginterface.delete();
        }
        VideoDownloadedActivity.access$0(_fld0).remove(s);
        VideoDownloadedActivity.access$2(_fld0).notifyDataSetChanged();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/VideoDownloadedActivity$1

/* anonymous class */
    class VideoDownloadedActivity._cls1 extends BroadcastReceiver
    {

        private int pos;
        final VideoDownloadedActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            pos = intent.getIntExtra("position", 0);
            (new android.app.AlertDialog.Builder(VideoDownloadedActivity.this)).setTitle(getString(0x7f0b003e)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b0046)))).append(((DownloadMovieItem)VideoDownloadedActivity.access$0(VideoDownloadedActivity.this).get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b0045), new VideoDownloadedActivity._cls1._cls1()).setPositiveButton(getString(0x7f0b0046), new VideoDownloadedActivity._cls1._cls2()).show();
        }



            
            {
                this$0 = VideoDownloadedActivity.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/activity/VideoDownloadedActivity$1$1

/* anonymous class */
        class VideoDownloadedActivity._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final VideoDownloadedActivity._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = VideoDownloadedActivity._cls1.this;
                        super();
                    }
        }

    }

}
