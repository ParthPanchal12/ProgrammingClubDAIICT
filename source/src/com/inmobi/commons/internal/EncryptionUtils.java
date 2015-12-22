// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.inmobi.commons.internal:
//            Base64, Log, InternalSDKUtil

public class EncryptionUtils
{
    private static class a extends IvParameterSpec
    {

        public a(byte abyte0[])
        {
            super(abyte0);
        }
    }

    private static class b extends RSAPublicKeySpec
    {

        public b(BigInteger biginteger, BigInteger biginteger1)
        {
            super(biginteger, biginteger1);
        }
    }

    private static class c extends SecretKeySpec
    {

        public c(byte abyte0[], int k, int l, String s)
        {
            super(abyte0, k, l, s);
        }

        public c(byte abyte0[], String s)
        {
            super(abyte0, s);
        }
    }


    private static byte a[] = new byte[16];
    private static String b = "SHA1PRNG";
    private static String c = "Crypto";
    private static String d = "HmacSHA1";
    private static String e = "RSA";
    private static String f = "RSA/ECB/nopadding";
    private static String g = "aeskeygenerate";
    private static String h = "last_key_generate";
    private static String i = "AES/CBC/PKCS7Padding";
    private static String j = "AES";

    public EncryptionUtils()
    {
    }

    public static byte[] DeAe(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        return b(abyte0, abyte1, abyte2);
    }

    public static String SeMeGe(String s, byte abyte0[], byte abyte1[], byte abyte2[], String s1, String s2)
    {
        return a(s, abyte0, abyte1, abyte2, s1, s2);
    }

    private static String a(String s, byte abyte0[], byte abyte1[], byte abyte2[], String s1, String s2)
    {
        try
        {
            s = a(s.getBytes("UTF-8"), abyte0, abyte1);
            byte abyte3[] = a(((byte []) (s)), abyte2);
            s = a(((byte []) (s)));
            abyte3 = a(abyte3);
            abyte1 = a(abyte1);
            s = new String(Base64.encode(b(a(a(b(b(a(abyte0), a(abyte2)), abyte1), s2, s1)), b(s, abyte3)), 8));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    private static byte[] a()
    {
        try
        {
            SecureRandom.getInstance(b, c).nextBytes(a);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            Log.internal("[InMobi]-4.5.5", "NoSuchAlgorithmException");
        }
        catch (NoSuchProviderException nosuchproviderexception)
        {
            Log.internal("[InMobi]-4.5.5", "NoSuchProviderException");
        }
        return a;
    }

    private static byte[] a(byte abyte0[])
    {
        long l = abyte0.length;
        ByteBuffer bytebuffer = ByteBuffer.allocate(8);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        bytebuffer.putLong(l);
        byte abyte1[] = bytebuffer.array();
        byte abyte2[] = new byte[abyte1.length + abyte0.length];
        System.arraycopy(abyte1, 0, abyte2, 0, abyte1.length);
        System.arraycopy(abyte0, 0, abyte2, abyte1.length, abyte0.length);
        return abyte2;
    }

    private static byte[] a(byte abyte0[], String s, String s1)
    {
        s1 = new BigInteger(s1, 16);
        s = new BigInteger(s, 16);
        try
        {
            s = (RSAPublicKey)KeyFactory.getInstance(e).generatePublic(new b(s1, s));
            s1 = Cipher.getInstance(f);
            s1.init(1, s);
            abyte0 = s1.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "NoSuchAlgorithmException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "InvalidKeySpecException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "NoSuchPaddingException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "InvalidKeyException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "IllegalBlockSizeException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "BadPaddingException");
            return null;
        }
        return abyte0;
    }

    private static byte[] a(byte abyte0[], byte abyte1[])
    {
        abyte1 = new c(abyte1, 0, abyte1.length, d);
        try
        {
            Mac mac = Mac.getInstance(d);
            mac.init(abyte1);
            abyte0 = mac.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "NoSuchAlgorithmException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "InvalidKeyException");
            return null;
        }
        return abyte0;
    }

    private static byte[] a(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        abyte1 = new c(abyte1, j);
        abyte2 = new a(abyte2);
        try
        {
            Cipher cipher = Cipher.getInstance(i);
            cipher.init(1, abyte1, abyte2);
            abyte0 = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "NoSuchAlgorithmException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "NoSuchPaddingException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "InvalidKeyException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "IllegalBlockSizeException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "BadPaddingException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "InvalidAlgorithmParameterException");
            return null;
        }
        return abyte0;
    }

    private static byte[] b()
    {
        Object obj = InternalSDKUtil.getContext().getSharedPreferences(g, 0);
        long l = ((SharedPreferences) (obj)).getLong(h, 0L);
        if (0L == l)
        {
            Log.internal("[InMobi]-4.5.5", "Generating for first time");
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putLong(h, System.currentTimeMillis());
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            return a();
        }
        if ((l + 0x5265c00L) - System.currentTimeMillis() <= 0L)
        {
            Log.internal("[InMobi]-4.5.5", "generated again");
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putLong(h, System.currentTimeMillis());
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            return a();
        } else
        {
            Log.internal("[InMobi]-4.5.5", "already generated");
            return a;
        }
    }

    private static byte[] b(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length + abyte1.length];
        System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
        System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
        return abyte2;
    }

    private static byte[] b(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        abyte1 = new c(abyte1, j);
        try
        {
            Cipher cipher = Cipher.getInstance(i);
            cipher.init(2, abyte1, new a(abyte2));
            abyte0 = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "NoSuchAlgorithmException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "NoSuchPaddingException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "InvalidKeyException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "IllegalBlockSizeException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "BadPaddingException");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.internal("[InMobi]-4.5.5", "InvalidAlgorithmParameterException");
            return null;
        }
        return abyte0;
    }

    public static byte[] generateKey(int k)
    {
        byte abyte0[];
        try
        {
            abyte0 = new byte[k];
            (new SecureRandom()).nextBytes(abyte0);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public static byte[] keag()
    {
        return b();
    }

}
