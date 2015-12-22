// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.allinone.free.fragments.DownloadedFragment;
import com.allinone.free.fragments.DownloadingFragment;
import java.util.Map;

// Referenced classes of package com.allinone.free.activity:
//            DownloadsActivity

public class this._cls0 extends FragmentPagerAdapter
{

    final DownloadsActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
    }

    public int getCount()
    {
        return DownloadsActivity.tabTitle.length;
    }

    public Fragment getItem(int i)
    {
        Object obj;
        obj = (Fragment)DownloadsActivity.access$0(DownloadsActivity.this).get(Integer.valueOf(i));
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
        DownloadsActivity.access$0(DownloadsActivity.this).put(Integer.valueOf(i), obj);
        return ((Fragment) (obj));
_L2:
        obj = new DownloadingFragment();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new DownloadedFragment();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = DownloadsActivity.this;
        super(fragmentmanager);
    }
}
