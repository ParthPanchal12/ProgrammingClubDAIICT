// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.google.ads:
//            aj, ap, an, aq, 
//            ao

public class ak extends aj
{
    static class a extends Exception
    {

        public a()
        {
        }

        public a(Throwable throwable)
        {
            super(throwable);
        }
    }


    static boolean c = false;
    private static Method d = null;
    private static Method e = null;
    private static Method f = null;
    private static Method g = null;
    private static Method h = null;
    private static String i = null;
    private static long j = 0L;

    protected ak(Context context)
    {
        super(context);
    }

    public static ak a(String s, Context context)
    {
        b(s, context);
        return new ak(context);
    }

    static String a()
        throws a
    {
        if (i == null)
        {
            throw new a();
        } else
        {
            return i;
        }
    }

    static ArrayList a(MotionEvent motionevent, DisplayMetrics displaymetrics)
        throws a
    {
        if (g == null || motionevent == null)
        {
            throw new a();
        }
        try
        {
            motionevent = (ArrayList)g.invoke(null, new Object[] {
                motionevent, displaymetrics
            });
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            throw new a(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            throw new a(motionevent);
        }
        return motionevent;
    }

    static Long b()
        throws a
    {
        if (d == null)
        {
            throw new a();
        }
        Long long1;
        try
        {
            long1 = (Long)d.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new a(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new a(invocationtargetexception);
        }
        return long1;
    }

    private static String b(byte abyte0[], String s)
        throws a
    {
        try
        {
            abyte0 = new String(an.a(abyte0, s), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new a(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new a(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new a(abyte0);
        }
        return abyte0;
    }

    protected static void b(String s, Context context)
    {
        com/google/ads/ak;
        JVM INSTR monitorenter ;
        boolean flag = c;
        if (!flag)
        {
            try
            {
                i = s;
                f(context);
                j = b().longValue();
                c = true;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            finally
            {
                com/google/ads/ak;
            }
        }
        com/google/ads/ak;
        JVM INSTR monitorexit ;
        return;
        throw s;
    }

    static String c()
        throws a
    {
        if (e == null)
        {
            throw new a();
        }
        String s;
        try
        {
            s = (String)e.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new a(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new a(invocationtargetexception);
        }
        return s;
    }

    static String d(Context context)
        throws a
    {
        if (h == null)
        {
            throw new a();
        }
        try
        {
            context = (String)h.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        throw new a();
        return context;
    }

    static String e(Context context)
        throws a
    {
        if (f == null)
        {
            throw new a();
        }
        try
        {
            context = (ByteBuffer)f.invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        throw new a();
        context = aq.a(context.array(), false);
        return context;
    }

    private static void f(Context context)
        throws a
    {
        File file;
        File file1;
        byte abyte0[];
        byte abyte1[];
        Class class1;
        Object obj;
        Class class2;
        Object obj1;
        try
        {
            abyte0 = an.a(ao.a());
            abyte1 = an.a(abyte0, ao.b());
            file1 = context.getCacheDir();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a(context);
        }
        file = file1;
        if (file1 != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        file1 = context.getDir("dex", 0);
        file = file1;
        if (file1 != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        throw new a();
        file1 = File.createTempFile("ads", ".jar", file);
        obj = new FileOutputStream(file1);
        ((FileOutputStream) (obj)).write(abyte1, 0, abyte1.length);
        ((FileOutputStream) (obj)).close();
        obj1 = new DexClassLoader(file1.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
        context = ((DexClassLoader) (obj1)).loadClass(b(abyte0, ao.c()));
        class1 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, ao.i()));
        obj = ((DexClassLoader) (obj1)).loadClass(b(abyte0, ao.g()));
        class2 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, ao.k()));
        obj1 = ((DexClassLoader) (obj1)).loadClass(b(abyte0, ao.e()));
        d = context.getMethod(b(abyte0, ao.d()), new Class[0]);
        e = class1.getMethod(b(abyte0, ao.j()), new Class[0]);
        f = ((Class) (obj)).getMethod(b(abyte0, ao.h()), new Class[] {
            android/content/Context
        });
        g = class2.getMethod(b(abyte0, ao.l()), new Class[] {
            android/view/MotionEvent, android/util/DisplayMetrics
        });
        h = ((Class) (obj1)).getMethod(b(abyte0, ao.f()), new Class[] {
            android/content/Context
        });
        context = file1.getName();
        file1.delete();
        (new File(file, context.replace(".jar", ".dex"))).delete();
        return;
    }

    protected void b(Context context)
    {
        try
        {
            a(1, c());
        }
        catch (a a3) { }
        try
        {
            a(2, a());
        }
        catch (a a2) { }
        try
        {
            a(25, b().longValue());
        }
        catch (a a1) { }
        try
        {
            a(24, d(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        context;
    }

    protected void c(Context context)
    {
        try
        {
            a(2, a());
        }
        catch (a a4) { }
        try
        {
            a(1, c());
        }
        catch (a a3) { }
        try
        {
            long l = b().longValue();
            a(25, l);
            if (j != 0L)
            {
                a(17, l - j);
                a(23, j);
            }
        }
        catch (a a2) { }
        try
        {
            ArrayList arraylist = a(a, b);
            a(14, ((Long)arraylist.get(0)).longValue());
            a(15, ((Long)arraylist.get(1)).longValue());
            if (arraylist.size() >= 3)
            {
                a(16, ((Long)arraylist.get(2)).longValue());
            }
        }
        catch (a a1) { }
        try
        {
            a(27, e(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        context;
    }

}
