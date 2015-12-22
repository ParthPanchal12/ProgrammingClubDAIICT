// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.client.IntentHelper;

// Referenced classes of package com.umeng.message.proguard:
//            aJ

public class by
{

    private static final String a = "ServiceUtil";

    public by()
    {
    }

    public static void a(Context context)
    {
        int i;
        int j;
        try
        {
            context = ((ActivityManager)context.getSystemService("activity")).getRunningServices(0x7fffffff);
            j = Process.myPid();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        i = 0;
        for (context = context.iterator(); context.hasNext();)
        {
            if (((android.app.ActivityManager.RunningServiceInfo)context.next()).pid == j)
            {
                i++;
            }
        }

        if (i >= 1)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        Process.killProcess(j);
    }

    public static void a(Context context, Class class1)
    {
        aJ.c("ServiceUtil", (new StringBuilder()).append("command --->[").append(context.getPackageName()).append(".service]:[").append("start").append("]").toString());
        class1 = new Intent();
        class1.setAction(IntentHelper.getAgooStart(context));
        class1.putExtra("method", "start");
        class1.setPackage(context.getPackageName());
        context.startService(class1);
    }

    public static void b(Context context, Class class1)
    {
        aJ.c("ServiceUtil", (new StringBuilder()).append("command --->[").append(context.getPackageName()).append(".service]:[").append("stop").append("]").toString());
        class1 = IntentHelper.getAgooStart(context);
        Intent intent = new Intent();
        intent.setAction(class1);
        intent.putExtra("method", "stop");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }
}
