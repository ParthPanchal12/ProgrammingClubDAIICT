// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.allinone.free.activity.AnzhuangActivity;
import com.allinone.free.activity.OpenActivity;
import com.allinone.free.activity.UnInstallActivity;
import com.allinone.free.model.AppInstalledEntity;
import com.allinone.free.utils.publicTools;
import com.stericson.RootTools.RootTools;
import java.io.File;

public class GetBroadcast extends BroadcastReceiver
{

    private static IntentFilter mIntentFilter;
    private static GetBroadcast mReceiver = new GetBroadcast();

    public GetBroadcast()
    {
    }

    public static void registerReceiver(Context context)
    {
        mIntentFilter = new IntentFilter();
        mIntentFilter.addDataScheme("package");
        mIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        mIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        context.registerReceiver(mReceiver, mIntentFilter);
    }

    public static void unregisterReceiver(Context context)
    {
        context.unregisterReceiver(mReceiver);
    }

    public AppInstalledEntity getAppInfoByPackageName(String s, Context context)
    {
        PackageInfo packageinfo;
        AppInstalledEntity appinstalledentity;
        appinstalledentity = new AppInstalledEntity();
        packageinfo = null;
        PackageInfo packageinfo1 = context.getPackageManager().getPackageInfo(s, 0);
        packageinfo = packageinfo1;
_L1:
        appinstalledentity.setAppId("1");
        appinstalledentity.setAppname(packageinfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
        String s1 = packageinfo.applicationInfo.publicSourceDir;
        appinstalledentity.setApkpath(s1);
        Log.e("www", (new StringBuilder("ppppppppp=")).append(s1).toString());
        appinstalledentity.setAckageinfo(s);
        appinstalledentity.setIcon(packageinfo.applicationInfo.loadIcon(context.getPackageManager()));
        appinstalledentity.setVersion(String.valueOf(packageinfo.versionName));
        long l = (new File(packageinfo.applicationInfo.publicSourceDir)).length() / 1024L;
        float f = (float)((double)(int)(((double)l / 1024D) * 100D) / 100D);
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        if (l >= 1024L)
        {
            appinstalledentity.setSize((new StringBuilder(String.valueOf(f))).append("MB").toString());
            return appinstalledentity;
        } else
        {
            appinstalledentity.setSize((new StringBuilder(String.valueOf(l))).append("KB").toString());
            return appinstalledentity;
        }
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L1
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getDataString().substring(8);
        intent = intent.getAction();
        if (!"android.intent.action.PACKAGE_ADDED".equals(intent))
        {
            break MISSING_BLOCK_LABEL_187;
        }
        Log.e("www", "PACKAGE_ADDED");
        if (RootTools.isRootAvailable() && !publicTools.tagtanchuang && !publicTools.openid.equals(""))
        {
            intent = new Intent(context, com/allinone/free/activity/OpenActivity);
            intent.addFlags(0x10000000);
            context.startActivity(intent);
        }
        Object obj;
        Intent intent1;
        try
        {
            intent = context.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            intent = null;
            namenotfoundexception.printStackTrace();
        }
        if (intent != null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        try
        {
            obj = getAppInfoByPackageName(s, context);
            intent = ((AppInstalledEntity) (obj)).getAppname();
            obj = ((AppInstalledEntity) (obj)).getSize();
            intent1 = new Intent(context, com/allinone/free/activity/AnzhuangActivity);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        intent1.addFlags(0x10000000);
        intent1.putExtra("appname", intent);
        intent1.putExtra("size", ((String) (obj)));
        intent1.putExtra("appid", s);
        if (!publicTools.tagtanchuang)
        {
            context.startActivity(intent1);
        }
_L1:
        return;
        if ("android.intent.action.PACKAGE_REMOVED".equals(intent) && !s.equals("com.evzapp.cleanmaster"))
        {
            try
            {
                context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                intent.printStackTrace();
            }
            if (!publicTools.tagtanchuang)
            {
                intent = new Intent(context, com/allinone/free/activity/UnInstallActivity);
                intent.addFlags(0x10000000);
                intent.putExtra("appname", s);
                intent.putExtra("size", (new StringBuilder(String.valueOf((int)(Math.random() * 100D + 100D)))).append("kb").toString());
                context.startActivity(intent);
                return;
            }
        }
          goto _L1
        context;
        return;
    }

}
