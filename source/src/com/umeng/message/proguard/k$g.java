// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            k, s, m

public static final class k
{
    public static interface a
    {

        public abstract m a(k.g g1);
    }


    private g a;
    private final g b[];
    private final g c[];
    private final g d[];
    private final g e[];
    private final g f[];
    private final g g[];
    private final g h;

    static a a(a a1)
    {
        return a1.h;
    }

    public static h a(h h1, h ah[])
        throws h
    {
        h h2 = new <init>(h1, ah, new <init>(ah));
        if (ah.length != h1.u())
        {
            throw new <init>(h2, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", null);
        }
        for (int l = 0; l < h1.u(); l++)
        {
            if (!ah[l].b().equals(h1.a(l)))
            {
                throw new <init>(h2, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", null);
            }
        }

        h2.k();
        return h2;
    }

    private void a(k k1)
    {
        boolean flag = false;
        a = k1;
        for (int l = 0; l < b.length; l++)
        {
            a(b[l], k1.e(l));
        }

        for (int i1 = 0; i1 < c.length; i1++)
        {
            a(c[i1], k1.g(i1));
        }

        int j1 = 0;
        int l1;
        do
        {
            l1 = ((flag) ? 1 : 0);
            if (j1 >= d.length)
            {
                break;
            }
            a(d[j1], k1.i(j1));
            j1++;
        } while (true);
        for (; l1 < e.length; l1++)
        {
            a(e[l1], k1.k(l1));
        }

    }

    public static void a(String as[], a aa[], a a1)
    {
        Object obj = new StringBuilder();
        int i1 = as.length;
        for (int l = 0; l < i1; l++)
        {
            ((StringBuilder) (obj)).append(as[l]);
        }

        try
        {
            as = ((StringBuilder) (obj)).toString().getBytes("ISO-8859-1");
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            throw new RuntimeException("Standard encoding ISO-8859-1 not supported by JVM.", as);
        }
        try
        {
            obj = a(as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", as);
        }
        try
        {
            aa = a(((a) (obj)), aa);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid embedded descriptor for \"").append(((ion) (obj)).o()).append("\".").toString(), as);
        }
        a1 = a1.a(aa);
        if (a1 != null)
        {
            try
            {
                as = a(as, a1);
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", as);
            }
            aa.a(((a) (as)));
        }
    }

    private void k()
        throws a
    {
        boolean flag = false;
        Object aobj[] = b;
        int k1 = aobj.length;
        for (int l = 0; l < k1; l++)
        {
            a(aobj[l]);
        }

        aobj = d;
        k1 = aobj.length;
        for (int i1 = 0; i1 < k1; i1++)
        {
            a(aobj[i1]);
        }

        aobj = e;
        k1 = aobj.length;
        for (int j1 = ((flag) ? 1 : 0); j1 < k1; j1++)
        {
            b(aobj[j1]);
        }

    }

    public b a()
    {
        return a;
    }

    public a a(String s1)
    {
        if (s1.indexOf('.') != -1)
        {
            return null;
        }
        String s2 = s1;
        if (c().length() > 0)
        {
            s2 = (new StringBuilder()).append(c()).append('.').append(s1).toString();
        }
        s1 = h.a(s2);
        if (s1 != null && (s1 instanceof a) && s1.e() == this)
        {
            return (e)s1;
        } else
        {
            return null;
        }
    }

    public e b(String s1)
    {
        if (s1.indexOf('.') != -1)
        {
            return null;
        }
        String s2 = s1;
        if (c().length() > 0)
        {
            s2 = (new StringBuilder()).append(c()).append('.').append(s1).toString();
        }
        s1 = h.a(s2);
        if (s1 != null && (s1 instanceof a) && s1.e() == this)
        {
            return (e)s1;
        } else
        {
            return null;
        }
    }

    public String b()
    {
        return a.o();
    }

    public o c(String s1)
    {
        if (s1.indexOf('.') != -1)
        {
            return null;
        }
        String s2 = s1;
        if (c().length() > 0)
        {
            s2 = (new StringBuilder()).append(c()).append('.').append(s1).toString();
        }
        s1 = h.a(s2);
        if (s1 != null && (s1 instanceof a) && s1.e() == this)
        {
            return (e)s1;
        } else
        {
            return null;
        }
    }

    public String c()
    {
        return a.r();
    }

    public r d()
    {
        return a.U();
    }

    public U d(String s1)
    {
        if (s1.indexOf('.') != -1)
        {
            return null;
        }
        String s2 = s1;
        if (c().length() > 0)
        {
            s2 = (new StringBuilder()).append(c()).append('.').append(s1).toString();
        }
        s1 = h.a(s2);
        if (s1 != null && (s1 instanceof a) && s1.e() == this)
        {
            return (e)s1;
        } else
        {
            return null;
        }
    }

    public List e()
    {
        return Collections.unmodifiableList(Arrays.asList(b));
    }

    public List f()
    {
        return Collections.unmodifiableList(Arrays.asList(c));
    }

    public List g()
    {
        return Collections.unmodifiableList(Arrays.asList(d));
    }

    public List h()
    {
        return Collections.unmodifiableList(Arrays.asList(e));
    }

    public List i()
    {
        return Collections.unmodifiableList(Arrays.asList(f));
    }

    public List j()
    {
        return Collections.unmodifiableList(Arrays.asList(g));
    }

    private a(a a1, a aa[], a a2)
        throws a
    {
        h = a2;
        a = a1;
        f = (f[])aa.clone();
        g = new g[a1.w()];
        for (int l = 0; l < a1.w(); l++)
        {
            int i2 = a1.c(l);
            if (i2 < 0 || i2 >= f.length)
            {
                throw new <init>(this, "Invalid public dependency index.", null);
            }
            g[l] = f[a1.c(l)];
        }

        a2.a(c(), this);
        b = new b[a1.B()];
        for (int i1 = 0; i1 < a1.B(); i1++)
        {
            b[i1] = new <init>(a1.e(i1), this, null, i1, null);
        }

        c = new c[a1.E()];
        for (int j1 = 0; j1 < a1.E(); j1++)
        {
            c[j1] = new <init>(a1.g(j1), this, null, j1, null);
        }

        d = new d[a1.H()];
        for (int k1 = 0; k1 < a1.H(); k1++)
        {
            d[k1] = new <init>(a1.i(k1), this, k1, null);
        }

        e = new e[a1.S()];
        for (int l1 = 0; l1 < a1.S(); l1++)
        {
            e[l1] = new <init>(a1.k(l1), this, null, l1, true, null);
        }

    }
}
