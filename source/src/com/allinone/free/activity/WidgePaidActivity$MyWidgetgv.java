// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.os.AsyncTask;
import android.widget.LinearLayout;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.activity:
//            WidgePaidActivity

class this._cls0 extends AsyncTask
{

    final WidgePaidActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        String s = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_featured&page=1");
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
            WidgePaidActivity.access$2(WidgePaidActivity.this, s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        WidgePaidActivity.access$0(WidgePaidActivity.this).setVisibility(0);
        WidgePaidActivity.access$1(WidgePaidActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = WidgePaidActivity.this;
        super();
    }
}
