// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.allinone.free.activity.AppDetailsActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import java.util.ArrayList;

// Referenced classes of package com.allinone.free.fragments:
//            GameGlobalNewFragment

class this._cls0
    implements android.widget.istener
{

    final GameGlobalNewFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getActivity(), com/allinone/free/activity/AppDetailsActivity);
        if (!GameGlobalNewFragment.access$4(GameGlobalNewFragment.this))
        {
            break MISSING_BLOCK_LABEL_62;
        }
        adapterview.putExtra("myid", ((DownloadMovieItem)GameGlobalNewFragment.access$5(GameGlobalNewFragment.this).get(i - 1)).getId());
_L1:
        startActivity(adapterview);
        return;
        try
        {
            adapterview.putExtra("myid", ((DownloadMovieItem)GameGlobalNewFragment.access$5(GameGlobalNewFragment.this).get(i)).getId());
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            return;
        }
          goto _L1
    }

    _cls9()
    {
        this$0 = GameGlobalNewFragment.this;
        super();
    }
}
