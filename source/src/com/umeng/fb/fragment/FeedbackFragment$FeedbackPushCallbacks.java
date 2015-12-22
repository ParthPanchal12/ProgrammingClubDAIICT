// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import com.umeng.fb.push.FeedbackPush;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a
    implements com.umeng.fb.push.cks
{

    final FeedbackFragment a;

    public void onAddPushDevReply()
    {
        FeedbackFragment.a(a, 0);
        FeedbackFragment.p(a).clearPushInfo();
    }

    (FeedbackFragment feedbackfragment)
    {
        a = feedbackfragment;
        super();
    }
}
