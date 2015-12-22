// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.KeyEvent;
import android.view.View;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDInterstitialController

class a
    implements android.view.rstitialController._cls3
{

    final MRAIDInterstitialController a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (4 == keyevent.getKeyCode())
        {
            flag = flag1;
            if (keyevent.getAction() == 0)
            {
                Log.debug("[InMobi]-[RE]-4.5.5", "Back Button pressed while Interstitial ad is in active state ");
                a.handleInterstitialClose();
                flag = flag1;
                if (MRAIDInterstitialController.b(a) > 0L)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    (MRAIDInterstitialController mraidinterstitialcontroller)
    {
        a = mraidinterstitialcontroller;
        super();
    }
}
