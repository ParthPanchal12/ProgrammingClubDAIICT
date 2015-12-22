// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.umeng.common.message.DeviceConfig;
import com.umeng.common.message.Log;
import com.umeng.message.MessageSharedPrefs;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message.proguard:
//            s, ax, as, g

public class aE
{

    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private static final String i = com/umeng/message/proguard/aE.getName();
    private final int d = 1;
    private String e;
    private String f;
    private int g;
    private Context h;

    public aE(Context context)
    {
        f = "10.0.0.172";
        g = 80;
        h = context;
        e = a(context);
    }

    private aB.a a(byte abyte0[])
    {
        Object obj = null;
        try
        {
            abyte0 = aB.a.a(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            abyte0 = obj;
        }
        Log.a(i, (new StringBuilder()).append("NetWork Response code:").append(abyte0.p()).append(",").append("msg:").append(abyte0.r()).toString());
        return abyte0;
    }

    private String a(Context context)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("1.7.0");
        stringbuffer.append("/");
        stringbuffer.append("1.7.0");
        stringbuffer.append(" ");
        try
        {
            StringBuffer stringbuffer1 = new StringBuffer();
            stringbuffer1.append(DeviceConfig.getApplicationLable(context));
            stringbuffer1.append("/");
            stringbuffer1.append(DeviceConfig.getAppVersionName(context));
            stringbuffer1.append(" ");
            stringbuffer1.append(Build.MODEL);
            stringbuffer1.append("/");
            stringbuffer1.append(android.os.Build.VERSION.RELEASE);
            stringbuffer1.append(" ");
            stringbuffer1.append(ax.a(DeviceConfig.getAppkey(context)));
            stringbuffer.append(URLEncoder.encode(stringbuffer1.toString(), "UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return stringbuffer.toString();
    }

    private boolean a()
    {
        if (h.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", h.getPackageName()) != 0)
        {
            return false;
        }
        Object obj = ((ConnectivityManager)h.getSystemService("connectivity")).getActiveNetworkInfo();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        if (((NetworkInfo) (obj)).getType() == 1)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        obj = ((NetworkInfo) (obj)).getExtraInfo();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        boolean flag;
        if (((String) (obj)).equals("cmwap") || ((String) (obj)).equals("3gwap"))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        flag = ((String) (obj)).equals("uniwap");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        return true;
        Exception exception;
        exception;
        exception.printStackTrace();
        return false;
    }

    private byte[] b(byte abyte0[], String s1)
    {
        HttpPost httppost;
        Object obj;
        httppost = new HttpPost(s1);
        obj = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), 10000);
        HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj)), 30000);
        obj = new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj)));
        httppost.addHeader("Msg-Type", "envelope");
        httppost.setEntity(new InputStreamEntity(new ByteArrayInputStream(abyte0), abyte0.length));
        abyte0 = ((HttpClient) (obj)).execute(httppost);
        int j = abyte0.getStatusLine().getStatusCode();
        Log.a(i, (new StringBuilder()).append("status code : ").append(j).toString());
        if (abyte0.getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        Log.a(i, (new StringBuilder()).append("Sent message to ").append(s1).toString());
        abyte0 = abyte0.getEntity();
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        abyte0 = abyte0.getContent();
        s1 = ax.a(abyte0);
        ax.b(abyte0);
        return s1;
        s1;
        try
        {
            ax.b(abyte0);
            throw s1;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.b(i, "ClientProtocolException,Failed to send message.", abyte0);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.b(i, "IOException,Failed to send message.", abyte0);
        }
        break MISSING_BLOCK_LABEL_231;
        return null;
        return null;
        return null;
    }

    public aB.a a(byte abyte0[], String s1)
    {
        abyte0 = b(abyte0, s1);
        if (abyte0 == null)
        {
            return null;
        } else
        {
            return a(abyte0);
        }
    }

    public byte[] a(JSONObject jsonobject)
    {
        aC.a.a a1;
        String s3;
        int j;
        int k;
        a1 = aC.a.K();
        s3 = DeviceConfig.getAppkey(h);
        a1.a("1.0");
        j = MessageSharedPrefs.getInstance(h).getSerialNo();
        a1.a(j);
        a1.b(s3);
        k = (int)(System.currentTimeMillis() / 1000L);
        a1.b(k);
        a1.a(aC.a.b.b);
        String s1 = as.a(new String[] {
            jsonobject.toString(), "utf-8", s3.substring(0, 16)
        });
        a1.i(com.umeng.message.proguard.g.a(s1.getBytes()));
_L1:
        String s2 = ax.a(s1);
        s1 = ax.a((new StringBuilder()).append(s3).append(k).append(ax.a(s1)).toString());
        a1.c(s2);
        a1.d(s1);
        Log.c(i, (new StringBuilder()).append("request = ").append(jsonobject).append("\n mTimestamp = ").append(k).append(",").append("checkSum = ").append(s2).append(",").append(" salt = ").append(s1).toString());
        MessageSharedPrefs.getInstance(h).setSerialNo(j + 1);
        return a1.K().g();
        Object obj;
        obj;
        s1 = null;
_L3:
        ((JSONException) (obj)).printStackTrace();
          goto _L1
        obj;
        s1 = null;
_L2:
        ((Exception) (obj)).printStackTrace();
          goto _L1
        obj;
          goto _L2
        obj;
          goto _L3
    }

}
