// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import com.umeng.fb.model.Store;
import com.umeng.fb.model.UserInfo;
import com.umeng.fb.net.a;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a
    implements Runnable
{

    final FeedbackFragment a;

    public void run()
    {
        (new a(a.getActivity())).a(Store.getInstance(a.getActivity()).getUserInfo().toJson());
    }

    (FeedbackFragment feedbackfragment)
    {
        a = feedbackfragment;
        super();
    }
}
