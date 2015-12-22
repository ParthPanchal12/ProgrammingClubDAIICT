// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class bx
{

    public bx()
    {
    }

    public static void a(Context context)
    {
        if (context == null) goto _L2; else goto _L1
_L1:
        PackageManager packagemanager;
        Object obj;
        packagemanager = context.getPackageManager();
        obj = context.getPackageName();
        PackageInfo packageinfo = packagemanager.getPackageInfo(((String) (obj)), 2);
        obj = packageinfo.receivers;
        if (obj != null)
        {
            ComponentName componentname;
            int i;
            int j;
            try
            {
                if (obj.length == 0)
                {
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
            break MISSING_BLOCK_LABEL_64;
        }
          goto _L2
        context;
        throw new IllegalStateException((new StringBuilder()).append("Could not get receivers for package ").append(((String) (obj))).toString());
        j = obj.length;
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        componentname = new ComponentName(context, ((ActivityInfo) (obj[i])).name);
        if (packagemanager.getComponentEnabledSetting(componentname) == 2)
        {
            packagemanager.setComponentEnabledSetting(componentname, 1, 1);
        }
        packagemanager.setComponentEnabledSetting(componentname, 1, 1);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static void a(Context context, Class class1)
    {
        if (context == null || class1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        PackageManager packagemanager = context.getPackageManager();
        if (packagemanager == null)
        {
            return;
        }
        try
        {
            if (packagemanager.getApplicationEnabledSetting(context.getPackageName()) > -1)
            {
                context = new ComponentName(context, class1);
                if (packagemanager.getComponentEnabledSetting(context) != 2)
                {
                    packagemanager.setComponentEnabledSetting(context, 2, 1);
                    return;
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
    }

    public static void b(Context context, Class class1)
    {
        if (context == null || class1 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        PackageManager packagemanager = context.getPackageManager();
        if (packagemanager == null)
        {
            return;
        }
        int i;
        if (packagemanager.getApplicationEnabledSetting(context.getPackageName()) <= -1)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        context = new ComponentName(context, class1);
        i = packagemanager.getComponentEnabledSetting(context);
        if (i != 1 && i != 0)
        {
            try
            {
                packagemanager.setComponentEnabledSetting(context, 1, 1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
    }
}
