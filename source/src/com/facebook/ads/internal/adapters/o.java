// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            b, c, p

public class o extends b
{

    private final p b;

    public o(Context context, c c1, p p1)
    {
        super(context, c1);
        b = p1;
    }

    protected void b()
    {
        if (b == null)
        {
            return;
        }
        HashMap hashmap = new HashMap();
        if (a != null)
        {
            hashmap.put("mil", Boolean.valueOf(a.a()));
        }
        b.a(hashmap);
    }
}
