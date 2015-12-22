// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MathUtils
{

    public MathUtils()
    {
    }

    public static String numberFormat(Number number, int i)
    {
        NumberFormat numberformat = NumberFormat.getInstance();
        numberformat.setMaximumFractionDigits(i);
        return numberformat.format(number);
    }

    public static String numberFormat2(Number number, int i)
    {
        StringBuilder stringbuilder = new StringBuilder("#");
        if (i > 0)
        {
            stringbuilder.append(".");
            for (int j = 0; j < i; j++)
            {
                stringbuilder.append("0");
            }

        }
        return (new DecimalFormat(stringbuilder.toString())).format(number);
    }
}
