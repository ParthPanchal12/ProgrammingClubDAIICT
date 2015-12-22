// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import com.allinone.free.dialog.NewUpdateDialog;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class val.dialog
    implements android.view.loadListner._cls1
{

    final val.dialog this$1;
    private final NewUpdateDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.dismiss();
    }

    ()
    {
        this$1 = final_;
        val$dialog = NewUpdateDialog.this;
        super();
    }
}
