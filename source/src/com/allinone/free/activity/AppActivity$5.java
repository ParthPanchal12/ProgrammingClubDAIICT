// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import android.widget.Toast;
import com.yeahmobi.android.shuffle.AdShuffle;

// Referenced classes of package com.allinone.free.activity:
//            AppActivity

class this._cls0
    implements android.view.stener
{

    final AppActivity this$0;

    public void onClick(View view)
    {
        if (!AppActivity.access$8(AppActivity.this))
        {
            Toast.makeText(getApplicationContext(), "Loading...", 1).show();
            AppActivity.access$9(AppActivity.this).loadAds(false);
        }
    }

    ()
    {
        this$0 = AppActivity.this;
        super();
    }
}
