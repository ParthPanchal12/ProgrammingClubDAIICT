// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.view.View;
import com.allinone.free.dialog.LianwangDialog;

// Referenced classes of package com.allinone.free.fragments:
//            HomeFragment

class val.dialog
    implements android.view.ener
{

    final HomeFragment this$0;
    private final LianwangDialog val$dialog;

    public void onClick(View view)
    {
        startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_homefragment;
        val$dialog = LianwangDialog.this;
        super();
    }
}
