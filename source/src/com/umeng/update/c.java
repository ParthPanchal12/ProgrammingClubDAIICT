// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.umeng.update.net.a;
import com.umeng.update.net.d;
import com.umeng.update.util.b;
import java.io.File;

// Referenced classes of package com.umeng.update:
//            UpdateConfig, UmengDownloadListener, UpdateDialogActivity, UpdateResponse

public class c
    implements d
{
    class a extends b
    {

        final c a;
        private String e;
        private String f;

        public Notification a()
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                return d.build();
            }
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                return d.getNotification();
            } else
            {
                c.setLatestEventInfo(b, e, f, c.contentIntent);
                return c;
            }
        }

        public a a(CharSequence charsequence)
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                d.setContentText(charsequence);
            }
            f = charsequence.toString();
            return this;
        }

        public a b(CharSequence charsequence)
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                d.setContentTitle(charsequence);
            }
            e = charsequence.toString();
            return this;
        }

        public a c(CharSequence charsequence)
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                d.setStyle((new android.app.Notification.BigTextStyle()).bigText(charsequence));
            }
            return this;
        }

        public a(Context context)
        {
            a = c.this;
            super(context);
            e = "";
            f = "";
        }
    }


    private final String a = "delta_update";
    private final String b = "update_normal";
    private UmengDownloadListener c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Context h;
    private String i;
    private com.umeng.update.net.a j;
    private boolean k;

    public c()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = false;
    }

    private void a(com.umeng.update.net.a a1)
    {
        int l = 0;
        int i1 = h.getPackageManager().getPackageInfo(h.getPackageName(), 0).applicationInfo.targetSdkVersion;
        l = i1;
_L2:
        if (android.os.Build.VERSION.SDK_INT >= 16 && l >= 14 && UpdateConfig.isRichNotification() && !UpdateConfig.isSilentDownload())
        {
            a1.a(true);
        }
        a1.b(UpdateConfig.isSilentDownload());
        a1.c(UpdateConfig.isSilentDownload());
        a1.a();
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void a(int l)
    {
        if (c != null)
        {
            c.OnDownloadUpdate(l);
        }
    }

    public void a(int l, int i1, String s)
    {
        l;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 32
    //                   1 32
    //                   2 32
    //                   3 56;
           goto _L1 _L1 _L1 _L1 _L2
_L1:
        k = false;
        if (c != null)
        {
            c.OnDownloadEnd(l, s);
        }
        return;
_L2:
        c();
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void a(Context context, UpdateResponse updateresponse, boolean flag, File file)
    {
        Intent intent = new Intent(context, com/umeng/update/UpdateDialogActivity);
        Bundle bundle = new Bundle();
        bundle.putSerializable("response", updateresponse);
        if (flag)
        {
            bundle.putString("file", file.getAbsolutePath());
        } else
        {
            bundle.putString("file", null);
        }
        bundle.putBoolean("force", UpdateConfig.isUpdateForce());
        intent.putExtras(bundle);
        intent.addFlags(0x14000000);
        context.startActivity(intent);
    }

    public void a(Context context, String s, String s1, String s2, String s3, UmengDownloadListener umengdownloadlistener)
    {
        h = context;
        i = u.upd.a.v(context);
        d = s;
        e = s1;
        f = s2;
        g = s3;
        c = umengdownloadlistener;
    }

    public boolean a()
    {
        return k;
    }

    public a b(Context context, UpdateResponse updateresponse, boolean flag, File file)
    {
        String s2 = u.upd.a.v(context);
        String s3 = updateresponse.a(context, flag);
        String s;
        if (flag)
        {
            updateresponse = context.getString(u.upd.c.a(context).f("UMDialog_InstallAPK"));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(0x10000000);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            file = intent;
        } else
        {
            String s1 = context.getString(u.upd.c.a(context).f("UMUpdateTitle"));
            file = new Intent(context, com/umeng/update/UpdateDialogActivity);
            Bundle bundle = new Bundle();
            bundle.putSerializable("response", updateresponse);
            bundle.putString("file", null);
            bundle.putBoolean("force", UpdateConfig.isUpdateForce());
            file.putExtras(bundle);
            file.addFlags(0x14000000);
            updateresponse = s1;
        }
        s = (new StringBuilder(String.valueOf(s2))).append(updateresponse).toString();
        file = PendingIntent.getActivity(context, 0, file, 0x8000000);
        context = new a(context);
        context.c(s3).b(s2).a(updateresponse).d(s).a(file).a(0x108007d).b(true);
        return context;
    }

    public void b()
    {
        j = new com.umeng.update.net.a(h, a, i, f, this);
        j.a(g);
        j.b(e);
        a(j);
    }

    public void b(int l)
    {
        switch (l)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        default:
            return;

        case 2: // '\002'
        case 7: // '\007'
            k = true;
            return;

        case 6: // '\006'
            k = false;
            break;
        }
    }

    public void c()
    {
        j = new com.umeng.update.net.a(h, b, i, d, this);
        j.a(e);
        j.b(e);
        a(j);
    }

    public void d()
    {
        k = true;
        if (c != null)
        {
            c.OnDownloadStart();
        }
    }
}
