// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.message.proguard.bz;

// Referenced classes of package org.android.agoo.client:
//            BaseIntentService

public abstract class BaseBroadcastReceiver extends BroadcastReceiver
{

    public BaseBroadcastReceiver()
    {
    }

    protected abstract String a(Context context);

    protected void a(Context context, Intent intent)
    {
    }

    public final void onReceive(Context context, Intent intent)
    {
        try
        {
            bz.a(new Runnable(context, intent) {

                final Context a;
                final Intent b;
                final BaseBroadcastReceiver c;

                public void run()
                {
                    try
                    {
                        c.a(a, b);
                        return;
                    }
                    catch (Throwable throwable)
                    {
                        return;
                    }
                }

            
            {
                c = BaseBroadcastReceiver.this;
                a = context;
                b = intent;
                super();
            }
            });
            BaseIntentService.a(context, intent, a(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }
}
