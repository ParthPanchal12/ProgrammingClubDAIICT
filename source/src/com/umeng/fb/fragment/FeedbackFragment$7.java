// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.umeng.fb.model.Conversation;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class b
    implements android.view.r
{

    final int a;
    final View b;
    final FeedbackFragment c;

    public void onClick(View view)
    {
        view = FeedbackFragment.l(c).getEditableText().toString().trim();
        FeedbackFragment.l(c).getEditableText().clear();
        if (a == 0)
        {
            FeedbackFragment.b(c, view);
            FeedbackFragment.a(c, 1, b);
        } else
        if (a == 1)
        {
            FeedbackFragment.n(c).addUserReply(view);
            c.a();
            c.refresh();
            return;
        }
    }

    (FeedbackFragment feedbackfragment, int i, View view)
    {
        c = feedbackfragment;
        a = i;
        b = view;
        super();
    }
}
