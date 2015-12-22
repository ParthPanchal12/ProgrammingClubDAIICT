// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.imai;

import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.monetization.internal.imai:
//            IMAICore

static final class b
    implements Runnable
{

    final IMWebView a;
    final String b;

    public void run()
    {
        a.injectJavaScript(b);
    }

    (IMWebView imwebview, String s)
    {
        a = imwebview;
        b = s;
        super();
    }
}
