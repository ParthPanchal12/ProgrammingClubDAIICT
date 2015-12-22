// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.util.k;
import com.facebook.ads.internal.util.l;
import java.util.Arrays;

// Referenced classes of package com.facebook.ads.internal.view:
//            h, e, d, i

public class com.facebook.ads.internal.view.a extends h
    implements l
{
    public static interface a
    {

        public abstract void a();
    }


    private DisplayMetrics a;
    private NativeAd b;
    private AdChoicesView c;
    private i d;
    private a e;
    private NativeAdViewAttributes f;
    private TextView g;
    private LinearLayout h;
    private View i;

    public com.facebook.ads.internal.view.a(Context context, NativeAd nativead, NativeAdViewAttributes nativeadviewattributes, a a1)
    {
        super(context);
        a = context.getResources().getDisplayMetrics();
        setMinWidth(Math.round(300F * a.density));
        setMaxWidth(Math.round(360F * a.density));
        f = nativeadviewattributes;
        b = nativead;
        e = a1;
        addView(c());
        addView(d());
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, Math.round(250F * a.density)));
    }

    private View a(View view)
    {
        TextView textview = new TextView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(3, view.getId());
        layoutparams.setMargins(Math.round(5F * a.density), Math.round(a.density * 10F), Math.round(0.0F), Math.round(a.density * 10F));
        textview.setLayoutParams(layoutparams);
        textview.setText(b.getAdBody());
        com.facebook.ads.internal.view.e.b(textview, f);
        textview.setEllipsize(android.text.TextUtils.TruncateAt.END);
        textview.setMaxLines(3);
        textview.setGravity(16);
        return textview;
    }

    private ViewGroup c()
    {
        RelativeLayout relativelayout = new RelativeLayout(getContext());
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, Math.round(a.density * 190F));
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
        relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.setBackgroundColor(f.getBackgroundColor());
        obj = new d(getContext());
        relativelayout.addView(((View) (obj)));
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, (int)(a.density * 190F));
        layoutparams.addRule(13, -1);
        ((d) (obj)).setLayoutParams(layoutparams);
        (new k(((d) (obj)))).a(this).execute(new String[] {
            b.getAdCoverImage().getUrl()
        });
        c = new AdChoicesView(getContext(), b);
        obj = (android.widget.RelativeLayout.LayoutParams)c.getLayoutParams();
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        obj = new GradientDrawable();
        ((GradientDrawable) (obj)).setColor(0xb3000000);
        ((GradientDrawable) (obj)).setCornerRadii(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, (float)Math.round(a.density * 8F), (float)Math.round(a.density * 8F)
        });
        setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        relativelayout.addView(c);
        return relativelayout;
    }

    private View d()
    {
        RelativeLayout relativelayout = new RelativeLayout(getContext());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, Math.round(60F * a.density));
        layoutparams.addRule(12);
        relativelayout.setLayoutParams(layoutparams);
        relativelayout.addView(e());
        return relativelayout;
    }

    private View e()
    {
        h = new LinearLayout(getContext());
        h.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        h.setBackgroundColor(f.getBackgroundColor());
        h.setOrientation(0);
        i = f();
        h.addView(i);
        h.addView(g());
        View view = j();
        h.addView(view);
        b.unregisterView();
        b.registerViewForInteraction(this, Arrays.asList(new View[] {
            i, view
        }));
        return h;
    }

    private View f()
    {
        ImageView imageview = new ImageView(getContext());
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(Math.round(a.density * 50F), Math.round(a.density * 50F));
        layoutparams.setMargins(Math.round(a.density * 5F), Math.round(a.density * 5F), Math.round(a.density * 5F), Math.round(a.density * 5F));
        imageview.setLayoutParams(layoutparams);
        NativeAd.downloadAndDisplayImage(b.getAdIcon(), imageview);
        return imageview;
    }

    private View g()
    {
        RelativeLayout relativelayout = new RelativeLayout(getContext());
        Object obj = new android.widget.LinearLayout.LayoutParams(0, -1);
        obj.weight = 1.0F;
        relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = h();
        relativelayout.addView(((View) (obj)));
        View view = a(((View) (obj)));
        relativelayout.addView(view);
        d = (new i(((View) (obj)), view)).a(Math.round(60F * a.density)).a();
        return relativelayout;
    }

    private View h()
    {
        LinearLayout linearlayout = new LinearLayout(getContext());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(10);
        layoutparams.setMargins(Math.round(5F * a.density), Math.round(a.density * 10F), Math.round(0.0F), Math.round(a.density * 10F));
        linearlayout.setLayoutParams(layoutparams);
        linearlayout.setOrientation(1);
        linearlayout.addView(i());
        linearlayout.addView(com.facebook.ads.internal.view.e.a(getContext(), b, f));
        return linearlayout;
    }

    private View i()
    {
        g = new TextView(getContext());
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -1, 1.0F);
        g.setLayoutParams(layoutparams);
        g.setText(b.getAdTitle());
        com.facebook.ads.internal.view.e.a(g, f);
        g.setEllipsize(android.text.TextUtils.TruncateAt.END);
        g.setSingleLine(true);
        return g;
    }

    private View j()
    {
        TextView textview = new TextView(getContext(), null, 0x1010097);
        textview.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
        int i1 = Math.round(9F * a.density);
        int j1 = Math.round(6F * a.density);
        textview.setPadding(i1, j1, i1, j1);
        textview.setText(b.getAdCallToAction().toUpperCase());
        textview.setTextColor(f.getButtonTextColor());
        textview.setTextSize(14F);
        textview.setIncludeFontPadding(false);
        textview.setTypeface(f.getTypeface(), 1);
        textview.setGravity(17);
        Object obj = new GradientDrawable();
        ((GradientDrawable) (obj)).setColor(f.getButtonColor());
        ((GradientDrawable) (obj)).setCornerRadius(3F * a.density);
        ((GradientDrawable) (obj)).setStroke(1, f.getButtonBorderColor());
        textview.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        obj = new RelativeLayout(getContext(), null);
        ((RelativeLayout) (obj)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        ((RelativeLayout) (obj)).setPadding(Math.round(a.density * 10F), 0, Math.round(a.density * 10F), 0);
        ((RelativeLayout) (obj)).addView(textview);
        ((RelativeLayout) (obj)).setGravity(17);
        return ((View) (obj));
    }

    public void a()
    {
        if (e != null)
        {
            e.a();
        }
    }

    public void b()
    {
        if (b != null)
        {
            b.destroy();
            b = null;
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        if (g != null && b != null)
        {
            android.text.TextPaint textpaint = g.getPaint();
            String s2 = b.getAdTitle();
            String s1 = s2.substring(0, Math.min(20, s2.length()));
            String s = s1;
            if (s2.length() > 20)
            {
                s = (new StringBuilder()).append(s1).append("\u2026").toString();
            }
            if (textpaint.measureText(s) >= (float)getMeasuredWidth() - (float)175 * a.density)
            {
                h.removeView(i);
                super.onMeasure(i1, j1);
            }
        }
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
        if (i1 == 0 && d != null)
        {
            d.a();
        }
    }
}
