// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MemoryCache
{

    private Map cache;

    public MemoryCache()
    {
        cache = Collections.synchronizedMap(new HashMap());
    }

    public void clear()
    {
        cache.clear();
    }

    public Bitmap get(String s)
    {
        if (!cache.containsKey(s))
        {
            return null;
        } else
        {
            return (Bitmap)((SoftReference)cache.get(s)).get();
        }
    }

    public void put(String s, Bitmap bitmap)
    {
        cache.put(s, new SoftReference(bitmap));
    }
}
