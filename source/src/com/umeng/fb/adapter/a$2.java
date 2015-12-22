// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.adapter;

import android.view.View;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;

// Referenced classes of package com.umeng.fb.adapter:
//            a

class a
    implements android.view..OnClickListener
{

    final Reply a;
    final a b;

    public void onClick(View view)
    {
        com.umeng.fb.adapter.a.a(b).sendReplyOnlyOne(com.umeng.fb.adapter.a.a(b).getId(), a);
    }

    sation(a a1, Reply reply)
    {
        b = a1;
        a = reply;
        super();
    }
}
