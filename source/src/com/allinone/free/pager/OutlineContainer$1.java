// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.pager;

import android.view.animation.Interpolator;

// Referenced classes of package com.allinone.free.pager:
//            OutlineContainer

class this._cls0
    implements Interpolator
{

    final OutlineContainer this$0;

    public float getInterpolation(float f)
    {
        f--;
        return f * f * f + 1.0F;
    }

    ()
    {
        this$0 = OutlineContainer.this;
        super();
    }
}
