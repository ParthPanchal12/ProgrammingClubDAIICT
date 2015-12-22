// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.allinone.free.activity:
//            Mp3Activity, MyMainActivity

class this._cls0
    implements android.view.stener
{

    final Mp3Activity this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(Mp3Activity.this, com/allinone/free/activity/MyMainActivity));
    }

    ()
    {
        this$0 = Mp3Activity.this;
        super();
    }
}
