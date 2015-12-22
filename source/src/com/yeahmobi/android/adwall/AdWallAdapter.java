// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.adwall;

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
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.adwall:
//            AdWallLoadListener

public class AdWallAdapter
{

    public static final String KEY_CONTENT = "content";
    static final String KEY_ID = "id";
    public static final String KEY_THUMB_URL = "thumb_url";
    public static final String KEY_TITLE = "title";
    private boolean PRELOAD;
    private AdManager adManager;
    private int adNum;
    private String appId;
    private List mAdClickHandlers;
    private String slotId;

    public AdWallAdapter()
    {
    }

    public void load(Context context, AdWallLoadListener adwallloadlistener)
    {
        load(context, true, adwallloadlistener);
    }

    public void load(final Context context, boolean flag, final AdWallLoadListener loadListener)
    {
        PRELOAD = flag;
        slotId = AdInterfaces.mSlotId;
        appId = AdInterfaces.mAppId;
        adNum = AdInterfaces.mAdNum;
        mAdClickHandlers = new ArrayList();
        loadListener = new OnAdReceiveListener() {

            final AdWallAdapter this$0;
            final Context val$context;
            final AdWallLoadListener val$loadListener;

            public void onAdFail(String s)
            {
                Log.e("AdFail:", s);
            }

            public void onAdReceive(List list)
            {
                ArrayList arraylist = new ArrayList();
                int i = 0;
                while (i < list.size()) 
                {
                    AdResponse adresponse = (AdResponse)list.get(i);
                    if (!Utils.isInstalled(context, adresponse.getPackageName()))
                    {
                        Object obj = new AdClickHandler(context);
                        ((AdClickHandler) (obj)).setAdInfo(adresponse);
                        ((AdClickHandler) (obj)).setWebViewShow(true);
                        mAdClickHandlers.add(obj);
                        obj = adresponse.getTitle();
                        String s = adresponse.getMainContent();
                        String s1 = adresponse.getIconImageUrl();
                        HashMap hashmap = new HashMap();
                        hashmap.put("title", (new StringBuilder()).append(((String) (obj))).append(":").toString());
                        hashmap.put("content", s);
                        hashmap.put("thumb_url", s1);
                        arraylist.add(hashmap);
                        if (PRELOAD && adresponse.preload())
                        {
                            UrlResolutionTask.getResolvedUrl(adresponse.getClickDestinationUrl(), adresponse. new com.yeahmobi.android.common.UrlResolutionTask.UrlResolutionListener() {

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
                    }
                    i++;
                }
                if (loadListener != null)
                {
                    loadListener.onComplete(arraylist);
                }
            }

            
            {
                this$0 = AdWallAdapter.this;
                context = context1;
                loadListener = adwallloadlistener;
                super();
            }
        };
        adManager = new AdManager(context);
        adManager.setAppId(Long.valueOf(appId).longValue());
        adManager.setSlotId(Long.valueOf(slotId).longValue());
        adManager.setAdReceiveListener(loadListener);
        adManager.setAdNum(adNum);
        if (PRELOAD)
        {
            adManager.setCallType(22);
        } else
        {
            adManager.setCallType(21);
        }
        adManager.setShowType(30);
        adManager.loadAd();
    }

    public void onClick(int i)
    {
        if (i >= 0 && i < mAdClickHandlers.size())
        {
            ((AdClickHandler)mAdClickHandlers.get(i)).jumpToClickDestinationUrl();
        }
    }


}
