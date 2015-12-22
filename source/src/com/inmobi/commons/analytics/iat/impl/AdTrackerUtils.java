// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl;

import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl:
//            Goal, GoalList

public class AdTrackerUtils
{

    public AdTrackerUtils()
    {
    }

    public static boolean checkDownloadGoalAdded()
    {
        if (InternalSDKUtil.getContext() == null)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Application Context NULL cannot checkStatusUpload");
            return false;
        } else
        {
            return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "insertStatus");
        }
    }

    public static boolean checkDownloadGoalUploaded()
    {
        if (InternalSDKUtil.getContext() == null)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Application Context NULL cannot checkStatusUpload");
            return false;
        } else
        {
            return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus");
        }
    }

    public static String getReferrerFromLogs()
    {
        Pattern pattern;
        BufferedReader bufferedreader;
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Getting referrer from logs");
        pattern = Pattern.compile(AdTrackerInitializer.getConfigParams().getLogcatPattern());
        bufferedreader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] {
            "logcat", "-d", "ActivityManager:I"
        }).getInputStream()));
        String s = null;
_L2:
        String s1 = s;
        s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        Matcher matcher = pattern.matcher(s);
        s = s1;
        if (!matcher.find()) goto _L2; else goto _L1
_L1:
        s = matcher.group(1);
          goto _L2
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Received referrer from logs: ").append(s1).toString());
        return s1;
        Exception exception;
        exception;
        s1 = null;
_L4:
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Getting referrer from logs failed", exception);
        return s1;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isPermissionGranted(String s)
    {
        int i = InternalSDKUtil.getContext().checkCallingOrSelfPermission(s);
        if (i == 0)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_23;
        s;
        Log.internal("[InMobi]-[AdTracker]-4.5.5", "Cant check permissions", s);
        return false;
    }

    public static void reportMetric(AdTrackerEventType adtrackereventtype, Goal goal, int i, long l, int j, String s)
    {
        try
        {
            if (!AdTrackerNetworkInterface.isMetricSample())
            {
                break MISSING_BLOCK_LABEL_218;
            }
            if (AdTrackerEventType.GOAL_SUCCESS.equals(adtrackereventtype))
            {
                adtrackereventtype = new JSONObject();
                adtrackereventtype.put("g", goal.name);
                adtrackereventtype.put("n", goal.retryCount);
                adtrackereventtype.put("t", l);
                adtrackereventtype.put("r", i);
                AdTrackerInitializer.getLogger().logEvent(new EventLog(AdTrackerEventType.GOAL_SUCCESS, adtrackereventtype));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (AdTrackerEventType adtrackereventtype)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Error reporting metric", adtrackereventtype);
            return;
        }
        if (!AdTrackerEventType.GOAL_FAILURE.equals(adtrackereventtype))
        {
            break MISSING_BLOCK_LABEL_171;
        }
        adtrackereventtype = new JSONObject();
        adtrackereventtype.put("g", goal.name);
        adtrackereventtype.put("n", goal.retryCount);
        adtrackereventtype.put("e", j);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        adtrackereventtype.put("m", s);
        AdTrackerInitializer.getLogger().logEvent(new EventLog(AdTrackerEventType.GOAL_FAILURE, adtrackereventtype));
        return;
        adtrackereventtype = new JSONObject();
        adtrackereventtype.put("g", goal.name);
        adtrackereventtype.put("n", goal.retryCount);
        AdTrackerInitializer.getLogger().logEvent(new EventLog(AdTrackerEventType.GOAL_DUMPED, adtrackereventtype));
    }

    public static boolean resetStatus()
    {
        if (InternalSDKUtil.getContext() == null)
        {
            return false;
        } else
        {
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus", false);
            return true;
        }
    }

    public static boolean sendBroadcastMessage(int i)
    {
        try
        {
            Intent intent = new Intent();
            intent.setAction("action.inmobi.ADTRACKER");
            intent.putExtra("iatError", i);
            InternalSDKUtil.getContext().sendBroadcast(intent);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Cant send test broadcast", exception);
            return false;
        }
        return true;
    }

    public static void setInternalReferrer(Context context, String s)
    {
        if (context == null || s == null)
        {
            try
            {
                Log.internal("[InMobi]-[AdTracker]-4.5.5", "Cannot set Market Referrer..Referrer NULL");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.internal("[InMobi]-[AdTracker]-4.5.5", "Cannot set referrer", context);
            }
            break MISSING_BLOCK_LABEL_105;
        }
        if (0L == FileOperations.getLongPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t2"))
        {
            FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t2", System.currentTimeMillis());
        }
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Saving referrer from broadcast receiver: ").append(s).toString());
        if (FileOperations.getPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "referrer") != null)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Install Receiver already set. Download Goal queued");
            return;
        }
        break MISSING_BLOCK_LABEL_106;
        return;
        FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "referrer", s);
        FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "rlc", "0");
        s = FileOperations.getPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "mk-siteid");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (!"".equals(s.trim()))
        {
            break MISSING_BLOCK_LABEL_175;
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.5", "Initialization incomplete. Please call InMobi initialize with a valid app Id");
        return;
        if (FileOperations.getBooleanPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "waitForReferrer"))
        {
            InternalSDKUtil.setContext(context);
            AdTrackerNetworkInterface.init();
            AdTrackerNetworkInterface.getGoalList().addGoal("download", 1, 0L, 0, true);
            AdTrackerNetworkInterface.reportToServer(s);
            return;
        }
        AdTrackerNetworkInterface.onReceiveReferrer(s);
        return;
    }

    public static void setReferrerFromLogs(Context context, String s)
    {
        if (context == null || s == null)
        {
            try
            {
                Log.internal("[InMobi]-[AdTracker]-4.5.5", "Cannot set Market Referrer from logs..Referrer NULL");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.internal("[InMobi]-[AdTracker]-4.5.5", "Cannot set referrer from logs", context);
            }
            break MISSING_BLOCK_LABEL_88;
        }
        if (0L == FileOperations.getLongPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t2"))
        {
            FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t2", System.currentTimeMillis());
        }
        FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "referrer", s);
        FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "rlc", "1");
        return;
    }

    public static boolean updateStatus()
    {
        if (InternalSDKUtil.getContext() == null)
        {
            return false;
        } else
        {
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus", true);
            return true;
        }
    }
}
