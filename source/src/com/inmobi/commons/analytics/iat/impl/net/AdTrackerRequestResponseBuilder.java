// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerNetworkInterface

public class AdTrackerRequestResponseBuilder
{

    private static String a = null;
    private static long b = 0L;

    public AdTrackerRequestResponseBuilder()
    {
    }

    protected static String formHttpRequest(String s, String s1, int i, boolean flag, String s2)
    {
        LinkedList linkedlist = new LinkedList();
        String s3 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
        if (s != null && !s.trim().equals(""))
        {
            linkedlist.add(new BasicNameValuePair("mk-siteid", s));
        }
        s = AdTrackerInitializer.getConfigParams().getDeviceIdMaskMap();
        s = UID.getInstance().getMapForEncryption(s);
        if (UID.getInstance().isLimitAdTrackingEnabled())
        {
            linkedlist.add(new BasicNameValuePair("u-id-adt", "1"));
        } else
        {
            linkedlist.add(new BasicNameValuePair("u-id-adt", "0"));
        }
        linkedlist.add(new BasicNameValuePair("u-id-map", (String)s.get("u-id-map")));
        linkedlist.add(new BasicNameValuePair("u-id-key", (String)s.get("u-id-key")));
        linkedlist.add(new BasicNameValuePair("u-key-ver", (String)s.get("u-key-ver")));
        if (s1 != null && !s1.trim().equals(""))
        {
            linkedlist.add(new BasicNameValuePair("goalName", s1));
        }
        if (flag)
        {
            linkedlist.add(new BasicNameValuePair("lp", "1"));
        } else
        {
            linkedlist.add(new BasicNameValuePair("lp", "0"));
        }
        linkedlist.add(new BasicNameValuePair("src", "and"));
        if (i > 0)
        {
            linkedlist.add(new BasicNameValuePair("goalCount", Integer.toString(i)));
        }
        s = (new StringBuilder()).append("pr-SAND-").append(InternalSDKUtil.getInMobiInternalVersion("4.5.5")).append("-").append("20150522").toString();
        linkedlist.add(new BasicNameValuePair("mk-version", s));
        linkedlist.add(new BasicNameValuePair("mk-rel-version", s));
        linkedlist.add(new BasicNameValuePair("osV", String.valueOf(android.os.Build.VERSION.SDK_INT)));
        s1 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rlc");
        s = s1;
        if (s1 == null)
        {
            s = "0";
        }
        linkedlist.add(new BasicNameValuePair("rlc", s));
        try
        {
            s = InternalSDKUtil.getContext().getPackageManager().getPackageInfo(InternalSDKUtil.getContext().getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "Cant get appversion", s);
            s = null;
        }
        if (s != null && !s.trim().equals(""))
        {
            linkedlist.add(new BasicNameValuePair("u-appver", s));
        }
        if (s2 != null && !s2.trim().equals(""))
        {
            linkedlist.add(new BasicNameValuePair("iat_ids", s2));
        }
        if (s3 != null)
        {
            i = FileOperations.getIntPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rfs");
            long l = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t1");
            long l1 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t2");
            linkedlist.add(new BasicNameValuePair("rfs", Integer.toString(i)));
            linkedlist.add(new BasicNameValuePair("rd", Long.toString(l1 - l)));
        }
        if (1 == AdTrackerNetworkInterface.isUnstableNetwork())
        {
            linkedlist.add(new BasicNameValuePair("nus", Integer.toString(AdTrackerNetworkInterface.isUnstableNetwork())));
        }
        linkedlist.add(new BasicNameValuePair("ts", Long.toString(System.currentTimeMillis())));
        return URLEncodedUtils.format(linkedlist, "utf-8");
    }

    public static String getWebViewRequestParam()
    {
        return a;
    }

