// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.a;
import com.facebook.ads.internal.adapters.e;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.h;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.view.b;

// Referenced classes of package com.facebook.ads:
//            Ad, AdSize, AdListener, ImpressionListener

public class AdView extends RelativeLayout
    implements Ad
{

    private static final c a;
    private final DisplayMetrics b;
    private final AdSize c;
    private final String d;
    private h e;
    private volatile boolean f;
    private AdListener g;
    private ImpressionListener h;
    private View i;
    private View j;
    private boolean k;
    private e l;

    public AdView(Context context, String s, AdSize adsize)
    {
        super(context);
        k = false;
        if (adsize == null || adsize == AdSize.INTERSTITIAL)
        {
            throw new IllegalArgumentException("adSize");
        } else
        {
            b = getContext().getResources().getDisplayMetrics();
            c = adsize;
            d = s;
            s = com.facebook.ads.internal.util.g.a(adsize);
            e = new h(context, d, s, adsize, a, 1);
            e.a(new a() {

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
                    com.facebook.ads.AdView.a(a, new e(a.getContext(), view, com.facebook.ads.AdView.b(a).b().e(), new com.facebook.ads.internal.adapters.e.a(this) {

                        final _cls1 a;

                        public void a()
                        {
                            com.facebook.ads.AdView.b(a.a).a();
                        }

            
            {
                a = _pcls1;
                super();
            }
                    }));
                    com.facebook.ads.AdView.c(a).a();
                    return;
_L2:
                    com.facebook.ads.AdView.a(a, true);
                    com.facebook.ads.AdView.b(a, view);
                    a.removeAllViews();
                    a.addView(com.facebook.ads.AdView.h(a));
                    if (com.facebook.ads.AdView.h(a) instanceof b)
                    {
                        com.facebook.ads.internal.util.g.a(AdView.i(a), com.facebook.ads.AdView.h(a), com.facebook.ads.AdView.e(a));
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
                a = AdView.this;
                super();
            }
            });
            return;
        }
    }

    static View a(AdView adview, View view)
    {
        adview.j = view;
        return view;
    }

    static AdListener a(AdView adview)
    {
        return adview.g;
    }

    static e a(AdView adview, e e1)
    {
        adview.l = e1;
        return e1;
    }

    private void a()
    {
        Animation animation = new Animation() {

            final AdView a;
            private boolean b;
            private boolean c;

            protected void applyTransformation(float f1, Transformation transformation)
            {
                double d1 = 3.1415926535897931D * (double)f1;
                float f3 = (float)((180D * d1) / 3.1415926535897931D);
                float f2 = f3;
                if (f1 >= 0.5F)
                {
                    f1 = f3 - 180F;
                    f2 = f1;
                    if (!b)
                    {
                        b = true;
                        AdView.f(a).setVisibility(0);
                        com.facebook.ads.AdView.h(a).setVisibility(4);
                        View view = com.facebook.ads.AdView.h(a);
                        com.facebook.ads.AdView.b(a, AdView.f(a));
                        com.facebook.ads.AdView.a(a, view);
                        f2 = f1;
                    }
                }
                f1 = f2;
                if (c)
                {
                    f1 = -f2;
                }
                Camera camera = new Camera();
                transformation = transformation.getMatrix();
                camera.save();
                camera.translate(0.0F, 0.0F, (float)(Math.sin(d1) * 150D));
                camera.rotateY(f1);
                camera.getMatrix(transformation);
                camera.restore();
                int i1 = a.getWidth() / 2;
                int j1 = a.getHeight() / 2;
                transformation.preTranslate(-i1, -j1);
                transformation.postTranslate(i1, j1);
            }

            
            {
                a = AdView.this;
                super();
                b = false;
                c = false;
            }
        };
        animation.setDuration(300L);
        animation.setFillAfter(true);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final AdView a;

            public void onAnimationEnd(Animation animation1)
            {
                a.removeView(AdView.f(a));
                com.facebook.ads.AdView.a(a, null);
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                a = AdView.this;
                super();
            }
        });
        startAnimation(animation);
    }

    static boolean a(AdView adview, boolean flag)
    {
        adview.k = flag;
        return flag;
    }

    static View b(AdView adview, View view)
    {
        adview.i = view;
        return view;
    }

    static h b(AdView adview)
    {
        return adview.e;
    }

    static e c(AdView adview)
    {
        return adview.l;
    }

    static boolean d(AdView adview)
    {
        return adview.k;
    }

    static AdSize e(AdView adview)
    {
        return adview.c;
    }

    static View f(AdView adview)
    {
        return adview.j;
    }

    static void g(AdView adview)
    {
        adview.a();
    }

    static View h(AdView adview)
    {
        return adview.i;
    }

    static DisplayMetrics i(AdView adview)
    {
        return adview.b;
    }

    static ImpressionListener j(AdView adview)
    {
        return adview.h;
    }

    public void destroy()
    {
        if (l != null)
        {
            l.b();
        }
        if (e != null)
        {
            e.e();
            e = null;
        }
        removeAllViews();
        i = null;
    }

    public void disableAutoRefresh()
    {
        if (e != null)
        {
            e.i();
        }
    }

    public void loadAd()
    {
        if (!f)
        {
            e.c();
            f = true;
        } else
        if (e != null)
        {
            e.h();
            return;
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (i != null)
        {
            com.facebook.ads.internal.util.g.a(b, i, c);
        }
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
        if (e != null)
        {
            if (i1 == 0)
            {
                if (l != null)
                {
                    l.a();
                }
                e.g();
                return;
            }
            if (i1 == 8)
            {
                if (l != null)
                {
                    l.b();
                }
                e.f();
                return;
            }
        }
    }

    public void setAdListener(AdListener adlistener)
    {
        g = adlistener;
    }

    public void setImpressionListener(ImpressionListener impressionlistener)
    {
        h = impressionlistener;
    }

    static 
    {
        a = c.a;
    }
}
