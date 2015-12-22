// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.adwall;

import android.view.View;
import android.widget.AdapterView;
import com.yeahmobi.android.common.AdClickHandler;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.adwall:
//            AdWall

class this._cls0
    implements android.widget.ew.OnItemClickListener
{

    final AdWall this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        ((AdClickHandler)AdWall.access$100(AdWall.this).get(i)).jumpToClickDestinationUrl();
    }

    ndler()
    {
        this$0 = AdWall.this;
        super();
    }
}
