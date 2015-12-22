// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

// Referenced classes of package com.umeng.message.proguard:
//            p, j, s, P, 
//            h, B, i, g, 
//            n, y, x, L, 
//            c

public static final class f extends p
    implements f
{
    public static final class a extends p.a
        implements j.h
    {

        private int a;
        private Object b;
        private int c;
        private j.i d;
        private L e;

        static a D()
        {
            return F();
        }

        private void E()
        {
            if (p.m)
            {
                G();
            }
        }

        private static a F()
        {
            return new a();
        }

        private L G()
        {
            if (e == null)
            {
                e = new L(d, aE(), aD());
                d = null;
            }
            return e;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.n();
        }

        public a A()
        {
            a = a & -3;
            c = 0;
            aF();
            return this;
        }

        public a B()
        {
            if (e == null)
            {
                d = com.umeng.message.proguard.j.i.h();
                aF();
            } else
            {
                e.g();
            }
            a = a & -5;
            return this;
        }

        public j.i.a C()
        {
            a = a | 4;
            aF();
            return (j.i.a)G().e();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.n();
        }

        public y Q()
        {
            return w();
        }

        public x R()
        {
            return w();
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
            a = a | 2;
            c = i1;
            aF();
            return this;
        }

        public a a(j.g g1)
        {
            if (g1 == j.g.h())
            {
                return this;
            }
            if (g1.n())
            {
                a = a | 1;
                b = j.g.b(g1);
                aF();
            }
            if (g1.q())
            {
                a(g1.r());
            }
            if (g1.s())
            {
                b(g1.t());
            }
            d(g1.b_());
            return this;
        }

        public a a(j.i.a a1)
        {
            if (e == null)
            {
                d = a1.s();
                aF();
            } else
            {
                e.a(a1.s());
            }
            a = a | 4;
            return this;
        }

        public a a(j.i i1)
        {
            if (e == null)
            {
                if (i1 == null)
                {
                    throw new NullPointerException();
                }
                d = i1;
                aF();
            } else
            {
                e.a(i1);
            }
            a = a | 4;
            return this;
        }

        public a a(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 1;
                b = s1;
                aF();
                return this;
            }
        }

        public final boolean a()
        {
            return !s() || t().a();
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return v();
        }

        public x aj()
        {
            return y();
        }

        public x ak()
        {
            return x();
        }

        public y al()
        {
            return y();
        }

        public y am()
        {
            return x();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a b(j.i i1)
        {
            if (e == null)
            {
                if ((a & 4) == 4 && d != com.umeng.message.proguard.j.i.h())
                {
                    d = com.umeng.message.proguard.j.i.a(d).a(i1).t();
                } else
                {
                    d = i1;
                }
                aF();
            } else
            {
                e.b(i1);
            }
            a = a | 4;
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
            return v();
        }

        public a.a d()
        {
            return v();
        }

        public a d(x x1)
        {
            if (x1 instanceof j.g)
            {
                return a((j.g)x1);
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
                a = a | 1;
                b = g1;
                aF();
                return this;
            }
        }

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (j.g)j.g.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.g)n1.a();
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
            return v();
        }

        public y.a g()
        {
            return v();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return v();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.o().a(com/umeng/message/proguard/j$g, com/umeng/message/proguard/j$g$a);
        }

        public a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = 0;
            a = a & -3;
            if (e == null)
            {
                d = com.umeng.message.proguard.j.i.h();
            } else
            {
                e.g();
            }
            a = a & -5;
            return this;
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public String o()
        {
            Object obj = b;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                b = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g p()
        {
            Object obj = b;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                b = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
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

        public j.i t()
        {
            if (e == null)
            {
                return d;
            } else
            {
                return (j.i)e.c();
            }
        }

        public j.j u()
        {
            if (e != null)
            {
                return (j.j)e.f();
            } else
            {
                return d;
            }
        }

        public a v()
        {
            return F().a(y());
        }

        public j.g w()
        {
            return j.g.h();
        }

        public j.g x()
        {
            j.g g1 = y();
            if (!g1.a())
            {
                throw b(g1);
            } else
            {
                return g1;
            }
        }

        public j.g y()
        {
            int i1 = 1;
            j.g g1 = new j.g(this, null);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            j.g.a(g1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            j.g.a(g1, c);
            if ((k1 & 4) == 4)
            {
                i1 = j1 | 4;
            } else
            {
                i1 = j1;
            }
            if (e == null)
            {
                j.g.a(g1, d);
            } else
            {
                j.g.a(g1, (j.i)e.d());
            }
            j.g.b(g1, i1);
            aB();
            return g1;
        }

        public a z()
        {
            a = a & -2;
            b = j.g.h().o();
            aF();
            return this;
        }

        private a()
        {
            b = "";
            d = com.umeng.message.proguard.j.i.h();
            E();
        }

        private a(p.b b1)
        {
            super(b1);
            b = "";
            d = com.umeng.message.proguard.j.i.h();
            E();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }


    public static B a = new c() {

        public j.g c(h h1, n n1)
            throws s
        {
            return new j.g(h1, n1, null);
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
    private static final _cls1.c e;
    private static final long n = 0L;
    private final P f;
    private int g;
    private Object h;
    private int i;
    private _cls1.c j;
    private byte k;
    private int l;

    static int a(a.aF af, int i1)
    {
        af.i = i1;
        return i1;
    }

    public static a a(i i1)
    {
        return v().a(i1);
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

    static a a(a a1, a a2)
    {
        a1.j = a2;
        return a2;
    }

    static Object a(j j1, Object obj)
    {
        j1.h = obj;
        return obj;
    }

    static int b(h h1, int i1)
    {
        h1.g = i1;
        return i1;
    }

    public static g b(InputStream inputstream)
        throws IOException
    {
        return (g)a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static Object b(a a1)
    {
        return a1.h;
    }

    public static h h()
    {
        return e;
    }

    public static final e k()
    {
        return com.umeng.message.proguard.j.n();
    }

    public static a v()
    {
        return a.D();
    }

    private void y()
    {
        h = "";
        i = 0;
        j = h();
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public h M()
    {
        return x();
    }

    public x N()
    {
        return w();
    }

    public w O()
    {
        return x();
    }

    public x P()
    {
        return w();
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
        if ((g & 1) == 1)
        {
            i1.a(1, p());
        }
        if ((g & 2) == 2)
        {
            i1.a(2, i);
        }
        if ((g & 4) == 4)
        {
            i1.c(3, j);
        }
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = k;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        if (s() && !t().a())
        {
            k = 0;
            return false;
        } else
        {
            k = 1;
            return true;
        }
    }

    protected k b(k k1)
    {
        return a(k1);
    }

    public final P b_()
    {
        return f;
    }

    public int d()
    {
        int i1 = l;
        if (i1 != -1)
        {
            return i1;
        }
        int j1 = 0;
        if ((g & 1) == 1)
        {
            j1 = 0 + com.umeng.message.proguard.i.c(1, p());
        }
        i1 = j1;
        if ((g & 2) == 2)
        {
            i1 = j1 + com.umeng.message.proguard.i.g(2, i);
        }
        j1 = i1;
        if ((g & 4) == 4)
        {
            j1 = i1 + com.umeng.message.proguard.i.g(3, j);
        }
        i1 = j1 + b_().d();
        l = i1;
        return i1;
    }

    public l i()
    {
        return e;
    }

    protected e l()
    {
        return com.umeng.message.proguard.j.o().a(com/umeng/message/proguard/j$g, com/umeng/message/proguard/j$g$a);
    }

    public B m()
    {
        return a;
    }

    public boolean n()
    {
        return (g & 1) == 1;
    }

    public String o()
    {
        Object obj = h;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            h = s1;
        }
        return s1;
    }

    public g p()
    {
        Object obj = h;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            h = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean q()
    {
        return (g & 2) == 2;
    }

    public int r()
    {
        return i;
    }

    public boolean s()
    {
        return (g & 4) == 4;
    }

    public g t()
    {
        return j;
    }

    public j u()
    {
        return j;
    }

    public a w()
    {
        return v();
    }

    public a x()
    {
        return a(this);
    }

    static 
    {
        e = new <init>(true);
        e.y();
    }

    private a(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        boolean flag;
        k = -1;
        l = -1;
        y();
        _lcls1 = com.umeng.message.proguard.P.b();
        flag = false;
_L14:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = h1.a();
        i1;
        JVM INSTR lookupswitch 4: default 270
    //                   0: 276
    //                   10: 99
    //                   16: 120
    //                   26: 141;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        if (!a(h1, _lcls1, n1, i1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        g = g | 1;
        h = h1.l();
        continue; /* Loop/switch isn't completed */
_L6:
        g = g | 2;
        i = h1.g();
        continue; /* Loop/switch isn't completed */
_L7:
        if ((g & 4) != 4) goto _L9; else goto _L8
_L8:
        a a1 = j.s();
_L12:
        j = (j)h1.a(a, n1);
        if (a1 == null) goto _L11; else goto _L10
_L10:
        a1.a(j);
        j = a1.t();
_L11:
        g = g | 4;
        continue; /* Loop/switch isn't completed */
        h1;
        throw h1.a(this);
        h1;
        f = _lcls1.b();
        ad();
        throw h1;
        h1;
        throw (new s(h1.getMessage())).a(this);
_L2:
        f = _lcls1.b();
        ad();
        return;
_L9:
        a1 = null;
          goto _L12
_L4:
        flag = true;
        if (true) goto _L14; else goto _L13
_L13:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        k = -1;
        l = -1;
        f = <init>1.b_();
    }

    b_(b_ b_1, b_ b_2)
    {
        this(b_1);
    }

    private <init>(boolean flag)
    {
        k = -1;
        l = -1;
        f = com.umeng.message.proguard.P.c();
    }
}
