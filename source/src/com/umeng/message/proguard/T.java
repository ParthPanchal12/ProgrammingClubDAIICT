// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.util.Log;

// Referenced classes of package com.umeng.message.proguard:
//            aa, U, V, ad, 
//            af, aF

public class T
{

    private static T a = null;
    private static final String b = com/umeng/message/proguard/T.getName();
    private static final int c = 1;
    private Context d;

    private T(Context context)
    {
        d = context;
    }

    public static T a(Context context)
    {
        com/umeng/message/proguard/T;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new T(context);
        }
        context = a;
        com/umeng/message/proguard/T;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private String b(String s, String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        if (d != null) goto _L2; else goto _L1
_L1:
        Log.e(b, "no context!");
        String s3 = "";
_L4:
        this;
        JVM INSTR monitorexit ;
        return s3;
_L2:
        s3 = "";
        if (aa.a(d))
        {
            s3 = U.a(d).a(s, s1, s2, V.a(d, s, s1));
        }
        V.a(d, s, s3, s1);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public String a(String s, String s1, String s2)
    {
        boolean flag1 = true;
        if (d != null && !ad.a(s) && !ad.a(s1)) goto _L2; else goto _L1
_L1:
        Object obj;
        s2 = b;
        obj = (new StringBuilder()).append("mContext:").append(d).append("; has appName:");
        boolean flag;
        if (!ad.a(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = ((StringBuilder) (obj)).append(flag).append("; has token:");
        if (!ad.a(s1))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Log.e(s2, s.append(flag).toString());
        obj = "";
_L4:
        return ((String) (obj));
_L2:
        String s3;
        s3 = V.a(d, s, s1);
        if (ad.a(s3))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s3;
        if (af.a(V.b(d, s, s1), 1)) goto _L4; else goto _L3
_L3:
        obj = s3;
        if (aa.a(d))
        {
            return b(s, s1, s2);
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void a(String s, String s1, String s2, aF af1)
    {
        boolean flag1 = true;
        if (af1 == null)
        {
            Log.e(b, "callback is null!");
            return;
        }
        if (d == null || ad.a(s) || ad.a(s1))
        {
            s2 = b;
            StringBuilder stringbuilder = (new StringBuilder()).append("mContext:").append(d).append("; callback:").append(af1).append("; has appName:");
            boolean flag;
            if (!ad.a(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s = stringbuilder.append(flag).append("; has token:");
            if (!ad.a(s1))
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            Log.e(s2, s.append(flag).toString());
            af1.a(1002, "");
            return;
        }
        String s3 = V.a(d, s, s1);
        if (!ad.a(s3) && af.a(V.b(d, s, s1), 1))
        {
            af1.a(1001, s3);
            return;
        }
        if (aa.a(d))
        {
            U.a(d).a(s, s1, s2, s3, af1);
            return;
        } else
        {
            af1.a(1003, s3);
            return;
        }
    }

}
