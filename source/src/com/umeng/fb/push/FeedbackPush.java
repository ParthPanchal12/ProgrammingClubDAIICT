// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.push;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.umeng.fb.push:
//            c, b, a, FBMessage

public class FeedbackPush
    implements c
{

    private static FeedbackPush b;
    private final String a = com/umeng/fb/push/FeedbackPush.getName();
    private c c;

    private FeedbackPush(Context context)
    {
        if (a())
        {
            c = com.umeng.fb.push.b.a(context);
            return;
        } else
        {
            c = new a();
            return;
        }
    }

    private boolean a()
    {
        try
        {
            Class.forName("com.umeng.message.UmengService");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.d(a, "service not found: com.umeng.message.UmengService");
            return false;
        }
        return true;
    }

    public static FeedbackPush getInstance(Context context)
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        com/umeng/fb/push/FeedbackPush;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new FeedbackPush(context);
        }
        com/umeng/fb/push/FeedbackPush;
        JVM INSTR monitorexit ;
_L2:
        return b;
        context;
        com/umeng/fb/push/FeedbackPush;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void clearPushInfo()
    {
        c.clearPushInfo();
    }

    public boolean dealFBMessage(FBMessage fbmessage)
    {
        return c.dealFBMessage(fbmessage);
    }

    public void disable()
    {
        c.disable();
    }

    public void enable()
    {
        c.enable();
    }

    public void init(Class class1, boolean flag)
    {
        c.init(class1, flag);
    }

    public void init(boolean flag)
    {
        c.init(flag);
    }

    public boolean onFBMessage(Intent intent)
    {
        return c.onFBMessage(intent);
    }

    public void setConversationId(String s)
    {
        c.setConversationId(s);
    }

    public void setFBPushCallbacks(c.a a1)
    {
        c.setFBPushCallbacks(a1);
    }

    public void setFbFragmentTag(boolean flag)
    {
        c.setFbFragmentTag(flag);
    }
}
