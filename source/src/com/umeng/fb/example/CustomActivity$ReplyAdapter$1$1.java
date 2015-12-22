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

class val.dialog
    implements android.view.ter._cls1._cls1
{

    final val.dialog this$2;
    private final CopyDialog val$dialog;
    private final Reply val$reply;

    public void onClick(View view)
    {
        ss._mth0(_fld1).copy(val$reply.content, CustomActivity.access$1(ss._mth0(_fld1)));
        val$dialog.dismiss();
    }

    l.reply()
    {
        this$2 = final_reply1;
        val$reply = reply2;
        val$dialog = CopyDialog.this;
        super();
    }

    // Unreferenced inner class com/umeng/fb/example/CustomActivity$ReplyAdapter$1

/* anonymous class */
    class CustomActivity.ReplyAdapter._cls1
        implements android.view.View.OnLongClickListener
    {

        final CustomActivity.ReplyAdapter this$1;
        private final Reply val$reply;

        public boolean onLongClick(final View dialog)
        {
            dialog = new CopyDialog(CustomActivity.ReplyAdapter.access$0(CustomActivity.ReplyAdapter.this), 0x7f0c0064);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
            LinearLayout linearlayout = (LinearLayout)dialog.findViewById(0x7f0600dc);
            LinearLayout linearlayout1 = (LinearLayout)dialog.findViewById(0x7f0600dd);
            linearlayout.setOnClickListener(dialog. new CustomActivity.ReplyAdapter._cls1._cls1());
            linearlayout1.setOnClickListener(new CustomActivity.ReplyAdapter._cls1._cls2());
            return false;
        }


            
            {
                this$1 = final_replyadapter;
                reply = Reply.this;
                super();
            }

        // Unreferenced inner class com/umeng/fb/example/CustomActivity$ReplyAdapter$1$2

/* anonymous class */
        class CustomActivity.ReplyAdapter._cls1._cls2
            implements android.view.View.OnClickListener
        {

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
        }

    }

}
