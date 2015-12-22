// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network;

import com.inmobi.commons.network.abstraction.INetworkListener;
import com.inmobi.commons.network.abstraction.INetworkServiceProvider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.inmobi.commons.network:
//            NetworkRequestTask, Request

public class ServiceProvider
    implements INetworkServiceProvider
{

    private static ServiceProvider a;
    private ExecutorService b;

    private ServiceProvider()
    {
        b = Executors.newFixedThreadPool(15);
    }

    public static ServiceProvider getInstance()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/inmobi/commons/network/ServiceProvider;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new ServiceProvider();
        }
        com/inmobi/commons/network/ServiceProvider;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Exception exception;
        exception;
        com/inmobi/commons/network/ServiceProvider;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void executeTask(Request request, INetworkListener inetworklistener)
    {
        b.execute(new NetworkRequestTask(request, inetworklistener));
    }
}
