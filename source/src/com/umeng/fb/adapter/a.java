// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.fb.audio.AudioAgent;
import com.umeng.fb.common.b;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;
import com.umeng.fb.res.c;
import com.umeng.fb.res.d;
import com.umeng.fb.res.e;
import com.umeng.fb.res.f;
import com.umeng.fb.res.g;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class com.umeng.fb.adapter.a extends BaseAdapter
{
    private class a extends b
    {

        View a;
        View b;
        TextView c;
        final com.umeng.fb.adapter.a d;

        private a()
        {
            d = com.umeng.fb.adapter.a.this;
            super();
        }

    }

    private class b
    {

        TextView e;
        View f;
        View g;
        ImageView h;
        final com.umeng.fb.adapter.a i;

        private b()
        {
            i = com.umeng.fb.adapter.a.this;
            super();
        }

    }

    private class c extends b
    {

        TextView a;
        final com.umeng.fb.adapter.a b;

        private c()
        {
            b = com.umeng.fb.adapter.a.this;
            super();
        }

    }


    public static final int a = 0;
    public static final int b = 1;
    private static Handler l;
    private final String c = com/umeng/fb/adapter/a.getName();
    private LayoutInflater d;
    private AnimationDrawable e;
    private Conversation f;
    private Context g;
    private AudioAgent h;
    private final int i = 2;
    private final int j = 0;
    private final int k = 1;

    public com.umeng.fb.adapter.a(Context context, Conversation conversation)
    {
        g = context;
        d = LayoutInflater.from(g);
        b();
        f = conversation;
        f.setOnChangeListener(new com.umeng.fb.model.Conversation.OnChangeListener() {

            final com.umeng.fb.adapter.a a;

            public void onChange()
            {
                a.notifyDataSetChanged();
            }

            
            {
                a = com.umeng.fb.adapter.a.this;
                super();
            }
        });
    }

    private int a(Context context, int i1)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)(WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        int k1 = displaymetrics.widthPixels;
        int j1 = 100 + (i1 * k1) / 80;
        i1 = j1;
        if ((double)j1 > (double)k1 * 0.69999999999999996D)
        {
            i1 = (int)((double)k1 * 0.69999999999999996D);
        }
        return i1;
    }

    static AnimationDrawable a(com.umeng.fb.adapter.a a1, AnimationDrawable animationdrawable)
    {
        a1.e = animationdrawable;
        return animationdrawable;
    }

    public static Handler a()
    {
        return l;
    }

    static AudioAgent a(com.umeng.fb.adapter.a a1, AudioAgent audioagent)
    {
        a1.h = audioagent;
        return audioagent;
    }

    static Conversation a(com.umeng.fb.adapter.a a1)
    {
        return a1.f;
    }

    private String a(long l1)
    {
        Date date = new Date();
        Date date1 = new Date(l1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        boolean flag;
        if (calendar.get(1) == calendar1.get(1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l1 = TimeUnit.MILLISECONDS.toMinutes(date.getTime() - l1);
        if (l1 < 1L)
        {
            return g.getResources().getString(com.umeng.fb.res.g.f(g));
        }
        if (l1 < 30L)
        {
            return String.format(g.getResources().getString(com.umeng.fb.res.g.g(g)), new Object[] {
                Long.valueOf(l1)
            });
        }
        if (flag)
        {
            return (new SimpleDateFormat(g.getResources().getString(com.umeng.fb.res.g.h(g)), Locale.CHINA)).format(date1);
        } else
        {
            return (new SimpleDateFormat(g.getResources().getString(com.umeng.fb.res.g.i(g)), Locale.CHINA)).format(date1);
        }
    }

    private void a(View view, a a1)
    {
        a(view, ((b) (a1)));
        a1.a = view.findViewById(com.umeng.fb.res.e.x(g));
        a1.b = view.findViewById(com.umeng.fb.res.e.y(g));
        a1.c = (TextView)view.findViewById(com.umeng.fb.res.e.z(g));
    }

    private void a(View view, b b1)
    {
        b1.e = (TextView)view.findViewById(com.umeng.fb.res.e.e(g));
        b1.g = view.findViewById(com.umeng.fb.res.e.i(g));
        b1.f = view.findViewById(com.umeng.fb.res.e.o(g));
        b1.h = (ImageView)view.findViewById(com.umeng.fb.res.e.p(g));
    }

    private void a(View view, c c1)
    {
        a(view, ((b) (c1)));
        c1.a = (TextView)view.findViewById(com.umeng.fb.res.e.b(g));
    }

    private void a(Reply reply, a a1)
    {
        a(reply, ((b) (a1)));
        a1.c.setText((new StringBuilder()).append((int)reply.audio_duration).append("\"").toString());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(a(g, (int)reply.audio_duration), -2);
        a1.a.setLayoutParams(layoutparams);
        if (!com.umeng.fb.common.b.a(g).d())
        {
            return;
        } else
        {
            a1.a.setOnClickListener(new android.view.View.OnClickListener(a1, reply) {

                final a a;
                final Reply b;
                final com.umeng.fb.adapter.a c;

                public void onClick(View view)
                {
                    if (com.umeng.fb.adapter.a.c(c) == null)
                    {
                        com.umeng.fb.adapter.a.a(c, AudioAgent.getInstance(com.umeng.fb.adapter.a.d(c)));
                    }
                    com.umeng.fb.adapter.a.b(c);
                    view = (AnimationDrawable)a.b.getBackground();
                    if (com.umeng.fb.adapter.a.c(c).getPlayStatus())
                    {
                        com.umeng.fb.adapter.a.c(c).stopPlayer();
                        if (com.umeng.fb.adapter.a.e(c) != null && view.equals(com.umeng.fb.adapter.a.e(c)))
                        {
                            return;
                        }
                    }
                    com.umeng.fb.adapter.a.a(c, view);
                    com.umeng.fb.adapter.a.e(c).start();
                    com.umeng.fb.adapter.a.c(c).startPlay(b.reply_id);
                }

            
            {
                c = com.umeng.fb.adapter.a.this;
                a = a2;
                b = reply;
                super();
            }
            });
            return;
        }
    }

    private void a(Reply reply, b b1)
    {
        if ("dev_reply".equals(reply.type))
        {
            b1.f.setBackgroundColor(g.getResources().getColor(com.umeng.fb.res.c.a(g)));
            b1.e.setText(a(reply.created_at));
        } else
        {
            b1.f.setBackgroundColor(g.getResources().getColor(com.umeng.fb.res.c.c(g)));
            if ("not_sent".equals(reply.status))
            {
                b1.e.setText(com.umeng.fb.res.g.d(g));
                b1.h.setOnClickListener(new android.view.View.OnClickListener(reply) {

                    final Reply a;
                    final com.umeng.fb.adapter.a b;

                    public void onClick(View view)
                    {
                        com.umeng.fb.adapter.a.a(b).sendReplyOnlyOne(com.umeng.fb.adapter.a.a(b).getId(), a);
                    }

            
            {
                b = com.umeng.fb.adapter.a.this;
                a = reply;
                super();
            }
                });
                b1.h.setImageResource(com.umeng.fb.res.d.a(g));
                b1.h.setAnimation(null);
                b1.h.setVisibility(0);
            } else
            if ("sending".equals(reply.status) || "will_sent".equals(reply.status))
            {
                b1.e.setText(com.umeng.fb.res.g.e(g));
                b1.h.setImageResource(com.umeng.fb.res.d.a(g));
                b1.h.setVisibility(0);
                reply = new RotateAnimation(0.0F, -360F, 1, 0.5F, 1, 0.5F);
                reply.setInterpolator(new LinearInterpolator());
                reply.setRepeatCount(-1);
                reply.setDuration(700L);
                b1.h.startAnimation(reply);
                b1.h.setOnClickListener(null);
            } else
            {
                b1.e.setText(a(reply.created_at));
                b1.h.setAnimation(null);
                b1.h.setVisibility(8);
                b1.h.setOnClickListener(null);
            }
        }
        b1.g.setVisibility(0);
    }

    private void a(Reply reply, c c1)
    {
        a(reply, ((b) (c1)));
        c1.a.setText(reply.content);
    }

    private void b()
    {
        l = new Handler() {

            final com.umeng.fb.adapter.a a;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 0 1: default 28
            //                           0 29
            //                           1 70;
                   goto _L1 _L2 _L3
_L1:
                return;
_L2:
                com.umeng.fb.adapter.a.b(a);
                if (com.umeng.fb.adapter.a.c(a) != null && com.umeng.fb.adapter.a.c(a).getPlayStatus())
                {
                    com.umeng.fb.adapter.a.c(a).stopPlayer();
                    return;
                }
                  goto _L1
_L3:
                a.notifyDataSetChanged();
                return;
            }

            
            {
                a = com.umeng.fb.adapter.a.this;
                super();
            }
        };
    }

    static void b(com.umeng.fb.adapter.a a1)
    {
        a1.c();
    }

    static AudioAgent c(com.umeng.fb.adapter.a a1)
    {
        return a1.h;
    }

    private void c()
    {
        if (e != null && e.isRunning())
        {
            e.stop();
            e.selectDrawable(0);
        }
    }

    static Context d(com.umeng.fb.adapter.a a1)
    {
        return a1.g;
    }

    static AnimationDrawable e(com.umeng.fb.adapter.a a1)
    {
        return a1.e;
    }

    public int getCount()
    {
        List list = f.getReplyList();
        if (list == null)
        {
            return 0;
        } else
        {
            return list.size();
        }
    }

    public Object getItem(int i1)
    {
        return f.getReplyList().get(i1);
    }

    public long getItemId(int i1)
    {
        return (long)i1;
    }

    public int getItemViewType(int i1)
    {
        return !"text_reply".equals(((Reply)f.getReplyList().get(i1)).content_type) ? 1 : 0;
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        boolean flag1 = true;
        Reply reply = (Reply)f.getReplyList().get(i1);
        if (view == null)
        {
            if ("text_reply".equals(reply.content_type))
            {
                view = d.inflate(com.umeng.fb.res.f.b(g), null);
                viewgroup = new c();
                view.setTag(viewgroup);
                a(view, (c)viewgroup);
            } else
            if ("audio_reply".equals(reply.content_type))
            {
                view = d.inflate(com.umeng.fb.res.f.c(g), null);
                viewgroup = new a();
                view.setTag(viewgroup);
                a(view, (a)viewgroup);
            } else
            {
                viewgroup = null;
            }
        } else
        {
            viewgroup = (b)view.getTag();
        }
        if ("text_reply".equals(reply.content_type))
        {
            a(reply, (c)viewgroup);
        } else
        {
            a(reply, (a)viewgroup);
        }
        if (i1 + 1 < getCount())
        {
            Reply reply1 = (Reply)f.getReplyList().get(i1 + 1);
            boolean flag;
            boolean flag2;
            if ("new_feedback".equals(reply.type) && "user_reply".equals(reply1.type))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag2 = reply1.type.equals(reply.type);
            if (i1 + 1 == getCount())
            {
                i1 = ((flag1) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            if ((flag2 | flag | i1) != 0)
            {
                ((b) (viewgroup)).g.setVisibility(8);
            }
        }
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
