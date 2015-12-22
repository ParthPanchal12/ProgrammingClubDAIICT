// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;

import android.content.Intent;
import android.view.View;
import com.allinone.free.activity.DownloadsActivity;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.cleaner:
//            RubActivity

class this._cls0
    implements android.view.stener
{

    final RubActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/allinone/free/activity/DownloadsActivity);
        startActivity(view);
        finish();
        publicTools.cleanertag = false;
    }

    vity()
    {
        this$0 = RubActivity.this;
        super();
    }
}
