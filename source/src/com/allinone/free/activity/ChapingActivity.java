// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class ChapingActivity extends Activity
    implements InterstitialAdListener
{

    private InterstitialAd interstitialAd;

    public ChapingActivity()
    {
    }

    private void loadInterstitialAd()
    {
        interstitialAd = new InterstitialAd(this, "340186902832477_401798000004700");
        interstitialAd.setAdListener(this);
        interstitialAd.loadAd();
    }

    public void onAdClicked(Ad ad)
    {
        Log.e("www", "onAdClicked");
    }

    public void onAdLoaded(Ad ad)
    {
        interstitialAd.show();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002f);
        ((LinearLayout)findViewById(0x7f0600d7)).setOnClickListener(new android.view.View.OnClickListener() {

            final ChapingActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = ChapingActivity.this;
                super();
            }
        });
        loadInterstitialAd();
    }

    public void onError(Ad ad, AdError aderror)
    {
        finish();
    }

    public void onInterstitialDismissed(Ad ad)
    {
        Log.e("www", "onInterstitialDismissed");
        finish();
    }

    public void onInterstitialDisplayed(Ad ad)
    {
        Log.e("www", "onInterstitialDisplayed");
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return super.onKeyDown(i, keyevent);
    }
}
