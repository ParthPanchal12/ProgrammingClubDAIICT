// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.FunTrendingFragment;
import com.allinone.free.fragments.FunadultFragment;
import com.allinone.free.fragments.FunallFragment;
import com.allinone.free.fragments.FungagFragment;
import com.allinone.free.fragments.FungifFragment;
import com.allinone.free.fragments.FunpopularFragment;
import com.allinone.free.fragments.FunvideoFragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            FunActivity

public class this._cls0 extends FragmentPagerAdapter
{

    final FunActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return FunActivity.tabTitle.length;
    }

    public Fragment getItem(int i)
    {
        Object obj;
        obj = (Fragment)FunActivity.access$0(FunActivity.this).get(Integer.valueOf(i));
        if (obj != null)
        {
            return ((Fragment) (obj));
        }
        i;
        JVM INSTR tableswitch 0 6: default 68
    //                   0 88
    //                   1 99
    //                   2 110
    //                   3 121
    //                   4 132
    //                   5 143
    //                   6 154;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        FunActivity.access$0(FunActivity.this).put(Integer.valueOf(i), obj);
        return ((Fragment) (obj));
_L2:
        obj = new FunallFragment();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new FunadultFragment();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new FungagFragment();
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new FungifFragment();
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new FunvideoFragment();
        continue; /* Loop/switch isn't completed */
_L7:
        obj = new FunpopularFragment();
        continue; /* Loop/switch isn't completed */
_L8:
        obj = new FunTrendingFragment();
        if (true) goto _L1; else goto _L9
_L9:
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = FunActivity.this;
        super(fragmentmanager);
    }
}
