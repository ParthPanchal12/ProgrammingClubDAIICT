// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import java.util.TimerTask;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a extends TimerTask
{

    final int a;
    final FeedbackFragment b;

    public void run()
    {
        FeedbackFragment.a(b, a);
    }

    (FeedbackFragment feedbackfragment, int i)
    {
        b = feedbackfragment;
        a = i;
        super();
    }
}
