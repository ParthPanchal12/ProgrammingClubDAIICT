// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.allinone.free.adapter.VideoDownloadedAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import java.io.File;
import java.util.List;

// Referenced classes of package com.allinone.free.fragments:
//            VideoFragment

class this._cls0 extends BroadcastReceiver
{

    private int pos;
    final VideoFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        pos = intent.getIntExtra("position", 0);
        (new android.app.der(getActivity())).setTitle(getString(0x7f0b003e)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b0046)))).append(((DownloadMovieItem)VideoFragment.access$0(VideoFragment.this).get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b0045), new android.content.DialogInterface.OnClickListener() {

            final VideoFragment._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = VideoFragment._cls1.this;
                super();
            }
        }).setPositiveButton(getString(0x7f0b0046), new android.content.DialogInterface.OnClickListener() {

            final VideoFragment._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                VideoFragment.access$1(this$0).deletefile(((DownloadMovieItem)VideoFragment.access$0(this$0).get(pos)).getFile_id());
                dialoginterface = new File(((DownloadMovieItem)VideoFragment.access$0(this$0).get(pos)).getFilePath());
                if (dialoginterface.exists())
                {
                    dialoginterface.delete();
                }
                VideoFragment.access$0(this$0).remove(pos);
                VideoFragment.access$2(this$0).notifyDataSetChanged();
            }

            
            {
                this$1 = VideoFragment._cls1.this;
                super();
            }
        }).show();
    }



    _cls2.this._cls1()
    {
        this$0 = VideoFragment.this;
        super();
    }
}
