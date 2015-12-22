// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.allinone.free.views.LDrawerButton;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity

class this._cls0
    implements android.support.v4.widget.rListener
{

    final MyMainActivity this$0;

    public void onDrawerClosed(View view)
    {
    }

    public void onDrawerOpened(View view)
    {
    }

    public void onDrawerSlide(View view, float f)
    {
        if (view == MyMainActivity.access$46(MyMainActivity.this))
        {
            MyMainActivity.access$47(MyMainActivity.this).onDrag(MyMainActivity.mDrawerLayout.isDrawerOpen(3), f);
        }
    }

    public void onDrawerStateChanged(int i)
    {
    }

    Listener()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
