// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package com.umeng.message.proguard:
//            aD

static final class te
    implements X509TrustManager
{

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
    {
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
    {
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return new X509Certificate[0];
    }

    te()
    {
    }
}