    public static com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode reportGoalOverHttp(String s, Goal goal, String s1)
    {
        com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode statuscode;
        Object obj;
        Object obj1;
        Handler handler;
        Message message;
        Object obj2;
        statuscode = com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        obj2 = new DefaultHttpClient();
        obj1 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
        s1 = formHttpRequest(s, goal.name, goal.count, goal.isDuplicate, s1);
        int i = AdTrackerInitializer.getConfigParams().getConnectionTimeout();
        obj = (new StringBuilder()).append(AdTrackerNetworkInterface.a()).append(s1).toString();
        s1 = ((String) (obj));
        if (obj1 != null)
        {
            s1 = (new StringBuilder()).append(((String) (obj))).append("&referrer=").append(((String) (obj1))).toString();
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.5", s1);
        handler = AdTrackerNetworkInterface.c();
        message = Message.obtain();
        message.what = 10;
        message.obj = goal;
        goal = new HttpGet(s1);
        s1 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(s1, i);
        HttpConnectionParams.setSoTimeout(s1, i);
        ((DefaultHttpClient) (obj2)).setParams(s1);
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        b = System.currentTimeMillis();
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        goal = ((DefaultHttpClient) (obj2)).execute(goal);
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        int j = goal.getStatusLine().getStatusCode();
        if (200 != j) goto _L2; else goto _L1
_L1:
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        goal = EntityUtils.toString(goal.getEntity());
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Response: ").append(goal).toString());
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        goal = new JSONObject(goal);
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        obj2 = goal.getString("errmsg");
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        j = goal.getInt("errcode");
        if (6000 != j) goto _L4; else goto _L3
_L3:
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        long l = System.currentTimeMillis();
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        long l1 = b;
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        goal = com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
        s1 = goal;
        obj = goal;
        obj1 = goal;
        message.what = 8;
        s1 = goal;
        obj = goal;
        obj1 = goal;
        message.arg2 = (int)(l - l1);
_L14:
        s1 = goal;
        if (6001 != j)
        {
            break MISSING_BLOCK_LABEL_475;
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Error uploading ping ").append(((String) (obj2))).append("\nReloading webview").toString());
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids", null);
        message.arg2 = j;
        s1 = goal;
_L6:
        goal = new Bundle();
        goal.putString("appId", s);
        message.setData(goal);
        handler.sendMessage(message);
        return s1;
_L4:
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        message.arg2 = j;
        goal = statuscode;
        continue; /* Loop/switch isn't completed */
_L2:
        s1 = statuscode;
        obj = statuscode;
        obj1 = statuscode;
        message.arg2 = j;
        s1 = statuscode;
        if (true) goto _L6; else goto _L5
_L5:
        ClientProtocolException clientprotocolexception;
        clientprotocolexception;
        goal = s1;
_L12:
        message.arg2 = 424;
        clientprotocolexception.printStackTrace();
        s1 = new Bundle();
        s1.putString("appId", s);
        message.setData(s1);
        handler.sendMessage(message);
        return goal;
        s1;
        goal = ((Goal) (obj));
_L10:
        message.arg2 = 424;
        s1.printStackTrace();
        s1 = new Bundle();
        s1.putString("appId", s);
        message.setData(s1);
        handler.sendMessage(message);
        return goal;
        s1;
        goal = ((Goal) (obj1));
_L8:
        message.arg2 = 424;
        s1.printStackTrace();
        s1 = new Bundle();
        s1.putString("appId", s);
        message.setData(s1);
        handler.sendMessage(message);
        return goal;
        goal;
        s1 = new Bundle();
        s1.putString("appId", s);
        message.setData(s1);
        handler.sendMessage(message);
        throw goal;
        s1;
        if (true) goto _L8; else goto _L7
_L7:
        s1;
        if (true) goto _L10; else goto _L9
_L9:
        clientprotocolexception;
        if (true) goto _L12; else goto _L11
_L11:
        if (true) goto _L14; else goto _L13
_L13:
    }

    public static void saveWebviewRequestParam(String s, Goal goal)
    {
        a = formHttpRequest(s, goal.name, goal.count, goal.isDuplicate, null);
    }

    public static boolean serverReachable(String s)
    {
        int i = (new DefaultHttpClient()).execute(new HttpGet(s)).getStatusLine().getStatusCode();
        if (i == 200)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_49;
        s;
        Log.debug("[InMobi]-[AdTracker]-4.5.5", "Server not reachable..Logging events");
        return false;
    }

}
