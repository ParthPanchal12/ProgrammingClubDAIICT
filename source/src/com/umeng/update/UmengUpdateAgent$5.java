// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.content.Context;
import android.widget.Toast;

// Referenced classes of package com.umeng.update:
//            UmengUpdateAgent

class a
    implements Runnable
{

    private final Context a;

    public void run()
    {
        Toast.makeText(a, "Please add Service in AndroidManifest!", 1).show();
    }

    (Context context)
    {
        a = context;
        super();
    }
}
