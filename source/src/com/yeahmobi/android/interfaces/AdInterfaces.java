// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.interfaces;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.yeahmobi.android.adwall.AdWall;
import com.yeahmobi.android.adwall.AdWallAdapter;
import com.yeahmobi.android.adwall.AdWallLoadListener;
import com.yeahmobi.android.adwall.AdWallRes;
import com.yeahmobi.android.banner.AdBannerView;
import com.yeahmobi.android.shuffle.AdShuffle;
import com.yeahmobi.android.shuffle.AdShuffleView;

public class AdInterfaces
{

    public static int mAdNum;
    public static String mAppId;
    public static String mSlotId;

    public AdInterfaces()
    {
    }

    public static AdBannerView getAdBannerView(Context context)
    {
        return com.yeahmobi.android.banner.AdBannerView.AdBannerFactory.create(context, true, 10000L);
    }

    public static AdBannerView getAdBannerView(Context context, long l)
    {
        return com.yeahmobi.android.banner.AdBannerView.AdBannerFactory.create(context, true, l);
    }

    public static AdBannerView getAdBannerView(Context context, boolean flag)
    {
        return com.yeahmobi.android.banner.AdBannerView.AdBannerFactory.create(context, flag, 10000L);
    }

    public static AdBannerView getAdBannerView(Context context, boolean flag, long l)
    {
        if (!isAppInfoExist())
        {
            return null;
        } else
        {
            return com.yeahmobi.android.banner.AdBannerView.AdBannerFactory.create(context, flag, l);
        }
    }

    public static AdShuffle getAdShffle(Context context)
    {
        return com.yeahmobi.android.shuffle.AdShuffle.AdShuffleFactory.create(context, true);
    }

    public static AdShuffleView getAdShuffleView(Context context)
    {
        return com.yeahmobi.android.shuffle.AdShuffleView.AdShuffleViewFactory.create(context, true, 0x7f020007);
    }

    public static AdShuffleView getAdShuffleView(Context context, int i)
    {
        return com.yeahmobi.android.shuffle.AdShuffleView.AdShuffleViewFactory.create(context, true, i);
    }

    public static AdShuffleView getAdShuffleView(Context context, boolean flag)
    {
        return com.yeahmobi.android.shuffle.AdShuffleView.AdShuffleViewFactory.create(context, flag, 0x7f020007);
    }

    public static AdShuffleView getAdShuffleView(Context context, boolean flag, int i)
    {
        return com.yeahmobi.android.shuffle.AdShuffleView.AdShuffleViewFactory.create(context, flag, i);
    }

    public static AdWallAdapter getCustomWall(Context context, AdWallLoadListener adwallloadlistener)
    {
        AdWallAdapter adwalladapter = new AdWallAdapter();
        adwalladapter.load(context, adwallloadlistener);
        return adwalladapter;
    }

    public static boolean isAppInfoExist()
    {
        if (mSlotId == null || mSlotId == "" || mAppId == null || mSlotId == "")
        {
            Log.e("Exception", "slotid and appid must be set");
            return false;
        } else
        {
            return true;
        }
    }

    public static void setAppInfo(String s, String s1)
    {
        mSlotId = s1;
        mAppId = s;
        mAdNum = 15;
    }

    public static void showAdWall(Context context, AdWallRes adwallres)
    {
        showAdWall(context, true, adwallres);
    }

    public static void showAdWall(Context context, boolean flag, AdWallRes adwallres)
    {
        if (!isAppInfoExist())
        {
            return;
        } else
        {
            Intent intent = new Intent(context, com/yeahmobi/android/adwall/AdWall);
            Bundle bundle = new Bundle();
            bundle.putParcelable("res", adwallres);
            bundle.putBoolean("preload", flag);
            intent.putExtras(bundle);
            context.startActivity(intent);
            return;
        }
    }
}
