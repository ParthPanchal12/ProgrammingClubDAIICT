// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.security.PrivilegedAction;

// Referenced classes of package com.umeng.message.proguard:
//            aD

static final class b
    implements PrivilegedAction
{

    final String a;
    final String b;

    public String a()
    {
        return System.setProperty(a, b);
    }

    public Object run()
    {
        return a();
    }

    (String s, String s1)
    {
        a = s;
        b = s1;
        super();
    }
}
