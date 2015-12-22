// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.anim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimationVert extends Animation
{

    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final boolean f;
    private Camera g;

    public Rotate3dAnimationVert(float f1, float f2, float f3, float f4, float f5, boolean flag)
    {
        a = f1;
        b = f2;
        c = f3;
        d = f4;
        e = f5;
        f = flag;
    }

    protected void applyTransformation(float f1, Transformation transformation)
    {
        float f2 = a;
        float f3 = b;
        float f4 = c;
        float f5 = d;
        Camera camera = g;
        transformation = transformation.getMatrix();
        camera.save();
        if (f)
        {
            camera.translate(0.0F, 0.0F, e * f1);
        } else
        {
            camera.translate(0.0F, 0.0F, e * (1.0F - f1));
        }
        camera.rotateY(f2 + (f3 - f2) * f1);
        camera.getMatrix(transformation);
        camera.restore();
        transformation.preTranslate(-f4, -f5);
        transformation.postTranslate(f4, f5);
    }

    public void initialize(int i, int j, int k, int l)
    {
        super.initialize(i, j, k, l);
        g = new Camera();
    }
}
