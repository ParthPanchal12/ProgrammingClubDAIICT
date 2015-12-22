// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import android.app.Dialog;
import java.util.TimerTask;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a extends TimerTask
{

    int a;
    final FeedbackFragment b;

    public void run()
    {
label0:
        {
            FeedbackFragment.b(b, true);
            if (FeedbackFragment.q(b).isShowing())
            {
                if (a <= 0)
                {
                    break label0;
                }
                FeedbackFragment.a(b, 4, a);
                a = a - 1;
            }
            return;
        }
        FeedbackFragment.a(b, 3);
        FeedbackFragment.c(b, false);
        cancel();
    }

    (FeedbackFragment feedbackfragment)
    {
        b = feedbackfragment;
        super();
        a = 10;
    }
}
