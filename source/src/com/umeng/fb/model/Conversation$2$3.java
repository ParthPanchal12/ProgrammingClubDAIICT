// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.model;

import android.os.Handler;
import com.umeng.fb.net.a;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.umeng.fb.model:
//            Reply, Conversation

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.status = "not_sent";
        com.umeng.fb.model.Conversation.a(a.a);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/umeng/fb/model/Conversation$2

/* anonymous class */
    class Conversation._cls2
        implements Runnable
    {

        final Reply a;
        final Handler b;
        final String c;
        final Conversation d;

        public void run()
        {
            a.status = "sending";
            b.post(new Conversation._cls2._cls1());
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
                b.post(new Conversation._cls2._cls2(map));
                return;
            } else
            {
                b.post(new Conversation._cls2._cls3(this));
                return;
            }
        }

            
            {
                d = conversation;
                a = reply;
                b = handler;
                c = s;
                super();
            }

        // Unreferenced inner class com/umeng/fb/model/Conversation$2$1

/* anonymous class */
        class Conversation._cls2._cls1
            implements Runnable
        {

            final Conversation._cls2 a;

            public void run()
            {
                com.umeng.fb.model.Conversation.a(a.d);
            }

                    
                    {
                        a = Conversation._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/umeng/fb/model/Conversation$2$2

/* anonymous class */
        class Conversation._cls2._cls2
            implements Runnable
        {

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
        }

    }

}
