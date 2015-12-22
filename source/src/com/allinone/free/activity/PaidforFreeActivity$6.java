// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import android.widget.Toast;
import com.yeahmobi.android.shuffle.AdShuffle;

// Referenced classes of package com.allinone.free.activity:
//            PaidforFreeActivity

class this._cls0
    implements android.view.reeActivity._cls6
{

    final PaidforFreeActivity this$0;

    public void onClick(View view)
    {
        if (PaidforFreeActivity.access$13(PaidforFreeActivity.this))
        {
            Toast.makeText(getApplicationContext(), "facebook", 1).show();
            return;
        } else
        {
            Toast.makeText(getApplicationContext(), "Loading...", 1).show();
            PaidforFreeActivity.access$14(PaidforFreeActivity.this).loadAds(false);
            return;
        }
    }

    ()
    {
        this$0 = PaidforFreeActivity.this;
        super();
    }
}
