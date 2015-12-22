// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.audio;

import com.umeng.fb.util.Log;
import java.io.File;

// Referenced classes of package com.umeng.fb.audio:
//            AudioAgent, a

class a
    implements a
{

    final AudioAgent a;

    public void a(String s, int i)
    {
        if (!(new File(s)).exists())
        {
            return;
        }
        try
        {
            AudioAgent.a(a, new a(s));
            if (AudioAgent.c(a) == null)
            {
                AudioAgent.a(a, new Thread(new <init>(a)));
            }
            AudioAgent.c(a).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.b(AudioAgent.b(a), s.getMessage());
        }
    }

    (AudioAgent audioagent)
    {
        a = audioagent;
        super();
    }
}
