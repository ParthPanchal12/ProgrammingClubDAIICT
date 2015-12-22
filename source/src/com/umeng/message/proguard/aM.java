// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;

// Referenced classes of package com.umeng.message.proguard:
//            aI, aL

public class aM
{

    private static final aM a = new aM();
    private volatile aL b;

    private aM()
    {
        b = null;
    }

    public static aM a()
    {
        return a;
    }

    public aL a(Context context)
        throws Throwable
    {
        try
        {
            if (b == null)
            {
                String s = aI.h(context);
                if (!TextUtils.isEmpty(s))
                {
                    b = (aL)Class.forName(s).newInstance();
                    s = aI.n(context);
                    String s1 = aI.o(context);
                    if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
                    {
                        String s2 = aI.p(context);
                        b.start(context, s, s2, s1);
                    } else
                    {
                        b = null;
                    }
                }
            }
            return b;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw context;
        }
    }

}
