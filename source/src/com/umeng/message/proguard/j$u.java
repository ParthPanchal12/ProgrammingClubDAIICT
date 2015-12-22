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
//            j, s, P, h, 
//            B, i, y, n, 
//            g, x, p, D, 
//            c

public static final class f extends f
    implements f
{
    public static final class a extends p.c
        implements j.v
    {

        private int a;
        private boolean b;
        private boolean c;
        private List d;
        private D e;

        static a F()
        {
            return H();
        }

        private void G()
        {
            if (p.m)
            {
                K();
            }
        }

        private static a H()
        {
            return new a();
        }

        private void I()
        {
            if ((a & 4) != 4)
            {
                d = new ArrayList(d);
                a = a | 4;
            }
        }

        private D K()
        {
            if (e == null)
            {
                List list = d;
                boolean flag;
                if ((a & 4) == 4)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                e = new D(list, flag, aE(), aD());
                d = null;
            }
            return e;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.v();
        }

        public p.c A()
        {
            return u();
        }

        public p.c B()
        {
            return m();
        }

        public a C()
        {
            if (e == null)
            {
                d = Collections.emptyList();
                a = a & -5;
                aF();
                return this;
            } else
            {
                e.e();
                return this;
            }
        }

        public j.G.a D()
        {
            return (j.G.a)K().b(com.umeng.message.proguard.j.G.h());
        }

        public List E()
        {
            return K().h();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.v();
        }

        public y Q()
        {
            return v();
        }

        public x R()
        {
            return v();
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

        public j.G a(int i1)
        {
            if (e == null)
            {
                return (j.G)d.get(i1);
            } else
            {
                return (j.G)e.a(i1);
            }
        }

        public a a(int i1, j.G.a a1)
        {
            if (e == null)
            {
                I();
                d.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                e.a(i1, a1.G());
                return this;
            }
        }

        public a a(int i1, j.G g1)
        {
            if (e == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    I();
                    d.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                e.a(i1, g1);
                return this;
            }
        }

        public a a(j.G.a a1)
        {
            if (e == null)
            {
                I();
                d.add(a1.G());
                aF();
                return this;
            } else
            {
                e.a(a1.G());
                return this;
            }
        }

        public a a(j.G g1)
        {
            if (e == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    I();
                    d.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                e.a(g1);
                return this;
            }
        }

        public a a(j.u u1)
        {
            D d1;
            d1 = null;
            if (u1 == j.u.h())
            {
                return this;
            }
            if (u1.n())
            {
                a(u1.o());
            }
            if (u1.p())
            {
                b(u1.q());
            }
            if (e != null) goto _L2; else goto _L1
_L1:
            if (!j.u.b(u1).isEmpty())
            {
                if (d.isEmpty())
                {
                    d = j.u.b(u1);
                    a = a & -5;
                } else
                {
                    I();
                    d.addAll(j.u.b(u1));
                }
                aF();
            }
_L4:
            a(((p.d) (u1)));
            d(u1.b_());
            return this;
_L2:
            if (!j.u.b(u1).isEmpty())
            {
                if (e.d())
                {
                    e.b();
                    e = null;
                    d = j.u.b(u1);
                    a = a & -5;
                    if (p.m)
                    {
                        d1 = K();
                    }
                    e = d1;
                } else
                {
                    e.a(j.u.b(u1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public a a(Iterable iterable)
        {
            if (e == null)
            {
                I();
                com.umeng.message.proguard.p.c.a(iterable, d);
                aF();
                return this;
            } else
            {
                e.a(iterable);
                return this;
            }
        }

        public a a(boolean flag)
        {
            a = a | 1;
            b = flag;
            aF();
            return this;
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= t()) goto _L2; else goto _L1
_L1:
            if (a(i1).a()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i1++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (!af()) goto _L3; else goto _L5
_L5:
            return true;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return u();
        }

        public x aj()
        {
            return x();
        }

        public x ak()
        {
            return w();
        }

        public y al()
        {
            return x();
        }

        public y am()
        {
            return w();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public j.H b(int i1)
        {
            if (e == null)
            {
                return (j.H)d.get(i1);
            } else
            {
                return (j.H)e.c(i1);
            }
        }

        public a b(int i1, j.G.a a1)
        {
            if (e == null)
            {
                I();
                d.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                e.b(i1, a1.G());
                return this;
            }
        }

        public a b(int i1, j.G g1)
        {
            if (e == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    I();
                    d.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                e.b(i1, g1);
                return this;
            }
        }

        public a b(boolean flag)
        {
            a = a | 2;
            c = flag;
            aF();
            return this;
        }

        public a c(int i1)
        {
            if (e == null)
            {
                I();
                d.remove(i1);
                aF();
                return this;
            } else
            {
                e.d(i1);
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
            return u();
        }

        public a.a d()
        {
            return u();
        }

        public j.G.a d(int i1)
        {
            return (j.G.a)K().b(i1);
        }

        public a d(x x1)
        {
            if (x1 instanceof j.u)
            {
                return a((j.u)x1);
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

        public j.G.a e(int i1)
        {
            return (j.G.a)K().c(i1, com.umeng.message.proguard.j.G.h());
        }

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (j.u)j.u.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.u)n1.a();
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
            return u();
        }

        public y.a g()
        {
            return u();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return u();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.w().a(com/umeng/message/proguard/j$u, com/umeng/message/proguard/j$u$a);
        }

        public a m()
        {
            super.B();
            b = false;
            a = a & -2;
            c = false;
            a = a & -3;
            if (e == null)
            {
                d = Collections.emptyList();
                a = a & -5;
                return this;
            } else
            {
                e.e();
                return this;
            }
        }

        public boolean n()
        {
            return (a & 1) == 1;
        }

        public boolean o()
        {
            return b;
        }

        public boolean p()
        {
            return (a & 2) == 2;
        }

        public boolean q()
        {
            return c;
        }

        public List r()
        {
            if (e == null)
            {
                return Collections.unmodifiableList(d);
            } else
            {
                return e.g();
            }
        }

        public List s()
        {
            if (e != null)
            {
                return e.i();
            } else
            {
                return Collections.unmodifiableList(d);
            }
        }

        public int t()
        {
            if (e == null)
            {
                return d.size();
            } else
            {
                return e.c();
            }
        }

        public a u()
        {
            return H().a(x());
        }

        public j.u v()
        {
            return j.u.h();
        }

        public j.u w()
        {
            j.u u1 = x();
            if (!u1.a())
            {
                throw b(u1);
            } else
            {
                return u1;
            }
        }

        public j.u x()
        {
            int i1 = 1;
            j.u u1 = new j.u(this, null);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            j.u.a(u1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            j.u.b(u1, c);
            if (e == null)
            {
                if ((a & 4) == 4)
                {
                    d = Collections.unmodifiableList(d);
                    a = a & -5;
                }
                j.u.a(u1, d);
            } else
            {
                j.u.a(u1, e.f());
            }
            j.u.a(u1, j1);
            aB();
            return u1;
        }

        public a y()
        {
            a = a & -2;
            b = false;
            aF();
            return this;
        }

        public a z()
        {
            a = a & -3;
            c = false;
            aF();
            return this;
        }

        private a()
        {
            d = Collections.emptyList();
            G();
        }

        private a(p.b b1)
        {
            super(b1);
            d = Collections.emptyList();
            G();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }


    public static B a = new c() {

        public j.u c(h h1, n n1)
            throws s
        {
            return new j.u(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 999;
    private static final _cls1.c e;
    private static final long n = 0L;
    private final P f;
    private int g;
    private boolean h;
    private boolean i;
    private List j;
    private byte k;
    private int l;

    static int a(a.aF af, int i1)
    {
        af.g = i1;
        return i1;
    }

    public static a a(g g1)
    {
        return u().a(g1);
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

    static List a(a a1, List list)
    {
        a1.j = list;
        return list;
    }

    static boolean a(j j1, boolean flag)
    {
        j1.h = flag;
        return flag;
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

    static List b(a a1)
    {
        return a1.j;
    }

    static boolean b(j j1, boolean flag)
    {
        j1.i = flag;
        return flag;
    }

    public static i h()
    {
        return e;
    }

    public static final e k()
    {
        return com.umeng.message.proguard.j.v();
    }

    public static a u()
    {
        return a.F();
    }

    private void x()
    {
        h = false;
        i = false;
        j = Collections.emptyList();
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public I M()
    {
        return w();
    }

    public w N()
    {
        return v();
    }

    public v O()
    {
        return w();
    }

    public w P()
    {
        return v();
    }

    public y Q()
    {
        return i();
    }

    public x R()
    {
        return i();
    }

    public i a(int i1)
    {
        return (i)j.get(i1);
    }

    protected a a(j j1)
    {
        return new a(j1, null);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        a a1 = X();
        if ((g & 1) == 1)
        {
            i1.a(1, h);
        }
        if ((g & 2) == 2)
        {
            i1.a(2, i);
        }
        for (int j1 = 0; j1 < j.size(); j1++)
        {
            i1.c(999, (y)j.get(j1));
        }

        a1.a(0x20000000, i1);
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = k;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        for (int i1 = 0; i1 < t(); i1++)
        {
            if (!a(i1).a())
            {
                k = 0;
                return false;
            }
        }

        if (!W())
        {
            k = 0;
            return false;
        } else
        {
            k = 1;
            return true;
        }
    }

    public k b(int i1)
    {
        return (k)j.get(i1);
    }

    protected j b(j j1)
    {
        return a(j1);
    }

    public final P b_()
    {
        return f;
    }

    public int d()
    {
        boolean flag = false;
        int i1 = l;
        if (i1 != -1)
        {
            return i1;
        }
        int j1;
        if ((g & 1) == 1)
        {
            i1 = com.umeng.message.proguard.i.b(1, h) + 0;
        } else
        {
            i1 = 0;
        }
        j1 = i1;
        if ((g & 2) == 2)
        {
            j1 = i1 + com.umeng.message.proguard.i.b(2, i);
        }
        i1 = j1;
        for (int k1 = ((flag) ? 1 : 0); k1 < j.size();)
        {
            int l1 = com.umeng.message.proguard.i.g(999, (y)j.get(k1));
            k1++;
            i1 = l1 + i1;
        }

        i1 = Z() + i1 + b_().d();
        l = i1;
        return i1;
    }

    public l i()
    {
        return e;
    }

    protected e l()
    {
        return com.umeng.message.proguard.j.w().a(com/umeng/message/proguard/j$u, com/umeng/message/proguard/j$u$a);
    }

    public B m()
    {
        return a;
    }

    public boolean n()
    {
        return (g & 1) == 1;
    }

    public boolean o()
    {
        return h;
    }

    public boolean p()
    {
        return (g & 2) == 2;
    }

    public boolean q()
    {
        return i;
    }

    public List r()
    {
        return j;
    }

    public List s()
    {
        return j;
    }

    public int t()
    {
        return j.size();
    }

    public a v()
    {
        return u();
    }

    public a w()
    {
        return a(this);
    }

    static 
    {
        e = new <init>(true);
        e.x();
    }

    private _cls1(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        int i1;
        boolean flag;
        flag = false;
        super();
        k = -1;
        l = -1;
        x();
        _lcls1 = com.umeng.message.proguard.P.b();
        i1 = 0;
_L11:
        if (flag) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        int i2;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        int j1 = h1.a();
        j1;
        JVM INSTR lookupswitch 4: default 392
    //                   0: 395
    //                   8: 126
    //                   16: 216
    //                   7994: 282;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        if (!a(h1, _lcls1, n1, j1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        g = g | 1;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        h = h1.j();
        continue; /* Loop/switch isn't completed */
        h1;
        k1 = l1;
        throw h1.a(this);
        h1;
        if ((k1 & 4) == 4)
        {
            j = Collections.unmodifiableList(j);
        }
        f = _lcls1.b();
        ad();
        throw h1;
_L6:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        g = g | 2;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        i = h1.j();
        continue; /* Loop/switch isn't completed */
        h1;
        k1 = i2;
        throw (new s(h1.getMessage())).a(this);
_L7:
        j1 = i1;
        if ((i1 & 4) == 4) goto _L9; else goto _L8
_L8:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        j = new ArrayList();
        j1 = i1 | 4;
_L9:
        l1 = j1;
        k1 = j1;
        i2 = j1;
        j.add(h1.a(a, n1));
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L2:
        if ((i1 & 4) == 4)
        {
            j = Collections.unmodifiableList(j);
        }
        f = _lcls1.b();
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
