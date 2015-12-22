// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.umeng.message.proguard:
//            n, x

public final class m extends n
{
    private static final class a
    {

        private final k.a a;
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

        a(k.a a1, int i)
        {
            a = a1;
            b = i;
        }
    }

    public static final class b
    {

        public final k.f a;
        public final x b;

        private b(k.f f)
        {
            a = f;
            b = null;
        }

        private b(k.f f, x x)
        {
            a = f;
            b = x;
        }

    }


    private static final m c = new m(true);
    private final Map a;
    private final Map b;

    private m()
    {
        a = new HashMap();
        b = new HashMap();
    }

    private m(m m1)
    {
        super(m1);
        a = Collections.unmodifiableMap(m1.a);
        b = Collections.unmodifiableMap(m1.b);
    }

    private m(boolean flag)
    {
        super(n.g());
        a = Collections.emptyMap();
        b = Collections.emptyMap();
    }

    public static m a()
    {
        return new m();
    }

    private void a(b b1)
    {
        if (!b1.a.t())
        {
            throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
        }
        a.put(b1.a.d(), b1);
        b.put(new a(b1.a.u(), b1.a.f()), b1);
        k.f f = b1.a;
        if (f.u().g().o() && f.i() == k.f.b.k && f.m() && f.v() == f.w())
        {
            a.put(f.w().d(), b1);
        }
    }

    public static m b()
    {
        return c;
    }

    public b a(k.a a1, int i)
    {
        return (b)b.get(new a(a1, i));
    }

    public b a(String s)
    {
        return (b)a.get(s);
    }

    public void a(k.f f)
    {
        if (f.g() == k.f.a.i)
        {
            throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
        } else
        {
            a(new b(f, null));
            return;
        }
    }

    public void a(k.f f, x x)
    {
        if (f.g() != k.f.a.i)
        {
            throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
        } else
        {
            a(new b(f, x));
            return;
        }
    }

    public void a(p.h h)
    {
        if (h.a().g() == k.f.a.i)
        {
            if (h.b() == null)
            {
                throw new IllegalStateException((new StringBuilder()).append("Registered message-type extension had null default instance: ").append(h.a().d()).toString());
            } else
            {
                a(new b(h.a(), h.b()));
                return;
            }
        } else
        {
            a(new b(h.a(), null));
            return;
        }
    }

    public m c()
    {
        return new m(this);
    }

    public n d()
    {
        return c();
    }

}
