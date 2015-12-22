// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class a
    implements Runnable
{

    final IMWebView a;

    public void run()
    {
        a.b.set(true);
        a.removeAllViews();
        ViewGroup viewgroup = (ViewGroup)a.getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(a);
        }
        if (android.os.N.SDK_INT >= 11)
        {
            a.removeJavascriptInterface("utilityController");
            a.removeJavascriptInterface("displayController");
            a.removeJavascriptInterface("imaiController");
        }
        a.a();
        IMWebView.p(a);
    }

    olean(IMWebView imwebview)
    {
        a = imwebview;
        super();
    }
}
