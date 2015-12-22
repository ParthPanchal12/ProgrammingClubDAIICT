// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.events;

import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.db.AnalyticsEventsQueue;
import com.inmobi.commons.analytics.db.FunctionEndSession;
import com.inmobi.commons.analytics.db.FunctionLevelBegin;
import com.inmobi.commons.analytics.db.FunctionLevelEnd;
import com.inmobi.commons.analytics.db.FunctionSetUserAttribute;
import com.inmobi.commons.analytics.db.FunctionStartSession;
import com.inmobi.commons.analytics.db.FunctionTagEvent;
import com.inmobi.commons.analytics.db.FunctionTagTransaction;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Map;

public final class AnalyticsEventsWrapper
{
    public static final class IMItemType extends Enum
    {

        public static final IMItemType CONSUMABLE;
        public static final IMItemType DURABLE;
        public static final IMItemType PERSONALIZATION;
        private static final IMItemType a[];

        public static IMItemType valueOf(String s)
        {
            return (IMItemType)Enum.valueOf(com/inmobi/commons/analytics/events/AnalyticsEventsWrapper$IMItemType, s);
        }

        public static IMItemType[] values()
        {
            return (IMItemType[])a.clone();
        }

        static 
        {
            CONSUMABLE = new IMItemType("CONSUMABLE", 0);
            DURABLE = new IMItemType("DURABLE", 1);
            PERSONALIZATION = new IMItemType("PERSONALIZATION", 2);
            a = (new IMItemType[] {
                CONSUMABLE, DURABLE, PERSONALIZATION
            });
        }

        private IMItemType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class IMSectionStatus extends Enum
    {

        public static final IMSectionStatus CANCELED;
        public static final IMSectionStatus COMPLETED;
        public static final IMSectionStatus FAILED;
        private static final IMSectionStatus a[];

        public static IMSectionStatus valueOf(String s)
        {
            return (IMSectionStatus)Enum.valueOf(com/inmobi/commons/analytics/events/AnalyticsEventsWrapper$IMSectionStatus, s);
        }

        public static IMSectionStatus[] values()
        {
            return (IMSectionStatus[])a.clone();
        }

        static 
        {
            COMPLETED = new IMSectionStatus("COMPLETED", 0);
            FAILED = new IMSectionStatus("FAILED", 1);
            CANCELED = new IMSectionStatus("CANCELED", 2);
            a = (new IMSectionStatus[] {
                COMPLETED, FAILED, CANCELED
            });
        }

        private IMSectionStatus(String s, int i)
        {
            super(s, i);
        }
    }


    private static AnalyticsEventsWrapper a;
    private static boolean c = false;
    private AnalyticsEventsQueue b;

    private AnalyticsEventsWrapper()
    {
    }

    private void a(String s)
    {
        Log.debug("[InMobi]-[Analytics]-4.5.5", (new StringBuilder()).append("IllegalArgumentError: ").append(s).toString());
    }

    private boolean a()
    {
        if (InternalSDKUtil.getContext() != null && SessionInfo.getSessionId(InternalSDKUtil.getContext()) == null)
        {
            startSession(InMobi.getAppId(), null);
        } else
        if (SessionInfo.getSessionId(InternalSDKUtil.getContext()) == null)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Please call InMobi.initialize or startSession before calling any events API");
            return false;
        }
        return true;
    }

