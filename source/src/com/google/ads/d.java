// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.ads:
//            c

public class d
{

    private c a;
    private long b;

    public d()
    {
        a = null;
        b = -1L;
    }

    public void a(c c, int i)
    {
        a = c;
        b = TimeUnit.MILLISECONDS.convert(i, TimeUnit.SECONDS) + SystemClock.elapsedRealtime();
    }

    public boolean a()
    {
        return a != null && SystemClock.elapsedRealtime() < b;
    }

    public c b()
    {
        return a;
    }
}
