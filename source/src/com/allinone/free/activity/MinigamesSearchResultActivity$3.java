// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.views.DeletableEditText;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.activity:
//            MinigamesSearchResultActivity

class this._cls0
    implements android.view.ultActivity._cls3
{

    final MinigamesSearchResultActivity this$0;

    public void onClick(View view)
    {
        if (!TextUtils.isEmpty(MinigamesSearchResultActivity.access$7(MinigamesSearchResultActivity.this).getText()))
        {
            MinigamesSearchResultActivity.access$2(MinigamesSearchResultActivity.this, MinigamesSearchResultActivity.access$7(MinigamesSearchResultActivity.this).getText().toString());
            MinigamesSearchResultActivity.access$6(MinigamesSearchResultActivity.this).clear();
            ((RelativeLayout)MinigamesSearchResultActivity.access$5(MinigamesSearchResultActivity.this).findViewById(0x7f0601a6)).setVisibility(8);
            MinigamesSearchResultActivity.access$5(MinigamesSearchResultActivity.this).setVisibility(8);
            (new a1(MinigamesSearchResultActivity.this)).execute(new Void[0]);
        }
    }

    a1()
    {
        this$0 = MinigamesSearchResultActivity.this;
        super();
    }
}
