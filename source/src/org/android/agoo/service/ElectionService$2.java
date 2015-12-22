// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.service;

import android.text.TextUtils;
import com.umeng.message.proguard.aJ;
import java.util.Map;
import org.android.agoo.net.mtop.MtopResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package org.android.agoo.service:
//            ElectionService

class er extends MtopResponseHandler
{

    final ElectionService a;

    public void onFailure(String s, String s1)
    {
        aJ.d("ElectionService", (new StringBuilder()).append("errCode[").append(s).append("]errDesc[").append(s1).append("]").toString());
        ElectionService.b(a);
    }

    public void onSuccess(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            aJ.c("ElectionService", "remote content==null");
            ElectionService.b(a);
            return;
        }
        aJ.c("ElectionService", (new StringBuilder()).append("remote election result[").append(s).append("] ").toString());
        s = new JSONObject(s);
        ElectionService.a(a, Long.parseLong(s.getString("time_out")));
        s = s.getJSONArray("vote_list");
        if (s == null)
        {
            try
            {
                aJ.c("ElectionService", "remote vote_list==null");
                ElectionService.b(a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                aJ.d("ElectionService", "remote--JSONException", s);
            }
            ElectionService.b(a);
            return;
        }
        int k = s.length();
        if (k > 0) goto _L2; else goto _L1
_L1:
        aJ.c("ElectionService", "remote vote_list.length==0");
        ElectionService.b(a);
        return;
_L10:
        int i;
        if (i >= k) goto _L4; else goto _L3
_L3:
        Object obj = s.getJSONObject(i);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        ElectionService.b(a);
        return;
        String s1;
        s1 = ((JSONObject) (obj)).getString("package_name");
        if (TextUtils.isEmpty(s1))
        {
            aJ.c("ElectionService", "sudoPack==null");
            ElectionService.b(a);
            return;
        }
        if (ElectionService.c(a).get(s1) == null)
        {
            aJ.c("ElectionService", (new StringBuilder()).append("elctionResults not found[").append(s1).append("]").toString());
            ElectionService.b(a);
            return;
        }
        obj = ((JSONObject) (obj)).getJSONArray("package_name_list");
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        aJ.c("ElectionService", "remote package_name_list==null");
        ElectionService.b(a);
        return;
        int l = ((JSONArray) (obj)).length();
        if (l > 0) goto _L6; else goto _L5
_L5:
        aJ.c("ElectionService", "remote package_name_list.length==0");
        ElectionService.b(a);
        return;
_L8:
        int j;
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        String s2 = ((JSONArray) (obj)).getString(j);
        ElectionService.d(a).put(s2, s1);
        j++;
        continue; /* Loop/switch isn't completed */
_L4:
        ElectionService.a(a, "remote");
        return;
_L2:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 0;
        if (true) goto _L8; else goto _L7
_L7:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    er(ElectionService electionservice)
    {
        a = electionservice;
        super();
    }
}
