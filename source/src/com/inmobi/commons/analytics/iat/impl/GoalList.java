// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl;

import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerGoalRetryParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl:
//            Goal, AdTrackerUtils

public class GoalList extends Vector
{

    public GoalList()
    {
    }

    public static GoalList getLoggedGoals()
    {
        GoalList goallist = null;
        if (FileOperations.isFileExist(InternalSDKUtil.getContext(), "eventlog"))
        {
            goallist = (GoalList)FileOperations.readFromFile(InternalSDKUtil.getContext(), "eventlog");
        }
        GoalList goallist1 = goallist;
        if (goallist == null)
        {
            goallist1 = new GoalList();
        }
        return goallist1;
    }

    public boolean addGoal(String s, int i, long l, int j, boolean flag)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.debug("[InMobi]-[AdTracker]-4.5.5", "Goal name is null");
            return false;
        }
        if (i < 1 || l < 0L)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "GoalCount cant be 0 or RetryTime cannot be negative");
            return false;
        }
        Iterator iterator = iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Goal goal = (Goal)iterator.next();
        if (!goal.name.equals(s)) goto _L4; else goto _L3
_L3:
        if (Goal.State.REPORTING_REQUESTED != goal.state) goto _L6; else goto _L5
_L5:
        Log.internal("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Attempt to update goal (").append(goal.name).append(") while it is being reported to the server! Ignoring ... ").toString());
        return false;
_L6:
        boolean flag1;
        try
        {
            if (!"download".equals(s))
            {
                goal.count = goal.count + i;
            }
            goal.retryCount = j;
            goal.retryTime = l;
            goal.isDuplicate = flag;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        flag1 = true;
_L8:
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        add(new Goal(s, i, l, j, flag));
        return true;
_L2:
        flag1 = false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Goal getGoal(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.debug("[InMobi]-[AdTracker]-4.5.5", "GoalName is null");
            return null;
        }
        Iterator iterator = iterator();
_L1:
        Goal goal;
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        goal = (Goal)iterator.next();
        flag = goal.name.equals(s);
        if (flag)
        {
            return goal;
        }
          goto _L1
        s;
        return null;
        return null;
    }

    public boolean increaseRetryTime(String s, int i, boolean flag)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "GoalName cannot be null");
        } else
        {
            s = getGoal(s);
            if (s != null)
            {
                int j = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxWaitTime();
                i = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxRetry();
                long l = ((Goal) (s)).retryTime;
                int k = ((Goal) (s)).retryCount;
                if (l < (long)j)
                {
                    long l1 = l * 2L + 30000L;
                    l = l1;
                    if (l1 > (long)j)
                    {
                        l = j;
                    }
                } else
                {
                    l = j;
                }
                j = k + 1;
                s.retryTime = l;
                s.retryCount = j;
                if (j >= i)
                {
                    AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_DUMPED, s, 0, 0L, 0, null);
                }
                return true;
            }
        }
        return false;
    }

    public boolean removeGoal(String s, int i)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.debug("[InMobi]-[AdTracker]-4.5.5", "GoalName is null");
            return false;
        }
        if (i < 1)
        {
            Log.internal("[InMobi]-[AdTracker]-4.5.5", "GoalCount cannot be 0 or negative");
            return false;
        }
        Iterator iterator = iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Goal goal = (Goal)iterator.next();
            if (!goal.name.equals(s))
            {
                continue;
            }
            i = goal.count - i;
            if (s.equals("download"))
            {
                remove(goal);
            } else
            if (i <= 0)
            {
                remove(goal);
            } else
            {
                goal.count = i;
            }
            break;
        } while (true);
        return true;
    }

    public void saveGoals()
    {
        FileOperations.saveToFile(InternalSDKUtil.getContext(), "eventlog", this);
    }
}
