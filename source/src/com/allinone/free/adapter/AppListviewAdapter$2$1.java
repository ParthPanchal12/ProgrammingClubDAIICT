// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.adapter:
//            AppListviewAdapter

class val.in_fo
    implements Runnable
{

    final tId this$1;
    private final DownloadMovieItem val$in_fo;

    public void run()
    {
        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(val$in_fo.getId()).append("&from=apk").toString());
    }

    l.has_apk()
    {
        this$1 = final_has_apk;
        val$in_fo = DownloadMovieItem.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/adapter/AppListviewAdapter$2

/* anonymous class */
    class AppListviewAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final AppListviewAdapter this$0;
        private final String val$has_apk;
        private final DownloadMovieItem val$in_fo;

        public void onClick(View view)
        {
            AppListviewAdapter.access$3(AppListviewAdapter.this).edit().putString("appname", in_fo.getTitle()).commit();
            AppListviewAdapter.access$4(AppListviewAdapter.this).edit().putString("appid", in_fo.getId()).commit();
            if (!has_apk.equals("1")) goto _L2; else goto _L1
_L1:
            (new Thread(in_fo. new AppListviewAdapter._cls2._cls1())).start();
            if (!AppListviewAdapter.access$6(AppListviewAdapter.this).getBoolean("isopen", false) || NetWorkUtil.getAPNType(AppListviewAdapter.access$0(AppListviewAdapter.this)) == 1) goto _L4; else goto _L3
_L3:
            AppListviewAdapter.access$7(AppListviewAdapter.this);
_L6:
            return;
_L4:
            if (AppListviewAdapter.access$8(AppListviewAdapter.this).queryfile(in_fo.getId()) == null)
            {
                MydownloadApk(in_fo.getId(), in_fo.getTitle(), in_fo.getIcon(), in_fo.getSerial());
                return;
            } else
            {
                AppListviewAdapter.access$1(AppListviewAdapter.this);
                return;
            }
_L2:
            if (has_apk.equals("0"))
            {
                (new Thread(new AppListviewAdapter._cls2._cls2())).start();
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(in_fo.getId()).toString()));
                AppListviewAdapter.access$0(AppListviewAdapter.this).startActivity(view);
                return;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

            
            {
                this$0 = final_applistviewadapter;
                in_fo = downloadmovieitem;
                has_apk = String.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/adapter/AppListviewAdapter$2$2

/* anonymous class */
        class AppListviewAdapter._cls2._cls2
            implements Runnable
        {

            final AppListviewAdapter._cls2 this$1;
            private final DownloadMovieItem val$in_fo;

            public void run()
            {
                try
                {
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(in_fo.getId()).append("&from=google").toString());
                    return;
                }
                catch (Exception exception)
                {
                    return;
                }
            }

                    
                    {
                        this$1 = AppListviewAdapter._cls2.this;
                        in_fo = downloadmovieitem;
                        super();
                    }
        }

    }

}
