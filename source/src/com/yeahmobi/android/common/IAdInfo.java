// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common;


public interface IAdInfo
{

    public abstract String getCallToAction();

    public abstract String getClickDestinationUrl();

    public abstract String getClickRecordUrl();

    public abstract String getConversionTrackUrl();

    public abstract String getIconImageUrl();

    public abstract long getId();

    public abstract String getImpressionTrackUrl();

    public abstract String getMainImageUrl();

    public abstract String getPackageName();

    public abstract String getText();

    public abstract String getTitle();

    public abstract boolean preload();
}
