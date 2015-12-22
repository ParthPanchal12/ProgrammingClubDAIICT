// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.uid:
//            AdvertisingId

class a
{

    private static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static AdvertisingId b = null;

    static String a()
    {
        return "1";
    }

    static String a(String s)
    {
        return InternalSDKUtil.getDigested(s, "SHA-1");
    }

    protected static void a(Context context)
    {
        Object obj = FileOperations.getPreferences(context, "impref", "IMID");
        long l = FileOperations.getLongPreferences(context, "impref", "timestamp");
        String s = ((String) (obj));
        if (obj == null)
        {
            s = UUID.randomUUID().toString();
            FileOperations.setPreferences(context, "impref", "IMID", s);
            FileOperations.setPreferences(context, "impref", "AID", DeviceInfo.getAid());
            FileOperations.setPreferences(context, "impref", "AIDL", DeviceInfo.getAid());
        }
        if (l == 0L)
        {
            FileOperations.setPreferences(context, "impref", "timestamp", (new Date()).getTime());
        }
        obj = new Intent();
        ((Intent) (obj)).setAction("com.inmobi.share.id");
        ((Intent) (obj)).putExtra("IMID", s);
        ((Intent) (obj)).putExtra("AIDL", FileOperations.getPreferences(context, "impref", "AIDL"));
        ((Intent) (obj)).putExtra("timestamp", FileOperations.getLongPreferences(context, "impref", "timestamp"));
        ((Intent) (obj)).putExtra("AID", DeviceInfo.getAid());
        context.sendBroadcast(((Intent) (obj)));
    }

    static String b()
    {
        return DemogInfo.getIDType(IMIDType.ID_SESSION);
    }

    static String b(Context context)
    {
        return FileOperations.getPreferences(context, "impref", "IMID");
    }

    static String b(String s)
    {
        return InternalSDKUtil.getDigested(s, "MD5");
    }

    static String c()
    {
        return DemogInfo.getIDType(IMIDType.ID_LOGIN);
    }

    static String c(Context context)
    {
        Object obj;
        JSONObject jsonobject;
        String s;
        try
        {
            jsonobject = new JSONObject();
            s = FileOperations.getPreferences(context, "impref", "AID");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        jsonobject.put("p", s);
        obj = FileOperations.getPreferences(context, "impref", "AIDL");
        context = ((Context) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        context = ((Context) (obj));
        if (((String) (obj)).contains(s))
        {
            context = ((String) (obj)).replace(s, "");
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (context.trim() == "")
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = context;
        if (context.charAt(0) == ',')
        {
            obj = context.substring(1);
        }
        context = new JSONArray();
        context.put(obj);
        jsonobject.put("s", context);
        context = jsonobject.toString();
        return context;
    }

    static String d()
    {
        Object obj;
        obj = InternalSDKUtil.getContext();
        int k;
        try
        {
            obj = ((Context) (obj)).getContentResolver().query(a, new String[] {
                "aid"
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.internal("[InMobi]-4.5.5", (new StringBuilder()).append("Unable to retrieve Facebook attrib id: ").append(obj).toString());
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        obj = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("aid"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        k = ((String) (obj)).length();
        if (k != 0)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        return null;
        obj = null;
        return ((String) (obj));
    }

    static String e()
    {
        String s;
        try
        {
            s = (String)Class.forName("com.inmobi.commons.uid.PlatformId").getDeclaredMethod("getAndroidId", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                InternalSDKUtil.getContext()
            });
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    static AdvertisingId f()
    {
        return b;
    }

    static void g()
    {
        b = new AdvertisingId();
        b.a(FileOperations.getPreferences(InternalSDKUtil.getContext(), "impref", "gpid"));
        b.a(FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "impref", "limitadtrck"));
        (new Thread(new Runnable() {

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

        })).start();
    }

    static boolean h()
    {
        boolean flag = false;
        int k;
        try
        {
            k = GooglePlayServicesUtil.isGooglePlayServicesAvailable(InternalSDKUtil.getContext());
        }
        catch (NoClassDefFoundError noclassdeffounderror)
        {
            return false;
        }
        if (k == 0)
        {
            flag = true;
        }
        return flag;
    }

    static boolean i()
    {
        AdvertisingId advertisingid = f();
        if (advertisingid != null)
        {
            return advertisingid.isLimitAdTracking();
        } else
        {
            return false;
        }
    }

    static AdvertisingId j()
    {
        return b;
    }

}
