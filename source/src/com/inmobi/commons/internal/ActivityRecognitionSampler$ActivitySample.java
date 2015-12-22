// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;


// Referenced classes of package com.inmobi.commons.internal:
//            ActivityRecognitionSampler

public static class a
{

    private long a;
    private int b;

    public int getActivity()
    {
        return b;
    }

    public long getTimestamp()
    {
        return a;
    }

    public (int i, long l)
    {
        b = i;
        a = l;
    }
}
