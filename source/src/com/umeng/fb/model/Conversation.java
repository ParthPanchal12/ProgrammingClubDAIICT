// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.model;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import com.umeng.fb.SyncListener;
import com.umeng.fb.net.a;
import com.umeng.fb.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.umeng.fb.model:
//            Reply, Store

public class Conversation
{
    class GetUidTask extends AsyncTask
    {

        final Conversation a;
        private Runnable b;

        protected transient Boolean a(Void avoid[])
        {
            avoid = new a(Conversation.c(a));
            String s = avoid.a();
            if (s == null || "".equals(s))
            {
                avoid.a();
            }
            return Boolean.valueOf(true);
        }

        protected void a(Boolean boolean1)
        {
            boolean1 = Store.getInstance(Conversation.c(a)).getUid();
            if (boolean1 != null && !"".equals(boolean1))
            {
                (new Thread(b)).start();
                return;
            } else
            {
                Log.c(com.umeng.fb.model.Conversation.a(), "get uid fail");
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Boolean)obj);
        }

        public GetUidTask(Runnable runnable)
        {
            a = Conversation.this;
            super();
            b = runnable;
        }
    }

    public static interface OnChangeListener
    {

        public abstract void onChange();
    }


    private static final String a = com/umeng/fb/model/Conversation.getName();
    private List b;
    private Context c;
    private String d;
    private boolean e;
    private OnChangeListener f;

    private Conversation(Context context)
    {
        b = new ArrayList();
        e = false;
        c = context.getApplicationContext();
    }

    protected static Conversation a(Context context, JSONArray jsonarray, String s)
        throws JSONException
    {
        context = new Conversation(context);
        for (int i = 0; i < jsonarray.length(); i++)
        {
            Reply reply = Reply.fromJson(jsonarray.getJSONObject(i));
            ((Conversation) (context)).b.add(reply);
            if ("new_feedback".equals(reply.type))
            {
                context.e = true;
            }
        }

        context.d = s;
        Collections.sort(((Conversation) (context)).b);
        Log.c(a, (new StringBuilder()).append("fromJson: json = ").append(jsonarray.toString()).append("\n").append("fromJson: conversation = ").append(context.toString()).toString());
        return context;
    }

    static String a()
    {
        return a;
    }

    static void a(Conversation conversation)
    {
        conversation.b();
    }

    static boolean a(Conversation conversation, Reply reply)
    {
        return conversation.a(reply);
    }

    private boolean a(Reply reply)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            Reply reply1 = (Reply)iterator.next();
            if (!TextUtils.isEmpty(reply1.reply_id) && "dev_reply".equals(reply1.type) && (reply1.reply_id.equals(reply.reply_id) || reply1.reply_id.equals((new StringBuilder()).append("RP").append(reply.created_at).append("1111").toString())))
            {
                return true;
            }
        }

        return false;
    }

    static String b(Conversation conversation)
    {
        return conversation.d;
    }

    private void b()
    {
        Log.c(a, (new StringBuilder()).append("onChange: ").append(toString()).toString());
        Store.getInstance(c).saveConversation(d, this);
        if (f != null)
        {
            f.onChange();
        }
    }

    static Context c(Conversation conversation)
    {
        return conversation.c;
    }

    private static String c()
    {
        return (new StringBuilder()).append("R").append(UUID.randomUUID().toString()).toString();
    }

    private static String d()
    {
        return (new StringBuilder()).append("C").append(UUID.randomUUID().toString()).toString();
    }

    static List d(Conversation conversation)
    {
        return conversation.b;
    }

    public static Conversation newInstance(Context context)
    {
        return newInstance(context, d());
    }

    public static Conversation newInstance(Context context, String s)
    {
        Conversation conversation = new Conversation(context);
        conversation.b = new ArrayList();
        conversation.d = s;
        Store.getInstance(context).saveConversation(conversation.d, conversation);
        return conversation;
    }

    public void addReply(Reply reply)
    {
        b.add(reply);
        b();
    }

    public void addUserReply(String s)
    {
        addUserReply(s, c(), "text_reply", -1F);
    }

    public void addUserReply(String s, String s1, String s2, float f1)
    {
        if (e || b.size() > 0)
        {
            s = new Reply(s, s1, "user_reply", (new Date()).getTime(), s2, f1);
        } else
        {
            s = new Reply(s, s1, "new_feedback", (new Date()).getTime(), s2, f1);
            e = true;
        }
        s.status = "will_sent";
        addReply(s);
    }

    public String getId()
    {
        return d;
    }

    public List getReplyList()
    {
        return b;
    }

    public void sendReplyOnlyOne(String s, Reply reply)
    {
        s = new Runnable(reply, new Handler(), s) {

            final Reply a;
            final Handler b;
            final String c;
            final Conversation d;

            public void run()
            {
                a.status = "sending";
                b.post(new Runnable(this) {

                    final _cls2 a;

                    public void run()
                    {
                        com.umeng.fb.model.Conversation.a(a.d);
                    }

            
            {
                a = _pcls2;
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
                    b.post(new Runnable(this, map) {

                        final Map a;
                        final _cls2 b;

                        public void run()
                        {
                            b.a.created_at = ((Long)a.get("created_at")).longValue();
                            b.a.status = "sent";
                            Collections.sort(Conversation.d(b.d));
                            com.umeng.fb.model.Conversation.a(b.d);
                        }

            
            {
                b = _pcls2;
                a = map;
                super();
            }
                    });
                    return;
                } else
                {
                    b.post(new Runnable(this) {

                        final _cls2 a;

                        public void run()
                        {
                            a.a.status = "not_sent";
                            com.umeng.fb.model.Conversation.a(a.d);
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                d = Conversation.this;
                a = reply;
                b = handler;
                c = s;
                super();
            }
        };
        reply = Store.getInstance(c).getUid();
        if (reply == null || "".equals(reply))
        {
            (new GetUidTask(s)).execute(new Void[0]);
            return;
        } else
        {
            (new Thread(s)).start();
            return;
        }
    }

    public void setOnChangeListener(OnChangeListener onchangelistener)
    {
        f = onchangelistener;
    }

    public void sync(SyncListener synclistener)
    {
        if (getReplyList().size() == 0)
        {
            return;
        }
        Log.c(a, (new StringBuilder()).append("sync id=").append(d).append(":\t ").append(this).toString());
        synclistener = new Runnable(new Handler(), synclistener) {

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
                    a.post(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            com.umeng.fb.model.Conversation.a(a.c);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
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
                        a.post(new Runnable(this, reply, map) {

                            final Reply a;
                            final Map b;
                            final _cls1 c;

                            public void run()
                            {
                                a.created_at = ((Long)b.get("created_at")).longValue();
                                a.status = "sent";
                                com.umeng.fb.model.Conversation.a(c.c);
                            }

            
            {
                c = _pcls1;
                a = reply;
                b = map;
                super();
            }
                        });
                        l1 = l;
                    } else
                    {
                        a.post(new Runnable(this, reply) {

                            final Reply a;
                            final _cls1 b;

                            public void run()
                            {
                                a.status = "not_sent";
                                com.umeng.fb.model.Conversation.a(b.c);
                            }

            
            {
                b = _pcls1;
                a = reply;
                super();
            }
                        });
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
                a.post(new Runnable(this, arraylist1, arraylist) {

                    final List a;
                    final List b;
                    final _cls1 c;

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
                c = _pcls1;
                a = list;
                b = list1;
                super();
            }
                });
                return;
            }

            
            {
                c = Conversation.this;
                a = handler;
                b = synclistener;
                super();
            }
        };
        String s = Store.getInstance(c).getUid();
        if (s == null || "".equals(s))
        {
            (new GetUidTask(synclistener)).execute(new Void[0]);
            return;
        } else
        {
            (new Thread(synclistener)).start();
            return;
        }
    }

    public JSONArray toJson()
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = b.iterator(); iterator.hasNext(); jsonarray.put(((Reply)iterator.next()).toJson())) { }
        return jsonarray;
    }

    public String toString()
    {
        return toJson().toString();
    }

}
