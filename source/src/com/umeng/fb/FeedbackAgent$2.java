// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb;

import java.util.List;

// Referenced classes of package com.umeng.fb:
//            SyncListener, FeedbackAgent

class a
    implements SyncListener
{

    final FeedbackAgent a;

    public void onReceiveDevReply(List list)
    {
        if (list == null || list.size() < 1)
        {
            return;
        } else
        {
            a.showReplyNotification(list);
            return;
        }
    }

    public void onSendUserReply(List list)
    {
    }

    (FeedbackAgent feedbackagent)
    {
        a = feedbackagent;
        super();
    }
}
