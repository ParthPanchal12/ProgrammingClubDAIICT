// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

// Referenced classes of package com.umeng.fb.fragment:
//            FeedbackFragment

class a
    implements android.widget.electedListener
{

    final FeedbackFragment a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 70
    //                   1 85
    //                   2 99
    //                   3 113;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        FeedbackFragment.l(a).setText(FeedbackFragment.a(a, FeedbackFragment.m(a)[i]));
        FeedbackFragment.l(a).requestFocus();
        return;
_L2:
        FeedbackFragment.l(a).setInputType(33);
        continue; /* Loop/switch isn't completed */
_L3:
        FeedbackFragment.l(a).setInputType(2);
        continue; /* Loop/switch isn't completed */
_L4:
        FeedbackFragment.l(a).setInputType(3);
        continue; /* Loop/switch isn't completed */
_L5:
        FeedbackFragment.l(a).setInputType(0x20001);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        FeedbackFragment.l(a).setInputType(0x20001);
    }

    Listener(FeedbackFragment feedbackfragment)
    {
        a = feedbackfragment;
        super();
    }
}
