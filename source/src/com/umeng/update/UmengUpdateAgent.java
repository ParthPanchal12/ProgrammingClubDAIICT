// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.umeng.update.net.j;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import u.upd.a;
import u.upd.b;
import u.upd.l;
import u.upd.n;

// Referenced classes of package com.umeng.update:
//            c, UmengDialogButtonListener, UpdateConfig, UpdateResponse, 
//            UmengUpdateListener, UmengDownloadListener, b

public class UmengUpdateAgent
{
    static class a
        implements Runnable
    {

        Context a;

        public void run()
        {
            Object obj = (new com.umeng.update.b(a)).b();
            if (obj == null)
            {
                try
                {
                    com.umeng.update.UmengUpdateAgent.a(3, null);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.umeng.update.UmengUpdateAgent.a(1, null);
                    u.upd.b.a("update", "request update error", ((Exception) (obj)));
                    return;
                }
                catch (Error error)
                {
                    u.upd.b.a("update", (new StringBuilder("request update error")).append(error.getMessage()).toString());
                }
                break MISSING_BLOCK_LABEL_84;
            }
            if (!((UpdateResponse) (obj)).hasUpdate)
            {
                com.umeng.update.UmengUpdateAgent.a(1, ((UpdateResponse) (obj)));
                return;
            }
            com.umeng.update.UmengUpdateAgent.a(0, ((UpdateResponse) (obj)));
            return;
        }

        public a(Context context)
        {
            a = context;
        }
    }


    private static UmengUpdateListener a = null;
    private static UmengDialogButtonListener b = null;
    private static UmengDownloadListener c = null;
    private static Context d;
    private static c e = new c();
    private static Handler f;

    public UmengUpdateAgent()
    {
    }

    static Context a()
    {
        return d;
    }

    static void a(int i, Context context, UpdateResponse updateresponse, File file)
    {
        i;
        JVM INSTR tableswitch 5 7: default 28
    //                   5 44
    //                   6 28
    //                   7 53;
           goto _L1 _L2 _L1 _L3
_L1:
        if (b != null)
        {
            b.onClick(i);
        }
        return;
_L2:
        a(context, updateresponse, file);
        continue; /* Loop/switch isn't completed */
_L3:
        ignoreUpdate(context, updateresponse);
        if (true) goto _L1; else goto _L4
_L4:
    }

    static void a(int i, UpdateResponse updateresponse)
    {
        b(i, updateresponse);
    }

    static void a(Context context)
    {
        d = context;
    }

    static void a(Context context, UpdateResponse updateresponse, int i)
    {
        b(context, updateresponse, i);
    }

    private static void a(Context context, UpdateResponse updateresponse, File file)
    {
        if (file == null)
        {
            startDownload(context, updateresponse);
            return;
        } else
        {
            startInstall(context, file);
            return;
        }
    }

    static UmengUpdateListener b()
    {
        return a;
    }

    private static void b(int i, UpdateResponse updateresponse)
    {
        Message message = new Message();
        message.what = i;
        message.obj = updateresponse;
        f.sendMessage(message);
    }

