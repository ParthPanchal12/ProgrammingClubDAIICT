// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.umeng.message.proguard:
//            M

static final class nit> extends M
{

    public void a()
    {
        if (!b())
        {
            for (int i = 0; i < c(); i++)
            {
                java.util.Entry entry = c(i);
                if (((c)entry.getKey()).n())
                {
                    entry.setValue(Collections.unmodifiableList((List)entry.getValue()));
                }
            }

            Iterator iterator = e().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Entry entry1 = (java.util.Entry)iterator.next();
                if (((e)entry1.getKey()).n())
                {
                    entry1.setValue(Collections.unmodifiableList((List)entry1.getValue()));
                }
            } while (true);
        }
        super.a();
    }

    public Object put(Object obj, Object obj1)
    {
        return super.a((bleList)obj, obj1);
    }

    (int i)
    {
        super(i, null);
    }
}
