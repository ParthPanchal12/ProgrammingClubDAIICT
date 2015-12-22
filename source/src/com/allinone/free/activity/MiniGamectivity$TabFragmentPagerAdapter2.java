// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.Mp3SearchFragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            MiniGamectivity

private class this._cls0 extends FragmentPagerAdapter
{

    final MiniGamectivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return 1;
    }

    public Fragment getItem(int i)
    {
        Fragment fragment = (Fragment)MiniGamectivity.access$1(MiniGamectivity.this).get(Integer.valueOf(i));
        if (fragment != null)
        {
            return fragment;
        } else
        {
            Mp3SearchFragment mp3searchfragment = new Mp3SearchFragment();
            MiniGamectivity.access$1(MiniGamectivity.this).put(Integer.valueOf(i), mp3searchfragment);
            return mp3searchfragment;
        }
    }

    public I(FragmentManager fragmentmanager)
    {
        this$0 = MiniGamectivity.this;
        super(fragmentmanager);
    }
}
