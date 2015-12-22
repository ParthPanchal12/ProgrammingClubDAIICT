// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import java.io.File;

// Referenced classes of package com.umeng.update.net:
//            j

class b
    implements Runnable
{

    private final File a;
    private final long b;

    public void run()
    {
        j.a(a, b);
        j.a(null);
    }

    (File file, long l)
    {
        a = file;
        b = l;
        super();
    }
}
