// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.swinginadapters.prepared;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.haarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

public class ScaleInAnimationAdapter extends AnimationAdapter
{

    private static final float DEFAULTSCALEFROM = 0.8F;
    private long mAnimationDelayMillis;
    private long mAnimationDurationMillis;
    private float mScaleFrom;

    public ScaleInAnimationAdapter(BaseAdapter baseadapter)
    {
        this(baseadapter, 0.8F);
    }

    public ScaleInAnimationAdapter(BaseAdapter baseadapter, float f)
    {
        this(baseadapter, f, 100L, 300L);
    }

    public ScaleInAnimationAdapter(BaseAdapter baseadapter, float f, long l, long l1)
    {
        super(baseadapter);
        mScaleFrom = f;
        mAnimationDelayMillis = l;
        mAnimationDurationMillis = l1;
    }

    protected long getAnimationDelayMillis()
    {
        return mAnimationDelayMillis;
    }

    protected long getAnimationDurationMillis()
    {
        return mAnimationDurationMillis;
    }

    public Animator[] getAnimators(ViewGroup viewgroup, View view)
    {
        return (new ObjectAnimator[] {
            ObjectAnimator.ofFloat(view, "scaleX", new float[] {
                mScaleFrom, 1.0F
            }), ObjectAnimator.ofFloat(view, "scaleY", new float[] {
                mScaleFrom, 1.0F
            })
        });
    }
}
