// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.view.View;
import com.allinone.free.dialog.LianwangDialog;

// Referenced classes of package com.allinone.free.adapter:
//            RingtoneListviewAdapter

class val.dialog
    implements android.view.iewAdapter._cls2
{

    final RingtoneListviewAdapter this$0;
    private final LianwangDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.dismiss();
    }

    _cls9()
    {
        this$0 = final_ringtonelistviewadapter;
        val$dialog = LianwangDialog.this;
        super();
    }
}
