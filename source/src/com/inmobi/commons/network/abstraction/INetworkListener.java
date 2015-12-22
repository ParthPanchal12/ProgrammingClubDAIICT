// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.network.abstraction;

import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Response;

public interface INetworkListener
{

    public abstract void onRequestFailed(Request request, Response response);

    public abstract void onRequestSucceded(Request request, Response response);
}
