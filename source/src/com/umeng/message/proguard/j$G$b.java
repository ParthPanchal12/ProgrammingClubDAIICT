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
//            n, y, x, c

public static final class e extends p
    implements e
{
    public static final class a extends p.a
        implements j.G.c
    {

        private int a;
        private Object b;
        private boolean c;

        private static a A()
        {
            return new a();
        }

        public static final k.a k()
        {
            return com.umeng.message.proguard.j.J();
        }

        static a y()
        {
            return A();
        }

        private void z()
        {
            if (!p.m);
        }

        public k.a J()
        {
            return com.umeng.message.proguard.j.J();
        }

        public y Q()
        {
            return t();
        }

        public x R()
        {
            return t();
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

        public a a(j.G.b b1)
        {
            if (b1 == j.G.b.h())
            {
                return this;
            }
            if (b1.n())
            {
                a = a | 1;
                b = j.G.b.b(b1);
                aF();
            }
            if (b1.q())
            {
                a(b1.r());
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
                a = a | 1;
                b = s1;
                aF();
                return this;
            }
        }

        public a a(boolean flag)
        {
            a = a | 2;
            c = flag;
            aF();
            return this;
        }

        public final boolean a()
        {
            while (!n() || !q()) 
            {
                return false;
            }
            return true;
        }

        public p.a ah()
        {
            return m();
        }

        public p.a ai()
        {
            return s();
        }

        public x aj()
        {
            return v();
        }

        public x ak()
        {
            return u();
        }

        public y al()
        {
            return v();
        }

        public y am()
        {
            return u();
        }

        public b.a b(h h1, n n1)
            throws IOException
        {
            return e(h1, n1);
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
            return s();
        }

        public a.a d()
        {
            return s();
        }

        public a d(x x1)
        {
            if (x1 instanceof j.G.b)
            {
                return a((j.G.b)x1);
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
            h1 = (j.G.b)j.G.b.a.d(h1, n1);
            if (h1 != null)
            {
                a(h1);
            }
            return this;
            n1;
            h1 = (j.G.b)n1.a();
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
            return s();
        }

        public y.a g()
        {
            return s();
        }

        public y.a h()
        {
            return m();
        }

        public x.a i()
        {
            return s();
        }

        public x.a j()
        {
            return m();
        }

        protected p.g l()
        {
            return com.umeng.message.proguard.j.K().a(com/umeng/message/proguard/j$G$b, com/umeng/message/proguard/j$G$b$a);
        }

        public a m()
        {
            super.ah();
            b = "";
            a = a & -2;
            c = false;
            a = a & -3;
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

        public boolean r()
        {
            return c;
        }

        public a s()
        {
            return A().a(v());
        }

        public j.G.b t()
        {
            return j.G.b.h();
        }

        public j.G.b u()
        {
            j.G.b b1 = v();
            if (!b1.a())
            {
                throw b(b1);
            } else
            {
                return b1;
            }
        }

        public j.G.b v()
        {
            int i1 = 1;
            j.G.b b1 = new j.G.b(this, null);
            int k1 = a;
            int j1;
            if ((k1 & 1) != 1)
            {
                i1 = 0;
            }
            j.G.b.a(b1, b);
            j1 = i1;
            if ((k1 & 2) == 2)
            {
                j1 = i1 | 2;
            }
            j.G.b.a(b1, c);
            j.G.b.a(b1, j1);
            aB();
            return b1;
        }

        public a w()
        {
            a = a & -2;
            b = j.G.b.h().o();
            aF();
            return this;
        }

        public a x()
        {
            a = a & -3;
            c = false;
            aF();
            return this;
        }

        private a()
        {
            b = "";
            z();
        }

        private a(p.b b1)
        {
            super(b1);
            b = "";
            z();
        }

        a(p.b b1, j._cls1 _pcls1)
        {
            this(b1);
        }
    }


    public static B a = new c() {

        public j.G.b c(h h1, n n1)
            throws s
        {
            return new j.G.b(h1, n1, null);
        }

        public Object d(h h1, n n1)
            throws s
        {
            return c(h1, n1);
        }

    };
    public static final int b = 1;
    public static final int c = 2;
    private static final _cls1.c d;
    private static final long k = 0L;
    private final P e;
    private int f;
    private Object g;
    private boolean h;
    private byte i;
    private int j;

    static int a(a.aF af, int i1)
    {
        af.f = i1;
        return i1;
    }

    public static a a(f f1)
    {
        return s().a(f1);
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
        a1.g = obj;
        return obj;
    }

    static boolean a(g g1, boolean flag)
    {
        g1.h = flag;
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

    static Object b(a a1)
    {
        return a1.g;
    }

    public static g h()
    {
        return d;
    }

    public static final d k()
    {
        return com.umeng.message.proguard.j.J();
    }

    public static a s()
    {
        return a.y();
    }

    private void v()
    {
        g = "";
        h = false;
    }

    protected Object I()
        throws ObjectStreamException
    {
        return super.I();
    }

    public h M()
    {
        return u();
    }

    public u N()
    {
        return t();
    }

    public t O()
    {
        return u();
    }

    public u P()
    {
        return t();
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
        if ((f & 1) == 1)
        {
            i1.a(1, p());
        }
        if ((f & 2) == 2)
        {
            i1.a(2, h);
        }
        b_().a(i1);
    }

    public final boolean a()
    {
        byte byte0 = i;
        if (byte0 != -1)
        {
            return byte0 == 1;
        }
        if (!n())
        {
            i = 0;
            return false;
        }
        if (!q())
        {
            i = 0;
            return false;
        } else
        {
            i = 1;
            return true;
        }
    }

    protected i b(i i1)
    {
        return a(i1);
    }

    public final P b_()
    {
        return e;
    }

    public int d()
    {
        int i1 = j;
        if (i1 != -1)
        {
            return i1;
        }
        i1 = 0;
        if ((f & 1) == 1)
        {
            i1 = 0 + com.umeng.message.proguard.i.c(1, p());
        }
        int j1 = i1;
        if ((f & 2) == 2)
        {
            j1 = i1 + com.umeng.message.proguard.i.b(2, h);
        }
        i1 = j1 + b_().d();
        j = i1;
        return i1;
    }

    public j i()
    {
        return d;
    }

    protected d l()
    {
        return com.umeng.message.proguard.j.K().d(com/umeng/message/proguard/j$G$b, com/umeng/message/proguard/j$G$b$a);
    }

    public B m()
    {
        return a;
    }

    public boolean n()
    {
        return (f & 1) == 1;
    }

    public String o()
    {
        Object obj = g;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (g)obj;
        String s1 = ((g) (obj)).h();
        if (((g) (obj)).i())
        {
            g = s1;
        }
        return s1;
    }

    public g p()
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

    public boolean q()
    {
        return (f & 2) == 2;
    }

    public boolean r()
    {
        return h;
    }

    public a t()
    {
        return s();
    }

    public a u()
    {
        return a(this);
    }

    static 
    {
        d = new <init>(true);
        d.v();
    }

    private _cls1(h h1, n n1)
        throws s
    {
        _cls1 _lcls1;
        boolean flag;
        i = -1;
        j = -1;
        v();
        _lcls1 = com.umeng.message.proguard.P.b();
        flag = false;
_L8:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = h1.a();
        i1;
        JVM INSTR lookupswitch 3: default 184
    //                   0: 187
    //                   10: 90
    //                   16: 133;
           goto _L3 _L4 _L5 _L6
_L3:
        if (!a(h1, _lcls1, n1, i1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        f = f | 1;
        g = h1.l();
        continue; /* Loop/switch isn't completed */
        h1;
        throw h1.a(this);
        h1;
        e = _lcls1.e();
        ad();
        throw h1;
_L6:
        f = f | 2;
        h = h1.j();
        continue; /* Loop/switch isn't completed */
        h1;
        throw (new s(h1.getMessage())).a(this);
_L2:
        e = _lcls1.e();
        ad();
        return;
_L4:
        flag = true;
        if (true) goto _L8; else goto _L7
_L7:
    }

    ad(h h1, n n1, ad ad)
        throws s
    {
        this(h1, n1);
    }

    private <init>(<init> <init>1)
    {
        super(<init>1);
        i = -1;
        j = -1;
        e = <init>1.();
    }

    ( ,  1)
    {
        this();
    }

    private <init>(boolean flag)
    {
        i = -1;
        j = -1;
        e = com.umeng.message.proguard.P.c();
    }
}
