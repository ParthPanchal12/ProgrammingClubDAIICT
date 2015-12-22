// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a
    implements android.view.r
{

    final FeedbackFragment a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (FeedbackFragment.j(a) != 1 && motionevent.getAction() == 1)
        {
            FeedbackFragment.a(a, 1, FeedbackFragment.k(a));
        }
        view.performClick();
        return false;
    }

    (FeedbackFragment feedbackfragment)
    {
        a = feedbackfragment;
        super();
    }
}
