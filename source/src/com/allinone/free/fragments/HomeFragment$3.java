// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import com.allinone.free.dialog.UpdateDialogVerison;
import com.allinone.free.dialog.UpdateDialogVerison2;
import com.allinone.free.model.GameInfosVersionModel;
import com.allinone.free.utils.Myutils;

// Referenced classes of package com.allinone.free.fragments:
//            HomeFragment

class this._cls0 extends Handler
{

    final HomeFragment this$0;

    public void handleMessage(final Message ntPath)
    {
        if (ntPath.what == 564 && HomeFragment.access$1(HomeFragment.this))
        {
            info = (GameInfosVersionModel)ntPath.obj;
            ntPath = info.getNtId();
            HomeFragment.access$2(HomeFragment.this, info.getUpdatePath());
            if (!HomeFragment.access$3(HomeFragment.this).equals(""))
            {
                Log.v("version", "777777");
                android.view.tener tener = new android.view.View.OnClickListener() {

                    final HomeFragment._cls3 this$1;

                    public void onClick(View view)
                    {
                        switch (view.getId())
                        {
                        default:
                            return;

                        case 2131099881: 
                            updateDialogVersion.dismiss();
                            return;

                        case 2131099882: 
                            view = new Intent("android.intent.action.VIEW", Uri.parse(HomeFragment.access$3(this$0)));
                            break;
                        }
                        updateDialogVersion.dismiss();
                        startActivity(view);
                    }

            
            {
                this$1 = HomeFragment._cls3.this;
                super();
            }
                };
                updateDialogVersion = new UpdateDialogVerison(getActivity(), 0x7f0c0066, tener);
                updateDialogVersion.setCanceledOnTouchOutside(false);
                updateDialogVersion.show();
                try
                {
                    updateDialogVersion.setTvTitle((new StringBuilder("Update Time: ")).append(Myutils.timezhuanhua(System.currentTimeMillis())).append(DateFormat.format(" dd, yyyy", System.currentTimeMillis())).toString());
                }
                catch (Exception exception) { }
            }
            if (ntPath != null && !"".equals(ntPath))
            {
                try
                {
                    packageInfo = getActivity().getPackageManager().getPackageInfo(ntPath, 0);
                }
                // Misplaced declaration of an exception variable
                catch (final Message ntPath)
                {
                    packageInfo = null;
                    ntPath.printStackTrace();
                }
                ntPath = info.getNtPath();
                if (packageInfo == null && ntPath != null && !"".equals(ntPath))
                {
                    itemsOnClick2 = new android.view.View.OnClickListener() {

                        final HomeFragment._cls3 this$1;
                        private final String val$ntPath;

                        public void onClick(View view)
                        {
                            switch (view.getId())
                            {
                            default:
                                return;

                            case 2131099884: 
                                updateDialogVersion2.dismiss();
                                return;

                            case 2131099885: 
                                view = new Intent("android.intent.action.VIEW", Uri.parse(ntPath));
                                break;
                            }
                            updateDialogVersion2.dismiss();
                            startActivity(view);
                        }

            
            {
                this$1 = HomeFragment._cls3.this;
                ntPath = s;
                super();
            }
                    };
                    ntPath = new Message();
                    ntPath.what = 10000;
                    handlertimer.sendMessageDelayed(ntPath, 5000L);
                    Log.v("ppp", "10000");
                }
            }
        }
    }


    _cls2.val.ntPath()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
