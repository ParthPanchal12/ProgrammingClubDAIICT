// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.os.AsyncTask;
import android.text.Editable;
import android.widget.ListView;
import com.allinone.free.adapter.AppsearchpromitAdapter;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.DeletableEditText;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity

class this._cls0 extends AsyncTask
{

    final AppRecommendKeywordsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        AppRecommendKeywordsActivity.access$1(AppRecommendKeywordsActivity.this, new ArrayList());
        if (publicTools.isNetworkAvailable(AppRecommendKeywordsActivity.this))
        {
            return publicTools.getUrl((new StringBuilder("https://market.android.com/suggest/SuggRequest?json=1&c=0&query=")).append(URLEncoder.encode(AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getText().toString())).append("&hl=en").toString());
        } else
        {
            return null;
        }
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
        } else
        {
            AppRecommendKeywordsActivity.access$3(AppRecommendKeywordsActivity.this).addAll(Myutils.parsearchpromitlist(s));
            AppRecommendKeywordsActivity.access$4(AppRecommendKeywordsActivity.this, new AppsearchpromitAdapter(getApplicationContext(), AppRecommendKeywordsActivity.access$3(AppRecommendKeywordsActivity.this)));
            AppRecommendKeywordsActivity.access$5(AppRecommendKeywordsActivity.this).setAdapter(AppRecommendKeywordsActivity.access$6(AppRecommendKeywordsActivity.this));
            AppRecommendKeywordsActivity.access$6(AppRecommendKeywordsActivity.this).notifyDataSetChanged();
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    ()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
