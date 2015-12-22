// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.adapter:
//            AppDownloadedAdapter

class val.in_fo
    implements android.view.dedAdapter._cls1
{

    final AppDownloadedAdapter this$0;
    private final DownloadMovieItem val$in_fo;

    public void onClick(View view)
    {
        try
        {
            AppDownloadedAdapter.access$1(AppDownloadedAdapter.this, AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).getPackageManager().getPackageInfo(val$in_fo.getFile_id(), 0));
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            AppDownloadedAdapter.access$1(AppDownloadedAdapter.this, null);
            view.printStackTrace();
        }
        if (AppDownloadedAdapter.access$2(AppDownloadedAdapter.this) != null)
        {
            try
            {
                view = AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).getPackageManager().getLaunchIntentForPackage(val$in_fo.getFile_id());
                AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).startActivity(view);
                Log.v("sss", "2222");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return;
            }
        } else
        {
            publicTools.openimgpath = val$in_fo.getMovieHeadImagePath();
            publicTools.opentitle = val$in_fo.getMovieName();
            publicTools.openid = val$in_fo.getFile_id();
            Log.v("sss", "11111");
            view = new Intent("android.intent.action.VIEW");
            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(val$in_fo.getFilePath()).toString()), "application/vnd.android.package-archive");
            AppDownloadedAdapter.access$0(AppDownloadedAdapter.this).startActivity(view);
            return;
        }
    }

    eption()
    {
        this$0 = final_appdownloadedadapter;
        val$in_fo = DownloadMovieItem.this;
        super();
    }
}
