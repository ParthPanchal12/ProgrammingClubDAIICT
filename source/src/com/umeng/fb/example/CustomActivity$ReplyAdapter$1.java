// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.view.View;
import android.widget.LinearLayout;
import com.allinone.free.dialog.CopyDialog;
import com.umeng.fb.model.Reply;

// Referenced classes of package com.umeng.fb.example:
//            CustomActivity

class val.reply
    implements android.view.apter._cls1
{

    final _cls2.val.dialog this$1;
    private final Reply val$reply;

    public boolean onLongClick(final View dialog)
    {
        dialog = new CopyDialog(cess._mth0(this._cls1.this), 0x7f0c0064);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        LinearLayout linearlayout = (LinearLayout)dialog.findViewById(0x7f0600dc);
        LinearLayout linearlayout1 = (LinearLayout)dialog.findViewById(0x7f0600dd);
        linearlayout.setOnClickListener(new android.view.View.OnClickListener() {

            final CustomActivity.ReplyAdapter._cls1 this$2;
            private final CopyDialog val$dialog;
            private final Reply val$reply;

            public void onClick(View view)
            {
                CustomActivity.ReplyAdapter.access$0(this$1).copy(reply.content, CustomActivity.access$1(CustomActivity.ReplyAdapter.access$0(this$1)));
                dialog.dismiss();
            }

            
            {
                this$2 = CustomActivity.ReplyAdapter._cls1.this;
                reply = reply1;
                dialog = copydialog;
                super();
            }
        });
        linearlayout1.setOnClickListener(new android.view.View.OnClickListener() {

            final CustomActivity.ReplyAdapter._cls1 this$2;
            private final CopyDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$2 = CustomActivity.ReplyAdapter._cls1.this;
                dialog = copydialog;
                super();
            }
        });
        return false;
    }


    _cls2.val.dialog()
    {
        this$1 = final_dialog;
        val$reply = Reply.this;
        super();
    }
}
