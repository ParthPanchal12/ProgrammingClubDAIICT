// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MetricEndPoint
{

    public MetricEndPoint()
    {
    }

    public static void sendData(String s, String s1)
        throws IOException
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
        s.setDoOutput(true);
        s.setDoInput(false);
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(s.getOutputStream());
        outputstreamwriter.write(s1);
        outputstreamwriter.flush();
        outputstreamwriter.close();
        s.getResponseCode();
    }
}
