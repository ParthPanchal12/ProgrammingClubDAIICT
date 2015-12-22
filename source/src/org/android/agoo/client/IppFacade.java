// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.text.TextUtils;
import com.umeng.message.proguard.aJ;

public class IppFacade
{

    private static String a = org/android/agoo/client/IppFacade.getSimpleName();
    private static final String b = "org.agoo.android.intent.action.PING2";

    public IppFacade()
    {
    }

    static String a()
    {
        return a;
    }

    public static void performProtectOnlyOnce(Context context)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (TextUtils.isEmpty(context.getPackageName())) goto _L1; else goto _L3
_L3:
        (new Thread(new Runnable(context) {

            final Context a;
            private ServiceConnection b;

            private boolean a(String s)
            {
                return a.getPackageManager().getLaunchIntentForPackage(s) != null;
            }

            public void run()
            {
                if (!a("com.eg.android.AlipayGphone"))
                {
                    break MISSING_BLOCK_LABEL_59;
                }
                Intent intent = new Intent();
                intent.setAction("org.agoo.android.intent.action.PING2");
                if (a.bindService(intent, b, 1))
                {
                    aJ.c(IppFacade.a(), "ippfacade binded--->[org.agoo.android.intent.action.PING2] success");
                    return;
                }
                try
                {
                    aJ.d(IppFacade.a(), "ippfacade binded--->[org.agoo.android.intent.action.PING2] failed");
                    return;
                }
                catch (Throwable throwable) { }
            }

            
            {
                a = context;
                super();
                b = new _cls1(this);
            }
        })).start();
        return;
        context;
    }


    // Unreferenced inner class org/android/agoo/client/IppFacade$1$1

/* anonymous class */
    class _cls1
        implements ServiceConnection
    {

        final _cls1 a;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            try
            {
                a.a.unbindService(this);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname)
            {
                return;
            }
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
        }

            
            {
                a = _pcls1;
                super();
            }
    }

}
