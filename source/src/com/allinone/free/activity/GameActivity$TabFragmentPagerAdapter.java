// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.GameFeaturedFragment;
import com.allinone.free.fragments.GameGlobalNewFragment;
import com.allinone.free.fragments.GameGlobalTopFragment;
import com.allinone.free.fragments.GameIndiaNewFragment;
import com.allinone.free.fragments.GameIndiaTopFragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            GameActivity

public class this._cls0 extends FragmentPagerAdapter
{

    final GameActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return GameActivity.tabTitle.length;
    }

    public Fragment getItem(int i)
    {
        Object obj;
        obj = (Fragment)GameActivity.access$7(GameActivity.this).get(Integer.valueOf(i));
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
        GameActivity.access$7(GameActivity.this).put(Integer.valueOf(i), obj);
        return ((Fragment) (obj));
_L2:
        obj = new GameFeaturedFragment();
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new GameIndiaTopFragment();
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new GameIndiaNewFragment();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new GameGlobalTopFragment();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new GameGlobalNewFragment();
        if (true) goto _L1; else goto _L7
_L7:
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = GameActivity.this;
        super(fragmentmanager);
    }
}
