// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class InterceptTouchSwipeRefreshLayout extends SwipeRefreshLayout
{

    private final String a = com/umeng/fb/widget/InterceptTouchSwipeRefreshLayout.getName();
    private android.view.View.OnTouchListener b;

    public InterceptTouchSwipeRefreshLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (b != null)
        {
            b.onTouch(this, motionevent);
        }
        return super.onInterceptTouchEvent(motionevent);
    }

    public void setInterceptTouch(android.view.View.OnTouchListener ontouchlistener)
    {
        b = ontouchlistener;
    }
}
