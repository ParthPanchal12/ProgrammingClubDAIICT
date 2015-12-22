// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import u.upd.b;

public class e
{

    private static final String a = "UMENG_RUNTIME_CACHE";
    private static final String b = com/umeng/update/net/e.getName();
    private final Context c;

    public e(Context context)
    {
        c = context;
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        SharedPreferences sharedpreferences;
        Iterator iterator;
        sharedpreferences = c.getSharedPreferences("UMENG_RUNTIME_CACHE", 0);
        iterator = sharedpreferences.getAll().keySet().iterator();
_L3:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        sharedpreferences.edit().clear().commit();
        return arraylist;
_L2:
        String s = (String)iterator.next();
        try
        {
            int i = Integer.parseInt(s);
            arraylist.add(Integer.valueOf(i));
            u.upd.b.a(b, (new StringBuilder("get nid [")).append(i).append("]").toString());
        }
        catch (NumberFormatException numberformatexception) { }
          goto _L3
        Exception exception;
        exception;
        return arraylist;
    }

    public void a(int i)
    {
        SharedPreferences sharedpreferences = c.getSharedPreferences("UMENG_RUNTIME_CACHE", 0);
        android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
        sharedpreferences;
        JVM INSTR monitorenter ;
        editor.putString((new StringBuilder()).append(i).toString(), "");
        editor.commit();
        sharedpreferences;
        JVM INSTR monitorexit ;
        Exception exception1;
        try
        {
            u.upd.b.a(b, (new StringBuilder("add nid [")).append(i).append("] to runtime cache.").toString());
            return;
        }
        catch (Exception exception)
        {
            return;
        }
        exception1;
        sharedpreferences;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public void b(int i)
    {
        try
        {
            Object obj = c.getSharedPreferences("UMENG_RUNTIME_CACHE", 0);
            if (((SharedPreferences) (obj)).contains((new StringBuilder()).append(i).toString()))
            {
                obj = ((SharedPreferences) (obj)).edit();
                ((android.content.SharedPreferences.Editor) (obj)).remove((new StringBuilder()).append(i).toString());
                ((android.content.SharedPreferences.Editor) (obj)).commit();
            }
            u.upd.b.a(b, (new StringBuilder("remove nid [")).append(i).append("] to runtime cache.").toString());
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public boolean b()
    {
        boolean flag = false;
        if (c.getSharedPreferences("UMENG_RUNTIME_CACHE", 0).getAll().size() > 0)
        {
            flag = true;
        }
        return flag;
    }

}
