// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.os.AsyncTask;
import android.widget.LinearLayout;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.activity:
//            AppDetailsActivity

class this._cls0 extends AsyncTask
{

    final AppDetailsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        String s = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_ad_1");
        avoid = s;
        if (s == null)
        {
            avoid = null;
        }
        return avoid;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            AppDetailsActivity.access$34(AppDetailsActivity.this, s);
            AppDetailsActivity.access$35(AppDetailsActivity.this).setVisibility(0);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppDetailsActivity.access$0(AppDetailsActivity.this).setVisibility(0);
    }

    _cls9()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
