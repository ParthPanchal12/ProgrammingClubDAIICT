// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.common.message;

import android.content.Context;
import android.os.Build;
import com.umeng.message.proguard.as;
import org.json.JSONObject;

// Referenced classes of package com.umeng.common.message:
//            DeviceConfig, Log

public class b
{

    public static final String A = "Android";
    public static final String B = "Android";
    private static final String C = com/umeng/common/message/b.getName();
    private final String D;
    private final String E;
    private final String F;
    private final String G;
    private final String H;
    private final String I;
    private final String J;
    private final String K;
    private final String L;
    private final String M;
    private final String N;
    private final String O;
    private final String P;
    private final String Q;
    private final String R;
    private final String S;
    private final String T;
    private final String U;
    private final String V;
    private final String W;
    private final String X;
    private final String Y;
    private final String Z;
    public String a;
    private final String aa;
    private final String ab;
    private final String ac;
    public String b;
    public String c;
    public String d;
    public String e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public int s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public b()
    {
        D = "appkey";
        E = "channel";
        F = "device_id";
        G = "idmd5";
        H = "mc";
        I = "req_time";
        J = "device_model";
        K = "os";
        L = "os_version";
        M = "resolution";
        N = "cpu";
        O = "gpu_vender";
        P = "gpu_renderer";
        Q = "app_version";
        R = "version_code";
        S = "package_name";
        T = "sdk_type";
        U = "sdk_version";
        V = "timezone";
        W = "country";
        X = "language";
        Y = "access";
        Z = "access_subtype";
        aa = "carrier";
        ab = "wrapper_type";
        ac = "wrapper_version";
    }

    public b(String s1, String s2)
    {
        D = "appkey";
        E = "channel";
        F = "device_id";
        G = "idmd5";
        H = "mc";
        I = "req_time";
        J = "device_model";
        K = "os";
        L = "os_version";
        M = "resolution";
        N = "cpu";
        O = "gpu_vender";
        P = "gpu_renderer";
        Q = "app_version";
        R = "version_code";
        S = "package_name";
        T = "sdk_type";
        U = "sdk_version";
        V = "timezone";
        W = "country";
        X = "language";
        Y = "access";
        Z = "access_subtype";
        aa = "carrier";
        ab = "wrapper_type";
        ac = "wrapper_version";
        a = s1;
        b = s2;
    }

    private void c(JSONObject jsonobject)
        throws Exception
    {
        a = jsonobject.getString("appkey");
        c = jsonobject.getString("device_id");
        d = jsonobject.getString("idmd5");
        if (jsonobject.has("mc"))
        {
            e = jsonobject.getString("mc");
        }
        if (jsonobject.has("channel"))
        {
            b = jsonobject.getString("channel");
        }
        if (jsonobject.has("req_time"))
        {
            f = jsonobject.getLong("req_time");
        }
    }

    private void d(JSONObject jsonobject)
        throws Exception
    {
        Object obj = null;
        String s1;
        if (jsonobject.has("device_model"))
        {
            s1 = jsonobject.getString("device_model");
        } else
        {
            s1 = null;
        }
        g = s1;
        if (jsonobject.has("os"))
        {
            s1 = jsonobject.getString("os");
        } else
        {
            s1 = null;
        }
        h = s1;
        if (jsonobject.has("os_version"))
        {
            s1 = jsonobject.getString("os_version");
        } else
        {
            s1 = null;
        }
        i = s1;
        if (jsonobject.has("resolution"))
        {
            s1 = jsonobject.getString("resolution");
        } else
        {
            s1 = null;
        }
        j = s1;
        if (jsonobject.has("cpu"))
        {
            s1 = jsonobject.getString("cpu");
        } else
        {
            s1 = null;
        }
        k = s1;
        if (jsonobject.has("gpu_vender"))
        {
            s1 = jsonobject.getString("gpu_vender");
        } else
        {
            s1 = null;
        }
        l = s1;
        s1 = obj;
        if (jsonobject.has("gpu_renderer"))
        {
            s1 = jsonobject.getString("gpu_renderer");
        }
        m = s1;
    }

    private void e(JSONObject jsonobject)
        throws Exception
    {
        Object obj = null;
        String s1;
        if (jsonobject.has("app_version"))
        {
            s1 = jsonobject.getString("app_version");
        } else
        {
            s1 = null;
        }
        n = s1;
        if (jsonobject.has("version_code"))
        {
            s1 = jsonobject.getString("version_code");
        } else
        {
            s1 = null;
        }
        o = s1;
        s1 = obj;
        if (jsonobject.has("package_name"))
        {
            s1 = jsonobject.getString("package_name");
        }
        p = s1;
    }

    private void f(JSONObject jsonobject)
        throws Exception
    {
        q = jsonobject.getString("sdk_type");
        r = jsonobject.getString("sdk_version");
    }

    private void g(JSONObject jsonobject)
        throws Exception
    {
        Object obj = null;
        String s1;
        int i1;
        if (jsonobject.has("timezone"))
        {
            i1 = jsonobject.getInt("timezone");
        } else
        {
            i1 = 8;
        }
        s = i1;
        if (jsonobject.has("country"))
        {
            s1 = jsonobject.getString("country");
        } else
        {
            s1 = null;
        }
        t = s1;
        s1 = obj;
        if (jsonobject.has("language"))
        {
            s1 = jsonobject.getString("language");
        }
        u = s1;
    }

    private void h(JSONObject jsonobject)
        throws Exception
    {
        Object obj = null;
        String s1;
        if (jsonobject.has("access"))
        {
            s1 = jsonobject.getString("access");
        } else
        {
            s1 = null;
        }
        v = s1;
        if (jsonobject.has("access_subtype"))
        {
            s1 = jsonobject.getString("access_subtype");
        } else
        {
            s1 = null;
        }
        w = s1;
        s1 = obj;
        if (jsonobject.has("carrier"))
        {
            s1 = jsonobject.getString("carrier");
        }
        x = s1;
    }

