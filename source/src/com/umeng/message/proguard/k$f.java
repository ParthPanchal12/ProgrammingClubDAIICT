// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            k, N, x, y, 
//            g

public static final class <init>
    implements <init>, <init>, Comparable
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        private static final a k[];
        private final Object j;

        static Object a(a a1)
        {
            return a1.j;
        }

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/umeng/message/proguard/k$f$a, s1);
        }

        public static a[] values()
        {
            return (a[])k.clone();
        }

        static 
        {
            a = new a("INT", 0, Integer.valueOf(0));
            b = new a("LONG", 1, Long.valueOf(0L));
            c = new a("FLOAT", 2, Float.valueOf(0.0F));
            d = new a("DOUBLE", 3, Double.valueOf(0.0D));
            e = new a("BOOLEAN", 4, Boolean.valueOf(false));
            f = new a("STRING", 5, "");
            g = new a("BYTE_STRING", 6, g.d);
            h = new a("ENUM", 7, null);
            i = new a("MESSAGE", 8, null);
            k = (new a[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private a(String s1, int i1, Object obj)
        {
            super(s1, i1);
            j = obj;
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final b g;
        public static final b h;
        public static final b i;
        public static final b j;
        public static final b k;
        public static final b l;
        public static final b m;
        public static final b n;
        public static final b o;
        public static final b p;
        public static final b q;
        public static final b r;
        private static final b t[];
        private a s;

        public static b a(j.k.c c1)
        {
            return values()[c1.a() - 1];
        }

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/umeng/message/proguard/k$f$b, s1);
        }

        public static b[] values()
        {
            return (b[])t.clone();
        }

        public j.k.c a()
        {
            return com.umeng.message.proguard.j.k.c.a(ordinal() + 1);
        }

        public a b()
        {
            return s;
        }

        static 
        {
            a = new b("DOUBLE", 0, a.d);
            b = new b("FLOAT", 1, a.c);
            c = new b("INT64", 2, a.b);
            d = new b("UINT64", 3, a.b);
            e = new b("INT32", 4, a.a);
            f = new b("FIXED64", 5, a.b);
            g = new b("FIXED32", 6, a.a);
            h = new b("BOOL", 7, a.e);
            i = new b("STRING", 8, a.f);
            j = new b("GROUP", 9, a.i);
            k = new b("MESSAGE", 10, a.i);
            l = new b("BYTES", 11, a.g);
            m = new b("UINT32", 12, a.a);
            n = new b("ENUM", 13, a.h);
            o = new b("SFIXED32", 14, a.a);
            p = new b("SFIXED64", 15, a.b);
            q = new b("SINT32", 16, a.a);
            r = new b("SINT64", 17, a.b);
            t = (new b[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r
            });
        }

        private b(String s1, int i1, a a1)
        {
            super(s1, i1);
            s = a1;
        }
    }


    private static final t> a[] = values();
    private final int b;
    private values c;
    private final String d;
    private final values e;
    private final values f;
    private b g;
    private b h;
    private b i;
    private b j;
    private Object k;

    private void a(a a1)
    {
        c = a1;
    }

    static void a(c c1, c c2)
    {
        c1.a(c2);
    }

    static void b(a a1)
        throws a
    {
        a1.z();
    }

    private void z()
        throws 
    {
        if (c.z())
        {
            c c1 = a(e).a(c.A(), this, c.a);
            if (!(c1 instanceof c.a))
            {
                throw new <init>(this, (new StringBuilder()).append('"').append(c.A()).append("\" is not a message type.").toString(), null);
            }
            h = (h)c1;
            if (!u().a(f()))
            {
                throw new <init>(this, (new StringBuilder()).append('"').append(u().d()).append("\" does not declare ").append(f()).append(" as an extension number.").toString(), null);
            }
        }
        if (!c.w()) goto _L2; else goto _L1
_L1:
        c c2;
        c2 = a(e).a(c.x(), this, c.a);
        if (!c.u())
        {
            if (c2 instanceof u)
            {
                g = b.k;
            } else
            if (c2 instanceof b.k)
            {
                g = b.n;
            } else
            {
                throw new <init>(this, (new StringBuilder()).append('"').append(c.x()).append("\" is not a type.").toString(), null);
            }
        }
        if (g() != a.i) goto _L4; else goto _L3
_L3:
        if (!(c2 instanceof a.i))
        {
            throw new <init>(this, (new StringBuilder()).append('"').append(c.x()).append("\" is not a message type.").toString(), null);
        }
        i = (i)c2;
        if (c.C())
        {
            throw new <init>(this, "Messages can't have default values.", null);
        }
          goto _L5
_L4:
        if (g() != a.h) goto _L7; else goto _L6
_L6:
        if (!(c2 instanceof a.h))
        {
            throw new <init>(this, (new StringBuilder()).append('"').append(c.x()).append("\" is not an enum type.").toString(), null);
        }
        j = (j)c2;
          goto _L5
_L7:
        throw new <init>(this, "Field with primitive type has type_name.", null);
_L2:
        if (g() == a.i || g() == a.h)
        {
            throw new <init>(this, "Field with message or enum type missing type_name.", null);
        }
        if (true) goto _L5; else goto _L8
_L5:
        if (!c.C())
        {
            break; /* Loop/switch isn't completed */
        }
        if (n())
        {
            throw new <init>(this, "Repeated fields cannot have default values.", null);
        }
        int i1;
        try
        {
            i1 = a[i().ordinal()];
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new <init>(this, (new StringBuilder()).append("Could not parse default value: \"").append(c.D()).append('"').toString(), numberformatexception, null);
        }
        i1;
        JVM INSTR tableswitch 1 18: default 592
    //                   1 667
    //                   2 667
    //                   3 667
    //                   4 730
    //                   5 730
    //                   6 750
    //                   7 750
    //                   8 750
    //                   9 770
    //                   10 770
    //                   11 790
    //                   12 894
    //                   13 998
    //                   14 1015
    //                   15 1029
    //                   16 1081
    //                   17 1147
    //                   18 1147;
           goto _L9 _L10 _L10 _L10 _L11 _L11 _L12 _L12 _L12 _L13 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L20
_L9:
        if (!t())
        {
            a(e).a(this);
        }
         ;
        if (h != null && h.g().o())
        {
            if (t())
            {
                if (!m() || i() != b.k)
                {
                    throw new <init>(this, "Extensions of MessageSets must be optional messages.", null);
                }
            } else
            {
                throw new <init>(this, "MessageSets cannot have fields, only extensions.", null);
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
        ;
        throw new <init>(this, (new StringBuilder()).append("Couldn't parse default value: ").append(.getMessage()).toString(), , null);
_L19:
        k = j.a(c.D());
        if (k == null)
        {
            throw new <init>(this, (new StringBuilder()).append("Unknown enum default value: \"").append(c.D()).append('"').toString(), null);
        }
        continue; /* Loop/switch isn't completed */
_L20:
        throw new <init>(this, "Message type had default value.", null);
_L8:
        if (n())
        {
            k = Collections.emptyList();
            continue; /* Loop/switch isn't completed */
        }
        switch (b[g().ordinal()])
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

    public int a(b b1)
    {
        if (b1.h != h)
        {
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        } else
        {
            return f() - b1.f();
        }
    }

    public f a(f f1, y y1)
    {
        return ((f)f1).c((x)y1);
    }

    public c b()
    {
        return c;
    }

    public String c()
    {
        return c.o();
    }

    public int compareTo(Object obj)
    {
        return a((a)obj);
    }

    public String d()
    {
        return d;
    }

    public d e()
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

    public b.b h()
    {
        return j().a();
    }

    public b i()
    {
        return g;
    }

    public g j()
    {
        return a[g.ordinal()];
    }

    public boolean k()
    {
        return c.t() == b.b;
    }

    public x l()
    {
        return b();
    }

    public boolean m()
    {
        return c.t() == b.a;
    }

    public boolean n()
    {
        return c.t() == b.c;
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

    public k s()
    {
        return c.G();
    }

    public boolean t()
    {
        return c.z();
    }

    public z u()
    {
        return h;
    }

    public h v()
    {
        if (!t())
        {
            throw new UnsupportedOperationException("This field is not an extension.");
        } else
        {
            return f;
        }
    }

    public f w()
    {
        if (g() != a.i)
        {
            throw new UnsupportedOperationException("This field is not of message type.");
        } else
        {
            return i;
        }
    }

    public i x()
    {
        if (g() != a.h)
        {
            throw new UnsupportedOperationException("This field is not of enum type.");
        } else
        {
            return j;
        }
    }

    public j y()
    {
        return x();
    }

    static 
    {
        if (b.values().length != com.umeng.message.proguard.c.values().length)
        {
            throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
        }
    }

    private c(b.s s1, b.s s2, b.s s3, int i1, boolean flag)
        throws c
    {
        b = i1;
        c = s1;
        d = com.umeng.message.proguard.k.a(s2, s3, s1.o());
        e = s2;
        if (s1.u())
        {
            g = b.a(s1.v());
        }
        if (f() <= 0)
        {
            throw new <init>(this, "Field numbers must be positive integers.", null);
        }
        if (s1.G().q() && !p())
        {
            throw new <init>(this, "[packed = true] can only be specified for repeated primitive fields.", null);
        }
        if (flag)
        {
            if (!s1.z())
            {
                throw new <init>(this, "FieldDescriptorProto.extendee not set for extension field.", null);
            }
            h = null;
            if (s3 != null)
            {
                f = s3;
            } else
            {
                f = null;
            }
        } else
        {
            if (s1.z())
            {
                throw new <init>(this, "FieldDescriptorProto.extendee set for non-extension field.", null);
            }
            h = s3;
            f = null;
        }
        a(s2).c(this);
    }

    c(c c1, c c2, c c3, int i1, boolean flag, c c4)
        throws c
    {
        this(c1, c2, c3, i1, flag);
    }
}
