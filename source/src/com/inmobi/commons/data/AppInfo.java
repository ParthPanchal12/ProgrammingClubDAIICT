// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class AppInfo
{

    private static String a;
    private static String b;
    private static String c;

    public AppInfo()
    {
    }

    private static void a(String s)
    {
        b = s;
    }

    private static void b(String s)
    {
        a = s;
    }

    private static void c(String s)
    {
        c = s;
    }

    public static String getAppBId()
    {
        return a;
    }

    public static String getAppDisplayName()
    {
        return b;
    }

    public static String getAppVer()
    {
        return c;
    }

    public static void updateAppInfo()
    {
        Object obj;
        Object obj1;
        Object obj2;
        try
        {
            obj = InternalSDKUtil.getContext();
            obj1 = ((Context) (obj)).getPackageManager();
            obj2 = ((PackageManager) (obj1)).getApplicationInfo(((Context) (obj)).getPackageName(), 128);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Failed to fill AppInfo", exception);
            return;
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        b(((ApplicationInfo) (obj2)).packageName);
        a(((ApplicationInfo) (obj2)).loadLabel(((PackageManager) (obj1))).toString());
        obj2 = ((PackageManager) (obj1)).getPackageInfo(((Context) (obj)).getPackageName(), 128);
        obj = null;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj1 = ((PackageInfo) (obj2)).versionName;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        obj = obj1;
        if (!((String) (obj1)).equals(""))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj = (new StringBuilder()).append(((PackageInfo) (obj2)).versionCode).append("").toString();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (!((String) (obj)).equals(""))
        {
            c(((String) (obj)));
        }
    }
}
