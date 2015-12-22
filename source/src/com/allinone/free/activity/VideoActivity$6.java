// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.view.View;
import com.allinone.free.dialog.ErrorDialog;

// Referenced classes of package com.allinone.free.activity:
//            VideoActivity

class val.dialog
    implements android.view.ener
{

    final VideoActivity this$0;
    private final ErrorDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_videoactivity;
        val$dialog = ErrorDialog.this;
        super();
    }
}
