// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.net;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.fb.model.Reply;
import com.umeng.fb.model.Store;
import com.umeng.fb.model.UserInfo;
import com.umeng.fb.util.Log;
import com.umeng.fb.util.b;
import com.umeng.fb.util.c;
import com.umeng.fb.util.d;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{

    public static final String a = "http://fb.umeng.com";
    public static final String b = "http://fb.umeng.com/api/v2/user/getuid";
    public static final String c = "http://fb.umeng.com/api/v2/feedback/reply/new";
    public static final String d = "http://fb.umeng.com/api/v2/feedback/reply/show";
    public static final String e = "http://fb.umeng.com/api/v2/feedback/new";
    public static final String f = "http://fb.umeng.com/api/v2/user/update";
    private static final String g = com/umeng/fb/net/a.getName();
    private static final int n = 10000;
    private Context h;
    private final String i = "multipart/form-data";
    private final String j = "UTF-8";
    private final String k = "--";
    private final String l = UUID.randomUUID().toString();
    private final String m = "\r\n";

    public a(Context context)
    {
        h = context;
        b();
    }

    private String a(Map map)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (map = map.entrySet().iterator(); map.hasNext(); stringbuffer.append("\r\n"))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            stringbuffer.append("--");
            stringbuffer.append(l);
            stringbuffer.append("\r\n");
            stringbuffer.append((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append((String)entry.getKey()).append("\"").append("\r\n").toString());
            stringbuffer.append("Content-Type: text/plain; charset=UTF-8\r\n");
            stringbuffer.append("\r\n");
            stringbuffer.append((String)entry.getValue());
        }

        return stringbuffer.toString();
    }

    private Map a(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        JSONObject jsonobject = com.umeng.fb.util.d.a(h);
        try
        {
            String s2;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s2, jsonobject.getString(s2)))
            {
                s2 = (String)iterator.next();
            }

        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        hashmap.put("feedback_id", s);
        hashmap.put("reply_id", s1);
        hashmap.put("device_uuid", Store.getInstance(h).getDeviceUUID());
        hashmap.put("type", "user_reply");
        return hashmap;
    }

    private JSONObject a(Reply reply, Map map, String s)
        throws IOException
    {
        DataOutputStream dataoutputstream;
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setConnectTimeout(10000);
        s.setReadTimeout(10000);
        s.setDoOutput(true);
        s.setUseCaches(false);
        s.setRequestMethod("POST");
        s.setRequestProperty("Charset", "UTF-8");
        s.setRequestProperty("Connection", "keep-alive");
        s.setRequestProperty("Content-Type", (new StringBuilder()).append("multipart/form-data;boundary=").append(l).toString());
        dataoutputstream = new DataOutputStream(s.getOutputStream());
        dataoutputstream.write(a(map).getBytes());
        map = new File((new StringBuilder()).append(com.umeng.fb.util.c.b(h)).append(reply.reply_id).append(".opus").toString());
        if (map.exists())
        {
            break MISSING_BLOCK_LABEL_194;
        }
        Log.c("uploadFile", (new StringBuilder()).append("File does not exist --").append(map.getAbsolutePath()).toString());
        return null;
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("--");
        stringbuilder.append(l);
        stringbuilder.append("\r\n");
        stringbuilder.append((new StringBuilder()).append("Content-Disposition: form-data; name=\"voice\"; filename=\"").append(reply.reply_id).append("\"").append("\r\n").toString());
        stringbuilder.append("Content-Type: application/octet-stream\r\n");
        stringbuilder.append("\r\n");
        dataoutputstream.write(stringbuilder.toString().getBytes());
        reply = new FileInputStream(map);
        map = new byte[1024];
_L3:
        int i1 = reply.read(map);
        if (i1 == -1) goto _L2; else goto _L1
_L1:
        dataoutputstream.write(map, 0, i1);
          goto _L3
        reply;
        reply.printStackTrace();
_L5:
        return null;
_L2:
        reply.close();
        dataoutputstream.write("\r\n".getBytes());
        dataoutputstream.write((new StringBuilder()).append("--").append(l).append("--").append("\r\n").toString().getBytes());
        dataoutputstream.flush();
        dataoutputstream.close();
        reply = a(s.getInputStream());
        s.disconnect();
        return reply;
        reply;
        reply.printStackTrace();
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static JSONObject a(InputStream inputstream)
        throws IOException, JSONException
    {
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            String s = inputstream.readLine();
            if (s != null)
            {
                stringbuilder.append(s);
            } else
            {
                inputstream.close();
                return new JSONObject(stringbuilder.toString());
            }
        } while (true);
    }

    private static JSONObject a(String s)
        throws IOException
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setRequestMethod("GET");
        s.setConnectTimeout(10000);
        s.setReadTimeout(10000);
        if (s.getResponseCode() != 200)
        {
            throw new RuntimeException((new StringBuilder()).append("Failed : HTTP error code : ").append(s.getResponseCode()).toString());
        }
          goto _L1
        s;
        s.printStackTrace();
