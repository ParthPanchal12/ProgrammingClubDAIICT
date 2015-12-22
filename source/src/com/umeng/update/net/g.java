// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.os.AsyncTask;
import u.upd.b;
import u.upd.e;
import u.upd.f;

public class g extends u.upd.g
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(u.upd.f.a a1);
    }

    private class b extends AsyncTask
    {

        final g a;
        private e b;
        private a c;

        protected transient u.upd.f.a a(Integer ainteger[])
        {
            return a.a(b);
        }

        protected void a(u.upd.f.a a1)
        {
            if (c != null)
            {
                c.a(a1);
            }
        }

        protected transient Object doInBackground(Object aobj[])
        {
            return a((Integer[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((u.upd.f.a)obj);
        }

        protected void onPreExecute()
        {
            if (c != null)
            {
                c.a();
            }
        }

        public b(e e, a a1)
        {
            a = g.this;
            super();
            b = e;
            c = a1;
        }
    }


    private static final String a = com/umeng/update/net/g.getName();

    public g()
    {
    }

    public u.upd.f.a a(e e)
    {
        e = (f)a(((u.upd.h) (e)), u/upd/f);
        if (e == null)
        {
            return u.upd.f.a.b;
        } else
        {
            return ((f) (e)).a;
        }
    }

    public void a(e e, a a1)
    {
        (new b(e, a1)).execute(new Integer[0]);
_L1:
        return;
        e;
        u.upd.b.b(a, "", e);
        if (a1 != null)
        {
            a1.a(u.upd.f.a.b);
            return;
        }
          goto _L1
    }

}
