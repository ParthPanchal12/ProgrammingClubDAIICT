// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.allinone.free.model.SearchkeywordModel;
import com.allinone.free.views.DeletableEditText;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            MinigameRecommendActivity, MinigamesSearchResultActivity

class this._cls0
    implements android.view.endActivity._cls3
{

    final MinigameRecommendActivity this$0;

    public void onClick(View view)
    {
        if (!TextUtils.isEmpty(MinigameRecommendActivity.access$7(MinigameRecommendActivity.this).getText()))
        {
            MinigameRecommendActivity.access$8(MinigameRecommendActivity.this, MinigameRecommendActivity.access$7(MinigameRecommendActivity.this).getText().toString());
            view = new Intent(MinigameRecommendActivity.this, com/allinone/free/activity/MinigamesSearchResultActivity);
            view.putExtra("searchkeywords", MinigameRecommendActivity.access$9(MinigameRecommendActivity.this));
            startActivity(view);
            return;
        } else
        {
            view = new Intent(MinigameRecommendActivity.this, com/allinone/free/activity/MinigamesSearchResultActivity);
            view.putExtra("searchkeywords", ((SearchkeywordModel)MinigameRecommendActivity.access$2(MinigameRecommendActivity.this).get(0)).getKeyword());
            startActivity(view);
            return;
        }
    }

    y()
    {
        this$0 = MinigameRecommendActivity.this;
        super();
    }
}
