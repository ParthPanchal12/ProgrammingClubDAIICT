// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            p, j, s, P, 
//            h, B, i, g, 
//            n, y, x, c

public static final class g extends p
    implements g
{
    public static final class a extends p.a
        implements j.E.c
    {

        private int a;
        private List b;
        private List c;
        private Object d;
        private Object e;

        static a F()
        {
            return H();
        }

        private void G()
        {
            if (!p.m);
        }

        private static a H()
        {
            return new a();
        }

        private void I()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private void K()
        {
            if ((a & 2) != 2)
            {
                c = new ArrayList(c);
                a = a | 2;
            }
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.N();
        }

        public j.E.b A()
        {
            int i1 = 1;
            j.E.b b1 = new j.E.b(this, null);
            int k1 = a;
            if ((a & 1) == 1)
            {
                b = Collections.unmodifiableList(b);
                a = a & -2;
            }
            j.E.b.a(b1, b);
            if ((a & 2) == 2)
            {
                c = Collections.unmodifiableList(c);
                a = a & -3;
            }
            j.E.b.b(b1, c);
            int j1;
            if ((k1 & 4) != 4)
            {
                i1 = 0;
            }
            j.E.b.a(b1, d);
            j1 = i1;
            if ((k1 & 8) == 8)
            {
                j1 = i1 | 2;
            }
            j.E.b.b(b1, e);
            j.E.b.a(b1, j1);
            aB();
            return b1;
        }

        public a B()
        {
            b = Collections.emptyList();
            a = a & -2;
            aF();
            return this;
        }

        public a C()
        {
            c = Collections.emptyList();
            a = a & -3;
            aF();
            return this;
        }

        public a D()
        {
            a = a & -5;
            d = j.E.b.h().s();
            aF();
            return this;
        }

        public a E()
        {
            a = a & -9;
            e = j.E.b.h().v();
            aF();
            return this;
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.N();
        }

        public y Q()
        {
            return y();
        }

        public x R()
        {
            return y();
        }

        public int a(int i1)
        {
            return ((Integer)b.get(i1)).intValue();
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

        public a a(int i1, int j1)
        {
            I();
            b.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public a a(j.E.b b1)
        {
            if (b1 == j.E.b.h())
            {
                return this;
            }
            if (!j.E.b.b(b1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = j.E.b.b(b1);
                    a = a & -2;
                } else
                {
                    I();
                    b.addAll(j.E.b.b(b1));
                }
                aF();
            }
            if (!j.E.b.c(b1).isEmpty())
            {
                if (c.isEmpty())
                {
                    c = j.E.b.c(b1);
                    a = a & -3;
                } else
                {
                    K();
                    c.addAll(j.E.b.c(b1));
                }
                aF();
            }
            if (b1.r())
            {
                a = a | 4;
                d = j.E.b.d(b1);
                aF();
            }
            if (b1.u())
            {
                a = a | 8;
                e = j.E.b.e(b1);
                aF();
            }
            d(b1.b_());
            return this;
        }

        public a a(Iterable iterable)
        {
            I();
            com.umeng.message.proguard.p.a.a(iterable, b);
            aF();
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
            return x();
        }

        public x aj()
        {
            return A();
        }

        public x ak()
        {
            return z();
        }

        public y al()
        {
            return A();
        }

        public y am()
        {
            return z();
        }

        public int b(int i1)
        {
            return ((Integer)c.get(i1)).intValue();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a b(int i1, int j1)
        {
            K();
            c.set(i1, Integer.valueOf(j1));
            aF();
            return this;
        }

        public a b(Iterable iterable)
        {
            K();
            com.umeng.message.proguard.p.a.a(iterable, c);
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
                a = a | 8;
                e = s1;
                aF();
                return this;
            }
        }

        public a c(int i1)
        {
            I();
            b.add(Integer.valueOf(i1));
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
            return x();
        }

        public a.a d()
        {
            return x();
        }

        public a d(int i1)
        {
            K();
            c.add(Integer.valueOf(i1));
            aF();
            return this;
        }

        public a d(x x1)
        {
            if (x1 instanceof j.E.b)
            {
                return a((j.E.b)x1);
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
            h1 = (j.E.b)j.E.b.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.E.b)n1.a();
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
            return x();
        }

        public a f(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 8;
                e = g1;
                aF();
                return this;
            }
        }

        public y.a g()
        {
            return x();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return x();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.O().a(com/umeng/message/proguard/j$E$b, com/umeng/message/proguard/j$E$b$a);
        }

        public a m()
        {
            super.ah();
            b = Collections.emptyList();
            a = a & -2;
            c = Collections.emptyList();
            a = a & -3;
            d = "";
            a = a & -5;
            e = "";
            a = a & -9;
            return this;
        }

        public List n()
        {
            return Collections.unmodifiableList(b);
        }

        public int o()
        {
            return b.size();
        }

        public List p()
        {
            return Collections.unmodifiableList(c);
        }

        public int q()
        {
            return c.size();
        }

        public boolean r()
        {
            return (a & 4) == 4;
        }

        public String s()
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

        public g t()
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

        public boolean u()
        {
            return (a & 8) == 8;
        }

        public String v()
        {
            Object obj = e;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                e = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public g w()
        {
            Object obj = e;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                e = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public a x()
        {
            return H().a(A());
        }

        public j.E.b y()
        {
            return j.E.b.h();
        }

        public j.E.b z()
        {
            j.E.b b1 = A();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        private a()
        {
            b = Collections.emptyList();
            c = Collections.emptyList();
            d = "";
            e = "";
            G();
        }

        private a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            c = Collections.emptyList();
            d = "";
            e = "";
            G();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }


    public static B a = new c() {

        public j.E.b c(h h1, n n1)
            throws s
        {
            return new j.E.b(h1, n1, null);
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
    private static final long r = 0L;
    private final P g;
    private int h;
    private List i;
    private int j;
    private List k;
    private int l;
    private Object n;
    private Object o;
    private byte p;
    private int q;

    private void A()
    {
        i = Collections.emptyList();
        k = Collections.emptyList();
        n = "";
        o = "";
    }

    static int a(o o1, int i1)
    {
        o1.h = i1;
        return i1;
    }

    public static a a(h h1)
    {
        return x().a(h1);
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
        a1.n = obj;
        return obj;
    }

    static List a(n n1, List list)
    {
        n1.i = list;
        return list;
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

    static Object b(a a1, Object obj)
    {
        a1.o = obj;
        return obj;
    }

    static List b(o o1)
    {
        return o1.i;
    }

    static List b(i i1, List list)
    {
        i1.k = list;
        return list;
    }

    static List c(k k1)
    {
        return k1.k;
    }

    static Object d(k k1)
    {
        return k1.n;
    }

    static Object e(n n1)
    {
        return n1.o;
    }

    public static o h()
    {
        return f;
    }

    public static final f k()
    {
        return com.umeng.message.proguard.j.N();
    }

    public static a x()
    {
        return a.F();
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public a.F M()
    {
        return z();
    }

    public z N()
    {
        return y();
    }

    public y O()
    {
        return z();
    }

    public z P()
    {
        return y();
    }

    public y Q()
    {
        return i();
    }

    public x R()
    {
        return i();
    }

    public int a(int i1)
    {
        return ((Integer)i.get(i1)).intValue();
    }

    protected a a(i i1)
    {
        return new a(i1, null);
    }

    public void a(i i1)
        throws IOException
    {
        boolean flag = false;
        d();
        if (n().size() > 0)
        {
            i1.p(10);
            i1.p(j);
        }
        for (int j1 = 0; j1 < i.size(); j1++)
        {
            i1.b(((Integer)i.get(j1)).intValue());
        }

        int k1 = ((flag) ? 1 : 0);
        if (p().size() > 0)
        {
            i1.p(18);
            i1.p(l);
            k1 = ((flag) ? 1 : 0);
        }
        for (; k1 < k.size(); k1++)
        {
            i1.b(((Integer)k.get(k1)).intValue());
        }

        if ((h & 1) == 1)
        {
            i1.a(3, t());
        }
        if ((h & 2) == 2)
        {
            i1.a(4, w());
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

    public int b(int i1)
    {
        return ((Integer)k.get(i1)).intValue();
    }

    protected k b(k k1)
    {
        return a(k1);
    }

    public final P b_()
    {
        return g;
    }

    public int d()
    {
        int k1 = 0;
        int i1 = q;
        if (i1 != -1)
        {
            return i1;
        }
        i1 = 0;
        int j1 = 0;
        for (; i1 < i.size(); i1++)
        {
            j1 += com.umeng.message.proguard.i.h(((Integer)i.get(i1)).intValue());
        }

        i1 = 0 + j1;
        if (!n().isEmpty())
        {
            i1 = i1 + 1 + com.umeng.message.proguard.i.h(j1);
        }
        j = j1;
        int l1;
        for (j1 = 0; k1 < k.size(); j1 = l1 + j1)
        {
            l1 = com.umeng.message.proguard.i.h(((Integer)k.get(k1)).intValue());
            k1++;
        }

        k1 = i1 + j1;
        i1 = k1;
        if (!p().isEmpty())
        {
            i1 = k1 + 1 + com.umeng.message.proguard.i.h(j1);
        }
        l = j1;
        j1 = i1;
        if ((h & 1) == 1)
        {
            j1 = i1 + com.umeng.message.proguard.i.c(3, t());
        }
        i1 = j1;
        if ((h & 2) == 2)
        {
            i1 = j1 + com.umeng.message.proguard.i.c(4, w());
        }
        i1 += b_().d();
        q = i1;
        return i1;
    }

    public q i()
    {
        return f;
    }

    protected f l()
    {
        return com.umeng.message.proguard.j.O().f(com/umeng/message/proguard/j$E$b, com/umeng/message/proguard/j$E$b$a);
    }

    public B m()
    {
        return a;
    }

    public List n()
    {
        return i;
    }

    public int o()
    {
        return i.size();
    }

    public List p()
    {
        return k;
    }

    public int q()
    {
        return k.size();
    }

    public boolean r()
    {
        return (h & 1) == 1;
    }

    public String s()
    {
        Object obj = n;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            n = s1;
        }
        return s1;
    }

    public g t()
    {
        Object obj = n;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            n = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean u()
    {
        return (h & 2) == 2;
    }

    public String v()
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

    public g w()
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

    public a y()
    {
        return x();
    }

    public a z()
    {
        return a(this);
    }

    static 
    {
        f = new <init>(true);
        f.A();
    }

    private _cls1(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        int i1;
        boolean flag;
        flag = false;
        super();
        j = -1;
        l = -1;
        p = -1;
        q = -1;
        A();
        _lcls1 = com.umeng.message.proguard.P.b();
        i1 = 0;
_L21:
        if (flag) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        int l1;
        k1 = i1;
        j1 = i1;
        l1 = i1;
        int i2 = h1.a();
        i2;
        JVM INSTR lookupswitch 7: default 862
    //                   0: 865
    //                   8: 158
    //                   10: 299
    //                   16: 482
    //                   18: 559
    //                   26: 721
    //                   34: 766;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
        k1 = i1;
        j1 = i1;
        l1 = i1;
        if (!a(h1, _lcls1, n1, i2))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i2 = i1;
        if ((i1 & 1) == 1) goto _L12; else goto _L11
_L11:
        k1 = i1;
        j1 = i1;
        l1 = i1;
        i = new ArrayList();
        i2 = i1 | 1;
_L12:
        k1 = i2;
        j1 = i2;
        l1 = i2;
        i.add(Integer.valueOf(h1.g()));
        i1 = i2;
        continue; /* Loop/switch isn't completed */
        h1;
        j1 = k1;
        throw h1.a(this);
        h1;
        if ((j1 & 1) == 1)
        {
            i = Collections.unmodifiableList(i);
        }
        if ((j1 & 2) == 2)
        {
            k = Collections.unmodifiableList(k);
        }
        g = _lcls1.g();
        ad();
        throw h1;
_L6:
        k1 = i1;
        j1 = i1;
        l1 = i1;
        int j2 = h1.f(h1.s());
        i2 = i1;
        if ((i1 & 1) == 1)
        {
            break MISSING_BLOCK_LABEL_385;
        }
        k1 = i1;
        j1 = i1;
        i2 = i1;
        l1 = i1;
        if (h1.x() <= 0)
        {
            break MISSING_BLOCK_LABEL_385;
        }
        k1 = i1;
        j1 = i1;
        l1 = i1;
        i = new ArrayList();
        i2 = i1 | 1;
_L15:
        k1 = i2;
        j1 = i2;
        l1 = i2;
        if (h1.x() <= 0) goto _L14; else goto _L13
_L13:
        k1 = i2;
        j1 = i2;
        l1 = i2;
        i.add(Integer.valueOf(h1.g()));
          goto _L15
        h1;
        j1 = l1;
        throw (new s(h1.getMessage())).a(this);
_L14:
        k1 = i2;
        j1 = i2;
        l1 = i2;
        h1.g(j2);
        i1 = i2;
        continue; /* Loop/switch isn't completed */
_L7:
        i2 = i1;
        if ((i1 & 2) == 2) goto _L17; else goto _L16
_L16:
        k1 = i1;
        j1 = i1;
        l1 = i1;
        k = new ArrayList();
        i2 = i1 | 2;
_L17:
        k1 = i2;
        j1 = i2;
        l1 = i2;
        k.add(Integer.valueOf(h1.g()));
        i1 = i2;
        continue; /* Loop/switch isn't completed */
_L8:
        k1 = i1;
        j1 = i1;
        l1 = i1;
        j2 = h1.f(h1.s());
        i2 = i1;
        if ((i1 & 2) == 2)
        {
            break MISSING_BLOCK_LABEL_645;
        }
        k1 = i1;
        j1 = i1;
        l1 = i1;
        i2 = i1;
        if (h1.x() <= 0)
        {
            break MISSING_BLOCK_LABEL_645;
        }
        k1 = i1;
        j1 = i1;
        l1 = i1;
        k = new ArrayList();
        i2 = i1 | 2;
_L19:
        k1 = i2;
        j1 = i2;
        l1 = i2;
        if (h1.x() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k1 = i2;
        j1 = i2;
        l1 = i2;
        k.add(Integer.valueOf(h1.g()));
        if (true) goto _L19; else goto _L18
_L18:
        k1 = i2;
        j1 = i2;
        l1 = i2;
        h1.g(j2);
        i1 = i2;
        continue; /* Loop/switch isn't completed */
_L9:
        k1 = i1;
        j1 = i1;
        l1 = i1;
        h = h | 1;
        k1 = i1;
        j1 = i1;
        l1 = i1;
        n = h1.l();
        continue; /* Loop/switch isn't completed */
_L10:
        k1 = i1;
        j1 = i1;
        l1 = i1;
        h = h | 2;
        k1 = i1;
        j1 = i1;
        l1 = i1;
        o = h1.l();
        continue; /* Loop/switch isn't completed */
_L2:
        if ((i1 & 1) == 1)
        {
            i = Collections.unmodifiableList(i);
        }
        if ((i1 & 2) == 2)
        {
            k = Collections.unmodifiableList(k);
        }
        g = _lcls1.g();
        ad();
        return;
_L4:
        flag = true;
        if (true) goto _L21; else goto _L20
_L20:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        j = -1;
        l = -1;
        p = -1;
        q = -1;
        g = <init>1.();
    }

    ( ,  1)
    {
        this();
    }

    private <init>(boolean flag)
    {
        j = -1;
        l = -1;
        p = -1;
        q = -1;
        g = com.umeng.message.proguard.P.c();
    }
}
