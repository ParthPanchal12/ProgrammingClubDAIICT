// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.SyncListener;
import com.umeng.fb.adapter.a;
import com.umeng.fb.audio.AudioAgent;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Store;
import com.umeng.fb.model.UserInfo;
import com.umeng.fb.opus.OpusTool;
import com.umeng.fb.push.FeedbackPush;
import com.umeng.fb.res.b;
import com.umeng.fb.res.c;
import com.umeng.fb.res.d;
import com.umeng.fb.res.e;
import com.umeng.fb.res.f;
import com.umeng.fb.res.g;
import com.umeng.fb.res.h;
import com.umeng.fb.util.Log;
import com.umeng.fb.widget.InterceptTouchSwipeRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class FeedbackFragment extends Fragment
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnTouchListener
{
    private static final class DialogStatus extends Enum
    {

        public static final DialogStatus AudioRecordErr;
        public static final DialogStatus CuntDown;
        public static final DialogStatus NoRecordPermission;
        public static final DialogStatus ReleaseCancel;
        public static final DialogStatus SlideUpCancel;
        public static final DialogStatus TimeShort;
        private static final DialogStatus a[];

        public static DialogStatus valueOf(String s1)
        {
            return (DialogStatus)Enum.valueOf(com/umeng/fb/fragment/FeedbackFragment$DialogStatus, s1);
        }

        public static DialogStatus[] values()
        {
            return (DialogStatus[])a.clone();
        }

        static 
        {
            SlideUpCancel = new DialogStatus("SlideUpCancel", 0);
            ReleaseCancel = new DialogStatus("ReleaseCancel", 1);
            CuntDown = new DialogStatus("CuntDown", 2);
            TimeShort = new DialogStatus("TimeShort", 3);
            NoRecordPermission = new DialogStatus("NoRecordPermission", 4);
            AudioRecordErr = new DialogStatus("AudioRecordErr", 5);
            a = (new DialogStatus[] {
                SlideUpCancel, ReleaseCancel, CuntDown, TimeShort, NoRecordPermission, AudioRecordErr
            });
        }

        private DialogStatus(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    class FeedbackPushCallbacks
        implements com.umeng.fb.push.c.a
    {

        final FeedbackFragment a;

        public void onAddPushDevReply()
        {
            com.umeng.fb.fragment.FeedbackFragment.a(a, 0);
            FeedbackFragment.p(a).clearPushInfo();
        }

        FeedbackPushCallbacks()
        {
            a = FeedbackFragment.this;
            super();
        }
    }


    private static final int A = 2;
    private static final int B = 3;
    public static final String BUNDLE_KEY_CONVERSATION_ID = "conversation_id";
    private static final int C = 4;
    private static final int D = 5;
    private static final int E = 1000;
    private static final int F = 51000;
    private static final int G = 300;
    private static final int H = 1000;
    public static final int HANDLE_MASSAGE_TYPE_REFRESH_START = 0;
    private static final float I = 0.5F;
    private static Handler S;
    private static final String a = com/umeng/fb/fragment/FeedbackFragment.getName();
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    private static final int v = 0;
    private static final int w = 1;
    private static final int x = 2;
    private static final int y = 3;
    private static final int z = 1;
    private String J;
    private Context K;
    private List L;
    private AudioAgent M;
    private Timer N;
    private String O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private Dialog T;
    private View U;
    private TextView V;
    private TextView W;
    private Button b;
    private Button c;
    private EditText d;
    private TextView e;
    private TextView f;
    private TextView g;
    private InterceptTouchSwipeRefreshLayout h;
    private ListView i;
    private Spinner j;
    private a k;
    private FeedbackAgent l;
    private Conversation m;
    private FeedbackPush n;
    private View o;
    private String p[];
    private String q[];
    private int u;

    public FeedbackFragment()
    {
        u = 1;
        P = false;
        Q = false;
        R = false;
    }

    static InterceptTouchSwipeRefreshLayout a(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.h;
    }

    static String a(FeedbackFragment feedbackfragment, String s1)
    {
        return feedbackfragment.a(s1);
    }

    private String a(String s1)
    {
        UserInfo userinfo = l.getUserInfo();
        if (userinfo != null)
        {
            Map map = userinfo.getContact();
            if (map != null)
            {
                String s2 = "";
                if (s1 == null)
                {
                    Iterator iterator = map.keySet().iterator();
                    s1 = s2;
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        s2 = (String)iterator.next();
                        if (map.get(s2) != null && d(s2) != null)
                        {
                            s1 = (new StringBuilder()).append(s1).append(d(s2)).append(": ").append((String)map.get(s2)).append("\t").toString();
                        }
                    } while (true);
                    s2 = s1;
                    if ("".equals(s1))
                    {
                        s2 = null;
                    }
                    return s2;
                } else
                {
                    return (String)map.get(s1);
                }
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }

    private void a(int i1)
    {
        int j1;
        if (2 == i1)
        {
            j1 = 300;
        } else
        {
            j1 = 1000;
        }
        (new Timer()).schedule(new TimerTask(i1) {

            final int a;
            final FeedbackFragment b;

            public void run()
            {
                com.umeng.fb.fragment.FeedbackFragment.a(b, a);
            }

            
            {
                b = FeedbackFragment.this;
                a = i1;
                super();
            }
        }, j1);
    }

    private void a(int i1, int j1)
    {
        Message message = Message.obtain();
        message.what = i1;
        message.arg1 = j1;
        S.sendMessage(message);
    }

    private void a(int i1, View view)
    {
        u = i1;
        if (i1 == 0)
        {
            View view1 = View.inflate(getActivity(), com.umeng.fb.res.f.g(K), null);
            j = (Spinner)view1.findViewById(com.umeng.fb.res.e.l(K));
            ArrayAdapter arrayadapter = ArrayAdapter.createFromResource(getActivity(), com.umeng.fb.res.b.a(K), com.umeng.fb.res.f.h(K));
            arrayadapter.setDropDownViewResource(0x1090009);
            j.setAdapter(arrayadapter);
            ((ViewGroup)view).removeAllViews();
            ((ViewGroup)view).addView(view1);
            d = (EditText)view.findViewById(com.umeng.fb.res.e.n(K));
        } else
        if (i1 == 1)
        {
            Object obj = View.inflate(getActivity(), com.umeng.fb.res.f.i(K), null);
            ((ViewGroup)view).removeAllViews();
            ((ViewGroup)view).addView(((View) (obj)));
            d = (EditText)view.findViewById(com.umeng.fb.res.e.n(K));
            obj = (ImageButton)view.findViewById(com.umeng.fb.res.e.r(K));
            if (!OpusTool.a())
            {
                ((ImageButton) (obj)).setVisibility(8);
            }
            ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final FeedbackFragment a;

                public void onClick(View view3)
                {
                    com.umeng.fb.fragment.FeedbackFragment.a(a, 2, FeedbackFragment.k(a));
                }

            
            {
                a = FeedbackFragment.this;
                super();
            }
            });
        } else
        if (i1 == 2)
        {
            if (M == null)
            {
                M = AudioAgent.getInstance(K);
            }
            j();
            View view2 = View.inflate(getActivity(), com.umeng.fb.res.f.j(K), null);
            ((ViewGroup)view).removeAllViews();
            ((ViewGroup)view).addView(view2);
            ((ImageButton)view.findViewById(com.umeng.fb.res.e.s(K))).setOnClickListener(new android.view.View.OnClickListener() {

                final FeedbackFragment a;

                public void onClick(View view3)
                {
                    com.umeng.fb.fragment.FeedbackFragment.a(a, 1, FeedbackFragment.k(a));
                }

            
            {
                a = FeedbackFragment.this;
                super();
            }
            });
            c = (Button)view.findViewById(com.umeng.fb.res.e.t(K));
            c.setOnTouchListener(this);
        }
        b = (Button)view.findViewById(com.umeng.fb.res.e.m(K));
        if (i1 == 0 && j != null)
        {
            if (L == null)
            {
                L = new ArrayList();
            }
            d.requestFocus();
            j.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                final FeedbackFragment a;

                public void onItemSelected(AdapterView adapterview, View view3, int j1, long l1)
                {
                    j1;
                    JVM INSTR tableswitch 0 3: default 32
                //                               0 70
                //                               1 85
                //                               2 99
                //                               3 113;
                       goto _L1 _L2 _L3 _L4 _L5
_L1:
                    FeedbackFragment.l(a).setText(com.umeng.fb.fragment.FeedbackFragment.a(a, FeedbackFragment.m(a)[j1]));
                    FeedbackFragment.l(a).requestFocus();
                    return;
_L2:
                    FeedbackFragment.l(a).setInputType(33);
                    continue; /* Loop/switch isn't completed */
_L3:
                    FeedbackFragment.l(a).setInputType(2);
                    continue; /* Loop/switch isn't completed */
_L4:
                    FeedbackFragment.l(a).setInputType(3);
                    continue; /* Loop/switch isn't completed */
_L5:
                    FeedbackFragment.l(a).setInputType(0x20001);
                    if (true) goto _L1; else goto _L6
_L6:
                }

                public void onNothingSelected(AdapterView adapterview)
                {
                    FeedbackFragment.l(a).setInputType(0x20001);
                }

            
            {
                a = FeedbackFragment.this;
                super();
            }
            });
            j.setSelection(d());
        } else
        {
            d.setInputType(0x20001);
        }
        if (i1 != 2 && d != null)
        {
            c();
            b.setOnClickListener(new android.view.View.OnClickListener(i1, view) {

                final int a;
                final View b;
                final FeedbackFragment c;

                public void onClick(View view3)
                {
                    view3 = FeedbackFragment.l(c).getEditableText().toString().trim();
                    FeedbackFragment.l(c).getEditableText().clear();
                    if (a == 0)
                    {
                        com.umeng.fb.fragment.FeedbackFragment.b(c, view3);
                        com.umeng.fb.fragment.FeedbackFragment.a(c, 1, b);
                    } else
                    if (a == 1)
                    {
                        FeedbackFragment.n(c).addUserReply(view3);
                        c.a();
                        c.refresh();
                        return;
                    }
                }

            
            {
                c = FeedbackFragment.this;
                a = i1;
                b = view;
                super();
            }
            });
        }
    }

    private void a(Button button, int i1)
    {
        switch (i1)
        {
        default:
            return;

        case 0: // '\0'
            button.setText(com.umeng.fb.res.g.t(K));
            button.setBackgroundDrawable(getResources().getDrawable(com.umeng.fb.res.c.a(K)));
            button.setTextColor(getResources().getColor(0x106000b));
            return;

        case 1: // '\001'
            button.setText(com.umeng.fb.res.g.s(K));
            button.setBackgroundDrawable(getResources().getDrawable(com.umeng.fb.res.c.c(K)));
            button.setTextColor(getResources().getColor(0x106000c));
            return;

        case 2: // '\002'
            button.setEnabled(true);
            button.setTextColor(getResources().getColor(0x106000c));
            return;

        case 3: // '\003'
            button.setEnabled(false);
            break;
        }
        button.setTextColor(getResources().getColor(com.umeng.fb.res.c.c(K)));
    }

    private void a(DialogStatus dialogstatus)
    {
        static class _cls13
        {

            static final int a[];

            static 
            {
                a = new int[DialogStatus.values().length];
                try
                {
                    a[DialogStatus.SlideUpCancel.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[DialogStatus.ReleaseCancel.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[DialogStatus.CuntDown.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[DialogStatus.TimeShort.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[DialogStatus.NoRecordPermission.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[DialogStatus.AudioRecordErr.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.umeng.fb.fragment._cls13.a[dialogstatus.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            U.setVisibility(0);
            V.setVisibility(8);
            U.setBackgroundDrawable(getResources().getDrawable(com.umeng.fb.res.d.b(K)));
            W.setText(getResources().getString(com.umeng.fb.res.g.v(K)));
            return;

        case 2: // '\002'
            U.setBackgroundDrawable(getResources().getDrawable(com.umeng.fb.res.d.c(K)));
            W.setText(getResources().getString(com.umeng.fb.res.g.u(K)));
            return;

        case 3: // '\003'
            U.setVisibility(8);
            V.setVisibility(0);
            W.setText(getResources().getString(com.umeng.fb.res.g.w(K)));
            return;

        case 4: // '\004'
            W.setText(getResources().getString(com.umeng.fb.res.g.x(K)));
            return;

        case 5: // '\005'
            W.setText(com.umeng.fb.res.g.y(K));
            return;

        case 6: // '\006'
            W.setText(com.umeng.fb.res.g.z(K));
            break;
        }
    }

    static void a(FeedbackFragment feedbackfragment, int i1)
    {
        feedbackfragment.b(i1);
    }

    static void a(FeedbackFragment feedbackfragment, int i1, int j1)
    {
        feedbackfragment.a(i1, j1);
    }

    static void a(FeedbackFragment feedbackfragment, int i1, View view)
    {
        feedbackfragment.a(i1, view);
    }

    static void a(FeedbackFragment feedbackfragment, Button button, int i1)
    {
        feedbackfragment.a(button, i1);
    }

    static boolean a(FeedbackFragment feedbackfragment, boolean flag)
    {
        feedbackfragment.R = flag;
        return flag;
    }

    private void b()
    {
        S = new Handler() {

            final FeedbackFragment a;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 0 5: default 44
            //                           0 57
            //                           1 45
            //                           2 167
            //                           3 65
            //                           4 73
            //                           5 159;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                return;
_L3:
                com.umeng.fb.fragment.FeedbackFragment.a(a).setRefreshing(false);
                return;
_L2:
                a.refresh();
                return;
_L5:
                com.umeng.fb.fragment.FeedbackFragment.b(a);
                return;
_L6:
                com.umeng.fb.fragment.FeedbackFragment.c(a).setVisibility(8);
                com.umeng.fb.fragment.FeedbackFragment.d(a).setVisibility(0);
                com.umeng.fb.fragment.FeedbackFragment.d(a).setText((new StringBuilder()).append("").append(message.arg1).toString());
                com.umeng.fb.fragment.FeedbackFragment.f(a).setText(a.getResources().getString(com.umeng.fb.res.g.w(com.umeng.fb.fragment.FeedbackFragment.e(a))));
                return;
_L7:
                com.umeng.fb.fragment.FeedbackFragment.g(a);
                return;
_L4:
                if (!com.umeng.fb.fragment.FeedbackFragment.h(a))
                {
                    FeedbackFragment.i(a);
                    com.umeng.fb.fragment.FeedbackFragment.a(a, true);
                    return;
                }
                if (true) goto _L1; else goto _L8
_L8:
            }

            
            {
                a = FeedbackFragment.this;
                super();
            }
        };
    }

    private void b(int i1)
    {
        Message message = Message.obtain();
        message.what = i1;
        S.sendMessage(message);
    }

    static void b(FeedbackFragment feedbackfragment)
    {
        feedbackfragment.g();
    }

    static void b(FeedbackFragment feedbackfragment, String s1)
    {
        feedbackfragment.c(s1);
    }

    private void b(String s1)
    {
        if (s1 != null)
        {
            e.setText(s1);
            f.setText(getResources().getString(com.umeng.fb.res.g.j(K)));
            return;
        } else
        {
            e.setText(getResources().getString(com.umeng.fb.res.g.k(K)));
            f.setText(getResources().getString(com.umeng.fb.res.g.l(K)));
            return;
        }
    }

    static boolean b(FeedbackFragment feedbackfragment, boolean flag)
    {
        feedbackfragment.P = flag;
        return flag;
    }

    static View c(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.U;
    }

    private void c()
    {
        if (TextUtils.isEmpty(d.getText().toString()))
        {
            a(b, 3);
        }
        d.addTextChangedListener(new TextWatcher() {

            final FeedbackFragment a;

            public void afterTextChanged(Editable editable)
            {
                if (!TextUtils.isEmpty(FeedbackFragment.l(a).getText().toString()))
                {
                    com.umeng.fb.fragment.FeedbackFragment.a(a, FeedbackFragment.o(a), 2);
                    return;
                } else
                {
                    com.umeng.fb.fragment.FeedbackFragment.a(a, FeedbackFragment.o(a), 3);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = FeedbackFragment.this;
                super();
            }
        });
    }

    private void c(String s1)
    {
        String s2 = p[j.getSelectedItemPosition()];
        if (s1.equals(a(s2)))
        {
            return;
        }
        Object obj = l.getUserInfo();
        UserInfo userinfo = ((UserInfo) (obj));
        if (obj == null)
        {
            userinfo = new UserInfo();
        }
        Map map = userinfo.getContact();
        obj = map;
        if (map == null)
        {
            obj = new HashMap();
        }
        ((Map) (obj)).put(s2, s1);
        userinfo.setContact(((Map) (obj)));
        l.setUserInfo(userinfo);
        b(a(((String) (null))));
        (new Thread(new Runnable() {

            final FeedbackFragment a;

            public void run()
            {
                (new com.umeng.fb.net.a(a.getActivity())).a(Store.getInstance(a.getActivity()).getUserInfo().toJson());
            }

            
            {
                a = FeedbackFragment.this;
                super();
            }
        })).start();
    }

    static boolean c(FeedbackFragment feedbackfragment, boolean flag)
    {
        feedbackfragment.Q = flag;
        return flag;
    }

    private int d()
    {
        for (int i1 = 0; i1 < p.length; i1++)
        {
            if (a(p[i1]) != null)
            {
                return i1;
            }
        }

        return 0;
    }

    static TextView d(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.V;
    }

    private String d(String s1)
    {
        for (int i1 = 0; i1 < p.length; i1++)
        {
            if (p[i1].endsWith(s1))
            {
                return q[i1];
            }
        }

        return null;
    }

    static Context e(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.K;
    }

    private void e()
    {
        a(DialogStatus.SlideUpCancel);
        J = l();
        T.show();
        P = false;
        Q = false;
        f();
        if (!m())
        {
            a(DialogStatus.NoRecordPermission);
            a(5);
            return;
        }
        if (!M.recordStart(J))
        {
            a(DialogStatus.AudioRecordErr);
            a(5);
            return;
        } else
        {
            k();
            return;
        }
    }

    static TextView f(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.W;
    }

    private void f()
    {
        Message message = new Message();
        message.what = 0;
        com.umeng.fb.adapter.a.a().sendMessage(message);
    }

    private void g()
    {
        R = true;
        if (N != null)
        {
            N.cancel();
        }
        if (M == null || !M.getAudioInitStatus())
        {
            h();
        } else
        {
            if (O != null && O.equals(J))
            {
                h();
                return;
            }
            if (Q)
            {
                h();
                M.recordShortStop();
                com.umeng.fb.util.c.a(K, J);
                return;
            }
            if (M.getAudioDuration() < 0.5F)
            {
                a(DialogStatus.TimeShort);
                M.recordShortStop();
                a(5);
                return;
            }
            if (M.getRecordStatus())
            {
                h();
                if (M.recordStop() > 0)
                {
                    m.addUserReply("voice", J, "audio_reply", M.getAudioDuration());
                    O = J;
                    a();
                    return;
                }
            } else
            {
                h();
                return;
            }
        }
    }

    static void g(FeedbackFragment feedbackfragment)
    {
        feedbackfragment.h();
    }

    public static Handler getHandler()
    {
        return S;
    }

    private void h()
    {
        if (T.isShowing())
        {
            T.dismiss();
        }
        a(c, 1);
    }

    static boolean h(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.R;
    }

    private void i()
    {
        T = new Dialog(K, com.umeng.fb.res.h.a(K));
        T.requestWindowFeature(1);
        T.getWindow().setFlags(1024, 1024);
        T.setContentView(com.umeng.fb.res.f.k(K));
        T.setCanceledOnTouchOutside(true);
        U = T.findViewById(com.umeng.fb.res.e.u(K));
        V = (TextView)T.findViewById(com.umeng.fb.res.e.w(K));
        W = (TextView)T.findViewById(com.umeng.fb.res.e.v(K));
    }

    static void i(FeedbackFragment feedbackfragment)
    {
        feedbackfragment.e();
    }

    static int j(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.u;
    }

    private void j()
    {
        ((InputMethodManager)K.getSystemService("input_method")).hideSoftInputFromWindow(d.getWindowToken(), 2);
    }

    static View k(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.o;
    }

    private void k()
    {
        if (N != null)
        {
            N.cancel();
        }
        N = new Timer();
        N.schedule(new TimerTask() {

            int a;
            final FeedbackFragment b;

            public void run()
            {
label0:
                {
                    com.umeng.fb.fragment.FeedbackFragment.b(b, true);
                    if (FeedbackFragment.q(b).isShowing())
                    {
                        if (a <= 0)
                        {
                            break label0;
                        }
                        com.umeng.fb.fragment.FeedbackFragment.a(b, 4, a);
                        a = a - 1;
                    }
                    return;
                }
                com.umeng.fb.fragment.FeedbackFragment.a(b, 3);
                com.umeng.fb.fragment.FeedbackFragment.c(b, false);
                cancel();
            }

            
            {
                b = FeedbackFragment.this;
                super();
                a = 10;
            }
        }, 51000L, 1000L);
    }

    static EditText l(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.d;
    }

    private String l()
    {
        return (new StringBuilder()).append("R").append(UUID.randomUUID().toString()).toString();
    }

    private boolean m()
    {
        return com.umeng.fb.util.b.a(K, "android.permission.RECORD_AUDIO");
    }

    static String[] m(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.p;
    }

    static Conversation n(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.m;
    }

    public static FeedbackFragment newInstance(String s1)
    {
        Log.c(a, String.format("newInstance(id=%s)", new Object[] {
            s1
        }));
        FeedbackFragment feedbackfragment = new FeedbackFragment();
        Bundle bundle = new Bundle();
        bundle.putString("conversation_id", s1);
        feedbackfragment.setArguments(bundle);
        return feedbackfragment;
    }

    static Button o(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.b;
    }

    static FeedbackPush p(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.n;
    }

    static Dialog q(FeedbackFragment feedbackfragment)
    {
        return feedbackfragment.T;
    }

    void a()
    {
        if (k.getCount() > 0)
        {
            i.smoothScrollToPosition(k.getCount());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        K = getActivity();
        i();
        b();
        Log.c(a, String.format("onCreateView(savedInstanceState=%s)", new Object[] {
            bundle
        }));
        p = getResources().getStringArray(com.umeng.fb.res.b.b(K));
        q = getResources().getStringArray(com.umeng.fb.res.b.a(K));
        viewgroup = layoutinflater.inflate(com.umeng.fb.res.f.d(K), null, false);
        l = new FeedbackAgent(getActivity());
        n = FeedbackPush.getInstance(getActivity());
        n.setFBPushCallbacks(new FeedbackPushCallbacks());
        bundle = getArguments().getString("conversation_id");
        n.setConversationId(bundle);
        if (TextUtils.isEmpty(bundle))
        {
            return viewgroup;
        }
        m = l.getConversationById(bundle);
        n.clearPushInfo();
        if (m == null)
        {
            return viewgroup;
        }
        i = (ListView)viewgroup.findViewById(com.umeng.fb.res.e.a(K));
        o = viewgroup.findViewById(com.umeng.fb.res.e.g(K));
        bundle = layoutinflater.inflate(com.umeng.fb.res.f.e(K), null, false);
        View view = bundle.findViewById(com.umeng.fb.res.e.h(K));
        f = (TextView)view.findViewById(com.umeng.fb.res.e.b(K));
        e = (TextView)view.findViewById(com.umeng.fb.res.e.e(K));
        b(a(((String) (null))));
        f.setTextColor(getResources().getColor(com.umeng.fb.res.c.a(K)));
        bundle.findViewById(com.umeng.fb.res.e.i(K)).setBackgroundColor(getResources().getColor(com.umeng.fb.res.c.a(K)));
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final FeedbackFragment a;

            public void onClick(View view1)
            {
                if (FeedbackFragment.j(a) != 0)
                {
                    com.umeng.fb.fragment.FeedbackFragment.a(a, 0, FeedbackFragment.k(a));
                }
            }

            
            {
                a = FeedbackFragment.this;
                super();
            }
        });
        i.setHeaderDividersEnabled(true);
        i.addHeaderView(bundle);
        if (com.umeng.fb.common.b.a(K).b())
        {
            layoutinflater = layoutinflater.inflate(com.umeng.fb.res.f.f(K), null, false);
            g = (TextView)layoutinflater.findViewById(com.umeng.fb.res.e.j(K));
            if (com.umeng.fb.common.b.a(K).c() != null)
            {
                g.setText(com.umeng.fb.common.b.a(K).c());
            }
            i.addHeaderView(layoutinflater);
        }
        k = new a(getActivity(), m);
        i.setAdapter(k);
        h = (InterceptTouchSwipeRefreshLayout)viewgroup.findViewById(com.umeng.fb.res.e.k(K));
        h.setOnRefreshListener(this);
        h.setColorSchemeResources(new int[] {
            com.umeng.fb.res.c.a(K), com.umeng.fb.res.c.b(K), com.umeng.fb.res.c.a(K), com.umeng.fb.res.c.b(K)
        });
        h.setInterceptTouch(new android.view.View.OnTouchListener() {

            final FeedbackFragment a;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                if (FeedbackFragment.j(a) != 1 && motionevent.getAction() == 1)
                {
                    com.umeng.fb.fragment.FeedbackFragment.a(a, 1, FeedbackFragment.k(a));
                }
                view1.performClick();
                return false;
            }

            
            {
                a = FeedbackFragment.this;
                super();
            }
        });
        a(1, o);
        refresh();
        return viewgroup;
    }

    public void onDestroy()
    {
        super.onDestroy();
        com.umeng.fb.util.c.a(K);
    }

    public void onPause()
    {
        super.onPause();
        n.setFbFragmentTag(false);
        if (N != null)
        {
            N.cancel();
        }
        f();
    }

    public void onRefresh()
    {
        Log.c(a, "onRefreshonRefresh");
        refresh();
    }

    public void onResume()
    {
        super.onResume();
        n.setFbFragmentTag(true);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 38
    //                   1 64
    //                   2 93
    //                   3 150;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return false;
_L2:
        motionevent.getY();
        R = false;
        a(c, 0);
        a(2);
        return false;
_L3:
        a(c, 1);
        if (R)
        {
            g();
            return false;
        } else
        {
            R = true;
            return false;
        }
_L4:
        float f1 = motionevent.getY();
        if (R)
        {
            if (0.0F - f1 > 80F)
            {
                a(DialogStatus.ReleaseCancel);
                Q = true;
                return false;
            }
            if (!P)
            {
                a(DialogStatus.SlideUpCancel);
            }
            Q = false;
            return false;
        }
          goto _L1
_L5:
        a(c, 1);
        if (R)
        {
            g();
            return false;
        } else
        {
            R = true;
            return false;
        }
    }

    public void refresh()
    {
        SyncListener synclistener = new SyncListener() {

            final FeedbackFragment a;

            public void onReceiveDevReply(List list)
            {
                com.umeng.fb.fragment.FeedbackFragment.a(a, 1);
                a.a();
            }

            public void onSendUserReply(List list)
            {
            }

            
            {
                a = FeedbackFragment.this;
                super();
            }
        };
        m.sync(synclistener);
    }

}
