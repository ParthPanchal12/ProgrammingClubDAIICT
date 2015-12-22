// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.umeng.message.proguard:
//            x, s, m, N, 
//            y, g

public final class k
{
    public static final class a
        implements h
    {

        private final int a;
        private j.a b;
        private final String c;
        private final g d;
        private final a e;
        private final a f[];
        private final d g[];
        private final f h[];
        private final f i[];

        private void a(j.a a1)
        {
            boolean flag = false;
            b = a1;
            for (int i1 = 0; i1 < f.length; i1++)
            {
                f[i1].a(a1.e(i1));
            }

            for (int j1 = 0; j1 < g.length; j1++)
            {
                d.a(g[j1], a1.g(j1));
            }

            int k1 = 0;
            int l1;
            do
            {
                l1 = ((flag) ? 1 : 0);
                if (k1 >= h.length)
                {
                    break;
                }
                f.a(h[k1], a1.a(k1));
                k1++;
            } while (true);
            for (; l1 < i.length; l1++)
            {
                f.a(i[l1], a1.c(l1));
            }

        }

        static void a(a a1)
            throws c
        {
            a1.m();
        }

        static void a(a a1, j.a a2)
        {
            a1.a(a2);
        }

        private void m()
            throws c
        {
            boolean flag = false;
            Object aobj[] = f;
            int l1 = aobj.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                aobj[i1].m();
            }

            aobj = h;
            l1 = aobj.length;
            for (int j1 = 0; j1 < l1; j1++)
            {
                f.b(aobj[j1]);
            }

            aobj = i;
            l1 = aobj.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < l1; k1++)
            {
                f.b(aobj[k1]);
            }

        }

        public int a()
        {
            return a;
        }

        public f a(String s)
        {
            s = g.a(d).a((new StringBuilder()).append(c).append('.').append(s).toString());
            if (s != null && (s instanceof f))
            {
                return (f)s;
            } else
            {
                return null;
            }
        }

        public boolean a(int i1)
        {
            for (Iterator iterator = b.C().iterator(); iterator.hasNext();)
            {
                j.a.b b1 = (j.a.b)iterator.next();
                if (b1.o() <= i1 && i1 < b1.q())
                {
                    return true;
                }
            }

            return false;
        }

        public j.a b()
        {
            return b;
        }

        public a b(String s)
        {
            s = g.a(d).a((new StringBuilder()).append(c).append('.').append(s).toString());
            if (s != null && (s instanceof a))
            {
                return (a)s;
            } else
            {
                return null;
            }
        }

        public f b(int i1)
        {
            return (f)b.a(g.a(d)).get(new b.a(this, i1));
        }

        public d c(String s)
        {
            s = g.a(d).a((new StringBuilder()).append(c).append('.').append(s).toString());
            if (s != null && (s instanceof d))
            {
                return (d)s;
            } else
            {
                return null;
            }
        }

        public String c()
        {
            return b.o();
        }

        public String d()
        {
            return c;
        }

        public g e()
        {
            return d;
        }

        public a f()
        {
            return e;
        }

        public j.u g()
        {
            return b.G();
        }

        public List h()
        {
            return Collections.unmodifiableList(Arrays.asList(h));
        }

        public List i()
        {
            return Collections.unmodifiableList(Arrays.asList(i));
        }

        public List j()
        {
            return Collections.unmodifiableList(Arrays.asList(f));
        }

        public List k()
        {
            return Collections.unmodifiableList(Arrays.asList(g));
        }

        public x l()
        {
            return b();
        }

        private a(j.a a1, g g1, a a2, int i1)
            throws c
        {
            a = i1;
            b = a1;
            c = k.a(g1, a2, a1.o());
            d = g1;
            e = a2;
            f = new a[a1.y()];
            for (i1 = 0; i1 < a1.y(); i1++)
            {
                f[i1] = new a(a1.e(i1), g1, this, i1);
            }

            g = new d[a1.B()];
            for (i1 = 0; i1 < a1.B(); i1++)
            {
                g[i1] = new d(a1.g(i1), g1, this, i1);
            }

            h = new f[a1.s()];
            for (i1 = 0; i1 < a1.s(); i1++)
            {
                h[i1] = new f(a1.a(i1), g1, this, i1, false);
            }

            i = new f[a1.v()];
            for (i1 = 0; i1 < a1.v(); i1++)
            {
                i[i1] = new f(a1.c(i1), g1, this, i1, true);
            }

            g.a(g1).c(this);
        }

    }

    private static final class b
    {

        static final boolean a;
        private final Set b = new HashSet();
        private final Map c = new HashMap();
        private final Map d = new HashMap();
        private final Map e = new HashMap();

        static Map a(b b1)
        {
            return b1.d;
        }

        private void a(g g1)
        {
            g1 = g1.j().iterator();
            do
            {
                if (!g1.hasNext())
                {
                    break;
                }
                g g2 = (g)g1.next();
                if (b.add(g2))
                {
                    a(g2);
                }
            } while (true);
        }

        static Map b(b b1)
        {
            return b1.e;
        }

        static void d(h h1)
            throws c
        {
            String s = h1.c();
            if (s.length() == 0)
            {
                throw new c(h1, "Missing name.");
            }
            boolean flag = true;
            int l = 0;
            while (l < s.length()) 
            {
                char c1 = s.charAt(l);
                boolean flag1 = flag;
                if (c1 >= '\200')
                {
                    flag1 = false;
                }
                flag = flag1;
                if (Character.isLetter(c1))
                {
                    continue;
                }
                flag = flag1;
                if (c1 != '_')
                {
                    if (Character.isDigit(c1) && l > 0)
                    {
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                }
                l++;
            }
            if (!flag)
            {
                throw new c(h1, (new StringBuilder()).append('"').append(s).append("\" is not a valid identifier.").toString());
            } else
            {
                return;
            }
        }

        h a(String s)
        {
            return a(s, c.c);
        }

        h a(String s, c c1)
        {
            h h2 = (h)c.get(s);
            if (h2 == null) goto _L2; else goto _L1
_L1:
            h h1 = h2;
            if (c1 == c.c) goto _L4; else goto _L3
_L3:
            if (c1 != c.a) goto _L6; else goto _L5
_L5:
            h1 = h2;
            if (a(h2)) goto _L4; else goto _L6
_L6:
            if (c1 != c.b || !b(h2)) goto _L2; else goto _L7
_L7:
            h1 = h2;
_L4:
            return h1;
_L2:
            Iterator iterator = b.iterator();
_L11:
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_171;
                }
                h2 = (h)g.a((g)iterator.next()).c.get(s);
            } while (h2 == null);
            h1 = h2;
            if (c1 == c.c) goto _L4; else goto _L8
_L8:
            if (c1 != c.a)
            {
                break; /* Loop/switch isn't completed */
            }
            h1 = h2;
            if (a(h2)) goto _L4; else goto _L9
_L9:
            if (c1 != c.b || !b(h2)) goto _L11; else goto _L10
_L10:
            return h2;
            return null;
        }

        h a(String s, h h1, c c1)
            throws c
        {
            if (!s.startsWith(".")) goto _L2; else goto _L1
_L1:
            c1 = a(s.substring(1), c1);
_L4:
            String s1;
            StringBuilder stringbuilder;
            int l;
            int i1;
            if (c1 == null)
            {
                throw new c(h1, (new StringBuilder()).append('"').append(s).append("\" is not defined.").toString());
            } else
            {
                return c1;
            }
_L2:
            l = s.indexOf('.');
            if (l == -1)
            {
                s1 = s;
            } else
            {
                s1 = s.substring(0, l);
            }
            stringbuilder = new StringBuilder(h1.d());
_L5:
            i1 = stringbuilder.lastIndexOf(".");
            if (i1 == -1)
            {
                c1 = a(s, c1);
            } else
            {
label0:
                {
                    stringbuilder.setLength(i1 + 1);
                    stringbuilder.append(s1);
                    h h2 = a(stringbuilder.toString(), c.b);
                    if (h2 == null)
                    {
                        break label0;
                    }
                    if (l != -1)
                    {
                        stringbuilder.setLength(i1 + 1);
                        stringbuilder.append(s);
                        c1 = a(stringbuilder.toString(), c1);
                    } else
                    {
                        c1 = h2;
                    }
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
            stringbuilder.setLength(i1);
              goto _L5
        }

        void a(e e1)
        {
            a a1 = new a(e1.g(), e1.a());
            e1 = (e)e.put(a1, e1);
            if (e1 != null)
            {
                e.put(a1, e1);
            }
        }

        void a(f f1)
            throws c
        {
            a a1 = new a(f1.u(), f1.f());
            f f2 = (f)d.put(a1, f1);
            if (f2 != null)
            {
                d.put(a1, f2);
                throw new c(f1, (new StringBuilder()).append("Field number ").append(f1.f()).append("has already been used in \"").append(f1.u().d()).append("\" by field \"").append(f2.c()).append("\".").toString());
            } else
            {
                return;
            }
        }

        void a(String s, g g1)
            throws c
        {
            int l = s.lastIndexOf('.');
            String s1;
            h h1;
            if (l == -1)
            {
                s1 = s;
            } else
            {
                a(s.substring(0, l), g1);
                s1 = s.substring(l + 1);
            }
            h1 = (h)c.put(s, new b(s1, s, g1));
            if (h1 != null)
            {
                c.put(s, h1);
                if (!(h1 instanceof b))
                {
                    throw new c(g1, (new StringBuilder()).append('"').append(s1).append("\" is already defined (as something other than a ").append("package) in file \"").append(h1.e().b()).append("\".").toString());
                }
            }
        }

        boolean a(h h1)
        {
            return (h1 instanceof a) || (h1 instanceof d);
        }

        boolean b(h h1)
        {
            return (h1 instanceof a) || (h1 instanceof d) || (h1 instanceof b) || (h1 instanceof j);
        }

        void c(h h1)
            throws c
        {
            d(h1);
            String s = h1.d();
            int l = s.lastIndexOf('.');
            h h2 = (h)c.put(s, h1);
            if (h2 != null)
            {
                c.put(s, h2);
                if (h1.e() == h2.e())
                {
                    if (l == -1)
                    {
                        throw new c(h1, (new StringBuilder()).append('"').append(s).append("\" is already defined.").toString());
                    } else
                    {
                        throw new c(h1, (new StringBuilder()).append('"').append(s.substring(l + 1)).append("\" is already defined in \"").append(s.substring(0, l)).append("\".").toString());
                    }
                } else
                {
                    throw new c(h1, (new StringBuilder()).append('"').append(s).append("\" is already defined in file \"").append(h2.e().b()).append("\".").toString());
                }
            } else
            {
                return;
            }
        }

        static 
        {
            boolean flag;
            if (!com/umeng/message/proguard/k.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a = flag;
        }

        b(g ag[])
        {
            for (int l = 0; l < ag.length; l++)
            {
                b.add(ag[l]);
                a(ag[l]);
            }

            for (ag = b.iterator(); ag.hasNext();)
            {
                g g1 = (g)ag.next();
                try
                {
                    a(g1.c(), g1);
                }
                catch (c c1)
                {
                    if (!a)
                    {
                        throw new AssertionError();
                    }
                }
            }

        }
    }

    private static final class b.a
    {

        private final h a;
        private final int b;

        public boolean equals(Object obj)
        {
            if (obj instanceof b.a)
            {
                if (a == ((b.a) (obj = (b.a)obj)).a && b == ((b.a) (obj)).b)
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return a.hashCode() * 65535 + b;
        }

        b.a(h h1, int l)
        {
            a = h1;
            b = l;
        }
    }

    private static final class b.b
        implements h
    {

        private final String a;
        private final String b;
        private final g c;

        public String c()
        {
            return a;
        }

        public String d()
        {
            return b;
        }

        public g e()
        {
            return c;
        }

        public x l()
        {
            return c.a();
        }

        b.b(String s, String s1, g g1)
        {
            c = g1;
            b = s1;
            a = s;
        }
    }

    static final class b.c extends Enum
    {

        public static final b.c a;
        public static final b.c b;
        public static final b.c c;
        private static final b.c d[];

        public static b.c valueOf(String s)
        {
            return (b.c)Enum.valueOf(com/umeng/message/proguard/k$b$c, s);
        }

        public static b.c[] values()
        {
            return (b.c[])d.clone();
        }

        static 
        {
            a = new b.c("TYPES_ONLY", 0);
            b = new b.c("AGGREGATES_ONLY", 1);
            c = new b.c("ALL_SYMBOLS", 2);
            d = (new b.c[] {
                a, b, c
            });
        }

        private b.c(String s, int l)
        {
            super(s, l);
        }
    }

    public static class c extends Exception
    {

        private static final long a = 0x4fccd5afd98283ccL;
        private final String b;
        private final x c;
        private final String d;

        public String a()
        {
            return b;
        }

        public x b()
        {
            return c;
        }

        public String c()
        {
            return d;
        }

        private c(g g1, String s)
        {
            super((new StringBuilder()).append(g1.b()).append(": ").append(s).toString());
            b = g1.b();
            c = g1.a();
            d = s;
        }


        private c(h h1, String s)
        {
            super((new StringBuilder()).append(h1.d()).append(": ").append(s).toString());
            b = h1.d();
            c = h1.l();
            d = s;
        }


        private c(h h1, String s, Throwable throwable)
        {
            this(h1, s);
            initCause(throwable);
        }

    }

    public static final class d
        implements h, r.b
    {

        private final int a;
        private j.c b;
        private final String c;
        private final g d;
        private final a e;
        private e f[];

        private void a(j.c c1)
        {
            b = c1;
            for (int i1 = 0; i1 < f.length; i1++)
            {
                e.a(f[i1], c1.a(i1));
            }

        }

        static void a(d d1, j.c c1)
        {
            d1.a(c1);
        }

        public int a()
        {
            return a;
        }

        public e a(int i1)
        {
            return (e)b.b(g.a(d)).get(new b.a(this, i1));
        }

        public e a(String s)
        {
            s = g.a(d).a((new StringBuilder()).append(c).append('.').append(s).toString());
            if (s != null && (s instanceof e))
            {
                return (e)s;
            } else
            {
                return null;
            }
        }

        public j.c b()
        {
            return b;
        }

        public r.a b(int i1)
        {
            return a(i1);
        }

        public String c()
        {
            return b.o();
        }

        public String d()
        {
            return c;
        }

        public g e()
        {
            return d;
        }

        public a f()
        {
            return e;
        }

        public j.e g()
        {
            return b.u();
        }

        public List h()
        {
            return Collections.unmodifiableList(Arrays.asList(f));
        }

        public x l()
        {
            return b();
        }

        private d(j.c c1, g g1, a a1, int i1)
            throws c
        {
            a = i1;
            b = c1;
            c = k.a(g1, a1, c1.o());
            d = g1;
            e = a1;
            if (c1.s() == 0)
            {
                throw new c(this, "Enums must contain at least one value.");
            }
            f = new e[c1.s()];
            for (i1 = 0; i1 < c1.s(); i1++)
            {
                f[i1] = new e(c1.a(i1), g1, this, i1);
            }

            g.a(g1).c(this);
        }

    }

    public static final class e
        implements h, r.a
    {

        private final int a;
        private j.g b;
        private final String c;
        private final g d;
        private final d e;

        private void a(j.g g1)
        {
            b = g1;
        }

        static void a(e e1, j.g g1)
        {
            e1.a(g1);
        }

        public int a()
        {
            return b.r();
        }

        public int b()
        {
            return a;
        }

        public String c()
        {
            return b.o();
        }

        public String d()
        {
            return c;
        }

        public g e()
        {
            return d;
        }

        public j.g f()
        {
            return b;
        }

        public d g()
        {
            return e;
        }

        public j.i h()
        {
            return b.t();
        }

        public x l()
        {
            return f();
        }

        private e(j.g g1, g g2, d d1, int i1)
            throws c
        {
            a = i1;
            b = g1;
            d = g2;
            e = d1;
            c = (new StringBuilder()).append(d1.d()).append('.').append(g1.o()).toString();
            g.a(g2).c(this);
            g.a(g2).a(this);
        }

    }

    public static final class f
        implements h, o.a, Comparable
    {

        private static final S.a a[] = S.a.values();
        private final int b;
        private j.k c;
        private final String d;
        private final g e;
        private final a f;
        private b g;
        private a h;
        private a i;
        private d j;
        private Object k;

        private void a(j.k k1)
        {
            c = k1;
        }

        static void a(f f1, j.k k1)
        {
            f1.a(k1);
        }

        static void b(f f1)
            throws c
        {
            f1.z();
        }

        private void z()
            throws c
        {
            if (c.z())
            {
                h h1 = g.a(e).a(c.A(), this, b.c.a);
                if (!(h1 instanceof a))
                {
                    throw new c(this, (new StringBuilder()).append('"').append(c.A()).append("\" is not a message type.").toString());
                }
                h = (a)h1;
                if (!u().a(f()))
                {
                    throw new c(this, (new StringBuilder()).append('"').append(u().d()).append("\" does not declare ").append(f()).append(" as an extension number.").toString());
                }
            }
            if (!c.w()) goto _L2; else goto _L1
_L1:
            h h2;
            h2 = g.a(e).a(c.x(), this, b.c.a);
            if (!c.u())
            {
                if (h2 instanceof a)
                {
                    g = b.k;
                } else
                if (h2 instanceof d)
                {
                    g = b.n;
                } else
                {
                    throw new c(this, (new StringBuilder()).append('"').append(c.x()).append("\" is not a type.").toString());
                }
            }
            if (g() != a.i) goto _L4; else goto _L3
_L3:
            if (!(h2 instanceof a))
            {
                throw new c(this, (new StringBuilder()).append('"').append(c.x()).append("\" is not a message type.").toString());
            }
            i = (a)h2;
            if (c.C())
            {
                throw new c(this, "Messages can't have default values.");
            }
              goto _L5
_L4:
            if (g() != a.h) goto _L7; else goto _L6
_L6:
            if (!(h2 instanceof d))
            {
                throw new c(this, (new StringBuilder()).append('"').append(c.x()).append("\" is not an enum type.").toString());
            }
            j = (d)h2;
              goto _L5
_L7:
            throw new c(this, "Field with primitive type has type_name.");
_L2:
            if (g() == a.i || g() == a.h)
            {
                throw new c(this, "Field with message or enum type missing type_name.");
            }
            if (true) goto _L5; else goto _L8
_L5:
            static class _cls1
            {

                static final int a[];
                static final int b[];

                static 
                {
                    b = new int[f.a.values().length];
                    try
                    {
                        b[f.a.h.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror19) { }
                    try
                    {
                        b[f.a.i.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror18) { }
                    a = new int[f.b.values().length];
                    try
                    {
                        a[f.b.e.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror17) { }
                    try
                    {
                        a[f.b.q.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror16) { }
                    try
                    {
                        a[f.b.o.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror15) { }
                    try
                    {
                        a[f.b.m.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror14) { }
                    try
                    {
                        a[f.b.g.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        a[f.b.c.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        a[f.b.r.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        a[f.b.p.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        a[f.b.d.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        a[f.b.f.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        a[f.b.b.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        a[f.b.a.ordinal()] = 12;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        a[f.b.h.ordinal()] = 13;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        a[f.b.i.ordinal()] = 14;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        a[f.b.l.ordinal()] = 15;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[f.b.n.ordinal()] = 16;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[f.b.k.ordinal()] = 17;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[f.b.j.ordinal()] = 18;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            if (!c.C())
            {
                break; /* Loop/switch isn't completed */
            }
            if (n())
            {
                throw new c(this, "Repeated fields cannot have default values.", null);
            }
            int i1;
            try
            {
                i1 = _cls1.a[i().ordinal()];
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new c(this, (new StringBuilder()).append("Could not parse default value: \"").append(c.D()).append('"').toString(), numberformatexception, null);
            }
            i1;
            JVM INSTR tableswitch 1 18: default 592
        //                       1 667
        //                       2 667
        //                       3 667
        //                       4 730
        //                       5 730
        //                       6 750
        //                       7 750
        //                       8 750
        //                       9 770
        //                       10 770
        //                       11 790
        //                       12 894
        //                       13 998
        //                       14 1015
        //                       15 1029
        //                       16 1081
        //                       17 1147
        //                       18 1147;
               goto _L9 _L10 _L10 _L10 _L11 _L11 _L12 _L12 _L12 _L13 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L20
_L9:
            if (!t())
            {
                g.a(e).a(this);
            }
            N.a a1;
            if (h != null && h.g().o())
            {
                if (t())
                {
                    if (!m() || i() != b.k)
                    {
                        throw new c(this, "Extensions of MessageSets must be optional messages.", null);
                    }
                } else
                {
                    throw new c(this, "MessageSets cannot have fields, only extensions.", null);
                }
            }
            break; /* Loop/switch isn't completed */
_L10:
            k = Integer.valueOf(N.c(c.D()));
            continue; /* Loop/switch isn't completed */
_L11:
            k = Integer.valueOf(N.d(c.D()));
            continue; /* Loop/switch isn't completed */
_L12:
            k = Long.valueOf(N.e(c.D()));
            continue; /* Loop/switch isn't completed */
_L13:
            k = Long.valueOf(N.f(c.D()));
            continue; /* Loop/switch isn't completed */
_L14:
            if (c.D().equals("inf"))
            {
                k = Float.valueOf((1.0F / 0.0F));
                continue; /* Loop/switch isn't completed */
            }
            if (c.D().equals("-inf"))
            {
                k = Float.valueOf((-1.0F / 0.0F));
                continue; /* Loop/switch isn't completed */
            }
            if (c.D().equals("nan"))
            {
                k = Float.valueOf((0.0F / 0.0F));
                continue; /* Loop/switch isn't completed */
            }
            k = Float.valueOf(c.D());
            continue; /* Loop/switch isn't completed */
_L15:
            if (c.D().equals("inf"))
            {
                k = Double.valueOf((1.0D / 0.0D));
                continue; /* Loop/switch isn't completed */
            }
            if (c.D().equals("-inf"))
            {
                k = Double.valueOf((-1.0D / 0.0D));
                continue; /* Loop/switch isn't completed */
            }
            if (c.D().equals("nan"))
            {
                k = Double.valueOf((0.0D / 0.0D));
                continue; /* Loop/switch isn't completed */
            }
            k = Double.valueOf(c.D());
            continue; /* Loop/switch isn't completed */
_L16:
            k = Boolean.valueOf(c.D());
            continue; /* Loop/switch isn't completed */
_L17:
            k = c.D();
            continue; /* Loop/switch isn't completed */
_L18:
            k = N.a(c.D());
            continue; /* Loop/switch isn't completed */
            a1;
            throw new c(this, (new StringBuilder()).append("Couldn't parse default value: ").append(a1.getMessage()).toString(), a1, null);
_L19:
            k = j.a(c.D());
            if (k == null)
            {
                throw new c(this, (new StringBuilder()).append("Unknown enum default value: \"").append(c.D()).append('"').toString(), null);
            }
            continue; /* Loop/switch isn't completed */
_L20:
            throw new c(this, "Message type had default value.", null);
_L8:
            if (n())
            {
                k = Collections.emptyList();
                continue; /* Loop/switch isn't completed */
            }
            switch (_cls1.b[g().ordinal()])
            {
            default:
                k = a.a(g());
                break;

            case 1: // '\001'
                k = j.h().get(0);
                break;

            case 2: // '\002'
                k = null;
                break;
            }
            if (true) goto _L9; else goto _L21
_L21:
        }

        public int a()
        {
            return b;
        }

        public int a(f f1)
        {
            if (f1.h != h)
            {
                throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
            } else
            {
                return f() - f1.f();
            }
        }

        public y.a a(y.a a1, y y1)
        {
            return ((x.a)a1).c((x)y1);
        }

        public j.k b()
        {
            return c;
        }

        public String c()
        {
            return c.o();
        }

        public int compareTo(Object obj)
        {
            return a((f)obj);
        }

        public String d()
        {
            return d;
        }

        public g e()
        {
            return e;
        }

        public int f()
        {
            return c.r();
        }

        public a g()
        {
            return g.b();
        }

        public S.b h()
        {
            return j().a();
        }

        public b i()
        {
            return g;
        }

        public S.a j()
        {
            return a[g.ordinal()];
        }

        public boolean k()
        {
            return c.t() == j.k.b.b;
        }

        public x l()
        {
            return b();
        }

        public boolean m()
        {
            return c.t() == j.k.b.a;
        }

        public boolean n()
        {
            return c.t() == j.k.b.c;
        }

        public boolean o()
        {
            return s().q();
        }

        public boolean p()
        {
            return n() && j().c();
        }

        public boolean q()
        {
            return c.C();
        }

        public Object r()
        {
            if (g() == a.i)
            {
                throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
            } else
            {
                return k;
            }
        }

        public j.m s()
        {
            return c.G();
        }

        public boolean t()
        {
            return c.z();
        }

        public a u()
        {
            return h;
        }

        public a v()
        {
            if (!t())
            {
                throw new UnsupportedOperationException("This field is not an extension.");
            } else
            {
                return f;
            }
        }

        public a w()
        {
            if (g() != a.i)
            {
                throw new UnsupportedOperationException("This field is not of message type.");
            } else
            {
                return i;
            }
        }

        public d x()
        {
            if (g() != a.h)
            {
                throw new UnsupportedOperationException("This field is not of enum type.");
            } else
            {
                return j;
            }
        }

        public r.b y()
        {
            return x();
        }

        static 
        {
            if (b.values().length != com.umeng.message.proguard.j.k.c.values().length)
            {
                throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
            }
        }

        private f(j.k k1, g g1, a a1, int i1, boolean flag)
            throws c
        {
            b = i1;
            c = k1;
            d = k.a(g1, a1, k1.o());
            e = g1;
            if (k1.u())
            {
                g = b.a(k1.v());
            }
            if (f() <= 0)
            {
                throw new c(this, "Field numbers must be positive integers.");
            }
            if (k1.G().q() && !p())
            {
                throw new c(this, "[packed = true] can only be specified for repeated primitive fields.");
            }
            if (flag)
            {
                if (!k1.z())
                {
                    throw new c(this, "FieldDescriptorProto.extendee not set for extension field.");
                }
                h = null;
                if (a1 != null)
                {
                    f = a1;
                } else
                {
                    f = null;
                }
            } else
            {
                if (k1.z())
                {
                    throw new c(this, "FieldDescriptorProto.extendee set for non-extension field.");
                }
                h = a1;
                f = null;
            }
            g.a(g1).c(this);
        }

    }

    public static final class f.a extends Enum
    {

        public static final f.a a;
        public static final f.a b;
        public static final f.a c;
        public static final f.a d;
        public static final f.a e;
        public static final f.a f;
        public static final f.a g;
        public static final f.a h;
        public static final f.a i;
        private static final f.a k[];
        private final Object j;

        static Object a(f.a a1)
        {
            return a1.j;
        }

        public static f.a valueOf(String s)
        {
            return (f.a)Enum.valueOf(com/umeng/message/proguard/k$f$a, s);
        }

        public static f.a[] values()
        {
            return (f.a[])k.clone();
        }

        static 
        {
            a = new f.a("INT", 0, Integer.valueOf(0));
            b = new f.a("LONG", 1, Long.valueOf(0L));
            c = new f.a("FLOAT", 2, Float.valueOf(0.0F));
            d = new f.a("DOUBLE", 3, Double.valueOf(0.0D));
            e = new f.a("BOOLEAN", 4, Boolean.valueOf(false));
            f = new f.a("STRING", 5, "");
            g = new f.a("BYTE_STRING", 6, com.umeng.message.proguard.g.d);
            h = new f.a("ENUM", 7, null);
            i = new f.a("MESSAGE", 8, null);
            k = (new f.a[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private f.a(String s, int l, Object obj)
        {
            super(s, l);
            j = obj;
        }
    }

    public static final class f.b extends Enum
    {

        public static final f.b a;
        public static final f.b b;
        public static final f.b c;
        public static final f.b d;
        public static final f.b e;
        public static final f.b f;
        public static final f.b g;
        public static final f.b h;
        public static final f.b i;
        public static final f.b j;
        public static final f.b k;
        public static final f.b l;
        public static final f.b m;
        public static final f.b n;
        public static final f.b o;
        public static final f.b p;
        public static final f.b q;
        public static final f.b r;
        private static final f.b t[];
        private f.a s;

        public static f.b a(j.k.c c1)
        {
            return values()[c1.a() - 1];
        }

        public static f.b valueOf(String s1)
        {
            return (f.b)Enum.valueOf(com/umeng/message/proguard/k$f$b, s1);
        }

        public static f.b[] values()
        {
            return (f.b[])t.clone();
        }

        public j.k.c a()
        {
            return com.umeng.message.proguard.j.k.c.a(ordinal() + 1);
        }

        public f.a b()
        {
            return s;
        }

        static 
        {
            a = new f.b("DOUBLE", 0, f.a.d);
            b = new f.b("FLOAT", 1, f.a.c);
            c = new f.b("INT64", 2, f.a.b);
            d = new f.b("UINT64", 3, f.a.b);
            e = new f.b("INT32", 4, f.a.a);
            f = new f.b("FIXED64", 5, f.a.b);
            g = new f.b("FIXED32", 6, f.a.a);
            h = new f.b("BOOL", 7, f.a.e);
            i = new f.b("STRING", 8, f.a.f);
            j = new f.b("GROUP", 9, f.a.i);
            k = new f.b("MESSAGE", 10, f.a.i);
            l = new f.b("BYTES", 11, f.a.g);
            m = new f.b("UINT32", 12, f.a.a);
            n = new f.b("ENUM", 13, f.a.h);
            o = new f.b("SFIXED32", 14, f.a.a);
            p = new f.b("SFIXED64", 15, f.a.b);
            q = new f.b("SINT32", 16, f.a.a);
            r = new f.b("SINT64", 17, f.a.b);
            t = (new f.b[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r
            });
        }

        private f.b(String s1, int i1, f.a a1)
        {
            super(s1, i1);
            s = a1;
        }
    }

    public static final class g
    {

        private j.o a;
        private final a b[];
        private final d c[];
        private final j d[];
        private final f e[];
        private final g f[];
        private final g g[];
        private final b h;

        static b a(g g1)
        {
            return g1.h;
        }

        public static g a(j.o o, g ag[])
            throws c
        {
            g g1 = new g(o, ag, new b(ag));
            if (ag.length != o.u())
            {
                throw new c(g1, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", null);
            }
            for (int l = 0; l < o.u(); l++)
            {
                if (!ag[l].b().equals(o.a(l)))
                {
                    throw new c(g1, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", null);
                }
            }

            g1.k();
            return g1;
        }

        private void a(j.o o)
        {
            boolean flag = false;
            a = o;
            for (int l = 0; l < b.length; l++)
            {
                a.a(b[l], o.e(l));
            }

            for (int i1 = 0; i1 < c.length; i1++)
            {
                d.a(c[i1], o.g(i1));
            }

            int j1 = 0;
            int k1;
            do
            {
                k1 = ((flag) ? 1 : 0);
                if (j1 >= d.length)
                {
                    break;
                }
                j.a(d[j1], o.i(j1));
                j1++;
            } while (true);
            for (; k1 < e.length; k1++)
            {
                f.a(e[k1], o.k(k1));
            }

        }

        public static void a(String as[], g ag[], a a1)
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
                obj = com.umeng.message.proguard.j.o.a(as);
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", as);
            }
            try
            {
                ag = a(((j.o) (obj)), ag);
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid embedded descriptor for \"").append(((j.o) (obj)).o()).append("\".").toString(), as);
            }
            a1 = a1.a(ag);
            if (a1 != null)
            {
                try
                {
                    as = com.umeng.message.proguard.j.o.a(as, a1);
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", as);
                }
                ag.a(((j.o) (as)));
            }
        }

        private void k()
            throws c
        {
            boolean flag = false;
            Object aobj[] = b;
            int k1 = aobj.length;
            for (int l = 0; l < k1; l++)
            {
                a.a(aobj[l]);
            }

            aobj = d;
            k1 = aobj.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                j.a(aobj[i1]);
            }

            aobj = e;
            k1 = aobj.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < k1; j1++)
            {
                f.b(aobj[j1]);
            }

        }

        public j.o a()
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
                return (a)s1;
            } else
            {
                return null;
            }
        }

        public d b(String s1)
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
            if (s1 != null && (s1 instanceof d) && s1.e() == this)
            {
                return (d)s1;
            } else
            {
                return null;
            }
        }

        public String b()
        {
            return a.o();
        }

        public j c(String s1)
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
            if (s1 != null && (s1 instanceof j) && s1.e() == this)
            {
                return (j)s1;
            } else
            {
                return null;
            }
        }

        public String c()
        {
            return a.r();
        }

        public j.s d()
        {
            return a.U();
        }

        public f d(String s1)
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
            if (s1 != null && (s1 instanceof f) && s1.e() == this)
            {
                return (f)s1;
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

        private g(j.o o, g ag[], b b1)
            throws c
        {
            h = b1;
            a = o;
            f = (g[])ag.clone();
            g = new g[o.w()];
            for (int l = 0; l < o.w(); l++)
            {
                int i2 = o.c(l);
                if (i2 < 0 || i2 >= f.length)
                {
                    throw new c(this, "Invalid public dependency index.");
                }
                g[l] = f[o.c(l)];
            }

            b1.a(c(), this);
            b = new a[o.B()];
            for (int i1 = 0; i1 < o.B(); i1++)
            {
                b[i1] = new a(o.e(i1), this, null, i1);
            }

            c = new d[o.E()];
            for (int j1 = 0; j1 < o.E(); j1++)
            {
                c[j1] = new d(o.g(j1), this, null, j1);
            }

            d = new j[o.H()];
            for (int k1 = 0; k1 < o.H(); k1++)
            {
                d[k1] = new j(o.i(k1), this, k1);
            }

            e = new f[o.S()];
            for (int l1 = 0; l1 < o.S(); l1++)
            {
                e[l1] = new f(o.k(l1), this, null, l1, true);
            }

        }
    }

    public static interface g.a
    {

        public abstract m a(g g1);
    }

    private static interface h
    {

        public abstract String c();

        public abstract String d();

        public abstract g e();

        public abstract x l();
    }

    public static final class i
        implements h
    {

        private final int a;
        private j.w b;
        private final String c;
        private final g d;
        private final j e;
        private a f;
        private a g;

        private void a(j.w w)
        {
            b = w;
        }

        static void a(i i1)
            throws c
        {
            i1.j();
        }

        static void a(i i1, j.w w)
        {
            i1.a(w);
        }

        private void j()
            throws c
        {
            h h1 = g.a(d).a(b.r(), this, b.c.a);
            if (!(h1 instanceof a))
            {
                throw new c(this, (new StringBuilder()).append('"').append(b.r()).append("\" is not a message type.").toString(), null);
            }
            f = (a)h1;
            h1 = g.a(d).a(b.u(), this, b.c.a);
            if (!(h1 instanceof a))
            {
                throw new c(this, (new StringBuilder()).append('"').append(b.u()).append("\" is not a message type.").toString(), null);
            } else
            {
                g = (a)h1;
                return;
            }
        }

        public int a()
        {
            return a;
        }

        public j.w b()
        {
            return b;
        }

        public String c()
        {
            return b.o();
        }

        public String d()
        {
            return c;
        }

        public g e()
        {
            return d;
        }

        public j f()
        {
            return e;
        }

        public a g()
        {
            return f;
        }

        public a h()
        {
            return g;
        }

        public j.y i()
        {
            return b.x();
        }

        public x l()
        {
            return b();
        }

        private i(j.w w, g g1, j j1, int i1)
            throws c
        {
            a = i1;
            b = w;
            d = g1;
            e = j1;
            c = (new StringBuilder()).append(j1.d()).append('.').append(w.o()).toString();
            g.a(g1).c(this);
        }

    }

    public static final class j
        implements h
    {

        private final int a;
        private j.A b;
        private final String c;
        private final g d;
        private i e[];

        private void a(j.A a1)
        {
            b = a1;
            for (int i1 = 0; i1 < e.length; i1++)
            {
                i.a(e[i1], a1.a(i1));
            }

        }

        static void a(j j1)
            throws c
        {
            j1.h();
        }

        static void a(j j1, j.A a1)
        {
            j1.a(a1);
        }

        private void h()
            throws c
        {
            i ai[] = e;
            int j1 = ai.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                i.a(ai[i1]);
            }

        }

        public int a()
        {
            return a;
        }

        public i a(String s)
        {
            s = g.a(d).a((new StringBuilder()).append(c).append('.').append(s).toString());
            if (s != null && (s instanceof i))
            {
                return (i)s;
            } else
            {
                return null;
            }
        }

        public j.A b()
        {
            return b;
        }

        public String c()
        {
            return b.o();
        }

        public String d()
        {
            return c;
        }

        public g e()
        {
            return d;
        }

        public j.C f()
        {
            return b.u();
        }

        public List g()
        {
            return Collections.unmodifiableList(Arrays.asList(e));
        }

        public x l()
        {
            return b();
        }

        private j(j.A a1, g g1, int i1)
            throws c
        {
            a = i1;
            b = a1;
            c = k.a(g1, null, a1.o());
            d = g1;
            e = new i[a1.s()];
            for (i1 = 0; i1 < a1.s(); i1++)
            {
                e[i1] = new i(a1.a(i1), g1, this, i1);
            }

            g.a(g1).c(this);
        }

    }


    public k()
    {
    }

    static String a(g g1, a a1, String s)
    {
        return b(g1, a1, s);
    }

    private static String b(g g1, a a1, String s)
    {
        if (a1 != null)
        {
            a1 = (new StringBuilder()).append(a1.d()).append('.').append(s).toString();
        } else
        {
            a1 = s;
            if (g1.c().length() > 0)
            {
                return (new StringBuilder()).append(g1.c()).append('.').append(s).toString();
            }
        }
        return a1;
    }
}
