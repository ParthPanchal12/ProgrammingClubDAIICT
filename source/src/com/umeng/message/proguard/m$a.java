// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            m

private static final class b
{

    private final b a;
    private final int b;

    public boolean equals(Object obj)
    {
        if (obj instanceof b)
        {
            if (a == ((a) (obj = (a)obj)).a && b == ((b) (obj)).b)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return a.hashCode() * 65535 + b;
    }

    ( , int i)
    {
        a = ;
        b = i;
    }
}
