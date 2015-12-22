// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.PaidFeaturedFragment;
import com.allinone.free.fragments.PaidHotAppsFragment;
import com.allinone.free.fragments.PaidHotGamesFragment;
import com.allinone.free.fragments.PaidNewAppsFragment;
import com.allinone.free.fragments.PaidNewGamesFragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            PaidforFreeActivity

public class this._cls0 extends FragmentPagerAdapter
{

    final PaidforFreeActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return PaidforFreeActivity.tabTitle.length;
    }

    public Fragment getItem(int i)
    {
        Object obj;
        obj = (Fragment)PaidforFreeActivity.access$7(PaidforFreeActivity.this).get(Integer.valueOf(i));
        if (obj != null)
        {
            return ((Fragment) (obj));
        }
        i;
        JVM INSTR tableswitch 0 4: default 60
    //                   0 80
    //                   1 91
    //                   2 102
    //                   3 113
    //                   4 124;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        PaidforFreeActivity.access$7(PaidforFreeActivity.this).put(Integer.valueOf(i), obj);
        return ((Fragment) (obj));
_L2:
        obj = new PaidFeaturedFragment();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new PaidHotAppsFragment();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new PaidNewAppsFragment();
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new PaidHotGamesFragment();
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new PaidNewGamesFragment();
        if (true) goto _L1; else goto _L7
_L7:
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = PaidforFreeActivity.this;
        super(fragmentmanager);
    }
}
