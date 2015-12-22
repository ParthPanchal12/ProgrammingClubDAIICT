// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.allinone.free.activity:
//            RingtoneActivity

class this._cls0
    implements android.support.v4.view.ngeListener
{

    final RingtoneActivity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        RingtoneActivity.access$2(RingtoneActivity.this, i);
        if (RingtoneActivity.access$3(RingtoneActivity.this) != null && RingtoneActivity.access$3(RingtoneActivity.this).getChildCount() > i)
        {
            ((RadioButton)RingtoneActivity.access$3(RingtoneActivity.this).getChildAt(i)).performClick();
        }
    }

    Listener()
    {
        this$0 = RingtoneActivity.this;
        super();
    }
}
