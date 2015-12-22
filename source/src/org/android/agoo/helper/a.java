// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.aU;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.bd;
import com.umeng.message.proguard.bp;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.agoo.client.AgooSettings;
import org.apache.http.HttpHost;

// Referenced classes of package org.android.agoo.helper:
//            PhoneHelper

public class org.android.agoo.helper.a
{
    class a
        implements Runnable
    {

        String a;
        b b;
        Context c;
        final org.android.agoo.helper.a d;

        public void run()
        {
            Object obj;
            org.android.agoo.client.AgooSettings.Mode mode;
            obj = null;
            mode = AgooSettings.getMode(c);
            Object obj1;
            Object obj2;
            Object obj3;
            int j;
            obj1 = new bb();
            ((bb) (obj1)).a("id", a);
            ((bb) (obj1)).a("app_version_code", (new StringBuilder()).append("").append(bp.b(c)).toString());
            ((bb) (obj1)).a("agoo_version_code", (new StringBuilder()).append("").append(AgooSettings.getAgooReleaseTime()).toString());
            obj2 = new aU(c);
            obj3 = ((aU) (obj2)).c();
            if (!TextUtils.isEmpty(((CharSequence) (obj3))))
            {
                ((bb) (obj1)).a("agoo_network", ((String) (obj3)));
            }
            obj2 = ((aU) (obj2)).b();
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                ((bb) (obj1)).a("agoo_apn", ((String) (obj2)));
            }
            obj2 = d.a(c);
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                ((bb) (obj1)).a("agoo_operators", ((String) (obj2)));
            }
            obj3 = mode.getPushApollIp();
            obj2 = AgooSettings.getApollUrl(c);
            j = mode.getPushApollPort();
            if (org.android.agoo.helper.a.a(d) == null)
            {
                org.android.agoo.helper.a.a(d, new bd());
            }
            if (AgooSettings.isAgooTestMode(c)) goto _L2; else goto _L1
_L1:
            obj1 = org.android.agoo.helper.a.a(d).get(c, ((String) (obj2)), ((bb) (obj1)));
            obj = obj1;
_L4:
            org.android.agoo.helper.a.a(d, ((com.umeng.message.proguard.bd.a) (obj)), b, mode);
            return;
_L2:
            aJ.c("HostClient", (new StringBuilder()).append("test host ip [ ").append(((String) (obj3))).append(" ]").toString());
            obj3 = new HttpHost(((String) (obj3)), j);
            obj1 = org.android.agoo.helper.a.a(d).get(c, ((HttpHost) (obj3)), ((String) (obj2)), ((bb) (obj1)));
            obj = obj1;
            continue; /* Loop/switch isn't completed */
            Throwable throwable;
            throwable;
            aJ.d("HostClient", "host Throwable", throwable);
            if (true) goto _L4; else goto _L3
_L3:
        }

        public a(Context context, String s, b b1)
        {
            d = org.android.agoo.helper.a.this;
            super();
            c = context;
            a = s;
            b = b1;
        }
    }

    public static interface b
    {

        public abstract void a(int j, String s);

        public abstract void a(String s);
    }


    private static final String a = "HostClient";
    private static final String b = "AGOO_HOST";
    private static final String c = "AGOO_HOST_SIZE";
    private static final String d = "AGOO_HOST_VALUE_";
    private volatile int e;
    private volatile ThreadPoolExecutor f;
    private volatile bd g;
    private volatile Context h;
    private volatile String i;

    public org.android.agoo.helper.a(Context context, String s)
    {
        e = 0;
        g = null;
        h = context;
        i = s;
        f = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
        g = new bd();
    }

    private int a(Context context, String as[])
    {
        int k = 0;
        context = context.getSharedPreferences("AGOO_HOST", 4).edit();
        context.clear();
        int i1 = as.length;
        for (int j = 0; j < i1;)
        {
            int l = k;
            if (!TextUtils.isEmpty(as[j]))
            {
                l = k;
                if (a(as[j]))
                {
                    context.putString((new StringBuilder()).append("AGOO_HOST_VALUE_").append(k).toString(), as[j]);
                    l = k + 1;
                }
            }
            j++;
            k = l;
        }

        context.putInt("AGOO_HOST_SIZE", k);
        context.commit();
        return k;
    }

    static bd a(org.android.agoo.helper.a a1)
    {
        return a1.g;
    }

    static bd a(org.android.agoo.helper.a a1, bd bd1)
    {
        a1.g = bd1;
        return bd1;
    }

    private static String a(Context context, int j)
    {
        return context.getSharedPreferences("AGOO_HOST", 4).getString((new StringBuilder()).append("AGOO_HOST_VALUE_").append(j).toString(), null);
    }

    private void a(com.umeng.message.proguard.bd.a a1, b b1, org.android.agoo.client.AgooSettings.Mode mode)
    {
        if (a1 == null)
        {
            b1.a(408, mode.getPushApollIp());
            return;
        }
        if (200 != a1.a)
        {
            b1.a(404, (new StringBuilder()).append("get [").append(mode.getPushApollIp()).append("] error").toString());
            return;
        }
        if (TextUtils.isEmpty(a1.b))
        {
            b1.a(504, (new StringBuilder()).append("get [").append(mode.getPushApollIp()).append("] error").toString());
            return;
        }
        if (TextUtils.indexOf(a1.b, "<html>") != -1)
        {
            b1.a(307, (new StringBuilder()).append("get [").append(mode.getPushApollIp()).append("] error").toString());
            return;
        }
        a1 = a1.b.split("\\|");
        if (a1.length <= 0)
        {
            b1.a(504, (new StringBuilder()).append("get [").append(mode.getPushApollIp()).append("] error").toString());
            return;
        }
        if (a1.length <= 0)
        {
            b1.a(504, (new StringBuilder()).append("get [").append(mode.getPushApollIp()).append("] error").toString());
            return;
        }
        if (a(h, ((String []) (a1))) <= 0)
        {
            b1.a(504, (new StringBuilder()).append("get [").append(mode.getPushApollIp()).append("] error").toString());
            return;
        } else
        {
            b1.a(a(h, 0));
            return;
        }
    }

    static void a(org.android.agoo.helper.a a1, com.umeng.message.proguard.bd.a a2, b b1, org.android.agoo.client.AgooSettings.Mode mode)
    {
        a1.a(a2, b1, mode);
    }

    private boolean a(String s)
    {
        String s1 = (new StringBuilder()).append("(").append("(2[0-4]\\d)|(25[0-5])").append(")|(").append("1\\d{2}").append(")|(").append("[1-9]\\d").append(")|(").append("\\d").append(")").toString();
        return Pattern.compile((new StringBuilder()).append("(").append(s1).append(").(").append(s1).append(").(").append(s1).append(").(").append(s1).append("):\\d*$").toString()).matcher(s).matches();
    }

    private void b(b b1)
    {
        f.submit(new a(h, i, b1));
    }

    public String a(Context context)
    {
        context = PhoneHelper.getImsi(context);
        if (!TextUtils.isEmpty(context))
        {
            if (context.startsWith("46000") || context.startsWith("46002"))
            {
                return "china_mobile";
            }
            if (context.startsWith("46001"))
            {
                return "china_unicom";
            }
            if (context.startsWith("46003"))
            {
                return "china_telecom";
            }
        }
        return null;
    }

    public void a(b b1)
    {
        if (b1 == null)
        {
            throw new NullPointerException("IHostHandler is null");
        }
        int j = b(h);
        if (j <= 0)
        {
            aJ.c("HostClient", "local host size <=0");
            b(b1);
            return;
        }
        if (e >= j)
        {
            aJ.c("HostClient", "next host >= localhost size");
            b(b1);
            return;
        }
        String s = a(h, e);
        if (TextUtils.isEmpty(s))
        {
            aJ.c("HostClient", "next host == null");
            b(b1);
            return;
        } else
        {
            aJ.c("HostClient", (new StringBuilder()).append("next host [").append(s).append("]").toString());
            b1.a(s);
            e = e + 1;
            return;
        }
    }

    public int b(Context context)
    {
        return context.getSharedPreferences("AGOO_HOST", 4).getInt("AGOO_HOST_SIZE", 0);
    }
}
