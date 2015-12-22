// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.model;

import android.os.Handler;
import com.umeng.fb.net.a;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.umeng.fb.model:
//            Conversation, Reply

class c
    implements Runnable
{

    final Reply a;
    final Handler b;
    final String c;
    final Conversation d;

    public void run()
    {
        a.status = "sending";
        b.post(new Runnable() {

            final Conversation._cls2 a;

            public void run()
            {
                com.umeng.fb.model.Conversation.a(a.d);
            }

            
            {
                a = Conversation._cls2.this;
                super();
            }
        });
        Map map;
        if ("user_reply".equals(a.type))
        {
            map = (new a(Conversation.c(d))).a(c, a);
        } else
        {
            map = (new a(Conversation.c(d))).b(c, a);
        }
        if (map != null && map.size() == 2)
        {
            b.post(new Runnable(map) {

                final Map a;
                final Conversation._cls2 b;

                public void run()
                {
                    b.a.created_at = ((Long)a.get("created_at")).longValue();
                    b.a.status = "sent";
                    Collections.sort(Conversation.d(b.d));
                    com.umeng.fb.model.Conversation.a(b.d);
                }

            
            {
                b = Conversation._cls2.this;
                a = map;
                super();
            }
            });
            return;
        } else
        {
            b.post(new Runnable() {

                final Conversation._cls2 a;

                public void run()
                {
                    a.a.status = "not_sent";
                    com.umeng.fb.model.Conversation.a(a.d);
                }

            
            {
                a = Conversation._cls2.this;
                super();
            }
            });
            return;
        }
    }

    _cls3.a(Conversation conversation, Reply reply, Handler handler, String s)
    {
        d = conversation;
        a = reply;
        b = handler;
        c = s;
        super();
    }
}
