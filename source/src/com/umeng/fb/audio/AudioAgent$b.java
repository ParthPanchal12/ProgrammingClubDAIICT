// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.audio;

import com.umeng.fb.util.Log;

// Referenced classes of package com.umeng.fb.audio:
//            AudioAgent, a

class a
    implements Runnable
{

    final AudioAgent a;

    public void run()
    {
        try
        {
            if (AudioAgent.a(a) != null)
            {
                AudioAgent.a(a).a();
            }
            return;
        }
        catch (Exception exception)
        {
            Log.b(AudioAgent.b(a), exception.getMessage());
        }
    }

    (AudioAgent audioagent)
    {
        a = audioagent;
        super();
    }
}
