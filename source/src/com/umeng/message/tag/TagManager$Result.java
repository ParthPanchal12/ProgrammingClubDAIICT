// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.tag;

import org.json.JSONObject;

// Referenced classes of package com.umeng.message.tag:
//            TagManager

public static class jsonString
{

    public String errors;
    public String jsonString;
    public int remain;
    public String status;

    public String toString()
    {
        return jsonString;
    }

    public (com.umeng.message.proguard. )
    {
        if (!.().(com.umeng.message.proguard.)) goto _L2; else goto _L1
_L1:
        status = "success";
_L4:
        remain = .n().n();
        errors = .s();
        jsonString = (new StringBuilder()).append("status:").append(status).append(",").append(" remain:").append(remain).append(",").append("description:").append(errors).toString();
        return;
_L2:
        if (.s().s(com.umeng.message.proguard.s))
        {
            status = "invalid_request";
        } else
        if (.s().s(com.umeng.message.proguard.s))
        {
            status = "server_exception";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public status(JSONObject jsonobject)
    {
        status = jsonobject.optString("success", "fail");
        remain = jsonobject.optInt("remain", 0);
        errors = jsonobject.optString("errors");
        jsonString = jsonobject.toString();
    }
}
