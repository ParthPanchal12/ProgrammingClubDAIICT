// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import com.umeng.fb.SyncListener;
import java.util.List;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a
    implements SyncListener
{

    final FeedbackFragment a;

    public void onReceiveDevReply(List list)
    {
        FeedbackFragment.a(a, 1);
        a.a();
    }

    public void onSendUserReply(List list)
    {
    }

    (FeedbackFragment feedbackfragment)
    {
        a = feedbackfragment;
        super();
    }
}
