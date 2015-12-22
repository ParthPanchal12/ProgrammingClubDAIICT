// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.widget.CompoundButton;

// Referenced classes of package com.umeng.update:
//            UpdateDialogActivity

class a
    implements android.widget.dChangeListener
{

    final UpdateDialogActivity a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        a.c = flag;
    }

    hangeListener(UpdateDialogActivity updatedialogactivity)
    {
        a = updatedialogactivity;
        super();
    }
}
