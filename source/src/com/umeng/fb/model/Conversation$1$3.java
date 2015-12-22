// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.model;

import android.os.Handler;
import com.umeng.fb.SyncListener;
import com.umeng.fb.net.a;
import com.umeng.fb.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.umeng.fb.model:
//            Reply, Conversation

class a
    implements Runnable
{

    final Reply a;
    final b b;

    public void run()
    {
        a.status = "not_sent";
        com.umeng.fb.model.Conversation.a(b.b);
    }

    b(b b1, Reply reply)
    {
        b = b1;
        a = reply;
        super();
    }

    // Unreferenced inner class com/umeng/fb/model/Conversation$1

/* anonymous class */
    class Conversation._cls1
        implements Runnable
    {

        final Handler a;
        final SyncListener b;
        final Conversation c;

        public void run()
        {
            ArrayList arraylist;
            ArrayList arraylist1;
            int i;
            long l;
            arraylist = new ArrayList();
            arraylist1 = new ArrayList();
            l = 0L;
            i = 0;
_L2:
            Reply reply;
            long l1;
label0:
            {
                if (i >= c.getReplyList().size())
                {
                    break MISSING_BLOCK_LABEL_358;
                }
                reply = (Reply)c.getReplyList().get(i);
                if (!"user_reply".equals(reply.type) && !"new_feedback".equals(reply.type))
                {
                    break; /* Loop/switch isn't completed */
                }
                if (!"not_sent".equals(reply.status))
                {
                    l1 = l;
                    if (!"will_sent".equals(reply.status))
                    {
                        break label0;
                    }
                }
                reply.status = "sending";
                arraylist.add(reply);
                a.post(new Conversation._cls1._cls1());
                Map map;
                if ("new_feedback".equals(reply.type))
                {
                    map = (new a(Conversation.c(c))).b(Conversation.b(c), reply);
                } else
                {
                    map = (new a(Conversation.c(c))).a(Conversation.b(c), reply);
                }
                Log.c(com.umeng.fb.model.Conversation.a(), (new StringBuilder()).append("result - ").append(map).toString());
                if (map != null && map.size() == 2)
                {
                    a.post(new Conversation._cls1._cls2(reply, map));
                    l1 = l;
                } else
                {
                    a.post(new Conversation._cls1._cls3(this, reply));
                    l1 = l;
                }
            }
_L3:
            i++;
            l = l1;
            if (true) goto _L2; else goto _L1
_L1:
            l1 = l;
            if ("dev_reply".equals(reply.type))
            {
                l1 = l;
                if (l <= reply.created_at)
                {
                    l1 = reply.created_at;
                }
            }
              goto _L3
            if (true) goto _L2; else goto _L4
_L4:
            try
            {
                Iterator iterator = (new a(Conversation.c(c))).a(Conversation.b(c), l).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Reply reply1 = (Reply)iterator.next();
                    if ("dev_reply".equals(reply1.type) && !com.umeng.fb.model.Conversation.a(c, reply1))
                    {
                        arraylist1.add(reply1);
                    }
                } while (true);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return;
            }
            a.post(new Conversation._cls1._cls4(arraylist1, arraylist));
            return;
        }

            
            {
                c = conversation;
                a = handler;
                b = synclistener;
                super();
            }

        // Unreferenced inner class com/umeng/fb/model/Conversation$1$1

/* anonymous class */
        class Conversation._cls1._cls1
            implements Runnable
        {

            final Conversation._cls1 a;

            public void run()
            {
                com.umeng.fb.model.Conversation.a(a.c);
            }

                    
                    {
                        a = Conversation._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/umeng/fb/model/Conversation$1$2

/* anonymous class */
        class Conversation._cls1._cls2
            implements Runnable
        {

            final Reply a;
            final Map b;
            final Conversation._cls1 c;

            public void run()
            {
                a.created_at = ((Long)b.get("created_at")).longValue();
                a.status = "sent";
                com.umeng.fb.model.Conversation.a(c.c);
            }

                    
                    {
                        c = Conversation._cls1.this;
                        a = reply;
                        b = map;
                        super();
                    }
        }


        // Unreferenced inner class com/umeng/fb/model/Conversation$1$4

/* anonymous class */
        class Conversation._cls1._cls4
            implements Runnable
        {

            final List a;
            final List b;
            final Conversation._cls1 c;

            public void run()
            {
                Conversation.d(c.c).addAll(a);
                Collections.sort(Conversation.d(c.c));
                com.umeng.fb.model.Conversation.a(c.c);
                if (c.b != null)
                {
                    c.b.onReceiveDevReply(a);
                    c.b.onSendUserReply(b);
                }
            }

                    
                    {
                        c = Conversation._cls1.this;
                        a = list;
                        b = list1;
                        super();
                    }
        }

    }

}