_L3:
        return null;
_L1:
        JSONObject jsonobject;
        jsonobject = a(s.getInputStream());
        s.disconnect();
        Log.c(g, (new StringBuilder()).append("\t ").append(jsonobject).toString());
        return jsonobject;
        s;
        s.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
    }

    private static JSONObject a(String s, Map map)
        throws IOException
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        s = new StringBuilder(s);
        if (s.charAt(s.length() - 1) != '?' && map.size() > 0)
        {
            s.append('?');
        }
        String s1;
        String s2;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); s.append((new StringBuilder()).append(URLEncoder.encode(s1, "UTF-8")).append("=").append(URLEncoder.encode(s2, "UTF-8")).append("&").toString()))
        {
            s1 = (String)iterator.next();
            s2 = (new StringBuilder()).append("").append(map.get(s1)).toString();
        }

        if ('&' == s.charAt(s.length() - 1))
        {
            s.deleteCharAt(s.length() - 1);
        }
        return a(s.toString());
    }

    private static JSONObject a(JSONObject jsonobject, String s)
        throws IOException
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setDoOutput(true);
        s.setRequestMethod("POST");
        s.setRequestProperty("Content-Type", "application/json");
        s.setConnectTimeout(10000);
        s.setReadTimeout(10000);
        jsonobject = jsonobject.toString();
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(s.getOutputStream());
        bufferedoutputstream.write(jsonobject.getBytes());
        bufferedoutputstream.flush();
        if (s.getResponseCode() != 200)
        {
            throw new RuntimeException((new StringBuilder()).append("Failed : HTTP error code : ").append(s.getResponseCode()).toString());
        }
          goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L3:
        return null;
_L1:
        jsonobject = a(s.getInputStream());
        s.disconnect();
        Log.c(g, (new StringBuilder()).append("\t response:\n").append(jsonobject).toString());
        return jsonobject;
        jsonobject;
        jsonobject.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
    }

    private Map b(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        try
        {
            if (c(jsonobject))
            {
                String s = jsonobject.getJSONObject("data").getString("feedback_id");
                long l1 = jsonobject.getJSONObject("data").getLong("created_at");
                hashmap.put("feedback_id", s);
                hashmap.put("created_at", Long.valueOf(l1));
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return hashmap;
        }
        return hashmap;
    }

    private static void b()
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 8)
        {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private boolean c(JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((jsonobject = jsonobject.getString("status")) != null)
        {
            boolean flag;
            try
            {
                flag = jsonobject.equals("200");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
                return false;
            }
            if (flag)
            {
                return true;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public String a()
    {
        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        JSONObject jsonobject = com.umeng.fb.util.d.a(h);
        stringbuilder = new StringBuilder("http://fb.umeng.com/api/v2/user/getuid");
        stringbuilder.append("?");
        String s;
        String s1;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append(URLEncoder.encode(s, "UTF-8")).append("=").append(URLEncoder.encode(s1, "UTF-8")).append("&").toString()))
        {
            s = (String)iterator.next();
            s1 = jsonobject.get(s).toString();
        }

          goto _L1
        Object obj;
        obj;
_L5:
        Object obj1 = "";
_L3:
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj1));
_L1:
        if ('&' == stringbuilder.charAt(stringbuilder.length() - 1))
        {
            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
        }
        obj1 = a(stringbuilder.toString());
        if (!c(((JSONObject) (obj1))))
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = ((JSONObject) (obj1)).getJSONObject("data").getString("uid");
        Store.getInstance(h).setUid(((String) (obj1)));
        if (true) goto _L3; else goto _L2
_L2:
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
        throw obj1;
    }

    public List a(String s, long l1)
        throws IOException, JSONException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new HashMap();
        ((Map) (obj)).put("feedback_id", s);
        ((Map) (obj)).put("appkey", com.umeng.fb.util.b.p(h));
        ((Map) (obj)).put("updated_at", Long.valueOf(l1));
        s = a("http://fb.umeng.com/api/v2/feedback/reply/show", ((Map) (obj)));
        Log.c(g, (new StringBuilder()).append("getDevReply resp: ").append(s).toString());
        s = s.getJSONObject("data").getJSONArray("result");
        obj = new ArrayList();
        int i1 = 0;
