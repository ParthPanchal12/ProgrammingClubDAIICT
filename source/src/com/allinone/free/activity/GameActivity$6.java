// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import android.widget.Toast;
import com.yeahmobi.android.shuffle.AdShuffle;

// Referenced classes of package com.allinone.free.activity:
//            GameActivity

class this._cls0
    implements android.view.tener
{

    final GameActivity this$0;

    public void onClick(View view)
    {
        if (GameActivity.access$13(GameActivity.this))
        {
            Toast.makeText(getApplicationContext(), "facebook", 1).show();
            return;
        } else
        {
            Toast.makeText(getApplicationContext(), "Loading...", 1).show();
            GameActivity.access$14(GameActivity.this).loadAds(false);
            return;
        }
    }

    ()
    {
        this$0 = GameActivity.this;
        super();
    }
}
