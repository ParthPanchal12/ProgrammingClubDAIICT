// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;


// Referenced classes of package com.umeng.message:
//            UmengIntentService

public class MsgConstant
{

    public static final int ACTION_TYPE_MSG_ARRIVAL = 0;
    public static final int ACTION_TYPE_MSG_CLICK = 1;
    public static final int ACTION_TYPE_MSG_DISMISS = 2;
    public static String ALIAS_ENDPOINT;
    public static final int APP_LAUNCH_BY_MESSAGE = 1;
    public static final int APP_LAUNCH_BY_UNSET = 0;
    public static final int APP_LAUNCH_BY_USER = 2;
    public static final int CACHE_LOG_COUNT_MAX = 20;
    public static final String CACHE_LOG_FILE_EXT = ".log";
    public static final String CACHE_LOG_FILE_PREFIX = "umeng_message_log_cache_";
    public static final String DEFAULT_INTENT_SERVICE_CLASS_NAME = com/umeng/message/UmengIntentService.getName();
    public static String DELETE_ALIAS_ENDPOINT;
    public static final String KEY_ACTION_TYPE = "action_type";
    public static final String KEY_ALIAS = "alias";
    public static final String KEY_APP_LAUNCH_LOG_SEND_POLICY = "KEY_APP_LAUNCH_LOG_SEND_POLICY";
    public static final String KEY_CACHE_FILE_TRANSFER_TO_SQL = "KEY_CACHE_FILE_TRANSFER_TO_SQL";
    public static final String KEY_DEVICE_TOKEN = "device_token";
    public static final String KEY_ENEABLED = "KEY_ENEABLED";
    public static final String KEY_HEADER = "header";
    public static final String KEY_LAST_ALIAS = "last_alias";
    public static final String KEY_LAST_MSG_ID = "last_msg_id";
    public static final String KEY_LAUNCH_LOG_SENT_MARK = "KEY_LAUNCH_LOG_SENT_MARK";
    public static final String KEY_MERGE_NOTIFICATION = "KEY_MERGE_NOTIFICATION";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_MSG_RESOURCE_DOWNLOAD_PREFIX = "KEY_MSG_RESOURCE_DOWNLOAD_PREFIX";
    public static final String KEY_MUTE_DURATION = "mute_duration";
    public static final String KEY_NO_DISTURB_END_HOUR = "KEY_NO_DISTURB_END_HOUR";
    public static final String KEY_NO_DISTURB_END_MINUTE = "KEY_NO_DISTURB_END_MINUTE";
    public static final String KEY_NO_DISTURB_START_HOUR = "KEY_NO_DISTURB_START_HOUR";
    public static final String KEY_NO_DISTURB_START_MINUTE = "KEY_NO_DISTURB_START_MINUTE";
    public static final String KEY_PUSH_INTENT_SERVICE_CLASSNAME = "KEY_PUSH_INTENT_SERVICE_CLASSNAME";
    public static final String KEY_REGISTERED_TO_UMENG = "KEY_REGISTERED_TO_UMENG_";
    public static final String KEY_SERIA_NO = "serial_no";
    public static final String KEY_SET_NOTIFICATION_ON_FOREGROUND = "KEY_SET_NOTIFICATION_ON_FOREGROUND";
    public static final String KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE = "KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE";
    public static final String KEY_TAGS = "tags";
    public static final String KEY_TAG_SEND_POLICY = "KEY_TAG_SEND_POLICY";
    public static final String KEY_TS = "ts";
    public static final String KEY_TYPE = "type";
    public static final String KEY_UMENG_MESSAGE_APP_CHANNEL = "KEY_UMENG_MESSAGE_APP_CHANNEL";
    public static final String KEY_UMENG_MESSAGE_APP_KEY = "KEY_UMENG_MESSAGE_APP_KEY";
    public static final String KEY_UMENG_MESSAGE_APP_SECRET = "KEY_UMENG_MESSAGE_APP_SECRET";
    public static final String KEY_UTDID = "utdid";
    public static String LAUNCH_ENDPOINT;
    public static String LOG_ENDPOINT;
    public static final String PROTOCOL_VERSION = "1.0";
    public static final String PUSH_SHARED_PREFERENCES_FILE_NAME = "umeng_message_state";
    public static String REGISTER_ENDPOINT;
    public static final String SDK_VERSION = "1.7.0";
    public static String TAG_ENDPOINT;
    static long a = 0L;
    static final int b = 0x132b531;
    static final long c = 60000L;
    protected static final String d = "TD";
    private static String e = "msg.umengcloud.com";
    private static String f;
    private static String g;

    public MsgConstant()
    {
    }

    static 
    {
        f = "msg.umengcloud.com/v2";
        g = "http";
        String s = (new StringBuilder()).append(g).append("://").append(f).append("/").toString();
        LOG_ENDPOINT = (new StringBuilder()).append(s).append("push_logs").toString();
        REGISTER_ENDPOINT = (new StringBuilder()).append(s).append("register").toString();
        ALIAS_ENDPOINT = (new StringBuilder()).append(s).append("alias").toString();
        DELETE_ALIAS_ENDPOINT = (new StringBuilder()).append(ALIAS_ENDPOINT).append("/delete").toString();
        LAUNCH_ENDPOINT = (new StringBuilder()).append(s).append("launch").toString();
        TAG_ENDPOINT = (new StringBuilder()).append(s).append("tag").toString();
        a = 0x493e0L;
    }
}
