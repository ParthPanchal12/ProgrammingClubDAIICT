// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import com.inmobi.commons.metric.EventType;
import com.inmobi.commons.metric.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.internal:
//            Log

public class ApiStatCollector
{
    public static class ApiEventType
        implements EventType
    {

        public static final int API_IMAI_OPEN_EMBEDDED = 1001;
        public static final int API_IMAI_OPEN_EXTERNAL = 1002;
        public static final int API_IMAI_PING = 1003;
        public static final int API_IMAI_PING_IN_WEB_VIEW = 1004;
        public static final int API_MRAID_ASYNC_PING = 31;
        public static final int API_MRAID_CLOSE = 13;
        public static final int API_MRAID_CLOSE_VIDEO = 50;
        public static final int API_MRAID_CREATE_CALENDAR_EVENT = 30;
        public static final int API_MRAID_EXPAND = 11;
        public static final int API_MRAID_GET_AUDIO_VOLUME = 37;
        public static final int API_MRAID_GET_CURRENT_POSITION = 18;
        public static final int API_MRAID_GET_DEFAULT_POSITION = 19;
        public static final int API_MRAID_GET_EXPAND_PROPERTIES = 4;
        public static final int API_MRAID_GET_GALLERY_IMAGE = 25;
        public static final int API_MRAID_GET_MAX_SIZE = 20;
        public static final int API_MRAID_GET_MIC_INTENSITY = 51;
        public static final int API_MRAID_GET_ORIENTATION = 16;
        public static final int API_MRAID_GET_ORIENTATION_PROPERTIES = 5;
        public static final int API_MRAID_GET_PLACEMENT_TYPE = 15;
        public static final int API_MRAID_GET_RESIZE_PROPERTIES = 6;
        public static final int API_MRAID_GET_SCREEN_SIZE = 17;
        public static final int API_MRAID_GET_STATE = 3;
        public static final int API_MRAID_GET_VIDEO_VOLUME = 45;
        public static final int API_MRAID_HIDE_VIDEO = 48;
        public static final int API_MRAID_IS_AUDIO_MUTED = 35;
        public static final int API_MRAID_IS_VIDEO_MUTED = 43;
        public static final int API_MRAID_IS_VIEWABLE = 14;
        public static final int API_MRAID_MAKE_CALL = 29;
        public static final int API_MRAID_MUTE_AUDIO = 33;
        public static final int API_MRAID_MUTE_VIDEO = 41;
        public static final int API_MRAID_OPEN = 1;
        public static final int API_MRAID_OPEN_EXTERNAL = 2;
        public static final int API_MRAID_PAUSE_AUDIO = 39;
        public static final int API_MRAID_PAUSE_VIDEO = 47;
        public static final int API_MRAID_PLAY_AUDIO = 32;
        public static final int API_MRAID_PLAY_VIDEO = 40;
        public static final int API_MRAID_POST_TO_SOCIAL = 21;
        public static final int API_MRAID_RESIZE = 12;
        public static final int API_MRAID_SEEK_AUDIO = 38;
        public static final int API_MRAID_SEEK_VIDEO = 46;
        public static final int API_MRAID_SEND_MAIL = 28;
        public static final int API_MRAID_SEND_SMS = 27;
        public static final int API_MRAID_SET_AUDIO_VOLUME = 36;
        public static final int API_MRAID_SET_EXPAND_PROPERTIES = 7;
        public static final int API_MRAID_SET_ORIENTATION_PROPERTIES = 8;
        public static final int API_MRAID_SET_RESIZE_PROPERTIES = 9;
        public static final int API_MRAID_SET_VIDEO_VOLUME = 44;
        public static final int API_MRAID_SHOW_VIDEO = 49;
        public static final int API_MRAID_STORE_PICTURE = 23;
        public static final int API_MRAID_SUPPORTS = 22;
        public static final int API_MRAID_TAKE_CAMERA_PICTURE = 24;
        public static final int API_MRAID_UNMUTE_AUDIO = 34;
        public static final int API_MRAID_UNMUTE_VIDEO = 42;
        public static final int API_MRAID_USE_CUSTOM_CLOSE = 10;
        public static final int API_MRAID_VIBRATE = 26;
        int a;

        public int getValue()
        {
            return a;
        }

        public ApiEventType(int i)
        {
            a = i;
        }
    }


    private static Logger a = new Logger(3, "apiStats", new com.inmobi.commons.metric.Storage.PreProcessor() {

        public JSONObject process(JSONObject jsonobject)
        {
            Object obj;
            int i;
            obj = new HashMap();
            JSONArray jsonarray;
            Integer integer;
            int j;
            try
            {
                jsonarray = jsonobject.getJSONArray("payload");
            }
            catch (JSONException jsonexception)
            {
                Log.internal("[InMobi]-4.5.5", "Unable to aggregate data. Sending data as-is.");
                return jsonobject;
            }
            i = 0;
_L2:
            if (i >= jsonarray.length())
            {
                break MISSING_BLOCK_LABEL_115;
            }
            j = jsonarray.getJSONObject(i).getInt("t");
            integer = (Integer)((Map) (obj)).get(Integer.valueOf(j));
            if (integer != null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ((Map) (obj)).put(Integer.valueOf(j), Integer.valueOf(1));
            break MISSING_BLOCK_LABEL_214;
            ((Map) (obj)).put(Integer.valueOf(j), Integer.valueOf(integer.intValue() + 1));
            break MISSING_BLOCK_LABEL_214;
            JSONArray jsonarray1;
            jsonarray1 = new JSONArray();
            JSONObject jsonobject1;
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); jsonarray1.put(jsonobject1))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                jsonobject1 = new JSONObject();
                jsonobject1.put("t", entry.getKey());
                jsonobject1.put("v", entry.getValue());
            }

            jsonobject.put("payload", jsonarray1);
            return jsonobject;
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

    });

    public ApiStatCollector()
    {
    }

    public static Logger getLogger()
    {
        return a;
    }

}
