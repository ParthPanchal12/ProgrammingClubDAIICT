// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.e;
import com.facebook.ads.internal.view.f;

public class a extends LinearLayout
{

    private f a;
    private int b;

    public a(Context context, NativeAd nativead, NativeAdViewAttributes nativeadviewattributes)
    {
        super(context);
        setOrientation(1);
        setVerticalGravity(16);
        a = new f(getContext(), 2);
        a.setMinTextSize(nativeadviewattributes.getTitleTextSize() - 2);
        a.setText(nativead.getAdTitle());
        e.a(a, nativeadviewattributes);
        a.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        addView(a);
        b = Math.min(nativead.getAdTitle().length(), 21);
        addView(e.a(context, nativead, nativeadviewattributes));
    }

    public int getMinVisibleTitleCharacters()
    {
        return b;
    }

    public TextView getTitleTextView()
    {
        return a;
    }
}
