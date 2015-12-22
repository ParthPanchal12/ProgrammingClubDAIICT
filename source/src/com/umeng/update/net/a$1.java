// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import u.upd.b;

// Referenced classes of package com.umeng.update.net:
//            a

class a
    implements ServiceConnection
{

    final a a;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        b.c(com.umeng.update.net.a.b(), "ServiceConnection.onServiceConnected");
        com.umeng.update.net.a.a(a, new Messenger(ibinder));
        try
        {
            componentname = Message.obtain(null, 4);
            ibinder = new <init>(com.umeng.update.net.a.a(a), com.umeng.update.net.a.b(a), com.umeng.update.net.a.c(a));
            ibinder.d = com.umeng.update.net.a.d(a);
            ibinder.e = com.umeng.update.net.a.e(a);
            ibinder.f = com.umeng.update.net.a.f(a);
            ibinder.g = com.umeng.update.net.a.g(a);
            ibinder.h = com.umeng.update.net.a.h(a);
            ibinder.i = com.umeng.update.net.a.i(a);
            componentname.setData(ibinder.a());
            componentname.replyTo = a.a;
            com.umeng.update.net.a.j(a).send(componentname);
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
        b.c(com.umeng.update.net.a.b(), "ServiceConnection.onServiceDisconnected");
        com.umeng.update.net.a.a(a, null);
    }

    Name(a a1)
    {
        a = a1;
        super();
    }
}
