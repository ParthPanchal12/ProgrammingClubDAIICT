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
//            MyMainActivity

class this._cls1 extends AsyncTask
{

    final is._cls0 this$1;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return String.valueOf(MyMainActivity.access$7(_fld0).size());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        MyMainActivity.access$8(_fld0).setText(s);
        MyMainActivity.access$8(_fld0).show();
        MyMainActivity.access$9(_fld0).setText(String.valueOf(s));
        MyMainActivity.access$9(_fld0).show();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/MyMainActivity$2

/* anonymous class */
    class MyMainActivity._cls2 extends BroadcastReceiver
    {

        final MyMainActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            try
            {
                MyMainActivity.access$4(MyMainActivity.this, new FinalDBChen(MyMainActivity.this, getDatabasePath("download2.db").getAbsolutePath()));
                MyMainActivity.access$6(MyMainActivity.this, MyMainActivity.access$5(MyMainActivity.this).findItemsByWhereAndWhereValue(null, null, com/allinone/free/mydownload/DownloadMovieItem, "downloadtask2", null));
                (new MyMainActivity._cls2._cls1()).execute(new Void[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }
    }

}
