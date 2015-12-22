// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Reply
    implements Comparable
{

    public static final String CONTENT_TYPE_AUDIO_REPLY = "audio_reply";
    public static final String CONTENT_TYPE_IMAGE_REPLY = "image_reply";
    public static final String CONTENT_TYPE_TEXT_REPLY = "text_reply";
    public static final String STATUS_NOT_SENT = "not_sent";
    public static final String STATUS_SENDING = "sending";
    public static final String STATUS_SENT = "sent";
    public static final String STATUS_WILL_SENT = "will_sent";
    public static final String TYPE_DEV_REPLY = "dev_reply";
    public static final String TYPE_NEW_FEEDBACK = "new_feedback";
    public static final String TYPE_USER_REPLY = "user_reply";
    private static final String a = com/umeng/fb/model/Reply.getName();
    private static final String b = "content";
    private static final String c = "reply_id";
    private static final String d = "type";
    private static final String e = "created_at";
    private static final String f = "status";
    private static final String g = "content_type";
    private static final String h = "audio_duration";
    public float audio_duration;
    public String content;
    public String content_type;
    public long created_at;
    public String feedback_id;
    public String reply_id;
    public String status;
    public String type;

    public Reply(String s, String s1, String s2, long l)
    {
        content = s;
        reply_id = s1;
        type = s2;
        created_at = l;
        status = "not_sent";
        content_type = "text_reply";
        audio_duration = -1F;
    }

    public Reply(String s, String s1, String s2, long l, String s3, float f1)
    {
        content = s;
        reply_id = s1;
        type = s2;
        created_at = l;
        status = "not_sent";
        content_type = s3;
        audio_duration = f1;
    }

    public static Reply fromJson(JSONObject jsonobject)
        throws JSONException
    {
        String s2 = jsonobject.optString("content", "").trim();
        String s3 = jsonobject.optString("reply_id", "");
        String s1 = jsonobject.getString("type");
        String s = jsonobject.optString("content_type", null);
        long l = jsonobject.getLong("created_at");
        float f1 = jsonobject.optLong("audio_duration", -1L);
        Object obj = s;
        if (s == null)
        {
            obj = "text_reply";
        }
        obj = new Reply(s2, s3, s1, l, ((String) (obj)), f1);
        if ("dev_reply".equals(s1))
        {
            obj.status = "sent";
            return ((Reply) (obj));
        } else
        {
            obj.status = jsonobject.optString("status", "not_sent");
            return ((Reply) (obj));
        }
    }

    public int compareTo(Reply reply)
    {
        long l = created_at - reply.created_at;
        if (l > 0L)
        {
            return 1;
        }
        return l != 0L ? -1 : 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Reply)obj);
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("content", content);
            jsonobject.put("reply_id", reply_id);
            jsonobject.put("type", type);
            jsonobject.put("created_at", created_at);
            jsonobject.put("status", status);
            jsonobject.put("content_type", content_type);
            jsonobject.put("audio_duration", audio_duration);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return null;
        }
        return jsonobject;
    }

    public String toString()
    {
        return toJson().toString();
    }

}
