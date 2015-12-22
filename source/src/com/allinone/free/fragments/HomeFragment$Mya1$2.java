// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.allinone.free.dialog.WebFirstDialog;
import com.allinone.free.mydownload.DownloadMovieItem;

// Referenced classes of package com.allinone.free.fragments:
//            HomeFragment

class val.dialog1
    implements android.view.
{

    final val.dialog1 this$1;
    private final WebFirstDialog val$dialog1;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(HomeFragment.access$7(cess._mth2(this._cls1.this)).getId()).toString()));
        cess._mth2(this._cls1.this).startActivity(view);
        val$dialog1.dismiss();
    }

    ()
    {
        this$1 = final_;
        val$dialog1 = WebFirstDialog.this;
        super();
    }
}
