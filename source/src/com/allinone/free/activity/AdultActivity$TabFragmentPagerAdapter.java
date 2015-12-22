// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.AdultDatingFragment;
import com.allinone.free.fragments.AdultFeaturedFragment;
import com.allinone.free.fragments.AdultGamesFragment;
import com.allinone.free.fragments.AdultVideoFragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            AdultActivity

public class this._cls0 extends FragmentPagerAdapter
{

    final AdultActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return AdultActivity.tabTitle.length;
    }

    public Fragment getItem(int i)
    {
        Object obj;
        obj = (Fragment)AdultActivity.access$7(AdultActivity.this).get(Integer.valueOf(i));
        if (obj != null)
        {
            return ((Fragment) (obj));
        }
        i;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 76
    //                   1 87
    //                   2 98
    //                   3 109;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        AdultActivity.access$7(AdultActivity.this).put(Integer.valueOf(i), obj);
        return ((Fragment) (obj));
_L2:
        obj = new AdultFeaturedFragment();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new AdultGamesFragment();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new AdultDatingFragment();
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new AdultVideoFragment();
        if (true) goto _L1; else goto _L6
_L6:
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = AdultActivity.this;
        super(fragmentmanager);
    }
}
