// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.os.Bundle;

// Referenced classes of package com.umeng.update.net:
//            a

static class c
{

    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f[];
    public boolean g;
    public boolean h;
    public boolean i;

    public static c a(Bundle bundle)
    {
        c c1 = new <init>(bundle.getString("mComponentName"), bundle.getString("mTitle"), bundle.getString("mUrl"));
        c1.d = bundle.getString("mMd5");
        c1.e = bundle.getString("mTargetMd5");
        c1.f = bundle.getStringArray("reporturls");
        c1.g = bundle.getBoolean("rich_notification");
        c1.h = bundle.getBoolean("mSilent");
        c1.i = bundle.getBoolean("mWifiOnly");
        return c1;
    }

    public Bundle a()
    {
        Bundle bundle = new Bundle();
        bundle.putString("mComponentName", a);
        bundle.putString("mTitle", b);
        bundle.putString("mUrl", c);
        bundle.putString("mMd5", d);
        bundle.putString("mTargetMd5", e);
        bundle.putStringArray("reporturls", f);
        bundle.putBoolean("rich_notification", g);
        bundle.putBoolean("mSilent", h);
        bundle.putBoolean("mWifiOnly", i);
        return bundle;
    }

    public (String s, String s1, String s2)
    {
        f = null;
        g = false;
        h = false;
        i = false;
        a = s;
        b = s1;
        c = s2;
    }
}
