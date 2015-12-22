// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.MiniGame_Popular_Fragment;
import com.allinone.free.fragments.MiniGame_Recent_Fragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            MiniGamectivity

public class this._cls0 extends FragmentPagerAdapter
{

    final MiniGamectivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return MiniGamectivity.tabTitle.length;
    }

    public Fragment getItem(int i)
    {
        Object obj;
        obj = (Fragment)MiniGamectivity.access$0(MiniGamectivity.this).get(Integer.valueOf(i));
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
        MiniGamectivity.access$0(MiniGamectivity.this).put(Integer.valueOf(i), obj);
        return ((Fragment) (obj));
_L2:
        obj = new MiniGame_Recent_Fragment();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new MiniGame_Popular_Fragment();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = MiniGamectivity.this;
        super(fragmentmanager);
    }
}
