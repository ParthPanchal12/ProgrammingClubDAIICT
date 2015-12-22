// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.shuffle;

import android.content.Context;
import android.util.Log;
import com.yeahmobi.android.common.AdClickHandler;
import com.yeahmobi.android.common.AdManager;
import com.yeahmobi.android.common.AdResponse;
import com.yeahmobi.android.common.OnAdReceiveListener;
import com.yeahmobi.android.common.UrlResolutionTask;
import com.yeahmobi.android.common.util.Utils;
import com.yeahmobi.android.interfaces.AdInterfaces;
import java.util.ArrayList;
import java.util.List;

public class AdShuffle
{
    public static class AdShuffleFactory
    {

        public static AdShuffle create(Context context, boolean flag)
        {
            return new AdShuffle(context, flag);
        }

        public AdShuffleFactory()
        {
        }
    }


    private final boolean PRELOAD;
    private AdManager adManager;
    private int adNum;
    private String appId;
    private int count;
    private boolean firstLaunch;
    private int index;
    private boolean isRequestingAd;
    private ArrayList mAdResponses;
    private Context mContext;
    private String slotId;

    public AdShuffle(Context context)
    {
        isRequestingAd = false;
        firstLaunch = true;
        PRELOAD = true;
        setup(context);
    }

    public AdShuffle(Context context, boolean flag)
    {
        isRequestingAd = false;
        firstLaunch = true;
        PRELOAD = flag;
        setup(context);
    }

    private void setup(Context context)
    {
        slotId = AdInterfaces.mSlotId;
        appId = AdInterfaces.mAppId;
        adNum = AdInterfaces.mAdNum;
        mContext = context;
    }

    public void loadAds()
    {
        this;
        JVM INSTR monitorenter ;
        loadAds(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void loadAds(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (index >= count) goto _L2; else goto _L1
_L1:
        AdResponse adresponse = (AdResponse)mAdResponses.get(index);
        AdClickHandler adclickhandler = new AdClickHandler(mContext);
        adclickhandler.setAdInfo(adresponse);
        adclickhandler.setWebViewShow(flag);
        adclickhandler.jumpToClickDestinationUrl();
        index = index + 1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (isRequestingAd) goto _L4; else goto _L3
_L3:
        isRequestingAd = true;
        OnAdReceiveListener onadreceivelistener = new OnAdReceiveListener() {

            final AdShuffle this$0;

            public void onAdFail(String s)
            {
                Log.e("AdFail:", s);
            }

            public void onAdReceive(List list)
            {
                if (list.size() > 0)
                {
                    mAdResponses = (ArrayList)list;
                    int i = 0;
                    int j = 0;
                    while (i < mAdResponses.size()) 
                    {
                        list = (AdResponse)mAdResponses.get(i);
                        if (Utils.isInstalled(mContext, list.getPackageName()))
                        {
                            mAdResponses.remove(i);
                        }
                        if (!firstLaunch || j != 0)
                        {
                            if (PRELOAD && list.preload())
                            {
                                UrlResolutionTask.getResolvedUrl(list.getClickDestinationUrl(), list. new com.yeahmobi.android.common.UrlResolutionTask.UrlResolutionListener() {

                                    final _cls1 this$1;
                                    final AdResponse val$ad;

                                    public void onFailure()
                                    {
                                    }

                                    public void onSuccess(String s)
                                    {
                                        ad.setClickTrackUrl(s);
                                    }

            
            {
                this$1 = final__pcls1;
                ad = AdResponse.this;
                super();
            }
                                });
                            }
                            j++;
                        }
                        i++;
                    }
                    index = 0;
                    count = mAdResponses.size();
                    if (firstLaunch)
                    {
                        list = (AdResponse)mAdResponses.get(index);
                        AdClickHandler adclickhandler1 = new AdClickHandler(mContext);
                        adclickhandler1.setAdInfo(list);
                        adclickhandler1.setWebViewShow(true);
                        adclickhandler1.jumpToClickDestinationUrl();
                        index = index + 1;
                        firstLaunch = false;
                    }
                    isRequestingAd = false;
                }
            }

            
            {
                this$0 = AdShuffle.this;
                super();
            }
        };
        adManager = new AdManager(mContext);
        adManager.setAppId(Long.valueOf(appId).longValue());
        adManager.setSlotId(Long.valueOf(slotId).longValue());
        adManager.setAdNum(adNum);
        adManager.setAdReceiveListener(onadreceivelistener);
        if (!PRELOAD)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        adManager.setCallType(22);
_L5:
        adManager.setShowType(10);
        adManager.loadAd();
          goto _L4
        Exception exception;
        exception;
        throw exception;
        adManager.setCallType(21);
          goto _L5
    }



/*
    static ArrayList access$002(AdShuffle adshuffle, ArrayList arraylist)
    {
        adshuffle.mAdResponses = arraylist;
        return arraylist;
    }

*/




/*
    static boolean access$202(AdShuffle adshuffle, boolean flag)
    {
        adshuffle.firstLaunch = flag;
        return flag;
    }

*/




/*
    static int access$402(AdShuffle adshuffle, int i)
    {
        adshuffle.index = i;
        return i;
    }

*/


/*
    static int access$502(AdShuffle adshuffle, int i)
    {
        adshuffle.count = i;
        return i;
    }

*/


/*
    static boolean access$602(AdShuffle adshuffle, boolean flag)
    {
        adshuffle.isRequestingAd = flag;
        return flag;
    }

*/
}
