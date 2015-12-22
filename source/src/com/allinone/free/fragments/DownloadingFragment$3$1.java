// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.fragments:
//            DownloadingFragment

class this._cls1
    implements Runnable
{

    final le_id this$1;

    public void run()
    {
        Looper.prepare();
        DownloadMovieItem downloadmovieitem = getMyApp().getDownloadSuccess();
        DownloadingFragment.access$6(_fld0).insertApk(downloadmovieitem.getFile_id(), downloadmovieitem.getType(), downloadmovieitem.getMovieName(), downloadmovieitem.getMovieHeadImagePath(), downloadmovieitem.getFileSize(), downloadmovieitem.getFilePath(), downloadmovieitem.getSerial(), downloadmovieitem.getCreate_time());
        (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "file_id=?", new String[] {
            downloadmovieitem.getFile_id()
        });
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/fragments/DownloadingFragment$3

/* anonymous class */
    class DownloadingFragment._cls3 extends BroadcastReceiver
    {

        final DownloadingFragment this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (DownloadingFragment.access$6(DownloadingFragment.this) == null)
            {
                DownloadingFragment.access$7(DownloadingFragment.this, new TypeDbUtils(context));
            }
            (new Thread(new DownloadingFragment._cls3._cls1())).start();
        }


            
            {
                this$0 = DownloadingFragment.this;
                super();
            }
    }

}
