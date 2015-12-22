// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

// Referenced classes of package com.umeng.message.proguard:
//            bv

public class bt
{

    private static final String a = "SHA-1";
    private static final String b = "MD5";
    private static final String c = "SHA-256";

    public bt()
    {
    }

    public static String a(InputStream inputstream)
    {
        try
        {
            inputstream = a(inputstream, "MD5");
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return null;
        }
        return inputstream;
    }

    private static String a(InputStream inputstream, String s)
        throws IOException
    {
        byte abyte0[];
        int i;
        try
        {
            s = MessageDigest.getInstance(s);
            abyte0 = new byte[1024];
            i = inputstream.read(abyte0, 0, 1024);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return null;
        }
        if (i <= -1)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        s.update(abyte0, 0, i);
        i = inputstream.read(abyte0, 0, 1024);
        break MISSING_BLOCK_LABEL_21;
        inputstream = bv.a(s.digest());
        return inputstream;
    }

    public static String a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        try
        {
            s = a(s.getBytes("UTF-8"), "MD5");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static String a(byte abyte0[])
    {
        return a(abyte0, "SHA-256");
    }

    private static String a(byte abyte0[], String s)
    {
        try
        {
            s = MessageDigest.getInstance(s);
            s.update(abyte0, 0, abyte0.length);
            abyte0 = bv.a(s.digest());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        return abyte0;
    }

    public static String b(InputStream inputstream)
    {
        try
        {
            inputstream = a(inputstream, "SHA-1");
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return null;
        }
        return inputstream;
    }

    public static String b(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        try
        {
            s = a(s.getBytes("UTF-8"), "SHA-1");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static String c(InputStream inputstream)
    {
        try
        {
            inputstream = a(inputstream, "SHA-256");
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return null;
        }
        return inputstream;
    }

    public static String c(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        try
        {
            s = a(s.getBytes("UTF-8"), "SHA-256");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }
}
