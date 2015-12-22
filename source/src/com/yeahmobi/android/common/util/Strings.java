// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import java.io.IOException;
import java.io.InputStream;

public class Strings
{

    public Strings()
    {
    }

    public static String fromStream(InputStream inputstream)
        throws IOException
    {
        int i = 0;
        StringBuffer stringbuffer = new StringBuffer();
        byte abyte0[] = new byte[4096];
        for (; i != -1; i = inputstream.read(abyte0))
        {
            stringbuffer.append(new String(abyte0, 0, i));
        }

        inputstream.close();
        return stringbuffer.toString();
    }

    public static boolean isEmpty(String s)
    {
        while (s == null || s.length() != 0) 
        {
            return false;
        }
        return true;
    }
}
