// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            k, x

public static class <init> extends Exception
{

    private static final long a = 0x4fccd5afd98283ccL;
    private final String b;
    private final x c;
    private final String d;

    public String a()
    {
        return b;
    }

    public x b()
    {
        return c;
    }

    public String c()
    {
        return d;
    }

    private ( , String s)
    {
        super((new StringBuilder()).append(.b()).append(": ").append(s).toString());
        b = .b();
        c = .a();
        d = s;
    }

    d(d d1, String s, d d2)
    {
        this(d1, s);
    }

    private <init>(<init> <init>1, String s)
    {
        super((new StringBuilder()).append(<init>1.d()).append(": ").append(s).toString());
        b = <init>1.d();
        c = <init>1.l();
        d = s;
    }

    d(d d1, String s, d d2)
    {
        this(d1, s);
    }

    private <init>(<init> <init>1, String s, Throwable throwable)
    {
        this(<init>1, s);
        initCause(throwable);
    }

    initCause(initCause initcause, String s, Throwable throwable, initCause initcause1)
    {
        this(initcause, s, throwable);
    }
}
