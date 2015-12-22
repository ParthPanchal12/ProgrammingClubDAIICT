// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import java.io.File;

// Referenced classes of package com.umeng.message:
//            UmengDownloadResourceService

static final class b
    implements Runnable
{

    final File a;
    final long b;

    public void run()
    {
        UmengDownloadResourceService.a(a, b);
        UmengDownloadResourceService.a(null);
    }

    (File file, long l)
    {
        a = file;
        b = l;
        super();
    }
}
