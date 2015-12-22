// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.Flushable;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

// Referenced classes of package com.umeng.message.proguard:
//            aD

class <init> extends <init>
{

    final Reader a;
    final Writer b;
    final aD c;

    protected aD a()
        throws IOException
    {
        return c.a(a, b);
    }

    protected Object b()
        throws b, IOException
    {
        return a();
    }

    (aD ad, Flushable flushable, Reader reader, Writer writer)
    {
        c = ad;
        a = reader;
        b = writer;
        super(flushable);
    }
}
