// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.util.SessionInfo;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsFunctions, AnalyticsEvent

public class FunctionSetUserAttribute extends AnalyticsFunctions
{

    private Context a;
    private String b;
    private String c;

    public FunctionSetUserAttribute(Context context, String s, String s1)
    {
        a = context;
        b = s;
        c = s1;
    }

    private AnalyticsEvent a()
    {
        if (SessionInfo.getSessionId(a) != null && b != null && c != null && !"".equals(b.trim()) && !"".equals(c.trim()))
        {
            AnalyticsEvent analyticsevent = new AnalyticsEvent("ae");
            analyticsevent.setUserAttribute(b, c);
            analyticsevent.setEventSessionId(SessionInfo.getSessionId(a));
            analyticsevent.setEventSessionTimeStamp(SessionInfo.getSessionTime(a));
            analyticsevent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
            insertInDatabase(analyticsevent);
            return analyticsevent;
        } else
        {
            printWarning("Please call startSession before calling track User Attribute");
            return null;
        }
    }

    public AnalyticsEvent processFunction()
    {
        return a();
    }
}
