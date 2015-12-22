// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb;

import java.util.List;

public interface SyncListener
{

    public abstract void onReceiveDevReply(List list);

    public abstract void onSendUserReply(List list);
}
