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
//            B, i, y, g, 
//            n, x, p, D, 
//            C, c

public static final class n extends n
    implements n
{
    public static final class a extends p.c
        implements j.t
    {

        private int a;
        private Object b;
        private Object c;
        private boolean d;
        private boolean e;
        private b f;
        private Object g;
        private boolean h;
        private boolean i;
        private boolean j;
        private List k;
        private D l;

        static a ae()
        {
            return an();
        }

        private void ag()
        {
            if (p.m)
            {
                ap();
            }
        }

        private static a an()
        {
            return new a();
        }

        private void ao()
        {
            if ((a & 0x200) != 512)
            {
                k = new ArrayList(k);
                a = a | 0x200;
            }
        }

        private D ap()
        {
            if (l == null)
            {
                List list = k;
                boolean flag;
                if ((a & 0x200) == 512)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                l = new D(list, flag, aE(), aD());
                k = null;
            }
            return l;
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.t();
        }

        public p.c A()
        {
            return I();
        }

        public p.c B()
        {
            return m();
        }

        public boolean C()
        {
            return (a & 0x40) == 64;
        }

        public boolean D()
        {
            return h;
        }

        public boolean E()
        {
            return (a & 0x80) == 128;
        }

        public boolean F()
        {
            return i;
        }

        public boolean G()
        {
            return (a & 0x100) == 256;
        }

        public boolean H()
        {
            return j;
        }

        public a I()
        {
            return an().a(O());
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.t();
        }

        public List K()
        {
            if (l == null)
            {
                return Collections.unmodifiableList(k);
            } else
            {
                return l.g();
            }
        }

        public List L()
        {
            if (l != null)
            {
                return l.i();
            } else
            {
                return Collections.unmodifiableList(k);
            }
        }

        public j.s M()
        {
            return j.s.h();
        }

        public j.s N()
        {
            j.s s1 = O();
            if (!s1.a())
            {
                throw b(s1);
            } else
            {
                return s1;
            }
        }

        public j.s O()
        {
            int j1 = 1;
            j.s s1 = new j.s(this, null);
            int k1 = a;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            j.s.a(s1, b);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            j.s.b(s1, c);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            j.s.a(s1, d);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            j.s.b(s1, e);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            j.s.a(s1, f);
            i1 = j1;
            if ((k1 & 0x20) == 32)
            {
                i1 = j1 | 0x20;
            }
            j.s.c(s1, g);
            j1 = i1;
            if ((k1 & 0x40) == 64)
            {
                j1 = i1 | 0x40;
            }
            j.s.c(s1, h);
            i1 = j1;
            if ((k1 & 0x80) == 128)
            {
                i1 = j1 | 0x80;
            }
            j.s.d(s1, i);
            j1 = i1;
            if ((k1 & 0x100) == 256)
            {
                j1 = i1 | 0x100;
            }
            j.s.e(s1, j);
            if (l == null)
            {
                if ((a & 0x200) == 512)
                {
                    k = Collections.unmodifiableList(k);
                    a = a & 0xfffffdff;
                }
                j.s.a(s1, k);
            } else
            {
                j.s.a(s1, l.f());
            }
            j.s.a(s1, j1);
            aB();
            return s1;
        }

        public a P()
        {
            a = a & -2;
            b = j.s.h().o();
            aF();
            return this;
        }

        public y Q()
        {
            return M();
        }

        public x R()
        {
            return M();
        }

        public int S()
        {
            if (l == null)
            {
                return k.size();
            } else
            {
                return l.c();
            }
        }

        public a T()
        {
            a = a & -3;
            c = j.s.h().r();
            aF();
            return this;
        }

        public a U()
        {
            a = a & -5;
            d = false;
            aF();
            return this;
        }

        public a V()
        {
            a = a & -9;
            e = false;
            aF();
            return this;
        }

        public a W()
        {
            a = a & 0xffffffef;
            f = b.a;
            aF();
            return this;
        }

        public a X()
        {
            a = a & 0xffffffdf;
            g = j.s.h().f_();
            aF();
            return this;
        }

        public a Y()
        {
            a = a & 0xffffffbf;
            h = false;
            aF();
            return this;
        }

        public a Z()
        {
            a = a & 0xffffff7f;
            i = false;
            aF();
            return this;
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
            if (l == null)
            {
                return (j.G)k.get(i1);
            } else
            {
                return (j.G)l.a(i1);
            }
        }

        public a a(int i1, j.G.a a1)
        {
            if (l == null)
            {
                ao();
                k.set(i1, a1.G());
                aF();
                return this;
            } else
            {
                l.a(i1, a1.G());
                return this;
            }
        }

        public a a(int i1, j.G g1)
        {
            if (l == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ao();
                    k.set(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                l.a(i1, g1);
                return this;
            }
        }

        public a a(j.G.a a1)
        {
            if (l == null)
            {
                ao();
                k.add(a1.G());
                aF();
                return this;
            } else
            {
                l.a(a1.G());
                return this;
            }
        }

        public a a(j.G g1)
        {
            if (l == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ao();
                    k.add(g1);
                    aF();
                    return this;
                }
            } else
            {
                l.a(g1);
                return this;
            }
        }

        public a a(b b1)
        {
            if (b1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x10;
                f = b1;
                aF();
                return this;
            }
        }

        public a a(j.s s1)
        {
            D d1;
            d1 = null;
            if (s1 == j.s.h())
            {
                return this;
            }
            if (s1.n())
            {
                a = a | 1;
                b = j.s.b(s1);
                aF();
            }
            if (s1.q())
            {
                a = a | 2;
                c = j.s.c(s1);
                aF();
            }
            if (s1.t())
            {
                a(s1.u());
            }
            if (s1.v())
            {
                b(s1.w());
            }
            if (s1.x())
            {
                a(s1.y());
            }
            if (s1.z())
            {
                a = a | 0x20;
                g = j.s.d(s1);
                aF();
            }
            if (s1.C())
            {
                c(s1.D());
            }
            if (s1.E())
            {
                d(s1.F());
            }
            if (s1.G())
            {
                e(s1.H());
            }
            if (l != null) goto _L2; else goto _L1
_L1:
            if (!j.s.e(s1).isEmpty())
            {
                if (k.isEmpty())
                {
                    k = j.s.e(s1);
                    a = a & 0xfffffdff;
                } else
                {
                    ao();
                    k.addAll(j.s.e(s1));
                }
                aF();
            }
_L4:
            a(((p.d) (s1)));
            d(s1.b_());
            return this;
_L2:
            if (!j.s.e(s1).isEmpty())
            {
                if (l.d())
                {
                    l.b();
                    l = null;
                    k = j.s.e(s1);
                    a = a & 0xfffffdff;
                    if (p.m)
                    {
                        d1 = ap();
                    }
                    l = d1;
                } else
                {
                    l.a(j.s.e(s1));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public a a(Iterable iterable)
        {
            if (l == null)
            {
                ao();
                com.umeng.message.proguard.p.c.a(iterable, k);
                aF();
                return this;
            } else
            {
                l.a(iterable);
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

        public a a(boolean flag)
        {
            a = a | 4;
            d = flag;
            aF();
            return this;
        }

        public final boolean a()
        {
            int i1 = 0;
_L7:
            if (i1 >= S()) goto _L2; else goto _L1
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

        public a aa()
        {
            a = a & 0xfffffeff;
            j = false;
            aF();
            return this;
        }

        public a ab()
        {
            if (l == null)
            {
                k = Collections.emptyList();
                a = a & 0xfffffdff;
                aF();
                return this;
            } else
            {
                l.e();
                return this;
            }
        }

        public j.G.a ac()
        {
            return (j.G.a)ap().b(com.umeng.message.proguard.j.G.h());
        }

        public List ad()
        {
            return ap().h();
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return I();
        }

        public x aj()
        {
            return O();
        }

        public x ak()
        {
            return N();
        }

        public y al()
        {
            return O();
        }

        public y am()
        {
            return N();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
        }

        public j.H b(int i1)
        {
            if (l == null)
            {
                return (j.H)k.get(i1);
            } else
            {
                return (j.H)l.c(i1);
            }
        }

        public a b(int i1, j.G.a a1)
        {
            if (l == null)
            {
                ao();
                k.add(i1, a1.G());
                aF();
                return this;
            } else
            {
                l.b(i1, a1.G());
                return this;
            }
        }

        public a b(int i1, j.G g1)
        {
            if (l == null)
            {
                if (g1 == null)
                {
                    throw new NullPointerException();
                } else
                {
                    ao();
                    k.add(i1, g1);
                    aF();
                    return this;
                }
            } else
            {
                l.b(i1, g1);
                return this;
            }
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

        public a b(boolean flag)
        {
            a = a | 8;
            e = flag;
            aF();
            return this;
        }

        public a c(int i1)
        {
            if (l == null)
            {
                ao();
                k.remove(i1);
                aF();
                return this;
            } else
            {
                l.d(i1);
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
                a = a | 0x20;
                g = s1;
                aF();
                return this;
            }
        }

        public a c(boolean flag)
        {
            a = a | 0x40;
            h = flag;
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
            return I();
        }

        public a.a d()
        {
            return I();
        }

        public j.G.a d(int i1)
        {
            return (j.G.a)ap().b(i1);
        }

        public a d(x x1)
        {
            if (x1 instanceof j.s)
            {
                return a((j.s)x1);
            } else
            {
                super.a(x1);
                return this;
            }
        }

        public a d(boolean flag)
        {
            a = a | 0x80;
            i = flag;
            aF();
            return this;
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
            return (j.G.a)ap().c(i1, com.umeng.message.proguard.j.G.h());
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
            h1 = (j.s)j.s.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.s)n1.a();
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

        public a e(boolean flag)
        {
            a = a | 0x100;
            j = flag;
            aF();
            return this;
        }

        public b.a f()
        {
            return I();
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

        public String f_()
        {
            Object obj = g;
            if (!(obj instanceof String))
            {
                obj = ((g)obj).h();
                g = obj;
                return ((String) (obj));
            } else
            {
                return (String)obj;
            }
        }

        public a g(g g1)
        {
            if (g1 == null)
            {
                throw new NullPointerException();
            } else
            {
                a = a | 0x20;
                g = g1;
                aF();
                return this;
            }
        }

        public y.a g()
        {
            return I();
        }

        public g g_()
        {
            Object obj = g;
            if (obj instanceof String)
            {
                obj = com.umeng.message.proguard.g.a((String)obj);
                g = obj;
                return ((g) (obj));
            } else
            {
                return (g)obj;
            }
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return I();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.u().a(com/umeng/message/proguard/j$s, com/umeng/message/proguard/j$s$a);
        }

        public a m()
        {
            super.B();
            b = "";
            a = a & -2;
            c = "";
            a = a & -3;
            d = false;
            a = a & -5;
            e = false;
            a = a & -9;
            f = b.a;
            a = a & 0xffffffef;
            g = "";
            a = a & 0xffffffdf;
            h = false;
            a = a & 0xffffffbf;
            i = false;
            a = a & 0xffffff7f;
            j = false;
            a = a & 0xfffffeff;
            if (l == null)
            {
                k = Collections.emptyList();
                a = a & 0xfffffdff;
                return this;
            } else
            {
                l.e();
                return this;
            }
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

        public boolean u()
        {
            return d;
        }

        public boolean v()
        {
            return (a & 8) == 8;
        }

        public boolean w()
        {
            return e;
        }

        public boolean x()
        {
            return (a & 0x10) == 16;
        }

        public b y()
        {
            return f;
        }

        public boolean z()
        {
            return (a & 0x20) == 32;
        }

        private a()
        {
            b = "";
            c = "";
            f = b.a;
            g = "";
            k = Collections.emptyList();
            ag();
        }

        private a(p.b b1)
        {
            super(b1);
            b = "";
            c = "";
            f = b.a;
            g = "";
            k = Collections.emptyList();
            ag();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }

    public static final class b extends Enum
        implements C
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static r.b g = new r.b() {

            public b a(int i1)
            {
                return b.a(i1);
            }

            public r.a b(int i1)
            {
                return a(i1);
            }

        };
        private static final b h[] = values();
        private static final b k[];
        private final int i;
        private final int j;

        public static b a(int i1)
        {
            switch (i1)
            {
            default:
                return null;

            case 1: // '\001'
                return a;

            case 2: // '\002'
                return b;

            case 3: // '\003'
                return c;
            }
        }

        public static b a(k.e e1)
        {
            if (e1.g() != e())
            {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else
            {
                return h[e1.b()];
            }
        }

        public static r.b b()
        {
            return g;
        }

        public static final k.d e()
        {
            return (k.d)j.s.k().k().get(0);
        }

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/umeng/message/proguard/j$s$b, s1);
        }

        public static b[] values()
        {
            return (b[])k.clone();
        }

        public final int a()
        {
            return j;
        }

        public final k.e c()
        {
            return (k.e)e().h().get(i);
        }

        public final k.d d()
        {
            return e();
        }

        static 
        {
            a = new b("SPEED", 0, 0, 1);
            b = new b("CODE_SIZE", 1, 1, 2);
            c = new b("LITE_RUNTIME", 2, 2, 3);
            k = (new b[] {
                a, b, c
            });
        }

        private b(String s1, int i1, int j1, int k1)
        {
            super(s1, i1);
            i = j1;
            j = k1;
        }
    }


    private static final long B = 0L;
    public static B a = new c() {

        public j.s c(h h1, n n1)
            throws s
        {
            return new j.s(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    public static final int c = 8;
    public static final int d = 10;
    public static final int e = 20;
    public static final int f = 9;
    public static final int g = 11;
    public static final int h = 16;
    public static final int i = 17;
    public static final int j = 18;
    public static final int k = 999;
    private static final _cls1.c l;
    private int A;
    private final P n;
    private int o;
    private Object p;
    private Object q;
    private boolean r;
    private boolean s;
    private b t;
    private Object u;
    private boolean v;
    private boolean w;
    private boolean x;
    private List y;
    private byte z;

    public static a T()
    {
        return a.ae();
    }

    static int a(a.ae ae1, int i1)
    {
        ae1.o = i1;
        return i1;
    }

    public static a a(o o1)
    {
        return T().a(o1);
    }

    static b a(b b1, b b2)
    {
        b1.t = b2;
        return b2;
    }

    public static t a(g g1)
        throws s
    {
        return (t)a.d(g1);
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
        a1.p = obj;
        return obj;
    }

    static List a(p p1, List list)
    {
        p1.y = list;
        return list;
    }

    static boolean a(y y1, boolean flag)
    {
        y1.r = flag;
        return flag;
    }

    private void ae()
    {
        p = "";
        q = "";
        r = false;
        s = false;
        t = b.a;
        u = "";
        v = false;
        w = false;
        x = false;
        y = Collections.emptyList();
    }

    public static  b(InputStream inputstream)
        throws IOException
    {
        return ()a.f(inputstream);
    }

    public static a b(InputStream inputstream, n n1)
        throws IOException
    {
        return (a)a.f(inputstream, n1);
    }

    static Object b(a a1)
    {
        return a1.p;
    }

    static Object b(p p1, Object obj)
    {
        p1.q = obj;
        return obj;
    }

    static boolean b(q q1, boolean flag)
    {
        q1.s = flag;
        return flag;
    }

    static Object c(s s1)
    {
        return s1.q;
    }

    static Object c(q q1, Object obj)
    {
        q1.u = obj;
        return obj;
    }

    static boolean c(u u1, boolean flag)
    {
        u1.v = flag;
        return flag;
    }

    static Object d(v v1)
    {
        return v1.u;
    }

    static boolean d(u u1, boolean flag)
    {
        u1.w = flag;
        return flag;
    }

    static List e(w w1)
    {
        return w1.y;
    }

    static boolean e(y y1, boolean flag)
    {
        y1.x = flag;
        return flag;
    }

    public static x h()
    {
        return l;
    }

    public static final l k()
    {
        return com.umeng.message.proguard.j.t();
    }

    public boolean C()
    {
        return (o & 0x40) == 64;
    }

    public boolean D()
    {
        return v;
    }

    public boolean E()
    {
        return (o & 0x80) == 128;
    }

    public boolean F()
    {
        return w;
    }

    public boolean G()
    {
        return (o & 0x100) == 256;
    }

    public boolean H()
    {
        return x;
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public List K()
    {
        return y;
    }

    public List L()
    {
        return y;
    }

    public y M()
    {
        return V();
    }

    public V N()
    {
        return U();
    }

    public U O()
    {
        return V();
    }

    public V P()
    {
        return U();
    }

    public y Q()
    {
        return i();
    }

    public x R()
    {
        return i();
    }

    public int S()
    {
        return y.size();
    }

    public a U()
    {
        return T();
    }

    public a V()
    {
        return a(this);
    }

    public a a(int i1)
    {
        return (a)y.get(i1);
    }

    protected a a(y y1)
    {
        return new a(y1, null);
    }

    public void a(i i1)
        throws IOException
    {
        d();
        a a1 = X();
        if ((o & 1) == 1)
        {
            i1.a(1, p());
        }
        if ((o & 2) == 2)
        {
            i1.a(8, s());
        }
        if ((o & 0x10) == 16)
        {
            i1.d(9, t.a());
        }
        if ((o & 4) == 4)
        {
            i1.a(10, r);
        }
        if ((o & 0x20) == 32)
        {
            i1.a(11, g_());
        }
        if ((o & 0x40) == 64)
        {
            i1.a(16, v);
        }
        if ((o & 0x80) == 128)
        {
            i1.a(17, w);
        }
        if ((o & 0x100) == 256)
        {
            i1.a(18, x);
        }
        if ((o & 8) == 8)
        {
            i1.a(20, s);
        }
        for (int j1 = 0; j1 < y.size(); j1++)
        {
            i1.c(999, (y)y.get(j1));
        }

        a1.a(0x20000000, i1);
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = z;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        for (int i1 = 0; i1 < S(); i1++)
        {
            if (!a(i1).a())
            {
                z = 0;
                return false;
            }
        }

        if (!W())
        {
            z = 0;
            return false;
        } else
        {
            z = 1;
            return true;
        }
    }

    public z b(int i1)
    {
        return (z)y.get(i1);
    }

    protected y b(y y1)
    {
        return a(y1);
    }

    public final P b_()
    {
        return n;
    }

    public int d()
    {
        boolean flag = false;
        int i1 = A;
        if (i1 != -1)
        {
            return i1;
        }
        int j1;
        if ((o & 1) == 1)
        {
            j1 = com.umeng.message.proguard.i.c(1, p()) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if ((o & 2) == 2)
        {
            i1 = j1 + com.umeng.message.proguard.i.c(8, s());
        }
        j1 = i1;
        if ((o & 0x10) == 16)
        {
            j1 = i1 + com.umeng.message.proguard.i.j(9, t.a());
        }
        i1 = j1;
        if ((o & 4) == 4)
        {
            i1 = j1 + com.umeng.message.proguard.i.b(10, r);
        }
        j1 = i1;
        if ((o & 0x20) == 32)
        {
            j1 = i1 + com.umeng.message.proguard.i.c(11, g_());
        }
        i1 = j1;
        if ((o & 0x40) == 64)
        {
            i1 = j1 + com.umeng.message.proguard.i.b(16, v);
        }
        j1 = i1;
        if ((o & 0x80) == 128)
        {
            j1 = i1 + com.umeng.message.proguard.i.b(17, w);
        }
        i1 = j1;
        if ((o & 0x100) == 256)
        {
            i1 = j1 + com.umeng.message.proguard.i.b(18, x);
        }
        j1 = i1;
        if ((o & 8) == 8)
        {
            j1 = i1 + com.umeng.message.proguard.i.b(20, s);
        }
        i1 = j1;
        for (j1 = ((flag) ? 1 : 0); j1 < y.size();)
        {
            int k1 = com.umeng.message.proguard.i.g(999, (y)y.get(j1));
            j1++;
            i1 = k1 + i1;
        }

        i1 = Z() + i1 + b_().d();
        A = i1;
        return i1;
    }

    public String f_()
    {
        Object obj = u;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            u = s1;
        }
        return s1;
    }

    public g g_()
    {
        Object obj = u;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            u = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public u i()
    {
        return l;
    }

    protected l l()
    {
        return com.umeng.message.proguard.j.u().a(com/umeng/message/proguard/j$s, com/umeng/message/proguard/j$s$a);
    }

    public B m()
    {
        return a;
    }

    public boolean n()
    {
        return (o & 1) == 1;
    }

    public String o()
    {
        Object obj = p;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            p = s1;
        }
        return s1;
    }

    public g p()
    {
        Object obj = p;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            p = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean q()
    {
        return (o & 2) == 2;
    }

    public String r()
    {
        Object obj = q;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            q = s1;
        }
        return s1;
    }

    public g s()
    {
        Object obj = q;
        if (obj instanceof String)
        {
            obj = com.umeng.message.proguard.g.a((String)obj);
            q = obj;
            return ((g) (obj));
        } else
        {
            return (g)obj;
        }
    }

    public boolean t()
    {
        return (o & 4) == 4;
    }

    public boolean u()
    {
        return r;
    }

    public boolean v()
    {
        return (o & 8) == 8;
    }

    public boolean w()
    {
        return s;
    }

    public boolean x()
    {
        return (o & 0x10) == 16;
    }

    public b y()
    {
        return t;
    }

    public boolean z()
    {
        return (o & 0x20) == 32;
    }

    static 
    {
        l = new <init>(true);
        l.ae();
    }

    private b(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        int i1;
        boolean flag;
        flag = false;
        super();
        z = -1;
        A = -1;
        ae();
        _lcls1 = com.umeng.message.proguard.P.b();
        i1 = 0;
_L20:
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
        JVM INSTR lookupswitch 11: default 849
    //                   0: 852
    //                   10: 182
    //                   66: 276
    //                   72: 342
    //                   80: 452
    //                   90: 497
    //                   128: 543
    //                   136: 589
    //                   144: 636
    //                   160: 683
    //                   7994: 729;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
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
        o = o | 1;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        p = h1.l();
        continue; /* Loop/switch isn't completed */
        h1;
        k1 = l1;
        throw h1.a(this);
        h1;
        if ((k1 & 0x200) == 512)
        {
            y = Collections.unmodifiableList(y);
        }
        n = _lcls1.b();
        ad();
        throw h1;
_L6:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = o | 2;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        q = h1.l();
        continue; /* Loop/switch isn't completed */
        h1;
        k1 = i2;
        throw (new s(h1.getMessage())).a(this);
_L7:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        j1 = h1.n();
        l1 = i1;
        k1 = i1;
        i2 = i1;
        b b1 = b.a(j1);
        if (b1 != null) goto _L16; else goto _L15
_L15:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        _lcls1.a(9, j1);
        continue; /* Loop/switch isn't completed */
_L16:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = o | 0x10;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        t = b1;
        continue; /* Loop/switch isn't completed */
_L8:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = o | 4;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        r = h1.j();
        continue; /* Loop/switch isn't completed */
_L9:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = o | 0x20;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        u = h1.l();
        continue; /* Loop/switch isn't completed */
_L10:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = o | 0x40;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        v = h1.j();
        continue; /* Loop/switch isn't completed */
_L11:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = o | 0x80;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        w = h1.j();
        continue; /* Loop/switch isn't completed */
_L12:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = o | 0x100;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        x = h1.j();
        continue; /* Loop/switch isn't completed */
_L13:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        o = o | 8;
        l1 = i1;
        k1 = i1;
        i2 = i1;
        s = h1.j();
        continue; /* Loop/switch isn't completed */
_L14:
        j1 = i1;
        if ((i1 & 0x200) == 512) goto _L18; else goto _L17
_L17:
        l1 = i1;
        k1 = i1;
        i2 = i1;
        y = new ArrayList();
        j1 = i1 | 0x200;
_L18:
        l1 = j1;
        k1 = j1;
        i2 = j1;
        y.add(h1.a(a, n1));
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L2:
        if ((i1 & 0x200) == 512)
        {
            y = Collections.unmodifiableList(y);
        }
        n = _lcls1.b();
        ad();
        return;
_L4:
        flag = true;
        if (true) goto _L20; else goto _L19
_L19:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        z = -1;
        A = -1;
        n = <init>1.b_();
    }

    b_(b_ b_1, b_ b_2)
    {
        this(b_1);
    }

    private <init>(boolean flag)
    {
        z = -1;
        A = -1;
        n = com.umeng.message.proguard.P.c();
    }
}
