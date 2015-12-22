// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.os.AsyncTask;
import android.widget.GridView;
import com.allinone.free.adapter.ApprecommendkeywordAdapter;
import com.allinone.free.model.SearchkeywordModel;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.DeletableEditText;
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
        AppRecommendKeywordsActivity.access$7(AppRecommendKeywordsActivity.this, new ArrayList());
        if (publicTools.isNetworkAvailable(AppRecommendKeywordsActivity.this))
        {
            return publicTools.getUrl("http://android.downloadatoz.com/_201409/market/top_keywords.php");
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
        }
        try
        {
            AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this).addAll(Myutils.parseSearchKeywords(s));
            AppRecommendKeywordsActivity.access$9(AppRecommendKeywordsActivity.this, new ApprecommendkeywordAdapter(getApplicationContext(), AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this)));
            AppRecommendKeywordsActivity.access$10(AppRecommendKeywordsActivity.this).setAdapter(AppRecommendKeywordsActivity.access$11(AppRecommendKeywordsActivity.this));
            AppRecommendKeywordsActivity.access$11(AppRecommendKeywordsActivity.this).notifyDataSetChanged();
            AppRecommendKeywordsActivity.access$0(AppRecommendKeywordsActivity.this).setVisibility(8);
            AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).setHint(((SearchkeywordModel)AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this).get(0)).getKeyword());
            Myutils.getInstance();
            Myutils.hint = ((SearchkeywordModel)AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this).get(0)).getKeyword();
            Myutils.getInstance();
            Myutils.hintid = ((SearchkeywordModel)AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this).get(0)).getId();
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
        AppRecommendKeywordsActivity.access$0(AppRecommendKeywordsActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
