// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl;

import java.io.Serializable;

public class Goal
    implements Serializable
{
    public static final class State extends Enum
    {

        public static final State ENQUEUE_PENDING;
        public static final State ENQUEUE_REQUESTED;
        public static final State ENQUEUE_SUCCEEDED;
        public static final State REFERRER_ACQUIRED;
        public static final State REFERRER_REQUESTED;
        public static final State REPORTING_COMPLETED;
        public static final State REPORTING_FAILED;
        public static final State REPORTING_REQUESTED;
        public static final State REPORTING_TIMED_OUT;
        private static final State a[];

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/inmobi/commons/analytics/iat/impl/Goal$State, s);
        }

        public static State[] values()
        {
            return (State[])a.clone();
        }

        static 
        {
            ENQUEUE_PENDING = new State("ENQUEUE_PENDING", 0);
            ENQUEUE_REQUESTED = new State("ENQUEUE_REQUESTED", 1);
            ENQUEUE_SUCCEEDED = new State("ENQUEUE_SUCCEEDED", 2);
            REFERRER_REQUESTED = new State("REFERRER_REQUESTED", 3);
            REFERRER_ACQUIRED = new State("REFERRER_ACQUIRED", 4);
            REPORTING_REQUESTED = new State("REPORTING_REQUESTED", 5);
            REPORTING_COMPLETED = new State("REPORTING_COMPLETED", 6);
            REPORTING_TIMED_OUT = new State("REPORTING_TIMED_OUT", 7);
            REPORTING_FAILED = new State("REPORTING_FAILED", 8);
            a = (new State[] {
                ENQUEUE_PENDING, ENQUEUE_REQUESTED, ENQUEUE_SUCCEEDED, REFERRER_REQUESTED, REFERRER_ACQUIRED, REPORTING_REQUESTED, REPORTING_COMPLETED, REPORTING_TIMED_OUT, REPORTING_FAILED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    public int count;
    public boolean isDuplicate;
    public String name;
    public int retryCount;
    public long retryTime;
    public State state;

    public Goal()
    {
        this("", 0, 0L, 0, false);
    }

    public Goal(String s, int i, long l, int j, boolean flag)
    {
        this(s, State.ENQUEUE_PENDING, i, l, j, flag);
    }

    public Goal(String s, State state1, int i, long l, int j, boolean flag)
    {
        boolean flag1 = false;
        super();
        name = s;
        state = state1;
        int k = i;
        if (i < 0)
        {
            k = 0;
        }
        count = k;
        long l1 = l;
        if (l < 0L)
        {
            l1 = 0L;
        }
        retryTime = l1;
        if (j < 0)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = j;
        }
        retryCount = i;
        isDuplicate = flag;
    }
}
