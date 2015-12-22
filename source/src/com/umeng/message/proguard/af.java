// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.util.Log;

// Referenced classes of package com.umeng.message.proguard:
//            Y

public class af
{

    public static final String a = com/umeng/message/proguard/af.getName();
    public static final int b = 0x5265c00;

    public af()
    {
    }

    public static boolean a(long l, int i)
    {
        boolean flag;
        if ((System.currentTimeMillis() - l) / 0x5265c00L < (long)i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (Y.a)
        {
            Log.d(a, (new StringBuilder()).append("isUpToDate: ").append(flag).append("; oldTimestamp: ").append(l).append("; currentTimestamp").append(System.currentTimeMillis()).toString());
        }
        return flag;
    }

}
