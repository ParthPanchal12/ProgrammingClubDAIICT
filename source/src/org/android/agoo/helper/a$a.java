// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.helper;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.aU;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.bd;
import com.umeng.message.proguard.bp;
import org.android.agoo.client.AgooSettings;
import org.apache.http.HttpHost;

// Referenced classes of package org.android.agoo.helper:
//            a

class b
    implements Runnable
{

    String a;
    J.d b;
    Context c;
    final a d;

    public void run()
    {
        Object obj;
        org.android.agoo.client.Settings.Mode mode;
        obj = null;
        mode = AgooSettings.getMode(c);
        Object obj1;
        Object obj2;
        Object obj3;
        int i;
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
        i = mode.getPushApollPort();
        if (org.android.agoo.helper.a.a(d) == null)
        {
            org.android.agoo.helper.a.a(d, new bd());
        }
        if (AgooSettings.isAgooTestMode(c)) goto _L2; else goto _L1
_L1:
        obj1 = org.android.agoo.helper.a.a(d).get(c, ((String) (obj2)), ((bb) (obj1)));
        obj = obj1;
_L4:
        org.android.agoo.helper.a.a(d, ((com.umeng.message.proguard.) (obj)), b, mode);
        return;
_L2:
        aJ.c("HostClient", (new StringBuilder()).append("test host ip [ ").append(((String) (obj3))).append(" ]").toString());
        obj3 = new HttpHost(((String) (obj3)), i);
        obj1 = org.android.agoo.helper.a.a(d).get(c, ((HttpHost) (obj3)), ((String) (obj2)), ((bb) (obj1)));
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        Throwable throwable;
        throwable;
        aJ.d("HostClient", "host Throwable", throwable);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public J(a a1, Context context, String s, J j)
    {
        d = a1;
        super();
        c = context;
        a = s;
        b = j;
    }
}
