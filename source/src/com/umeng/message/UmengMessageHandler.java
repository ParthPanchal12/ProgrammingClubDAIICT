// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.PowerManager;
import android.text.TextUtils;
import com.umeng.common.message.Log;
import com.umeng.common.message.c;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.az;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message:
//            UHandler, PushAgent, UTrack, MessageSharedPrefs, 
//            NotificationProxyBroadcastReceiver, UmengDownloadResourceService

public class UmengMessageHandler
    implements UHandler
{

    private static int a = 0;
    private static final String b = com/umeng/message/UmengMessageHandler.getName();
    private static Date c;
    private static String d = "9999999999999";
    private static final String f = "umeng_push_notification_default_large_icon";
    private static final String g = "umeng_push_notification_default_small_icon";
    private static final String h = "umeng_push_notification_default_sound";
    private UMessage e;

    public UmengMessageHandler()
    {
        e = null;
    }

    private void a(Context context)
    {
        context = (PowerManager)context.getSystemService("power");
        boolean flag = false;
        if (android.os.Build.VERSION.SDK_INT < 7)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        flag = (new Object(context) {

            final PowerManager a;
            final UmengMessageHandler b;

            boolean a()
            {
                return a.isScreenOn();
            }

            
            {
                b = UmengMessageHandler.this;
                a = powermanager;
                super();
            }
        }).a();
_L1:
        Log.c(b, (new StringBuilder()).append("screen on.................................").append(flag).toString());
        if (!flag)
        {
            try
            {
                context.newWakeLock(0x30000006, "MyLock").acquire(10000L);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_93;
        Log.c(b, "android os version < 7, skip checking screen on status");
          goto _L1
    }

    private void a(Context context, Notification notification, boolean flag, UMessage umessage)
    {
        NotificationManager notificationmanager;
        int i;
        int j;
        try
        {
            notificationmanager = (NotificationManager)context.getSystemService("notification");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        i = 0x132b531;
        if (PushAgent.getInstance(context).getMergeNotificaiton()) goto _L2; else goto _L1
_L1:
        j = (new Random()).nextInt();
        i = j;
_L3:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (PushAgent.getInstance(context).getMergeNotificaiton())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (!c(context) || !b(context) || PushAgent.getInstance(context).getNotificationOnForeground())
        {
            notificationmanager.notify(i, notification);
        }
        return;
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        notificationmanager.cancel(0x132b531);
        if (!c(context) || !b(context) || PushAgent.getInstance(context).getNotificationOnForeground())
        {
            break MISSING_BLOCK_LABEL_157;
        }
        UTrack.getInstance(context).trackMsgClick(umessage);
          goto _L3
        umessage;
        umessage.printStackTrace();
          goto _L3
        if (e != null)
        {
            UTrack.getInstance(context).trackMsgDismissed(e);
        }
        e = umessage;
          goto _L3
        UTrack.getInstance(context).trackMsgDismissed(umessage);
          goto _L3
    }

    private boolean a(Context context, android.support.v4.app.NotificationCompat.Builder builder, UMessage umessage)
    {
        int i = getSmallIconId(context, umessage);
        context = getLargeIcon(context, umessage);
        if (i < 0)
        {
            return false;
        }
        builder.setSmallIcon(i);
        if (context != null)
        {
            builder.setLargeIcon(context);
        }
        return true;
    }

    private boolean b(Context context)
    {
        String s = ((android.app.ActivityManager.RunningTaskInfo)((ActivityManager)context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
        return s != null && s.equals(context.getPackageName());
    }

    private boolean c(Context context)
    {
        return context.getPackageManager().checkPermission("android.permission.GET_TASKS", context.getPackageName()) == 0;
    }

    public void dealWithCustomMessage(Context context, UMessage umessage)
    {
    }

    public void dealWithNotificationMessage(Context context, UMessage umessage)
    {
        Log.c(b, (new StringBuilder()).append("notify: ").append(umessage.getRaw().toString()).toString());
        if (!umessage.hasResourceFromInternet() || MessageSharedPrefs.getInstance(context).b(umessage.msg_id) || !startDownloadResourceService(context, umessage)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = MessageSharedPrefs.getInstance(context).j();
        Object obj1;
        int i;
        int j;
        boolean flag;
        if ("".equals(obj))
        {
            obj = "";
        } else
        {
            obj = ((String) (obj)).substring(7, 20);
        }
        if (umessage.msg_id != null && 22 == umessage.msg_id.length() && umessage.msg_id.startsWith("u"))
        {
            MessageSharedPrefs.getInstance(context).e(umessage.msg_id);
            obj1 = umessage.msg_id.substring(7, 20);
        } else
        {
            obj1 = d;
        }
        if ("".equals(obj))
        {
            flag = true;
        } else
        if (((String) (obj1)).compareToIgnoreCase(((String) (obj))) >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        MessageSharedPrefs.getInstance(context).d(umessage.msg_id);
        obj1 = getNotification(context, umessage);
        if (obj1 == null || ((Notification) (obj1)).icon != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = getSmallIconId(context, umessage);
        if (i <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1.icon = i;
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        obj = obj1;
        if (obj1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new android.support.v4.app.NotificationCompat.Builder(context);
        if (!a(context, ((android.support.v4.app.NotificationCompat.Builder) (obj)), umessage))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((android.support.v4.app.NotificationCompat.Builder) (obj)).setContentTitle(umessage.title).setContentText(umessage.text).setTicker(umessage.ticker).setAutoCancel(true);
        obj1 = new android.support.v4.app.NotificationCompat.BigTextStyle();
        ((android.support.v4.app.NotificationCompat.BigTextStyle) (obj1)).setBigContentTitle(umessage.title);
        ((android.support.v4.app.NotificationCompat.BigTextStyle) (obj1)).bigText(umessage.text);
        ((android.support.v4.app.NotificationCompat.Builder) (obj)).setStyle(((android.support.v4.app.NotificationCompat.Style) (obj1)));
        obj = ((android.support.v4.app.NotificationCompat.Builder) (obj)).build();
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L4
_L4:
        obj1 = getClickPendingIntent(context, umessage);
        obj.deleteIntent = getDismissPendingIntent(context, umessage);
        obj.contentIntent = ((PendingIntent) (obj1));
        j = getNotificationDefaults(context, umessage);
        i = j;
        if ((j & 1) != 0)
        {
            obj1 = getSound(context, umessage);
            if (obj1 != null)
            {
                obj.sound = getSound(context, umessage);
            }
            i = j;
            if (obj1 != null)
            {
                i = j ^ 1;
            }
        }
        obj.defaults = i;
        a(context, ((Notification) (obj)), flag, umessage);
        return;
    }

    public PendingIntent getClickPendingIntent(Context context, UMessage umessage)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/umeng/message/NotificationProxyBroadcastReceiver);
        intent.putExtra("MSG", umessage.getRaw().toString());
        intent.putExtra("ACTION", 10);
        return PendingIntent.getBroadcast(context, (int)System.currentTimeMillis(), intent, 0x10000000);
    }

    public PendingIntent getDismissPendingIntent(Context context, UMessage umessage)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/umeng/message/NotificationProxyBroadcastReceiver);
        intent.putExtra("MSG", umessage.getRaw().toString());
        intent.putExtra("ACTION", 11);
        return PendingIntent.getBroadcast(context, (int)(System.currentTimeMillis() + 1L), intent, 0x10000000);
    }

    public Bitmap getLargeIcon(Context context, UMessage umessage)
    {
        if (!umessage.isLargeIconFromInternet()) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(UmengDownloadResourceService.getMessageResourceFolder(context, umessage)).append(umessage.img.hashCode()).toString());
_L5:
        int i;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        i = -1;
        if (!TextUtils.isEmpty(umessage.largeIcon))
        {
            i = com.umeng.common.message.c.a(context).c(umessage.largeIcon);
        }
        int k;
        k = i;
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        k = com.umeng.common.message.c.a(context).c("umeng_push_notification_default_large_icon");
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        umessage = BitmapFactory.decodeResource(context.getResources(), k);
_L3:
        if (umessage != null)
        {
            try
            {
                int j;
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    j = (int)context.getResources().getDimension(0x1050006);
                } else
                {
                    j = az.a(a);
                }
                return Bitmap.createScaledBitmap(umessage, j, j, true);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
            return null;
        } else
        {
            return null;
        }
        umessage = bitmap;
          goto _L3
_L2:
        bitmap = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Notification getNotification(Context context, UMessage umessage)
    {
        return null;
    }

    public int getNotificationDefaults(Context context, UMessage umessage)
    {
        int i;
        int j;
        long l;
        boolean flag;
        j = 0;
        i = 0;
        flag = isInNoDisturbTime(context);
        l = MessageSharedPrefs.getInstance(context).k();
        break MISSING_BLOCK_LABEL_22;
        if (!flag && (c == null || Calendar.getInstance().getTimeInMillis() - c.getTime() >= 1L * l * 1000L))
        {
            if (umessage.play_vibrate)
            {
                j = 2;
            }
            i = j;
            if (umessage.play_lights)
            {
                i = j | 4;
            }
            j = i;
            if (umessage.play_sound)
            {
                j = i | 1;
            }
            c = Calendar.getInstance().getTime();
            i = j;
            if (umessage.screen_on)
            {
                a(context);
                return j;
            }
        }
        return i;
    }

    public int getSmallIconId(Context context, UMessage umessage)
    {
        int i;
        int j;
        int k;
        k = -1;
        j = k;
        i = k;
        if (TextUtils.isEmpty(umessage.icon))
        {
            break MISSING_BLOCK_LABEL_36;
        }
        i = k;
        j = com.umeng.common.message.c.a(context).c(umessage.icon);
        k = j;
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        i = j;
        k = com.umeng.common.message.c.a(context).c("umeng_push_notification_default_small_icon");
        if (k >= 0) goto _L2; else goto _L1
_L1:
        i = k;
        Log.c(b, "no custom notificaiton icon, fail back to app icon.");
        i = k;
        j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        i = j;
_L5:
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        Log.b(b, "Cann't find appropriate icon for notification, please make sure you have specified an icon for this notification or the app has defined an icon.");
        return i;
        context;
_L3:
        context.printStackTrace();
        return i;
        context;
        if (true) goto _L3; else goto _L2
_L2:
        i = k;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Uri getSound(Context context, UMessage umessage)
    {
        Object obj = null;
        if (!umessage.isSoundFromInternet()) goto _L2; else goto _L1
_L1:
        String s1 = (new StringBuilder()).append(UmengDownloadResourceService.getMessageResourceFolder(context, umessage)).append(umessage.sound.hashCode()).toString();
        String s = s1;
        if (!(new File(s1)).exists())
        {
            s = null;
        }
_L4:
        String s2 = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        int i = -1;
        int j;
        try
        {
            if (!TextUtils.isEmpty(umessage.sound))
            {
                i = com.umeng.common.message.c.a(context).h(umessage.sound);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        j = i;
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        j = com.umeng.common.message.c.a(context).h("umeng_push_notification_default_sound");
        s2 = s;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        s2 = (new StringBuilder()).append("android.resource://").append(context.getPackageName()).append("/").append(j).toString();
        context = obj;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        context = Uri.parse(s2);
        return context;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void handleMessage(Context context, UMessage umessage)
    {
        if ("notification".equals(umessage.display_type))
        {
            dealWithNotificationMessage(context, umessage);
        } else
        if ("custom".equals(umessage.display_type))
        {
            dealWithCustomMessage(context, umessage);
            return;
        }
    }

    public boolean isInNoDisturbTime(Context context)
    {
        boolean flag;
        boolean flag1;
        int i = Calendar.getInstance().get(11);
        int j = Calendar.getInstance().get(12);
        if (i * 60 + j >= PushAgent.getInstance(context).getNoDisturbStartHour() * 60 + PushAgent.getInstance(context).getNoDisturbStartMinute())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i * 60 + j <= PushAgent.getInstance(context).getNoDisturbEndHour() * 60 + PushAgent.getInstance(context).getNoDisturbEndMinute())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (PushAgent.getInstance(context).getNoDisturbEndHour() * 60 + PushAgent.getInstance(context).getNoDisturbEndMinute() > PushAgent.getInstance(context).getNoDisturbStartHour() * 60 + PushAgent.getInstance(context).getNoDisturbStartMinute())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (!j) goto _L2; else goto _L1
_L1:
        if (!flag || !flag1) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (!flag && !flag1)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void setPrevMessage(UMessage umessage)
    {
        e = umessage;
    }

    public boolean startDownloadResourceService(Context context, UMessage umessage)
    {
        try
        {
            Intent intent = new Intent(context, com/umeng/message/UmengDownloadResourceService);
            intent.putExtra("body", umessage.getRaw().toString());
            context.startService(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return true;
    }

    static 
    {
        a = 64;
    }
}
