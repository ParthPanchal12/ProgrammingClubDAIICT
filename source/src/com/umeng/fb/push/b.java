// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.SystemClock;
import com.umeng.fb.ConversationActivity;
import com.umeng.fb.model.Reply;
import com.umeng.fb.model.Store;
import com.umeng.fb.res.g;
import com.umeng.fb.util.Log;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.umeng.fb.push:
//            c, FBMessage

public class b
    implements c
{

    private static final String a = com/umeng/fb/push/b.getName();
    private static c b;
    private Context c;
    private Class d;
    private SharedPreferences e;
    private final String f = "feedback_push";
    private final String g = "alias";
    private final String h = "umeng_feedback";
    private final String i = "feedback_id";
    private final String j = "switch";
    private List k;
    private c.a l;
    private boolean m;
    private String n;
    private boolean o;
    private int p;
    private String q;

    private b(Context context)
    {
        m = false;
        c = context;
        k = new ArrayList();
        e = c.getSharedPreferences("feedback_push", 0);
    }

    static Context a(b b1)
    {
        return b1.c;
    }

    public static c a(Context context)
    {
        if (b == null)
        {
            b = new b(context);
        }
        return b;
    }

    private void a()
    {
        Log.c(a, (new StringBuilder()).append("setAlias UUID ").append(Store.getInstance(c).getDeviceUUID()).toString());
        if (!e.getBoolean("alias", false))
        {
            (new Thread() {

                final b a;

                public void run()
                {
                    int i1 = 0;
_L2:
                    if (i1 >= 10)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    if (PushAgent.getInstance(b.a(a)).addAlias(Store.getInstance(b.a(a)).getDeviceUUID(), "umeng_feedback"))
                    {
                        b.b(a).edit().putBoolean("alias", true).apply();
                        return;
                    }
                    sleep(1000L);
                    i1++;
                    if (true) goto _L2; else goto _L1
                    Exception exception;
                    exception;
                    exception.printStackTrace();
_L1:
                }

            
            {
                a = b.this;
                super();
            }
            }).start();
        }
    }

    private void a(List list, String s, String s1)
    {
        NotificationManager notificationmanager;
        String s2;
        int i1;
        if (p == 1)
        {
            list = c.getResources().getString(com.umeng.fb.res.g.b(c));
            list = String.format(Locale.US, list, new Object[] {
                s1
            });
        } else
        {
            list = c.getResources().getString(com.umeng.fb.res.g.c(c));
            list = String.format(Locale.US, list, new Object[] {
                Integer.valueOf(p)
            });
        }
        notificationmanager = (NotificationManager)c.getSystemService("notification");
        s2 = c.getString(com.umeng.fb.res.g.a(c));
        i1 = c.getPackageManager().getPackageInfo(c.getPackageName(), 0).applicationInfo.icon;
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        s1 = new Intent(c, d);
_L1:
        s1.setFlags(0x20000);
        s1.putExtra("conversation_id", s);
        int j1 = (int)SystemClock.uptimeMillis();
        s = PendingIntent.getActivity(c, j1, s1, 0x8000000);
        notificationmanager.notify(0, (new android.support.v4.app.NotificationCompat.Builder(c)).setSmallIcon(i1).setContentTitle(s2).setTicker(s2).setContentText(list).setAutoCancel(true).setContentIntent(s).build());
        return;
        try
        {
            s1 = new Intent(c, com/umeng/fb/ConversationActivity);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
            return;
        }
          goto _L1
    }

    private boolean a(String s)
    {
        try
        {
            s = (new JSONObject(s)).optString("feedback_id", null);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return false;
        }
        return s != null;
    }

    static SharedPreferences b(b b1)
    {
        return b1.e;
    }

    public void clearPushInfo()
    {
        p = 0;
        q = "";
    }

    public boolean dealFBMessage(FBMessage fbmessage)
    {
        String s;
        Log.c(a, (new StringBuilder()).append("received push message  - ").append(fbmessage.custom).toString());
        if (!a(fbmessage.custom))
        {
            return false;
        }
        if (e == null)
        {
            e = c.getSharedPreferences("feedback_push", 0);
        }
        o = e.getBoolean("switch", false);
        if (!o)
        {
            return true;
        }
        try
        {
            fbmessage = new JSONObject(fbmessage.custom);
            s = fbmessage.getString("feedback_id");
        }
        // Misplaced declaration of an exception variable
        catch (FBMessage fbmessage)
        {
            fbmessage.printStackTrace();
            return false;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        if (p < 1)
        {
            q = Reply.fromJson(fbmessage).content;
        }
        k.add(s);
        p = p + 1;
        if (m)
        {
            if (n != null && n.endsWith(s))
            {
                l.onAddPushDevReply();
            } else
            {
                a(k, s, q);
            }
        } else
        {
            a(k, s, q);
        }
        return true;
    }

    public void disable()
    {
        e.edit().putBoolean("switch", false).apply();
        o = false;
    }

    public void enable()
    {
        e.edit().putBoolean("switch", true).apply();
        o = true;
    }

    public void init(Class class1, boolean flag)
    {
        d = class1;
        init(flag);
    }

    public void init(boolean flag)
    {
        a();
        if (flag)
        {
            return;
        }
        try
        {
            UmengMessageHandler umengmessagehandler = new UmengMessageHandler() {

                final b a;

                public void dealWithCustomMessage(Context context, UMessage umessage)
                {
                    a.dealFBMessage(new FBMessage(umessage.custom));
                }

            
            {
                a = b.this;
                super();
            }
            };
            PushAgent.getInstance(c).setMessageHandler(umengmessagehandler);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public boolean onFBMessage(Intent intent)
    {
        intent = intent.getStringExtra("body");
        try
        {
            intent = new UMessage(new JSONObject(intent));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent.printStackTrace();
            return false;
        }
        return dealFBMessage(new FBMessage(((UMessage) (intent)).custom));
    }

    public void setConversationId(String s)
    {
        n = s;
    }

    public void setFBPushCallbacks(c.a a1)
    {
        l = a1;
    }

    public void setFbFragmentTag(boolean flag)
    {
        m = flag;
    }

}
