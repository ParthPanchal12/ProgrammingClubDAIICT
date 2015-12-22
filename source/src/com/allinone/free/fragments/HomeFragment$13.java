// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.util.Log;
import android.widget.LinearLayout;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;

// Referenced classes of package com.allinone.free.fragments:
//            HomeFragment

class this._cls0
    implements AdListener
{

    final HomeFragment this$0;

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        HomeFragment.access$27(HomeFragment.this).addView(HomeFragment.access$28(HomeFragment.this));
    }

    public void onError(Ad ad, AdError aderror)
    {
        Log.v("rtrtr", (new StringBuilder()).append(aderror).toString());
    }

    ()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
