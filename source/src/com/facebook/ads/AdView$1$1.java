// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.view.View;
import com.facebook.ads.internal.a;
import com.facebook.ads.internal.adapters.e;
import com.facebook.ads.internal.dto.c;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.view.b;

// Referenced classes of package com.facebook.ads:
//            AdView, AdSize, AdListener, ImpressionListener

class a
    implements com.facebook.ads.internal.adapters.
{

    final a a;

    public void a()
    {
        com.facebook.ads.AdView.b(a.a).a();
    }

    <init>(<init> <init>1)
    {
        a = <init>1;
        super();
    }

    // Unreferenced inner class com/facebook/ads/AdView$1

/* anonymous class */
    class AdView._cls1 extends a
    {

        final AdView a;

        public void a()
        {
            if (com.facebook.ads.AdView.b(a) != null)
            {
                com.facebook.ads.AdView.b(a).d();
            }
        }

        public void a(View view)
        {
            if (view == null)
            {
                throw new IllegalStateException("Cannot present null view");
            }
            if (com.facebook.ads.AdView.c(a) != null)
            {
                com.facebook.ads.AdView.c(a).b();
            }
            if (!AdView.d(a) || com.facebook.ads.AdView.e(a) != AdSize.RECTANGLE_HEIGHT_250) goto _L2; else goto _L1
_L1:
            com.facebook.ads.AdView.a(a, view);
            AdView.f(a).setVisibility(4);
            a.addView(AdView.f(a));
            com.facebook.ads.AdView.g(a);
_L4:
            if (com.facebook.ads.AdView.a(a) != null)
            {
                com.facebook.ads.AdView.a(a).onAdLoaded(a);
            }
            com.facebook.ads.AdView.a(a, new e(a.getContext(), view, com.facebook.ads.AdView.b(a).b().e(), new AdView._cls1._cls1(this)));
            com.facebook.ads.AdView.c(a).a();
            return;
_L2:
            com.facebook.ads.AdView.a(a, true);
            com.facebook.ads.AdView.b(a, view);
            a.removeAllViews();
            a.addView(com.facebook.ads.AdView.h(a));
            if (com.facebook.ads.AdView.h(a) instanceof b)
            {
                g.a(AdView.i(a), com.facebook.ads.AdView.h(a), com.facebook.ads.AdView.e(a));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void a(com.facebook.ads.internal.b b1)
        {
            if (com.facebook.ads.AdView.a(a) != null)
            {
                com.facebook.ads.AdView.a(a).onError(a, b1.b());
            }
        }

        public void b()
        {
            if (com.facebook.ads.AdView.a(a) != null)
            {
                com.facebook.ads.AdView.a(a).onAdClicked(a);
            }
        }

        public void c()
        {
            if (AdView.j(a) != null)
            {
                AdView.j(a).onLoggingImpression(a);
            }
            if ((com.facebook.ads.AdView.a(a) instanceof ImpressionListener) && com.facebook.ads.AdView.a(a) != AdView.j(a))
            {
                ((ImpressionListener)com.facebook.ads.AdView.a(a)).onLoggingImpression(a);
            }
        }

            
            {
                a = adview;
                super();
            }
    }

}
