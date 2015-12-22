// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class i
{
    private class a
        implements android.view.animation.Animation.AnimationListener
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

        static void a(a a1, Animation animation)
        {
            a1.a(animation);
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
                (new Handler()).postDelayed(new Runnable(this, animation) {

                    final Animation a;
                    final a b;

                    public void run()
                    {
                        a.a(b, a);
                    }

            
            {
                b = a1;
                a = animation;
                super();
            }
                }, i.c(a));
            }
        }

        public a(View view)
        {
            a = i.this;
            super();
            c = false;
            b = view;
        }
    }


    private int a;
    private int b;
    private int c;
    private final a d;
    private final a e;
    private boolean f;

    public i(View view, View view1)
    {
        a = 200;
        b = 500;
        c = 4000;
        d = new a(view);
        e = (new a(view1)).a(true);
        f = "4.1.2".equals(android.os.Build.VERSION.RELEASE);
    }

    static int a(i j)
    {
        return j.a;
    }

    static int b(i j)
    {
        return j.b;
    }

    static int c(i j)
    {
        return j.c;
    }

    static boolean d(i j)
    {
        return j.f;
    }

    public i a()
    {
        d.a();
        e.a();
        return this;
    }

    public i a(int j)
    {
        a = j * 2;
        return this;
    }
}
