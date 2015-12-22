// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            N

public static class <init> extends IOException
{

    private static final long a = 0x2c5b241b4d0ff6f6L;
    private final int b;
    private final int c;

    public int a()
    {
        return b;
    }

    public int b()
    {
        return c;
    }

    public (int i, int j, String s)
    {
        super((new StringBuilder()).append(Integer.toString(i)).append(":").append(j).append(": ").append(s).toString());
        b = i;
        c = j;
    }

    public c(String s)
    {
        this(-1, -1, s);
    }
}
