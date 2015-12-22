// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.SharedPreferences;
import android.view.View;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.WebFirstDialog;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.NetWorkUtil;

// Referenced classes of package com.allinone.free.fragments:
//            HomeFragment

class val.dialog1
    implements android.view.
{

    final val.dialog1 this$1;
    private final WebFirstDialog val$dialog1;

    public void onClick(View view)
    {
        if (HomeFragment.access$17(cess._mth2(this._cls1.this)).getBoolean("isopen", false) && NetWorkUtil.getAPNType(cess._mth2(this._cls1.this).getActivity()) != 1)
        {
            HomeFragment.access$18(cess._mth2(this._cls1.this));
            return;
        }
        if (HomeFragment.access$19(cess._mth2(this._cls1.this)).queryfile(HomeFragment.access$7(cess._mth2(this._cls1.this)).getId()) == null)
        {
            cess._mth2(this._cls1.this).MydownloadApk(HomeFragment.access$7(cess._mth2(this._cls1.this)).getId(), HomeFragment.access$7(cess._mth2(this._cls1.this)).getTitle(), HomeFragment.access$7(cess._mth2(this._cls1.this)).getIcon(), HomeFragment.access$7(cess._mth2(this._cls1.this)).getSerial());
        } else
        {
            HomeFragment.access$6(cess._mth2(this._cls1.this));
        }
        val$dialog1.dismiss();
    }

    ()
    {
        this$1 = final_;
        val$dialog1 = WebFirstDialog.this;
        super();
    }
}
