// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aN;

// Referenced classes of package org.android.agoo.client:
//            AgooSettings, IntentHelper

public class BaseRegistrar
{

    public BaseRegistrar()
    {
    }

    static void a(Context context)
    {
        try
        {
            e(context);
            d(context);
            f(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    protected static void a(Context context, String s, String s1, String s2)
    {
        a(context, s, s1, s2, true);
    }

    protected static void a(Context context, String s, String s1, String s2, boolean flag)
    {
        try
        {
            aN.a(context);
            if (TextUtils.isEmpty(s1))
            {
                AgooSettings.setAgooSecurityMode(context, true);
            }
            aI.j(context);
            aI.a(context, s, s1, s2);
            aI.t(context);
            b(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    static void b(Context context)
    {
        try
        {
            Intent intent = IntentHelper.createComandIntent(context, "register");
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    static void c(Context context)
    {
        try
        {
            Intent intent = IntentHelper.createComandIntent(context, "unregister");
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public static void checkDevice(Context context)
    {
    }

    private static final void d(Context context)
    {
    }

    private static final void e(Context context)
    {
    }

    private static void f(Context context)
    {
    }

    public static final String getRegistrationId(Context context)
    {
        try
        {
            context = aI.q(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static final boolean isRegistered(Context context)
    {
        boolean flag = false;
        boolean flag1;
        try
        {
            flag1 = TextUtils.isEmpty(aI.q(context));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("BaseRegistrar", "isRegistered", context);
            return false;
        }
        if (!flag1)
        {
            flag = true;
        }
        return flag;
    }

    public static void unregister(Context context)
    {
        try
        {
            aN.h(context);
            aN.b(context);
            aI.j(context);
            c(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }
}
