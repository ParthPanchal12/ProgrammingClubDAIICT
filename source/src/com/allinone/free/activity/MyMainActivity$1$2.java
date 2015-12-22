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

class 
    implements android.view.r
{

    final .dismiss this$1;
    private final NoupdareversionDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.dismiss();
    }

    ()
    {
        this$1 = final_;
        val$dialog = NoupdareversionDialog.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/MyMainActivity$1

/* anonymous class */
    class MyMainActivity._cls1 extends Handler
    {

        final MyMainActivity this$0;

        public void handleMessage(Message message)
        {
            if (message.what != 564)
            {
                break MISSING_BLOCK_LABEL_126;
            }
            message = (GameInfosVersionModel)message.obj;
            MyMainActivity.access$0(MyMainActivity.this, message.getUpdatePath());
            if (MyMainActivity.access$1(MyMainActivity.this).equals(""))
            {
                break MISSING_BLOCK_LABEL_127;
            }
            message = new MyMainActivity._cls1._cls1();
            MyMainActivity.access$3(MyMainActivity.this, new UpdateDialogVerison(MyMainActivity.this, 0x7f0c0066, message));
            MyMainActivity.access$2(MyMainActivity.this).show();
            MyMainActivity.access$2(MyMainActivity.this).setTvTitle((new StringBuilder("Update Time: ")).append(Myutils.timezhuanhua(System.currentTimeMillis())).append(DateFormat.format(" dd, yyyy", System.currentTimeMillis())).toString());
            return;
            message = new NoupdareversionDialog(MyMainActivity.this, 0x7f0c0064);
            message.setCanceledOnTouchOutside(false);
            message.show();
            ((TextView)message.findViewById(0x7f060189)).setText("Current version: 3.0.9 is the latest version.");
            ((Button)message.findViewById(0x7f06020e)).setOnClickListener(message. new MyMainActivity._cls1._cls2());
            return;
            message;
        }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/activity/MyMainActivity$1$1

/* anonymous class */
        class MyMainActivity._cls1._cls1
            implements android.view.View.OnClickListener
        {

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
        }

    }

}
