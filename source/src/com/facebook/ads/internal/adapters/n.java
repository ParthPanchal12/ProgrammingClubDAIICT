// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.action.a;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.e;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.o;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            a

public class n
    implements com.facebook.ads.internal.adapters.a
{

    private static final String a = com/facebook/ads/internal/adapters/n.getSimpleName();
    private com.facebook.ads.internal.util.b.a A;
    private final Uri b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final com.facebook.ads.NativeAd.Image h;
    private final com.facebook.ads.NativeAd.Image i;
    private final com.facebook.ads.NativeAd.Rating j;
    private final String k;
    private final String l;
    private final String m;
    private final e n;
    private final String o;
    private final Collection p;
    private final boolean q;
    private final com.facebook.ads.NativeAd.Image r;
    private final String s;
    private final String t;
    private final String u;
    private final String v = UUID.randomUUID().toString();
    private boolean w;
    private boolean x;
    private boolean y;
    private long z;

    private n(Uri uri, String s1, String s2, String s3, String s4, String s5, com.facebook.ads.NativeAd.Image image, 
            com.facebook.ads.NativeAd.Image image1, com.facebook.ads.NativeAd.Rating rating, String s6, String s7, String s8, e e1, String s9, 
            Collection collection, boolean flag, com.facebook.ads.NativeAd.Image image2, String s10, String s11, String s12)
    {
        z = 0L;
        A = null;
        b = uri;
        c = s1;
        d = s2;
        e = s3;
        f = s4;
        g = s5;
        h = image;
        i = image1;
        j = rating;
        k = s6;
        l = s7;
        m = s8;
        n = e1;
        o = s9;
        p = collection;
        q = flag;
        r = image2;
        s = s10;
        t = s11;
        u = s12;
    }

    public static n a(String s1, JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            s1 = null;
        } else
        {
            Uri uri = Uri.parse(jsonobject.optString("fbad_command"));
            String s2 = jsonobject.optString("title");
            String s3 = jsonobject.optString("subtitle");
            String s4 = jsonobject.optString("body");
            String s5 = jsonobject.optString("call_to_action");
            String s6 = jsonobject.optString("social_context");
            com.facebook.ads.NativeAd.Image image1 = com.facebook.ads.NativeAd.Image.fromJSONObject(jsonobject.optJSONObject("icon"));
            com.facebook.ads.NativeAd.Image image2 = com.facebook.ads.NativeAd.Image.fromJSONObject(jsonobject.optJSONObject("image"));
            com.facebook.ads.NativeAd.Rating rating = com.facebook.ads.NativeAd.Rating.fromJSONObject(jsonobject.optJSONObject("star_rating"));
            String s7 = jsonobject.optString("impression_report_url");
            String s8 = jsonobject.optString("click_report_url");
            String s9 = jsonobject.optString("used_report_url");
            boolean flag = jsonobject.optBoolean("manual_imp");
            com.facebook.ads.NativeAd.Image image = null;
            Object obj = jsonobject.optJSONObject("ad_choices_icon");
            if (obj != null)
            {
                image = com.facebook.ads.NativeAd.Image.fromJSONObject(((JSONObject) (obj)));
            }
            obj = jsonobject.optString("ad_choices_link_url");
            String s10 = jsonobject.optString("request_id");
            e e1 = com.facebook.ads.internal.util.e.a(jsonobject.optString("invalidation_behavior"));
            String s11 = jsonobject.optString("invalidation_report_url");
            try
            {
                jsonobject = new JSONArray(jsonobject.optString("detection_strings"));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
                jsonobject = null;
            }
            jsonobject = new n(uri, s2, s3, s4, s5, s6, image1, image2, rating, s7, s8, s9, e1, s11, com.facebook.ads.internal.util.f.a(jsonobject), flag, image, ((String) (obj)), s10, s1);
            s1 = jsonobject;
            if (!jsonobject.r())
            {
                return null;
            }
        }
        return s1;
    }

    private Map b(Map map)
    {
        if (map.containsKey("mil"))
        {
            boolean flag = ((Boolean)map.get("mil")).booleanValue();
            map.remove("mil");
            if (!flag)
            {
                return null;
            }
        }
        return Collections.singletonMap("mil", String.valueOf(true));
    }

    private void q()
    {
        if (!y)
        {
            (new o()).execute(new String[] {
                m
            });
            y = true;
        }
    }

    private boolean r()
    {
        return c != null && c.length() > 0 && f != null && f.length() > 0 && h != null && i != null;
    }

    public e a()
    {
        return n;
    }

    public void a(int i1)
    {
        if (i1 == 0 && z > 0L && A != null)
        {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(z, A, t));
            z = 0L;
            A = null;
        }
    }

    public void a(Context context, Map map)
    {
        if (!x)
        {
            HashMap hashmap = new HashMap();
            if (map != null)
            {
                hashmap.putAll(b(map));
                hashmap.put("touch", com.facebook.ads.internal.util.g.a(map));
            }
            (new o(hashmap)).execute(new String[] {
                l
            });
            x = true;
            com.facebook.ads.internal.util.g.a(context, "Click logged");
        }
        context = com.facebook.ads.internal.action.b.a(context, b);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        z = System.currentTimeMillis();
        A = context.a();
        context.b();
        return;
        context;
        Log.e(a, "Error executing action", context);
        return;
    }

    public void a(Map map)
    {
        if (!w)
        {
            (new o(b(map))).execute(new String[] {
                k
            });
            w = true;
        }
    }

    public String b()
    {
        return o;
    }

    public Collection c()
    {
        return p;
    }

    public com.facebook.ads.NativeAd.Image d()
    {
        return h;
    }

    public com.facebook.ads.NativeAd.Image e()
    {
        return i;
    }

    public String f()
    {
        q();
        return c;
    }

    public String g()
    {
        q();
        return d;
    }

    public String h()
    {
        q();
        return e;
    }

    public String i()
    {
        q();
        return f;
    }

    public String j()
    {
        q();
        return g;
    }

    public com.facebook.ads.NativeAd.Rating k()
    {
        q();
        return j;
    }

    public boolean l()
    {
        return q;
    }

    public String m()
    {
        return v;
    }

    public com.facebook.ads.NativeAd.Image n()
    {
        return r;
    }

    public String o()
    {
        return s;
    }

    public String p()
    {
        return t;
    }

}
