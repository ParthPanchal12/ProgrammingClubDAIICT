// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network.abstraction;

import com.inmobi.commons.network.Request;

// Referenced classes of package com.inmobi.commons.network.abstraction:
//            INetworkListener

public interface INetworkServiceProvider
{

    public abstract void executeTask(Request request, INetworkListener inetworklistener);
}
