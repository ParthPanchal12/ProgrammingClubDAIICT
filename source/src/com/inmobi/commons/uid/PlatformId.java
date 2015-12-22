// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import android.content.Context;
import com.inmobi.commons.internal.Log;

public class PlatformId
{

    public PlatformId()
    {
    }

    public static String getAndroidId(Context context)
    {
        String s = null;
        String s1 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        s = s1;
_L2:
        String s2 = s;
        Exception exception;
        if (s == null)
        {
            try
            {
                s2 = android.provider.Settings.System.getString(context.getContentResolver(), "android_id");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.internal("commons", "Unable to retrieve android id.");
                return s;
            }
        }
        return s2;
        exception;
        Log.internal("commons", "Unable to retrieve android id.");
        if (true) goto _L2; else goto _L1
_L1:
    }
}
