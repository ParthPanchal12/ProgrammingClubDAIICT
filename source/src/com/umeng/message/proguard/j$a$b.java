// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

// Referenced classes of package com.umeng.message.proguard:
//            p, j, s, P, 
//            h, B, i, n, 
//            g, y, x, c

public static final class e extends p
    implements e
{
    public static final class a extends p.a
        implements j.a.c
    {

        private int a;
        private int b;
        private int c;

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.h();
        }

        static a x()
        {
            return z();
        }

        private void y()
        {
            if (!p.m);
        }

        private static a z()
        {
            return new a();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.h();
        }

        public y Q()
        {
            return s();
        }

        public x R()
        {
            return s();
        }

        public a.a a(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a a(x x1)
        {
            return d(x1);
        }

        public a a(int i1)
        {
            a = a | 1;
            b = i1;
            aF();
            return this;
        }

        public a a(j.a.b b1)
        {
            if (b1 == j.a.b.h())
            {
                return this;
            }
            if (b1.n())
            {
                a(b1.o());
            }
            if (b1.p())
            {
                b(b1.q());
            }
            d(b1.b_());
            return this;
        }

        public final boolean a()
        {
            return true;
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return r();
        }

        public x aj()
        {
            return u();
        }

        public x ak()
        {
            return t();
        }

        public y al()
        {
            return u();
        }

        public y am()
        {
            return t();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a b(int i1)
        {
            a = a | 2;
            c = i1;
            aF();
            return this;
        }

        public x.a c(x x1)
        {
            return d(x1);
        }

        public y.a c(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public Object clone()
            throws CloneNotSupportedException
        {
            return r();
        }

        public a.a d()
        {
            return r();
        }

        public a d(x x1)
        {
            if (x1 instanceof j.a.b)
            {
                return a((j.a.b)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public x.a d(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a.a e()
        {
            return m();
        }

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (j.a.b)j.a.b.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.a.b)n1.a();
            throw n1;
            n1;
_L2:
            if (h1 != null)
            {
                a(h1);
            }
            throw n1;
            n1;
            h1 = null;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public b.a f()
        {
            return r();
        }

        public y.a g()
        {
            return r();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return r();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.i().a(com/umeng/message/proguard/j$a$b, com/umeng/message/proguard/j$a$b$a);
        }

        public a m()
        {
            super.ah();
            b = 0;
            a = a & -2;
            c = 0;
            a = a & -3;
            return this;
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public int o()
        {
            return b;
        }

        public boolean p()
        {
            return (a & 2) == 2;
        }

        public int q()
        {
            return c;
        }

        public a r()
        {
            return z().a(u());
        }

        public j.a.b s()
        {
            return j.a.b.h();
        }

        public j.a.b t()
        {
            j.a.b b1 = u();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        public j.a.b u()
        {
            int i1 = 1;
            j.a.b b1 = new j.a.b(this, null);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            j.a.b.a(b1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            j.a.b.b(b1, c);
            j.a.b.c(b1, j1);
            aB();
            return b1;
        }

        public a v()
        {
            a = a & -2;
            b = 0;
            aF();
            return this;
        }

        public a w()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        private a()
        {
            y();
        }

        private a(p.b b1)
        {
            super(b1);
            y();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }


    public static B a = new c() {

        public j.a.b c(h h1, n n1)
            throws s
        {
            return new j.a.b(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    public static final int c = 2;
    private static final _cls1.c d;
    private static final long k = 0L;
    private final P e;
    private int f;
    private int g;
    private int h;
    private byte i;
    private int j;

    static int a(a.aF af, int i1)
    {
        af.g = i1;
        return i1;
    }

    public static a a(g g1)
    {
        return r().a(g1);
    }

    public static a.a a(g g1)
        throws s
    {
        return (a.a)a.d(g1);
    }

    public static a a(g g1, n n1)
        throws s
    {
        return (a)a.d(g1, n1);
    }

    public static a a(h h1)
        throws IOException
    {
        return (a)a.d(h1);
    }

    public static a a(h h1, n n1)
        throws IOException
    {
        return (a)a.b(h1, n1);
    }

    public static a a(InputStream inputstream)
        throws IOException
    {
        return (a)a.h(inputstream);
    }

    public static a a(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.h(inputstream, n1);
    }

    public static a a(byte abyte0[])
        throws s
    {
        return (a)a.d(abyte0);
    }

    public static a a(byte abyte0[], n n1)
        throws s
    {
        return (a)a.d(abyte0, n1);
    }

    static int b(a a1, int i1)
    {
        a1.h = i1;
        return i1;
    }

    public static h b(InputStream inputstream)
        throws IOException
    {
        return (h)a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static int c(a a1, int i1)
    {
        a1.f = i1;
        return i1;
    }

    public static f h()
    {
        return d;
    }

    public static final d k()
    {
        return com.umeng.message.proguard.j.h();
    }

    public static a r()
    {
        return a.x();
    }

    private void u()
    {
        g = 0;
        h = 0;
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public h M()
    {
        return t();
    }

    public t N()
    {
        return s();
    }

    public s O()
    {
        return t();
    }

    public t P()
    {
        return s();
    }

    public y Q()
    {
        return i();
    }

    public x R()
    {
        return i();
    }

    protected a a(i i1)
    {
        return new a(i1, null);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        if ((f & 1) == 1)
        {
            i1.a(1, g);
        }
        if ((f & 2) == 2)
        {
            i1.a(2, h);
        }
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = i;
        if (byte0 != -1)
        {
            return byte0 == 1;
        } else
        {
            i = 1;
            return true;
        }
    }

    protected i b(i i1)
    {
        return a(i1);
    }

    public final P b_()
    {
        return e;
    }

    public int d()
    {
        int i1 = j;
        if (i1 != -1)
        {
            return i1;
        }
        i1 = 0;
        if ((f & 1) == 1)
        {
            i1 = 0 + com.umeng.message.proguard.i.g(1, g);
        }
        int j1 = i1;
        if ((f & 2) == 2)
        {
            j1 = i1 + com.umeng.message.proguard.i.g(2, h);
        }
        i1 = j1 + b_().d();
        j = i1;
        return i1;
    }

    public j i()
    {
        return d;
    }

    protected d l()
    {
        return com.umeng.message.proguard.j.i().d(com/umeng/message/proguard/j$a$b, com/umeng/message/proguard/j$a$b$a);
    }

    public B m()
    {
        return a;
    }

    public boolean n()
    {
        return (f & 1) == 1;
    }

    public int o()
    {
        return g;
    }

    public boolean p()
    {
        return (f & 2) == 2;
    }

    public int q()
    {
        return h;
    }

    public a s()
    {
        return r();
    }

    public a t()
    {
        return a(this);
    }

    static 
    {
        d = new <init>(true);
        d.u();
    }

    private _cls1(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        boolean flag;
        i = -1;
        j = -1;
        u();
        _lcls1 = com.umeng.message.proguard.P.b();
        flag = false;
_L8:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = h1.a();
        i1;
        JVM INSTR lookupswitch 3: default 184
    //                   0: 187
    //                   8: 90
    //                   16: 133;
           goto _L3 _L4 _L5 _L6
_L3:
        if (!a(h1, _lcls1, n1, i1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        f = f | 1;
        g = h1.g();
        continue; /* Loop/switch isn't completed */
        h1;
        throw h1.a(this);
        h1;
        e = _lcls1.e();
        ad();
        throw h1;
_L6:
        f = f | 2;
        h = h1.g();
        continue; /* Loop/switch isn't completed */
        h1;
        throw (new s(h1.getMessage())).a(this);
_L2:
        e = _lcls1.e();
        ad();
        return;
_L4:
        flag = true;
        if (true) goto _L8; else goto _L7
_L7:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        i = -1;
        j = -1;
        e = <init>1.();
    }

    ( ,  1)
    {
        this();
    }

    private <init>(boolean flag)
    {
        i = -1;
        j = -1;
        e = com.umeng.message.proguard.P.c();
    }
}
