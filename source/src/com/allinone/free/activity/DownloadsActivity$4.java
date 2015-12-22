// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.allinone.free.activity:
//            DownloadsActivity

class this._cls0
    implements android.support.v4.view.geListener
{

    final DownloadsActivity this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        DownloadsActivity.access$2(DownloadsActivity.this, i);
        if (DownloadsActivity.access$3(DownloadsActivity.this) != null && DownloadsActivity.access$3(DownloadsActivity.this).getChildCount() > i)
        {
            ((RadioButton)DownloadsActivity.access$3(DownloadsActivity.this).getChildAt(i)).performClick();
        }
    }

    istener()
    {
        this$0 = DownloadsActivity.this;
        super();
    }
}
