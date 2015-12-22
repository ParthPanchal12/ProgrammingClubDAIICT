// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.model;

import android.os.AsyncTask;
import com.umeng.fb.net.a;
import com.umeng.fb.util.Log;

// Referenced classes of package com.umeng.fb.model:
//            Conversation, Store

class b extends AsyncTask
{

    final Conversation a;
    private Runnable b;

    protected transient Boolean a(Void avoid[])
    {
        avoid = new a(Conversation.c(a));
        String s = avoid.a();
        if (s == null || "".equals(s))
        {
            avoid.a();
        }
        return Boolean.valueOf(true);
    }

    protected void a(Boolean boolean1)
    {
        boolean1 = Store.getInstance(Conversation.c(a)).getUid();
        if (boolean1 != null && !"".equals(boolean1))
        {
            (new Thread(b)).start();
            return;
        } else
        {
            Log.c(com.umeng.fb.model.Conversation.a(), "get uid fail");
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    public (Conversation conversation, Runnable runnable)
    {
        a = conversation;
        super();
        b = runnable;
    }
}
