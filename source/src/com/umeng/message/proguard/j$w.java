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

public static final class g extends p
    implements g
{
    public static final class a extends p.a
        implements j.x
    {

        private int a;
        private Object b;
        private Object c;
        private Object d;
        private j.y e;
        private L f;

        static a I()
        {
            return L();
        }

        private void K()
        {
            if (p.m)
            {
                M();
            }
        }

        private static a L()
        {
            return new a();
        }

        private L M()
        {
            if (f == null)
            {
                f = new L(e, aE(), aD());
                e = null;
            }
            return f;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.r();
        }

        public j.w A()
        {
            return j.w.h();
        }

        public j.w B()
        {
            j.w w1 = C();
            if (!w1.a())
            {
                throw b(w1);
            } else
            {
                return w1;
            }
        }

        public j.w C()
        {
            int j1 = 1;
            j.w w1 = new j.w(this, null);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            j.w.a(w1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            j.w.b(w1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            j.w.c(w1, d);
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            } else
            {
                i1 = j1;
            }
            if (f == null)
            {
                j.w.a(w1, e);
            } else
            {
                j.w.a(w1, (j.y)f.d());
            }
            j.w.a(w1, i1);
            aB();
            return w1;
        }

        public a D()
        {
            a = a & -2;
            b = j.w.h().o();
            aF();
            return this;
        }

        public a E()
        {
            a = a & -3;
            c = j.w.h().r();
            aF();
            return this;
        }

        public a F()
        {
            a = a & -5;
            d = j.w.h().u();
            aF();
            return this;
        }

        public a G()
        {
            if (f == null)
            {
                e = com.umeng.message.proguard.j.y.h();
                aF();
            } else
            {
                f.g();
            }
            a = a & -9;
            return this;
        }

        public j.y.a H()
        {
            a = a | 8;
            aF();
            return (j.y.a)M().e();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.r();
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

        public a a(j.w w1)
        {
            if (w1 == j.w.h())
            {
                return this;
            }
            if (w1.n())
            {
                a = a | 1;
                b = j.w.b(w1);
                aF();
            }
            if (w1.q())
            {
                a = a | 2;
                c = j.w.c(w1);
                aF();
            }
            if (w1.t())
            {
                a = a | 4;
                d = j.w.d(w1);
                aF();
            }
            if (w1.w())
            {
                b(w1.x());
            }
            d(w1.b_());
            return this;
        }

        public a a(j.y.a a1)
        {
            if (f == null)
            {
                e = a1.s();
                aF();
            } else
            {
                f.a(a1.s());
            }
            a = a | 8;
            return this;
        }

        public a a(j.y y1)
        {
            if (f == null)
            {
                if (y1 == null)
                {
                    throw new NullPointerException();
                }
                e = y1;
                aF();
            } else
            {
                f.a(y1);
            }
            a = a | 8;
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
            return !w() || x().a();
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return z();
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

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a b(j.y y1)
        {
            if (f == null)
            {
                if ((a & 8) == 8 && e != com.umeng.message.proguard.j.y.h())
                {
                    e = com.umeng.message.proguard.j.y.a(e).a(y1).t();
                } else
                {
                    e = y1;
                }
                aF();
            } else
            {
                f.b(y1);
            }
            a = a | 8;
            return this;
        }

        public a b(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 2;
                c = s1;
                aF();
                return this;
            }
        }

        public a c(String s1)
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
            return z();
        }

        public a.a d()
        {
            return z();
        }

        public a d(x x1)
        {
            if (x1 instanceof j.w)
            {
                return a((j.w)x1);
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
            h1 = (j.w)j.w.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.w)n1.a();
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
            return z();
        }

        public a f(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 2;
                c = g1;
                aF();
                return this;
            }
        }

        public a g(g g1)
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

        public y.a g()
        {
            return z();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return z();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.s().a(com/umeng/message/proguard/j$w, com/umeng/message/proguard/j$w$a);
        }

        public a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = "";
            a = a & -3;
            d = "";
            a = a & -5;
            if (f == null)
            {
                e = com.umeng.message.proguard.j.y.h();
            } else
            {
                f.g();
            }
            a = a & -9;
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

        public String r()
        {
            Object obj = c;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                c = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g s()
        {
            Object obj = c;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                c = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public boolean t()
        {
            return (a & 4) == 4;
        }

        public String u()
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

        public g v()
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

        public boolean w()
        {
            return (a & 8) == 8;
        }

        public j.y x()
        {
            if (f == null)
            {
                return e;
            } else
            {
                return (j.y)f.c();
            }
        }

        public j.z y()
        {
            if (f != null)
            {
                return (j.z)f.f();
            } else
            {
                return e;
            }
        }

        public a z()
        {
            return L().a(C());
        }

        private a()
        {
            b = "";
            c = "";
            d = "";
            e = com.umeng.message.proguard.j.y.h();
            K();
        }

        private a(p.b b1)
        {
            super(b1);
            b = "";
            c = "";
            d = "";
            e = com.umeng.message.proguard.j.y.h();
            K();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }


    public static B a = new c() {

        public j.w c(h h1, n n1)
            throws s
        {
            return new j.w(h1, n1, null);
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
    private static final _cls1.c f;
    private static final long p = 0L;
    private final P g;
    private int h;
    private Object i;
    private Object j;
    private Object k;
    private _cls1.c l;
    private byte n;
    private int o;

    private void C()
    {
        i = "";
        j = "";
        k = "";
        l = h();
    }

    static int a(h h1, int i1)
    {
        h1.h = i1;
        return i1;
    }

    public static a a(h h1)
    {
        return z().a(h1);
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
        a1.l = a2;
        return a2;
    }

    static Object a(l l1, Object obj)
    {
        l1.i = obj;
        return obj;
    }

    public static i b(InputStream inputstream)
        throws IOException
    {
        return (i)a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static Object b(a a1)
    {
        return a1.i;
    }

    static Object b(i i1, Object obj)
    {
        i1.j = obj;
        return obj;
    }

    static Object c(j j1)
    {
        return j1.j;
    }

    static Object c(j j1, Object obj)
    {
        j1.k = obj;
        return obj;
    }

    static Object d(k k1)
    {
        return k1.k;
    }

    public static k h()
    {
        return f;
    }

    public static final f k()
    {
        return com.umeng.message.proguard.j.r();
    }

    public static a z()
    {
        return a.I();
    }

    public a A()
    {
        return z();
    }

    public a B()
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
        return B();
    }

    public B N()
    {
        return A();
    }

    public A O()
    {
        return B();
    }

    public B P()
    {
        return A();
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
        if ((h & 1) == 1)
        {
            i1.a(1, p());
        }
        if ((h & 2) == 2)
        {
            i1.a(2, s());
        }
        if ((h & 4) == 4)
        {
            i1.a(3, v());
        }
        if ((h & 8) == 8)
        {
            i1.c(4, l);
        }
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = n;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        if (w() && !x().a())
        {
            n = 0;
            return false;
        } else
        {
            n = 1;
            return true;
        }
    }

    protected n b(n n1)
    {
        return a(n1);
    }

    public final P b_()
    {
        return g;
    }

    public int d()
    {
        int i1 = o;
        if (i1 != -1)
        {
            return i1;
        }
        int j1 = 0;
        if ((h & 1) == 1)
        {
            j1 = 0 + com.umeng.message.proguard.i.c(1, p());
        }
        i1 = j1;
        if ((h & 2) == 2)
        {
            i1 = j1 + com.umeng.message.proguard.i.c(2, s());
        }
        j1 = i1;
        if ((h & 4) == 4)
        {
            j1 = i1 + com.umeng.message.proguard.i.c(3, v());
        }
        i1 = j1;
        if ((h & 8) == 8)
        {
            i1 = j1 + com.umeng.message.proguard.i.g(4, l);
        }
        i1 += b_().d();
        o = i1;
        return i1;
    }

    public o i()
    {
        return f;
    }

    protected f l()
    {
        return com.umeng.message.proguard.j.s().a(com/umeng/message/proguard/j$w, com/umeng/message/proguard/j$w$a);
    }

    public B m()
    {
        return a;
    }

    public boolean n()
    {
        return (h & 1) == 1;
    }

    public String o()
    {
        Object obj = i;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            i = s1;
        }
        return s1;
    }

    public g p()
    {
        Object obj = i;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            i = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean q()
    {
        return (h & 2) == 2;
    }

    public String r()
    {
        Object obj = j;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            j = s1;
        }
        return s1;
    }

    public g s()
    {
        Object obj = j;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            j = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean t()
    {
        return (h & 4) == 4;
    }

    public String u()
    {
        Object obj = k;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            k = s1;
        }
        return s1;
    }

    public g v()
    {
        Object obj = k;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            k = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean w()
    {
        return (h & 8) == 8;
    }

    public h x()
    {
        return l;
    }

    public l y()
    {
        return l;
    }

    static 
    {
        f = new <init>(true);
        f.C();
    }

    private a(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        boolean flag;
        n = -1;
        o = -1;
        C();
        _lcls1 = com.umeng.message.proguard.P.b();
        flag = false;
_L15:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = h1.a();
        i1;
        JVM INSTR lookupswitch 5: default 302
    //                   0: 308
    //                   10: 107
    //                   18: 128
    //                   26: 149
    //                   34: 170;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        if (!a(h1, _lcls1, n1, i1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        h = h | 1;
        i = h1.l();
        continue; /* Loop/switch isn't completed */
_L6:
        h = h | 2;
        j = h1.l();
        continue; /* Loop/switch isn't completed */
_L7:
        h = h | 4;
        k = h1.l();
        continue; /* Loop/switch isn't completed */
_L8:
        if ((h & 8) != 8) goto _L10; else goto _L9
_L9:
        a a1 = l.s();
_L13:
        l = (l)h1.a(a, n1);
        if (a1 == null) goto _L12; else goto _L11
_L11:
        a1.a(l);
        l = a1.t();
_L12:
        h = h | 8;
        continue; /* Loop/switch isn't completed */
        h1;
        throw h1.a(this);
        h1;
        g = _lcls1.b();
        ad();
        throw h1;
        h1;
        throw (new s(h1.getMessage())).a(this);
_L2:
        g = _lcls1.b();
        ad();
        return;
_L10:
        a1 = null;
          goto _L13
_L4:
        flag = true;
        if (true) goto _L15; else goto _L14
_L14:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        n = -1;
        o = -1;
        g = <init>1.b_();
    }

    b_(b_ b_1, b_ b_2)
    {
        this(b_1);
    }

    private <init>(boolean flag)
    {
        n = -1;
        o = -1;
        g = com.umeng.message.proguard.P.c();
    }
}
