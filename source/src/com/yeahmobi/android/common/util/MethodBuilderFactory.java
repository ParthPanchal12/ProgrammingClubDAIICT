// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;


public class MethodBuilderFactory
{

    protected static MethodBuilderFactory instance = new MethodBuilderFactory();

    public MethodBuilderFactory()
    {
    }

    public static Reflection.MethodBuilder create(Object obj, String s)
    {
        return instance.internalCreate(obj, s);
    }

    public static void setInstance(MethodBuilderFactory methodbuilderfactory)
    {
        instance = methodbuilderfactory;
    }

    protected Reflection.MethodBuilder internalCreate(Object obj, String s)
    {
        return new Reflection.MethodBuilder(obj, s);
    }

}
