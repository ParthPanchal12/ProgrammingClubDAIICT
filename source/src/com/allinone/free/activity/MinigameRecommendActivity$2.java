// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.allinone.free.model.SearchkeywordModel;
import com.allinone.free.views.DeletableEditText;
import java.util.List;

// Referenced classes of package com.allinone.free.activity:
//            MinigameRecommendActivity, MinigamesSearchResultActivity

class this._cls0
    implements android.view.endActivity._cls2
{

    final MinigameRecommendActivity this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
label0:
        {
            if (keyevent.getAction() == 0 && i == 66)
            {
                if (TextUtils.isEmpty(MinigameRecommendActivity.access$7(MinigameRecommendActivity.this).getText()))
                {
                    break label0;
                }
                MinigameRecommendActivity.access$8(MinigameRecommendActivity.this, MinigameRecommendActivity.access$7(MinigameRecommendActivity.this).getText().toString());
                view = new Intent(MinigameRecommendActivity.this, com/allinone/free/activity/MinigamesSearchResultActivity);
                view.putExtra("searchkeywords", MinigameRecommendActivity.access$9(MinigameRecommendActivity.this));
                startActivity(view);
            }
            return false;
        }
        view = new Intent(MinigameRecommendActivity.this, com/allinone/free/activity/MinigamesSearchResultActivity);
        view.putExtra("searchkeywords", ((SearchkeywordModel)MinigameRecommendActivity.access$2(MinigameRecommendActivity.this).get(0)).getKeyword());
        startActivity(view);
        return false;
    }

    y()
    {
        this$0 = MinigameRecommendActivity.this;
        super();
    }
}
