// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.common.message.DeviceConfig;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.umeng.message:
//            MsgConstant

public class MessageSharedPrefs
{

    private static MessageSharedPrefs c;
    private Context a;
    private SharedPreferences b;

    private MessageSharedPrefs(Context context)
    {
        a = context;
        byte byte0 = 0;
        if (android.os.Build.VERSION.SDK_INT > 11)
        {
            byte0 = 4;
        }
        b = context.getSharedPreferences("umeng_message_state", byte0);
    }

    public static MessageSharedPrefs getInstance(Context context)
    {
        com/umeng/message/MessageSharedPrefs;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            c = new MessageSharedPrefs(context);
        }
        context = c;
        com/umeng/message/MessageSharedPrefs;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    int a()
    {
        return b.getInt("KEY_NO_DISTURB_START_HOUR", 23);
    }

    void a(int l)
    {
        b.edit().putInt("mute_duration", l).commit();
    }

    void a(int l, int i1, int j1, int k1)
    {
        b.edit().putInt("KEY_NO_DISTURB_START_HOUR", l).putInt("KEY_NO_DISTURB_START_MINUTE", i1).putInt("KEY_NO_DISTURB_END_HOUR", j1).putInt("KEY_NO_DISTURB_END_MINUTE", k1).commit();
    }

