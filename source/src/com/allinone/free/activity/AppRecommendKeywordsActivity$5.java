// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.allinone.free.model.SearcherPromitModel;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.views.DeletableEditText;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity

class this._cls0
    implements android.widget.
{

    final AppRecommendKeywordsActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        try
        {
            AppRecommendKeywordsActivity.access$19(AppRecommendKeywordsActivity.this).clear();
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview) { }
        try
        {
            ((InputMethodManager)AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getWindowToken(), 0);
            AppRecommendKeywordsActivity.access$14(AppRecommendKeywordsActivity.this, ((SearcherPromitModel)AppRecommendKeywordsActivity.access$3(AppRecommendKeywordsActivity.this).get(i)).getS());
            ((RelativeLayout)AppRecommendKeywordsActivity.access$17(AppRecommendKeywordsActivity.this).findViewById(0x7f0601a6)).setVisibility(8);
            (new a1(AppRecommendKeywordsActivity.this)).execute(new Void[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            return;
        }
    }

    a1()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
