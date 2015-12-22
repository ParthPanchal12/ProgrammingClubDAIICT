// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.shuffle;

import android.view.View;
import com.yeahmobi.android.common.AdClickHandler;
import com.yeahmobi.android.common.AdResponse;
import java.util.ArrayList;

// Referenced classes of package com.yeahmobi.android.shuffle:
//            AdShuffleView

class this._cls0
    implements android.view.ener
{

    final AdShuffleView this$0;

    public void onClick(View view)
    {
        if (AdShuffleView.access$000(AdShuffleView.this) < AdShuffleView.access$100(AdShuffleView.this))
        {
            view = (AdResponse)AdShuffleView.access$200(AdShuffleView.this).get(AdShuffleView.access$000(AdShuffleView.this));
            AdClickHandler adclickhandler = new AdClickHandler(AdShuffleView.access$300(AdShuffleView.this));
            adclickhandler.setAdInfo(view);
            adclickhandler.setWebViewShow(true);
            adclickhandler.jumpToClickDestinationUrl();
            AdShuffleView.access$002(AdShuffleView.this, AdShuffleView.access$000(AdShuffleView.this) + 1);
        }
        if (AdShuffleView.access$000(AdShuffleView.this) >= AdShuffleView.access$100(AdShuffleView.this) - 1)
        {
            AdShuffleView.access$400(AdShuffleView.this);
        }
    }

    ()
    {
        this$0 = AdShuffleView.this;
        super();
    }
}
