// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.fb.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.umeng.fb.model:
//            Conversation, UserInfo, Reply

public class Store
{

    private static final String a = com/umeng/fb/model/Store.getName();
    private static Store b;
    private static final String d = "umeng_feedback_conversations";
    private static final String e = "umeng_feedback_user_info";
    private static final String f = "user";
    private static final String g = "uid";
    private static final String h = "device_uuid";
    private static final String i = "conversation_format_version";
    private static final String j = "last_update_at";
    private static final String k = "last_sync_at";
    private Context c;
    private SharedPreferences l;
    private SharedPreferences m;
    private Map n;

    private Store(Context context)
    {
        n = new HashMap();
        c = context.getApplicationContext();
        l = c.getSharedPreferences("umeng_feedback_conversations", 0);
        m = c.getSharedPreferences("umeng_feedback_user_info", 0);
    }

    public static Store getInstance(Context context)
    {
        if (b == null)
        {
            b = new Store(context);
        }
        return b;
    }

    void a()
    {
        l.edit().clear().apply();
        m.edit().clear().apply();
    }

    public List getAllConversationIds()
    {
        Object obj = l.getAll();
        ArrayList arraylist = new ArrayList();
        for (obj = ((Map) (obj)).keySet().iterator(); ((Iterator) (obj)).hasNext(); arraylist.add((String)((Iterator) (obj)).next())) { }
        Collections.sort(arraylist);
        return arraylist;
    }

    public Conversation getConversationById(String s)
    {
        if (!n.containsKey(s))
        {
            try
            {
                Object obj = l.getString(s, "");
                obj = Conversation.a(c, new JSONArray(((String) (obj))), s);
                n.put(s, obj);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }
        return (Conversation)n.get(s);
    }

    public String getDeviceUUID()
    {
        String s1 = m.getString("device_uuid", "");
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = UUID.randomUUID().toString();
            m.edit().putString("device_uuid", s).apply();
        }
        return s;
    }

    public String getUid()
    {
        return m.getString("uid", "");
    }

    public UserInfo getUserInfo()
    {
        Object obj = m.getString("user", "");
        if ("".equals(obj))
        {
            return new UserInfo();
        }
        try
        {
            obj = new UserInfo(new JSONObject(((String) (obj))));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return new UserInfo();
        }
        return ((UserInfo) (obj));
    }

    public long getUserInfoLastSyncAt()
    {
        return m.getLong("last_sync_at", 0L);
    }

    public long getUserInfoLastUpdateAt()
    {
        return m.getLong("last_update_at", 0L);
    }

    public boolean isMigrated()
    {
        boolean flag = false;
        if (m.getInt("conversation_format_version", 0) >= 5)
        {
            flag = true;
        }
        return flag;
    }

    public void migrateData()
    {
        Map map;
        Iterator iterator;
        map = l.getAll();
        iterator = map.keySet().iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        Conversation conversation;
        JSONArray jsonarray;
        s = (String)iterator.next();
        s1 = (String)map.get(s);
        conversation = Conversation.newInstance(c, s);
        jsonarray = new JSONArray(s1);
        int i1 = 0;
_L3:
        Object obj;
        if (i1 >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_244;
        }
        obj = jsonarray.getJSONObject(i1);
        String s3 = ((JSONObject) (obj)).optString("content");
        String s4 = ((JSONObject) (obj)).optString("reply_id");
        String s2 = ((JSONObject) (obj)).optString("status");
        new Date();
        Date date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)).parse(((JSONObject) (obj)).optString("datetime"));
        obj = new Reply(s3, s4, ((JSONObject) (obj)).optString("type"), date.getTime());
        obj.status = s2;
        conversation.addReply(((Reply) (obj)));
_L4:
        i1++;
          goto _L3
        ParseException parseexception;
        parseexception;
        parseexception.printStackTrace();
          goto _L4
        Exception exception;
        exception;
        exception.printStackTrace();
_L2:
        m.edit().putInt("conversation_format_version", 5).apply();
        return;
        Log.c(a, (new StringBuilder()).append("migrate data: id=").append(s).append("\n ").toString());
        Log.c(a, (new StringBuilder()).append("old: \n").append(s1).append("\n").toString());
        Log.c(a, (new StringBuilder()).append("new :\n").append(conversation.toString()).toString());
          goto _L5
    }

    public void removeConversation(String s)
    {
        l.edit().remove(s).apply();
        n.remove(s);
    }

    public void saveConversation(String s, Conversation conversation)
    {
        l.edit().putString(s, conversation.toJson().toString()).apply();
        n.put(s, conversation);
    }

    public void saveUserInfo(UserInfo userinfo)
    {
        m.edit().putString("user", userinfo.toJson().toString()).putLong("last_update_at", System.currentTimeMillis()).apply();
    }

    public void setUid(String s)
    {
        m.edit().putString("uid", s).apply();
    }

    public void setUserInfoLastSyncAt(long l1)
    {
        m.edit().putLong("last_sync_at", l1).apply();
    }

}
