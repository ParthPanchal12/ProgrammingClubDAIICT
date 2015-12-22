// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.webkit.WebView;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.s;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            b, l, c

public class m extends b
{

    private final WebView b;
    private l c;
    private boolean d;

    public m(Context context, WebView webview, c c1)
    {
        super(context, c1);
        b = webview;
    }

    private void a(Map map)
    {
        String s1;
        if (c != null)
        {
            if (!s.a(s1 = c.f()))
            {
                (new o(map)).execute(new String[] {
                    s1
                });
                return;
            }
        }
    }

    public void a(l l1)
    {
        c = l1;
    }

    protected void b()
    {
        if (c == null)
        {
            return;
        }
        if (b != null && !s.a(c.g()))
        {
            b.loadUrl((new StringBuilder()).append("javascript:").append(c.g()).toString());
        }
        a(Collections.singletonMap("evt", "native_imp"));
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (d) goto _L2; else goto _L1
_L1:
        l l1 = c;
        if (l1 != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        d = true;
        if (b != null && !s.a(c.e()))
        {
            b.loadUrl((new StringBuilder()).append("javascript:").append(c.e()).toString());
        }
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void d()
    {
        a(Collections.singletonMap("evt", "interstitial_displayed"));
    }
}
