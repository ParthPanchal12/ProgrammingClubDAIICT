// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import com.allinone.free.dialog.DownloadpathCustomDialog;

// Referenced classes of package com.allinone.free.activity:
//            MySettingsActivity

class g
    implements android.view.ngsActivity._cls6
{

    final MySettingsActivity this$0;
    private final DownloadpathCustomDialog val$downloadpathCustomDialog;

    public void onClick(View view)
    {
        val$downloadpathCustomDialog.dismiss();
    }

    g()
    {
        this$0 = final_mysettingsactivity;
        val$downloadpathCustomDialog = DownloadpathCustomDialog.this;
        super();
    }
}
