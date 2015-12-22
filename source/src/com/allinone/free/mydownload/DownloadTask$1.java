// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.mydownload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package com.allinone.free.mydownload:
//            DownloadTask, DownloadMovieItem, DownloadFile

class this._cls0 extends BroadcastReceiver
{

    final DownloadTask this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("type");
        Log.v("mjmj", (new StringBuilder("*******")).append(context).toString());
        if (context.equals("pause"))
        {
            if (DownloadTask.access$0(DownloadTask.this) != null)
            {
                context = (Button)DownloadTask.access$1(DownloadTask.this).findViewById(0x7f060199);
                DownloadTask.access$2(DownloadTask.this).getDownloadFile().stopDownload();
                if (context != null)
                {
                    context.setBackgroundResource(0x7f0201ae);
                }
                DownloadTask.access$0(DownloadTask.this).clickState = true;
            }
        } else
        {
            if (context.equals("resume"))
            {
                context = (Button)DownloadTask.access$1(DownloadTask.this).findViewById(0x7f060199);
                intent = (TextView)DownloadTask.access$1(DownloadTask.this).findViewById(0x7f060198);
                if (context != null)
                {
                    context.setBackgroundResource(0x7f0201ae);
                    context.setVisibility(4);
                    intent.setTextColor(Color.parseColor("#cccccc"));
                    intent.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b002c));
                }
                context = DownloadTask.access$2(DownloadTask.this).getDownloadUrl();
                intent = DownloadTask.access$2(DownloadTask.this).getFilePath();
                DownloadTask.access$2(DownloadTask.this).setDownloadFile((new DownloadFile()).startDownloadFileByUrl(context, intent, new llBackFuc(DownloadTask.this, DownloadTask.access$1(DownloadTask.this), DownloadTask.access$2(DownloadTask.this))));
                return;
            }
            if (context.equals("delete"))
            {
                DownloadTask.access$4(DownloadTask.this).onDelete(DownloadTask.access$1(DownloadTask.this), DownloadTask.access$2(DownloadTask.this), Boolean.valueOf(true));
                return;
            }
        }
    }

    DeleteTaskListener()
    {
        this$0 = DownloadTask.this;
        super();
    }
}
