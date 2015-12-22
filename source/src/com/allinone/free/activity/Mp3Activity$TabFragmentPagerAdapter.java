// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.Mp3_Popular_Fragment;
import com.allinone.free.fragments.Mp3_Recent_Fragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            Mp3Activity

public class this._cls0 extends FragmentPagerAdapter
{

    final Mp3Activity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return Mp3Activity.tabTitle.length;
    }

    public Fragment getItem(int i)
    {
        Object obj;
        obj = (Fragment)Mp3Activity.access$0(Mp3Activity.this).get(Integer.valueOf(i));
        if (obj != null)
        {
            return ((Fragment) (obj));
        }
        i;
        JVM INSTR tableswitch 0 1: default 48
    //                   0 68
    //                   1 79;
           goto _L1 _L2 _L3
_L1:
        Mp3Activity.access$0(Mp3Activity.this).put(Integer.valueOf(i), obj);
        return ((Fragment) (obj));
_L2:
        obj = new Mp3_Recent_Fragment();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new Mp3_Popular_Fragment();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = Mp3Activity.this;
        super(fragmentmanager);
    }
}
