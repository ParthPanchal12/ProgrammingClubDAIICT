// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.allinone.free.model.SearchkeywordModel;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.views.DeletableEditText;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity, AppDetailsActivity

class this._cls0
    implements android.view.rdsActivity._cls7
{

    final AppRecommendKeywordsActivity this$0;

    public void onClick(View view)
    {
        try
        {
            AppRecommendKeywordsActivity.access$19(AppRecommendKeywordsActivity.this).clear();
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        try
        {
            ((InputMethodManager)AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getWindowToken(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        try
        {
            if (!TextUtils.isEmpty(AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getText()))
            {
                AppRecommendKeywordsActivity.access$14(AppRecommendKeywordsActivity.this, AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getText().toString());
                ((RelativeLayout)AppRecommendKeywordsActivity.access$17(AppRecommendKeywordsActivity.this).findViewById(0x7f0601a6)).setVisibility(8);
                (new a1(AppRecommendKeywordsActivity.this)).execute(new Void[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        view = new Intent(AppRecommendKeywordsActivity.this, com/allinone/free/activity/AppDetailsActivity);
        view.putExtra("myid", ((SearchkeywordModel)AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this).get(0)).getId());
        startActivity(view);
        return;
    }

    a1()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
