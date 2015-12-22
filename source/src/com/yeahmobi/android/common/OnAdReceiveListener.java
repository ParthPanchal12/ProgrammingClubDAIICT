// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;

import java.util.List;

public interface OnAdReceiveListener
{

    public abstract void onAdFail(String s);

    public abstract void onAdReceive(List list);
}
