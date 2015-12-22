// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.carb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.Base64;
import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.configs.PkInitilaizer;
import com.inmobi.monetization.internal.configs.PkParams;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.monetization.internal.carb:
//            CarbInitializer, CarbConfigParams, CarbInfo

public class CARB
{
    public static interface CarbCallback
    {

        public abstract void postFailed();

        public abstract void postSuccess();
    }


    public static final String LOGGING_TAG = "[InMobi]-[CARB]-4.5.5";
    private static CARB g = new CARB();
    private static SharedPreferences j;
    private static AtomicBoolean k = new AtomicBoolean(false);
    private static Thread l;
    private static AtomicBoolean m = new AtomicBoolean(false);
    private static Thread n;
    private static String o = "";
    private static String p = "";
    private static String q = "";
    byte a[];
    byte b[];
    String c;
    String d;
    String e;
    CarbCallback f;
    private String h;
    private String i;
    private final int r = 8;
    private final int s = 16;
    private byte t[];
    private byte u[];
    private byte v[];
    private byte w[];
    private ArrayList x;

    private CARB()
    {
        h = "carb_last_req_time";
        i = "carbpreference";
        c = "";
        d = "";
        e = "";
        f = null;
        x = new ArrayList();
        CarbInitializer.initialize();
        j = InternalSDKUtil.getContext().getSharedPreferences(i, 0);
    }

    static SharedPreferences a()
    {
        return j;
    }

    static String a(CARB carb, String s1, byte abyte0[], byte abyte1[], byte abyte2[], String s2, String s3)
    {
        return carb.a(s1, abyte0, abyte1, abyte2, s2, s3);
    }

    private String a(String s1, byte abyte0[], byte abyte1[], byte abyte2[], String s2, String s3)
    {
        s1 = EncryptionUtils.SeMeGe(s1, abyte0, abyte1, abyte2, s2, s3);
        abyte0 = new StringBuilder();
        abyte0.append("sm=");
        abyte0.append(s1);
        abyte0.append("&sn=");
        abyte0.append(e);
        s1 = abyte0.toString();
        Log.internal("[InMobi]-[CARB]-4.5.5", s1);
        return s1;
    }

    static void a(CARB carb)
    {
        carb.c();
    }

    static void a(CARB carb, ArrayList arraylist, String s1, int i1)
    {
        carb.a(arraylist, s1, i1);
    }

