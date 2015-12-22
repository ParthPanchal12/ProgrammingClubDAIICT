// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.net.mtop;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.bt;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package org.android.agoo.net.mtop:
//            MtopRequest

public class MtopRequestHelper
{

    public static final String SPLIT_STR = "&";
    private static final String a = "MtopRequestHelper";

    public MtopRequestHelper()
    {
    }

    private static long a()
    {
        return System.currentTimeMillis() / 1000L;
    }

    private static String a(String s, String s1, String s2, String s3, String s4, String s5, long l, 
            String s6, String s7)
        throws Throwable
    {
        StringBuffer stringbuffer;
        try
        {
            s = bt.a(new ByteArrayInputStream(s.getBytes("UTF-8")));
            stringbuffer = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        if (s7 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        if (!"".equals(s7))
        {
            stringbuffer.append(s7);
            stringbuffer.append("&");
        }
        stringbuffer.append(s1);
        stringbuffer.append("&");
        stringbuffer.append(s);
        stringbuffer.append("&");
        stringbuffer.append(s2);
        stringbuffer.append("&");
        stringbuffer.append(s3);
        stringbuffer.append("&");
        stringbuffer.append(s4);
        stringbuffer.append("&");
        stringbuffer.append(s5);
        stringbuffer.append("&");
        stringbuffer.append(bt.a(new ByteArrayInputStream(s6.getBytes("UTF-8"))));
        stringbuffer.append("&");
        stringbuffer.append(l);
        s = bt.a(new ByteArrayInputStream(stringbuffer.toString().getBytes("UTF-8")));
        return s;
    }

    private static String a(Map map)
    {
        return (new JSONObject(map)).toString();
    }

    public static void checkAppKeyAndAppSecret(MtopRequest mtoprequest, String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && TextUtils.isEmpty(mtoprequest.getAppKey()))
        {
            mtoprequest.setAppKey(s);
        }
        if (!TextUtils.isEmpty(s1) && TextUtils.isEmpty(mtoprequest.getAppSecret()))
        {
            mtoprequest.setAppSecret(s1);
        }
    }

    public static bb getUrlWithRequestParams(Context context, MtopRequest mtoprequest)
        throws Throwable
    {
        context = new bb();
        context.a("api", mtoprequest.getApi());
        context.a("v", mtoprequest.getV());
        long l1 = mtoprequest.getTime();
        long l = l1;
        if (l1 <= 0L)
        {
            l = a();
        }
        context.a("t", (new StringBuilder()).append("").append(l).toString());
        context.a("imei", "umeng");
        context.a("imsi", "umeng");
        context.a("ttid", mtoprequest.getTtId());
        context.a("appKey", mtoprequest.getAppKey());
        if (!TextUtils.isEmpty(mtoprequest.getDeviceId()))
        {
            context.a("deviceId", mtoprequest.getDeviceId());
        }
        Object obj = mtoprequest.getSysParams();
        if (obj != null)
        {
            obj = ((Map) (obj)).entrySet().iterator();
            if (obj != null)
            {
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    if (entry != null && !TextUtils.isEmpty((CharSequence)entry.getKey()) && !TextUtils.isEmpty((CharSequence)entry.getValue()))
                    {
                        context.a((String)entry.getKey(), (String)entry.getValue());
                    }
                } while (true);
            }
        }
        obj = a(mtoprequest.getParams());
        String s = mtoprequest.getAppKey();
        String s1 = mtoprequest.getAppSecret();
        if (TextUtils.isEmpty(s))
        {
            throw new NullPointerException("appKey is null");
        }
        if (mtoprequest.isHasSigin())
        {
            context.a("sign", a(s, s1, mtoprequest.getApi(), mtoprequest.getV(), "umeng", "umeng", l, ((String) (obj)), mtoprequest.getEcode()));
        }
        context.a("data", ((String) (obj)));
        if (mtoprequest.getSId() != null || !"".equals(mtoprequest.getSId()))
        {
            context.a("sid", mtoprequest.getSId());
        }
        return context;
    }
}
