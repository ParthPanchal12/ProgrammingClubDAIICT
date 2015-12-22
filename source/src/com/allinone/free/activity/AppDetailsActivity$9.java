// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity

class this._cls0
    implements android.view.ilsActivity._cls9
{

    final AppDetailsActivity this$0;

    public void onClick(View view)
    {
        (new AsyncTask() {

            final AppDetailsActivity._cls9 this$1;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                try
                {
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(AppDetailsActivity.access$8(this$0)).append("&from=apk").toString());
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[]) { }
                return null;
            }

            
            {
                this$1 = AppDetailsActivity._cls9.this;
                super();
            }
        }).execute(new Void[0]);
        if (AppDetailsActivity.access$39(AppDetailsActivity.this).getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
        {
            AppDetailsActivity.access$40(AppDetailsActivity.this);
            return;
        }
        if (AppDetailsActivity.access$41(AppDetailsActivity.this).queryfile(AppDetailsActivity.access$7(AppDetailsActivity.this).getId()) == null)
        {
            MydownloadApk(AppDetailsActivity.access$7(AppDetailsActivity.this).getId(), AppDetailsActivity.access$7(AppDetailsActivity.this).getTitle(), AppDetailsActivity.access$7(AppDetailsActivity.this).getIcon(), AppDetailsActivity.access$7(AppDetailsActivity.this).getSerial());
            return;
        } else
        {
            AppDetailsActivity.access$6(AppDetailsActivity.this);
            return;
        }
    }


    _cls1.this._cls1()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
