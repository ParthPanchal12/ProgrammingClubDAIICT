// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.allinone.free.dialog.NewUpdateDialog;
import com.thin.downloadmanager.DownloadStatusListener;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class this._cls0
    implements DownloadStatusListener
{

    final MyMainActivity this$0;

    public void onDownloadComplete(int i)
    {
        Log.i("jone", "download completed");
        if (i == MyMainActivity.access$33(MyMainActivity.this))
        {
            final NewUpdateDialog dialog = new NewUpdateDialog(MyMainActivity.this, 0x7f0c0064);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
            Button button = (Button)dialog.findViewById(0x7f0600e9);
            Button button1 = (Button)dialog.findViewById(0x7f0600ea);
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final MyMainActivity.MyDownloadListner this$1;
                private final NewUpdateDialog val$dialog;

                public void onClick(View view)
                {
                    dialog.dismiss();
                }

            
            {
                this$1 = MyMainActivity.MyDownloadListner.this;
                dialog = newupdatedialog;
                super();
            }
            });
            button1.setOnClickListener(new android.view.View.OnClickListener() {

                final MyMainActivity.MyDownloadListner this$1;
                private final NewUpdateDialog val$dialog;

                public void onClick(View view)
                {
                    MyMainActivity.access$34(this$0);
                    dialog.dismiss();
                }

            
            {
                this$1 = MyMainActivity.MyDownloadListner.this;
                dialog = newupdatedialog;
                super();
            }
            });
        }
    }

    public void onDownloadFailed(int i, int j, String s)
    {
        Log.i("jone", "DownloadFailed");
        if (i == MyMainActivity.access$33(MyMainActivity.this))
        {
            MyMainActivity.access$35(MyMainActivity.this).setProgress(0);
        }
    }

    public void onProgress(int i, long l, long l1, int j)
    {
        Log.i("jone", (new StringBuilder(String.valueOf(j))).toString());
        if (i == MyMainActivity.access$33(MyMainActivity.this))
        {
            MyMainActivity.access$35(MyMainActivity.this).setProgress(j);
        }
    }


    _cls2.val.dialog()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
