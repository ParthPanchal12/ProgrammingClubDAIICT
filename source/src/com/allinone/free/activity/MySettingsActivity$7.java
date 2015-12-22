// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import com.allinone.free.dialog.HelpusShareDialog;

// Referenced classes of package com.allinone.free.activity:
//            MySettingsActivity

class val.helpusShareDialog
    implements android.view.ngsActivity._cls7
{

    final MySettingsActivity this$0;
    private final HelpusShareDialog val$helpusShareDialog;

    public void onClick(View view)
    {
        val$helpusShareDialog.dismiss();
    }

    ()
    {
        this$0 = final_mysettingsactivity;
        val$helpusShareDialog = HelpusShareDialog.this;
        super();
    }
}
