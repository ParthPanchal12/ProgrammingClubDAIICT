// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


public class Z
{

    public Z()
    {
    }

    public static byte[] a(int i)
    {
        byte byte0 = (byte)(i % 256);
        i >>= 8;
        byte byte1 = (byte)(i % 256);
        i >>= 8;
        byte byte2 = (byte)(i % 256);
        return (new byte[] {
            (byte)((i >> 8) % 256), byte2, byte1, byte0
        });
    }

    public static byte[] a(byte abyte0[], int i)
    {
        if (abyte0.length == 4)
        {
            abyte0[3] = (byte)(i % 256);
            i >>= 8;
            abyte0[2] = (byte)(i % 256);
            i >>= 8;
            abyte0[1] = (byte)(i % 256);
            abyte0[0] = (byte)((i >> 8) % 256);
            return abyte0;
        } else
        {
            return null;
        }
    }
}
