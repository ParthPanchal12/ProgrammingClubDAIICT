// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.aN;
import org.android.agoo.helper.PhoneHelper;
import org.android.agoo.net.mtop.IMtopSynClient;
import org.android.agoo.net.mtop.MtopRequest;
import org.android.agoo.net.mtop.MtopSyncClientV3;
import org.android.agoo.net.mtop.Result;
import org.json.JSONObject;

// Referenced classes of package org.android.agoo.client:
//            AgooSettings

public class DeviceService
{

    private static final String a = "DeviceService";

    public DeviceService()
    {
    }

    private static String a(Context context, String s, String s1, String s2)
    {
        try
        {
            Log.d("DeviceService", (new StringBuilder()).append("getRemoteDeviceID==>").append(s).toString());
            aJ.c("DeviceService", (new StringBuilder()).append("getRemoteDeviceID--->appkey==").append(s).append("|appSecret==").append(s1).append("|ttId==").append(s2).toString());
            MtopRequest mtoprequest = new MtopRequest();
            mtoprequest.setApi("mtop.sys.newDeviceId");
            mtoprequest.setV("4.0");
            mtoprequest.setTtId(s2);
            s2 = aI.r(context);
            if (!TextUtils.isEmpty(s2))
            {
                mtoprequest.putParams("old_device_id", s2);
            } else
            {
                mtoprequest.putParams("new_device", "true");
            }
            mtoprequest.putParams("device_global_id", aN.c(context));
            mtoprequest.putParams("c0", Build.BRAND);
            mtoprequest.putParams("c1", Build.MODEL);
            mtoprequest.putParams("c2", "umeng");
            mtoprequest.putParams("c3", "umeng");
            mtoprequest.putParams("c4", PhoneHelper.getLocalMacAddress(context));
            mtoprequest.putParams("c5", PhoneHelper.getSerialNum());
            mtoprequest.putParams("c6", PhoneHelper.getAndroidId(context));
            s2 = new MtopSyncClientV3();
            s2.setDefaultAppkey(s);
            s2.setDefaultAppSecret(s1);
            s2.setBaseUrl(AgooSettings.getPullUrl(context));
            context = s2.getV3(context, mtoprequest);
            aJ.c("DeviceService", (new StringBuilder()).append("data:[").append(context.toString()).append("]").toString());
            if (context.isSuccess())
            {
                return (new JSONObject(context.getData())).getString("device_id");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        return null;
    }

    public static String getRegistrationId(Context context, String s, String s1, String s2)
    {
        try
        {
            context = a(context, s, s1, s2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }
}
