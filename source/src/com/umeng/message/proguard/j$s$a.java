// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            j, p, D, s, 
//            B, g, y, x, 
//            h, n

public static final class <init> extends <init>
    implements <init>
{

    private int a;
    private Object b;
    private Object c;
    private boolean d;
    private boolean e;
    private a f;
    private Object g;
    private boolean h;
    private boolean i;
    private boolean j;
    private List k;
    private D l;

    static <init> ae()
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

    private static ap an()
    {
        return new <init>();
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

    public static final l k()
    {
        return com.umeng.message.proguard.j.t();
    }

    public l A()
    {
        return I();
    }

    public I B()
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

    public j I()
    {
        return an().a(O());
    }

    public O J()
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

    public k M()
    {
        return k();
    }

    public k N()
    {
        k k1 = O();
        if (!k1.O())
        {
            throw b(k1);
        } else
        {
            return k1;
        }
    }

    public b O()
    {
        int j1 = 1;
        b b1 = new nit>(this, null);
        int k1 = a;
        int i1;
        if ((k1 & 1) != 1)
        {
            j1 = 0;
        }
        a(b1, b);
        i1 = j1;
        if ((k1 & 2) == 2)
        {
            i1 = j1 | 2;
        }
        b(b1, c);
        j1 = i1;
        if ((k1 & 4) == 4)
        {
            j1 = i1 | 4;
        }
        c(b1, d);
        i1 = j1;
        if ((k1 & 8) == 8)
        {
            i1 = j1 | 8;
        }
        d(b1, e);
        j1 = i1;
        if ((k1 & 0x10) == 16)
        {
            j1 = i1 | 0x10;
        }
        e(b1, f);
        i1 = j1;
        if ((k1 & 0x20) == 32)
        {
            i1 = j1 | 0x20;
        }
        f(b1, g);
        j1 = i1;
        if ((k1 & 0x40) == 64)
        {
            j1 = i1 | 0x40;
        }
        g(b1, h);
        i1 = j1;
        if ((k1 & 0x80) == 128)
        {
            i1 = j1 | 0x80;
        }
        h(b1, i);
        j1 = i1;
        if ((k1 & 0x100) == 256)
        {
            j1 = i1 | 0x100;
        }
        i(b1, j);
        if (l == null)
        {
            if ((a & 0x200) == 512)
            {
                k = Collections.unmodifiableList(k);
                a = a & 0xfffffdff;
            }
            a(b1, k);
        } else
        {
            k(b1, l.f());
        }
        l(b1, j1);
        aB();
        return b1;
    }

    public aB P()
    {
        a = a & -2;
        b = b().b();
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

    public l T()
    {
        a = a & -3;
        c = c().c();
        aF();
        return this;
    }

    public aF U()
    {
        a = a & -5;
        d = false;
        aF();
        return this;
    }

    public aF V()
    {
        a = a & -9;
        e = false;
        aF();
        return this;
    }

    public aF W()
    {
        a = a & 0xffffffef;
        f = a;
        aF();
        return this;
    }

    public aF X()
    {
        a = a & 0xffffffdf;
        g = g().();
        aF();
        return this;
    }

    public aF Y()
    {
        a = a & 0xffffffbf;
        h = false;
        aF();
        return this;
    }

    public aF Z()
    {
        a = a & 0xffffff7f;
        i = false;
        aF();
        return this;
    }

    public aF a(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e a(x x1)
    {
        return d(x1);
    }

    public d a(int i1)
    {
        if (l == null)
        {
            return (l)k.get(i1);
        } else
        {
            return (k)l.a(i1);
        }
    }

    public l a(int i1, l l1)
    {
        if (l == null)
        {
            ao();
            k.set(i1, l1.G());
            aF();
            return this;
        } else
        {
            l.a(i1, l1.G());
            return this;
        }
    }

    public G a(int i1, G g1)
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

    public l a(l l1)
    {
        if (l == null)
        {
            ao();
            k.add(l1.G());
            aF();
            return this;
        } else
        {
            l.a(l1.G());
            return this;
        }
    }

    public G a(G g1)
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

    public l a(l l1)
    {
        if (l1 == null)
        {
            throw new NullPointerException();
        } else
        {
            a = a | 0x10;
            f = l1;
            aF();
            return this;
        }
    }

    public aF a(aF af)
    {
        D d1;
        d1 = null;
        if (af == aF())
        {
            return this;
        }
        if (af.aF())
        {
            a = a | 1;
            b = b(af);
            aF();
        }
        if (af.aF())
        {
            a = a | 2;
            c = c(af);
            aF();
        }
        if (af.aF())
        {
            a(af.a());
        }
        if (af.a())
        {
            b(af.b());
        }
        if (af.b())
        {
            a(af.a());
        }
        if (af.a())
        {
            a = a | 0x20;
            g = g(af);
            aF();
        }
        if (af.aF())
        {
            c(af.c());
        }
        if (af.c())
        {
            d(af.d());
        }
        if (af.d())
        {
            e(af.e());
        }
        if (l != null) goto _L2; else goto _L1
_L1:
        if (!l(af).isEmpty())
        {
            if (k.isEmpty())
            {
                k = k(af);
                a = a & 0xfffffdff;
            } else
            {
                ao();
                k.addAll(k(af));
            }
            aF();
        }
_L4:
        a(((a) (af)));
        d(af.());
        return this;
_L2:
        if (!(af).isEmpty())
        {
            if (l.d())
            {
                l.b();
                l = null;
                k = k(af);
                a = a & 0xfffffdff;
                if (p.m)
                {
                    d1 = ap();
                }
                l = d1;
            } else
            {
                l.a(l(af));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public l a(Iterable iterable)
    {
        if (l == null)
        {
            ao();
            ao(iterable, k);
            aF();
            return this;
        } else
        {
            l.a(iterable);
            return this;
        }
    }

    public l a(String s1)
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

    public aF a(boolean flag)
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

    public af aa()
    {
        a = a & 0xfffffeff;
        j = false;
        aF();
        return this;
    }

    public aF ab()
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

    public l ac()
    {
        return (l)ap().b(ap());
    }

    public List ad()
    {
        return ap().h();
    }

    public ap ah()
    {
        return m();
    }

    public m ai()
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

    public N b(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e b(int i1)
    {
        if (l == null)
        {
            return (l)k.get(i1);
        } else
        {
            return (k)l.c(i1);
        }
    }

    public l b(int i1, l l1)
    {
        if (l == null)
        {
            ao();
            k.add(i1, l1.G());
            aF();
            return this;
        } else
        {
            l.b(i1, l1.G());
            return this;
        }
    }

    public G b(int i1, G g1)
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

    public l b(String s1)
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

    public aF b(boolean flag)
    {
        a = a | 8;
        e = flag;
        aF();
        return this;
    }

    public aF c(int i1)
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

    public l c(String s1)
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

    public aF c(boolean flag)
    {
        a = a | 0x40;
        h = flag;
        aF();
        return this;
    }

    public aF c(x x1)
    {
        return d(x1);
    }

    public d c(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return I();
    }

    public I d()
    {
        return I();
    }

    public I d(int i1)
    {
        return (I)ap().b(i1);
    }

    public ap d(x x1)
    {
        if (x1 instanceof ap)
        {
            return a((a)x1);
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

    public aF d(h h1, n n1)
        throws IOException
    {
        return e(h1, n1);
    }

    public e e()
    {
        return m();
    }

    public m e(int i1)
    {
        return (m)ap().c(i1, ap());
    }

    public ap e(g g1)
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

    public aF e(h h1, n n1)
        throws IOException
    {
        h1 = (aF)aF.d(h1, n1);
        if (h1 != null)
        {
            a(h1);
        }
        return this;
        n1;
        h1 = (a)n1.a();
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

    public aF f()
    {
        return I();
    }

    public I f(g g1)
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

    public g g(g g1)
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

    public aF g()
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

    public g h()
    {
        return m();
    }

    public m i()
    {
        return I();
    }

    public I j()
    {
        return m();
    }

    protected m l()
    {
        return com.umeng.message.proguard.j.u().m(com/umeng/message/proguard/j$s, com/umeng/message/proguard/j$s$a);
    }

    public m m()
    {
        super.m();
        b = "";
        a = a & -2;
        c = "";
        a = a & -3;
        d = false;
        a = a & -5;
        e = false;
        a = a & -9;
        f = a;
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

    public a y()
    {
        return f;
    }

    public boolean z()
    {
        return (a & 0x20) == 32;
    }

    private ion()
    {
        b = "";
        c = "";
        f = a;
        g = "";
        k = Collections.emptyList();
        ag();
    }

    private ag(ag ag1)
    {
        super(ag1);
        b = "";
        c = "";
        f = a;
        g = "";
        k = Collections.emptyList();
        ag();
    }

    ag(ag ag1, ag ag2)
    {
        this(ag1);
    }
}
