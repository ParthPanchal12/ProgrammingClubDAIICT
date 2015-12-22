// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import android.util.Log;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsDatabaseManager, AnalyticsEvent

public abstract class AnalyticsFunctions
{
    public static final class FunctionName extends Enum
    {

        public static final FunctionName CE;
        public static final FunctionName ES;
        public static final FunctionName LB;
        public static final FunctionName LE;
        public static final FunctionName PI;
        public static final FunctionName SS;
        private static final FunctionName a[];

        public static FunctionName valueOf(String s)
        {
            return (FunctionName)Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsFunctions$FunctionName, s);
        }

        public static FunctionName[] values()
        {
            return (FunctionName[])a.clone();
        }

        static 
        {
            SS = new FunctionName("SS", 0);
            ES = new FunctionName("ES", 1);
            LB = new FunctionName("LB", 2);
            LE = new FunctionName("LE", 3);
            CE = new FunctionName("CE", 4);
            PI = new FunctionName("PI", 5);
            a = (new FunctionName[] {
                SS, ES, LB, LE, CE, PI
            });
        }

        private FunctionName(String s, int i)
        {
            super(s, i);
        }
    }


    private FunctionName a;

    public AnalyticsFunctions()
    {
        a = null;
    }

    public FunctionName getFunctionName()
    {
        return a;
    }

    protected void insertInDatabase(AnalyticsEvent analyticsevent)
    {
        try
        {
            AnalyticsDatabaseManager.getInstance().insertEvents(analyticsevent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AnalyticsEvent analyticsevent)
        {
            Log.w("[InMobi]-[Analytics]-4.5.5", analyticsevent);
        }
    }

    protected void printWarning(String s)
    {
        Log.d("[InMobi]-[Analytics]-4.5.5", "IllegalStateException", new IllegalStateException(s));
    }

    public abstract AnalyticsEvent processFunction();
}
