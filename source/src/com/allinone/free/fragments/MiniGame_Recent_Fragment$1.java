// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import com.allinone.free.activity.MiniGameDetails;

// Referenced classes of package com.allinone.free.fragments:
//            MiniGame_Recent_Fragment

class this._cls0
    implements android.widget.ener
{

    final MiniGame_Recent_Fragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getActivity(), com/allinone/free/activity/MiniGameDetails);
        adapterview.putExtra("pos", i);
        adapterview.putExtra("list", MiniGame_Recent_Fragment.access$3(MiniGame_Recent_Fragment.this));
        getActivity().startActivity(adapterview);
    }

    ()
    {
        this$0 = MiniGame_Recent_Fragment.this;
        super();
    }
}
