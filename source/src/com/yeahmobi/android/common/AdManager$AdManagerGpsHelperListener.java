// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.util.Log;
import com.yeahmobi.android.common.util.AsyncTasks;
import java.lang.ref.SoftReference;

// Referenced classes of package com.yeahmobi.android.common:
//            AdManager, UrlBuilder, AbsAdTask, AdFetchTask

protected static final class mControl
    implements mControl
{

    private final SoftReference mControl;

    public void onFetchAdInfoCompleted()
    {
        String s = AdManager.access$000((AdManager)mControl.get()).buildUrlString();
        Log.d("YeahMobi", (new StringBuilder()).append("start to load ad url=").append(s).toString());
        if (AdManager.access$100((AdManager)mControl.get()) != null)
        {
            AdManager.access$100((AdManager)mControl.get()).cancel(true);
        }
        AdManager.access$102((AdManager)mControl.get(), new AdFetchTask((AdManager)mControl.get()));
        try
        {
            AsyncTasks.safeExecuteOnExecutor(AdManager.access$100((AdManager)mControl.get()), new String[] {
                s
            });
            return;
        }
        catch (Exception exception)
        {
            Log.d("AdViewController", "Error executing AdFetchTask", exception);
        }
    }

    public (AdManager admanager)
    {
        mControl = new SoftReference(admanager);
    }
}
