// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.facebook.ads:
//            AdView

class c extends Animation
{

    final AdView a;
    private boolean b;
    private boolean c;

    protected void applyTransformation(float f, Transformation transformation)
    {
        double d = 3.1415926535897931D * (double)f;
        float f2 = (float)((180D * d) / 3.1415926535897931D);
        float f1 = f2;
        if (f >= 0.5F)
        {
            f = f2 - 180F;
            f1 = f;
            if (!b)
            {
                b = true;
                AdView.f(a).setVisibility(0);
                AdView.h(a).setVisibility(4);
                View view = AdView.h(a);
                AdView.b(a, AdView.f(a));
                AdView.a(a, view);
                f1 = f;
            }
        }
        f = f1;
        if (c)
        {
            f = -f1;
        }
        Camera camera = new Camera();
        transformation = transformation.getMatrix();
        camera.save();
        camera.translate(0.0F, 0.0F, (float)(Math.sin(d) * 150D));
        camera.rotateY(f);
        camera.getMatrix(transformation);
        camera.restore();
        int i = a.getWidth() / 2;
        int j = a.getHeight() / 2;
        transformation.preTranslate(-i, -j);
        transformation.postTranslate(i, j);
    }

    nsformation(AdView adview)
    {
        a = adview;
        super();
        b = false;
        c = false;
    }
}
