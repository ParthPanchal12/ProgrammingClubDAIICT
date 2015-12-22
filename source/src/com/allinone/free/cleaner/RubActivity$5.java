// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.cleaner;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.allinone.free.activity.DownloadsActivity;

// Referenced classes of package com.allinone.free.cleaner:
//            RubActivity

class this._cls0
    implements android.view.stener
{

    final RubActivity this$0;

    public void onClick(View view)
    {
        if (i == 0)
        {
            startActivity(new Intent(RubActivity.this, com/allinone/free/activity/DownloadsActivity));
            return;
        } else
        {
            Toast.makeText(getApplicationContext(), "Cleaning...", 1).show();
            return;
        }
    }

    vity()
    {
        this$0 = RubActivity.this;
        super();
    }
}
