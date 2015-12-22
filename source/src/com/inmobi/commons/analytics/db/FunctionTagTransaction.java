// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsFunctions, AnalyticsEvent

public class FunctionTagTransaction extends AnalyticsFunctions
{

    private Context a;
    private Intent b;
    private Bundle c;

    public FunctionTagTransaction(Context context, Intent intent, Bundle bundle)
    {
        a = context;
        b = intent;
        c = bundle;
    }

    private AnalyticsEvent a()
    {
        if (SessionInfo.getSessionId(a) == null || b == null) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        int i;
        obj = new AnalyticsEvent("pi");
        i = b.getIntExtra("RESPONSE_CODE", 0);
        s = b.getStringExtra("INAPP_PURCHASE_DATA");
        Object obj2 = obj;
        if (i != 0) goto _L4; else goto _L3
_L3:
        long l1;
        obj2 = new JSONObject(s);
        ((AnalyticsEvent) (obj)).setTransactionId(((JSONObject) (obj2)).getString("orderId"));
        ((AnalyticsEvent) (obj)).setTransactionProductId(((JSONObject) (obj2)).getString("productId"));
        l1 = ((JSONObject) (obj2)).getLong("purchaseTime");
        long l;
        l = l1;
        if (0L != l1)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        l = System.currentTimeMillis();
        ((AnalyticsEvent) (obj)).setEventTimeStamp(l / 1000L);
        i = ((JSONObject) (obj2)).getInt("purchaseState");
        if (AnalyticsEvent.TRANSACTION_STATUS_GOOGLE_API_VALUES.PURCHASED.getValue() != i) goto _L6; else goto _L5
_L5:
        i = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.PURCHASED.getValue();
_L7:
        ((AnalyticsEvent) (obj)).setTransactionStatus(i);
        obj2 = a(((AnalyticsEvent) (obj)));
        obj = obj2;
        ((AnalyticsEvent) (obj)).setEventSessionId(SessionInfo.getSessionId(a));
        ((AnalyticsEvent) (obj)).setEventSessionTimeStamp(SessionInfo.getSessionTime(a));
_L8:
        insertInDatabase(((AnalyticsEvent) (obj)));
        obj2 = obj;
_L4:
        return ((AnalyticsEvent) (obj2));
_L6:
label0:
        {
            if (AnalyticsEvent.TRANSACTION_STATUS_GOOGLE_API_VALUES.FAILED.getValue() != i)
            {
                break label0;
            }
            i = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.FAILED.getValue();
        }
          goto _L7
label1:
        {
            if (AnalyticsEvent.TRANSACTION_STATUS_GOOGLE_API_VALUES.REFUNDED.getValue() != i)
            {
                break label1;
            }
            i = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.REFUNDED.getValue();
        }
          goto _L7
        i = AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.RESTORED.getValue();
          goto _L7
        Object obj1;
        obj1;
        Log.debug("[InMobi]-[Analytics]-4.5.5", "Error sending transaction info. Transaction details invalid");
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Failed transaction", ((Throwable) (obj1)));
        return null;
_L9:
        Exception exception;
        Log.debug("[InMobi]-[Analytics]-4.5.5", "Error sending transaction info. Bundle details invalid");
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Failed to send extra params transaction", exception);
          goto _L8
        obj1;
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Exception in tag transaction", ((Throwable) (obj1)));
_L2:
        return null;
        exception;
          goto _L9
        exception;
          goto _L9
    }

    private AnalyticsEvent a(AnalyticsEvent analyticsevent)
    {
        if (c.getInt("RESPONSE_CODE") != 0) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = c.getStringArrayList("DETAILS_LIST");
        int i = 0;
_L7:
        String s1;
        String s2;
        long l;
        if (i >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = new JSONObject((String)arraylist.get(i));
        String s = ((JSONObject) (obj)).getString("productId");
        l = ((JSONObject) (obj)).getLong("price_amount_micros");
        s1 = ((JSONObject) (obj)).getString("price_currency_code");
        s2 = ((JSONObject) (obj)).optString("type");
        String s3 = ((JSONObject) (obj)).optString("title");
        obj = ((JSONObject) (obj)).optString("description");
        if (!s.equals(analyticsevent.getTransactionProductId()))
        {
            break MISSING_BLOCK_LABEL_206;
        }
        analyticsevent.setTransactionItemCount(1);
        analyticsevent.setTransactionItemDescription(((String) (obj)));
        analyticsevent.setTransactionItemName(s3);
        if (!"inapp".equals(s2)) goto _L4; else goto _L3
_L3:
        analyticsevent.setTransactionItemType(AnalyticsEvent.TRANSACTION_ITEM_TYPE.INAPP.getValue());
_L6:
        analyticsevent.setTransactionItemPrice((double)l / 1000000D);
        analyticsevent.setTransactionCurrencyCode(s1);
        return analyticsevent;
_L4:
        if (!"subs".equals(s2)) goto _L6; else goto _L5
_L5:
        analyticsevent.setTransactionItemType(AnalyticsEvent.TRANSACTION_ITEM_TYPE.SUBSCRIPTION.getValue());
          goto _L6
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Failed to set purchase bundle info", exception);
        return analyticsevent;
        i++;
        if (true) goto _L7; else goto _L2
_L2:
        return analyticsevent;
    }

    public AnalyticsEvent processFunction()
    {
        return a();
    }
}
