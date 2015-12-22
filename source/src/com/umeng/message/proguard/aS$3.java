// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.text.TextUtils;
import org.android.agoo.net.mtop.MtopHttpChunked;

// Referenced classes of package com.umeng.message.proguard:
//            aS, aJ, aN

class a
    implements org.android.agoo.helper.._cls3
{

    final aS a;

    public void a(int i, String s)
    {
        aJ.c("MessagePush", (new StringBuilder()).append("connect_host[").append(s).append("]---->[").append(i).append("]").toString());
        aN.a(a.a, i, s);
        if (i == 408 || i == 307)
        {
            aS.d(a, aS.j(a), "host_error_connect");
            return;
        } else
        {
            aS.d(a, aS.k(a), "host_error_connect");
            return;
        }
    }

    public void a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            s = String.format("http://%s/rest/api3.do", new Object[] {
                s
            });
            aS.a(a).setBaseUrl(s);
            aS.i(a);
        }
    }

    tpChunked(aS as)
    {
        a = as;
        super();
    }
}
