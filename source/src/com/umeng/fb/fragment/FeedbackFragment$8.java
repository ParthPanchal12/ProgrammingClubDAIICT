// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a
    implements TextWatcher
{

    final FeedbackFragment a;

    public void afterTextChanged(Editable editable)
    {
        if (!TextUtils.isEmpty(FeedbackFragment.l(a).getText().toString()))
        {
            FeedbackFragment.a(a, FeedbackFragment.o(a), 2);
            return;
        } else
        {
            FeedbackFragment.a(a, FeedbackFragment.o(a), 3);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (FeedbackFragment feedbackfragment)
    {
        a = feedbackfragment;
        super();
    }
}
