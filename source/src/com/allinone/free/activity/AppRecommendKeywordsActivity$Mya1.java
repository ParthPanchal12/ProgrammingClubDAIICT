// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.allinone.free.refresh.PullToRefreshLayout;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import java.net.URLEncoder;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity

class this._cls0 extends AsyncTask
{

    private String jsonData;
    final AppRecommendKeywordsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        try
        {
            AppRecommendKeywordsActivity.access$14(AppRecommendKeywordsActivity.this, URLEncoder.encode(AppRecommendKeywordsActivity.access$13(AppRecommendKeywordsActivity.this)));
            jsonData = publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword=")).append(AppRecommendKeywordsActivity.access$13(AppRecommendKeywordsActivity.this)).append("&page=").append(AppRecommendKeywordsActivity.access$15(AppRecommendKeywordsActivity.this)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return jsonData;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if (s == null)
        {
            return;
        }
        try
        {
            AppRecommendKeywordsActivity.access$16(AppRecommendKeywordsActivity.this, s);
            ((RelativeLayout)AppRecommendKeywordsActivity.access$17(AppRecommendKeywordsActivity.this).findViewById(0x7f0601a6)).setVisibility(0);
            AppRecommendKeywordsActivity.access$17(AppRecommendKeywordsActivity.this).setVisibility(0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppRecommendKeywordsActivity.access$5(AppRecommendKeywordsActivity.this).setVisibility(8);
        AppRecommendKeywordsActivity.access$10(AppRecommendKeywordsActivity.this).setVisibility(8);
        AppRecommendKeywordsActivity.access$12(AppRecommendKeywordsActivity.this).setVisibility(0);
        AppRecommendKeywordsActivity.access$0(AppRecommendKeywordsActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
