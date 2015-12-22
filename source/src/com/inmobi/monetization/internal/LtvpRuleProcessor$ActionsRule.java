// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;


// Referenced classes of package com.inmobi.monetization.internal:
//            LtvpRuleProcessor

public static final class a extends Enum
{

    public static final ACTIONS_ONLY ACTIONS_ONLY;
    public static final ACTIONS_ONLY ACTIONS_TO_MEDIATION;
    public static final ACTIONS_ONLY MEDIATION;
    public static final ACTIONS_ONLY NO_ADS;
    private static final ACTIONS_ONLY b[];
    int a;

    static a a(int i)
    {
        switch (i)
        {
        default:
            return MEDIATION;

        case 1: // '\001'
            return NO_ADS;

        case 2: // '\002'
            return ACTIONS_TO_MEDIATION;

        case 3: // '\003'
            return ACTIONS_ONLY;
        }
    }

    public static ACTIONS_ONLY valueOf(String s)
    {
        return (ACTIONS_ONLY)Enum.valueOf(com/inmobi/monetization/internal/LtvpRuleProcessor$ActionsRule, s);
    }

    public static ACTIONS_ONLY[] values()
    {
        return (ACTIONS_ONLY[])b.clone();
    }

    public int getValue()
    {
        return a;
    }

    static 
    {
        MEDIATION = new <init>("MEDIATION", 0, 0);
        NO_ADS = new <init>("NO_ADS", 1, 1);
        ACTIONS_TO_MEDIATION = new <init>("ACTIONS_TO_MEDIATION", 2, 2);
        ACTIONS_ONLY = new <init>("ACTIONS_ONLY", 3, 3);
        b = (new b[] {
            MEDIATION, NO_ADS, ACTIONS_TO_MEDIATION, ACTIONS_ONLY
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
