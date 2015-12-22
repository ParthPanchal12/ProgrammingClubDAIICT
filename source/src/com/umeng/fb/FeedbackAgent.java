// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import com.umeng.fb.common.b;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;
import com.umeng.fb.model.Store;
import com.umeng.fb.model.UserInfo;
import com.umeng.fb.net.a;
import com.umeng.fb.push.c;
import com.umeng.fb.res.g;
import com.umeng.fb.util.Log;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.umeng.fb:
//            ConversationActivity, SyncListener

public class FeedbackAgent
{

    private static final String a = com/umeng/fb/FeedbackAgent.getName();
    private static boolean d = false;
    private Context b;
    private Store c;

    public FeedbackAgent(Context context)
    {
        b = context;
        c = Store.getInstance(b);
        a();
    }

    static Context a(FeedbackAgent feedbackagent)
    {
        return feedbackagent.b;
    }

    private void a()
    {
        if (!c.isMigrated())
        {
            c.migrateData();
        }
        if (TextUtils.isEmpty(c.getUid()))
        {
            (new Thread() {

                final FeedbackAgent a;

                public void run()
                {
                    (new a(com.umeng.fb.FeedbackAgent.a(a))).a();
                }

            
            {
                a = FeedbackAgent.this;
                super();
            }
            }).start();
        }
    }

    public void closeAudioFeedback()
    {
        com.umeng.fb.common.b.a(b).c(false);
    }

    public void closeFeedbackPush()
    {
        com.umeng.fb.push.b.a(b).disable();
    }

    public List getAllConversationIds()
    {
        return c.getAllConversationIds();
    }

    public Conversation getConversationById(String s)
    {
        return c.getConversationById(s);
    }

    public Conversation getDefaultConversation()
    {
        List list = getAllConversationIds();
        if (list == null || list.size() < 1)
        {
            Log.c(a, "getDefaultConversation: No conversation saved locally. Create a new one.");
            return Conversation.newInstance(b);
        } else
        {
            Log.c(a, (new StringBuilder()).append("getDefaultConversation: There are ").append(list.size()).append(" saved locally, use the first one by default.").toString());
            return getConversationById((String)list.get(0));
        }
    }

    public UserInfo getUserInfo()
    {
        return c.getUserInfo();
    }

    public long getUserInfoLastUpdateAt()
    {
        return c.getUserInfoLastUpdateAt();
    }

    public void openAudioFeedback()
    {
        com.umeng.fb.common.b.a(b).c(true);
    }

    public void openFeedbackPush()
    {
        com.umeng.fb.push.b.a(b).enable();
    }

    public void removeWelcomeInfo()
    {
        com.umeng.fb.common.b.a(b).b(false);
    }

    public void setDebug(boolean flag)
    {
        Log.LOG = flag;
    }

    public void setUserInfo(UserInfo userinfo)
    {
        c.saveUserInfo(userinfo);
    }

    public void setWelcomeInfo()
    {
        com.umeng.fb.common.b.a(b).b(true);
    }

    public void setWelcomeInfo(String s)
    {
        com.umeng.fb.common.b.a(b).b(true);
        if (s != null)
        {
            com.umeng.fb.common.b.a(b).a(s);
        }
    }

    public void showReplyNotification(List list)
    {
        if (list.size() == 1)
        {
            String s = b.getResources().getString(g.b(b));
            list = String.format(Locale.US, s, new Object[] {
                ((Reply)list.get(0)).content
            });
        } else
        {
            String s1 = b.getResources().getString(g.c(b));
            list = String.format(Locale.US, s1, new Object[] {
                Integer.valueOf(list.size())
            });
        }
        try
        {
            NotificationManager notificationmanager = (NotificationManager)b.getSystemService("notification");
            String s2 = b.getString(g.a(b));
            Object obj = new Intent(b, com/umeng/fb/ConversationActivity);
            ((Intent) (obj)).setFlags(0x20000);
            int i = (int)SystemClock.uptimeMillis();
            obj = PendingIntent.getActivity(b, i, ((Intent) (obj)), 0x8000000);
            i = b.getPackageManager().getPackageInfo(b.getPackageName(), 0).applicationInfo.icon;
            notificationmanager.notify(0, (new android.support.v4.app.NotificationCompat.Builder(b)).setSmallIcon(i).setContentTitle(s2).setTicker(s2).setContentText(list).setAutoCancel(true).setContentIntent(((PendingIntent) (obj))).build());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
        }
    }

    public void startFeedbackActivity()
    {
        try
        {
            Intent intent = new Intent();
            intent.setClass(b, com/umeng/fb/ConversationActivity);
            b.startActivity(intent);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void sync()
    {
        SyncListener synclistener = new SyncListener() {

            final FeedbackAgent a;

            public void onReceiveDevReply(List list)
            {
                if (list == null || list.size() < 1)
                {
                    return;
                } else
                {
                    a.showReplyNotification(list);
                    return;
                }
            }

            public void onSendUserReply(List list)
            {
            }

            
            {
                a = FeedbackAgent.this;
                super();
            }
        };
        getDefaultConversation().sync(synclistener);
    }

    public boolean updateUserInfo()
    {
        return (new a(b)).a(Store.getInstance(b).getUserInfo().toJson());
    }

}
