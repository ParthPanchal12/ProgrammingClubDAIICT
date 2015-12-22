// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.umeng.message.proguard:
//            p, o, l, h, 
//            n, t, i, x

public static abstract class a extends p
    implements a
{
    protected class a
    {

        final p.d a;
        private final Iterator b;
        private java.util.Map.Entry c;
        private final boolean d;

        public void a(int j, i k)
            throws IOException
        {
            while (c != null && ((k.f)c.getKey()).f() < j) 
            {
                k.f f = (k.f)c.getKey();
                if (d && f.h() == S.b.i && !f.n())
                {
                    if (c instanceof t.a)
                    {
                        k.b(f.f(), ((t.a)c).a().c());
                    } else
                    {
                        k.d(f.f(), (x)c.getValue());
                    }
                } else
                {
                    o.a(f, c.getValue(), k);
                }
                if (b.hasNext())
                {
                    c = (java.util.Map.Entry)b.next();
                } else
                {
                    c = null;
                }
            }
        }

        private a(boolean flag)
        {
            a = p.d.this;
            super();
            b = p.d.a(a).h();
            if (b.hasNext())
            {
                c = (java.util.Map.Entry)b.next();
            }
            d = flag;
        }

        a(boolean flag, p._cls1 _pcls1)
        {
            this(flag);
        }
    }


    private final o a;

    static o a(a.c c1)
    {
        return c1.a;
    }

    private void d(a a1)
    {
        if (a1.u() != J())
        {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        } else
        {
            return;
        }
    }

    private void d(ion ion)
    {
        if (ion.a().u() != J())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Extension is for type \"").append(ion.a().u().d()).append("\" which does not match message type \"").append(J().d()).append("\".").toString());
        } else
        {
            return;
        }
    }

    protected boolean W()
    {
        return a.i();
    }

    protected a X()
    {
        return new a(false, null);
    }

    protected a Y()
    {
        return new a(true, null);
    }

    protected int Z()
    {
        return a.j();
    }

    public Object a(a a1, int i)
    {
        if (a1.t())
        {
            d(a1);
            return a.a(a1, i);
        } else
        {
            return super.a(a1, i);
        }
    }

    public final Object a(a a1, int i)
    {
        d(a1);
        a a2 = a1.a();
        return b(a1, a.a(a2, i));
    }

    public boolean a()
    {
        return super.a() && W();
    }

    protected boolean a(h h, W w, n n, int i)
        throws IOException
    {
        return a(h, w, n, J(), null, a, i);
    }

    public final boolean a(a a1)
    {
        d(a1);
        return a.a(a1.a());
    }

    public Map a_()
    {
        Map map = p.a(this);
        map.putAll(ab());
        return Collections.unmodifiableMap(map);
    }

    public boolean a_(bleMap blemap)
    {
        if (blemap.t())
        {
            d(blemap);
            return a.a(blemap);
        } else
        {
            return super.a_(blemap);
        }
    }

    protected int aa()
    {
        return a.k();
    }

    protected Map ab()
    {
        return a.g();
    }

    protected void ad()
    {
        a.c();
    }

    public final int b(a a1)
    {
        d(a1);
        a1 = a1.a();
        return a.d(a1);
    }

    public Object b(a a1)
    {
label0:
        {
label1:
            {
                if (!a1.t())
                {
                    break label0;
                }
                d(a1);
                Object obj1 = a.b(a1);
                Object obj = obj1;
                if (obj1 == null)
                {
                    if (a1.g() != a.i)
                    {
                        break label1;
                    }
                    obj = l.a(a1.w());
                }
                return obj;
            }
            return a1.r();
        }
        return super.b(a1);
    }

    public int c(r r)
    {
        if (r.t())
        {
            d(r);
            return a.d(r);
        } else
        {
            return super.c(r);
        }
    }

    public final Object c(a a1)
    {
        d(a1);
        a a2 = a1.a();
        Object obj = a.b(a2);
        if (obj == null)
        {
            if (a2.n())
            {
                return Collections.emptyList();
            }
            if (a2.g() == a.i)
            {
                return a1.b();
            } else
            {
                return a(a1, a2.r());
            }
        } else
        {
            return a(a1, obj);
        }
    }

    protected a()
    {
        a = o.a();
    }

    protected a(a a1)
    {
        super(a1);
        a = a(a1);
    }
}
