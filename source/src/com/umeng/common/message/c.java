// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.common.message;

import android.content.Context;
import java.lang.reflect.Field;

// Referenced classes of package com.umeng.common.message:
//            Log

public class c
{

    private static final String a = com/umeng/common/message/c.getName();
    private static c b;
    private static Class d = null;
    private static Class e = null;
    private static Class f = null;
    private static Class g = null;
    private static Class h = null;
    private static Class i = null;
    private static Class j = null;
    private static Class k = null;
    private Context c;

    private c(Context context)
    {
        c = context.getApplicationContext();
        try
        {
            e = Class.forName((new StringBuilder()).append(c.getPackageName()).append(".R$drawable").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, context.getMessage());
        }
        try
        {
            f = Class.forName((new StringBuilder()).append(c.getPackageName()).append(".R$layout").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, context.getMessage());
        }
        try
        {
            d = Class.forName((new StringBuilder()).append(c.getPackageName()).append(".R$id").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, context.getMessage());
        }
        try
        {
            g = Class.forName((new StringBuilder()).append(c.getPackageName()).append(".R$anim").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, context.getMessage());
        }
        try
        {
            h = Class.forName((new StringBuilder()).append(c.getPackageName()).append(".R$style").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, context.getMessage());
        }
        try
        {
            i = Class.forName((new StringBuilder()).append(c.getPackageName()).append(".R$string").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, context.getMessage());
        }
        try
        {
            j = Class.forName((new StringBuilder()).append(c.getPackageName()).append(".R$array").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, context.getMessage());
        }
        try
        {
            k = Class.forName((new StringBuilder()).append(c.getPackageName()).append(".R$raw").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.b(a, context.getMessage());
        }
    }

    private int a(Class class1, String s)
    {
        if (class1 == null)
        {
            Log.b(a, (new StringBuilder()).append("getRes(null,").append(s).append(")").toString());
            throw new IllegalArgumentException((new StringBuilder()).append("ResClass is not initialized. Please make sure you have added neccessary resources. Also make sure you have ").append(c.getPackageName()).append(".R$* configured in obfuscation. field=").append(s).toString());
        }
        int l;
        try
        {
            l = class1.getField(s).getInt(s);
        }
        catch (Exception exception)
        {
            Log.b(a, (new StringBuilder()).append("getRes(").append(class1.getName()).append(", ").append(s).append(")").toString());
            Log.b(a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
            Log.b(a, exception.getMessage());
            return -1;
        }
        return l;
    }

    public static c a(Context context)
    {
        if (b == null)
        {
            b = new c(context);
        }
        return b;
    }

    public int a(String s)
    {
        return a(g, s);
    }

    public int b(String s)
    {
        return a(d, s);
    }

    public int c(String s)
    {
        return a(e, s);
    }

    public int d(String s)
    {
        return a(f, s);
    }

    public int e(String s)
    {
        return a(h, s);
    }

    public int f(String s)
    {
        return a(i, s);
    }

    public int g(String s)
    {
        return a(j, s);
    }

    public int h(String s)
    {
        return a(k, s);
    }

}
