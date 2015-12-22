// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.umeng.message.proguard:
//            z, y, s, n, 
//            g, h

public static interface 
    extends z, Cloneable
{

    public abstract y al();

    public abstract y am();

    public abstract boolean b(InputStream inputstream)
        throws IOException;

    public abstract boolean b(InputStream inputstream, n n)
        throws IOException;

    public abstract  c(g g1)
        throws s;

    public abstract  c(g g1, n n)
        throws s;

    public abstract  c(h h1)
        throws IOException;

    public abstract  c(h h1, n n)
        throws IOException;

    public abstract  c(byte abyte0[])
        throws s;

    public abstract  c(byte abyte0[], int i, int j)
        throws s;

    public abstract  c(byte abyte0[], int i, int j, n n)
        throws s;

    public abstract  c(byte abyte0[], n n)
        throws s;

    public abstract  d(InputStream inputstream)
        throws IOException;

    public abstract  d(InputStream inputstream, n n)
        throws IOException;

    public abstract  g();

    public abstract  h();
}
