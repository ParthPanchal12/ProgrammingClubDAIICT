// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.allinone.free.activity:
//            Mp3Activity

class this._cls0
    implements android.support.v4.view.geChangeListener
{

    final Mp3Activity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        Mp3Activity.access$2(Mp3Activity.this, i);
        if (Mp3Activity.access$3(Mp3Activity.this) != null && Mp3Activity.access$3(Mp3Activity.this).getChildCount() > i)
        {
            ((RadioButton)Mp3Activity.access$3(Mp3Activity.this).getChildAt(i)).performClick();
        }
    }

    hangeListener()
    {
        this$0 = Mp3Activity.this;
        super();
    }
}
