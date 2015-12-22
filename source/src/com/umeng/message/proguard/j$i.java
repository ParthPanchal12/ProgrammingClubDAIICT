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
//            B, y, i, n, 
//            g, x, D, p, 
//            c

public static final class d extends d
    implements d
{
    public static final class a extends p.c
        implements j.j
    {

        private int a;
        private List b;
        private D c;

        private void C()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private D D()
        {
            boolean flag = true;
            if (c == null)
            {
                List list = b;
                if ((a & 1) != 1)
                {
                    flag = false;
                }
                c = new D(list, flag, aE(), aD());
                b = null;
            }
            return c;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.B();
        }

        static a x()
        {
            return z();
        }

        private void y()
        {
            if (p.m)
            {
                D();
            }
        }

        private static a z()
        {
            return new a();
        }

        public p.c A()
        {
            return q();
        }

        public p.c B()
        {
            return m();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.B();
        }

        public y Q()
        {
            return r();
        }

        public x R()
        {
            return r();
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
            if (c == null)
            {
                return (j.G)b.get(i1);
            } else
            {
                return (j.G)c.a(i1);
            }
        }

        public a a(int i1, j.G.a a1)
        {
            if (c == null)
            {
                C();
                b.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                c.a(i1, a1.G());
                return this;
            }
        }

        public a a(int i1, j.G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(i1, g1);
                return this;
            }
        }

        public a a(j.G.a a1)
        {
            if (c == null)
            {
                C();
                b.add(a1.G());
                aF();
                return this;
            } else
            {
                c.a(a1.G());
                return this;
            }
        }

        public a a(j.G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(g1);
                return this;
            }
        }

        public a a(j.i i1)
        {
            D d1;
            d1 = null;
            if (i1 == j.i.h())
            {
                return this;
            }
            if (c != null) goto _L2; else goto _L1
_L1:
            if (!j.i.b(i1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = j.i.b(i1);
                    a = a & -2;
                } else
                {
                    C();
                    b.addAll(j.i.b(i1));
                }
                aF();
            }
_L4:
            a(((p.d) (i1)));
            d(i1.b_());
            return this;
_L2:
            if (!j.i.b(i1).isEmpty())
            {
                if (c.d())
                {
                    c.b();
                    c = null;
                    b = j.i.b(i1);
                    a = a & -2;
                    if (p.m)
                    {
                        d1 = D();
                    }
                    c = d1;
                } else
                {
                    c.a(j.i.b(i1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public a a(Iterable iterable)
        {
            if (c == null)
            {
                C();
                com.umeng.message.proguard.p.c.a(iterable, b);
                aF();
                return this;
            } else
            {
                c.a(iterable);
                return this;
            }
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= p()) goto _L2; else goto _L1
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
            return q();
        }

        public x aj()
        {
            return t();
        }

        public x ak()
        {
            return s();
        }

        public y al()
        {
            return t();
        }

        public y am()
        {
            return s();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public j.H b(int i1)
        {
            if (c == null)
            {
                return (j.H)b.get(i1);
            } else
            {
                return (j.H)c.c(i1);
            }
        }

        public a b(int i1, j.G.a a1)
        {
            if (c == null)
            {
                C();
                b.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                c.b(i1, a1.G());
                return this;
            }
        }

        public a b(int i1, j.G g1)
        {
            if (c == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    C();
                    b.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                c.b(i1, g1);
                return this;
            }
        }

        public a c(int i1)
        {
            if (c == null)
            {
                C();
                b.remove(i1);
                aF();
                return this;
            } else
            {
                c.d(i1);
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
            return q();
        }

        public a.a d()
        {
            return q();
        }

        public j.G.a d(int i1)
        {
            return (j.G.a)D().b(i1);
        }

        public a d(x x1)
        {
            if (x1 instanceof j.i)
            {
                return a((j.i)x1);
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
            return (j.G.a)D().c(i1, com.umeng.message.proguard.j.G.h());
        }

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (j.i)j.i.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.i)n1.a();
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
            return q();
        }

        public y.a g()
        {
            return q();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return q();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.C().a(com/umeng/message/proguard/j$i, com/umeng/message/proguard/j$i$a);
        }

        public a m()
        {
            super.B();
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public List n()
        {
            if (c == null)
            {
                return Collections.unmodifiableList(b);
            } else
            {
                return c.g();
            }
        }

        public List o()
        {
            if (c != null)
            {
                return c.i();
            } else
            {
                return Collections.unmodifiableList(b);
            }
        }

        public int p()
        {
            if (c == null)
            {
                return b.size();
            } else
            {
                return c.c();
            }
        }

        public a q()
        {
            return z().a(t());
        }

        public j.i r()
        {
            return j.i.h();
        }

        public j.i s()
        {
            j.i i1 = t();
            if (!i1.a())
            {
                throw b(i1);
            } else
            {
                return i1;
            }
        }

        public j.i t()
        {
            j.i i1 = new j.i(this, null);
            int j1 = a;
            if (c == null)
            {
                if ((a & 1) == 1)
                {
                    b = Collections.unmodifiableList(b);
                    a = a & -2;
                }
                j.i.a(i1, b);
            } else
            {
                j.i.a(i1, c.f());
            }
            aB();
            return i1;
        }

        public a u()
        {
            if (c == null)
            {
                b = Collections.emptyList();
                a = a & -2;
                aF();
                return this;
            } else
            {
                c.e();
                return this;
            }
        }

        public j.G.a v()
        {
            return (j.G.a)D().b(com.umeng.message.proguard.j.G.h());
        }

        public List w()
        {
            return D().h();
        }

        private a()
        {
            b = Collections.emptyList();
            y();
        }

        private a(p.b b1)
        {
            super(b1);
            b = Collections.emptyList();
            y();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }


    public static B a = new c() {

        public j.i c(h h1, n n1)
            throws s
        {
            return new j.i(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 999;
    private static final _cls1.c c;
    private static final long h = 0L;
    private final P d;
    private List e;
    private byte f;
    private int g;

    public static a a(a.D d1)
    {
        return q().a(d1);
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
        a1.e = list;
        return list;
    }

    public static e b(InputStream inputstream)
        throws IOException
    {
        return (e)a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static List b(a a1)
    {
        return a1.e;
    }

    public static e h()
    {
        return c;
    }

    public static final c k()
    {
        return j.B();
    }

    public static a q()
    {
        return a.x();
    }

    private void t()
    {
        e = Collections.emptyList();
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public I M()
    {
        return s();
    }

    public s N()
    {
        return r();
    }

    public r O()
    {
        return s();
    }

    public s P()
    {
        return r();
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
        return (i)e.get(i1);
    }

    protected a a(e e1)
    {
        return new a(e1, null);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        a a1 = X();
        for (int j1 = 0; j1 < e.size(); j1++)
        {
            i1.c(999, (y)e.get(j1));
        }

        a1.a(0x20000000, i1);
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = f;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        for (int i1 = 0; i1 < p(); i1++)
        {
            if (!a(i1).a())
            {
                f = 0;
                return false;
            }
        }

        if (!W())
        {
            f = 0;
            return false;
        } else
        {
            f = 1;
            return true;
        }
    }

    public f b(int i1)
    {
        return (f)e.get(i1);
    }

    protected e b(e e1)
    {
        return a(e1);
    }

    public final P b_()
    {
        return d;
    }

    public int d()
    {
        int i1 = g;
        if (i1 != -1)
        {
            return i1;
        }
        i1 = 0;
        int j1 = 0;
        for (; i1 < e.size(); i1++)
        {
            j1 += com.umeng.message.proguard.i.g(999, (y)e.get(i1));
        }

        i1 = Z() + j1 + b_().d();
        g = i1;
        return i1;
    }

    public g i()
    {
        return c;
    }

    protected c l()
    {
        return j.C().a(com/umeng/message/proguard/j$i, com/umeng/message/proguard/j$i$a);
    }

    public B m()
    {
        return a;
    }

    public List n()
    {
        return e;
    }

    public List o()
    {
        return e;
    }

    public int p()
    {
        return e.size();
    }

    public a r()
    {
        return q();
    }

    public a s()
    {
        return a(this);
    }

    static 
    {
        c = new <init>(true);
        c.t();
    }

    private _cls1(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        boolean flag;
        boolean flag2;
        flag2 = false;
        super();
        f = -1;
        g = -1;
        t();
        _lcls1 = com.umeng.message.proguard.P.b();
        flag = false;
_L9:
        if (flag2) goto _L2; else goto _L1
_L1:
        boolean flag1;
        boolean flag3;
        boolean flag4;
        flag3 = flag;
        flag1 = flag;
        flag4 = flag;
        int i1 = h1.a();
        i1;
        JVM INSTR lookupswitch 2: default 286
    //                   0: 289
    //                   7994: 110;
           goto _L3 _L4 _L5
_L3:
        flag3 = flag;
        flag1 = flag;
        flag4 = flag;
        if (!a(h1, _lcls1, n1, i1))
        {
            flag2 = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = ((flag) ? 1 : 0);
        if ((flag & true)) goto _L7; else goto _L6
_L6:
        flag3 = flag;
        flag1 = flag;
        flag4 = flag;
        e = new ArrayList();
        i1 = flag | true;
_L7:
        flag3 = i1;
        flag1 = i1;
        flag4 = i1;
        e.add(h1.a(a, n1));
        flag = i1;
        continue; /* Loop/switch isn't completed */
        h1;
        flag1 = flag3;
        throw h1.a(this);
        h1;
        if ((flag1 & true))
        {
            e = Collections.unmodifiableList(e);
        }
        d = _lcls1.b();
        ad();
        throw h1;
        h1;
        flag1 = flag4;
        throw (new s(h1.getMessage())).a(this);
_L2:
        if ((flag & true))
        {
            e = Collections.unmodifiableList(e);
        }
        d = _lcls1.b();
        ad();
        return;
_L4:
        flag2 = true;
        if (true) goto _L9; else goto _L8
_L8:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        f = -1;
        g = -1;
        d = <init>1.b_();
    }

    b_(b_ b_1, b_ b_2)
    {
        this(b_1);
    }

    private <init>(boolean flag)
    {
        f = -1;
        g = -1;
        d = com.umeng.message.proguard.P.c();
    }
}
