// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.annotation.sqlite;

import java.lang.annotation.Annotation;

public interface Id
    extends Annotation
{

    public abstract String column();
}
