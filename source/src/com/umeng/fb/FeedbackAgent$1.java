// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb;

import com.umeng.fb.net.a;

// Referenced classes of package com.umeng.fb:
//            FeedbackAgent

class a extends Thread
{

    final FeedbackAgent a;

    public void run()
    {
        (new a(com.umeng.fb.FeedbackAgent.a(a))).a();
    }

    (FeedbackAgent feedbackagent)
    {
        a = feedbackagent;
        super();
    }
}
