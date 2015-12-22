// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;
import com.allinone.free.start_welcome.MainActivity;

// Referenced classes of package com.allinone.free.activity:
//            GameActivity

class this._cls0
    implements android.view.tener
{

    final GameActivity this$0;

    public void onClick(View view)
    {
        if (GameActivity.access$12(GameActivity.this))
        {
            startActivity(new Intent(GameActivity.this, com/allinone/free/start_welcome/MainActivity));
            finish();
            return;
        } else
        {
            finish();
            return;
        }
    }

    ty()
    {
        this$0 = GameActivity.this;
        super();
    }
}
