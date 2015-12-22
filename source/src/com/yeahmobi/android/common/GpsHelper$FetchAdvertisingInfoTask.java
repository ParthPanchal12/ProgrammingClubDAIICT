// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.yeahmobi.android.common.util.MethodBuilderFactory;
import java.lang.ref.SoftReference;

// Referenced classes of package com.yeahmobi.android.common:
//            GpsHelper

private static class mGpsHelperListenerWeakReference extends AsyncTask
{

    private SoftReference mContextWeakReference;
    private SoftReference mGpsHelperListenerWeakReference;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = (Context)mContextWeakReference.get();
        if (avoid == null)
        {
            return null;
        }
        Object obj = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").extWeakReference(Class.forName(GpsHelper.access$000())).extWeakReference(android/content/Context, avoid).extWeakReference();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        GpsHelper.updateSharedPreferences(avoid, obj);
        return null;
        avoid;
        Log.d("YeahMobi", "Unable to obtain AdvertisingIdClient.getAdvertisingIdInfo()");
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        void1 = (onPostExecute)mGpsHelperListenerWeakReference.get();
        if (void1 != null)
        {
            void1.AdInfoCompleted();
        }
    }

    public (Context context,  )
    {
        mContextWeakReference = new SoftReference(context);
        mGpsHelperListenerWeakReference = new SoftReference();
    }
}
