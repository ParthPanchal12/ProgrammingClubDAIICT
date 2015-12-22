// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;


// Referenced classes of package com.umeng.update:
//            UpdateResponse

public interface UmengUpdateListener
{

    public abstract void onUpdateReturned(int i, UpdateResponse updateresponse);
}
