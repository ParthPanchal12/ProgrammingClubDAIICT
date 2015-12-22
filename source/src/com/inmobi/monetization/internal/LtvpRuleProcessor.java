// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.ErrorCode;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Response;
import com.inmobi.commons.network.ServiceProvider;
import com.inmobi.commons.network.abstraction.INetworkListener;
import com.inmobi.monetization.internal.objects.LtvpRuleCache;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.monetization.internal:
//            LtvpRulesObject

public class LtvpRuleProcessor
    implements INetworkListener
{
    public static final class ActionsRule extends Enum
    {

        public static final ActionsRule ACTIONS_ONLY;
        public static final ActionsRule ACTIONS_TO_MEDIATION;
        public static final ActionsRule MEDIATION;
        public static final ActionsRule NO_ADS;
        private static final ActionsRule b[];
        int a;

        static ActionsRule a(int i)
        {
            switch (i)
            {
            default:
                return MEDIATION;

            case 1: // '\001'
                return NO_ADS;

            case 2: // '\002'
                return ACTIONS_TO_MEDIATION;

            case 3: // '\003'
                return ACTIONS_ONLY;
            }
        }

        public static ActionsRule valueOf(String s)
        {
            return (ActionsRule)Enum.valueOf(com/inmobi/monetization/internal/LtvpRuleProcessor$ActionsRule, s);
        }

        public static ActionsRule[] values()
        {
            return (ActionsRule[])b.clone();
        }

        public int getValue()
        {
            return a;
        }

        static 
        {
            MEDIATION = new ActionsRule("MEDIATION", 0, 0);
            NO_ADS = new ActionsRule("NO_ADS", 1, 1);
            ACTIONS_TO_MEDIATION = new ActionsRule("ACTIONS_TO_MEDIATION", 2, 2);
            ACTIONS_ONLY = new ActionsRule("ACTIONS_ONLY", 3, 3);
            b = (new ActionsRule[] {
                MEDIATION, NO_ADS, ACTIONS_TO_MEDIATION, ACTIONS_ONLY
            });
        }

        private ActionsRule(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }


    private ServiceProvider a;

    private LtvpRuleProcessor()
    {
        a = ServiceProvider.getInstance();
    }

    public static LtvpRuleProcessor getInstance()
    {
        return new LtvpRuleProcessor();
    }

    public void dispatchLtvpRule()
    {
        Log.internal("[InMobi]-[Monetization]", "Fetching LTVP Rule");
        Request request = new Request(AnalyticsInitializer.getConfigParams().getEndPoints().getRulesUrl(), com.inmobi.commons.network.Request.Format.KEY_VAL, com.inmobi.commons.network.Request.Method.GET);
        request.fillAppInfo();
        request.fillDeviceInfo();
        a.executeTask(request, this);
    }

    public ActionsRule getLtvpRuleConfig(long l)
    {
        ActionsRule.MEDIATION.getValue();
        LtvpRuleCache ltvprulecache = LtvpRuleCache.getInstance(InternalSDKUtil.getContext());
        if (ltvprulecache.getHardExpiryForLtvpRule() <= System.currentTimeMillis() || ltvprulecache.getHardExpiryForLtvpRule() == 0L)
        {
            Log.internal("[InMobi]-[Monetization]", "Hard Expiry or 1st rule fetch. Default mediation. Fetching Rule");
            dispatchLtvpRule();
            ltvprulecache.clearLtvpRuleCache();
            return ActionsRule.MEDIATION;
        }
        int i;
        if (ltvprulecache.getSoftExpiryForLtvpRule() <= System.currentTimeMillis())
        {
            Log.internal("[InMobi]-[Monetization]", "Soft Expiry. Default mediation. Fetching Rule");
            dispatchLtvpRule();
            i = ltvprulecache.getLtvpRule(l);
        } else
        {
            Log.internal("[InMobi]-[Monetization]", "Valid rule");
            i = ltvprulecache.getLtvpRule(l);
        }
        return ActionsRule.a(i);
    }

    public void onRequestFailed(Request request, Response response)
    {
        try
        {
            Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Ltvp Rule error").append(response.getError().toString()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            Log.internal("[InMobi]-[Monetization]", "Ltvp Rule exception", request);
        }
    }

    public void onRequestSucceded(Request request, Response response)
    {
        if (response.getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        request = new JSONObject(response.getResponseBody());
        if (!request.getBoolean("success"))
        {
            int i = request.getInt("error_code");
            request = request.getString("error_message");
            Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Received LTVP rule fetch failure: ").append(i).append(" : ").append(request).toString());
            return;
        }
        Object obj;
        long l;
        long l1;
        long l2;
        try
        {
            JSONObject jsonobject = request.getJSONObject("response");
            Log.debug("[InMobi]-[Monetization]", (new StringBuilder()).append("Received LTVP rule fetch success: ").append(jsonobject.toString()).toString());
            request = new LtvpRulesObject();
            response = jsonobject.getString("rule_id");
            l = jsonobject.getLong("ts");
            obj = jsonobject.getJSONObject("exp");
            l1 = ((JSONObject) (obj)).getLong("se");
            l2 = ((JSONObject) (obj)).getLong("he");
            obj = new HashMap();
            jsonobject = jsonobject.getJSONObject("rules");
            String s;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); ((HashMap) (obj)).put(s, Integer.valueOf(jsonobject.getInt(String.valueOf(s)))))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            Log.internal("[InMobi]-[Monetization]", "Exception getting ltvp rule", request);
            return;
        }
        request.setRuleId(response);
        request.setTimeStamp(l);
        request.setSoftExpiry(l1);
        request.setHardExpiry(l2);
        request.setRules(((HashMap) (obj)));
        Log.internal("[InMobi]-[Monetization]", (new StringBuilder()).append("Ltvp Rule received").append(request.getRules().toString()).toString());
        LtvpRuleCache.getInstance(InternalSDKUtil.getContext()).setLtvpRuleConfig(request);
    }
}
