// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.umeng.fb.res.g;
import com.umeng.fb.widget.InterceptTouchSwipeRefreshLayout;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a extends Handler
{

    final FeedbackFragment a;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 5: default 44
    //                   0 57
    //                   1 45
    //                   2 167
    //                   3 65
    //                   4 73
    //                   5 159;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L3:
        FeedbackFragment.a(a).setRefreshing(false);
        return;
_L2:
        a.refresh();
        return;
_L5:
        FeedbackFragment.b(a);
        return;
_L6:
        FeedbackFragment.c(a).setVisibility(8);
        FeedbackFragment.d(a).setVisibility(0);
        FeedbackFragment.d(a).setText((new StringBuilder()).append("").append(message.arg1).toString());
        FeedbackFragment.f(a).setText(a.getResources().getString(g.w(FeedbackFragment.e(a))));
        return;
_L7:
        com.umeng.fb.fragment.FeedbackFragment.g(a);
        return;
_L4:
        if (!FeedbackFragment.h(a))
        {
            FeedbackFragment.i(a);
            FeedbackFragment.a(a, true);
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    freshLayout(FeedbackFragment feedbackfragment)
    {
        a = feedbackfragment;
        super();
    }
}
