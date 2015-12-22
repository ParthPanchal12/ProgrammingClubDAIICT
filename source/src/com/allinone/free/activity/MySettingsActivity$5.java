// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import com.allinone.free.dialog.AboutCustomDialog;

// Referenced classes of package com.allinone.free.activity:
//            MySettingsActivity

class val.dialog
    implements android.view.ngsActivity._cls5
{

    final MySettingsActivity this$0;
    private final AboutCustomDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_mysettingsactivity;
        val$dialog = AboutCustomDialog.this;
        super();
    }
}
