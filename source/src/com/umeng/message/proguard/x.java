// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.umeng.message.proguard:
//            A, y, B, s, 
//            P, n, g, h

public interface x
    extends A, y
{
    public static interface a
        extends A, y.a
    {

        public abstract k.a J();

        public abstract a a(k.f f1);

        public abstract x aj();

        public abstract x ak();

        public abstract a b(P p);

        public abstract a b(k.f f1, int k, Object obj);

        public abstract boolean b(InputStream inputstream)
            throws IOException;

        public abstract boolean b(InputStream inputstream, n n)
            throws IOException;

        public abstract a c(k.f f1, Object obj);

        public abstract a c(x x1);

        public abstract a d(g g1)
            throws s;

        public abstract a d(g g1, n n)
            throws s;

        public abstract a d(h h)
            throws IOException;

        public abstract a d(h h, n n)
            throws IOException;

        public abstract a d(k.f f1, Object obj);

        public abstract a d(byte abyte0[])
            throws s;

        public abstract a d(byte abyte0[], int k, int l)
            throws s;

        public abstract a d(byte abyte0[], int k, int l, n n)
            throws s;

        public abstract a d(byte abyte0[], n n)
            throws s;

        public abstract a e(P p);

        public abstract a e(InputStream inputstream)
            throws IOException;

        public abstract a e(InputStream inputstream, n n)
            throws IOException;

        public abstract a f(k.f f1);

        public abstract a g(k.f f1);

        public abstract a i();

        public abstract a j();
    }


    public abstract a M();

    public abstract a N();

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract B m();

    public abstract String toString();
}
