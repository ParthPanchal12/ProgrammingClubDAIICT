// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import com.yeahmobi.android.common.util.YMLog;
import java.lang.ref.SoftReference;

// Referenced classes of package com.yeahmobi.android.common:
//            AdClickHandler

private static final class mAdClickHandler
    implements mAdClickHandler
{

    private final SoftReference mAdClickHandler;

    public void onFailure()
    {
        YMLog.d("Failed to resolve URL for click.");
    }

    public void onSuccess(String s)
    {
        YMLog.d((new StringBuilder()).append("Success to resolve URL for : ").append(s).toString());
        if (mAdClickHandler != null && mAdClickHandler.get() != null)
        {
            ((AdClickHandler)mAdClickHandler.get()).visitUrl(s);
        }
    }

    public (AdClickHandler adclickhandler)
    {
        mAdClickHandler = new SoftReference(adclickhandler);
    }
}
