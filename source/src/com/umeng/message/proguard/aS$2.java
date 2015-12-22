// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Map;

// Referenced classes of package com.umeng.message.proguard:
//            bh, aS, aJ, aN

class b
    implements bh
{

    final aS a;
    private long b;

    public void a()
    {
        aJ.c("MessagePush", (new StringBuilder()).append("connect[").append(aS.d(a)).append("]--->[onClose()]").toString());
        aN.a(a.a, b, "onClose");
        aS.f(a);
    }

    public void a(int i, Map map)
    {
        aS.a(a, i);
        aJ.c("MessagePush", (new StringBuilder()).append("connect[").append(aS.d(a)).append("]--->[onOpen()]").toString());
        aS.e(a);
        aS.a(a, System.currentTimeMillis());
        b = System.currentTimeMillis();
        aS.b(a, b, (String)map.get("Hb"));
        aS.a(a, (String)map.get("X-AT"));
        aS.b(a, (String)map.get("X-COMMAND"));
        aS.c(a, b, (String)map.get("Dye"));
    }

    public void a(int i, Map map, Throwable throwable)
    {
        aS.a(a, -1L);
        aJ.c("MessagePush", (new StringBuilder()).append("connect[").append(aS.d(a)).append("]--->httpStatusCode[").append(i).append("]:Throwable[").append(throwable.getMessage()).append("]").toString());
        aN.a(a.a, b, "onError", (new StringBuilder()).append("").append(i).toString());
        aS.f(a);
        aS.a(a, i, map);
    }

    public void a(String s)
    {
        if (!aS.g(a))
        {
            return;
        } else
        {
            aS.a(a, System.currentTimeMillis());
            aJ.c("MessagePush", (new StringBuilder()).append("connect[").append(aS.d(a)).append("]--->[").append(s).append("][lastHeartTime:").append(aS.h(a)).append("]").toString());
            a.f(s);
            return;
        }
    }

    public void a(char ac[])
    {
        if (!aS.g(a))
        {
            return;
        } else
        {
            aS.a(a, ac, b);
            return;
        }
    }

    (aS as)
    {
        a = as;
        super();
        b = -1L;
    }
}
