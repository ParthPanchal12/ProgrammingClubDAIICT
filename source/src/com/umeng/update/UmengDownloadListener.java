// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;


public interface UmengDownloadListener
{

    public abstract void OnDownloadEnd(int i, String s);

    public abstract void OnDownloadStart();

    public abstract void OnDownloadUpdate(int i);
}
