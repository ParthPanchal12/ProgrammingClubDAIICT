// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.monetization.internal:
//            Ad, AdErrorCode, IMAdListener

static class a extends Handler
{

    private final WeakReference a;

    public void handleMessage(Message message)
    {
        Ad ad = (Ad)a.get();
        if (ad != null)
        {
            long l;
            switch (message.what)
            {
            default:
                return;

            case 101: // 'e'
                l = System.currentTimeMillis();
                break;
            }
            long l1 = ad.mFetchStartTime;
            message = new JSONObject();
            try
            {
                message.put("t", l - l1);
                message.put("m", 1);
                Ad.a(ad, message, NetworkEventType.CONNECT_ERROR);
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Error creating metric logs for error at ").append(System.currentTimeMillis()).toString());
            }
            ad.setDownloadingNewAd(false);
            if (ad.mAdListener != null)
            {
                ad.mAdListener.onAdRequestFailed(AdErrorCode.NETWORK_ERROR);
                return;
            }
        }
    }

    public istener(Ad ad)
    {
        a = new WeakReference(ad);
    }
}
