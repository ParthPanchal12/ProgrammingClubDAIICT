// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.shuffle;

import android.util.Log;
import com.yeahmobi.android.common.AdClickHandler;
import com.yeahmobi.android.common.AdResponse;
import com.yeahmobi.android.common.OnAdReceiveListener;
import com.yeahmobi.android.common.UrlResolutionTask;
import com.yeahmobi.android.common.util.Utils;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.shuffle:
//            AdShuffle

class val.ad
    implements com.yeahmobi.android.common.ask.UrlResolutionListener
{

    final lickTrackUrl this$1;
    final AdResponse val$ad;

    public void onFailure()
    {
    }

    public void onSuccess(String s)
    {
        val$ad.setClickTrackUrl(s);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$ad = AdResponse.this;
        super();
    }

    // Unreferenced inner class com/yeahmobi/android/shuffle/AdShuffle$1

/* anonymous class */
    class AdShuffle._cls1
        implements OnAdReceiveListener
    {

        final AdShuffle this$0;

        public void onAdFail(String s)
        {
            Log.e("AdFail:", s);
        }

        public void onAdReceive(List list)
        {
            if (list.size() > 0)
            {
                AdShuffle.access$002(AdShuffle.this, (ArrayList)list);
                int i = 0;
                int j = 0;
                while (i < AdShuffle.access$000(AdShuffle.this).size()) 
                {
                    list = (AdResponse)AdShuffle.access$000(AdShuffle.this).get(i);
                    if (Utils.isInstalled(AdShuffle.access$100(AdShuffle.this), list.getPackageName()))
                    {
                        AdShuffle.access$000(AdShuffle.this).remove(i);
                    }
                    if (!AdShuffle.access$200(AdShuffle.this) || j != 0)
                    {
                        if (AdShuffle.access$300(AdShuffle.this) && list.preload())
                        {
                            UrlResolutionTask.getResolvedUrl(list.getClickDestinationUrl(), list. new AdShuffle._cls1._cls1());
                        }
                        j++;
                    }
                    i++;
                }
                AdShuffle.access$402(AdShuffle.this, 0);
                AdShuffle.access$502(AdShuffle.this, AdShuffle.access$000(AdShuffle.this).size());
                if (AdShuffle.access$200(AdShuffle.this))
                {
                    list = (AdResponse)AdShuffle.access$000(AdShuffle.this).get(AdShuffle.access$400(AdShuffle.this));
                    AdClickHandler adclickhandler = new AdClickHandler(AdShuffle.access$100(AdShuffle.this));
                    adclickhandler.setAdInfo(list);
                    adclickhandler.setWebViewShow(true);
                    adclickhandler.jumpToClickDestinationUrl();
                    AdShuffle.access$402(AdShuffle.this, AdShuffle.access$400(AdShuffle.this) + 1);
                    AdShuffle.access$202(AdShuffle.this, false);
                }
                AdShuffle.access$602(AdShuffle.this, false);
            }
        }

            
            {
                this$0 = AdShuffle.this;
                super();
            }
    }

}
