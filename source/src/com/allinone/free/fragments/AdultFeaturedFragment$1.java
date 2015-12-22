// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.allinone.free.utils.ProgressWheel;

// Referenced classes of package com.allinone.free.fragments:
//            AdultFeaturedFragment

class this._cls0 extends BroadcastReceiver
{

    final AdultFeaturedFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        AdultFeaturedFragment.access$0(AdultFeaturedFragment.this).setVisibility(0);
    }

    _cls9()
    {
        this$0 = AdultFeaturedFragment.this;
        super();
    }
}
