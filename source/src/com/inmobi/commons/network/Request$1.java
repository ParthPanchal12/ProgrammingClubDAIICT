// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;


// Referenced classes of package com.inmobi.commons.network:
//            Request

static class rmat
{

    static final int a[];

    static 
    {
        a = new int[rmat.values().length];
        try
        {
            a[rmat.KEY_VAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[rmat.JSON.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
