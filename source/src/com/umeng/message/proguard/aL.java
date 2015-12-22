// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;

public interface aL
{

    public static final int a = 0x1051b9cd;

    public abstract void commitEvent(int i, Object obj);

    public abstract void commitEvent(int i, Object obj, Object obj1);

    public abstract void commitEvent(int i, Object obj, Object obj1, Object obj2);

    public transient abstract void commitEvent(int i, Object obj, Object obj1, Object obj2, String as[]);

    public abstract String getUtdId(Context context);

    public abstract void onCaughException(Throwable throwable);

    public abstract void start(Context context, String s, String s1, String s2);

    public abstract void stop(Context context);
}
