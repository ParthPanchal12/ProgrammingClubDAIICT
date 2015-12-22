// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class bp
{

    public bp()
    {
    }

    public static String a(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static int b(Context context)
    {
        int i;
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String s = ((PackageInfo) (context)).versionName;
            i = ((PackageInfo) (context)).versionCode;
            i = (new StringBuilder()).append(s).append(".").append(i).toString().hashCode();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return -1;
        }
        return i;
    }
}
