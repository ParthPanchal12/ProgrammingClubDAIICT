// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.banner;

import android.util.Log;
import com.yeahmobi.android.common.AdResponse;
import com.yeahmobi.android.common.OnAdReceiveListener;
import com.yeahmobi.android.common.UrlResolutionTask;
import com.yeahmobi.android.common.util.Utils;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.banner:
//            AdBannerView

class val.ad
    implements com.yeahmobi.android.common..UrlResolutionListener
{

    final ckTrackUrl this$1;
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

    // Unreferenced inner class com/yeahmobi/android/banner/AdBannerView$3

/* anonymous class */
    class AdBannerView._cls3
        implements OnAdReceiveListener
    {

        final AdBannerView this$0;

        public void onAdFail(String s)
        {
            Log.e("AdFail:", s);
        }

        public void onAdReceive(List list)
        {
            if (list.size() > 0)
            {
                AdBannerView.access$202(AdBannerView.this, (ArrayList)list);
                for (int i = 0; i < AdBannerView.access$200(AdBannerView.this).size(); i++)
                {
                    list = (AdResponse)AdBannerView.access$200(AdBannerView.this).get(i);
                    if (Utils.isInstalled(AdBannerView.access$300(AdBannerView.this), list.getPackageName()))
                    {
                        AdBannerView.access$200(AdBannerView.this).remove(i);
                    }
                    if (AdBannerView.access$400(AdBannerView.this) && list.preload())
                    {
                        UrlResolutionTask.getResolvedUrl(list.getClickDestinationUrl(), list. new AdBannerView._cls3._cls1());
                    }
                }

                AdBannerView.access$000(AdBannerView.this);
                AdBannerView.access$502(AdBannerView.this, false);
            }
        }

            
            {
                this$0 = AdBannerView.this;
                super();
            }
    }

}
