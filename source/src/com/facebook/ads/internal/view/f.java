// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.content.Context;
import android.widget.TextView;

public class f extends TextView
{

    private int a;
    private float b;
    private float c;

    public f(Context context, int i)
    {
        super(context);
        c = 8F;
        setMaxLines(i);
        setEllipsize(android.text.TextUtils.TruncateAt.END);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.setMaxLines(a + 1);
        super.setTextSize(b);
        int i1 = k - i;
        int j1 = l - j;
        measure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j1, 0));
        if (getMeasuredHeight() > j1)
        {
            float f1 = b;
label0:
            do
            {
                float f2;
                do
                {
                    if (f1 <= c)
                    {
                        break label0;
                    }
                    f2 = f1 - 0.5F;
                    super.setTextSize(f2);
                    measure(android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000), 0);
                    f1 = f2;
                } while (getMeasuredHeight() > j1);
                f1 = f2;
            } while (getLineCount() > a);
        }
        super.setMaxLines(a);
        setMeasuredDimension(i1, j1);
        super.onLayout(flag, i, j, k, l);
    }

    public void setMaxLines(int i)
    {
        a = i;
        super.setMaxLines(i);
    }

    public void setMinTextSize(float f1)
    {
        c = f1;
    }

    public void setTextSize(float f1)
    {
        b = f1;
        super.setTextSize(f1);
    }
}
