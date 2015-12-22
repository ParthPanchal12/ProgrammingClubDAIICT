// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.util;

import android.content.Context;
import java.lang.reflect.Field;

// Referenced classes of package com.umeng.fb.util:
//            Log

public class Res
{

    private static final String a = com/umeng/fb/util/Res.getName();
    private static Res b = null;
    private static String c = null;
    private static Class d = null;
    private static Class e = null;
    private static Class f = null;
    private static Class g = null;
    private static Class h = null;
    private static Class i = null;
    private static Class j = null;
    private static Class k = null;

    private Res(String s)
    {
        try
        {
            e = Class.forName((new StringBuilder()).append(s).append(".R$drawable").toString());
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.b(a, classnotfoundexception.getMessage());
        }
        try
        {
            f = Class.forName((new StringBuilder()).append(s).append(".R$layout").toString());
        }
        catch (ClassNotFoundException classnotfoundexception1)
        {
            Log.b(a, classnotfoundexception1.getMessage());
        }
        try
        {
            d = Class.forName((new StringBuilder()).append(s).append(".R$id").toString());
        }
        catch (ClassNotFoundException classnotfoundexception2)
        {
            Log.b(a, classnotfoundexception2.getMessage());
        }
        try
        {
            g = Class.forName((new StringBuilder()).append(s).append(".R$anim").toString());
        }
        catch (ClassNotFoundException classnotfoundexception3)
        {
            Log.b(a, classnotfoundexception3.getMessage());
        }
        try
        {
            h = Class.forName((new StringBuilder()).append(s).append(".R$style").toString());
        }
        catch (ClassNotFoundException classnotfoundexception4)
        {
            Log.b(a, classnotfoundexception4.getMessage());
        }
        try
        {
            i = Class.forName((new StringBuilder()).append(s).append(".R$string").toString());
        }
        catch (ClassNotFoundException classnotfoundexception5)
        {
            Log.b(a, classnotfoundexception5.getMessage());
        }
        try
        {
            j = Class.forName((new StringBuilder()).append(s).append(".R$array").toString());
        }
        catch (ClassNotFoundException classnotfoundexception6)
        {
            Log.b(a, classnotfoundexception6.getMessage());
        }
        try
        {
            k = Class.forName((new StringBuilder()).append(s).append(".R$color").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.b(a, s.getMessage());
        }
    }

    private int a(Class class1, String s)
    {
        if (class1 == null)
        {
            Log.b(a, (new StringBuilder()).append("getRes(null,").append(s).append(")").toString());
            throw new IllegalArgumentException((new StringBuilder()).append("ResClass is not initialized. Please make sure you have added necessary resources. Also make sure you have ").append(c).append(".R$* configured in obfuscation. field=").append(s).toString());
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

    public static Res getInstance(Context context)
    {
        com/umeng/fb/util/Res;
        JVM INSTR monitorenter ;
        if (b != null) goto _L2; else goto _L1
_L1:
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        context = c;
_L3:
        c = context;
        b = new Res(c);
_L2:
        context = b;
        com/umeng/fb/util/Res;
        JVM INSTR monitorexit ;
        return context;
        context = context.getPackageName();
          goto _L3
        context;
        throw context;
    }

    public static void setPackageName(String s)
    {
        c = s;
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
