// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.allinone.free.dialog.NoupdareversionDialog;
import com.allinone.free.dialog.UpdateDialogVerison;
import com.allinone.free.model.GameInfosVersionModel;
import com.allinone.free.utils.Myutils;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class this._cls0 extends Handler
{

    final MyMainActivity this$0;

    public void handleMessage(final Message dialog)
    {
        if (dialog.what != 564)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        dialog = (GameInfosVersionModel)dialog.obj;
        MyMainActivity.access$0(MyMainActivity.this, dialog.getUpdatePath());
        if (MyMainActivity.access$1(MyMainActivity.this).equals(""))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        dialog = new android.view.View.OnClickListener() {

            final MyMainActivity._cls1 this$1;

            public void onClick(View view)
            {
                MyMainActivity.access$2(this$0).dismiss();
                switch (view.getId())
                {
                case 2131099881: 
                default:
                    return;

                case 2131099882: 
                    view = new Intent("android.intent.action.VIEW", Uri.parse(MyMainActivity.access$1(this$0)));
                    break;
                }
                startActivity(view);
            }

            
            {
                this$1 = MyMainActivity._cls1.this;
                super();
            }
        };
        MyMainActivity.access$3(MyMainActivity.this, new UpdateDialogVerison(MyMainActivity.this, 0x7f0c0066, dialog));
        MyMainActivity.access$2(MyMainActivity.this).show();
        MyMainActivity.access$2(MyMainActivity.this).setTvTitle((new StringBuilder("Update Time: ")).append(Myutils.timezhuanhua(System.currentTimeMillis())).append(DateFormat.format(" dd, yyyy", System.currentTimeMillis())).toString());
        return;
        dialog = new NoupdareversionDialog(MyMainActivity.this, 0x7f0c0064);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        ((TextView)dialog.findViewById(0x7f060189)).setText("Current version: 3.0.9 is the latest version.");
        ((Button)dialog.findViewById(0x7f06020e)).setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity._cls1 this$1;
            private final NoupdareversionDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$1 = MyMainActivity._cls1.this;
                dialog = noupdareversiondialog;
                super();
            }
        });
        return;
        dialog;
    }


    _cls2.val.dialog()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
