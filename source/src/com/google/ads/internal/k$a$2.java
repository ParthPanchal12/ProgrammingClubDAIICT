// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.google.ads.internal:
//            k, j, d

class a
    implements android.content.Interface.OnClickListener
{

    final ationContext a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        (new Thread(new j(t>(a).d(), a(a).getApplicationContext()))).start();
    }

    e(e e)
    {
        a = e;
        super();
    }
}
