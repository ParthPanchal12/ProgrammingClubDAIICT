// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.view.View;

// Referenced classes of package com.umeng.update:
//            UpdateDialogActivity

class c
    implements android.view.y._cls1
{

    final UpdateDialogActivity a;
    private final int b;
    private final int c;

    public void onClick(View view)
    {
        if (b != view.getId()) goto _L2; else goto _L1
_L1:
        a.a = 5;
_L4:
        a.finish();
        return;
_L2:
        if (c == view.getId())
        {
            a.a = 7;
        } else
        if (a.c)
        {
            a.a = 7;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (UpdateDialogActivity updatedialogactivity, int i, int j)
    {
        a = updatedialogactivity;
        b = i;
        c = j;
        super();
    }
}
