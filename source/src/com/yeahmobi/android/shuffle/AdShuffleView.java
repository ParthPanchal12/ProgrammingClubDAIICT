// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.shuffle;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.yeahmobi.android.common.AdClickHandler;
import com.yeahmobi.android.common.AdManager;
import com.yeahmobi.android.common.AdResponse;
import com.yeahmobi.android.common.OnAdReceiveListener;
import com.yeahmobi.android.common.UrlResolutionTask;
import com.yeahmobi.android.common.util.Utils;
import com.yeahmobi.android.interfaces.AdInterfaces;
import java.util.ArrayList;
import java.util.List;

public class AdShuffleView extends FrameLayout
{
    public static class AdShuffleViewFactory
    {

        public static AdShuffleView create(Context context, boolean flag, int i)
        {
            return new AdShuffleView(context, flag, i);
        }

        public AdShuffleViewFactory()
        {
        }
    }


    private final boolean PRELOAD;
    private AdManager adManager;
    private int adNum;
    private String appId;
    private int count;
    private int index;
    private boolean isRequestingAd;
    private ArrayList mAdResponses;
    private ImageButton mButton;
    private Context mContext;
    private String slotId;

    public AdShuffleView(Context context)
    {
        super(context);
        isRequestingAd = false;
        PRELOAD = true;
        setup(context, 0x7f020007);
    }

    public AdShuffleView(Context context, int i)
    {
        super(context);
        isRequestingAd = false;
        PRELOAD = true;
        setup(context, i);
    }

    public AdShuffleView(Context context, boolean flag)
    {
        super(context);
        isRequestingAd = false;
        PRELOAD = flag;
        setup(context, 0x7f020007);
    }

    public AdShuffleView(Context context, boolean flag, int i)
    {
        super(context);
        isRequestingAd = false;
        PRELOAD = flag;
        setup(context, i);
    }

    private void requestAds()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isRequestingAd;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        isRequestingAd = true;
        OnAdReceiveListener onadreceivelistener = new OnAdReceiveListener() {

            final AdShuffleView this$0;

            public void onAdFail(String s)
            {
                Log.e("AdFail:", s);
            }

            public void onAdReceive(List list)
            {
                if (list.size() > 0)
                {
                    mAdResponses = (ArrayList)list;
                    for (int i = 0; i < mAdResponses.size(); i++)
                    {
                        list = (AdResponse)mAdResponses.get(i);
                        if (Utils.isInstalled(mContext, list.getPackageName()))
                        {
                            mAdResponses.remove(i);
                        }
                        if (PRELOAD && list.preload())
                        {
                            UrlResolutionTask.getResolvedUrl(list.getClickDestinationUrl(), list. new com.yeahmobi.android.common.UrlResolutionTask.UrlResolutionListener() {

                                final _cls2 this$1;
                                final AdResponse val$ad;

                                public void onFailure()
                                {
                                }

                                public void onSuccess(String s)
                                {
                                    ad.setClickTrackUrl(s);
                                }

            
            {
                this$1 = final__pcls2;
                ad = AdResponse.this;
                super();
            }
                            });
                        }
                    }

                    index = 0;
                    count = mAdResponses.size();
                    isRequestingAd = false;
                }
            }

            
            {
                this$0 = AdShuffleView.this;
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
            break; /* Loop/switch isn't completed */
        }
        adManager.setCallType(22);
_L4:
        adManager.setShowType(10);
        adManager.loadAd();
        if (true) goto _L1; else goto _L3
        Exception exception;
        exception;
        throw exception;
_L3:
        adManager.setCallType(21);
          goto _L4
    }

    private void setup(Context context, int i)
    {
        mContext = context;
        slotId = AdInterfaces.mSlotId;
        appId = AdInterfaces.mAppId;
        adNum = AdInterfaces.mAdNum;
        mButton = new ImageButton(context);
        mButton.setImageResource(i);
        requestAds();
        mButton.setOnClickListener(new android.view.View.OnClickListener() {

            final AdShuffleView this$0;

            public void onClick(View view)
            {
                if (index < count)
                {
                    view = (AdResponse)mAdResponses.get(index);
                    AdClickHandler adclickhandler = new AdClickHandler(mContext);
                    adclickhandler.setAdInfo(view);
                    adclickhandler.setWebViewShow(true);
                    adclickhandler.jumpToClickDestinationUrl();
                    index = index + 1;
                }
                if (index >= count - 1)
                {
                    requestAds();
                }
            }

            
            {
                this$0 = AdShuffleView.this;
                super();
            }
        });
        addView(mButton);
    }



/*
    static int access$002(AdShuffleView adshuffleview, int i)
    {
        adshuffleview.index = i;
        return i;
    }

*/



/*
    static int access$102(AdShuffleView adshuffleview, int i)
    {
        adshuffleview.count = i;
        return i;
    }

*/



/*
    static ArrayList access$202(AdShuffleView adshuffleview, ArrayList arraylist)
    {
        adshuffleview.mAdResponses = arraylist;
        return arraylist;
    }

*/





/*
    static boolean access$602(AdShuffleView adshuffleview, boolean flag)
    {
        adshuffleview.isRequestingAd = flag;
        return flag;
    }

*/
}
