// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.shuffle;

import android.util.Log;
import com.yeahmobi.android.common.AdResponse;
import com.yeahmobi.android.common.OnAdReceiveListener;
import com.yeahmobi.android.common.UrlResolutionTask;
import com.yeahmobi.android.common.util.Utils;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.shuffle:
//            AdShuffleView

class val.ad
    implements com.yeahmobi.android.common.UrlResolutionListener
{

    final TrackUrl this$1;
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

    // Unreferenced inner class com/yeahmobi/android/shuffle/AdShuffleView$2

/* anonymous class */
    class AdShuffleView._cls2
        implements OnAdReceiveListener
    {

        final AdShuffleView this$0;

        public void onAdFail(String s)
        {
            Log.e("AdFail:", s);
        }

        public void onAdReceive(List list)
        {
            if (list.size() > 0)
            {
                AdShuffleView.access$202(AdShuffleView.this, (ArrayList)list);
                for (int i = 0; i < AdShuffleView.access$200(AdShuffleView.this).size(); i++)
                {
                    list = (AdResponse)AdShuffleView.access$200(AdShuffleView.this).get(i);
                    if (Utils.isInstalled(AdShuffleView.access$300(AdShuffleView.this), list.getPackageName()))
                    {
                        AdShuffleView.access$200(AdShuffleView.this).remove(i);
                    }
                    if (AdShuffleView.access$500(AdShuffleView.this) && list.preload())
                    {
                        UrlResolutionTask.getResolvedUrl(list.getClickDestinationUrl(), list. new AdShuffleView._cls2._cls1());
                    }
                }

                AdShuffleView.access$002(AdShuffleView.this, 0);
                AdShuffleView.access$102(AdShuffleView.this, AdShuffleView.access$200(AdShuffleView.this).size());
                AdShuffleView.access$602(AdShuffleView.this, false);
            }
        }

            
            {
                this$0 = AdShuffleView.this;
                super();
            }
    }

}
