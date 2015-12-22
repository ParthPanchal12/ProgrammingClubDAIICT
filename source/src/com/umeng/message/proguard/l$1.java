// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            c, l, s, h, 
//            n

class nit> extends c
{

    final l a;

    public l c(h h, n n)
        throws s
    {
        nit> nit> = l.b(l.a(a));
        try
        {
            nit>.a(h, n);
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            throw h.a(nit>.m());
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            throw (new s(h.getMessage())).a(nit>.m());
        }
        return nit>.m();
    }

    public Object d(h h, n n)
        throws s
    {
        return c(h, n);
    }

    (l l1)
    {
        a = l1;
        super();
    }
}
