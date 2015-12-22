// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.config;

import java.util.Map;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.config:
//            AdTrackerInitializer

static final class I
    implements com.inmobi.commons.cache.or
{

    public boolean validate(Map map)
    {
        return AdTrackerInitializer.a(map);
    }

    I()
    {
    }
}