    private void i(JSONObject jsonobject)
        throws Exception
    {
        Object obj = null;
        String s1;
        if (jsonobject.has("wrapper_type"))
        {
            s1 = jsonobject.getString("wrapper_type");
        } else
        {
            s1 = null;
        }
        y = s1;
        s1 = obj;
        if (jsonobject.has("wrapper_version"))
        {
            s1 = jsonobject.getString("wrapper_version");
        }
        z = s1;
    }

    private void j(JSONObject jsonobject)
        throws Exception
    {
        jsonobject.put("appkey", a);
        if (a != null && 24 == a.length())
        {
            c = as.a(new String[] {
                c, "utf-8", a.substring(0, 16)
            });
        } else
        {
            c = as.a(new String[] {
                c, "utf-8"
            });
        }
        jsonobject.put("device_id", c);
        jsonobject.put("idmd5", d);
        if (b != null)
        {
            jsonobject.put("channel", b);
        }
        if (e != null)
        {
            jsonobject.put("mc", e);
        }
        if (f > 0L)
        {
            jsonobject.put("req_time", f);
        }
    }

    private void k(JSONObject jsonobject)
        throws Exception
    {
        if (g != null)
        {
            jsonobject.put("device_model", g);
        }
        if (h != null)
        {
            jsonobject.put("os", h);
        }
        if (i != null)
        {
            jsonobject.put("os_version", i);
        }
        if (j != null)
        {
            jsonobject.put("resolution", j);
        }
        if (k != null)
        {
            jsonobject.put("cpu", k);
        }
        if (l != null)
        {
            jsonobject.put("gpu_vender", l);
        }
        if (m != null)
        {
            jsonobject.put("gpu_vender", m);
        }
    }

    private void l(JSONObject jsonobject)
        throws Exception
    {
        if (n != null)
        {
            jsonobject.put("app_version", n);
        }
        if (o != null)
        {
            jsonobject.put("version_code", o);
        }
        if (p != null)
        {
            jsonobject.put("package_name", p);
        }
    }

    private void m(JSONObject jsonobject)
        throws Exception
    {
        jsonobject.put("sdk_type", q);
        jsonobject.put("sdk_version", r);
    }

    private void n(JSONObject jsonobject)
        throws Exception
    {
        jsonobject.put("timezone", s);
        if (t != null)
        {
            jsonobject.put("country", t);
        }
        if (u != null)
        {
            jsonobject.put("language", u);
        }
    }

    private void o(JSONObject jsonobject)
        throws Exception
    {
        if (v != null)
        {
            jsonobject.put("access", v);
        }
        if (w != null)
        {
            jsonobject.put("access_subtype", w);
        }
        if (x != null)
        {
            jsonobject.put("carrier", x);
        }
    }

    private void p(JSONObject jsonobject)
        throws Exception
    {
        if (y != null)
        {
            jsonobject.put("wrapper_type", y);
        }
        if (z != null)
        {
            jsonobject.put("wrapper_version", z);
        }
    }

    public void a(Context context)
    {
        g = Build.MODEL;
        h = "Android";
        i = android.os.Build.VERSION.RELEASE;
        j = DeviceConfig.getResolution(context);
        k = DeviceConfig.getCPU();
    }

    public transient void a(Context context, String as1[])
    {
        if (as1 != null && as1.length == 2)
        {
            a = as1[0];
            b = as1[1];
        }
        if (a == null)
        {
            a = DeviceConfig.getAppkey(context);
        }
        if (b == null)
        {
            b = DeviceConfig.getChannel(context);
        }
        c = DeviceConfig.getDeviceId(context);
        d = DeviceConfig.getDeviceIdMD5(context);
        e = DeviceConfig.getMac(context);
    }

    public void a(JSONObject jsonobject)
        throws Exception
    {
        if (jsonobject == null)
        {
            return;
        } else
        {
            c(jsonobject);
            d(jsonobject);
            e(jsonobject);
            f(jsonobject);
            g(jsonobject);
            h(jsonobject);
            i(jsonobject);
            return;
        }
    }

    public boolean a()
    {
        if (a == null)
        {
            Log.b(C, "missing appkey ");
            return false;
        }
        if (c == null || d == null)
        {
            Log.b(C, "missing device id");
            return false;
        } else
        {
            return true;
        }
    }

    public void b(Context context)
    {
        n = DeviceConfig.getAppVersionName(context);
        o = DeviceConfig.getAppVersionCode(context);
        p = DeviceConfig.getPackageName(context);
    }

    public transient void b(Context context, String as1[])
    {
        a(context, as1);
        a(context);
        b(context);
        c(context);
        d(context);
        e(context);
    }

    public void b(JSONObject jsonobject)
        throws Exception
    {
        j(jsonobject);
        k(jsonobject);
        l(jsonobject);
        m(jsonobject);
        n(jsonobject);
        o(jsonobject);
        p(jsonobject);
    }

    public boolean b()
    {
        return a != null && c != null;
    }

    public void c(Context context)
    {
        q = "Android";
        r = "1.7.0";
    }

    public void d(Context context)
    {
        s = DeviceConfig.getTimeZone(context);
        context = DeviceConfig.getLocaleInfo(context);
        t = context[0];
        u = context[1];
    }

    public void e(Context context)
    {
        String as1[] = DeviceConfig.getNetworkAccessMode(context);
        v = as1[0];
        w = as1[1];
        x = DeviceConfig.getOperator(context);
    }

}
