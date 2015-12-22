// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.yeahmobi.android.common:
//            AdClickHandler

class this._cls0
    implements android.view.r
{

    final AdClickHandler this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return false;

        case 4: // '\004'
            AdClickHandler.access$000(AdClickHandler.this);
            break;
        }
        return true;
    }

    ()
    {
        this$0 = AdClickHandler.this;
        super();
    }
}
