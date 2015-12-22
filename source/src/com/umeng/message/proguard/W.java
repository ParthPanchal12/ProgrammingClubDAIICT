// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class W
{

    public static final String a = "AESUtils";

    public W()
    {
    }

    public static String a(String s)
    {
        return a(s.getBytes());
    }

    public static String a(String s, String s1)
    {
        Object obj = null;
        try
        {
            s = a(b(s.getBytes()), s1.getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
        s1 = obj;
        if (s != null)
        {
            s1 = a(((byte []) (s)));
        }
        return s1;
    }

    public static String a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
        for (int i = 0; i < abyte0.length; i++)
        {
            a(stringbuffer, abyte0[i]);
        }

        return stringbuffer.toString();
    }

    private static void a(StringBuffer stringbuffer, byte byte0)
    {
        stringbuffer.append("0123456789ABCDEF".charAt(byte0 >> 4 & 0xf)).append("0123456789ABCDEF".charAt(byte0 & 0xf));
    }

    private static byte[] a(byte abyte0[], byte abyte1[])
        throws Exception
    {
        abyte0 = new SecretKeySpec(abyte0, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, abyte0, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(abyte1);
    }

    public static String b(String s)
    {
        return new String(c(s));
    }

    public static String b(String s, String s1)
    {
        try
        {
            s = new String(b(b(s.getBytes()), c(s1)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static byte[] b(byte abyte0[])
        throws Exception
    {
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        SecureRandom securerandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        securerandom.setSeed(abyte0);
        keygenerator.init(128, securerandom);
        return keygenerator.generateKey().getEncoded();
    }

    private static byte[] b(byte abyte0[], byte abyte1[])
        throws Exception
    {
        abyte0 = new SecretKeySpec(abyte0, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, abyte0, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(abyte1);
    }

    public static byte[] c(String s)
    {
        int j = s.length() / 2;
        byte abyte0[] = new byte[j];
        for (int i = 0; i < j; i++)
        {
            abyte0[i] = Integer.valueOf(s.substring(i * 2, i * 2 + 2), 16).byteValue();
        }

        return abyte0;
    }
}
