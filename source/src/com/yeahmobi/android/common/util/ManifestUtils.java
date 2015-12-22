// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.common.util:
//            IntentUtils, Utils

public class ManifestUtils
{

    private static final List REQUIRED_NATIVE_SDK_ACTIVITIES = new ArrayList(1);
    private static final List REQUIRED_WEB_VIEW_SDK_ACTIVITIES = new ArrayList(4);

    private ManifestUtils()
    {
    }

    public static void checkNativeActivitiesDeclared(Context context)
    {
        displayWarningForMissingActivities(context, REQUIRED_NATIVE_SDK_ACTIVITIES);
    }

    public static void checkWebViewActivitiesDeclared(Context context)
    {
        displayWarningForMissingActivities(context, REQUIRED_WEB_VIEW_SDK_ACTIVITIES);
    }

    static void displayWarningForMissingActivities(Context context, List list)
    {
        if (context != null)
        {
            if (!(list = getUndeclaredActivities(context, list)).isEmpty())
            {
                if (isDebuggable(context))
                {
                    context = Toast.makeText(context, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities.", 1);
                    context.setGravity(7, 0, 0);
                    context.show();
                }
                logMissingActivities(list);
                return;
            }
        }
    }

    static List getRequiredNativeSdkActivities()
    {
        return REQUIRED_NATIVE_SDK_ACTIVITIES;
    }

    static List getRequiredWebViewSdkActivities()
    {
        return REQUIRED_WEB_VIEW_SDK_ACTIVITIES;
    }

    private static List getUndeclaredActivities(Context context, List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Class class1 = (Class)list.next();
            if (!IntentUtils.deviceCanHandleIntent(context, new Intent(context, class1)))
            {
                arraylist.add(class1.getName());
            }
        } while (true);
        return arraylist;
    }

    static boolean isDebuggable(Context context)
    {
        if (context == null || context.getApplicationInfo() == null)
        {
            return false;
        } else
        {
            return Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, 2);
        }
    }

    private static void logMissingActivities(List list)
    {
        StringBuilder stringbuilder = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
        String s;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append("\n\t").append(s))
        {
            s = (String)list.next();
        }

        stringbuilder.append("\n\nPlease update your manifest to include them.");
        Log.w("YeahMobi", stringbuilder.toString());
    }

}
