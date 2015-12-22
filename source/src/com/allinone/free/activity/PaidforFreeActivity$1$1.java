// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.views.BadgeView;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.allinone.free.activity:
//            PaidforFreeActivity

class this._cls1 extends AsyncTask
{

    final is._cls0 this$1;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return String.valueOf(PaidforFreeActivity.access$3(_fld0).size());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        PaidforFreeActivity.access$4(_fld0).setVisibility(0);
        PaidforFreeActivity.access$4(_fld0).startAnimation(PaidforFreeActivity.access$5(_fld0));
        PaidforFreeActivity.access$6(_fld0).setText(s);
        PaidforFreeActivity.access$6(_fld0).show();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/PaidforFreeActivity$1

/* anonymous class */
    class PaidforFreeActivity._cls1 extends BroadcastReceiver
    {

        final PaidforFreeActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            try
            {
                PaidforFreeActivity.access$0(PaidforFreeActivity.this, new FinalDBChen(PaidforFreeActivity.this, getDatabasePath("download2.db").getAbsolutePath()));
                PaidforFreeActivity.access$2(PaidforFreeActivity.this, PaidforFreeActivity.access$1(PaidforFreeActivity.this).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
                (new PaidforFreeActivity._cls1._cls1()).execute(new Void[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }


            
            {
                this$0 = PaidforFreeActivity.this;
                super();
            }
    }

}
