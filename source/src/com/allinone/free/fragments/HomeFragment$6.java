// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.Toast;
import com.allinone.free.mydownload.DownloadMovieItem;

// Referenced classes of package com.allinone.free.fragments:
//            HomeFragment

class this._cls0 extends Handler
{

    final HomeFragment this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            Toast.makeText(getActivity(), "Failed to connect server.", 0).show();
            return;

        case 2: // '\002'
            HomeFragment.access$6(HomeFragment.this);
            return;

        case 3: // '\003'
            Toast.makeText(getActivity(), (new StringBuilder("'")).append(HomeFragment.access$7(HomeFragment.this).getTitle()).append("' is added to download queue.").toString(), 0).show();
            break;
        }
        message = new Intent();
        message.setAction("homeapp");
        getActivity().sendBroadcast(message);
        HomeFragment.access$4(HomeFragment.this).setVisibility(0);
        HomeFragment.access$4(HomeFragment.this).startAnimation(HomeFragment.access$5(HomeFragment.this));
    }

    tem()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
