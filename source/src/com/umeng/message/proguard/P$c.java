// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            c, P, s, h, 
//            n

public static final class  extends c
{

    public P c(h h, n n)
        throws s
    {
        n = P.b();
        try
        {
            n.a(h);
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            throw h.a(n.c());
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            throw (new s(h.getMessage())).a(n.c());
        }
        return n.c();
    }

    public Object d(h h, n n)
        throws s
    {
        return c(h, n);
    }

    public ()
    {
    }
}
