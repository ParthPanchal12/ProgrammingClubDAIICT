// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

// Referenced classes of package com.umeng.message.proguard:
//            aD

public static interface _cls1
{

    public static final _cls1 a = new aD.c() {

        public HttpURLConnection a(URL url)
            throws IOException
        {
            return (HttpURLConnection)url.openConnection();
        }

        public HttpURLConnection a(URL url, Proxy proxy)
            throws IOException
        {
            return (HttpURLConnection)url.openConnection(proxy);
        }

    };

    public abstract HttpURLConnection a(URL url)
        throws IOException;

    public abstract HttpURLConnection a(URL url, Proxy proxy)
        throws IOException;

}
