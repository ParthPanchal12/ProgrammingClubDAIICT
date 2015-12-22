// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity

class this._cls1
    implements Runnable
{

    final d this$1;

    public void run()
    {
        try
        {
            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(AppDetailsActivity.access$7(_fld0).getId()).append("&from=google").toString());
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/AppDetailsActivity$10

/* anonymous class */
    class AppDetailsActivity._cls10
        implements android.view.View.OnClickListener
    {

        final AppDetailsActivity this$0;

        public void onClick(View view)
        {
            (new Thread(new AppDetailsActivity._cls10._cls1())).start();
            view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(AppDetailsActivity.access$7(AppDetailsActivity.this).getId()).toString()));
            startActivity(view);
        }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }
    }

}
