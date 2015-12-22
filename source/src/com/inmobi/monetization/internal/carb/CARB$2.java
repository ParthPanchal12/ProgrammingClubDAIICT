// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.carb;

import android.os.Handler;
import android.os.Looper;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.configs.PkInitilaizer;
import com.inmobi.monetization.internal.configs.PkParams;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.json.JSONArray;

// Referenced classes of package com.inmobi.monetization.internal.carb:
//            CARB, CarbInitializer, CarbConfigParams, CarbInfo

class a
    implements Runnable
{

    int a;
    final ArrayList b;
    final String c;
    final int d;
    final CARB e;

    private int a(String s)
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
        long l = CarbInitializer.getConfigParams().getTimeoutInterval() * 1000L;
        ((HttpURLConnection) (obj1)).setConnectTimeout((int)l);
        ((HttpURLConnection) (obj1)).setReadTimeout((int)l);
        ((HttpURLConnection) (obj1)).setRequestProperty("user-agent", DeviceInfo.getPhoneDefaultUserAgent());
        ((HttpURLConnection) (obj1)).setUseCaches(false);
        ((HttpURLConnection) (obj1)).setDoOutput(true);
        ((HttpURLConnection) (obj1)).setDoInput(true);
        ((HttpURLConnection) (obj1)).setRequestMethod("POST");
        ((HttpURLConnection) (obj1)).setRequestProperty("content-type", "application/x-www-form-urlencoded");
        ((HttpURLConnection) (obj1)).setRequestProperty("Content-Length", Integer.toString(s.length()));
        try
        {
            InetAddress.getByName(((URL) (obj)).getHost());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                throw new MalformedURLException((new StringBuilder()).append("Malformed URL: ").append(((URL) (obj)).toString()).toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.internal("[InMobi]-[CARB]-4.5.5", "Malformed URL");
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            return -1;
        }
        obj = new BufferedWriter(new OutputStreamWriter(((HttpURLConnection) (obj1)).getOutputStream()));
        ((BufferedWriter) (obj)).write(s);
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
        s;
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Exception closing resource: ").append(obj).toString(), s);
        if (true) goto _L2; else goto _L1
        s;
        obj = null;
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        ((BufferedWriter) (obj)).close();
_L3:
        throw s;
        obj1;
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Exception closing resource: ").append(obj).toString(), ((Throwable) (obj1)));
          goto _L3
_L1:
        int i = ((HttpURLConnection) (obj1)).getResponseCode();
        return i;
        s;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private String a(ArrayList arraylist, String s, int i)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("req_id=");
        stringbuffer.append(CARB.getURLEncoded(s));
        s = new JSONArray();
        int k = arraylist.size();
        for (int j = 0; j < k; j++)
        {
            s.put(((CarbInfo)arraylist.get(j)).getInmId());
        }

        stringbuffer.append("&p_a_apps=");
        stringbuffer.append(CARB.getURLEncoded(s.toString()));
        stringbuffer.append("&i_till=");
        stringbuffer.append(i);
        arraylist = CarbInitializer.getConfigParams().getDeviceIdMaskMap();
        arraylist = UID.getInstance().getJSON(arraylist);
        stringbuffer.append("&u-id-map=");
        stringbuffer.append(CARB.getURLEncoded(arraylist));
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
        String s = a(b, c, d);
        Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("PostBody Before encryption: ").append(s).toString());
        s = CARB.a(e, s, CARB.i(e), CARB.j(e), e.b, e.d, e.c);
        if (s == null)
        {
            Log.internal("[InMobi]-[CARB]-4.5.5", "POST message cannot be encrypted");
            CARB.b(e);
            return;
        }
        int i = a(s);
        Log.internal("[InMobi]-[CARB]-4.5.5", (new StringBuilder()).append("Post Response to CARB server: ").append(i).toString());
        if (200 == i)
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
        i = CarbInitializer.getConfigParams().getRetryCount();
        long l = CarbInitializer.getConfigParams().getRetryInterval();
        if (a <= i)
        {
            try
            {
                Thread.sleep(l * 1000L * (long)a);
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

    rbCallback(CARB carb, ArrayList arraylist, String s, int i)
    {
        e = carb;
        b = arraylist;
        c = s;
        d = i;
        super();
        a = 1;
    }
}
