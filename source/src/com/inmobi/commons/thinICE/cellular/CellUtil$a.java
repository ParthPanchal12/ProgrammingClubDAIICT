// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.cellular;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.inmobi.commons.thinICE.icedatacollector.BuildSettings;
import java.lang.reflect.Method;
import java.util.ArrayList;

// Referenced classes of package com.inmobi.commons.thinICE.cellular:
//            CellUtil

static class ldSettings
{

    static int a(Context context)
    {
        context = (TelephonyManager)context.getSystemService("phone");
        context = (ArrayList)android/telephony/TelephonyManager.getMethod("getAllCellInfo", (Class[])null).invoke(context, (Object[])null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        int i;
        context = ((Context) (context.get(0)));
        context = ((Context) (context.getClass().getMethod("getCellSignalStrength", (Class[])null).invoke(context, (Object[])null)));
        i = ((Integer)context.getClass().getMethod("getDbm", (Class[])null).invoke(context, (Object[])null)).intValue();
        return i;
        context;
        if (BuildSettings.DEBUG)
        {
            Log.e("IceDataCollector", "Error getting cell tower signal strength", context);
        }
        return 0;
    }
}
