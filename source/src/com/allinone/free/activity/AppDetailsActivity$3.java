// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.views.BadgeView;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity

class this._cls0 extends BroadcastReceiver
{

    final AppDetailsActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            AppDetailsActivity.access$1(AppDetailsActivity.this, new FinalDBChen(AppDetailsActivity.this, getDatabasePath("download2.db").getAbsolutePath()));
            AppDetailsActivity.access$3(AppDetailsActivity.this, AppDetailsActivity.access$2(AppDetailsActivity.this).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
            (new AsyncTask() {

                final AppDetailsActivity._cls3 this$1;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    return String.valueOf(AppDetailsActivity.access$4(this$0).size());
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    super.onPostExecute(s);
                    AppDetailsActivity.access$5(this$0).setText(s);
                    AppDetailsActivity.access$5(this$0).show();
                }

            
            {
                this$1 = AppDetailsActivity._cls3.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }


    _cls1.this._cls1()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
