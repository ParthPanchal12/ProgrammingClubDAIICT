// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.tag;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.common.message.DeviceConfig;
import com.umeng.common.message.Log;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack;
import com.umeng.message.UmengRegistrar;
import com.umeng.message.proguard.aD;
import com.umeng.message.proguard.aE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TagManager
{
    public static class Result
    {

        public String errors;
        public String jsonString;
        public int remain;
        public String status;

        public String toString()
        {
            return jsonString;
        }

        public Result(com.umeng.message.proguard.aB.a a1)
        {
            if (!a1.p().equals(com.umeng.message.proguard.aB.a.d.a)) goto _L2; else goto _L1
_L1:
            status = "success";
_L4:
            remain = a1.u().w();
            errors = a1.r();
            jsonString = (new StringBuilder()).append("status:").append(status).append(",").append(" remain:").append(remain).append(",").append("description:").append(errors).toString();
            return;
_L2:
            if (a1.p().equals(com.umeng.message.proguard.aB.a.d.b))
            {
                status = "invalid_request";
            } else
            if (a1.p().equals(com.umeng.message.proguard.aB.a.d.c))
            {
                status = "server_exception";
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public Result(JSONObject jsonobject)
        {
            status = jsonobject.optString("success", "fail");
            remain = jsonobject.optInt("remain", 0);
            errors = jsonobject.optString("errors");
            jsonString = jsonobject.toString();
        }
    }


    private static final String a = com/umeng/message/tag/TagManager.getName();
    private static final String b = "ok";
    private static final String c = "fail";
    private static TagManager d;
    private Context e;

    private TagManager(Context context)
    {
        e = context.getApplicationContext();
    }

    private static String a(List list1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (list1 = list1.iterator(); list1.hasNext(); stringbuilder.append((String)list1.next()).append(",")) { }
        if (stringbuilder.length() > 0 && stringbuilder.charAt(stringbuilder.length() - 1) == ',')
        {
            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
        }
        return stringbuilder.toString();
    }

    private static transient String a(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(as[i]).append(",");
        }

        if (stringbuilder.length() > 0 && stringbuilder.charAt(stringbuilder.length() - 1) == ',')
        {
            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
        }
        return stringbuilder.toString();
    }

    private JSONObject a()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("header", UTrack.getInstance(e).getHeader());
        jsonobject.put("utdid", DeviceConfig.getUtdid(e));
        jsonobject.put("device_token", UmengRegistrar.getRegistrationId(e));
        jsonobject.put("ts", System.currentTimeMillis());
        return jsonobject;
    }

    private static JSONObject a(JSONObject jsonobject, String s)
        throws JSONException
    {
        String s1 = aD.c(s).H().r("application/json").i(jsonobject.toString()).b("UTF-8");
        Log.c(a, (new StringBuilder()).append("postJson() url=").append(s).append("\n request = ").append(jsonobject).append("\n response = ").append(s1).toString());
        return new JSONObject(s1);
    }

    private boolean b()
    {
        if (TextUtils.isEmpty(DeviceConfig.getUtdid(e)))
        {
            Log.b(a, "UTDID is empty");
            return false;
        }
        if (TextUtils.isEmpty(UmengRegistrar.getRegistrationId(e)))
        {
            Log.b(a, "RegistrationId is empty");
            return false;
        } else
        {
            return true;
        }
    }

    private boolean c()
    {
        boolean flag = true;
        if (MessageSharedPrefs.getInstance(e).getTagSendPolicy() != 1)
        {
            flag = false;
        }
        if (flag)
        {
            Log.c(a, "tag is disabled by the server");
        }
        return flag;
    }

    private Result d()
    {
        Result result = new Result(new JSONObject());
        result.remain = MessageSharedPrefs.getInstance(e).getTagRemain();
        result.status = "ok";
        result.jsonString = (new StringBuilder()).append("status:").append(result.status).append(",").append(" remain:").append(result.remain).append(",").append("description:").append(result.status).toString();
        return result;
    }

    public static TagManager getInstance(Context context)
    {
        com/umeng/message/tag/TagManager;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            d = new TagManager(context.getApplicationContext());
        }
        context = d;
        com/umeng/message/tag/TagManager;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public transient Result add(String as[])
        throws Exception
    {
        if (c())
        {
            throw new Exception("Tag API is disabled by the server.");
        }
        if (!b())
        {
            throw new Exception("No utdid or device_token");
        }
        if (as == null || as.length == 0)
        {
            throw new Exception("No tags");
        }
        Object obj = new ArrayList();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (!MessageSharedPrefs.getInstance(e).isTagSet(s) && !((ArrayList) (obj)).contains(s))
            {
                ((ArrayList) (obj)).add(s);
            }
        }

        if (((ArrayList) (obj)).size() == 0)
        {
            obj = d();
        } else
        {
            Object obj1 = a();
            ((JSONObject) (obj1)).put("tags", a(((List) (obj))));
            obj = new aE(e);
            com.umeng.message.proguard.aB.a a1 = ((aE) (obj)).a(((aE) (obj)).a(((JSONObject) (obj1))), (new StringBuilder()).append(MsgConstant.TAG_ENDPOINT).append("/add").toString());
            obj1 = new Result(a1);
            obj = obj1;
            if (a1 != null)
            {
                obj = obj1;
                if (a1.p().equals(com.umeng.message.proguard.aB.a.d.a))
                {
                    MessageSharedPrefs.getInstance(e).addTags(as);
                    MessageSharedPrefs.getInstance(e).setTagRemain(((Result) (obj1)).remain);
                    return ((Result) (obj1));
                }
            }
        }
        return ((Result) (obj));
    }

    public transient Result delete(String as[])
        throws Exception
    {
        if (c())
        {
            throw new Exception("Tag API is disabled by the server.");
        }
        if (!b())
        {
            throw new Exception("No utdid or device_token");
        }
        if (as == null || as.length == 0)
        {
            throw new Exception("No tags");
        }
        Object obj = a();
        ((JSONObject) (obj)).put("tags", a(as));
        Object obj1 = new aE(e);
        obj = ((aE) (obj1)).a(((aE) (obj1)).a(((JSONObject) (obj))), (new StringBuilder()).append(MsgConstant.TAG_ENDPOINT).append("/delete").toString());
        obj1 = new Result(((com.umeng.message.proguard.aB.a) (obj)));
        if (obj != null && ((com.umeng.message.proguard.aB.a) (obj)).p().equals(com.umeng.message.proguard.aB.a.d.a))
        {
            MessageSharedPrefs.getInstance(e).removeTags(as);
            MessageSharedPrefs.getInstance(e).setTagRemain(((Result) (obj1)).remain);
        }
        return ((Result) (obj1));
    }

    public List list()
        throws Exception
    {
        if (c())
        {
            throw new Exception("Tag API is disabled by the server.");
        }
        if (!b())
        {
            throw new Exception("No utdid or device_token");
        }
        Object obj = a();
        aE ae = new aE(e);
        obj = ae.a(ae.a(((JSONObject) (obj))), (new StringBuilder()).append(MsgConstant.TAG_ENDPOINT).append("/get").toString());
        if (obj != null && ((com.umeng.message.proguard.aB.a) (obj)).p().equals(com.umeng.message.proguard.aB.a.d.a) && ((com.umeng.message.proguard.aB.a) (obj)).t() && ((com.umeng.message.proguard.aB.a) (obj)).u().x())
        {
            Log.c(a, ((com.umeng.message.proguard.aB.a) (obj)).u().y());
            return Arrays.asList(((com.umeng.message.proguard.aB.a) (obj)).u().y().split(","));
        } else
        {
            return null;
        }
    }

    public Result reset()
        throws Exception
    {
        if (c())
        {
            throw new Exception("Tag API is disabled by the server.");
        }
        if (!b())
        {
            throw new Exception("No utdid or device_token");
        }
        Object obj = a();
        Object obj1 = new aE(e);
        obj = ((aE) (obj1)).a(((aE) (obj1)).a(((JSONObject) (obj))), (new StringBuilder()).append(MsgConstant.TAG_ENDPOINT).append("/reset").toString());
        obj1 = new Result(((com.umeng.message.proguard.aB.a) (obj)));
        if (obj != null && ((com.umeng.message.proguard.aB.a) (obj)).p().equals(com.umeng.message.proguard.aB.a.d.a))
        {
            MessageSharedPrefs.getInstance(e).resetTags();
        }
        return ((Result) (obj1));
    }

}
