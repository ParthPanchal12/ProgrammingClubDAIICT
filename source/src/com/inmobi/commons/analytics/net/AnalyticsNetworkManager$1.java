// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.net;

import android.os.Handler;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.commons.analytics.net:
//            AnalyticsNetworkManager

static final class ver.a
    implements ver.a
{

    public void a()
    {
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Connectivity came");
        if (AnalyticsNetworkManager.a() != null && !AnalyticsUtils.getStartHandle())
        {
            AnalyticsUtils.setStartHandle(true);
            AnalyticsNetworkManager.a().sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
        }
    }

    public void b()
    {
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Connectivity gone");
    }

    ver.a()
    {
    }
}
