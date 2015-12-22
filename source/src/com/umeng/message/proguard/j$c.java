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
//            h, B, i, y, 
//            g, n, x, D, 
//            L, c

public static final class f extends p
    implements f
{
    public static final class a extends p.a
        implements j.d
    {

        private int a;
        private Object b;
        private List c;
        private D d;
        private j.e e;
        private L f;

        static a G()
        {
            return I();
        }

        private void H()
        {
            if (p.m)
            {
                L();
                M();
            }
        }

        private static a I()
        {
            return new a();
        }

        private void K()
        {
            if ((a & 2) != 2)
            {
                c = new ArrayList(c);
                a = a | 2;
            }
        }

        private D L()
        {
            if (d == null)
            {
                List list = c;
                boolean flag;
                if ((a & 2) == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                d = new D(list, flag, aE(), aD());
                c = null;
            }
            return d;
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
            return com.umeng.message.proguard.j.l();
        }

        public a A()
        {
            a = a & -2;
            b = j.c.h().o();
            aF();
            return this;
        }

        public a B()
        {
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
                aF();
                return this;
            } else
            {
                d.e();
                return this;
            }
        }

        public j.g.a C()
        {
            return (j.g.a)L().b(com.umeng.message.proguard.j.g.h());
        }

        public List D()
        {
            return L().h();
        }

        public a E()
        {
            if (f == null)
            {
                e = com.umeng.message.proguard.j.e.h();
                aF();
            } else
            {
                f.g();
            }
            a = a & -5;
            return this;
        }

        public j.e.a F()
        {
            a = a | 4;
            aF();
            return (j.e.a)M().e();
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.l();
        }

        public y Q()
        {
            return x();
        }

        public x R()
        {
            return x();
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

        public a a(int i1, j.g.a a1)
        {
            if (d == null)
            {
                K();
                c.set(i1, a1.x());
                aF();
                return this;
            } else
            {
                d.a(i1, a1.x());
                return this;
            }
        }

        public a a(int i1, j.g g1)
        {
            if (d == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    K();
                    c.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(i1, g1);
                return this;
            }
        }

        public a a(j.c c1)
        {
            D d1;
            d1 = null;
            if (c1 == j.c.h())
            {
                return this;
            }
            if (c1.n())
            {
                a = a | 1;
                b = j.c.b(c1);
                aF();
            }
            if (d != null) goto _L2; else goto _L1
_L1:
            if (!j.c.c(c1).isEmpty())
            {
                if (c.isEmpty())
                {
                    c = j.c.c(c1);
                    a = a & -3;
                } else
                {
                    K();
                    c.addAll(j.c.c(c1));
                }
                aF();
            }
_L4:
            if (c1.t())
            {
                b(c1.u());
            }
            d(c1.b_());
            return this;
_L2:
            if (!j.c.c(c1).isEmpty())
            {
                if (d.d())
                {
                    d.b();
                    d = null;
                    c = j.c.c(c1);
                    a = a & -3;
                    if (p.m)
                    {
                        d1 = L();
                    }
                    d = d1;
                } else
                {
                    d.a(j.c.c(c1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public a a(j.e.a a1)
        {
            if (f == null)
            {
                e = a1.u();
                aF();
            } else
            {
                f.a(a1.u());
            }
            a = a | 4;
            return this;
        }

        public a a(j.e e1)
        {
            if (f == null)
            {
                if (e1 == null)
                {
                    throw new NullPointerException();
                }
                e = e1;
                aF();
            } else
            {
                f.a(e1);
            }
            a = a | 4;
            return this;
        }

        public a a(j.g.a a1)
        {
            if (d == null)
            {
                K();
                c.add(a1.x());
                aF();
                return this;
            } else
            {
                d.a(a1.x());
                return this;
            }
        }

        public a a(j.g g1)
        {
            if (d == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    K();
                    c.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                d.a(g1);
                return this;
            }
        }

        public a a(Iterable iterable)
        {
            if (d == null)
            {
                K();
                com.umeng.message.proguard.p.a.a(iterable, c);
                aF();
                return this;
            } else
            {
                d.a(iterable);
                return this;
            }
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

        public j.g a(int i1)
        {
            if (d == null)
            {
                return (j.g)c.get(i1);
            } else
            {
                return (j.g)d.a(i1);
            }
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= s()) goto _L2; else goto _L1
_L1:
            if (a(i1).a()) goto _L4; else goto _L3
_L3:
            return false;
_L4:
            i1++;
            continue; /* Loop/switch isn't completed */
_L2:
            if (t() && !u().a()) goto _L3; else goto _L5
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
            return w();
        }

        public x aj()
        {
            return z();
        }

        public x ak()
        {
            return y();
        }

        public y al()
        {
            return z();
        }

        public y am()
        {
            return y();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public a b(int i1, j.g.a a1)
        {
            if (d == null)
            {
                K();
                c.add(i1, a1.x());
                aF();
                return this;
            } else
            {
                d.b(i1, a1.x());
                return this;
            }
        }

        public a b(int i1, j.g g1)
        {
            if (d == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    K();
                    c.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                d.b(i1, g1);
                return this;
            }
        }

        public a b(j.e e1)
        {
            if (f == null)
            {
                if ((a & 4) == 4 && e != com.umeng.message.proguard.j.e.h())
                {
                    e = com.umeng.message.proguard.j.e.a(e).a(e1).v();
                } else
                {
                    e = e1;
                }
                aF();
            } else
            {
                f.b(e1);
            }
            a = a | 4;
            return this;
        }

        public j.h b(int i1)
        {
            if (d == null)
            {
                return (j.h)c.get(i1);
            } else
            {
                return (j.h)d.c(i1);
            }
        }

        public a c(int i1)
        {
            if (d == null)
            {
                K();
                c.remove(i1);
                aF();
                return this;
            } else
            {
                d.d(i1);
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
            return w();
        }

        public a.a d()
        {
            return w();
        }

        public a d(x x1)
        {
            if (x1 instanceof j.c)
            {
                return a((j.c)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public j.g.a d(int i1)
        {
            return (j.g.a)L().b(i1);
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
            h1 = (j.c)j.c.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.c)n1.a();
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

        public j.g.a e(int i1)
        {
            return (j.g.a)L().c(i1, com.umeng.message.proguard.j.g.h());
        }

        public b.a f()
        {
            return w();
        }

        public y.a g()
        {
            return w();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return w();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.m().a(com/umeng/message/proguard/j$c, com/umeng/message/proguard/j$c$a);
        }

        public a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            if (d == null)
            {
                c = Collections.emptyList();
                a = a & -3;
            } else
            {
                d.e();
            }
            if (f == null)
            {
                e = com.umeng.message.proguard.j.e.h();
            } else
            {
                f.g();
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

        public List q()
        {
            if (d == null)
            {
                return Collections.unmodifiableList(c);
            } else
            {
                return d.g();
            }
        }

        public List r()
        {
            if (d != null)
            {
                return d.i();
            } else
            {
                return Collections.unmodifiableList(c);
            }
        }

        public int s()
        {
            if (d == null)
            {
                return c.size();
            } else
            {
                return d.c();
            }
        }

        public boolean t()
        {
            return (a & 4) == 4;
        }

        public j.e u()
        {
            if (f == null)
            {
                return e;
            } else
            {
                return (j.e)f.c();
            }
        }

        public j.f v()
        {
            if (f != null)
            {
                return (j.f)f.f();
            } else
            {
                return e;
            }
        }

        public a w()
        {
            return I().a(z());
        }

        public j.c x()
        {
            return j.c.h();
        }

        public j.c y()
        {
            j.c c1 = z();
            if (!c1.a())
            {
                throw b(c1);
            } else
            {
                return c1;
            }
        }

        public j.c z()
        {
            int i1 = 1;
            j.c c1 = new j.c(this, null);
            int j1 = a;
            if ((j1 & 1) != 1)
            {
                i1 = 0;
            }
            j.c.a(c1, b);
            if (d == null)
            {
                if ((a & 2) == 2)
                {
                    c = Collections.unmodifiableList(c);
                    a = a & -3;
                }
                j.c.a(c1, c);
            } else
            {
                j.c.a(c1, d.f());
            }
            if ((j1 & 4) == 4)
            {
                i1 |= 2;
            }
            if (f == null)
            {
                j.c.a(c1, e);
            } else
            {
                j.c.a(c1, (j.e)f.d());
            }
            j.c.a(c1, i1);
            aB();
            return c1;
        }

        private a()
        {
            b = "";
            c = Collections.emptyList();
            e = com.umeng.message.proguard.j.e.h();
            H();
        }

        private a(p.b b1)
        {
            super(b1);
            b = "";
            c = Collections.emptyList();
            e = com.umeng.message.proguard.j.e.h();
            H();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }


    public static B a = new c() {

        public j.c c(h h1, n n1)
            throws s
        {
            return new j.c(h1, n1, null);
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
    private List i;
    private _cls1.c j;
    private byte k;
    private int l;

    static int a(a.aB ab, int i1)
    {
        ab.g = i1;
        return i1;
    }

    public static a a(g g1)
    {
        return w().a(g1);
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

    static List a(h h1, List list)
    {
        h1.i = list;
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

    static Object b(a a1)
    {
        return a1.h;
    }

    static List c(h h1)
    {
        return h1.i;
    }

    public static i h()
    {
        return e;
    }

    public static final e k()
    {
        return com.umeng.message.proguard.j.l();
    }

    public static a w()
    {
        return a.G();
    }

    private void z()
    {
        h = "";
        i = Collections.emptyList();
        j = h();
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public h M()
    {
        return y();
    }

    public y N()
    {
        return x();
    }

    public x O()
    {
        return y();
    }

    public y P()
    {
        return x();
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

    public a a(int i1)
    {
        return (a)i.get(i1);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        if ((g & 1) == 1)
        {
            i1.a(1, p());
        }
        for (int j1 = 0; j1 < i.size(); j1++)
        {
            i1.c(2, (y)i.get(j1));
        }

        if ((g & 2) == 2)
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
        for (int i1 = 0; i1 < s(); i1++)
        {
            if (!a(i1).a())
            {
                k = 0;
                return false;
            }
        }

        if (t() && !u().a())
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
        return (k)i.get(i1);
    }

    protected i b(i i1)
    {
        return a(i1);
    }

    public final P b_()
    {
        return f;
    }

    public int d()
    {
        int j1 = 0;
        int i1 = l;
        if (i1 != -1)
        {
            return i1;
        }
        if ((g & 1) == 1)
        {
            i1 = com.umeng.message.proguard.i.c(1, p()) + 0;
        } else
        {
            i1 = 0;
        }
        while (j1 < i.size()) 
        {
            int k1 = com.umeng.message.proguard.i.g(2, (y)i.get(j1));
            j1++;
            i1 = k1 + i1;
        }
        j1 = i1;
        if ((g & 2) == 2)
        {
            j1 = i1 + com.umeng.message.proguard.i.g(3, j);
        }
        i1 = b_().d() + j1;
        l = i1;
        return i1;
    }

    public l i()
    {
        return e;
    }

    protected e l()
    {
        return com.umeng.message.proguard.j.m().a(com/umeng/message/proguard/j$c, com/umeng/message/proguard/j$c$a);
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

    public List q()
    {
        return i;
    }

    public List r()
    {
        return i;
    }

    public int s()
    {
        return i.size();
    }

    public boolean t()
    {
        return (g & 2) == 2;
    }

    public g u()
    {
        return j;
    }

    public j v()
    {
        return j;
    }

    public a x()
    {
        return w();
    }

    public a y()
    {
        return a(this);
    }

    static 
    {
        e = new <init>(true);
        e.z();
    }

    private a(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        int i1;
        int j1;
        j1 = 0;
        super();
        k = -1;
        l = -1;
        z();
        _lcls1 = com.umeng.message.proguard.P.b();
        i1 = 0;
_L17:
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        int k1 = i1;
        int j2 = h1.a();
        j2;
        JVM INSTR lookupswitch 4: default 464
    //                   0: 482
    //                   10: 119
    //                   18: 160
    //                   26: 222;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        k1 = i1;
        a a1;
        if (!a(h1, _lcls1, n1, j2))
        {
            k1 = 1;
            j1 = i1;
            i1 = k1;
        } else
        {
            int l1 = i1;
            i1 = j1;
            j1 = l1;
        }
          goto _L8
_L5:
        k1 = i1;
        g = g | 1;
        k1 = i1;
        h = h1.l();
        k1 = i1;
        i1 = j1;
        j1 = k1;
          goto _L8
_L6:
        if ((i1 & 2) == 2)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        k1 = i1;
        i = new ArrayList();
        i1 |= 2;
        i.add(h1.a(a, n1));
        k1 = i1;
        i1 = j1;
        j1 = k1;
          goto _L8
_L7:
        k1 = i1;
        if ((g & 2) != 2) goto _L10; else goto _L9
_L9:
        k1 = i1;
        a1 = j.u();
_L16:
        k1 = i1;
        j = (j)h1.a(a, n1);
        if (a1 == null) goto _L12; else goto _L11
_L11:
        k1 = i1;
        a1.a(j);
        k1 = i1;
        j = a1.v();
_L12:
        k1 = i1;
        g = g | 2;
        k1 = i1;
        i1 = j1;
        j1 = k1;
        break; /* Loop/switch isn't completed */
        h1;
_L15:
        k1 = i1;
        throw h1.a(this);
        h1;
_L13:
        if ((k1 & 2) == 2)
        {
            i = Collections.unmodifiableList(i);
        }
        f = _lcls1.b();
        ad();
        throw h1;
        h1;
_L14:
        k1 = i1;
        throw (new s(h1.getMessage())).a(this);
_L2:
        if ((i1 & 2) == 2)
        {
            i = Collections.unmodifiableList(i);
        }
        f = _lcls1.b();
        ad();
        return;
        h1;
        k1 = i1;
          goto _L13
        h1;
          goto _L14
        h1;
        if (true) goto _L15; else goto _L10
_L10:
        a1 = null;
        if (true) goto _L16; else goto _L8
_L8:
        int i2 = j1;
        j1 = i1;
        i1 = i2;
          goto _L17
_L4:
        boolean flag = true;
        j1 = i1;
        i1 = ((flag) ? 1 : 0);
          goto _L8
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
