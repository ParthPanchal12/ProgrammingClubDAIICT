// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.upd;

import android.os.AsyncTask;

// Referenced classes of package u.upd:
//            g, f, b, e

public class d extends g
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(f.a a1);
    }

    private class b extends AsyncTask
    {

        final d a;
        private e b;
        private a c;

        protected transient f.a a(Integer ainteger[])
        {
            return a.a(b);
        }

        protected void a(f.a a1)
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
            a((f.a)obj);
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
            a = d.this;
            super();
            b = e;
            c = a1;
        }
    }


    private static final String a = u/upd/d.getName();

    public d()
    {
    }

    public f.a a(e e)
    {
        e = (f)a(((h) (e)), u/upd/f);
        if (e == null)
        {
            return f.a.b;
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
            a1.a(f.a.b);
            return;
        }
          goto _L1
    }

}
