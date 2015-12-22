// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.cellular;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.inmobi.commons.thinICE.icedatacollector.BuildSettings;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.commons.thinICE.cellular:
//            CellOperatorInfo, CellTowerInfo

public final class CellUtil
{
    static class a
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


    private static final String a[] = {
        "android.permission.ACCESS_COARSE_LOCATION"
    };
    private static final String b[] = {
        "android.permission.ACCESS_FINE_LOCATION"
    };
    private static final String c[] = {
        "android.permission.ACCESS_COARSE_LOCATION"
    };

    public CellUtil()
    {
    }

    private static int[] a(String s)
    {
        int ai[] = new int[2];
        ai[0] = -1;
        ai[1] = -1;
        if (s == null || s.equals(""))
        {
            return ai;
        }
        int i;
        int j;
        try
        {
            i = Integer.parseInt(s.substring(0, 3));
            j = Integer.parseInt(s.substring(3));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return ai;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return ai;
        }
        ai[0] = i;
        ai[1] = j;
        return ai;
    }

    public static CellOperatorInfo getCellNetworkInfo(Context context)
    {
        CellOperatorInfo celloperatorinfo = new CellOperatorInfo();
        context = (TelephonyManager)context.getSystemService("phone");
        int ai[] = a(context.getNetworkOperator());
        celloperatorinfo.currentMcc = ai[0];
        celloperatorinfo.currentMnc = ai[1];
        context = a(context.getSimOperator());
        celloperatorinfo.simMcc = context[0];
        celloperatorinfo.simMnc = context[1];
        return celloperatorinfo;
    }

    public static CellTowerInfo getCurrentCellTower(Context context)
    {
        Object obj;
        String s;
        String s1;
        Object obj1;
        obj = (TelephonyManager)context.getSystemService("phone");
        int ai[] = a(((TelephonyManager) (obj)).getNetworkOperator());
        obj1 = ((TelephonyManager) (obj)).getCellLocation();
        if (obj1 == null || ai[0] == -1)
        {
            return null;
        }
        obj = new CellTowerInfo();
        s = String.valueOf(ai[0]);
        s1 = String.valueOf(ai[1]);
        if (!(obj1 instanceof CdmaCellLocation)) goto _L2; else goto _L1
_L1:
        obj1 = (CdmaCellLocation)obj1;
        int i = ((CdmaCellLocation) (obj1)).getNetworkId();
        int k = ((CdmaCellLocation) (obj1)).getBaseStationId();
        int i1 = ((CdmaCellLocation) (obj1)).getSystemId();
        obj.signalStrength = a.a(context);
        if (i != -1 && k != -1 && i1 != -1)
        {
            context = Integer.toHexString(i);
            obj1 = Integer.toHexString(k);
            String s3 = Integer.toHexString(i1);
            obj.id = (new StringBuilder()).append(s).append("-").append(s1).append("-").append(context).append("-").append(((String) (obj1))).append("-").append(s3).toString();
        }
_L4:
        return ((CellTowerInfo) (obj));
_L2:
        obj1 = (GsmCellLocation)obj1;
        int j = ((GsmCellLocation) (obj1)).getCid();
        int l = ((GsmCellLocation) (obj1)).getLac();
        obj.signalStrength = a.a(context);
        if (j != -1 && l != -1)
        {
            context = Integer.toHexString(l);
            String s2 = Integer.toHexString(j);
            obj.id = (new StringBuilder()).append(s).append("-").append(s1).append("-").append(context).append("-").append(s2).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static List getVisibleCellTower(Context context)
    {
        List list = ((TelephonyManager)context.getSystemService("phone")).getNeighboringCellInfo();
        if (list != null)
        {
            context = list;
            if (list.size() == 0)
            {
                context = null;
            }
            return context;
        } else
        {
            return null;
        }
    }

    public static List getVisibleCellTowerIds(Context context)
    {
        Object obj = getVisibleCellTower(context);
        if (obj == null || ((List) (obj)).size() == 0)
        {
            return null;
        }
        context = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); context.add(Integer.valueOf(((NeighboringCellInfo)((Iterator) (obj)).next()).getCid()))) { }
        return context;
    }

    public static boolean hasGetCurrentServingCellPermission(Context context)
    {
        String as[] = a;
        int j = as.length;
        int i = 0;
        boolean flag = true;
        for (; i < j; i++)
        {
            if (context.checkCallingOrSelfPermission(as[i]) != 0)
            {
                flag = false;
            }
        }

        as = b;
        int k = as.length;
        i = 0;
        boolean flag1 = true;
        for (; i < k; i++)
        {
            if (context.checkCallingOrSelfPermission(as[i]) != 0)
            {
                flag1 = false;
            }
        }

        return flag || flag1;
    }

    public static boolean hasGetVisibleCellTowerPermission(Context context)
    {
        String as[] = c;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (context.checkCallingOrSelfPermission(as[i]) != 0)
            {
                return false;
            }
        }

        return true;
    }

}
