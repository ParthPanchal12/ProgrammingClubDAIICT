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
//            h, B, y, i, 
//            n, g, x, D, 
//            c

public static final class d extends p
    implements d
{
    public static final class a extends p.a
        implements j.r
    {

        private int a;
        private List b;
        private D c;

        private void A()
        {
            if ((a & 1) != 1)
            {
                b = new ArrayList(b);
                a = a | 1;
            }
        }

        private D B()
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
            return com.umeng.message.proguard.j.b();
        }

        static a x()
        {
            return z();
        }

        private void y()
        {
            if (p.m)
            {
                B();
            }
        }

        private static a z()
        {
            return new a();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.b();
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

        public j.o a(int i1)
        {
            if (c == null)
            {
                return (j.o)b.get(i1);
            } else
            {
                return (j.o)c.a(i1);
            }
        }

        public a a(int i1, j.o.a a1)
        {
            if (c == null)
            {
                A();
                b.set(i1, a1.N());
                aF();
                return this;
            } else
            {
                c.a(i1, a1.N());
                return this;
            }
        }

        public a a(int i1, j.o o1)
        {
            if (c == null)
            {
                if (o1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    A();
                    b.set(i1, o1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(i1, o1);
                return this;
            }
        }

        public a a(j.o.a a1)
        {
            if (c == null)
            {
                A();
                b.add(a1.N());
                aF();
                return this;
            } else
            {
                c.a(a1.N());
                return this;
            }
        }

        public a a(j.o o1)
        {
            if (c == null)
            {
                if (o1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    A();
                    b.add(o1);
                    aF();
                    return this;
                }
            } else
            {
                c.a(o1);
                return this;
            }
        }

        public a a(j.q q1)
        {
            D d1;
            d1 = null;
            if (q1 == j.q.h())
            {
                return this;
            }
            if (c != null) goto _L2; else goto _L1
_L1:
            if (!j.q.b(q1).isEmpty())
            {
                if (b.isEmpty())
                {
                    b = j.q.b(q1);
                    a = a & -2;
                } else
                {
                    A();
                    b.addAll(j.q.b(q1));
                }
                aF();
            }
_L4:
            d(q1.b_());
            return this;
_L2:
            if (!j.q.b(q1).isEmpty())
            {
                if (c.d())
                {
                    c.b();
                    c = null;
                    b = j.q.b(q1);
                    a = a & -2;
                    if (p.m)
                    {
                        d1 = B();
                    }
                    c = d1;
                } else
                {
                    c.a(j.q.b(q1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public a a(Iterable iterable)
        {
            if (c == null)
            {
                A();
                com.umeng.message.proguard.p.a.a(iterable, b);
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
            for (int i1 = 0; i1 < p(); i1++)
            {
                if (!a(i1).a())
                {
                    return false;
                }
            }

            return true;
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

        public j.p b(int i1)
        {
            if (c == null)
            {
                return (j.p)b.get(i1);
            } else
            {
                return (j.p)c.c(i1);
            }
        }

        public a b(int i1, j.o.a a1)
        {
            if (c == null)
            {
                A();
                b.add(i1, a1.N());
                aF();
                return this;
            } else
            {
                c.b(i1, a1.N());
                return this;
            }
        }

        public a b(int i1, j.o o1)
        {
            if (c == null)
            {
                if (o1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    A();
                    b.add(i1, o1);
                    aF();
                    return this;
                }
            } else
            {
                c.b(i1, o1);
                return this;
            }
        }

        public a c(int i1)
        {
            if (c == null)
            {
                A();
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

        public j.o.a d(int i1)
        {
            return (j.o.a)B().b(i1);
        }

        public a d(x x1)
        {
            if (x1 instanceof j.q)
            {
                return a((j.q)x1);
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

        public j.o.a e(int i1)
        {
            return (j.o.a)B().c(i1, com.umeng.message.proguard.j.o.h());
        }

        public a e(h h1, n n1)
            throws IOException
        {
            h1 = (j.q)j.q.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.q)n1.a();
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
            return com.umeng.message.proguard.j.c().a(com/umeng/message/proguard/j$q, com/umeng/message/proguard/j$q$a);
        }

        public a m()
        {
            super.ah();
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

        public j.q r()
        {
            return j.q.h();
        }

        public j.q s()
        {
            j.q q1 = t();
            if (!q1.a())
            {
                throw b(q1);
            } else
            {
                return q1;
            }
        }

        public j.q t()
        {
            j.q q1 = new j.q(this, null);
            int i1 = a;
            if (c == null)
            {
                if ((a & 1) == 1)
                {
                    b = Collections.unmodifiableList(b);
                    a = a & -2;
                }
                j.q.a(q1, b);
            } else
            {
                j.q.a(q1, c.f());
            }
            aB();
            return q1;
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

        public j.o.a v()
        {
            return (j.o.a)B().b(com.umeng.message.proguard.j.o.h());
        }

        public List w()
        {
            return B().h();
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

        public j.q c(h h1, n n1)
            throws s
        {
            return new j.q(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    private static final _cls1.c c;
    private static final long h = 0L;
    private final P d;
    private List e;
    private byte f;
    private int g;

    public static a a(a.B b1)
    {
        return q().a(b1);
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
        return j.b();
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

    public  M()
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
        for (int j1 = 0; j1 < e.size(); j1++)
        {
            i1.c(1, (y)e.get(j1));
        }

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

        f = 1;
        return true;
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
            j1 += com.umeng.message.proguard.i.g(1, (y)e.get(i1));
        }

        i1 = b_().d() + j1;
        g = i1;
        return i1;
    }

    public g i()
    {
        return c;
    }

    protected c l()
    {
        return j.c().a(com/umeng/message/proguard/j$q, com/umeng/message/proguard/j$q$a);
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
    //                   10: 110;
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
_L2:
        if ((flag & true))
        {
            e = Collections.unmodifiableList(e);
        }
        d = _lcls1.b();
        ad();
        return;
        h1;
        flag1 = flag4;
        throw (new s(h1.getMessage())).a(this);
_L4:
        flag2 = true;
        if (true) goto _L9; else goto _L8
_L8:
    }

    nit>(h h1, n n1, nit> nit>)
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
