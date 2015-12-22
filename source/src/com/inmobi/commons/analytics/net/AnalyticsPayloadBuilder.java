// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.net;

import android.content.Context;
import android.os.Build;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thirdparty.Base62;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.net:
//            AnalyticsPayload

public class AnalyticsPayloadBuilder
{

    public AnalyticsPayloadBuilder()
    {
    }

    private JSONArray a(List list)
    {
        JSONArray jsonarray;
        jsonarray = new JSONArray();
        list = list.iterator();
_L4:
        JSONObject jsonobject;
        AnalyticsEvent analyticsevent;
        if (!list.hasNext())
        {
            break MISSING_BLOCK_LABEL_442;
        }
        analyticsevent = (AnalyticsEvent)list.next();
        jsonobject = new JSONObject();
        String s = Base62.fromBase10(analyticsevent.getEventId());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        jsonobject.put("eid", s);
        jsonobject.put("t", analyticsevent.getEventType());
        jsonobject.put("ts", analyticsevent.getEventTimeStamp());
        jsonobject.put("ld", analyticsevent.getEventLevelId());
        jsonobject.put("ls", analyticsevent.getEventLevelStatus());
        jsonobject.put("ln", analyticsevent.getEventLevelName());
        s = analyticsevent.getEventAttributeMap();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        jsonobject.put("am", new JSONObject(analyticsevent.getEventAttributeMap()));
_L1:
        int i;
        jsonobject.put("tt", analyticsevent.getEventTimeTaken());
        if (analyticsevent.getEventAttemptCount() != null)
        {
            jsonobject.put("ac", 1);
        }
        jsonobject.put("at", analyticsevent.getEventAttemptTime());
        jsonobject.put("en", analyticsevent.getEventCustomName());
        if ("ae".equals(analyticsevent.getEventType()))
        {
            jsonobject.put("k", analyticsevent.getAttributeName());
            jsonobject.put("v", analyticsevent.getAttributeValue());
        }
        if (!"pi".equals(analyticsevent.getEventType()))
        {
            break MISSING_BLOCK_LABEL_407;
        }
        jsonobject.put("in", analyticsevent.getTransactionItemName());
        i = analyticsevent.getTransactionItemCount();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        jsonobject.put("n", i);
        jsonobject.put("id", analyticsevent.getTransactionItemDescription());
        jsonobject.put("ip", analyticsevent.getTransactionItemPrice());
        jsonobject.put("c", analyticsevent.getTransactionCurrencyCode());
        jsonobject.put("pi", analyticsevent.getTransactionProductId());
        jsonobject.put("ti", analyticsevent.getTransactionId());
        int j = analyticsevent.getTransactionItemType();
        if (com.inmobi.commons.analytics.db.AnalyticsEvent.TRANSACTION_ITEM_TYPE.INVALID.getValue() != j)
        {
            jsonobject.put("it", j);
        }
        j = analyticsevent.getTransactionStatus();
        if (com.inmobi.commons.analytics.db.AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.INVALID.getValue() != j)
        {
            jsonobject.put("tp", j);
        }
_L2:
        jsonarray.put(jsonobject);
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        Log.debug("[InMobi]-[Analytics]-4.5.5", "Events attribute map is incorrect. Not sending custom event map.");
          goto _L1
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Analytics]-4.5.5", "Creation of events json object failed", exception);
          goto _L2
        return jsonarray;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private JSONObject a(String s, long l, Context context)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("ft", SessionInfo.getFirstTime());
            jsonobject.put("a", context.getPackageName());
            jsonobject.put("an", AnalyticsUtils.getApplicationName(context));
            jsonobject.put("av", AnalyticsUtils.getAppVersion(context));
            jsonobject.put("p", "android");
            jsonobject.put("pv", android.os.Build.VERSION.RELEASE);
            jsonobject.put("ca", InternalSDKUtil.getConnectivityType(context));
            jsonobject.put("ma", Build.MANUFACTURER);
            jsonobject.put("mo", Build.MODEL);
            jsonobject.put("ss", s);
            jsonobject.put("sts", l);
            jsonobject.put("sv", "4.5.5");
            if (AnalyticsUtils.getCountryISO(context) != null)
            {
                jsonobject.put("co", AnalyticsUtils.getCountryISO(context));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Creation of session object failed", s);
            return jsonobject;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "null passed as context", s);
            return jsonobject;
        }
        return jsonobject;
    }

    private JSONObject a(JSONObject jsonobject, JSONArray jsonarray)
    {
        JSONObject jsonobject1 = new JSONObject();
        try
        {
            jsonobject1.put("session", jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Session addition to payload failed");
        }
        try
        {
            jsonobject1.put("events", jsonarray);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.internal("[InMobi]-[Analytics]-4.5.5", "Events addition to payload failed");
            return jsonobject1;
        }
        return jsonobject1;
    }

    public AnalyticsPayload getPayloadList(List list, Context context)
    {
        Log.debug("[InMobi]-[Analytics]-4.5.5", "PayloadBuilder->getPayloadList:");
        JSONArray jsonarray = new JSONArray();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        AnalyticsEvent analyticsevent;
        String s;
        JSONArray jsonarray1;
        for (int i = 0; i < list.size(); jsonarray.put(a(a(s, analyticsevent.getEventSessionTimeStamp(), context), jsonarray1)))
        {
            arraylist.clear();
            analyticsevent = (AnalyticsEvent)list.get(i);
            for (s = analyticsevent.getEventSessionId(); i < list.size() && s.equals(((AnalyticsEvent)list.get(i)).getEventSessionId()); i++)
            {
                arraylist1.add(Long.valueOf(((AnalyticsEvent)list.get(i)).getEventTableId()));
                arraylist.add(list.get(i));
            }

            jsonarray1 = a(arraylist);
        }

        context = new AnalyticsPayload(null, (ArrayList)arraylist1);
        if (jsonarray.length() != 0)
        {
            context.setCompletePayload(jsonarray.toString());
            context.setPayloadSize(list.size());
        }
        return context;
    }
}
