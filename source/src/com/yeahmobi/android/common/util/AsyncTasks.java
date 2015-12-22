// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import android.os.AsyncTask;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;

// Referenced classes of package com.yeahmobi.android.common.util:
//            VersionCode

public class AsyncTasks
{

    public AsyncTasks()
    {
    }

    public static transient void safeExecuteOnExecutor(AsyncTask asynctask, Object aobj[])
        throws IllegalArgumentException, IllegalStateException
    {
        if (asynctask == null)
        {
            throw new IllegalArgumentException("Unable to execute null AsyncTask.");
        }
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new IllegalStateException("AsyncTask must be executed on the main thread");
        }
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH))
        {
            try
            {
                Executor executor = (Executor)android/os/AsyncTask.getField("THREAD_POOL_EXECUTOR").get(android/os/AsyncTask);
                (new Reflection.MethodBuilder(asynctask, "executeOnExecutor")).addParam(java/util/concurrent/Executor, executor).addParam([Ljava/lang/Object;, ((Object) (aobj))).execute();
                return;
            }
            catch (Exception exception)
            {
                asynctask.execute(aobj);
            }
            return;
        } else
        {
            asynctask.execute(aobj);
            return;
        }
    }
}
