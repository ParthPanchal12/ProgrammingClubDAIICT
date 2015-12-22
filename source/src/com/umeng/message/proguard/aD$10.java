// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

// Referenced classes of package com.umeng.message.proguard:
//            aD

class init> extends init>
{

    final Reader a;
    final Writer b;
    final aD c;

    public aD a()
        throws IOException
    {
        char ac[] = new char[aD.a(c)];
        do
        {
            int i = a.read(ac);
            if (i != -1)
            {
                b.write(ac, 0, i);
            } else
            {
                return c;
            }
        } while (true);
    }

    public Object b()
        throws c, IOException
    {
        return a();
    }

    (aD ad, Closeable closeable, boolean flag, Reader reader, Writer writer)
    {
        c = ad;
        a = reader;
        b = writer;
        super(closeable, flag);
    }
}
