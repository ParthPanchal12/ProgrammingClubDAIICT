// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;

// Referenced classes of package com.umeng.message.proguard:
//            bh, bf

public interface bi
{

    public static final int h = 307;
    public static final int i = 504;
    public static final int j = 404;
    public static final int k = 408;

    public abstract void addHeader(String s, String s1);

    public abstract void close();

    public abstract void connect(Context context, String s, long l, bh bh);

    public abstract void disconnect(int l);

    public abstract bf readyState();
}
