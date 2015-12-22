// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.allinone.free.dialog.LianwangDialog;

// Referenced classes of package com.allinone.free.adapter:
//            Home_Gridview_Adapter

class val.dialog
    implements android.view.ew_Adapter._cls5
{

    final Home_Gridview_Adapter this$0;
    private final LianwangDialog val$dialog;

    public void onClick(View view)
    {
        Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_home_gridview_adapter;
        val$dialog = LianwangDialog.this;
        super();
    }
}
