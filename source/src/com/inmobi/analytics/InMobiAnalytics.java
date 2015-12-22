// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.analytics;

import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.androidsdk.IMAdTracker;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Map;

public class InMobiAnalytics
{

    public InMobiAnalytics()
    {
    }

    public static void beginSection(String s)
    {
        beginSection(s, null);
    }

    public static void beginSection(String s, Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            int i = s.hashCode();
            AnalyticsEventsWrapper.getInstance().beginSection(i, s, map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-[Analytics]-4.5.5", "Please pass a valid Section Name");
        }
    }

    public static void endSection(String s)
    {
        endSection(s, null);
    }

    public static void endSection(String s, Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            int i = s.hashCode();
            AnalyticsEventsWrapper.getInstance().endSection(i, s, map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-[Analytics]-4.5.5", "Please pass a valid Section Name");
        }
    }

    public static void endSessionManually()
    {
        endSessionManually(null);
    }

    public static void endSessionManually(Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        } else
        {
            AnalyticsEventsWrapper.getInstance().endSession(map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
    }

    public static void reportCustomGoal(String s)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            IMAdTracker.getInstance().reportCustomGoal(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Unable to report custom goal due to unexpected exception.", s);
        }
    }

    public static void setUserAttribute(String s, String s1)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            AnalyticsEventsWrapper.getInstance().setUserAttribute(s, s1);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Unable to set user attribute unexpected exception.", s);
        }
        return;
    }

    public static void startSessionManually()
    {
        startSessionManually(null);
    }

    public static void startSessionManually(Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        } else
        {
            AnalyticsEventsWrapper.getInstance().startSession(InMobi.getAppId(), map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
    }

    public static void tagEvent(String s)
    {
        tagEvent(s, null);
    }

    public static void tagEvent(String s, Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            AnalyticsEventsWrapper.getInstance().tagEvent(s, map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Unable to tag event due to unexpected exception.", s);
        }
    }

    public static void tagTransactionManually(Intent intent, Bundle bundle)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            AnalyticsEventsWrapper.getInstance().tagTransactionManually(intent, bundle);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Unable to tag transaction due to unexpected exception.", intent);
        }
    }
}
