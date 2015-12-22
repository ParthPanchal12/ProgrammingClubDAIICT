// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Referenced classes of package com.inmobi.commons.internal:
//            Log, InternalSDKUtil

public class ActivityRecognitionManager extends IntentService
{
    private static class a
        implements InvocationHandler
    {

        public void a(Bundle bundle)
        {
            int i;
            bundle = new Intent(InternalSDKUtil.getContext().getApplicationContext(), com/inmobi/commons/internal/ActivityRecognitionManager);
            bundle = PendingIntent.getService(InternalSDKUtil.getContext().getApplicationContext(), 0, bundle, 0x8000000);
            i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(InternalSDKUtil.getContext());
            if (i == 0)
            {
                try
                {
                    Class.forName("com.google.android.gms.location.ActivityRecognitionClient").getMethod("requestActivityUpdates", new Class[] {
                        java/lang/Integer, android/app/PendingIntent
                    }).invoke(ActivityRecognitionManager.b, new Object[] {
                        Integer.valueOf(1000), bundle
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle) { }
                try
                {
                    Log.internal("[InMobi]-4.5.5", "Unable to request activity updates from ActivityRecognition client");
                    Class.forName("com.google.android.gms.common.GooglePlayServicesClient").getMethod("disconnect", (Class[])null).invoke(ActivityRecognitionManager.b, (Object[])null);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    Log.internal("[InMobi]-4.5.5", "Unable to request activity updates from ActivityRecognition client");
                }
                return;
            }
            Class.forName("com.google.android.gms.common.GooglePlayServicesClient").getMethod("disconnect", (Class[])null).invoke(ActivityRecognitionManager.b, (Object[])null);
            return;
        }

        public Object invoke(Object obj, Method method, Object aobj[])
            throws Throwable
        {
            if (aobj != null)
            {
                try
                {
                    if (method.getName().equals("onConnected"))
                    {
                        a((Bundle)aobj[0]);
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    Log.internal("[InMobi]-4.5.5", "Unable to invoke method", ((Throwable) (obj)));
                    return null;
                }
            }
            return null;
        }

        private a()
        {
        }

    }


    static Object a = null;
    static Object b = null;
    static int c = -1;
    private static Object d = null;
    private static Object e = null;

    public ActivityRecognitionManager()
    {
        super("InMobi activity service");
    }

    private static void a(Context context)
    {
        Object obj = null;
        if (a == null)
        {
            return;
        }
        Class class2;
        Class class3;
        Class aclass[];
        int j;
        class2 = Class.forName("com.google.android.gms.common.GooglePlayServicesClient");
        class3 = Class.forName("com.google.android.gms.location.ActivityRecognitionClient");
        if (b != null)
        {
            class2.getMethod("disconnect", (Class[])null).invoke(b, (Object[])null);
        }
        aclass = class2.getDeclaredClasses();
        j = aclass.length;
        Object obj1;
        int i;
        i = 0;
        obj1 = null;
_L2:
        Class class1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        class1 = aclass[i];
        if (!class1.getSimpleName().equalsIgnoreCase("ConnectionCallbacks"))
        {
            break MISSING_BLOCK_LABEL_130;
        }
        obj = class1.getClassLoader();
        a a1 = new a();
        d = Proxy.newProxyInstance(((ClassLoader) (obj)), new Class[] {
            class1
        }, a1);
        obj = class1;
        break MISSING_BLOCK_LABEL_272;
        if (!class1.getSimpleName().equalsIgnoreCase("OnConnectionFailedListener"))
        {
            break MISSING_BLOCK_LABEL_272;
        }
        obj1 = class1.getClassLoader();
        a a2 = new a();
        e = Proxy.newProxyInstance(((ClassLoader) (obj1)), new Class[] {
            class1
        }, a2);
        obj1 = class1;
        break MISSING_BLOCK_LABEL_272;
        try
        {
            b = class3.getDeclaredConstructor(new Class[] {
                android/content/Context, obj, obj1
            }).newInstance(new Object[] {
                context, d, e
            });
            class2.getMethod("connect", (Class[])null).invoke(b, (Object[])null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", "Init: Google play services not included. Cannot get current activity.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.internal("[InMobi]-4.5.5", "Init: Something went wrong during ActivityRecognitionManager.init", context);
        }
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(Intent intent)
    {
        try
        {
            Class class1 = Class.forName("com.google.android.gms.location.ActivityRecognitionResult");
            if (((Boolean)class1.getMethod("hasResult", new Class[] {
    android/content/Intent
}).invoke(null, new Object[] {
    intent
})).booleanValue())
            {
                intent = ((Intent) (class1.getMethod("extractResult", new Class[] {
                    android/content/Intent
                }).invoke(null, new Object[] {
                    intent
                })));
                a = class1.getMethod("getMostProbableActivity", (Class[])null).invoke(intent, (Object[])null);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Log.internal("[InMobi]-4.5.5", "HandleIntent: Google play services not included. Cannot get current activity.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Log.internal("[InMobi]-4.5.5", "HandleIntent: Google play services not included. Cannot get current activity.");
        }
    }

    private static boolean a()
    {
        boolean flag;
        flag = true;
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            return false;
        }
        if (c != -1)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        a = Class.forName("com.google.android.gms.location.DetectedActivity").getConstructor(new Class[] {
            Integer.TYPE, Integer.TYPE
        }).newInstance(new Object[] {
            Integer.valueOf(-1), Integer.valueOf(100)
        });
        c = 1;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(InternalSDKUtil.getContext()) == 0)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        c = 0;
        return false;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        Log.debug("[InMobi]-4.5.5", "Google play services not included.");
        c = 0;
_L1:
        Exception exception;
        if (c != 1)
        {
            flag = false;
        }
        return flag;
        exception;
        Log.debug("[InMobi]-4.5.5", "Google play services not included.");
        c = 0;
          goto _L1
    }

    public static int getDetectedActivity()
    {
        if (a == null)
        {
            return -1;
        }
        int i;
        try
        {
            i = ((Integer)Class.forName("com.google.android.gms.location.DetectedActivity").getMethod("getType", (Class[])null).invoke(a, (Object[])null)).intValue();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.internal("[InMobi]-4.5.5", "getDetectedActivity: Google play services not included. Returning null.");
            return -1;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "getDetectedActivity: Google play services not included. Returning null.");
            return -1;
        }
        return i;
    }

    public static void init(Context context)
    {
        if (a())
        {
            a(context);
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        if (a())
        {
            a(intent);
        }
    }

}
