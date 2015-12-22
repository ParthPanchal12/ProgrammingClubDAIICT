// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


public final class EducationType extends Enum
{

    public static final EducationType COLLEGEORGRADUATE;
    public static final EducationType HIGHSCHOOLORLESS;
    public static final EducationType POSTGRADUATEORABOVE;
    public static final EducationType UNKNOWN;
    private static final EducationType a[];

    private EducationType(String s, int i)
    {
        super(s, i);
    }

    public static EducationType valueOf(String s)
    {
        return (EducationType)Enum.valueOf(com/inmobi/commons/EducationType, s);
    }

    public static EducationType[] values()
    {
        return (EducationType[])a.clone();
    }

    static 
    {
        HIGHSCHOOLORLESS = new EducationType("HIGHSCHOOLORLESS", 0);
        COLLEGEORGRADUATE = new EducationType("COLLEGEORGRADUATE", 1);
        POSTGRADUATEORABOVE = new EducationType("POSTGRADUATEORABOVE", 2);
        UNKNOWN = new EducationType("UNKNOWN", 3);
        a = (new EducationType[] {
            HIGHSCHOOLORLESS, COLLEGEORGRADUATE, POSTGRADUATEORABOVE, UNKNOWN
        });
    }
}
