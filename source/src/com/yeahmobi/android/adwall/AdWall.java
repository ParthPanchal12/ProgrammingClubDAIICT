// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.adwall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
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
//            AdWallRes, AdWallListAdapter

public class AdWall extends Activity
{

    static final String KEY_CONTENT = "content";
    static final String KEY_ID = "id";
    static final String KEY_THUMB_URL = "thumb_url";
    static final String KEY_TITLE = "title";
    private boolean PRELOAD;
    private AdManager adManager;
    private int adNum;
    private String appId;
    private List mAdClickHandlers;
    private ProgressBar progressBar;
    private String slotId;
    ListView wallList;
    private AdWallRes wallRes;

    public AdWall()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        bundle = getIntent().getExtras();
        PRELOAD = bundle.getBoolean("preload");
        wallRes = (AdWallRes)bundle.getParcelable("res");
        setContentView(wallRes.getLayoutRes());
        slotId = AdInterfaces.mSlotId;
        appId = AdInterfaces.mAppId;
        adNum = AdInterfaces.mAdNum;
        wallList = (ListView)findViewById(wallRes.getListRes());
        mAdClickHandlers = new ArrayList();
        bundle = new OnAdReceiveListener() {

            final AdWall this$0;
            final Context val$mContext;

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
                    Object obj1 = (AdResponse)list.get(i);
                    if (!Utils.isInstalled(mContext, ((AdResponse) (obj1)).getPackageName()))
                    {
                        if (PRELOAD && ((AdResponse) (obj1)).preload())
                        {
                            UrlResolutionTask.getResolvedUrl(((AdResponse) (obj1)).getClickDestinationUrl(), ((_cls1) (obj1)). new com.yeahmobi.android.common.UrlResolutionTask.UrlResolutionListener() {

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
                        Object obj = new AdClickHandler(mContext);
                        ((AdClickHandler) (obj)).setAdInfo(((com.yeahmobi.android.common.IAdInfo) (obj1)));
                        ((AdClickHandler) (obj)).setWebViewShow(true);
                        mAdClickHandlers.add(obj);
                        obj = ((AdResponse) (obj1)).getTitle();
                        String s = ((AdResponse) (obj1)).getMainContent();
                        obj1 = ((AdResponse) (obj1)).getIconImageUrl();
                        HashMap hashmap = new HashMap();
                        hashmap.put("title", (new StringBuilder()).append(((String) (obj))).append(":").toString());
                        hashmap.put("content", s);
                        hashmap.put("thumb_url", obj1);
                        arraylist.add(hashmap);
                    }
                    i++;
                }
                list = new AdWallListAdapter(mContext, wallRes.getItemRes(), arraylist);
                wallList.setAdapter(list);
                progressBar = (ProgressBar)findViewById(wallRes.getProcessBarRes());
                progressBar.setVisibility(8);
            }

            
            {
                this$0 = AdWall.this;
                mContext = context;
                super();
            }
        };
        adManager = new AdManager(getBaseContext());
        adManager.setAppId(Long.valueOf(appId).longValue());
        adManager.setSlotId(Long.valueOf(slotId).longValue());
        adManager.setAdReceiveListener(bundle);
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
        wallList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AdWall this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                ((AdClickHandler)mAdClickHandlers.get(i)).jumpToClickDestinationUrl();
            }

            
            {
                this$0 = AdWall.this;
                super();
            }
        });
    }






/*
    static ProgressBar access$302(AdWall adwall, ProgressBar progressbar)
    {
        adwall.progressBar = progressbar;
        return progressbar;
    }

*/
}
