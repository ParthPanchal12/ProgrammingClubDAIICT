// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.util.Log;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.yeahmobi.android.common:
//            AbsAdTask

public final class AdCommonTask extends AbsAdTask
{

    public AdCommonTask()
    {
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient List doInBackground(String as[])
    {
        as = new HttpGet(as[0]);
        if (!isStateValid())
        {
            return null;
        }
        mHttpClient.execute(as);
        shutdownHttpClient();
        return null;
        as;
        as.printStackTrace();
        Log.d("YeahMobi", (new StringBuilder()).append("Exception caught while loading ad: ").append(as).toString());
        shutdownHttpClient();
        return null;
        as;
        shutdownHttpClient();
        throw as;
    }
}
