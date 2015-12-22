// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.audio;

import android.os.AsyncTask;
import com.umeng.fb.util.Log;
import com.umeng.fb.util.c;

// Referenced classes of package com.umeng.fb.audio:
//            c

class  extends AsyncTask
{

    final com.umeng.fb.audio.c a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private a h;

    protected transient Integer a(Void avoid[])
    {
        int i = 0;
        a[h.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 45
    //                   2 67
    //                   3 86;
           goto _L1 _L2 _L3 _L4
_L1:
        return Integer.valueOf(i);
_L2:
        com.umeng.fb.audio.c.a(a, b, c, g);
        continue; /* Loop/switch isn't completed */
_L3:
        i = com.umeng.fb.audio.c.a(a, c, e);
        continue; /* Loop/switch isn't completed */
_L4:
        i = a.a(e, d);
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void a(Integer integer)
    {
        switch (a[h.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            com.umeng.fb.audio.c.a(a, f, integer.intValue());
            return;

        case 2: // '\002'
            com.umeng.fb.audio.c.a(a, c, e, f, integer.intValue());
            return;

        case 3: // '\003'
            com.umeng.fb.audio.c.b(a, d, integer.intValue());
            break;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Integer)obj);
    }

    public (com.umeng.fb.audio.c c1, String s, int i,  )
    {
        a = c1;
        super();
        b = (new StringBuilder()).append(com.umeng.fb.util.c.c(com.umeng.fb.audio.c.a(c1))).append(s).append(".raw").toString();
        c = (new StringBuilder()).append(com.umeng.fb.util.c.c(com.umeng.fb.audio.c.a(c1))).append(s).append(".wav").toString();
        d = (new StringBuilder()).append(com.umeng.fb.util.c.c(com.umeng.fb.audio.c.a(c1))).append(s).append("cache.wav").toString();
        e = (new StringBuilder()).append(com.umeng.fb.util.c.b(com.umeng.fb.audio.c.a(c1))).append(s).append(".opus").toString();
        f = s;
        g = i;
        h = ;
        com.umeng.fb.audio.c.b(c1);
        Log.c(com.umeng.fb.audio.c.c(c1), "TranscodeTask create task");
    }
}
