// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.umeng.message.proguard:
//            M

static final class eption
    implements Iterator
{

    public boolean hasNext()
    {
        return false;
    }

    public Object next()
    {
        throw new NoSuchElementException();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    eption()
    {
    }
}
