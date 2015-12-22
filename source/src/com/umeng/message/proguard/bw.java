// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.text.TextUtils;

public class bw
{

    public bw()
    {
    }

    public static int a(long l)
    {
        return a(l, null);
    }

    public static int a(long l, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            s = s.getBytes();
            return (int)((long)Math.abs(a(((byte []) (s)), 0, s.length, 0x7fffffff)) % l);
        } else
        {
            return (int)(Math.random() * (double)l);
        }
    }

    public static int a(byte abyte0[], int i, int j, int k)
    {
        int j1 = j >> 2;
        k ^= j;
        for (int l = 0; l < j1;)
        {
            int k1 = l << 2;
            byte byte0 = abyte0[i + k1 + 3];
            byte byte1 = abyte0[i + k1 + 2];
            byte byte2 = abyte0[i + k1 + 1];
            k1 = (abyte0[k1 + i + 0] & 0xff | ((byte0 << 8 | byte1 & 0xff) << 8 | byte2 & 0xff) << 8) * 0x5bd1e995;
            l++;
            k = (k1 ^ k1 >>> 24) * 0x5bd1e995 ^ k * 0x5bd1e995;
        }

        j1 = j - (j1 << 2);
        int i1 = k;
        if (j1 != 0)
        {
            i1 = k;
            if (j1 >= 3)
            {
                i1 = k ^ abyte0[(i + j) - 3] << 16;
            }
            k = i1;
            if (j1 >= 2)
            {
                k = i1 ^ abyte0[(i + j) - 2] << 8;
            }
            i1 = k;
            if (j1 >= 1)
            {
                i1 = k ^ abyte0[(i + j) - 1];
            }
            i1 *= 0x5bd1e995;
        }
        i = (i1 ^ i1 >>> 13) * 0x5bd1e995;
        return i ^ i >>> 15;
    }
}
