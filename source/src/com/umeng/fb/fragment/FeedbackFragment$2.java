// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import android.view.View;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a
    implements android.view.r
{

    final FeedbackFragment a;

    public void onClick(View view)
    {
        if (FeedbackFragment.j(a) != 0)
        {
            FeedbackFragment.a(a, 0, FeedbackFragment.k(a));
        }
    }

    (FeedbackFragment feedbackfragment)
    {
        a = feedbackfragment;
        super();
    }
}
