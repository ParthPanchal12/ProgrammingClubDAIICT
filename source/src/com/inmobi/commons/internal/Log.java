// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import com.inmobi.commons.thinICE.icedatacollector.BuildSettings;

// Referenced classes of package com.inmobi.commons.internal:
//            CommonsConfig

public class Log
{
    public static final class INTERNAL_LOG_LEVEL extends Enum
    {

        public static final INTERNAL_LOG_LEVEL DEBUG;
        public static final INTERNAL_LOG_LEVEL INTERNAL;
        public static final INTERNAL_LOG_LEVEL NONE;
        public static final INTERNAL_LOG_LEVEL NOT_SET;
        public static final INTERNAL_LOG_LEVEL VERBOSE;
        private static final INTERNAL_LOG_LEVEL b[];
        private final int a;

        public static INTERNAL_LOG_LEVEL valueOf(String s)
        {
            return (INTERNAL_LOG_LEVEL)Enum.valueOf(com/inmobi/commons/internal/Log$INTERNAL_LOG_LEVEL, s);
        }

        public static INTERNAL_LOG_LEVEL[] values()
        {
            return (INTERNAL_LOG_LEVEL[])b.clone();
        }

        public int getValue()
        {
            return a;
        }

        static 
        {
            NOT_SET = new INTERNAL_LOG_LEVEL("NOT_SET", 0, -1);
            NONE = new INTERNAL_LOG_LEVEL("NONE", 1, 0);
            DEBUG = new INTERNAL_LOG_LEVEL("DEBUG", 2, 1);
            VERBOSE = new INTERNAL_LOG_LEVEL("VERBOSE", 3, 2);
            INTERNAL = new INTERNAL_LOG_LEVEL("INTERNAL", 4, 3);
            b = (new INTERNAL_LOG_LEVEL[] {
                NOT_SET, NONE, DEBUG, VERBOSE, INTERNAL
            });
        }

        private INTERNAL_LOG_LEVEL(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }


    private static INTERNAL_LOG_LEVEL a;

    public Log()
    {
    }

    public static void debug(String s, String s1)
    {
        if (a.getValue() >= INTERNAL_LOG_LEVEL.DEBUG.getValue() || a == INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= INTERNAL_LOG_LEVEL.DEBUG.getValue())
        {
            android.util.Log.d(s, s1);
        }
    }

    public static void debug(String s, String s1, Throwable throwable)
    {
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[INTERNAL_LOG_LEVEL.values().length];
                try
                {
                    a[INTERNAL_LOG_LEVEL.DEBUG.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[INTERNAL_LOG_LEVEL.INTERNAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[INTERNAL_LOG_LEVEL.VERBOSE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            debug(s, s1);
            return;

        case 2: // '\002'
            internal(s, s1, throwable);
            break;
        }
    }

    public static INTERNAL_LOG_LEVEL getLogLevel()
    {
        return a;
    }

    public static INTERNAL_LOG_LEVEL getLogLevelValue(long l)
    {
        if (l == 2L)
        {
            return INTERNAL_LOG_LEVEL.INTERNAL;
        }
        if (l == 1L)
        {
            return INTERNAL_LOG_LEVEL.DEBUG;
        } else
        {
            return INTERNAL_LOG_LEVEL.NONE;
        }
    }

    public static void internal(String s, String s1)
    {
        if (a.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue() || a == INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue())
        {
            StackTraceElement stacktraceelement = (new Throwable()).getStackTrace()[1];
            android.util.Log.v(s, (new StringBuilder()).append(stacktraceelement.getFileName()).append(": ").append(stacktraceelement.getMethodName()).append(" ").append(s1).toString());
        }
    }

    public static void internal(String s, String s1, Throwable throwable)
    {
        if (a.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue() || a == INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue())
        {
            StackTraceElement stacktraceelement = (new Throwable()).getStackTrace()[1];
            android.util.Log.e(s, (new StringBuilder()).append(stacktraceelement.getFileName()).append(": ").append(stacktraceelement.getMethodName()).append(" ").append(s1).toString(), throwable);
        }
    }

    public static void setInternalLogLevel(INTERNAL_LOG_LEVEL internal_log_level)
    {
        a = internal_log_level;
        if (a == INTERNAL_LOG_LEVEL.INTERNAL)
        {
            BuildSettings.DEBUG = true;
        }
    }

    public static void verbose(String s, String s1)
    {
        if (a.getValue() >= INTERNAL_LOG_LEVEL.VERBOSE.getValue() || a == INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= INTERNAL_LOG_LEVEL.VERBOSE.getValue())
        {
            android.util.Log.i(s, s1);
        }
    }

    public static void verbose(String s, String s1, Throwable throwable)
    {
        switch (_cls1.a[a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 3: // '\003'
            verbose(s, s1);
            return;

        case 2: // '\002'
            internal(s, s1, throwable);
            break;
        }
    }

    static 
    {
        a = INTERNAL_LOG_LEVEL.NOT_SET;
    }
}
