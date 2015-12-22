// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.allinone.free.model.SearchkeywordModel;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.DeletableEditText;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            AppRecommendKeywordsActivity, AppDetailsActivity

class this._cls0
    implements android.view.rdsActivity._cls6
{

    final AppRecommendKeywordsActivity this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        try
        {
            AppRecommendKeywordsActivity.access$19(AppRecommendKeywordsActivity.this).clear();
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        if (keyevent.getAction() != 0 || i != 66) goto _L2; else goto _L1
_L1:
        try
        {
            ((InputMethodManager)AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getContext().getSystemService("input_method")).hideSoftInputFromWindow(AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getWindowToken(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        if (TextUtils.isEmpty(AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getText()))
        {
            break MISSING_BLOCK_LABEL_153;
        }
        AppRecommendKeywordsActivity.access$14(AppRecommendKeywordsActivity.this, AppRecommendKeywordsActivity.access$2(AppRecommendKeywordsActivity.this).getText().toString());
        ((RelativeLayout)AppRecommendKeywordsActivity.access$17(AppRecommendKeywordsActivity.this).findViewById(0x7f0601a6)).setVisibility(8);
        (new a1(AppRecommendKeywordsActivity.this)).execute(new Void[0]);
_L3:
        try
        {
            (new Thread(new Runnable() {

                final AppRecommendKeywordsActivity._cls6 this$1;

                public void run()
                {
                    String s = URLEncoder.encode(AppRecommendKeywordsActivity.access$2(this$0).getText().toString());
                    publicTools.getUrl((new StringBuilder(String.valueOf("http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=app&title="))).append(s).toString());
                }

            
            {
                this$1 = AppRecommendKeywordsActivity._cls6.this;
                super();
            }
            })).start();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return false;
        }
_L2:
        return false;
        try
        {
            view = new Intent(AppRecommendKeywordsActivity.this, com/allinone/free/activity/AppDetailsActivity);
            view.putExtra("myid", ((SearchkeywordModel)AppRecommendKeywordsActivity.access$8(AppRecommendKeywordsActivity.this).get(0)).getId());
            startActivity(view);
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
          goto _L3
    }


    _cls1.this._cls1()
    {
        this$0 = AppRecommendKeywordsActivity.this;
        super();
    }
}
