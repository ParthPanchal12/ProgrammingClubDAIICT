// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.start_welcome;

import android.content.Intent;
import com.allinone.free.activity.DownloadsActivity;

// Referenced classes of package com.allinone.free.start_welcome:
//            MainActivity

class this._cls0
    implements Runnable
{

    final MainActivity this$0;

    public void run()
    {
        Intent intent = new Intent(MainActivity.this, com/allinone/free/activity/DownloadsActivity);
        startActivity(intent);
        finish();
        overridePendingTransition(0x7f04000a, 0x7f04000f);
    }

    ()
    {
        this$0 = MainActivity.this;
        super();
    }
}
