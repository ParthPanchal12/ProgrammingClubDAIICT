// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.umeng.message.proguard:
//            k, x

private static final class 
{
    private static final class a
    {

        private final k.h a;
        private final int b;

        public boolean equals(Object obj)
        {
            if (obj instanceof a)
            {
                if (a == ((a) (obj = (a)obj)).a && b == ((a) (obj)).b)
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

        a(k.h h, int i)
        {
            a = h;
            b = i;
        }
    }

    private static final class b
        implements k.h
    {

        private final String a;
        private final String b;
        private final k.g c;

        public String c()
        {
            return a;
        }

        public String d()
        {
            return b;
        }

        public k.g e()
        {
            return c;
        }

        public x l()
        {
            return c.a();
        }

        b(String s, String s1, k.g g)
        {
            c = g;
            b = s1;
            a = s;
        }
    }

    static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        private static final c d[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/umeng/message/proguard/k$b$c, s);
        }

        public static c[] values()
        {
            return (c[])d.clone();
        }

        static 
        {
            a = new c("TYPES_ONLY", 0);
            b = new c("AGGREGATES_ONLY", 1);
            c = new c("ALL_SYMBOLS", 2);
            d = (new c[] {
                a, b, c
            });
        }

        private c(String s, int i)
        {
            super(s, i);
        }
    }


    static final boolean a;
    private final Set b = new HashSet();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final Map e = new HashMap();

    static Map a(c c1)
    {
        return c1.d;
    }

    private void a(d d1)
    {
        d1 = d1.j().iterator();
        do
        {
            if (!d1.hasNext())
            {
                break;
            }
            d d2 = (j)d1.next();
            if (b.add(d2))
            {
                a(d2);
            }
        } while (true);
    }

    static Map b(a a1)
    {
        return a1.e;
    }

    static void d(e e1)
        throws e
    {
        String s = e1.c();
        if (s.length() == 0)
        {
            throw new <init>(e1, "Missing name.", null);
        }
        boolean flag = true;
        int i = 0;
        while (i < s.length()) 
        {
            char c1 = s.charAt(i);
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
                if (Character.isDigit(c1) && i > 0)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
            }
            i++;
        }
        if (!flag)
        {
            throw new <init>(e1, (new StringBuilder()).append('"').append(s).append("\" is not a valid identifier.").toString(), null);
        } else
        {
            return;
        }
    }

    g a(String s)
    {
        return a(s, c.c);
    }

    c a(String s, c c1)
    {
        c c3 = (c)c.get(s);
        if (c3 == null) goto _L2; else goto _L1
_L1:
        c c2 = c3;
        if (c1 == c.c) goto _L4; else goto _L3
_L3:
        if (c1 != c.a) goto _L6; else goto _L5
_L5:
        c2 = c3;
        if (a(c3)) goto _L4; else goto _L6
_L6:
        if (c1 != c.b || !b(c3)) goto _L2; else goto _L7
_L7:
        c2 = c3;
_L4:
        return c2;
_L2:
        Iterator iterator = b.iterator();
_L11:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_171;
            }
            c3 = (b)a((a)iterator.next()).c.get(s);
        } while (c3 == null);
        c2 = c3;
        if (c1 == c.c) goto _L4; else goto _L8
_L8:
        if (c1 != c.a)
        {
            break; /* Loop/switch isn't completed */
        }
        c2 = c3;
        if (a(c3)) goto _L4; else goto _L9
_L9:
        if (c1 != c.b || !b(c3)) goto _L11; else goto _L10
_L10:
        return c3;
        return null;
    }

    c a(String s, c c1, c c2)
        throws c
    {
        if (!s.startsWith(".")) goto _L2; else goto _L1
_L1:
        c2 = a(s.substring(1), c2);
_L4:
        String s1;
        StringBuilder stringbuilder;
        int i;
        int j;
        if (c2 == null)
        {
            throw new <init>(c1, (new StringBuilder()).append('"').append(s).append("\" is not defined.").toString(), null);
        } else
        {
            return c2;
        }
_L2:
        i = s.indexOf('.');
        if (i == -1)
        {
            s1 = s;
        } else
        {
            s1 = s.substring(0, i);
        }
        stringbuilder = new StringBuilder(c1.d());
_L5:
        j = stringbuilder.lastIndexOf(".");
        if (j == -1)
        {
            c2 = a(s, c2);
        } else
        {
label0:
            {
                stringbuilder.setLength(j + 1);
                stringbuilder.append(s1);
                c c3 = a(stringbuilder.toString(), c.b);
                if (c3 == null)
                {
                    break label0;
                }
                if (i != -1)
                {
                    stringbuilder.setLength(j + 1);
                    stringbuilder.append(s);
                    c2 = a(stringbuilder.toString(), c2);
                } else
                {
                    c2 = c3;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        stringbuilder.setLength(j);
          goto _L5
    }

    void a(th th)
    {
        a a1 = new a(th.g(), th.a());
        th = (a)e.put(a1, th);
        if (th != null)
        {
            e.put(a1, th);
        }
    }

    void a(e e1)
        throws a
    {
        a a1 = new a(e1.u(), e1.f());
        a a2 = (f)d.put(a1, e1);
        if (a2 != null)
        {
            d.put(a1, a2);
            throw new <init>(e1, (new StringBuilder()).append("Field number ").append(e1.f()).append("has already been used in \"").append(e1.u().d()).append("\" by field \"").append(a2.c()).append("\".").toString(), null);
        } else
        {
            return;
        }
    }

    void a(String s, g g)
        throws g
    {
        int i = s.lastIndexOf('.');
        String s1;
        g g1;
        if (i == -1)
        {
            s1 = s;
        } else
        {
            a(s.substring(0, i), g);
            s1 = s.substring(i + 1);
        }
        g1 = (a)c.put(s, new b(s1, s, g));
        if (g1 != null)
        {
            c.put(s, g1);
            if (!(g1 instanceof b))
            {
                throw new <init>(g, (new StringBuilder()).append('"').append(s1).append("\" is already defined (as something other than a ").append("package) in file \"").append(g1.e().b()).append("\".").toString(), null);
            }
        }
    }

    boolean a(g g)
    {
        return (g instanceof g) || (g instanceof g);
    }

    boolean b(g g)
    {
        return (g instanceof g) || (g instanceof g) || (g instanceof b) || (g instanceof b);
    }

    void c(b b1)
        throws b
    {
        d(b1);
        String s = b1.d();
        int i = s.lastIndexOf('.');
        b b2 = (d)c.put(s, b1);
        if (b2 != null)
        {
            c.put(s, b2);
            if (b1.e() == b2.e())
            {
                if (i == -1)
                {
                    throw new <init>(b1, (new StringBuilder()).append('"').append(s).append("\" is already defined.").toString(), null);
                } else
                {
                    throw new <init>(b1, (new StringBuilder()).append('"').append(s.substring(i + 1)).append("\" is already defined in \"").append(s.substring(0, i)).append("\".").toString(), null);
                }
            } else
            {
                throw new <init>(b1, (new StringBuilder()).append('"').append(s).append("\" is already defined in file \"").append(b2.e().b()).append("\".").toString(), null);
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

    c(c ac[])
    {
        for (int i = 0; i < ac.length; i++)
        {
            b.add(ac[i]);
            a(ac[i]);
        }

        for (ac = b.iterator(); ac.hasNext();)
        {
            c c1 = (b)ac.next();
            try
            {
                a(c1.c(), c1);
            }
            catch (c c2)
            {
                if (!a)
                {
                    throw new AssertionError();
                }
            }
        }

    }
}
