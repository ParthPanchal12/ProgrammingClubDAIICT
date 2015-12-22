// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.net.mtop;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package org.android.agoo.net.mtop:
//            Result

public class MtopResponseHelper
{

    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "SUCCESS";

    public MtopResponseHelper()
    {
    }

    public static void handlerMessageError(String s)
    {
        while (TextUtils.equals(s, "ER_PARAM_DEVICE_TOKEN") || TextUtils.equals(s, "ER_PARAM_INVALID") || TextUtils.equals(s, "ER_PARAM_APP_PACKAGE") || TextUtils.equals(s, "ER_PARAM_AGOO_SDK_VERSION") || TextUtils.equals(s, "ER_BIZ_NO_MULTIPLEX") || TextUtils.equals(s, "FAIL") || TextUtils.equals(s, "FAIL_SYS_SERVLET_ASYNC_TIMEOUT") || TextUtils.equals(s, "FAIL_SYS_SERVLET_ASYNC_ERROR") || TextUtils.equals(s, "FAIL_SYS_PARAM_FORMAT_ERROR") || TextUtils.equals(s, "FAIL_SYS_PARAM_MISSING") || TextUtils.equals(s, "API_STOP_SERVICE") || TextUtils.equals(s, "ERRCODE_AUTH_REJECT") || TextUtils.equals(s, "ERRCODE_APP_ACCESS_API_FAIL") || TextUtils.equals(s, "ERR_SID_INVALID") || TextUtils.equals(s, "FAIL_SYS_HSF_ASYNC_POOL_FOOL") || TextUtils.equals(s, "FAIL_SYS_HSF_ASYNC_TIMEOUT") || TextUtils.equals(s, "FAIL_SYS_HSF_THROWN_EXCEPTION_CODE") || TextUtils.equals(s, "FAIL_SYS_HSF_INVOKE_ERROR") || TextUtils.equals(s, "FAIL_SYS_HSF_NOTFOUND") || !TextUtils.equals(s, "FAIL_SYS_HSF_TIMEOUT")) 
        {
            return;
        }
    }

    public static Result parse(String s)
        throws Throwable
    {
        Result result;
        int i;
        i = 0;
        result = new Result();
        JSONArray jsonarray;
        String s1;
        String as[];
        int j;
        try
        {
            s = new JSONObject(s);
            jsonarray = s.getJSONArray("ret");
            j = jsonarray.length();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        s1 = jsonarray.getString(i);
        if (TextUtils.isEmpty(s1))
        {
            continue; /* Loop/switch isn't completed */
        }
        as = s1.split("::");
        if (as == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (2 != as.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        result.setRetCode(as[0]);
        result.setRetDesc(as[1]);
        if (!"SUCCESS".equals(as[0]))
        {
            break MISSING_BLOCK_LABEL_116;
        }
        result.setData(s.getString("data"));
        result.setSuccess(true);
        return result;
        result.setSuccess(false);
        result.setData(s.getString("data"));
        i++;
          goto _L3
_L2:
        return result;
    }
}
