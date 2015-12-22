// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.tag;

import com.umeng.common.message.Log;

// Referenced classes of package com.umeng.message.tag:
//            a

public class b
    implements a
{

    private static final String a = com/umeng/message/tag/b.getName();
    private static int b = 256;

    public b()
    {
    }

    public boolean a(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            return false;
        }
        if (s != null && s.length() > b)
        {
            Log.b(a, String.format("The length of %s exceeds allowed max length %i", new Object[] {
                s, Integer.valueOf(b)
            }));
            return false;
        } else
        {
            return true;
        }
    }

}
