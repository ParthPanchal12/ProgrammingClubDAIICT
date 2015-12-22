// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public class bv
{

    private static String a = "0123456789ABCDEF";

    public bv()
    {
    }

    private static byte a(byte byte0, byte byte1)
    {
        return (byte)((byte)(Byte.decode((new StringBuilder()).append("0x").append(new String(new byte[] {
            byte0
        })).toString()).byteValue() << 4) | Byte.decode((new StringBuilder()).append("0x").append(new String(new byte[] {
            byte1
        })).toString()).byteValue());
    }

    private static byte a(char c1)
    {
        return (byte)a.indexOf(c1);
    }

    public static String a(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++)
        {
            stringbuffer.append(Integer.toHexString(s.charAt(i)));
        }

        return stringbuffer.toString();
    }

    public static String a(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder("");
        if (abyte0 == null || abyte0.length <= 0)
        {
            return null;
        }
        for (int i = 0; i < abyte0.length; i++)
        {
            String s = Integer.toHexString(abyte0[i] & 0xff);
            if (s.length() < 2)
            {
                stringbuilder.append(0);
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static String b(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        s = s.getBytes();
        StringBuilder stringbuilder = new StringBuilder(s.length * 2);
        for (int i = 0; i < s.length; i++)
        {
            stringbuilder.append(a.charAt((s[i] & 0xf0) >> 4));
            stringbuilder.append(a.charAt((s[i] & 0xf) >> 0));
        }

        return stringbuilder.toString();
    }

    public static String c(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(s.length() / 2);
        for (int i = 0; i < s.length(); i += 2)
        {
            bytearrayoutputstream.write(a.indexOf(s.charAt(i)) << 4 | a.indexOf(s.charAt(i + 1)));
        }

        return new String(bytearrayoutputstream.toByteArray());
    }

    public static byte[] d(String s)
    {
        byte abyte0[] = new byte[6];
        s = s.getBytes();
        for (int i = 0; i < 6; i++)
        {
            abyte0[i] = a(s[i * 2], s[i * 2 + 1]);
        }

        return abyte0;
    }

    public static byte[] e(String s)
    {
        if (s != null && !s.equals("")) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        s = s.toUpperCase();
        int j = s.length() / 2;
        char ac[] = s.toCharArray();
        byte abyte0[] = new byte[j];
        int i = 0;
        do
        {
            s = abyte0;
            if (i >= j)
            {
                continue;
            }
            int k = i * 2;
            byte byte0 = a(ac[k]);
            abyte0[i] = (byte)(a(ac[k + 1]) | byte0 << 4);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
