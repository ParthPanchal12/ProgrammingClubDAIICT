// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.List;

public class IntentUtils
{

    private static final String HIAPK = "com.hiapk.marketpho";
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static final String MARKET = "market";
    private static final String MARKET_ANDROID_COM = "market.android.com";
    private static final String PLAY_GOOGLE_COM = "play.google.com";
    private static final String TWITTER_APPLICATION_DEEPLINK_URL = "twitter://timeline";

    private IntentUtils()
    {
    }

    public static boolean canHandleApplicationUrl(Context context, String s)
    {
        return canHandleApplicationUrl(context, s, true);
    }

    public static boolean canHandleApplicationUrl(Context context, String s, boolean flag)
    {
        if (!deviceCanHandleIntent(context, new Intent("android.intent.action.VIEW", Uri.parse(s))))
        {
            if (flag)
            {
                Log.w("MoPub", (new StringBuilder()).append("Could not handle application specific action: ").append(s).append(". ").append("You may be running in the emulator or another device which does not ").append("have the required application.").toString());
            }
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean canHandleTwitterUrl(Context context)
    {
        return canHandleApplicationUrl(context, "twitter://timeline", false);
    }

    public static boolean deviceCanHandleIntent(Context context, Intent intent)
    {
        boolean flag = false;
        boolean flag1;
        try
        {
            flag1 = context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (!flag1)
        {
            flag = true;
        }
        return flag;
    }

    public static Intent getStartActivityIntent(Context context, Class class1, Bundle bundle)
    {
        class1 = new Intent(context, class1);
        if (!(context instanceof Activity))
        {
            class1.addFlags(0x10000000);
        }
        if (bundle != null)
        {
            class1.putExtras(bundle);
        }
        return class1;
    }

    public static boolean isAppStoreUrl(String s)
    {
        if (s != null)
        {
            Object obj = Uri.parse(s);
            s = ((Uri) (obj)).getScheme();
            obj = ((Uri) (obj)).getHost();
            if ("play.google.com".equals(obj) || "market.android.com".equals(obj))
            {
                return true;
            }
            if ("market".equals(s))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isDeepLink(String s)
    {
        return !isHttpUrl(s);
    }

    public static boolean isHiapkUrl(String s)
    {
        if (s != null)
        {
            s = Uri.parse(s);
            s.getScheme();
            if ("com.hiapk.marketpho".equals(s.getHost()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isHttpUrl(String s)
    {
        if (s != null)
        {
            if ("http".equals(s = Uri.parse(s).getScheme()) || "https".equals(s))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean shouldJumpHiapkLink(String s)
    {
        return isHiapkUrl(s);
    }
}
