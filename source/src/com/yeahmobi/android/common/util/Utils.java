// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.yeahmobi.android.common.util:
//            IntentUtils

public class Utils
{

    public static final String GOOGLE_PLAY_PACKAGENAME = "com.android.vending";
    private static final AtomicLong sNextGeneratedId = new AtomicLong(1L);

    public Utils()
    {
    }

    public static boolean bitMaskContainsFlag(int i, int j)
    {
        return (i & j) != 0;
    }

    public static long generateUniqueId()
    {
        long l;
        long l2;
        do
        {
            l2 = sNextGeneratedId.get();
            long l1 = l2 + 1L;
            l = l1;
            if (l1 > 0x7ffffffffffffffeL)
            {
                l = 1L;
            }
        } while (!sNextGeneratedId.compareAndSet(l2, l));
        return l2;
    }

    public static boolean isInstalled(Context context, String s)
    {
        try
        {
            context.getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static String sha1(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i;
        int j;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            s = s.getBytes("UTF-8");
            messagedigest.update(s, 0, s.length);
            s = messagedigest.digest();
            j = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(String.format("%02X", new Object[] {
            Byte.valueOf(s[i])
        }));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_40;
_L1:
        s = stringbuilder.toString().toLowerCase();
        return s;
    }

    public static void visitUrl(String s, Context context)
    {
        Intent intent;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        flag = false;
        if (!IntentUtils.isAppStoreUrl(s))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent.addFlags(0x800000);
        intent.addFlags(0x10000000);
        intent.addFlags(0x40000000);
        intent.addFlags(0x10000);
        Iterator iterator = context.getPackageManager().queryIntentActivities(intent, 0x10000).iterator();
_L2:
        flag2 = flag;
        flag1 = flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_188;
        }
        flag2 = flag;
        ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
        flag2 = flag;
        if (!resolveinfo.activityInfo.packageName.equals("com.android.vending")) goto _L2; else goto _L1
_L1:
        flag2 = flag;
        intent.setClassName(resolveinfo.activityInfo.packageName, resolveinfo.activityInfo.name);
        flag2 = flag;
        context.startActivity(intent);
        flag2 = flag;
        ((Activity)context).overridePendingTransition(0, 0);
        flag = true;
          goto _L2
        Exception exception;
        exception;
        exception.printStackTrace();
        flag1 = flag2;
        if (!flag1)
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        return;
    }

}
