// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import android.view.View;
import com.google.ads.AdSize;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.AdWebView;
import com.google.ads.n;

public class IcsUtil
{
    public static class IcsAdWebView extends AdWebView
    {

        public boolean canScrollHorizontally(int i)
        {
            if (a.e.a() != null)
            {
                return !((ActivationOverlay)a.e.a()).b();
            } else
            {
                return super.canScrollHorizontally(i);
            }
        }

        public boolean canScrollVertically(int i)
        {
            if (a.e.a() != null)
            {
                return !((ActivationOverlay)a.e.a()).b();
            } else
            {
                return super.canScrollVertically(i);
            }
        }

        public IcsAdWebView(n n1, AdSize adsize)
        {
            super(n1, adsize);
        }
    }

    public static class a extends g.a
    {

        public void onShowCustomView(View view, int i, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            customviewcallback.onCustomViewHidden();
        }

        public a(n n)
        {
            super(n);
        }
    }

}
