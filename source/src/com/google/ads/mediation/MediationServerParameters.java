// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import com.google.ads.util.b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class MediationServerParameters
{
    public static class MappingException extends Exception
    {

        public MappingException(String s)
        {
            super(s);
        }
    }

    protected static interface Parameter
        extends Annotation
    {

        public abstract String name();

        public abstract boolean required();
    }


    public MediationServerParameters()
    {
    }

    protected void a()
    {
    }

    public void load(Map map)
        throws MappingException
    {
        Object obj = new HashMap();
        Field afield[] = getClass().getFields();
        int j = afield.length;
        for (int i = 0; i < j; i++)
        {
            Field field1 = afield[i];
            Parameter parameter = (Parameter)field1.getAnnotation(com/google/ads/mediation/MediationServerParameters$Parameter);
            if (parameter != null)
            {
                ((Map) (obj)).put(parameter.name(), field1);
            }
        }

        if (((Map) (obj)).isEmpty())
        {
            b.e("No server options fields detected.  To suppress this message either add a field with the @Parameter annotation, or override the load() method");
        }
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            Field field2 = (Field)((Map) (obj)).remove(entry.getKey());
            if (field2 != null)
            {
                try
                {
                    field2.set(this, entry.getValue());
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    b.b((new StringBuilder()).append("Server Option '").append((String)entry.getKey()).append("' could not be set: Illegal Access").toString());
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    b.b((new StringBuilder()).append("Server Option '").append((String)entry.getKey()).append("' could not be set: Bad Type").toString());
                }
            } else
            {
                b.e((new StringBuilder()).append("Unexpected Server Option: ").append((String)entry.getKey()).append(" = '").append((String)entry.getValue()).append("'").toString());
            }
        }

        map = null;
        obj = ((Map) (obj)).values().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Field field = (Field)((Iterator) (obj)).next();
            if (((Parameter)field.getAnnotation(com/google/ads/mediation/MediationServerParameters$Parameter)).required())
            {
                b.b((new StringBuilder()).append("Required Server Option missing: ").append(((Parameter)field.getAnnotation(com/google/ads/mediation/MediationServerParameters$Parameter)).name()).toString());
                StringBuilder stringbuilder = new StringBuilder();
                if (map == null)
                {
                    map = "";
                } else
                {
                    map = (new StringBuilder()).append(map).append(", ").toString();
                }
                map = stringbuilder.append(map).append(((Parameter)field.getAnnotation(com/google/ads/mediation/MediationServerParameters$Parameter)).name()).toString();
            }
        } while (true);
        if (map != null)
        {
            throw new MappingException((new StringBuilder()).append("Required Server Option(s) missing: ").append(map).toString());
        } else
        {
            a();
            return;
        }
    }
}
