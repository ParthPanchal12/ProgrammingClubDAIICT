// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.entity;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class UMessage
{

    public static final String DISPLAY_TYPE_AUTOUPDATE = "autoupdate";
    public static final String DISPLAY_TYPE_CUSTOM = "custom";
    public static final String DISPLAY_TYPE_NOTIFICATION = "notification";
    public static final String NOTIFICATION_GO_ACTIVITY = "go_activity";
    public static final String NOTIFICATION_GO_APP = "go_app";
    public static final String NOTIFICATION_GO_CUSTOM = "go_custom";
    public static final String NOTIFICATION_GO_URL = "go_url";
    private JSONObject a;
    public String activity;
    public String after_open;
    public String alias;
    public int builder_id;
    public String custom;
    public String display_type;
    public Map extra;
    public String icon;
    public String img;
    public String largeIcon;
    public String msg_id;
    public boolean play_lights;
    public boolean play_sound;
    public boolean play_vibrate;
    public long random_min;
    public boolean screen_on;
    public String sound;
    public String text;
    public String ticker;
    public String title;
    public String url;

    public UMessage(JSONObject jsonobject)
        throws JSONException
    {
        a = jsonobject;
        msg_id = jsonobject.getString("msg_id");
        display_type = jsonobject.getString("display_type");
        alias = jsonobject.optString("alias");
        random_min = jsonobject.optLong("random_min");
        JSONObject jsonobject1 = jsonobject.getJSONObject("body");
        ticker = jsonobject1.optString("ticker");
        title = jsonobject1.optString("title");
        text = jsonobject1.optString("text");
        play_vibrate = jsonobject1.optBoolean("play_vibrate", true);
        play_lights = jsonobject1.optBoolean("play_lights", true);
        play_sound = jsonobject1.optBoolean("play_sound", true);
        screen_on = jsonobject1.optBoolean("screen_on", false);
        url = jsonobject1.optString("url");
        img = jsonobject1.optString("img");
        sound = jsonobject1.optString("sound");
        icon = jsonobject1.optString("icon");
        after_open = jsonobject1.optString("after_open");
        largeIcon = jsonobject1.optString("largeIcon");
        activity = jsonobject1.optString("activity");
        custom = jsonobject1.optString("custom");
        builder_id = jsonobject1.optInt("builder_id", 0);
        jsonobject = jsonobject.optJSONObject("extra");
        if (jsonobject != null && jsonobject.keys() != null)
        {
            extra = new HashMap();
            String s;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); extra.put(s, jsonobject.getString(s)))
            {
                s = (String)iterator.next();
            }

        }
    }

    public JSONObject getRaw()
    {
        return a;
    }

    public boolean hasResourceFromInternet()
    {
        return isLargeIconFromInternet() || isSoundFromInternet();
    }

    public boolean isLargeIconFromInternet()
    {
        return !TextUtils.isEmpty(img);
    }

    public boolean isSoundFromInternet()
    {
        return !TextUtils.isEmpty(sound) && (sound.startsWith("http://") || sound.startsWith("https://"));
    }
}
