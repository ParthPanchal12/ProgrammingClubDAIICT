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
import com.umeng.message.proguard.aJ;

// Referenced classes of package org.android.agoo.client:
//            IppFacade

class a
    implements ServiceConnection
{

    final a a;

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

    <init>(<init> <init>1)
    {
        a = <init>1;
        super();
    }

    // Unreferenced inner class org/android/agoo/client/IppFacade$1

/* anonymous class */
    static final class IppFacade._cls1
        implements Runnable
    {

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
                b = new IppFacade._cls1._cls1(this);
            }
    }

}
