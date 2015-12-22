// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMBanner

class a
    implements IMAdListener
{

    final IMBanner a;

    public void onAdInteraction(Map map)
    {
        IMBanner.a(a, 105, null, map);
    }

    public void onAdRequestFailed(AdErrorCode aderrorcode)
    {
        IMBanner.a(a, 101, aderrorcode, null);
    }

    public void onAdRequestSucceeded()
    {
        IMBanner.a(a, 100, null, null);
    }

    public void onDismissAdScreen()
    {
        IMBanner.a(a, 103, null, null);
    }

    public void onIncentCompleted(Map map)
    {
    }

    public void onLeaveApplication()
    {
        IMBanner.a(a, 104, null, null);
    }

    public void onShowAdScreen()
    {
        IMBanner.a(a, 102, null, null);
    }

    ErrorCode(IMBanner imbanner)
    {
        a = imbanner;
        super();
    }
}
