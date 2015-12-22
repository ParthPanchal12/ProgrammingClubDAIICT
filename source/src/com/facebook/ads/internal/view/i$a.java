// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.facebook.ads.internal.view:
//            i

private class b
    implements android.view.animation.ation.AnimationListener
{

    final i a;
    private final View b;
    private boolean c;
    private Animation d;
    private Animation e;

    private void a(Animation animation)
    {
        if (animation == d)
        {
            b.startAnimation(e);
        } else
        if (animation == e)
        {
            b.startAnimation(d);
            return;
        }
    }

    static void a(d d1, Animation animation)
    {
        d1.a(animation);
    }

    public a a(boolean flag)
    {
        c = flag;
        return this;
    }

    public void a()
    {
        d = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, 0 - i.a(a));
        d.setDuration(i.b(a));
        d.setStartOffset(i.c(a));
        d.setFillAfter(true);
        d.setAnimationListener(this);
        e = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, i.a(a), 0, 0.0F);
        e.setDuration(i.b(a));
        e.setStartOffset(i.c(a));
        e.setFillAfter(true);
        e.setAnimationListener(this);
        View view = b;
        Animation animation;
        if (c)
        {
            animation = e;
        } else
        {
            animation = d;
        }
        view.startAnimation(animation);
    }

    public void onAnimationEnd(Animation animation)
    {
        if (!i.d(a))
        {
            a(animation);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        if (i.d(a))
        {
            (new Handler()).postDelayed(new Runnable(animation) {

                final Animation a;
                final i.a b;

                public void run()
                {
                    i.a.a(b, a);
                }

            
            {
                b = i.a.this;
                a = animation;
                super();
            }
            }, i.c(a));
        }
    }

    public _cls1.a(i j, View view)
    {
        a = j;
        super();
        c = false;
        b = view;
    }
}