    private void a(ArrayList arraylist, String s1, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (m.compareAndSet(false, true))
        {
            m.set(true);
            n = new Thread(new Runnable(arraylist, s1, i1) {

                int a;
                final ArrayList b;
                final String c;
                final int d;
                final CARB e;

                private int a(String s2)
                {
                    if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
                    {
                        return -1;
                    }
                    Object obj;
                    Object obj1;
                    obj = new URL(CarbInitializer.getConfigParams().getCarbPostpoint());
                    obj1 = (HttpURLConnection)((URL) (obj)).openConnection();
                    ((HttpURLConnection) (obj1)).setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
                    long l1 = CarbInitializer.getConfigParams().getTimeoutInterval() * 1000L;
                    ((HttpURLConnection) (obj1)).setConnectTimeout((int)l1);
                    ((HttpURLConnection) (obj1)).setReadTimeout((int)l1);
                    ((HttpURLConnection) (obj1)).setRequestProperty("user-agent", DeviceInfo.getPhoneDefaultUserAgent());
                    ((HttpURLConnection) (obj1)).setUseCaches(false);
                    ((HttpURLConnection) (obj1)).setDoOutput(true);
                    ((HttpURLConnection) (obj1)).setDoInput(true);
                    ((HttpURLConnection) (obj1)).setRequestMethod("POST");
                    ((HttpURLConnection) (obj1)).setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    ((HttpURLConnection) (obj1)).setRequestProperty("Content-Length", Integer.toString(s2.length()));
                    try
                    {
                        InetAddress.getByName(((URL) (obj)).getHost());
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s2)
                    {
                        try
                        {
                            throw new MalformedURLException((new StringBuilder()).append("Malformed URL: ").append(((URL) (obj)).toString()).toString());
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s2)
                        {
                            Log.internal("[InMobi]-[CARB]-4.5.5", "Malformed URL");
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s2) { }
                        return -1;
                    }
                    obj = new BufferedWriter(new OutputStreamWriter(((HttpURLConnection) (obj1)).getOutputStream()));
                    ((BufferedWriter) (obj)).write(s2);
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_159;
                    }
                    ((BufferedWriter) (obj)).close();
_L2:
                    if (((HttpURLConnection) (obj1)).getResponseCode() == 200)
                    {
                        return 200;
                    }
                    break; /* Loop/switch isn't completed */
                    s2;
                    Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Exception closing resource: ").append(obj).toString(), s2);
                    if (true) goto _L2; else goto _L1
                    s2;
                    obj = null;
_L5:
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_258;
                    }
                    ((BufferedWriter) (obj)).close();
_L3:
                    throw s2;
                    obj1;
                    Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Exception closing resource: ").append(obj).toString(), ((Throwable) (obj1)));
                      goto _L3
_L1:
                    int j1 = ((HttpURLConnection) (obj1)).getResponseCode();
                    return j1;
                    s2;
                    if (true) goto _L5; else goto _L4
_L4:
                }

                private String a(ArrayList arraylist1, String s2, int j1)
                {
                    StringBuffer stringbuffer = new StringBuffer();
                    stringbuffer.append("req_id=");
                    stringbuffer.append(CARB.getURLEncoded(s2));
                    s2 = new JSONArray();
                    int l1 = arraylist1.size();
                    for (int k1 = 0; k1 < l1; k1++)
                    {
                        s2.put(((CarbInfo)arraylist1.get(k1)).getInmId());
                    }

                    stringbuffer.append("&p_a_apps=");
                    stringbuffer.append(CARB.getURLEncoded(s2.toString()));
                    stringbuffer.append("&i_till=");
                    stringbuffer.append(j1);
                    arraylist1 = CarbInitializer.getConfigParams().getDeviceIdMaskMap();
                    arraylist1 = UID.getInstance().getJSON(arraylist1);
                    stringbuffer.append("&u-id-map=");
                    stringbuffer.append(CARB.getURLEncoded(arraylist1));
                    return stringbuffer.toString();
                }

                public void run()
                {
                    CARB.h(e);
                    CARB.b(e, EncryptionUtils.keag());
                    e.c = PkInitilaizer.getConfigParams().getExponent();
                    e.d = PkInitilaizer.getConfigParams().getModulus();
                    e.e = PkInitilaizer.getConfigParams().getVersion();
                    if (e.c.equals("") || e.d.equals("") || e.e.equals(""))
                    {
                        Log.internal("[InMobi]-[CARB]-4.5.5", "Exception retreiving Carb info due to key problem");
                        CARB.f(e);
                        return;
                    }
                    String s2 = a(b, c, d);
                    Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("PostBody Before encryption: ").append(s2).toString());
                    s2 = CARB.a(e, s2, CARB.i(e), CARB.j(e), e.b, e.d, e.c);
                    if (s2 == null)
                    {
                        Log.internal("[InMobi]-[CARB]-4.5.5", "POST message cannot be encrypted");
                        CARB.b(e);
                        return;
                    }
                    int j1 = a(s2);
                    Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("Post Response to CARB server: ").append(j1).toString());
                    if (200 == j1)
                    {
                        if (e.f != null)
                        {
                            e.f.postSuccess();
                        }
                        CARB.f(e);
                        return;
                    }
                    if (e.f != null)
                    {
                        e.f.postFailed();
                    }
                    j1 = CarbInitializer.getConfigParams().getRetryCount();
                    long l1 = CarbInitializer.getConfigParams().getRetryInterval();
                    if (a <= j1)
                    {
                        try
                        {
                            Thread.sleep(l1 * 1000L * (long)a);
                        }
                        catch (InterruptedException interruptedexception) { }
                        Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("POSt to carb failed. Retrying count: ").append(a).toString());
                        a = a + 1;
                        if (Looper.myLooper() == null)
                        {
                            Looper.prepare();
                        }
                        (new Handler()).postDelayed(this, 0L);
                        Looper.loop();
                        Looper.myLooper().quit();
                        return;
                    } else
                    {
                        a = 0;
                        CARB.f(e);
                        return;
                    }
                }

            
            {
                e = CARB.this;
                b = arraylist;
                c = s1;
                d = i1;
                super();
                a = 1;
            }
            });
            n.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        arraylist;
        throw arraylist;
    }

    static boolean a(CARB carb, String s1)
    {
        return carb.a(s1);
    }

    private boolean a(String s1)
    {
        PackageManager packagemanager = InternalSDKUtil.getContext().getPackageManager();
        try
        {
            packagemanager.getPackageInfo(s1, 256);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return false;
        }
        return true;
    }

    static byte[] a(CARB carb, byte abyte0[])
    {
        carb.t = abyte0;
        return abyte0;
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        x.clear();
        if (k.compareAndSet(false, true))
        {
            l = new Thread(new Runnable() {

                int a;
                final CARB b;

                private int a(String s1)
                {
                    Object obj;
                    int j1;
                    obj = null;
                    j1 = 0;
                    if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
                    {
                        return -1;
                    }
                    Object obj1;
                    Object obj2;
                    obj1 = new URL(CarbInitializer.getConfigParams().getCarbEndpoint());
                    obj2 = (HttpURLConnection)((URL) (obj1)).openConnection();
                    ((HttpURLConnection) (obj2)).setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
                    long l1 = CarbInitializer.getConfigParams().getTimeoutInterval() * 1000L;
                    ((HttpURLConnection) (obj2)).setConnectTimeout((int)l1);
                    ((HttpURLConnection) (obj2)).setReadTimeout((int)l1);
                    ((HttpURLConnection) (obj2)).setRequestProperty("user-agent", DeviceInfo.getPhoneDefaultUserAgent());
                    ((HttpURLConnection) (obj2)).setUseCaches(false);
                    ((HttpURLConnection) (obj2)).setDoOutput(true);
                    ((HttpURLConnection) (obj2)).setDoInput(true);
                    ((HttpURLConnection) (obj2)).setRequestMethod("POST");
                    ((HttpURLConnection) (obj2)).setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    ((HttpURLConnection) (obj2)).setRequestProperty("Content-Length", Integer.toString(s1.length()));
                    InetAddress.getByName(((URL) (obj1)).getHost());
                    obj1 = new BufferedWriter(new OutputStreamWriter(((HttpURLConnection) (obj2)).getOutputStream()));
                    ((BufferedWriter) (obj1)).write(s1);
                    if (obj1 == null)
                    {
                        break MISSING_BLOCK_LABEL_176;
                    }
                    ((BufferedWriter) (obj1)).close();
_L8:
                    Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("Get CARB list status: ").append(((HttpURLConnection) (obj2)).getResponseCode()).toString());
                    if (((HttpURLConnection) (obj2)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
                    s1 = CARB.a().edit();
                    s1.putLong(CARB.e(b), System.currentTimeMillis());
                    s1.commit();
                    s1 = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj2)).getInputStream(), "UTF-8"));
                    obj1 = new StringBuilder();
_L5:
                    obj2 = s1.readLine();
                    if (obj2 == null) goto _L4; else goto _L3
_L3:
                    ((StringBuilder) (obj1)).append(((String) (obj2))).append("\n");
                      goto _L5
_L7:
                    return -1;
                    s1;
                    int i1;
                    try
                    {
                        throw new MalformedURLException((new StringBuilder()).append("Malformed URL: ").append(((URL) (obj1)).toString()).toString());
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s1)
                    {
                        Log.internal("[InMobi]-[CARB]-4.5.5", "Malformed URL");
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s1) { }
                    // Misplaced declaration of an exception variable
                    catch (String s1)
                    {
                        Log.internal("[InMobi]-[CARB]-4.5.5", "Invalid JSON response");
                    }
                    if (true) goto _L7; else goto _L6
_L6:
                    s1;
                    Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Exception closing resource: ").append(obj1).toString(), s1);
                      goto _L8
                    s1;
                    obj = null;
_L17:
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_396;
                    }
                    ((BufferedWriter) (obj)).close();
_L9:
                    throw s1;
                    obj1;
                    Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Exception closing resource: ").append(obj).toString(), ((Throwable) (obj1)));
                      goto _L9
_L4:
                    s1 = ((StringBuilder) (obj1)).toString();
                    Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("RESPONSE: ").append(s1).toString());
                    s1 = new String(EncryptionUtils.DeAe(Base64.decode(s1.getBytes(), 0), CARB.c(b), CARB.d(b)));
