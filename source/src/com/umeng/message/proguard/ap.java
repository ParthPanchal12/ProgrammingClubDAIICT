// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Random;

// Referenced classes of package com.umeng.message.proguard:
//            X, W

public class ap
{

    private static Random b = new Random();
    private String a;

    public ap()
    {
        a = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        a = X.b(a.getBytes(), 2);
    }

    public static String a()
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < 24; i++)
        {
            stringbuffer.append((char)(b.nextInt(25) + 65));
        }

        return stringbuffer.toString();
    }

    public String a(String s)
    {
        return W.a(a, s);
    }

    public String a(byte abyte0[])
    {
        abyte0 = X.b(abyte0, 2);
        return W.a(a, abyte0);
    }

    public String b(String s)
    {
        return W.b(a, s);
    }

}
