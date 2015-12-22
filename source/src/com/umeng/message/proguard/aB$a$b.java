// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

// Referenced classes of package com.umeng.message.proguard:
//            p, aB, s, P, 
//            h, B, i, g, 
//            n, y, x, c

public static final class h extends p
    implements h
{
    public static final class a extends p.a
        implements aB.a.c
    {

        private int a;
        private int b;
        private int c;
        private Object d;
        private int e;
        private Object f;

        static a I()
        {
            return L();
        }

        private void K()
        {
            if (!aB.a.b.D());
        }

        private static a L()
        {
            return new a();
        }

        public static final k.a k()
        {
            return aB.d();
        }

        public aB.a.b A()
        {
            return aB.a.b.h();
        }

        public aB.a.b B()
        {
            aB.a.b b1 = C();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        public aB.a.b C()
        {
            int j1 = 1;
            aB.a.b b1 = new aB.a.b(this, null);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            aB.a.b.a(b1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            aB.a.b.b(b1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            aB.a.b.a(b1, d);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            aB.a.b.c(b1, e);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            aB.a.b.b(b1, f);
            aB.a.b.d(b1, j1);
            aB();
            return b1;
        }

        public a D()
        {
            a = a & -2;
            b = 0;
            aF();
            return this;
        }

        public a E()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        public a F()
        {
            a = a & -5;
            d = aB.a.b.h().t();
            aF();
            return this;
        }

        public a G()
        {
            a = a & -9;
            e = 0;
            aF();
            return this;
        }

        public a H()
        {
            a = a & 0xffffffef;
            f = aB.a.b.h().y();
            aF();
            return this;
        }

        public k.a J()
        {
            return aB.d();
        }

        public y Q()
        {
            return A();
        }

        public x R()
        {
            return A();
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

        public a a(aB.a.b b1)
        {
            if (b1 == aB.a.b.h())
            {
                return this;
            }
            if (b1.o())
            {
                a(b1.p());
            }
            if (b1.q())
            {
                b(b1.r());
            }
            if (b1.s())
            {
                a = a | 4;
                d = aB.a.b.b(b1);
                aF();
            }
            if (b1.v())
            {
                c(b1.w());
            }
            if (b1.x())
            {
                a = a | 0x10;
                f = aB.a.b.c(b1);
                aF();
            }
            d(b1.b_());
            return this;
        }

        public a a(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 4;
                d = s1;
                aF();
                return this;
            }
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
            return n();
        }

        public x aj()
        {
            return C();
        }

        public x ak()
        {
            return B();
        }

        public y al()
        {
            return C();
        }

        public y am()
        {
            return B();
        }

        public a b(int i1)
        {
            a = a | 2;
            c = i1;
            aF();
            return this;
        }

        public a b(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x10;
                f = s1;
                aF();
                return this;
            }
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a c(int i1)
        {
            a = a | 8;
            e = i1;
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
            return n();
        }

        public a.a d()
        {
            return n();
        }

        public a d(x x1)
        {
            if (x1 instanceof aB.a.b)
            {
                return a((aB.a.b)x1);
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

        public a e(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 4;
                d = g1;
                aF();
                return this;
            }
        }

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (aB.a.b)aB.a.b.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (aB.a.b)n1.a();
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

        public a f(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x10;
                f = g1;
                aF();
                return this;
            }
        }

        public b.a f()
        {
            return n();
        }

        public y.a g()
        {
            return n();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return n();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return aB.e().a(com/umeng/message/proguard/aB$a$b, com/umeng/message/proguard/aB$a$b$a);
        }

        public a m()
        {
            super.ah();
            b = 0;
            a = a & -2;
            c = 0;
            a = a & -3;
            d = "";
            a = a & -5;
            e = 0;
            a = a & -9;
            f = "";
            a = a & 0xffffffef;
            return this;
        }

        public a n()
        {
            return L().a(C());
        }

        public boolean o()
        {
            return (a & 1) == 1;
        }

        public int p()
        {
            return b;
        }

        public boolean q()
        {
            return (a & 2) == 2;
        }

        public int r()
        {
            return c;
        }

        public boolean s()
        {
            return (a & 4) == 4;
        }

        public String t()
        {
            Object obj = d;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                d = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g u()
        {
            Object obj = d;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                d = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public boolean v()
        {
            return (a & 8) == 8;
        }

        public int w()
        {
            return e;
        }

        public boolean x()
        {
            return (a & 0x10) == 16;
        }

        public String y()
        {
            Object obj = f;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                f = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g z()
        {
            Object obj = f;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                f = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        private a()
        {
            d = "";
            f = "";
            K();
        }

        private a(p.b b1)
        {
            super(b1);
            d = "";
            f = "";
            K();
        }

        a(p.b b1, aB._cls1 _pcls1)
        {
            this(b1);
        }
    }


    public static B a = new c() {

        public aB.a.b c(h h1, n n1)
            throws s
        {
            return new aB.a.b(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    private static final _cls1.c g;
    private static final long r = 0L;
    private final P h;
    private int i;
    private int j;
    private int k;
    private Object l;
    private int n;
    private Object o;
    private byte p;
    private int q;

    public static a A()
    {
        return a.I();
    }

    static boolean D()
    {
        return m;
    }

    private void E()
    {
        j = 0;
        k = 0;
        l = "";
        n = 0;
        o = "";
    }

    static int a(o o1, int i1)
    {
        o1.j = i1;
        return i1;
    }

    public static a a(j j1)
    {
        return A().a(j1);
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

    static Object a(a a1, Object obj)
    {
        a1.l = obj;
        return obj;
    }

    static int b(l l1, int i1)
    {
        l1.k = i1;
        return i1;
    }

    public static k b(InputStream inputstream)
        throws IOException
    {
        return (k)a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static Object b(a a1)
    {
        return a1.l;
    }

    static Object b(l l1, Object obj)
    {
        l1.o = obj;
        return obj;
    }

    static int c(o o1, int i1)
    {
        o1.n = i1;
        return i1;
    }

    static Object c(n n1)
    {
        return n1.o;
    }

    static int d(o o1, int i1)
    {
        o1.i = i1;
        return i1;
    }

    public static i h()
    {
        return g;
    }

    public static final g n()
    {
        return aB.d();
    }

    public a B()
    {
        return A();
    }

    public a C()
    {
        return a(this);
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public a M()
    {
        return C();
    }

    public C N()
    {
        return B();
    }

    public B O()
    {
        return C();
    }

    public C P()
    {
        return B();
    }

    public y Q()
    {
        return k();
    }

    public x R()
    {
        return k();
    }

    protected a a(k k1)
    {
        return new a(k1, null);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        if ((i & 1) == 1)
        {
            i1.a(1, j);
        }
        if ((i & 2) == 2)
        {
            i1.a(2, k);
        }
        if ((i & 4) == 4)
        {
            i1.a(3, u());
        }
        if ((i & 8) == 8)
        {
            i1.a(4, n);
        }
        if ((i & 0x10) == 16)
        {
            i1.a(5, z());
        }
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = p;
        if (byte0 != -1)
        {
            return byte0 == 1;
        } else
        {
            p = 1;
            return true;
        }
    }

    protected p b(p p1)
    {
        return a(p1);
    }

    public final P b_()
    {
        return h;
    }

    public int d()
    {
        int i1 = q;
        if (i1 != -1)
        {
            return i1;
        }
        int j1 = 0;
        if ((i & 1) == 1)
        {
            j1 = 0 + com.umeng.message.proguard.i.g(1, j);
        }
        i1 = j1;
        if ((i & 2) == 2)
        {
            i1 = j1 + com.umeng.message.proguard.i.g(2, k);
        }
        j1 = i1;
        if ((i & 4) == 4)
        {
            j1 = i1 + com.umeng.message.proguard.i.c(3, u());
        }
        i1 = j1;
        if ((i & 8) == 8)
        {
            i1 = j1 + com.umeng.message.proguard.i.g(4, n);
        }
        j1 = i1;
        if ((i & 0x10) == 16)
        {
            j1 = i1 + com.umeng.message.proguard.i.c(5, z());
        }
        i1 = j1 + b_().d();
        q = i1;
        return i1;
    }

    public q k()
    {
        return g;
    }

    protected g l()
    {
        return aB.e().g(com/umeng/message/proguard/aB$a$b, com/umeng/message/proguard/aB$a$b$a);
    }

    public B m()
    {
        return a;
    }

    public boolean o()
    {
        return (i & 1) == 1;
    }

    public int p()
    {
        return j;
    }

    public boolean q()
    {
        return (i & 2) == 2;
    }

    public int r()
    {
        return k;
    }

    public boolean s()
    {
        return (i & 4) == 4;
    }

    public String t()
    {
        Object obj = l;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            l = s1;
        }
        return s1;
    }

    public g u()
    {
        Object obj = l;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            l = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean v()
    {
        return (i & 8) == 8;
    }

    public int w()
    {
        return n;
    }

    public boolean x()
    {
        return (i & 0x10) == 16;
    }

    public String y()
    {
        Object obj = o;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            o = s1;
        }
        return s1;
    }

    public g z()
    {
        Object obj = o;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            o = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    static 
    {
        g = new <init>(true);
        g.E();
    }

    private _cls1(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        boolean flag;
        p = -1;
        q = -1;
        E();
        _lcls1 = com.umeng.message.proguard.P.b();
        flag = false;
_L11:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = h1.a();
        i1;
        JVM INSTR lookupswitch 6: default 273
    //                   0: 276
    //                   8: 114
    //                   16: 157
    //                   26: 195
    //                   32: 216
    //                   42: 238;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        if (!a(h1, _lcls1, n1, i1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i = i | 1;
        j = h1.g();
        continue; /* Loop/switch isn't completed */
        h1;
        throw h1.a(this);
        h1;
        h = _lcls1.h();
        ad();
        throw h1;
_L6:
        i = i | 2;
        k = h1.g();
        continue; /* Loop/switch isn't completed */
        h1;
        throw (new s(h1.getMessage())).a(this);
_L7:
        i = i | 4;
        l = h1.l();
        continue; /* Loop/switch isn't completed */
_L8:
        i = i | 8;
        n = h1.g();
        continue; /* Loop/switch isn't completed */
_L9:
        i = i | 0x10;
        o = h1.l();
        continue; /* Loop/switch isn't completed */
_L2:
        h = _lcls1.h();
        ad();
        return;
_L4:
        flag = true;
        if (true) goto _L11; else goto _L10
_L10:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        p = -1;
        q = -1;
        h = <init>1.h();
    }

    h(h h1, h h2)
    {
        this(h1);
    }

    private <init>(boolean flag)
    {
        p = -1;
        q = -1;
        h = com.umeng.message.proguard.P.c();
    }
}
