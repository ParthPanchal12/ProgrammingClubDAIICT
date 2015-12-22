// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.androidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.net.URLEncoder;

public class IMAdTrackerReceiver extends BroadcastReceiver
{

    public IMAdTrackerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (context == null)
        {
            Log.debug("[InMobi]-4.5.5", "Application Context NULL");
            Log.debug("[InMobi]-4.5.5", "context cannot be null");
        } else
        {
            if (intent.getAction().equals("com.android.vending.INSTALL_REFERRER"))
            {
                try
                {
                    Log.debug("[InMobi]-[AdTracker]-4.5.5", "Received INSTALL REFERRER");
                    intent = intent.getExtras().getString("referrer");
                    Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Referrer String: ").append(intent).toString());
                    FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "rfs", 1);
                    intent = URLEncoder.encode(intent, "utf-8");
                    AdTrackerUtils.setInternalReferrer(context.getApplicationContext(), intent);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.internal("[InMobi]-[AdTracker]-4.5.5", "Error install receiver", context);
                }
                return;
            }
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && InternalSDKUtil.checkNetworkAvailibility(context))
            {
                try
                {
                    Log.internal("[InMobi]-[AdTracker]-4.5.5", "Received CONNECTIVITY BROADCAST");
                    AdTrackerNetworkInterface.init();
                    AdTrackerNetworkInterface.reportToServer(FileOperations.getPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "mk-siteid"));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.internal("[InMobi]-[AdTracker]-4.5.5", "Connectivity receiver exception", context);
                }
                return;
            }
            if (intent.getAction().equals("com.inmobi.share.id"))
            {
                String s3 = intent.getExtras().getString("AID");
                String s = FileOperations.getPreferences(context, "impref", "IMID");
                String s4 = intent.getExtras().getString("IMID");
                String s1 = FileOperations.getPreferences(context, "impref", "AIDL");
                String s2 = intent.getExtras().getString("AIDL");
                long l = FileOperations.getLongPreferences(context, "impref", "timestamp");
                long l1 = intent.getExtras().getLong("timestamp");
                if (s1 != null && s3 != null)
                {
                    if (!s1.contains(s3))
                    {
                        if (l1 < l)
                        {
                            FileOperations.setPreferences(context, "impref", "IMID", s4);
                        }
                        intent = new Intent();
                        intent.setAction("com.inmobi.share.id");
                        intent.putExtra("IMID", s);
                        intent.putExtra("AIDL", s1);
                        intent.putExtra("timestamp", l);
                        intent.putExtra("AID", DeviceInfo.getAid());
                        context.sendBroadcast(intent);
                    }
                    FileOperations.setPreferences(context, "impref", "AIDL", InternalSDKUtil.union(s2, s1));
                    return;
                }
            }
        }
    }
}
