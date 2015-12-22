// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.common.message.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.android.agoo.client.AgooSettings;
import org.android.agoo.client.BaseRegistrar;

// Referenced classes of package com.umeng.message:
//            MessageSharedPrefs, UmengUT, UTrack

public class UmengRegistrar extends BaseRegistrar
{

    private static final String a = "android@umeng";
    private static final String b = com/umeng/message/UmengRegistrar.getName();

    public UmengRegistrar()
    {
    }

    static void a(Context context, boolean flag)
    {
        if (context == null)
        {
            Log.b(b, "setRegisteredToUmeng: null context");
            return;
        }
        String s = getRegistrationId(context);
        if (TextUtils.isEmpty(s))
        {
            Log.b(b, "setRegisteredToUmeng: empty registration id");
            return;
        }
        Object obj = context.getSharedPreferences("umeng_message_state", 0);
        context = ((SharedPreferences) (obj)).edit();
        obj = ((SharedPreferences) (obj)).getAll();
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
                    context.remove(s1);
                }
            } while (true);
        }
        context.putBoolean((new StringBuilder()).append("KEY_REGISTERED_TO_UMENG_").append(s).toString(), flag).commit();
    }

    public static final void checkManifest(Context context)
    {
    }

    public static void checkRegisteredToUmeng(Context context)
    {
        if (!isRegisteredToUmeng(context))
        {
            registerToUmeng(context);
        }
    }

    public static boolean isRegisteredToUmeng(Context context)
    {
        if (context == null)
        {
            Log.b(b, "isRegisteredToUmeng: null context");
            return false;
        }
        String s = getRegistrationId(context);
        if (TextUtils.isEmpty(s))
        {
            Log.b(b, "isRegisteredToUmeng: empty registration id");
            return false;
        } else
        {
            return MessageSharedPrefs.getInstance(context).a(s);
        }
    }

    public static void register(Context context, String s, String s1)
    {
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            Log.b(b, "Push SDK does not work for Android Verion < 8");
            return;
        }
        if (TextUtils.isEmpty(s))
        {
            throw new NullPointerException("appKey==null");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new NullPointerException("appSecret==null");
        } else
        {
            AgooSettings.setUTVersion(context, com/umeng/message/UmengUT.getName());
            a(context, (new StringBuilder()).append("umeng:").append(s).toString(), s1, "android@umeng");
            return;
        }
    }

    public static void registerToUmeng(Context context)
    {
        UTrack.getInstance(context).trackRegister();
    }

}
