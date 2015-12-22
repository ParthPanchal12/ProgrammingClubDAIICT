// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.support.v4.widget.SwipeRefreshLayout;
import com.umeng.fb.SyncListener;
import java.util.List;

// Referenced classes of package com.umeng.fb.example:
//            CustomActivity

class this._cls0
    implements SyncListener
{

    final CustomActivity this$0;

    public void onReceiveDevReply(List list)
    {
        CustomActivity.access$9(CustomActivity.this).setRefreshing(false);
        CustomActivity.access$6(CustomActivity.this).notifyDataSetChanged();
        CustomActivity.access$7(CustomActivity.this);
    }

    public void onSendUserReply(List list)
    {
    }

    plyAdapter()
    {
        this$0 = CustomActivity.this;
        super();
    }
}
