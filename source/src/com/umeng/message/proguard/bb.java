// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class bb
{

    private static String b = "UTF-8";
    protected ConcurrentHashMap a;

    public bb()
    {
        d();
    }

    public bb(String s, String s1)
    {
        d();
        a(s, s1);
    }

    public bb(Map map)
    {
        d();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); a((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    private void d()
    {
        a = new ConcurrentHashMap();
    }

    public HttpEntity a()
    {
        UrlEncodedFormEntity urlencodedformentity;
        try
        {
            urlencodedformentity = new UrlEncodedFormEntity(b(), b);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
            return null;
        }
        return urlencodedformentity;
    }

    public void a(String s)
    {
        a.remove(s);
    }

    public void a(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            a.put(s, s1);
        }
    }

    protected List b()
    {
        LinkedList linkedlist = new LinkedList();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); linkedlist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return linkedlist;
    }

    public String c()
    {
        return URLEncodedUtils.format(b(), b);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append("=");
        }

        return stringbuilder.toString();
    }

}
