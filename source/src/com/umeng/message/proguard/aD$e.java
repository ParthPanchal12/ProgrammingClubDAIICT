// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            aD

public static class > extends RuntimeException
{

    private static final long a = 0xefc1aa7964bcfdc9L;

    public IOException a()
    {
        return (IOException)super.getCause();
    }

    public Throwable getCause()
    {
        return a();
    }

    protected (IOException ioexception)
    {
        super(ioexception);
    }
}
