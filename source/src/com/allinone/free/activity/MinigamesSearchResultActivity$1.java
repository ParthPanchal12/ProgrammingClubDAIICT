// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.allinone.free.activity:
//            MinigamesSearchResultActivity, MiniGameDetails

class this._cls0
    implements android.widget.tActivity._cls1
{

    final MinigamesSearchResultActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(MinigamesSearchResultActivity.this, com/allinone/free/activity/MiniGameDetails);
        adapterview.putExtra("pos", i);
        adapterview.putExtra("list", MinigamesSearchResultActivity.access$6(MinigamesSearchResultActivity.this));
        startActivity(adapterview);
    }

    ()
    {
        this$0 = MinigamesSearchResultActivity.this;
        super();
    }
}