    private static void b(Context context)
    {
        if (context == null)
        {
            try
            {
                u.upd.b.b("update", "unexpected null context in update");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                u.upd.b.b("update", "Exception occurred in Mobclick.update(). ", context);
            }
            break MISSING_BLOCK_LABEL_59;
        }
        f = new Handler(context.getMainLooper()) {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                if (message.what == 0 && UpdateConfig.isUpdateAutoPopup())
                {
                    com.umeng.update.UmengUpdateAgent.a(com.umeng.update.UmengUpdateAgent.a(), (UpdateResponse)message.obj, UpdateConfig.getStyle());
                }
                com.umeng.update.UmengUpdateAgent.a(null);
                if (com.umeng.update.UmengUpdateAgent.b() != null)
                {
                    com.umeng.update.UmengUpdateAgent.b().onUpdateReturned(message.what, (UpdateResponse)message.obj);
                }
            }

        };
        c(context);
        if (u.upd.a.k(context))
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (UpdateConfig.isSilentDownload())
        {
            b(2, null);
            return;
        }
        break MISSING_BLOCK_LABEL_60;
        return;
        if (UpdateConfig.isUpdateOnlyWifi() && !UpdateConfig.isUpdateForce())
        {
            b(2, null);
            return;
        }
        if (e.a())
        {
            b(4, null);
            u.upd.b.a("update", "Is updating now.");
            f.post(new Runnable(context) {

                private final Context a;

                public void run()
                {
                    Toast.makeText(a, l.b(a), 0).show();
                }

            
            {
                a = context;
                super();
            }
            });
            return;
        }
        d = context;
        (new Thread(new a(context.getApplicationContext()))).start();
        return;
    }

    private static void b(Context context, UpdateResponse updateresponse, int i)
    {
        if (isIgnore(context, updateresponse))
        {
            return;
        }
        File file = downloadedFile(context, updateresponse);
        boolean flag;
        if (file != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        if (UpdateConfig.isSilentDownload()) goto _L3; else goto _L2
_L7:
        try
        {
            e.a(context, updateresponse, flag, file);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            u.upd.b.b("update", "Fail to create update dialog box.", context);
        }
        return;
_L5:
        ((NotificationManager)context.getSystemService("notification")).notify(0, e.b(context, updateresponse, flag, file).a());
        return;
_L3:
        startDownload(context, updateresponse);
        return;
_L2:
        switch (i)
        {
        default:
            break; /* Loop/switch isn't completed */

        case 0: // '\0'
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            break;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static boolean c(Context context)
    {
        if (UpdateConfig.isUpdateCheck()) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        PackageInfo packageinfo;
        Exception exception;
        Object aobj[];
        int i;
        boolean flag;
        boolean flag1;
        int k;
        int l;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        try
        {
            flag3 = Class.forName((new StringBuilder(String.valueOf(context.getPackageName()))).append(".BuildConfig").toString()).getField("DEBUG").getBoolean(null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return true;
        }
        if (!flag3) goto _L1; else goto _L3
_L3:
        if (UpdateConfig.getAppkey(context) != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        f.post(new Runnable(context) {

            private final Context a;

            public void run()
            {
                Toast.makeText(a, "Please set umeng appkey!", 1).show();
            }

            
            {
                a = context;
                super();
            }
        });
        return false;
        packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4101);
        aobj = packageinfo.activities;
        if (aobj == null) goto _L5; else goto _L4
_L4:
        i = 0;
        flag4 = false;
_L10:
        flag3 = flag4;
        if (i < packageinfo.activities.length) goto _L7; else goto _L6
_L6:
        flag3 = flag4;
_L27:
        if (flag3) goto _L9; else goto _L8
_L8:
        f.post(new Runnable(context) {

            private final Context a;

            public void run()
            {
                Toast.makeText(a, "Please add Activity in AndroidManifest!", 1).show();
            }

            
            {
                a = context;
                super();
            }
        });
        return false;
_L7:
        flag3 = flag4;
        flag5 = "com.umeng.update.UpdateDialogActivity".equals(packageinfo.activities[i].name);
        if (flag5)
        {
            flag4 = true;
        }
        i++;
          goto _L10
_L9:
        aobj = packageinfo.services;
        if (aobj == null) goto _L12; else goto _L11
_L11:
        i = 0;
        flag4 = false;
_L17:
        flag3 = flag4;
        if (i < packageinfo.services.length) goto _L14; else goto _L13
_L13:
        flag3 = flag4;
_L26:
        if (flag3) goto _L16; else goto _L15
_L15:
        f.post(new Runnable(context) {

            private final Context a;

            public void run()
            {
                Toast.makeText(a, "Please add Service in AndroidManifest!", 1).show();
            }

            
            {
                a = context;
                super();
            }
        });
        return false;
_L14:
        flag3 = flag4;
        flag5 = "com.umeng.update.net.DownloadingService".equals(packageinfo.services[i].name);
        if (flag5)
        {
            flag4 = true;
        }
        i++;
          goto _L17
_L16:
        if (packageinfo.requestedPermissions == null) goto _L19; else goto _L18
_L18:
        k = 0;
        flag1 = false;
        i = 0;
        flag = false;
_L28:
        l = packageinfo.requestedPermissions.length;
        if (k < l) goto _L21; else goto _L20
_L20:
        if (flag && i && flag1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag3) goto _L23; else goto _L22
_L22:
        f.post(new Runnable(context) {

            private final Context a;

            public void run()
            {
                Toast.makeText(a, "Please add Permission in AndroidManifest!", 1).show();
            }

            
            {
                a = context;
                super();
            }
        });
        return false;
_L21:
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(packageinfo.requestedPermissions[k]))
        {
            flag2 = true;
            l = i;
            break MISSING_BLOCK_LABEL_571;
        }
        if ("android.permission.ACCESS_NETWORK_STATE".equals(packageinfo.requestedPermissions[k]))
        {
            l = 1;
            flag2 = flag;
            break MISSING_BLOCK_LABEL_571;
        }
        flag3 = "android.permission.INTERNET".equals(packageinfo.requestedPermissions[k]);
        l = i;
        flag2 = flag;
        if (flag3)
        {
            flag1 = true;
            l = i;
            flag2 = flag;
        }
        break MISSING_BLOCK_LABEL_571;
_L23:
        flag3 = "2.4.2.20140520".equals(context.getString(Class.forName((new StringBuilder(String.valueOf(context.getPackageName()))).append(".R$string").toString()).getField("UMUpdateCheck").getInt(null)));
        if (flag3)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if (flag4) goto _L1; else goto _L24
_L24:
        flag3 = flag4;
        f.post(new Runnable(context) {

            private final Context a;

            public void run()
            {
                Toast.makeText(a, "Please copy all resources (res/) from SDK to your project!", 1).show();
            }

            
            {
                a = context;
                super();
            }
        });
        flag3 = flag4;
_L25:
        return flag3;
        exception;
        flag4 = false;
          goto _L24
        context;
        flag3 = false;
          goto _L25
        context;
          goto _L25
_L19:
        flag1 = false;
        i = 0;
        flag = false;
          goto _L20
_L12:
        flag3 = false;
          goto _L26
_L5:
        flag3 = false;
          goto _L27
        k++;
        i = l;
        flag = flag2;
          goto _L28
    }

    public static File downloadedFile(Context context, UpdateResponse updateresponse)
    {
label0:
        {
            String s = (new StringBuilder(String.valueOf(updateresponse.new_md5))).append(".apk").toString();
            boolean flag;
            try
            {
                context = new File(j.a("/apk", context, new boolean[1]), s);
                if (!context.exists())
                {
                    break label0;
                }
                flag = updateresponse.new_md5.equalsIgnoreCase(n.a(context));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return null;
            }
            if (flag)
            {
                return context;
            }
        }
        return null;
    }

    public static void forceUpdate(Context context)
    {
        UpdateConfig.setUpdateForce(true);
        UpdateConfig.setSilentDownload(false);
        b(context.getApplicationContext());
    }

    public static void ignoreUpdate(Context context, UpdateResponse updateresponse)
    {
        UpdateConfig.saveIgnoreMd5(context, updateresponse.new_md5);
    }

    public static boolean isIgnore(Context context, UpdateResponse updateresponse)
    {
        return updateresponse.new_md5 != null && updateresponse.new_md5.equalsIgnoreCase(UpdateConfig.getIgnoreMd5(context)) && !UpdateConfig.isUpdateForce();
    }

    public static void setAppkey(String s)
    {
        UpdateConfig.setAppkey(s);
    }

    public static void setChannel(String s)
    {
        UpdateConfig.setChannel(s);
    }

    public static void setDefault()
    {
        setDeltaUpdate(true);
        setUpdateAutoPopup(true);
        setUpdateOnlyWifi(true);
        setRichNotification(true);
        setDialogListener(null);
        setDownloadListener(null);
        setUpdateListener(null);
        setAppkey(null);
        setChannel(null);
        setUpdateUIStyle(0);
    }

    public static void setDeltaUpdate(boolean flag)
    {
        UpdateConfig.setDeltaUpdate(flag);
    }

    public static void setDialogListener(UmengDialogButtonListener umengdialogbuttonlistener)
    {
        b = umengdialogbuttonlistener;
    }

    public static void setDownloadListener(UmengDownloadListener umengdownloadlistener)
    {
        c = umengdownloadlistener;
    }

    public static void setRichNotification(boolean flag)
    {
        UpdateConfig.setRichNotification(flag);
    }

    public static void setUpdateAutoPopup(boolean flag)
    {
        UpdateConfig.setUpdateAutoPopup(flag);
    }

    public static void setUpdateCheckConfig(boolean flag)
    {
        UpdateConfig.setUpdateCheck(flag);
    }

    public static void setUpdateListener(UmengUpdateListener umengupdatelistener)
    {
        a = umengupdatelistener;
    }

    public static void setUpdateOnlyWifi(boolean flag)
    {
        UpdateConfig.setUpdateOnlyWifi(flag);
    }

    public static void setUpdateUIStyle(int i)
    {
        UpdateConfig.setStyle(i);
    }

    public static void showUpdateDialog(Context context, UpdateResponse updateresponse)
    {
        b(context, updateresponse, 0);
    }

    public static void showUpdateNotification(Context context, UpdateResponse updateresponse)
    {
        b(context, updateresponse, 1);
    }

    public static void silentUpdate(Context context)
    {
        UpdateConfig.setUpdateForce(false);
        UpdateConfig.setSilentDownload(true);
        b(context.getApplicationContext());
    }

    public static void startDownload(Context context, UpdateResponse updateresponse)
    {
        if (updateresponse.delta && UpdateConfig.isDeltaUpdate())
        {
            e.a(context, updateresponse.origin, updateresponse.new_md5, updateresponse.path, updateresponse.patch_md5, c);
            e.b();
            return;
        } else
        {
            e.a(context, updateresponse.path, updateresponse.new_md5, null, null, c);
            e.c();
            return;
        }
    }

    public static void startInstall(Context context, File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(0x10000000);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static void update(Context context)
    {
        UpdateConfig.setUpdateForce(false);
        UpdateConfig.setSilentDownload(false);
        b(context.getApplicationContext());
    }

    public static void update(Context context, String s, String s1)
    {
        UpdateConfig.setAppkey(s);
        UpdateConfig.setChannel(s1);
        update(context);
    }

}
