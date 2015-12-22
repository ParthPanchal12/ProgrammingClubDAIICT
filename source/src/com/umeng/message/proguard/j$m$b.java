// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            C, j

public static final class j extends Enum
    implements C
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    private static c g = new r.b() {

        public j.m.b a(int l)
        {
            return j.m.b.a(l);
        }

        public r.a b(int l)
        {
            return a(l);
        }

    };
    private static final _cls1.a h[] = values();
    private static final values k[];
    private final int i;
    private final int j;

    public static j a(int l)
    {
        switch (l)
        {
        default:
            return null;

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;
        }
    }

    public static c a(c c1)
    {
        if (c1.c() != e())
        {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else
        {
            return h[c1.h()];
        }
    }

    public static h b()
    {
        return g;
    }

    public static final g e()
    {
        return (g)g().g().get(0);
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/umeng/message/proguard/j$m$b, s);
    }

    public static g[] values()
    {
        return (g[])k.clone();
    }

    public final int a()
    {
        return j;
    }

    public final j c()
    {
        return (j)e().e().get(i);
    }

    public final i d()
    {
        return e();
    }

    static 
    {
        a = new <init>("STRING", 0, 0, 0);
        b = new <init>("CORD", 1, 1, 1);
        c = new <init>("STRING_PIECE", 2, 2, 2);
        k = (new k[] {
            a, b, c
        });
    }

    private _cls1(String s, int l, int i1, int j1)
    {
        super(s, l);
        i = i1;
        j = j1;
    }
}
