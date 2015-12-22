// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.adwall;

import android.content.Context;
import android.util.Log;
import com.yeahmobi.android.common.AdClickHandler;
import com.yeahmobi.android.common.AdResponse;
import com.yeahmobi.android.common.OnAdReceiveListener;
import com.yeahmobi.android.common.UrlResolutionTask;
import com.yeahmobi.android.common.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.adwall:
//            AdWallAdapter, AdWallLoadListener

class val.ad
    implements com.yeahmobi.android.common.UrlResolutionListener
{

    final kTrackUrl this$1;
    final AdResponse val$ad;

    public void onFailure()
    {
    }

    public void onSuccess(String s)
    {
        val$ad.setClickTrackUrl(s);
    }

    ()
    {
        this$1 = final_;
        val$ad = AdResponse.this;
        super();
    }

    // Unreferenced inner class com/yeahmobi/android/adwall/AdWallAdapter$1

/* anonymous class */
    class AdWallAdapter._cls1
        implements OnAdReceiveListener
    {

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
                    AdWallAdapter.access$000(AdWallAdapter.this).add(obj);
                    obj = adresponse.getTitle();
                    String s = adresponse.getMainContent();
                    String s1 = adresponse.getIconImageUrl();
                    HashMap hashmap = new HashMap();
                    hashmap.put("title", (new StringBuilder()).append(((String) (obj))).append(":").toString());
                    hashmap.put("content", s);
                    hashmap.put("thumb_url", s1);
                    arraylist.add(hashmap);
                    if (AdWallAdapter.access$100(AdWallAdapter.this) && adresponse.preload())
                    {
                        UrlResolutionTask.getResolvedUrl(adresponse.getClickDestinationUrl(), adresponse. new AdWallAdapter._cls1._cls1());
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
                this$0 = final_adwalladapter;
                context = context1;
                loadListener = AdWallLoadListener.this;
                super();
            }
    }

}
