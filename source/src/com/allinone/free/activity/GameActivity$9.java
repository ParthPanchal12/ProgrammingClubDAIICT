// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.allinone.free.activity:
//            GameActivity

class this._cls0
    implements android.support.v4.view.eChangeListener
{

    final GameActivity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        GameActivity.access$15(GameActivity.this, i);
        if (GameActivity.access$16(GameActivity.this) != null && GameActivity.access$16(GameActivity.this).getChildCount() > i)
        {
            ((RadioButton)GameActivity.access$16(GameActivity.this).getChildAt(i)).performClick();
        }
    }

    angeListener()
    {
        this$0 = GameActivity.this;
        super();
    }
}
