// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.SharedPreferences;
import android.view.View;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.WebFirstDialog;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.NetWorkUtil;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class val.dialog1
    implements android.view.tivity.Mya1._cls1
{

    final val.dialog1 this$1;
    private final WebFirstDialog val$dialog1;

    public void onClick(View view)
    {
        if (MyMainActivity.access$26(cess._mth2(this._cls1.this)).getBoolean("isopen", false) && NetWorkUtil.getAPNType(cess._mth2(this._cls1.this)) != 1)
        {
            MyMainActivity.access$27(cess._mth2(this._cls1.this));
            return;
        }
        if (MyMainActivity.access$28(cess._mth2(this._cls1.this)).queryfile(MyMainActivity.access$15(cess._mth2(this._cls1.this)).getId()) == null)
        {
            cess._mth2(this._cls1.this).MydownloadApk(MyMainActivity.access$15(cess._mth2(this._cls1.this)).getId(), MyMainActivity.access$15(cess._mth2(this._cls1.this)).getTitle(), MyMainActivity.access$15(cess._mth2(this._cls1.this)).getIcon(), MyMainActivity.access$15(cess._mth2(this._cls1.this)).getSerial());
        } else
        {
            MyMainActivity.access$14(cess._mth2(this._cls1.this));
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
