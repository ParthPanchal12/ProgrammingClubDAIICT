// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            q, y

public static final class <init>
{

    private final y a;
    private final Object b;
    private final y c;
    private final c d;

    static <init> a(<init> <init>1)
    {
        return <init>1.d;
    }

    static Object b(d d1)
    {
        return d1.b;
    }

    static y c(b b1)
    {
        return b1.c;
    }

    public y a()
    {
        return a;
    }

    public int b()
    {
        return d.f();
    }

    public y c()
    {
        return c;
    }

    private ion(y y, Object obj, y y1, ion ion)
    {
        if (y == null)
        {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (ion.j() == k && y1 == null)
        {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        } else
        {
            a = y;
            b = obj;
            c = y1;
            d = ion;
            return;
        }
    }

    d(y y, Object obj, y y1, d d1, d d2)
    {
        this(y, obj, y1, d1);
    }
}
