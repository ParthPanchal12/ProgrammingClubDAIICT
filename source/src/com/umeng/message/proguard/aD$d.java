// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.Flushable;
import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            aD

protected static abstract class a extends a
{

    private final Flushable a;

    protected void c()
        throws IOException
    {
        a.flush();
    }

    protected (Flushable flushable)
    {
        a = flushable;
    }
}
