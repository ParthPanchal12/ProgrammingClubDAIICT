// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;


// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class b
    implements Runnable
{

    final String a;
    final String b;
    final IMWebView c;

    public void run()
    {
        if (a != null)
        {
            c.injectJavaScript((new StringBuilder()).append("window.imraid.broadcastEvent('").append(b).append("','").append(a).append("');").toString());
            return;
        } else
        {
            c.injectJavaScript((new StringBuilder()).append("window.imraid.broadcastEvent('").append(b).append("');").toString());
            return;
        }
    }

    (IMWebView imwebview, String s, String s1)
    {
        c = imwebview;
        a = s;
        b = s1;
        super();
    }
}
