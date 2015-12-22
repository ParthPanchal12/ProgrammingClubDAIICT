// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.db;


// Referenced classes of package com.inmobi.commons.db:
//            ColumnData

public static final class  extends Enum
{

    public static final TEXT INTEGER;
    public static final TEXT REAL;
    public static final TEXT TEXT;
    public static final TEXT VARCHAR;
    private static final TEXT a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/db/ColumnData$ColumnType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        INTEGER = new <init>("INTEGER", 0);
        VARCHAR = new <init>("VARCHAR", 1);
        REAL = new <init>("REAL", 2);
        TEXT = new <init>("TEXT", 3);
        a = (new a[] {
            INTEGER, VARCHAR, REAL, TEXT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
