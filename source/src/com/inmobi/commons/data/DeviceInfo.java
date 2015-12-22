// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.data;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;

public class DeviceInfo
{
    private static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a f[];
        private int e;

        private int a()
        {
            return e;
        }

        static int a(a a1)
        {
            return a1.a();
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/inmobi/commons/data/DeviceInfo$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("PORTRAIT", 0, 1);
            b = new a("REVERSE_PORTRAIT", 1, 2);
            c = new a("LANDSCAPE", 2, 3);
            d = new a("REVERSE_LANDSCAPE", 3, 4);
            f = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i, int j)
        {
            super(s, i);
            e = j;
        }
    }


    private static String a;
    private static String b;
    private static String c;
    private static String d = null;
    private static String e = null;
    private static String f;
    private static String g;
    private static a h;

    public DeviceInfo()
    {
    }

    private static String a()
    {
        return c;
    }

    private static void a(Context context)
    {
        try
        {
            if (f == null)
            {
                f = FileOperations.getPreferences(context, "impref", "AID");
            }
            if (f == null)
            {
                f = UUID.randomUUID().toString();
                FileOperations.setPreferences(context, "impref", "AID", f);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    private static void a(a a1)
    {
        h = a1;
    }

    private static void a(String s)
    {
        a = s;
    }

    private static void b(String s)
    {
        b = s;
    }

    private static void c(String s)
    {
        c = s;
    }

    public static String getAid()
    {
        return f;
    }

    public static int getDisplayRotation(Display display)
    {
        Method method = null;
        Method method1 = android/view/Display.getMethod("getRotation", (Class[])null);
        method = method1;
_L2:
        if (method == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int i = ((Integer)method.invoke(display, (Object[])null)).intValue();
        return i;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        nosuchmethodexception = android/view/Display.getMethod("getOrientation", (Class[])null);
        method = nosuchmethodexception;
        continue; /* Loop/switch isn't completed */
        nosuchmethodexception;
        Log.internal("[InMobi]-4.5.5", "Unable to access getOrientation method via reflection");
        if (true) goto _L2; else goto _L1
        display;
        Log.internal("[InMobi]-4.5.5", "Unable to access display rotation");
_L1:
        return -999;
    }

    public static String getLocalization()
    {
        return b;
    }

    public static String getNetworkType()
    {
        return a;
    }

    public static int getOrientation()
    {
        return a.a(h);
    }

    public static String getPhoneDefaultUserAgent()
    {
        if (g == null)
        {
            return "";
        } else
        {
            return g;
        }
    }

    public static String getScreenDensity()
    {
        return e;
    }

    public static String getScreenSize()
    {
        return d;
    }

    public static boolean isDefOrientationLandscape(int i, int j, int k)
    {
        while (j > k && (i == 0 || i == 2) || j < k && (i == 1 || i == 3)) 
        {
            return true;
        }
        return false;
    }

    public static boolean isTablet(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        context.getMetrics(displaymetrics);
        double d1 = (float)displaymetrics.widthPixels / displaymetrics.xdpi;
        double d2 = (float)displaymetrics.heightPixels / displaymetrics.ydpi;
        return Math.sqrt(d2 * d2 + d1 * d1) > 7D;
    }

    public static void setPhoneDefaultUserAgent(String s)
    {
        g = s;
    }

    public static void setScreenDensity(String s)
    {
        e = s;
    }

    public static void setScreenSize(String s)
    {
        d = s;
    }

    public static void updateDeviceInfo()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        Display display = ((WindowManager)InternalSDKUtil.getContext().getSystemService("window")).getDefaultDisplay();
        display.getMetrics(displaymetrics);
        float f1 = displaymetrics.density;
        int i = (int)((float)WrapperFunctions.getDisplayWidth(display) / f1);
        int j = (int)((float)WrapperFunctions.getDisplayHeight(display) / f1);
        setScreenDensity(String.valueOf(f1));
        setScreenSize((new StringBuilder()).append("").append(i).append("X").append(j).toString());
        setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent());
        if (a() != null) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        c(Build.BRAND);
        obj = Locale.getDefault();
        s = ((Locale) (obj)).getLanguage();
        if (s == null) goto _L4; else goto _L3
_L3:
        String s1;
        try
        {
            s = s.toLowerCase(Locale.ENGLISH);
            s1 = ((Locale) (obj)).getCountry();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Exception setting device info", exception);
            return;
        }
        obj = s;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        obj = (new StringBuilder()).append(s).append("_").append(s1.toLowerCase(Locale.ENGLISH)).toString();
_L5:
        b(((String) (obj)));
_L2:
        if (InternalSDKUtil.getContext() != null)
        {
            a(InternalSDKUtil.getContext());
        }
        updateDeviceOrientation();
        updateNetworkConnectedInfo();
        return;
_L4:
        obj = (String)System.getProperties().get("user.language");
        s1 = (String)System.getProperties().get("user.region");
        if (obj == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        s = (new StringBuilder()).append(((String) (obj))).append("_").append(s1).toString();
        obj = s;
        if (s == null)
        {
            obj = "en";
        }
          goto _L5
    }

    public static void updateDeviceOrientation()
    {
        int i = WrapperFunctions.getCurrentOrientationInFixedValues(InternalSDKUtil.getContext());
        if (i == 9)
        {
            try
            {
                a(a.b);
                return;
            }
            catch (Exception exception)
            {
                Log.debug("[InMobi]-4.5.5", "Error getting the orientation info ", exception);
            }
            break MISSING_BLOCK_LABEL_43;
        }
        if (i != 8)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        a(a.d);
        return;
        return;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        a(a.c);
        return;
        a(a.a);
        return;
    }

    public static void updateNetworkConnectedInfo()
    {
        a(InternalSDKUtil.getConnectivityType(InternalSDKUtil.getContext()));
    }

    static 
    {
        h = a.a;
    }
}
