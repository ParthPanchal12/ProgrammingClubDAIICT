// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.mydownload;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// Referenced classes of package com.allinone.free.mydownload:
//            DownloadTask, DownloadMovieItem, DownloadFile

public class button
    implements android.view.dTask.MyOnClick
{

    private Button button;
    public boolean clickState;
    private TextView current_progress;
    private DownloadMovieItem downItem;
    public int state;
    final DownloadTask this$0;

    public TextView getCurrent_progress()
    {
        return current_progress;
    }

    public void onClick(View view)
    {
        view = downItem.getMovieName();
        switch (state)
        {
        case 6: // '\006'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        default:
            return;

        case 5: // '\005'
            button.setVisibility(4);
            current_progress.setTextColor(Color.parseColor("#cccccc"));
            current_progress.setText("Waiting in queue");
            gotoDownload(DownloadTask.access$2(DownloadTask.this), DownloadTask.access$1(DownloadTask.this));
            try
            {
                DownloadTask.mNotificationManager.cancel(DownloadTask.access$2(DownloadTask.this).getSerial());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return;
            }

        case 7: // '\007'
            if (clickState)
            {
                gotoDownload(DownloadTask.access$2(DownloadTask.this), DownloadTask.access$1(DownloadTask.this));
                Toast.makeText(DownloadTask.access$3(DownloadTask.this), (new StringBuilder("'")).append(view).append("' starts downloading.").toString(), 0).show();
                if (button != null)
                {
                    button.setVisibility(4);
                    current_progress.setTextColor(Color.parseColor("#cccccc"));
                    current_progress.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b002c));
                }
                clickState = false;
                return;
            }
            DownloadTask.access$2(DownloadTask.this).getDownloadFile().stopDownload();
            Toast.makeText(DownloadTask.access$3(DownloadTask.this), (new StringBuilder("'")).append(view).append("' is paused.").toString(), 0).show();
            if (button != null)
            {
                button.setBackgroundResource(0x7f0201ae);
            }
            clickState = true;
            return;

        case 13: // '\r'
            view = DownloadTask.access$2(DownloadTask.this).getDownloadUrl();
            String s = DownloadTask.access$2(DownloadTask.this).getFilePath();
            DownloadTask.access$2(DownloadTask.this).setDownloadFile((new DownloadFile()).startDownloadFileByUrl(view, s, new c(DownloadTask.this, DownloadTask.access$1(DownloadTask.this), DownloadTask.access$2(DownloadTask.this))));
            return;
        }
    }

    public void setCurrent_progress(TextView textview)
    {
        current_progress = textview;
    }

    public c(int i, DownloadMovieItem downloadmovieitem, Button button1)
    {
        this$0 = DownloadTask.this;
        super();
        clickState = false;
        state = i;
        downItem = downloadmovieitem;
        button = button1;
    }
}
