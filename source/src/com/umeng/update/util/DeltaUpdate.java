// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import u.upd.n;

public class DeltaUpdate
{

    private static boolean a = false;
    private static final String b = "bspatch";

    public DeltaUpdate()
    {
    }

    public static int a(String s, String s1, String s2)
    {
        return bspatch(s, s1, s2);
    }

    public static String a(Context context)
    {
        return context.getApplicationInfo().sourceDir;
    }

    public static boolean a()
    {
        return a;
    }

    public static String b(Context context)
    {
        context = a(context);
        if (!(new File(context)).exists())
        {
            return "";
        } else
        {
            return n.a(new File(context));
        }
    }

    public static native int bspatch(String s, String s1, String s2);

    static 
    {
        try
        {
            System.loadLibrary("bspatch");
            a = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            a = false;
        }
    }
}
