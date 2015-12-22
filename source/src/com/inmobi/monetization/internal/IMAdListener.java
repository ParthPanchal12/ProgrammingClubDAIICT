// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import java.util.Map;

// Referenced classes of package com.inmobi.monetization.internal:
//            AdErrorCode

public interface IMAdListener
{

    public abstract void onAdInteraction(Map map);

    public abstract void onAdRequestFailed(AdErrorCode aderrorcode);

    public abstract void onAdRequestSucceeded();

    public abstract void onDismissAdScreen();

    public abstract void onIncentCompleted(Map map);

    public abstract void onLeaveApplication();

    public abstract void onShowAdScreen();
}
