// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.content.Context;
import u.upd.b;

// Referenced classes of package com.umeng.update:
//            UmengUpdateAgent, b, UpdateResponse

static class a
    implements Runnable
{

    Context a;

    public void run()
    {
        Object obj = (new com.umeng.update.b(a)).b();
        if (obj == null)
        {
            try
            {
                UmengUpdateAgent.a(3, null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                UmengUpdateAgent.a(1, null);
                b.a("update", "request update error", ((Exception) (obj)));
                return;
            }
            catch (Error error)
            {
                b.a("update", (new StringBuilder("request update error")).append(error.getMessage()).toString());
            }
            break MISSING_BLOCK_LABEL_84;
        }
        if (!((UpdateResponse) (obj)).hasUpdate)
        {
            UmengUpdateAgent.a(1, ((UpdateResponse) (obj)));
            return;
        }
        UmengUpdateAgent.a(0, ((UpdateResponse) (obj)));
        return;
    }

    public (Context context)
    {
        a = context;
    }
}
