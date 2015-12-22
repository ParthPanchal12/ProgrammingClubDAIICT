// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;


// Referenced classes of package com.umeng.message.proguard:
//            x, F

public final class I
{
    public static final class a extends RuntimeException
    {

        private static final long a = 0x4be86cb6ba5b1c4aL;

        public a()
        {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }


    private I()
    {
    }

    public static F a(F f)
    {
        return f;
    }

    public static F a(F f, Class class1, x x1)
    {
        return new F(class1, x1, f) {

            final Class a;
            final x b;
            final F c;

            public void a(x x2)
            {
                x x3 = (x)a.cast(x2);
                x2 = x3;
_L2:
                c.a(x2);
                return;
                ClassCastException classcastexception;
                classcastexception;
                x2 = I.a(b, x2);
                if (true) goto _L2; else goto _L1
_L1:
            }

            public volatile void a(Object obj)
            {
                a((x)obj);
            }

            
            {
                a = class1;
                b = x1;
                c = f;
                super();
            }
        };
    }

    static x a(x x1, x x2)
    {
        return b(x1, x2);
    }

    public static F b(F f)
    {
        return new F(f) {

            final F a;
            private boolean b;

            public void a(Object obj)
            {
                this;
                JVM INSTR monitorenter ;
                if (b)
                {
                    throw new a();
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

            
            {
                a = f;
                super();
                b = false;
            }
        };
    }

    private static x b(x x1, x x2)
    {
        return x1.N().c(x2).ak();
    }
}
