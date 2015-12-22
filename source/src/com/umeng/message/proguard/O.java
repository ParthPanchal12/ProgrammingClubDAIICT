// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            s, y

public class O extends RuntimeException
{

    private static final long a = 0x986022c4d65db14dL;
    private final List b;

    public O(y y)
    {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        b = null;
    }

    public O(List list)
    {
        super(a(list));
        b = list;
    }

    private static String a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder("Message missing required fields: ");
        list = list.iterator();
        boolean flag = true;
        while (list.hasNext()) 
        {
            String s1 = (String)list.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(s1);
        }
        return stringbuilder.toString();
    }

    public List a()
    {
        return Collections.unmodifiableList(b);
    }

    public s b()
    {
        return new s(getMessage());
    }
}
