// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.push;

import android.content.Intent;

// Referenced classes of package com.umeng.fb.push:
//            FBMessage

public interface c
{
    public static interface a
    {

        public abstract void onAddPushDevReply();
    }


    public abstract void clearPushInfo();

    public abstract boolean dealFBMessage(FBMessage fbmessage);

    public abstract void disable();

    public abstract void enable();

    public abstract void init(Class class1, boolean flag);

    public abstract void init(boolean flag);

    public abstract boolean onFBMessage(Intent intent);

    public abstract void setConversationId(String s);

    public abstract void setFBPushCallbacks(a a1);

    public abstract void setFbFragmentTag(boolean flag);
}
