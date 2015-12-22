// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package com.umeng.message.proguard:
//            aU

public class aV extends DefaultHttpClient
{

    private static final String a = com/umeng/message/proguard/aV.getSimpleName();
    private static final int b = 30000;
    private static final int c = 8192;
    private String d;
    private int e;
    private boolean f;
    private RuntimeException g;

    public aV(Context context, aU au)
    {
        this(context, null, au);
    }

    public aV(Context context, String s, aU au)
    {
        g = new IllegalStateException("ProxyHttpClient created and never closed");
        aU au1 = au;
        if (au == null)
        {
            au1 = new aU(context);
        }
        f = au1.a();
        d = au1.d();
        e = au1.e();
        if (f)
        {
            context = new HttpHost(d, e);
            getParams().setParameter("http.route.default-proxy", context);
        }
        HttpConnectionParams.setConnectionTimeout(getParams(), 30000);
        HttpConnectionParams.setSoTimeout(getParams(), 30000);
        HttpConnectionParams.setSocketBufferSize(getParams(), 8192);
        if (!TextUtils.isEmpty(s))
        {
            HttpProtocolParams.setUserAgent(getParams(), s);
        }
    }

    public void a()
    {
        if (g != null)
        {
            getConnectionManager().shutdown();
            g = null;
        }
    }

    public boolean b()
    {
        return f;
    }

    protected HttpParams createHttpParams()
    {
        HttpParams httpparams = super.createHttpParams();
        HttpProtocolParams.setUseExpectContinue(httpparams, false);
        return httpparams;
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        if (g != null)
        {
            Log.e(a, "Leak found", g);
        }
    }

}
