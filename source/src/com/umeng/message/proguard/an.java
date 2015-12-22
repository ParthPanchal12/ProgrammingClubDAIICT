// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;

// Referenced classes of package com.umeng.message.proguard:
//            am, al, ad

public class an
{

    public an()
    {
    }

    public static String a(Context context)
    {
        context = am.a(context);
        if (context == null || ad.a(context.f()))
        {
            return "ffffffffffffffffffffffff";
        } else
        {
            return context.f();
        }
    }
}