_L1:
        int j1 = s.length();
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        ((List) (obj)).add(Reply.fromJson(s.getJSONObject(i1)));
_L2:
        i1++;
          goto _L1
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
          goto _L2
        s;
        throw s;
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
    }

    public Map a(String s, Reply reply)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = null;
        if (!"text_reply".equals(reply.content_type)) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        jsonobject = com.umeng.fb.util.d.a(h);
        jsonobject.put("content", reply.content);
        jsonobject.put("feedback_id", s);
        jsonobject.put("reply_id", reply.reply_id);
        jsonobject.put("device_uuid", Store.getInstance(h).getDeviceUUID());
        jsonobject.put("type", "user_reply");
        jsonobject = a(jsonobject, "http://fb.umeng.com/api/v2/feedback/reply/new");
_L4:
        s = b(jsonobject);
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        jsonobject = obj;
        if (!"audio_reply".equals(reply.content_type)) goto _L4; else goto _L3
_L3:
        jsonobject = a(reply, a(s, reply.reply_id), "http://fb.umeng.com/api/v2/feedback/reply/new");
          goto _L4
        s;
        s.printStackTrace();
        jsonobject = obj;
          goto _L4
        s;
        throw s;
    }

    public boolean a(JSONObject jsonobject)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        JSONObject jsonobject1 = com.umeng.fb.util.d.a(h);
        jsonobject1.put("uid", Store.getInstance(h).getUid());
        jsonobject1.put("userinfo", jsonobject.toString());
        flag = c(a(jsonobject1, "http://fb.umeng.com/api/v2/user/update"));
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        jsonobject;
        jsonobject.printStackTrace();
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject;
        throw jsonobject;
    }

    public Map b(String s, Reply reply)
    {
        this;
        JVM INSTR monitorenter ;
        new HashMap();
        Object obj = null;
        if (!"text_reply".equals(reply.content_type)) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        jsonobject = com.umeng.fb.util.d.a(h);
        jsonobject.put("content", reply.content);
        jsonobject.put("uid", Store.getInstance(h).getUid());
        jsonobject.put("device_uuid", Store.getInstance(h).getDeviceUUID());
        jsonobject.put("feedback_id", s);
        if (Store.getInstance(h).getUserInfo().getRemarkJson() != null)
        {
            jsonobject.put("remark", Store.getInstance(h).getUserInfo().getRemarkJson().toString());
        }
        jsonobject = a(jsonobject, "http://fb.umeng.com/api/v2/feedback/new");
_L4:
        s = b(jsonobject);
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        jsonobject = obj;
        if (!"audio_reply".equals(reply.content_type)) goto _L4; else goto _L3
_L3:
        jsonobject = a(reply, a(s, reply.reply_id), "http://fb.umeng.com/api/v2/feedback/new");
          goto _L4
        s;
        s.printStackTrace();
        jsonobject = obj;
          goto _L4
        s;
        throw s;
    }

}
