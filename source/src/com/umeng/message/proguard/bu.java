// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.umeng.message.proguard:
//            bq

public class bu
{

    public static final int a = 128;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    private static final String e = "AES/CBC/PKCS5Padding";
    private static byte f[] = {
        82, 22, 50, 44, -16, 124, -40, -114, -87, -40, 
        37, 23, -56, 23, -33, 75
    };
    private static ThreadLocal g = new ThreadLocal();
    private static final AlgorithmParameterSpec h;
    private static final SecureRandom i = new SecureRandom();

    public bu()
    {
    }

    public static String a(String s, String s1, int j)
    {
        try
        {
            s = a(s.getBytes(), j);
            s = new String(b(bq.a(s1, 8), s), "utf-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static Cipher a()
    {
        Cipher cipher1 = (Cipher)g.get();
        Cipher cipher = cipher1;
        if (cipher1 == null)
        {
            try
            {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            catch (NoSuchAlgorithmException nosuchalgorithmexception)
            {
                throw new RuntimeException((new StringBuilder()).append("get Chipher error:").append(nosuchalgorithmexception.getMessage()).toString(), nosuchalgorithmexception);
            }
            catch (NoSuchPaddingException nosuchpaddingexception)
            {
                throw new RuntimeException((new StringBuilder()).append("get Chipher error:").append(nosuchpaddingexception.getMessage()).toString(), nosuchpaddingexception);
            }
            g.set(cipher);
        }
        return cipher;
    }

    private static Cipher a(SecretKeySpec secretkeyspec, int j)
    {
        Cipher cipher = a();
        try
        {
            cipher.init(j, secretkeyspec, h, i);
        }
        // Misplaced declaration of an exception variable
        catch (SecretKeySpec secretkeyspec)
        {
            throw new RuntimeException((new StringBuilder()).append("init Chipher error:").append(secretkeyspec.getMessage()).toString(), secretkeyspec);
        }
        // Misplaced declaration of an exception variable
        catch (SecretKeySpec secretkeyspec)
        {
            throw new RuntimeException((new StringBuilder()).append("init Chipher error:").append(secretkeyspec.getMessage()).toString(), secretkeyspec);
        }
        // Misplaced declaration of an exception variable
        catch (SecretKeySpec secretkeyspec)
        {
            throw new RuntimeException((new StringBuilder()).append("init Chipher error:").append(secretkeyspec.getMessage()).toString(), secretkeyspec);
        }
        return cipher;
    }

    private static SecretKeySpec a(byte abyte0[], int j)
        throws Throwable
    {
        byte abyte2[];
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("secret key can not be null");
        }
        abyte2 = new byte[16];
        j;
        JVM INSTR tableswitch 0 2: default 48
    //                   0 61
    //                   1 88
    //                   2 105;
           goto _L1 _L2 _L3 _L4
_L1:
        byte abyte1[] = abyte2;
_L6:
        return new SecretKeySpec(abyte1, "AES");
_L2:
        abyte1 = abyte2;
        if (128 != abyte0.length * 8)
        {
            System.arraycopy(abyte0, 0, abyte2, 0, 16);
            abyte1 = abyte2;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        System.arraycopy(b(abyte0), 0, abyte2, 0, 16);
        abyte1 = abyte2;
        continue; /* Loop/switch isn't completed */
_L4:
        abyte1 = a(abyte0);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static byte[] a(byte abyte0[])
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte0 = messagedigest.digest();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("md5 value Throwable", abyte0);
        }
        return abyte0;
    }

    public static byte[] a(byte abyte0[], SecretKeySpec secretkeyspec)
        throws Throwable
    {
        try
        {
            abyte0 = a(secretkeyspec, 1).doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new Throwable((new StringBuilder()).append("AES encrypt error:").append(abyte0.getMessage()).toString(), abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new Throwable((new StringBuilder()).append("AES encrypt error:").append(abyte0.getMessage()).toString(), abyte0);
        }
        return abyte0;
    }

    public static byte[] a(byte abyte0[], byte abyte1[], int j)
        throws Throwable
    {
        try
        {
            abyte0 = a(abyte0, a(abyte1, j));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new Throwable((new StringBuilder()).append("AES encrypt error:").append(abyte0.getMessage()).toString(), abyte0);
        }
        return abyte0;
    }

    private static byte[] b(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        byte abyte1[] = new byte[abyte0.length];
        for (int j = 0; j < abyte0.length; j++)
        {
            abyte1[j] = abyte0[abyte0.length - 1 - j];
        }

        return abyte1;
    }

    private static byte[] b(byte abyte0[], SecretKeySpec secretkeyspec)
        throws Throwable
    {
        try
        {
            abyte0 = a(secretkeyspec, 2).doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new Throwable((new StringBuilder()).append("AES decrypt error:").append(abyte0.getMessage()).toString(), abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new Throwable((new StringBuilder()).append("AES decrypt error:").append(abyte0.getMessage()).toString(), abyte0);
        }
        return abyte0;
    }

    static 
    {
        h = new IvParameterSpec(f);
    }
}
