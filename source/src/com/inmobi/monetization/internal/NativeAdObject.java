// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;


// Referenced classes of package com.inmobi.monetization.internal:
//            e

public class NativeAdObject
{

    String a;
    String b;
    String c;
    e d;

    public NativeAdObject(String s, String s1, String s2)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        a = s;
        b = s1;
        c = s2;
    }

    public String getContextCode()
    {
        return b;
    }

    public String getNameSpace()
    {
        return c;
    }

    public String getPubContent()
    {
        return a;
    }
}
