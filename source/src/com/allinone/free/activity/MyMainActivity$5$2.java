// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import com.allinone.free.dialog.UpdateDialogVerison;
import com.allinone.free.dialog.UpdateDialogVerison2;
import com.allinone.free.model.GameInfosVersionModel;
import com.allinone.free.utils.Myutils;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class val.ntPath
    implements android.view.r
{

    final tActivity this$1;
    private final String val$ntPath;

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131099884: 
            updateDialogVersion2.dismiss();
            return;

        case 2131099885: 
            view = new Intent("android.intent.action.VIEW", Uri.parse(val$ntPath));
            break;
        }
        updateDialogVersion2.dismiss();
        startActivity(view);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$ntPath = String.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/activity/MyMainActivity$5

/* anonymous class */
    class MyMainActivity._cls5 extends Handler
    {

        final MyMainActivity this$0;

        public void handleMessage(Message message)
        {
            if (message.what == 564 && MyMainActivity.access$11(MyMainActivity.this))
            {
                info = (GameInfosVersionModel)message.obj;
                message = info.getNtId();
                MyMainActivity.access$0(MyMainActivity.this, info.getUpdatePath());
                if (!MyMainActivity.access$1(MyMainActivity.this).equals(""))
                {
                    Log.v("version", "777777");
                    android.view.View.OnClickListener onclicklistener = new MyMainActivity._cls5._cls1();
                    updateDialogVersion = new UpdateDialogVerison(MyMainActivity.this, 0x7f0c0066, onclicklistener);
                    updateDialogVersion.setCanceledOnTouchOutside(false);
                    try
                    {
                        updateDialogVersion.setTvTitle((new StringBuilder("Update Time: ")).append(Myutils.timezhuanhua(System.currentTimeMillis())).append(DateFormat.format(" dd, yyyy", System.currentTimeMillis())).toString());
                    }
                    catch (Exception exception) { }
                }
                if (message != null && !"".equals(message))
                {
                    try
                    {
                        packageInfo = getPackageManager().getPackageInfo(message, 0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Message message)
                    {
                        packageInfo = null;
                        message.printStackTrace();
                    }
                    message = info.getNtPath();
                    if (packageInfo == null && message != null && !"".equals(message))
                    {
                        itemsOnClick2 = message. new MyMainActivity._cls5._cls2();
                        message = new Message();
                        message.what = 10000;
                        handlertimer.sendMessageDelayed(message, 5000L);
                        Log.v("ppp", "10000");
                    }
                }
            }
        }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/activity/MyMainActivity$5$1

/* anonymous class */
        class MyMainActivity._cls5._cls1
            implements android.view.View.OnClickListener
        {

            final MyMainActivity._cls5 this$1;

            public void onClick(View view)
            {
                switch (view.getId())
                {
                default:
                    return;

                case 2131099881: 
                    updateDialogVersion.dismiss();
                    return;

                case 2131099882: 
                    view = new Intent("android.intent.action.VIEW", Uri.parse(MyMainActivity.access$1(this$0)));
                    break;
                }
                updateDialogVersion.dismiss();
                startActivity(view);
            }

                    
                    {
                        this$1 = MyMainActivity._cls5.this;
                        super();
                    }
        }

    }

}
