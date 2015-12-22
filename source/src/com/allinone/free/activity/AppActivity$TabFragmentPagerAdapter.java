// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.AppFeaturedFragment;
import com.allinone.free.fragments.AppGlobalNewFragment;
import com.allinone.free.fragments.AppGlobalTopFragment;
import com.allinone.free.fragments.AppIndiaNewFragment;
import com.allinone.free.fragments.AppIndiaTopFragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            AppActivity

public class this._cls0 extends FragmentPagerAdapter
{

    final AppActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return AppActivity.tabTitle.length;
    }

    public Fragment getItem(int i)
    {
        Object obj;
        obj = (Fragment)AppActivity.access$7(AppActivity.this).get(Integer.valueOf(i));
        if (obj != null)
        {
            return ((Fragment) (obj));
        }
        i;
        JVM INSTR tableswitch 0 4: default 60
    //                   0 80
    //                   1 113
    //                   2 124
    //                   3 91
    //                   4 102;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        AppActivity.access$7(AppActivity.this).put(Integer.valueOf(i), obj);
        return ((Fragment) (obj));
_L2:
        obj = new AppFeaturedFragment();
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new AppIndiaTopFragment();
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new AppIndiaNewFragment();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new AppGlobalTopFragment();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new AppGlobalNewFragment();
        if (true) goto _L1; else goto _L7
_L7:
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = AppActivity.this;
        super(fragmentmanager);
    }
}
