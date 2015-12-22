// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.banner;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.yeahmobi.android.common.AdClickHandler;
import java.lang.ref.SoftReference;

// Referenced classes of package com.yeahmobi.android.banner:
//            AdBannerView

protected static class mClickHandler extends WebView
{

    private final SoftReference mClickHandler;

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 1 1: default 24
    //                   1 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        ((AdClickHandler)mClickHandler.get()).jumpToClickDestinationUrl();
        if (true) goto _L1; else goto _L3
_L3:
    }

    public (Context context, AdClickHandler adclickhandler)
    {
        super(context);
        mClickHandler = new SoftReference(adclickhandler);
    }
}
