// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.allinone.free.activity:
//            AppActivity, AppRecommendKeywordsActivity

class this._cls0
    implements android.view.stener
{

    final AppActivity this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(AppActivity.this, com/allinone/free/activity/AppRecommendKeywordsActivity));
    }

    ywordsActivity()
    {
        this$0 = AppActivity.this;
        super();
    }
}
