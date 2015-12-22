// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.upd;

import org.json.JSONObject;

public abstract class h
{

    protected static String a = "POST";
    protected static String b = "GET";
    protected String c;

    public h(String s)
    {
        c = s;
    }

    public abstract JSONObject a();

    public void a(String s)
    {
        c = s;
    }

    public abstract String b();

    protected String c()
    {
        return a;
    }

    public String d()
    {
        return c;
    }

}
