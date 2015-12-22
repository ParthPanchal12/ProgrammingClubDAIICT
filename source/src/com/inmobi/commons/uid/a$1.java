// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import android.content.Context;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.commons.uid:
//            a, AdvertisingId

static final class .Log
    implements Runnable
{

    public void run()
    {
        try
        {
            Object obj1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Object obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            obj1 = ((Class) (obj1)).getDeclaredMethod("getAdvertisingIdInfo", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                InternalSDKUtil.getContext()
            });
            String s = (String)((Class) (obj)).getDeclaredMethod("getId", (Class[])null).invoke(obj1, (Object[])null);
            a.j().a(s);
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "gpid", s);
            obj = (Boolean)((Class) (obj)).getDeclaredMethod("isLimitAdTrackingEnabled", (Class[])null).invoke(obj1, (Object[])null);
            a.j().a(((Boolean) (obj)).booleanValue());
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "limitadtrck", ((Boolean) (obj)).booleanValue());
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Exception getting advertiser id", exception);
        }
    }

    .Log()
    {
    }
}
