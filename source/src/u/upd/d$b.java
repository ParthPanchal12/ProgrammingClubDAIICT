// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.upd;

import android.os.AsyncTask;

// Referenced classes of package u.upd:
//            d, e

private class c extends AsyncTask
{

    final d a;
    private e b;
    private a c;

    protected transient Integer a(Integer ainteger[])
    {
        return a.a(b);
    }

    protected void a(b b1)
    {
        if (c != null)
        {
            c.a(b1);
        }
    }

    protected transient Object doInBackground(Object aobj[])
    {
        return a((Integer[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((a)obj);
    }

    protected void onPreExecute()
    {
        if (c != null)
        {
            c.a();
        }
    }

    public Object(d d1, e e, Object obj)
    {
        a = d1;
        super();
        b = e;
        c = obj;
    }
}
