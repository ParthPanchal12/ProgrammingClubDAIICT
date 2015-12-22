// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.umeng.message.proguard:
//            z, i, g, B, 
//            s, n, h

public interface y
    extends z
{
    public static interface a
        extends z, Cloneable
    {

        public abstract y al();

        public abstract y am();

        public abstract boolean b(InputStream inputstream)
            throws IOException;

        public abstract boolean b(InputStream inputstream, n n)
            throws IOException;

        public abstract a c(g g1)
            throws s;

        public abstract a c(g g1, n n)
            throws s;

        public abstract a c(h h1)
            throws IOException;

        public abstract a c(h h1, n n)
            throws IOException;

        public abstract a c(byte abyte0[])
            throws s;

        public abstract a c(byte abyte0[], int i, int j)
            throws s;

        public abstract a c(byte abyte0[], int i, int j, n n)
            throws s;

        public abstract a c(byte abyte0[], n n)
            throws s;

        public abstract a d(InputStream inputstream)
            throws IOException;

        public abstract a d(InputStream inputstream, n n)
            throws IOException;

        public abstract a g();

        public abstract a h();
    }


    public abstract a O();

    public abstract a P();

    public abstract void a(i i)
        throws IOException;

    public abstract void a(OutputStream outputstream)
        throws IOException;

    public abstract void b(OutputStream outputstream)
        throws IOException;

    public abstract int d();

    public abstract g f();

    public abstract byte[] g();

    public abstract B m();
}