    void a(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        Object obj = b.getAll();
        if (obj != null && ((Map) (obj)).size() > 0)
        {
            obj = ((Map) (obj)).entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s1 = (String)((java.util.Map.Entry)((Iterator) (obj)).next()).getKey();
                if (s1.startsWith("KEY_REGISTERED_TO_UMENG_"))
                {
                    editor.remove(s1);
                }
            } while (true);
        }
        editor.putBoolean((new StringBuilder()).append("KEY_REGISTERED_TO_UMENG_").append(s).toString(), flag).commit();
    }

    boolean a(String s)
    {
        s = (new StringBuilder()).append("KEY_REGISTERED_TO_UMENG_").append(s).toString();
        return b.getBoolean(s, false);
    }

    public void addAlias(String s, String s1)
    {
        s1 = String.format("ALIAS_%s", new Object[] {
            s1
        });
        String s2 = b.getString(s1, null);
        int l = getAliasCount();
        android.content.SharedPreferences.Editor editor = b.edit();
        if (s2 == null)
        {
            editor.putInt("ALIAS_COUNT", l + 1);
        }
        editor.putString(s1, s).commit();
    }

    public transient void addTags(String as[])
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        int i1 = as.length;
        for (int l = 0; l < i1; l++)
        {
            String s = String.format("UMENG_TAG_%s", new Object[] {
                as[l]
            });
            if (!b.getBoolean(s, false))
            {
                editor.putBoolean(s, true);
                editor.putInt("UMENG_TAG_COUNT", getTagCount() + 1);
            }
        }

        editor.commit();
    }

    int b()
    {
        return b.getInt("KEY_NO_DISTURB_START_MINUTE", 0);
    }

    boolean b(String s)
    {
        return b.getBoolean((new StringBuilder()).append("KEY_MSG_RESOURCE_DOWNLOAD_PREFIX").append(s).toString(), false);
    }

    int c()
    {
        return b.getInt("KEY_NO_DISTURB_END_HOUR", 7);
    }

    void c(String s)
    {
        b.edit().putBoolean((new StringBuilder()).append("KEY_MSG_RESOURCE_DOWNLOAD_PREFIX").append(s).toString(), true).commit();
    }

    int d()
    {
        return b.getInt("KEY_NO_DISTURB_END_MINUTE", 0);
    }

    void d(String s)
    {
        b.edit().remove((new StringBuilder()).append("KEY_MSG_RESOURCE_DOWNLOAD_PREFIX").append(s).toString()).commit();
    }

    void e()
    {
        b.edit().putBoolean("KEY_ENEABLED", true).commit();
    }

    void e(String s)
    {
        b.edit().putString("last_msg_id", s).commit();
    }

    void f()
    {
        b.edit().putBoolean("KEY_ENEABLED", false).commit();
    }

    boolean g()
    {
        return b.getBoolean("KEY_ENEABLED", false);
    }

    public int getAliasCount()
    {
        return b.getInt("ALIAS_COUNT", 0);
    }

    public int getAppLaunchLogSendPolicy()
    {
        return b.getInt("KEY_APP_LAUNCH_LOG_SEND_POLICY", -1);
    }

    public long getAppLaunchLogSentAt()
    {
        return b.getLong("KEY_LAUNCH_LOG_SENT_MARK", 0L);
    }

    public String getLastAlias(String s)
    {
        s = String.format("ALIAS_%s", new Object[] {
            s
        });
        return b.getString(s, "");
    }

    public boolean getMergeNotificaiton()
    {
        return b.getBoolean("KEY_MERGE_NOTIFICATION", true);
    }

    public String getMessageAppKey()
    {
        return b.getString("KEY_UMENG_MESSAGE_APP_KEY", "");
    }

    public String getMessageAppSecret()
    {
        return b.getString("KEY_UMENG_MESSAGE_APP_SECRET", "");
    }

    public String getMessageChannel()
    {
        return b.getString("KEY_UMENG_MESSAGE_APP_CHANNEL", "");
    }

    public boolean getNotificaitonOnForeground()
    {
        return b.getBoolean("KEY_SET_NOTIFICATION_ON_FOREGROUND", true);
    }

    public String getPushIntentServiceClass()
    {
        String s = b.getString("KEY_PUSH_INTENT_SERVICE_CLASSNAME", MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME);
        String s1 = b.getString("KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE", null);
        String s2 = DeviceConfig.getAppVersionCode(a);
        try
        {
            Class.forName(s);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME;
        }
        if (TextUtils.equals(s1, s2) && !TextUtils.equals(s2, "Unknown"))
        {
            return s;
        } else
        {
            return MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME;
        }
    }

    public int getSerialNo()
    {
        return b.getInt("serial_no", 1);
    }

    public int getTagCount()
    {
        return b.getInt("UMENG_TAG_COUNT", 0);
    }

    public int getTagRemain()
    {
        return b.getInt("UMENG_TAG_REMAIN", 64);
    }

    public int getTagSendPolicy()
    {
        return b.getInt("KEY_TAG_SEND_POLICY", -1);
    }

    boolean h()
    {
        return b.getBoolean("KEY_CACHE_FILE_TRANSFER_TO_SQL", false);
    }

    public boolean hasAppLaunchLogSentToday()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(getAppLaunchLogSentAt());
        Calendar calendar1 = Calendar.getInstance();
        return calendar.get(6) == calendar1.get(6) && calendar.get(1) == calendar1.get(1);
    }

    boolean i()
    {
        return b.edit().putBoolean("KEY_CACHE_FILE_TRANSFER_TO_SQL", true).commit();
    }

    public boolean isAliasSet(String s, String s1)
    {
        s1 = String.format("ALIAS_%s", new Object[] {
            s1
        });
        s1 = b.getString(s1, null);
        return s != null && s.equals(s1);
    }

    public boolean isAliaseTypeSet(String s)
    {
        s = String.format("ALIAS_%s", new Object[] {
            s
        });
        return b.contains(s);
    }

    public boolean isTagSet(String s)
    {
        s = String.format("UMENG_TAG_%s", new Object[] {
            s
        });
        return b.getBoolean(s, false);
    }

    String j()
    {
        return b.getString("last_msg_id", "");
    }

    int k()
    {
        return b.getInt("mute_duration", 60);
    }

    public void removeAlias(String s, String s1)
    {
        s = String.format("ALIAS_%s", new Object[] {
            s1
        });
        if (b.contains(s))
        {
            int l = getAliasCount();
            s1 = b.edit();
            s1.remove(s);
            s1.putInt("ALIAS_COUNT", l - 1);
            s1.commit();
        }
    }

    public transient void removeTags(String as[])
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        int i1 = as.length;
        for (int l = 0; l < i1; l++)
        {
            String s = String.format("UMENG_TAG_%s", new Object[] {
                as[l]
            });
            if (b.getBoolean(s, false))
            {
                editor.remove(s);
                editor.putInt("UMENG_TAG_COUNT", getTagCount() - 1);
            }
        }

        editor.commit();
    }

    public void resetTags()
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        Object obj = b.getAll();
        if (obj != null && ((Map) (obj)).size() > 0)
        {
            obj = ((Map) (obj)).entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((java.util.Map.Entry)((Iterator) (obj)).next()).getKey();
                if (s.startsWith("UMENG_TAG_"))
                {
                    editor.remove(s);
                }
            } while (true);
        }
        editor.commit();
    }

    public void setAppLaunchLogSendPolicy(int l)
    {
        b.edit().putInt("KEY_APP_LAUNCH_LOG_SEND_POLICY", l).commit();
    }

    public void setAppLaunchLogSentAt(long l)
    {
        b.edit().putLong("KEY_LAUNCH_LOG_SENT_MARK", Calendar.getInstance().getTimeInMillis()).commit();
    }

    public void setMergeNotificaiton(boolean flag)
    {
        b.edit().putBoolean("KEY_MERGE_NOTIFICATION", flag).commit();
    }

    public void setMessageAppKey(String s)
    {
        b.edit().putString("KEY_UMENG_MESSAGE_APP_KEY", s).commit();
    }

    public void setMessageAppSecret(String s)
    {
        b.edit().putString("KEY_UMENG_MESSAGE_APP_SECRET", s).commit();
    }

    public void setMessageChannel(String s)
    {
        b.edit().putString("KEY_UMENG_MESSAGE_APP_CHANNEL", s).commit();
    }

    public void setNotificaitonOnForeground(boolean flag)
    {
        b.edit().putBoolean("KEY_SET_NOTIFICATION_ON_FOREGROUND", flag).commit();
    }

    public void setPushIntentServiceClass(Class class1)
    {
        if (class1 == null)
        {
            b.edit().remove("KEY_PUSH_INTENT_SERVICE_CLASSNAME").remove("KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE").commit();
            return;
        } else
        {
            class1 = class1.getName();
            String s = DeviceConfig.getAppVersionCode(a);
            b.edit().putString("KEY_PUSH_INTENT_SERVICE_CLASSNAME", class1).putString("KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE", s).commit();
            return;
        }
    }

    public void setSerialNo(int l)
    {
        b.edit().putInt("serial_no", l).commit();
    }

    public void setTagRemain(int l)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.putInt("UMENG_TAG_REMAIN", l);
        editor.commit();
    }

    public void setTagSendPolicy(int l)
    {
        b.edit().putInt("KEY_TAG_SEND_POLICY", l).commit();
    }
}
