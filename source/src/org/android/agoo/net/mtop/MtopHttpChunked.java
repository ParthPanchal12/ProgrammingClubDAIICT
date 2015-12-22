// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.net.mtop;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.umeng.message.proguard.aU;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.bg;
import com.umeng.message.proguard.bh;
import org.android.agoo.helper.PhoneHelper;

// Referenced classes of package org.android.agoo.net.mtop:
//            MtopRequest, MtopRequestHelper

public class MtopHttpChunked extends bg
{

    private volatile String l;
    private volatile String m;
    private volatile String n;

    public MtopHttpChunked()
    {
    }

    private String a(Context context)
    {
        Object obj = new aU(context);
        String s = ((aU) (obj)).c();
        context = new StringBuffer();
        if (!TextUtils.isEmpty(s))
        {
            context.append((new StringBuilder()).append("nt=").append(s).toString());
        }
        obj = ((aU) (obj)).b();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            context.append((new StringBuilder()).append("&apn=").append(((String) (obj))).toString());
        }
        return context.toString();
    }

    private String a(String s, bb bb1)
    {
        String s1 = s;
        if (bb1 != null)
        {
            bb1 = bb1.c();
            s1 = (new StringBuilder()).append(s).append("?").append(bb1).toString();
        }
        return s1;
    }

    private String b(Context context)
    {
        if (-1 == context.getPackageManager().checkPermission("android.permission.ACCESS_COARSE_LOCATION", context.getPackageName()))
        {
            return null;
        }
        Object obj;
        int i;
        int j;
        try
        {
            obj = (TelephonyManager)context.getSystemService("phone");
            context = (GsmCellLocation)((TelephonyManager) (obj)).getCellLocation();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        if (context == null) goto _L2; else goto _L1
_L1:
        i = context.getLac();
        j = context.getCid();
        if (i <= -1 && j <= -1) goto _L2; else goto _L3
_L3:
        context = (new StringBuilder()).append("lac=").append(i).append("&cid=").append(j).toString();
_L5:
        try
        {
            obj = (CdmaCellLocation)((TelephonyManager) (obj)).getCellLocation();
        }
        catch (Throwable throwable)
        {
            return context;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        i = ((CdmaCellLocation) (obj)).getNetworkId();
        j = ((CdmaCellLocation) (obj)).getBaseStationId();
        if (i <= -1 && j <= -1)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        obj = (new StringBuilder()).append("lac=").append(i).append("&cid=").append(j).toString();
        return ((String) (obj));
        return context;
_L2:
        context = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void connect(Context context, MtopRequest mtoprequest, long l1, bh bh1)
    {
        Object obj;
        String s;
        mtoprequest.putParams("c0", Build.BRAND);
        mtoprequest.putParams("c1", Build.MODEL);
        mtoprequest.putParams("c2", "umeng");
        mtoprequest.putParams("c3", "umeng");
        mtoprequest.putParams("c4", PhoneHelper.getLocalMacAddress(context));
        mtoprequest.putParams("c5", PhoneHelper.getSerialNum());
        mtoprequest.putParams("c6", PhoneHelper.getAndroidId(context));
        MtopRequestHelper.checkAppKeyAndAppSecret(mtoprequest, l, m);
        mtoprequest = MtopRequestHelper.getUrlWithRequestParams(context, mtoprequest);
        obj = a(n, mtoprequest);
        s = a(context);
        mtoprequest = ((MtopRequest) (obj));
        if (!TextUtils.isEmpty(s))
        {
            mtoprequest = (new StringBuilder()).append(((String) (obj))).append("&").append(s).toString();
        }
        s = b(context);
        obj = mtoprequest;
        if (!TextUtils.isEmpty(s))
        {
            obj = (new StringBuilder()).append(mtoprequest).append("&").append(s).toString();
        }
        super.connect(context, ((String) (obj)), l1, bh1);
_L1:
        return;
        context;
        if (!hasCallError())
        {
            callError(true);
            bh1.a(504, null, context);
            return;
        }
          goto _L1
    }

    public void setBaseUrl(String s)
    {
        n = s;
    }

    public void setDefaultAppSecret(String s)
    {
        m = s;
    }

    public void setDefaultAppkey(String s)
    {
        l = s;
    }
}
