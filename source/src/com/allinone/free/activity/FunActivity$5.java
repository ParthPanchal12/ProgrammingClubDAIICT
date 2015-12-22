// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.allinone.free.activity:
//            FunActivity

class this._cls0
    implements android.support.v4.view.geChangeListener
{

    final FunActivity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        FunActivity.access$6(FunActivity.this, i);
        if (FunActivity.access$7(FunActivity.this) != null && FunActivity.access$7(FunActivity.this).getChildCount() > i)
        {
            ((RadioButton)FunActivity.access$7(FunActivity.this).getChildAt(i)).performClick();
        }
    }

    hangeListener()
    {
        this$0 = FunActivity.this;
        super();
    }
}