_L16:
                    if (s1 == null) goto _L11; else goto _L10
_L10:
                    Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("Get list after decryption: ").append(s1).toString());
                    s1 = new JSONObject(s1);
                    if (!s1.getBoolean("success")) goto _L13; else goto _L12
_L12:
                    obj = s1.getJSONObject("data");
                    s1 = ((JSONObject) (obj)).getString("req_id");
                    obj = ((JSONObject) (obj)).getJSONArray("p_apps");
                    if (((JSONArray) (obj)).length() != 0) goto _L15; else goto _L14
_L14:
                    CARB.b(b);
                    return -1;
                    s1;
                    Log.internal("[InMobi]-[CARB]-4.5.5", "Exception in carb ", s1);
                    s1 = ((String) (obj));
                      goto _L16
_L11:
                    Log.internal("[InMobi]-[CARB]-4.5.5", "Unable to decrypt response or response not encrypted");
                    CARB.b(b);
                    return -1;
_L18:
                    if (i1 >= ((JSONArray) (obj)).length())
                    {
                        break MISSING_BLOCK_LABEL_725;
                    }
                    obj2 = ((JSONArray) (obj)).getJSONObject(i1);
                    obj1 = ((JSONObject) (obj2)).getString("bid");
                    obj2 = ((JSONObject) (obj2)).getString("inm_id");
                    if (obj2 == null)
                    {
                        break MISSING_BLOCK_LABEL_781;
                    }
                    if ("".equals(obj2))
                    {
                        break MISSING_BLOCK_LABEL_781;
                    }
                    break MISSING_BLOCK_LABEL_676;
                    obj1;
                    Log.internal("[InMobi]-[CARB]-4.5.5", "BID or INM missing");
                    break MISSING_BLOCK_LABEL_781;
                    CarbInfo carbinfo = new CarbInfo();
                    carbinfo.setBid(((String) (obj1)));
                    carbinfo.setInmId(((String) (obj2)));
                    if (!CARB.a(b, ((String) (obj1))))
                    {
                        CARB.g(b).add(carbinfo);
                    }
                    break MISSING_BLOCK_LABEL_781;
                    CARB.a(b, CARB.g(b), s1, j1 + 1);
