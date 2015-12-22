// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.IOException;

// Referenced classes of package com.umeng.message.proguard:
//            N

private static final class <init>
{

    private final Appendable a;
    private final StringBuilder b;
    private boolean c;

    private void a(CharSequence charsequence, int i)
        throws IOException
    {
        if (i == 0)
        {
            return;
        }
        if (c)
        {
            c = false;
            a.append(b);
        }
        a.append(charsequence);
    }

    public void a()
    {
        b.append("  ");
    }

    public void a(CharSequence charsequence)
        throws IOException
    {
        int j = 0;
        int l = charsequence.length();
        for (int i = 0; i < l;)
        {
            int k = j;
            if (charsequence.charAt(i) == '\n')
            {
                a(charsequence.subSequence(j, l), (i - j) + 1);
                k = i + 1;
                c = true;
            }
            i++;
            j = k;
        }

        a(charsequence.subSequence(j, l), l - j);
    }

    public void b()
    {
        int i = b.length();
        if (i == 0)
        {
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        } else
        {
            b.delete(i - 2, i);
            return;
        }
    }

    private ion(Appendable appendable)
    {
        b = new StringBuilder();
        c = true;
        a = appendable;
    }

    a(Appendable appendable, a a1)
    {
        this(appendable);
    }
}
