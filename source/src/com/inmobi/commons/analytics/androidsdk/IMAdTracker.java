// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.androidsdk;

import android.content.Context;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public final class IMAdTracker
{

    private static IMAdTracker a;

    private IMAdTracker()
    {
    }

    private boolean a(String s)
    {
        String s1 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "mk-siteid");
        if (InternalSDKUtil.getContext() == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        if (!s1.trim().equals(""))
        {
            break MISSING_BLOCK_LABEL_42;
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.5", "Please call init() with valid context and app id");
        return false;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (!"".equals(s.trim()))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.5", "Please pass a valid GoalName");
        return false;
        boolean flag = AdTrackerUtils.checkDownloadGoalUploaded();
        if ("download".equals(s) && flag)
        {
            try
            {
                Log.debug("[InMobi]-[AdTracker]-4.5.5", "Download goal already uploaded");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.internal("[InMobi]-[AdTracker]-4.5.5", "Cannot report goal", s);
                return false;
            }
            return false;
        }
        AdTrackerNetworkInterface.init();
        if (!"download".equals(s))
        {
            break MISSING_BLOCK_LABEL_165;
        }
        if (!AdTrackerUtils.checkDownloadGoalAdded())
        {
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "insertStatus", true);
            Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Goal Queued ").append(s).toString());
            AdTrackerNetworkInterface.getGoalList().addGoal(s, 1, 0L, 0, false);
        }
_L1:
        AdTrackerNetworkInterface.reportToServer(s1);
        return true;
        Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Goal Queued ").append(s).toString());
        AdTrackerNetworkInterface.getGoalList().addGoal(s, 1, 0L, 0, false);
          goto _L1
    }

    public static IMAdTracker getInstance()
    {
        com/inmobi/commons/analytics/androidsdk/IMAdTracker;
        JVM INSTR monitorenter ;
        IMAdTracker imadtracker;
        if (a == null)
        {
            a = new IMAdTracker();
        }
        imadtracker = a;
        com/inmobi/commons/analytics/androidsdk/IMAdTracker;
        JVM INSTR monitorexit ;
        return imadtracker;
        Exception exception;
        exception;
        throw exception;
    }

    public void init(Context context, String s)
    {
        if (context == null)
        {
            try
            {
                Log.debug("[InMobi]-[AdTracker]-4.5.5", "Application Context NULL");
                Log.debug("[InMobi]-[AdTracker]-4.5.5", "context cannot be null");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.internal("[InMobi]-[AdTracker]-4.5.5", "Failed to init", context);
            }
            break MISSING_BLOCK_LABEL_47;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.5", "APP ID Cannot be NULL");
        Log.debug("[InMobi]-[AdTracker]-4.5.5", "appId cannot be null");
        return;
        return;
        if (s.trim().equals(""))
        {
            Log.debug("[InMobi]-[AdTracker]-4.5.5", "appId cannot be blank");
            return;
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.5", "IMAdtracker init successfull");
        FileOperations.setPreferences(context, "IMAdTrackerStatusUpload", "mk-siteid", s);
        if (!AdTrackerUtils.isPermissionGranted("android.permission.INTERNET") || !AdTrackerUtils.isPermissionGranted("android.permission.ACCESS_NETWORK_STATE"))
        {
            Log.debug("[InMobi]-[AdTracker]-4.5.5", "Add android.permission.INTERNET and android.permission.ACCESS_NETWORK_STATE permission in Android manifest");
            return;
        }
        if (android.os.Build.VERSION.SDK_INT < 17 && !AdTrackerUtils.isPermissionGranted("android.permission.READ_LOGS"))
        {
            Log.debug("[InMobi]-[AdTracker]-4.5.5", "Add android.permission.READ_LOGS permission in Android Manifest");
        }
        if (0L == FileOperations.getLongPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t1"))
        {
            FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t1", System.currentTimeMillis());
        }
        return;
    }

    public void reportAppDownloadGoal()
    {
        a("download");
    }

    public void reportCustomGoal(String s)
    {
        if ("download".equals(s))
        {
            Log.debug("[InMobi]-[AdTracker]-4.5.5", "Download Goal should be reported using reportAppDownloadGoal()..");
            return;
        } else
        {
            a(s);
            return;
        }
    }
}
