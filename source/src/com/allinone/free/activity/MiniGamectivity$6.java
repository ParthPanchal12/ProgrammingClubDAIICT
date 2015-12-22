// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.allinone.free.activity:
//            MiniGamectivity

class this._cls0
    implements android.support.v4.view.angeListener
{

    final MiniGamectivity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        MiniGamectivity.access$8(MiniGamectivity.this, i);
        if (MiniGamectivity.access$9(MiniGamectivity.this) != null && MiniGamectivity.access$9(MiniGamectivity.this).getChildCount() > i)
        {
            ((RadioButton)MiniGamectivity.access$9(MiniGamectivity.this).getChildAt(i)).performClick();
        }
    }

    eListener()
    {
        this$0 = MiniGamectivity.this;
        super();
    }
}
