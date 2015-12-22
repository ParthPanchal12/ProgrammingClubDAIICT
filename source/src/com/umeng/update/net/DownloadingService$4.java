// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;


// Referenced classes of package com.umeng.update.net:
//            DownloadingService

class a
    implements Runnable
{

    final DownloadingService a;

    public void run()
    {
        DownloadingService.a(Boolean.valueOf(false));
    }

    (DownloadingService downloadingservice)
    {
        a = downloadingservice;
        super();
    }
}
