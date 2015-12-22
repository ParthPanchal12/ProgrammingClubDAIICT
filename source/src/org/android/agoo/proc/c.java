// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.proc;

import com.umeng.message.proguard.bj;
import com.umeng.message.proguard.bl;
import com.umeng.message.proguard.bn;

// Referenced classes of package org.android.agoo.proc:
//            d

public class c
{

    private static final String a = "x86";
    private static final String b = "armeabi";
    private static final String c = "armeabi_v7a";
    private static final String d = "armeabi-v7a";

    public c()
    {
    }

    static byte[] a(String s, String s1)
    {
        if (!s.equals(d.a)) goto _L2; else goto _L1
_L1:
        if (s1 != null && !"".equals(s1) && !"x86".equals(s1)) goto _L4; else goto _L3
_L3:
        return null;
_L4:
        if ("armeabi_v7a".equals(s1) || "armeabi-v7a".equals(s1))
        {
            return bj.a();
        }
        if ("armeabi".equals(s1))
        {
            return bj.a();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!s.equals("android"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s1 != null && !"".equals(s1) && !"x86".equals(s1))
        {
            if ("armeabi_v7a".equals(s1) || "armeabi-v7a".equals(s1))
            {
                return bn.a();
            }
            if ("armeabi".equals(s1))
            {
                return bn.a();
            }
        }
        continue; /* Loop/switch isn't completed */
        if (!s.equals("libcockroach.so") || s1 == null || "".equals(s1) || "x86".equals(s1)) goto _L3; else goto _L5
_L5:
        if ("armeabi_v7a".equals(s1) || "armeabi-v7a".equals(s1))
        {
            return bl.a();
        }
        if ("armeabi".equals(s1))
        {
            return bl.a();
        }
        if (true) goto _L3; else goto _L6
_L6:
    }
}
