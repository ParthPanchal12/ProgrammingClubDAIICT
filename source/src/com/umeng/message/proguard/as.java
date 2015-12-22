// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.umeng.message.proguard:
//            at

public class as
{

    private static byte a[] = "uLi4/f4+Pb39.T19".getBytes();
    private static byte b[] = "nmeug.f9/Om+L823".getBytes();

    public as()
    {
    }

    public static String a(String s, String s1)
        throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(a, "AES"), new IvParameterSpec(b));
        return new String(cipher.doFinal(at.b(s)), s1);
    }

    public static transient String a(String as1[])
        throws Exception
    {
        Object obj = null;
        String s;
        if (as1.length == 2)
        {
            s = as1[0];
            as1 = as1[1];
        } else
        if (as1.length == 3)
        {
            s = as1[0];
            String s1 = as1[1];
            obj = as1[2];
            as1 = s1;
        } else
        {
            as1 = null;
            s = null;
        }
        if (obj != null && ((String) (obj)).length() == 16)
        {
            a = ((String) (obj)).getBytes();
        }
        obj = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher) (obj)).init(1, new SecretKeySpec(a, "AES"), new IvParameterSpec(b));
        return at.d(((Cipher) (obj)).doFinal(s.getBytes(as1)));
    }

}
