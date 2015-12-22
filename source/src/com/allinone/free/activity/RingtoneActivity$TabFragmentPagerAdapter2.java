// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.RingtoneSearchFragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            RingtoneActivity

private class this._cls0 extends FragmentPagerAdapter
{

    final RingtoneActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return 1;
    }

    public Fragment getItem(int i)
    {
        Fragment fragment = (Fragment)RingtoneActivity.access$1(RingtoneActivity.this).get(Integer.valueOf(i));
        if (fragment != null)
        {
            return fragment;
        } else
        {
            RingtoneSearchFragment ringtonesearchfragment = new RingtoneSearchFragment();
            RingtoneActivity.access$1(RingtoneActivity.this).put(Integer.valueOf(i), ringtonesearchfragment);
            return ringtonesearchfragment;
        }
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = RingtoneActivity.this;
        super(fragmentmanager);
    }
}
