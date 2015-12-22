// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.model;

import android.text.TextUtils;
import com.umeng.fb.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class UserInfo
{

    private static final String e = com/umeng/fb/model/UserInfo.getName();
    int a;
    String b;
    Map c;
    Map d;

    public UserInfo()
    {
        a = -1;
        b = "";
        c = new HashMap();
        d = new HashMap();
    }

    UserInfo(JSONObject jsonobject)
        throws JSONException
    {
        a = -1;
        b = "";
        a = jsonobject.optInt("age_group", -1);
        b = jsonobject.optString("gender", "");
        c = new HashMap();
        d = new HashMap();
        JSONObject jsonobject1 = jsonobject.optJSONObject("contact");
        if (jsonobject1 != null)
        {
            String s1;
            for (Iterator iterator1 = jsonobject1.keys(); iterator1.hasNext(); c.put(s1, jsonobject1.getString(s1)))
            {
                s1 = (String)iterator1.next();
            }

        }
        jsonobject = jsonobject.optJSONObject("remark");
        Log.c(e, (new StringBuilder()).append("").append(jsonobject).toString());
        if (jsonobject != null)
        {
            String s;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); d.put(s, jsonobject.getString(s)))
            {
                s = (String)iterator.next();
            }

        }
    }

    public int getAgeGroup()
    {
        return a;
    }

    public Map getContact()
    {
        return c;
    }

    public String getGender()
    {
        return b;
    }

    public Map getRemark()
    {
        return d;
    }

    public JSONObject getRemarkJson()
    {
        Object obj;
        JSONObject jsonobject;
        Object obj1;
        jsonobject = null;
        obj1 = null;
        obj = jsonobject;
        if (d == null) goto _L2; else goto _L1
_L1:
        obj = jsonobject;
        if (d.size() <= 0) goto _L2; else goto _L3
_L3:
        jsonobject = new JSONObject();
        for (obj = d.entrySet().iterator(); ((Iterator) (obj)).hasNext(); jsonobject.put((String)((java.util.Map.Entry) (obj1)).getKey(), ((java.util.Map.Entry) (obj1)).getValue()))
        {
            obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

          goto _L4
        obj;
        obj1 = obj;
        obj = jsonobject;
_L6:
        ((JSONException) (obj1)).printStackTrace();
_L2:
        return ((JSONObject) (obj));
_L4:
        return jsonobject;
        JSONException jsonexception;
        jsonexception;
        obj = obj1;
        obj1 = jsonexception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setAgeGroup(int i)
    {
        a = i;
    }

    public void setContact(Map map)
    {
        c = map;
    }

    public void setGender(String s)
    {
        b = s;
    }

    public void setRemark(Map map)
    {
        d = map;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        if (a > -1)
        {
            jsonobject.put("age_group", a);
        }
        if (!TextUtils.isEmpty(b))
        {
            jsonobject.put("gender", b);
        }
        if (c == null || c.size() <= 0) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new JSONObject();
        java.util.Map.Entry entry;
        for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext(); ((JSONObject) (obj)).put((String)entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

          goto _L3
        obj;
        ((JSONException) (obj)).printStackTrace();
_L5:
        return jsonobject;
_L3:
        jsonobject.put("contact", obj);
_L2:
        if (d == null || d.size() <= 0) goto _L5; else goto _L4
_L4:
        obj = new JSONObject();
        java.util.Map.Entry entry1;
        for (Iterator iterator1 = d.entrySet().iterator(); iterator1.hasNext(); ((JSONObject) (obj)).put((String)entry1.getKey(), entry1.getValue()))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

        jsonobject.put("remark", obj);
        return jsonobject;
    }

}
