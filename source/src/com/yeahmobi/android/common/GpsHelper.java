// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import com.yeahmobi.android.common.util.AsyncTasks;
import com.yeahmobi.android.common.util.MethodBuilderFactory;
import com.yeahmobi.android.common.util.Reflection;
import java.lang.ref.SoftReference;

// Referenced classes of package com.yeahmobi.android.common:
//            SharedPreferencesHelper

public class GpsHelper
{
    private static class FetchAdvertisingInfoTask extends AsyncTask
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
            Object obj = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.sAdvertisingIdClientClassName)).addParam(android/content/Context, avoid).execute();
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
            void1 = (GpsHelperListener)mGpsHelperListenerWeakReference.get();
            if (void1 != null)
            {
                void1.onFetchAdInfoCompleted();
            }
        }

        public FetchAdvertisingInfoTask(Context context, GpsHelperListener gpshelperlistener)
        {
            mContextWeakReference = new SoftReference(context);
            mGpsHelperListenerWeakReference = new SoftReference(gpshelperlistener);
        }
    }

    public static interface GpsHelperListener
    {

        public abstract void onFetchAdInfoCompleted();
    }


    public static final String ADVERTISING_ID_KEY = "advertisingId";
    public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
    public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";
    private static String sAdvertisingIdClientClassName = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static String sPlayServicesUtilClassName = "com.google.android.gms.common.GooglePlayServicesUtil";

    public GpsHelper()
    {
    }

    public static void asyncFetchAdvertisingInfo(Context context)
    {
        asyncFetchAdvertisingInfo(context, null);
    }

    public static void asyncFetchAdvertisingInfo(Context context, GpsHelperListener gpshelperlistener)
    {
        if (!Reflection.classFound(sAdvertisingIdClientClassName))
        {
            if (gpshelperlistener != null)
            {
                gpshelperlistener.onFetchAdInfoCompleted();
            }
        } else
        {
            try
            {
                AsyncTasks.safeExecuteOnExecutor(new FetchAdvertisingInfoTask(context, gpshelperlistener), new Void[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.d("YeahMobi", "Error executing FetchAdvertisingInfoTask", context);
            }
            if (gpshelperlistener != null)
            {
                gpshelperlistener.onFetchAdInfoCompleted();
                return;
            }
        }
    }

    public static void asyncFetchAdvertisingInfoIfNotCached(Context context, GpsHelperListener gpshelperlistener)
    {
        if (isGpsAvailable(context) && !isSharedPreferencesPopluated(context))
        {
            asyncFetchAdvertisingInfo(context, gpshelperlistener);
            return;
        } else
        {
            gpshelperlistener.onFetchAdInfoCompleted();
            return;
        }
    }

    public static String getAdvertisingId(Context context)
    {
        String s = null;
        if (isGpsAvailable(context))
        {
            s = SharedPreferencesHelper.getSharedPreferences(context).getString("advertisingId", null);
        }
        return s;
    }

    static boolean isGpsAvailable(Context context)
    {
        boolean flag1 = false;
        int i;
        boolean flag;
        try
        {
            context = ((Context) (MethodBuilderFactory.create(null, "isGooglePlayServicesAvailable").setStatic(Class.forName(sPlayServicesUtilClassName)).addParam(android/content/Context, context).execute()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        flag = flag1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        i = ((Integer)context).intValue();
        flag = flag1;
        if (i == 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isLimitAdTrackingEnabled(Context context)
    {
        boolean flag = false;
        if (isGpsAvailable(context))
        {
            flag = SharedPreferencesHelper.getSharedPreferences(context).getBoolean("isLimitAdTrackingEnabled", false);
        }
        return flag;
    }

    static boolean isSharedPreferencesPopluated(Context context)
    {
        context = SharedPreferencesHelper.getSharedPreferences(context);
        return context.contains("advertisingId") && context.contains("isLimitAdTrackingEnabled");
    }

    static String reflectedGetAdvertisingId(Object obj, String s)
    {
        try
        {
            obj = (String)MethodBuilderFactory.create(obj, "getId").execute();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return s;
        }
        return ((String) (obj));
    }

    static boolean reflectedIsLimitAdTrackingEnabled(Object obj, boolean flag)
    {
        boolean flag1;
        try
        {
            obj = (Boolean)MethodBuilderFactory.create(obj, "isLimitAdTrackingEnabled").execute();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return flag;
        }
        flag1 = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        flag1 = ((Boolean) (obj)).booleanValue();
        return flag1;
    }

    public static void setClassNamesForTesting()
    {
        sPlayServicesUtilClassName = "java.lang.Class";
        sAdvertisingIdClientClassName = "java.lang.Class";
    }

    static void updateSharedPreferences(Context context, Object obj)
    {
        String s = reflectedGetAdvertisingId(obj, null);
        boolean flag = reflectedIsLimitAdTrackingEnabled(obj, false);
        SharedPreferencesHelper.getSharedPreferences(context).edit().putString("advertisingId", s).putBoolean("isLimitAdTrackingEnabled", flag).commit();
    }


}
