// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.umeng.message.proguard:
//            Y, ad, ac

public class V
{

    private static final String a = com/umeng/message/proguard/V.getName();
    private static final String b = "OfJbkLdFbPOMbGyP";
    private static final String c = "EvQwnbilKezpOJey";
    private static final String d = "rKrMJgyAEbVtSQGi";
    private static Map e = new ConcurrentHashMap();
    private static Map f = new ConcurrentHashMap();

    public V()
    {
    }

    public static String a(Context context, String s, String s1)
    {
        if (context == null)
        {
            Log.e(a, "no context!");
            s = "";
        } else
        {
            String s2 = a(s, s1);
            s1 = (String)e.get(s2);
            if (Y.a)
            {
                Log.d(a, (new StringBuilder()).append("cache AID:").append(s1).toString());
            }
            s = s1;
            if (ad.a(s1))
            {
                context = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getString("EvQwnbilKezpOJey".concat(s2), "");
                e.put(s2, context);
                return context;
            }
        }
        return s;
    }

    private static String a(String s, String s1)
    {
        s = Base64.encodeToString(s.concat(s1).getBytes(Charset.forName("UTF-8")), 2);
        if (Y.a)
        {
            Log.d(a, (new StringBuilder()).append("encodedName:").append(s).toString());
        }
        return s;
    }

    public static void a(Context context, String s, String s1, String s2)
    {
        if (context == null)
        {
            Log.e(a, "no context!");
            return;
        }
        s = a(s, s2);
        long l = System.currentTimeMillis();
        e.put(s, s1);
        f.put(s, Long.valueOf(l));
        context = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            ac.a(context.edit().putString("EvQwnbilKezpOJey".concat(s), s1));
            ac.a(context.edit().putLong("rKrMJgyAEbVtSQGi".concat(s), l));
            return;
        } else
        {
            context.edit().putString("EvQwnbilKezpOJey".concat(s), s1).commit();
            context.edit().putLong("rKrMJgyAEbVtSQGi".concat(s), l).commit();
            return;
        }
    }

    public static long b(Context context, String s, String s1)
    {
        if (context == null)
        {
            Log.e(a, "no context!");
            return 0L;
        }
        String s2 = a(s, s1);
        long l;
        if (f.containsKey(s2))
        {
            l = ((Long)f.get(s2)).longValue();
        } else
        {
            l = 0L;
        }
        s1 = Long.valueOf(l);
        if (Y.a)
        {
            Log.d(a, (new StringBuilder()).append("cache AIDGenTime:").append(s1).toString());
        }
        s = s1;
        if (s1.longValue() == 0L)
        {
            s = Long.valueOf(context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getLong("rKrMJgyAEbVtSQGi".concat(s2), 0L));
            f.put(s2, s);
        }
        return s.longValue();
    }

}
