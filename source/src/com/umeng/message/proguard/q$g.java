// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.umeng.message.proguard:
//            q, y, s

static final class c
    implements Serializable
{

    private static final long a = 0L;
    private String b;
    private byte c[];

    protected Object a()
        throws ObjectStreamException
    {
        Object obj;
        try
        {
            obj = (getException)Class.forName(b).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
            (() (obj)).c(c);
            obj = ((c) (obj)).al();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new RuntimeException("Unable to find proto buffer class", classnotfoundexception);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            throw new RuntimeException("Unable to find newBuilder method", nosuchmethodexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RuntimeException("Unable to call newBuilder method", illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new RuntimeException("Error calling newBuilder", invocationtargetexception.getCause());
        }
        catch (s s1)
        {
            throw new RuntimeException("Unable to understand proto buffer", s1);
        }
        return obj;
    }

    getException(y y1)
    {
        b = y1.getClass().getName();
        c = y1.g();
    }
}
