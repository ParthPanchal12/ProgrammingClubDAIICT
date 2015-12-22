// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.CharBuffer;

// Referenced classes of package com.umeng.message.proguard:
//            aD

class <init> extends <init>
{

    final BufferedReader a;
    final Appendable b;
    final aD c;

    public aD a()
        throws IOException
    {
        CharBuffer charbuffer = CharBuffer.allocate(aD.a(c));
        do
        {
            int i = a.read(charbuffer);
            if (i != -1)
            {
                charbuffer.rewind();
                b.append(charbuffer, 0, i);
                charbuffer.rewind();
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

    (aD ad, Closeable closeable, boolean flag, BufferedReader bufferedreader, Appendable appendable)
    {
        c = ad;
        a = bufferedreader;
        b = appendable;
        super(closeable, flag);
    }
}
