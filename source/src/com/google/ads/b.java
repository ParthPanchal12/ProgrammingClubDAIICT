// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class b
{

    private static b c = null;
    private final BigInteger a = d();
    private BigInteger b;

    private b()
    {
        b = BigInteger.ONE;
    }

    public static b a()
    {
        com/google/ads/b;
        JVM INSTR monitorenter ;
        b b1;
        if (c == null)
        {
            c = new b();
        }
        b1 = c;
        com/google/ads/b;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    private static byte[] a(long l)
    {
        return BigInteger.valueOf(l).toByteArray();
    }

    private static BigInteger d()
    {
        Object obj;
        byte abyte0[];
        try
        {
            obj = MessageDigest.getInstance("MD5");
            UUID uuid = UUID.randomUUID();
            ((MessageDigest) (obj)).update(a(uuid.getLeastSignificantBits()));
            ((MessageDigest) (obj)).update(a(uuid.getMostSignificantBits()));
            abyte0 = new byte[9];
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new RuntimeException("Cannot find MD5 message digest algorithm.");
        }
        abyte0[0] = 0;
        System.arraycopy(((MessageDigest) (obj)).digest(), 0, abyte0, 1, 8);
        obj = new BigInteger(abyte0);
        return ((BigInteger) (obj));
    }

    public BigInteger b()
    {
        this;
        JVM INSTR monitorenter ;
        BigInteger biginteger = a;
        this;
        JVM INSTR monitorexit ;
        return biginteger;
        Exception exception;
        exception;
        throw exception;
    }

    public BigInteger c()
    {
        this;
        JVM INSTR monitorenter ;
        BigInteger biginteger;
        biginteger = b;
        b = b.add(BigInteger.ONE);
        this;
        JVM INSTR monitorexit ;
        return biginteger;
        Exception exception;
        exception;
        throw exception;
    }

}
