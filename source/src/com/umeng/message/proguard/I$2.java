// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            F, I

static final class b
    implements F
{

    final F a;
    private boolean b;

    public void a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (b)
        {
            throw new <init>();
        }
        break MISSING_BLOCK_LABEL_22;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        b = true;
        this;
        JVM INSTR monitorexit ;
        a.a(obj);
        return;
    }

    (F f)
    {
        a = f;
        super();
        b = false;
    }
}
