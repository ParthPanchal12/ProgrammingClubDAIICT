// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.db;


public class ColumnData
{
    public static final class ColumnType extends Enum
    {

        public static final ColumnType INTEGER;
        public static final ColumnType REAL;
        public static final ColumnType TEXT;
        public static final ColumnType VARCHAR;
        private static final ColumnType a[];

        public static ColumnType valueOf(String s)
        {
            return (ColumnType)Enum.valueOf(com/inmobi/commons/db/ColumnData$ColumnType, s);
        }

        public static ColumnType[] values()
        {
            return (ColumnType[])a.clone();
        }

        static 
        {
            INTEGER = new ColumnType("INTEGER", 0);
            VARCHAR = new ColumnType("VARCHAR", 1);
            REAL = new ColumnType("REAL", 2);
            TEXT = new ColumnType("TEXT", 3);
            a = (new ColumnType[] {
                INTEGER, VARCHAR, REAL, TEXT
            });
        }

        private ColumnType(String s, int i)
        {
            super(s, i);
        }
    }


    private boolean a;
    private boolean b;
    private boolean c;
    private ColumnType d;

    public ColumnData()
    {
        a = false;
        b = false;
        c = false;
    }

    public ColumnType getDataType()
    {
        return d;
    }

    public boolean isAutoIncrement()
    {
        return b;
    }

    public boolean isMandatory()
    {
        return c;
    }

    public boolean isPrimaryKey()
    {
        return a;
    }

    public void setAutoIncrement(boolean flag)
    {
        b = flag;
    }

    public void setDataType(ColumnType columntype)
    {
        d = columntype;
    }

    public void setMandatory(boolean flag)
    {
        c = flag;
    }

    public void setPrimaryKey(boolean flag)
    {
        a = flag;
    }
}
