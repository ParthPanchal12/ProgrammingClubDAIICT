// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import com.allinone.free.refresh.PullToRefreshLayout;
import com.allinone.free.views.DeletableEditText;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity

class this._cls0
    implements TextWatcher
{

    final AppRecommendKeywordsActivity this$0;

    public void afterTextChanged(Editable editable)
    {
        Log.v("changetv", "333");
        if (TextUtils.isEmpty(AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getText()))
        {
            AppRecommendKeywordsActivity.access$10(AppRecommendKeywordsActivity.this).setVisibility(0);
            AppRecommendKeywordsActivity.access$5(AppRecommendKeywordsActivity.this).setVisibility(8);
            AppRecommendKeywordsActivity.access$12(AppRecommendKeywordsActivity.this).setVisibility(8);
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        Log.v("changetv", "111");
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        Log.v("changetv", "222");
        AppRecommendKeywordsActivity.access$10(AppRecommendKeywordsActivity.this).setVisibility(8);
        AppRecommendKeywordsActivity.access$12(AppRecommendKeywordsActivity.this).setVisibility(8);
        (new adpromittv(AppRecommendKeywordsActivity.this)).execute(new Void[0]);
        AppRecommendKeywordsActivity.access$5(AppRecommendKeywordsActivity.this).setVisibility(0);
    }

    adpromittv()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
