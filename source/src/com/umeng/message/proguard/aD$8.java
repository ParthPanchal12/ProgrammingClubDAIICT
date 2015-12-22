// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;

// Referenced classes of package com.umeng.message.proguard:
//            aD

class <init> extends <init>
{

    final BufferedReader a;
    final Writer b;
    final aD c;

    public aD a()
        throws IOException
    {
        return c.a(a, b);
    }

    public Object b()
        throws b, IOException
    {
        return a();
    }

    (aD ad, Closeable closeable, boolean flag, BufferedReader bufferedreader, Writer writer)
    {
        c = ad;
        a = bufferedreader;
        b = writer;
        super(closeable, flag);
    }
}