    public static AnalyticsEventsWrapper getInstance()
    {
        com/inmobi/commons/analytics/events/AnalyticsEventsWrapper;
        JVM INSTR monitorenter ;
        AnalyticsEventsWrapper analyticseventswrapper;
        if (AnalyticsUtils.getWebviewUserAgent() == null)
        {
            AnalyticsUtils.setWebviewUserAgent(InternalSDKUtil.getUserAgent());
        }
        if (a == null)
        {
            a = new AnalyticsEventsWrapper();
            AnalyticsUtils.setStartHandle(false);
            AnalyticsNetworkManager.startInstance();
        }
        a.b = AnalyticsEventsQueue.getInstance();
        analyticseventswrapper = a;
        com/inmobi/commons/analytics/events/AnalyticsEventsWrapper;
        JVM INSTR monitorexit ;
        return analyticseventswrapper;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isEventsUser()
    {
        return c;
    }

    public static void setIsEventsUser()
    {
        c = true;
    }

    public void beginSection(int i, String s, Map map)
    {
        if (s == null)
        {
            try
            {
                a("arguments cannot be null");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.internal("[InMobi]-[Analytics]-4.5.5", "Begin Section Exception", s);
            }
            break MISSING_BLOCK_LABEL_42;
        }
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (map.size() > 10)
        {
            a("attribute map cannot exceed 10 values");
            return;
        }
        break MISSING_BLOCK_LABEL_43;
        return;
        if (a())
        {
            s = new FunctionLevelBegin(InternalSDKUtil.getContext(), i, s, map);
            b.addElement(s);
            b.processFunctions();
        }
        return;
    }

    public void endSection(int i, String s, Map map)
    {
        if (s == null)
        {
            try
            {
                a("arguments cannot be null");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.internal("[InMobi]-[Analytics]-4.5.5", "End Section Exception", s);
            }
            break MISSING_BLOCK_LABEL_42;
        }
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (map.size() > 10)
        {
            a("attribute map cannot exceed 10 values");
            return;
        }
        break MISSING_BLOCK_LABEL_43;
        return;
        if (a())
        {
            s = new FunctionLevelEnd(InternalSDKUtil.getContext(), i, s, null, map);
            b.addElement(s);
            b.processFunctions();
        }
        return;
    }

    public void endSession(Map map)
    {
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        if (map.size() > 10)
        {
            a("attribute map cannot exceed 10 values");
            return;
        }
        try
        {
            map = new FunctionEndSession(InternalSDKUtil.getContext(), map);
            b.addElement(map);
            b.processFunctions();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "End Session Exception", map);
        }
        return;
    }

    public void setUserAttribute(String s, String s1)
    {
        if (s != null && !s.trim().equals("") && s1 != null && !s1.trim().equals("")) goto _L2; else goto _L1
_L1:
        a("arguments cannot be null or empty");
_L4:
        return;
_L2:
        if (s.length() > 15 || s1.length() > 20)
        {
            a("attribute name cannot exceed 15 chars and attribute val cannot exceed 20 chars. Please pass a valid attribute");
            return;
        }
        if (!a()) goto _L4; else goto _L3
_L3:
        s = new FunctionSetUserAttribute(InternalSDKUtil.getContext(), s, s1);
        b.addElement(s);
        b.processFunctions();
        return;
        s;
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Set User Attribute Exception", s);
        return;
    }

    public void startSession(String s, Map map)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        if (!s.trim().equals(""))
        {
            break MISSING_BLOCK_LABEL_23;
        }
        a("appid cannot be null or empty");
        return;
        if (map != null)
        {
            try
            {
                if (map.size() > 10)
                {
                    a("attribute map cannot exceed 10 values");
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.internal("[InMobi]-[Analytics]-4.5.5", "Init exception", s);
                return;
            }
        }
        s = new FunctionStartSession(InternalSDKUtil.getContext(), s, map);
        b.addElement(s);
        b.processFunctions();
        return;
    }

    public void tagEvent(String s, Map map)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        if (!s.trim().equals(""))
        {
            break MISSING_BLOCK_LABEL_23;
        }
        a("arguments cannot be null or empty");
        return;
        if (map != null)
        {
            try
            {
                if (map.size() > 10)
                {
                    a("attribute map cannot exceed 10 values");
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.internal("[InMobi]-[Analytics]-4.5.5", "Tag Event Exception", s);
                return;
            }
        }
        if (a())
        {
            s = new FunctionTagEvent(InternalSDKUtil.getContext(), s, map);
            b.addElement(s);
            b.processFunctions();
        }
        return;
    }

    public void tagTransactionManually(Intent intent, Bundle bundle)
    {
        if (intent == null)
        {
            try
            {
                a("transaction intent cannot be null or empty");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.internal("[InMobi]-[Analytics]-4.5.5", "Tag Transaction Manually Exception", intent);
            }
            break MISSING_BLOCK_LABEL_56;
        }
        if (a())
        {
            intent = new FunctionTagTransaction(InternalSDKUtil.getContext(), intent, bundle);
            b.addElement(intent);
            b.processFunctions();
            return;
        }
    }

}
