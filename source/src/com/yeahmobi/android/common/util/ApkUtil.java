// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.common.util;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.File;

public class ApkUtil
{

    private static final String dir = ".YeahMobi_Files";

    public ApkUtil()
    {
    }

    private static File tryGetLocalApkFile(String s)
    {
        s = Environment.getExternalStoragePublicDirectory((new StringBuilder()).append(".YeahMobi_Files").append(s).append(".apk").toString());
        if (s.exists() && s.isFile())
        {
            return s;
        } else
        {
            return null;
        }
    }

    private static void tryOpen(File file, Context context)
    {
        if (file != null && context != null)
        {
            Intent intent = new Intent();
            intent.addFlags(0x10000000);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            ((Activity)context).startActivity(intent);
        }
    }

    private static void tryOpen(String s, Context context)
    {
        if (s != null && s.length() != 0 && context != null)
        {
            s = Environment.getExternalStoragePublicDirectory((new StringBuilder()).append(".YeahMobi_Files").append(s).append(".apk").toString());
            if (s.exists() && s.isFile())
            {
                Intent intent = new Intent();
                intent.addFlags(0x10000000);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(s), "application/vnd.android.package-archive");
                ((Activity)context).startActivity(intent);
            }
        }
    }

    public static void visit_from_http(String s, String s1, Context context)
    {
        Object obj = tryGetLocalApkFile(s1);
        if (obj != null)
        {
            tryOpen(((File) (obj)), context);
            return;
        }
        obj = (DownloadManager)context.getSystemService("download");
        File file = Environment.getExternalStoragePublicDirectory(".YeahMobi_Files");
        if (!file.exists() || !file.isDirectory())
        {
            file.mkdirs();
        }
        s = new android.app.DownloadManager.Request(Uri.parse(s));
        s.setDestinationInExternalPublicDir(".YeahMobi_Files", (new StringBuilder()).append(s1).append(".apk").toString());
        s.setTitle(s1);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            Log.e("guard", (new StringBuilder()).append(android.os.Build.VERSION.SDK_INT).append("").toString());
            s.setNotificationVisibility(1);
        }
        s.setVisibleInDownloadsUi(true);
        s.setMimeType("application/com.yeahmobi.download.file");
        long l = ((DownloadManager) (obj)).enqueue(s);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("yeahmobi_download_id", l);
    }

    public static void visit_from_market(String s, Context context)
    {
        if (s != null && s.length() != 0 && context != null)
        {
            s = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString()));
            s.addFlags(0x10000000);
            ((Activity)context).startActivity(s);
        }
    }
}
