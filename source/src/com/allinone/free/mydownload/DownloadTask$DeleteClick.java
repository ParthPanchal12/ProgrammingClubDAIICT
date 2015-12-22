// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.mydownload;

import android.view.View;

// Referenced classes of package com.allinone.free.mydownload:
//            DownloadTask

class this._cls0
    implements android.view.ask.DeleteClick
{

    final DownloadTask this$0;

    public void onClick(View view)
    {
        if (DownloadTask.access$4(DownloadTask.this) != null)
        {
            DownloadTask.access$4(DownloadTask.this).onDelete(DownloadTask.access$1(DownloadTask.this), DownloadTask.access$2(DownloadTask.this), Boolean.valueOf(false));
        }
    }

    Listener()
    {
        this$0 = DownloadTask.this;
        super();
    }
}
