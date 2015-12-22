// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import com.umeng.message.proguard.aL;
import com.umeng.message.proguard.an;

public class UmengUT
    implements aL
{

    private volatile boolean b;

    public UmengUT()
    {
        b = false;
    }

    public void commitEvent(int i, Object obj)
    {
    }

    public void commitEvent(int i, Object obj, Object obj1)
    {
    }

    public void commitEvent(int i, Object obj, Object obj1, Object obj2)
    {
    }

    public transient void commitEvent(int i, Object obj, Object obj1, Object obj2, String as[])
    {
    }

    public String getUtdId(Context context)
    {
        try
        {
            context = an.a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public void onCaughException(Throwable throwable)
    {
    }

    public void start(Context context, String s, String s1, String s2)
    {
    }

    public void stop(Context context)
    {
    }
}
