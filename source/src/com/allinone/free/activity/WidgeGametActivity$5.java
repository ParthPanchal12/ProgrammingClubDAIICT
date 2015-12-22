// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import android.widget.Toast;
import com.yeahmobi.android.shuffle.AdShuffle;

// Referenced classes of package com.allinone.free.activity:
//            WidgeGametActivity

class this._cls0
    implements android.view.metActivity._cls5
{

    final WidgeGametActivity this$0;

    public void onClick(View view)
    {
        if (WidgeGametActivity.access$19(WidgeGametActivity.this))
        {
            Toast.makeText(getApplicationContext(), "facebook", 1).show();
            return;
        } else
        {
            Toast.makeText(getApplicationContext(), "Loading...", 1).show();
            WidgeGametActivity.access$20(WidgeGametActivity.this).loadAds(false);
            return;
        }
    }

    ()
    {
        this$0 = WidgeGametActivity.this;
        super();
    }
}
