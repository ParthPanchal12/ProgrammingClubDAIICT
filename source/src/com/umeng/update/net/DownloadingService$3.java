// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.widget.Toast;

// Referenced classes of package com.umeng.update.net:
//            DownloadingService

class b
    implements Runnable
{

    final DownloadingService a;
    private final String b;

    public void run()
    {
        Toast.makeText(DownloadingService.b(a), b, 0).show();
    }

    (DownloadingService downloadingservice, String s)
    {
        a = downloadingservice;
        b = s;
        super();
    }
}