_L13:
                    CARB.b(b);
                    return 200;
_L2:
                    i1 = ((HttpURLConnection) (obj2)).getResponseCode();
                    return i1;
                    s1;
                    obj = obj1;
                      goto _L17
_L15:
                    i1 = 0;
                      goto _L18
                    j1 = i1;
                    i1++;
                      goto _L18
                }

                private void a()
                {
                    CARB.a(b);
                    CARB.a(b, EncryptionUtils.keag());
                    b.c = PkInitilaizer.getConfigParams().getExponent();
                    b.d = PkInitilaizer.getConfigParams().getModulus();
                    b.e = PkInitilaizer.getConfigParams().getVersion();
                    if (b.c.equals("") || b.d.equals("") || b.e.equals(""))
                    {
                        Log.internal("[InMobi]-[CARB]-4.5.5", "Exception retreiving Carb info due to key problem");
                        CARB.b(b);
                    } else
                    {
                        String s1 = b();
                        Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("Unencrypted postbody :").append(s1).toString());
                        s1 = CARB.a(b, s1, CARB.c(b), CARB.d(b), b.a, b.d, b.c);
                        if (s1 == null)
                        {
                            CARB.b(b);
                            return;
                        }
                        if (a(s1) != 200)
                        {
                            int i1 = CarbInitializer.getConfigParams().getRetryCount();
                            long l1 = CarbInitializer.getConfigParams().getRetryInterval();
                            if (a <= i1)
                            {
                                android.content.SharedPreferences.Editor editor;
                                try
                                {
                                    Thread.sleep(l1 * 1000L * (long)a);
                                }
                                catch (InterruptedException interruptedexception) { }
                                Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("Get carb info Failed. Retrying count: ").append(a).toString());
                                a = a + 1;
                                if (Looper.myLooper() == null)
                                {
                                    Looper.prepare();
                                }
                                (new Handler()).postDelayed(this, 0L);
                                Looper.loop();
                                Looper.myLooper().quit();
                                return;
                            } else
                            {
                                a = 0;
                                editor = CARB.a().edit();
                                editor.putLong(CARB.e(b), System.currentTimeMillis());
                                editor.commit();
                                CARB.f(b);
                                return;
                            }
                        }
                    }
                }

                private String b()
                {
                    Object obj;
                    StringBuffer stringbuffer;
                    stringbuffer = new StringBuffer();
                    CARB.fillCarbInfo();
                    stringbuffer.append("mk-siteid=");
                    stringbuffer.append(CARB.getURLEncoded(InMobi.getAppId()));
                    obj = (new StringBuilder()).append("pr-SAND-").append(InternalSDKUtil.getInMobiInternalVersion("4.5.5")).append("-").append("20150522").toString();
                    stringbuffer.append("&mk-version=");
                    stringbuffer.append(CARB.getURLEncoded(((String) (obj))));
                    obj = CarbInitializer.getConfigParams().getDeviceIdMaskMap();
                    obj = UID.getInstance().getJSON(((java.util.Map) (obj)));
                    stringbuffer.append("&u-id-map=");
                    stringbuffer.append(CARB.getURLEncoded(((String) (obj))));
                    stringbuffer.append("&u-appbid=");
                    stringbuffer.append(CARB.getURLEncoded(CARB.getAppBid()));
                    stringbuffer.append("&u-appver=");
                    stringbuffer.append(CARB.getURLEncoded(CARB.getAppVer()));
                    stringbuffer.append("&h-user-agent=");
                    stringbuffer.append(CARB.getURLEncoded(DeviceInfo.getPhoneDefaultUserAgent()));
                    stringbuffer.append("&d-localization=");
                    stringbuffer.append(CARB.getURLEncoded(DeviceInfo.getLocalization()));
                    stringbuffer.append("&d-nettype=");
                    stringbuffer.append(CARB.getURLEncoded(DeviceInfo.getNetworkType()));
                    obj = null;
                    WifiInfo wifiinfo = IceDataCollector.getConnectedWifiInfo(InternalSDKUtil.getContext());
                    obj = wifiinfo;
_L2:
                    if (obj != null)
                    {
                        stringbuffer.append("&c-ap-bssid=");
                        stringbuffer.append(Long.toString(((WifiInfo) (obj)).bssid));
                    }
                    return stringbuffer.toString();
                    Exception exception1;
                    exception1;
                    Log.internal("[InMobi]-4.5.5", "No wifi permissions set, unable to send wifi data");
                    if (true) goto _L2; else goto _L1
_L1:
                }

                public void run()
                {
                    a();
                }

            
            {
                b = CARB.this;
                super();
                a = 1;
            }
            });
            l.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void b(CARB carb)
    {
        carb.e();
    }

    static byte[] b(CARB carb, byte abyte0[])
    {
        carb.v = abyte0;
        return abyte0;
    }

    private void c()
    {
        try
        {
            a = new byte[8];
            SecureRandom securerandom = new SecureRandom();
            securerandom.nextBytes(a);
            u = new byte[16];
            securerandom.nextBytes(u);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    static byte[] c(CARB carb)
    {
        return carb.t;
    }

    private void d()
    {
        try
        {
            b = new byte[8];
            SecureRandom securerandom = new SecureRandom();
            securerandom.nextBytes(b);
            w = new byte[16];
            securerandom.nextBytes(w);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    static byte[] d(CARB carb)
    {
        return carb.u;
    }

    static String e(CARB carb)
    {
        return carb.h;
    }

    private void e()
    {
        if (k != null)
        {
            k.set(false);
        }
    }

    private void f()
    {
        if (m != null)
        {
            m.set(false);
        }
    }

    static void f(CARB carb)
    {
        carb.f();
    }

    public static void fillCarbInfo()
    {
        Object obj;
        Object obj1;
        Object obj2;
        try
        {
            obj = InternalSDKUtil.getContext();
            obj1 = ((Context) (obj)).getPackageManager();
            obj2 = ((PackageManager) (obj1)).getApplicationInfo(((Context) (obj)).getPackageName(), 128);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Failed to fill CarbInfo", exception);
            return;
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        setAppBId(((ApplicationInfo) (obj2)).packageName);
        setAppDisplayName(((ApplicationInfo) (obj2)).loadLabel(((PackageManager) (obj1))).toString());
        obj2 = ((PackageManager) (obj1)).getPackageInfo(((Context) (obj)).getPackageName(), 128);
        obj = null;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj1 = ((PackageInfo) (obj2)).versionName;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        obj = obj1;
        if (!((String) (obj1)).equals(""))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj = (new StringBuilder()).append(((PackageInfo) (obj2)).versionCode).append("").toString();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (!((String) (obj)).equals(""))
        {
            setAppVer(((String) (obj)));
        }
    }

    static ArrayList g(CARB carb)
    {
        return carb.x;
    }

    public static String getAppBid()
    {
        return o;
    }

    public static String getAppDisplayName()
    {
        return q;
    }

    public static String getAppVer()
    {
        return p;
    }

    public static Object getCountryISO(Context context)
    {
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if (telephonymanager.getNetworkCountryIso().equals(""))
        {
            return context.getResources().getConfiguration().locale.getISO3Country();
        } else
        {
            return telephonymanager.getNetworkCountryIso();
        }
    }

    public static CARB getInstance()
    {
        return g;
    }

    public static String getURLDecoded(String s1, String s2)
    {
        try
        {
            s1 = URLDecoder.decode(s1, s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return "";
        }
        return s1;
    }

    public static String getURLEncoded(String s1)
    {
        try
        {
            s1 = URLEncoder.encode(s1, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return "";
        }
        return s1;
    }

    static void h(CARB carb)
    {
        carb.d();
    }

    static byte[] i(CARB carb)
    {
        return carb.v;
    }

    static byte[] j(CARB carb)
    {
        return carb.w;
    }

    public static void setAppBId(String s1)
    {
        o = s1;
    }

    public static void setAppDisplayName(String s1)
    {
        q = s1;
    }

    public static void setAppVer(String s1)
    {
        p = s1;
    }

    public void setCallBack(CarbCallback carbcallback)
    {
        f = carbcallback;
    }

    public void startCarb()
    {
        this;
        JVM INSTR monitorenter ;
        if (CarbInitializer.getConfigParams().isCarbEnabled()) goto _L2; else goto _L1
_L1:
        Log.internal("[InMobi]-[CARB]-4.5.5", "CARB feature disabled.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) goto _L4; else goto _L3
_L3:
        long l1 = j.getLong(h, 0L);
        if (0L != l1)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (!k.get())
        {
            break MISSING_BLOCK_LABEL_76;
        }
        Log.internal("[InMobi]-[CARB]-4.5.5", "First CARB request is in progress");
          goto _L4
        Exception exception;
        exception;
        throw exception;
        Log.internal("[InMobi]-[CARB]-4.5.5", "Requesting CARB first time");
        b();
          goto _L4
label0:
        {
            if ((l1 + CarbInitializer.getConfigParams().getRetreiveFrequncy()) - System.currentTimeMillis() > 0L)
            {
                break MISSING_BLOCK_LABEL_143;
            }
            if (!k.get())
            {
                break label0;
            }
            Log.internal("[InMobi]-[CARB]-4.5.5", "CARB request is in progress");
        }
          goto _L4
        Log.internal("[InMobi]-[CARB]-4.5.5", "CARB request interval reached. Requesting again");
        b();
          goto _L4
        Log.internal("[InMobi]-[CARB]-4.5.5", "CARB request interval not reached. NO request");
          goto _L4
    }

}
