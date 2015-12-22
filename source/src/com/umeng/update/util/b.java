// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.widget.RemoteViews;
import java.lang.reflect.Field;

public class b
{

    protected Context b;
    protected Notification c;
    protected android.app.Notification.Builder d;

    public b(Context context)
    {
        c = new Notification();
        b = context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            d = new android.app.Notification.Builder(context);
        }
    }

    public b a(int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            d.setSmallIcon(i);
        }
        c.icon = i;
        return this;
    }

    public b a(long l)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            d.setWhen(l);
        }
        c.when = l;
        return this;
    }

    public b a(PendingIntent pendingintent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            d.setContentIntent(pendingintent);
        }
        c.contentIntent = pendingintent;
        return this;
    }

    public b a(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            d.setOngoing(flag);
        }
        if (flag)
        {
            Notification notification = c;
            notification.flags = notification.flags | 2;
            return this;
        } else
        {
            Notification notification1 = c;
            notification1.flags = notification1.flags & -3;
            return this;
        }
    }

    public b b(RemoteViews remoteviews)
    {
        if (android.os.Build.VERSION.SDK_INT < 16 && android.os.Build.VERSION.SDK_INT >= 14)
        {
            d.setContent(remoteviews);
        }
        c.contentView = remoteviews;
        return this;
    }

    public b b(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            d.setAutoCancel(flag);
        }
        if (flag)
        {
            Notification notification = c;
            notification.flags = notification.flags | 0x10;
            return this;
        } else
        {
            Notification notification1 = c;
            notification1.flags = notification1.flags & 0xffffffef;
            return this;
        }
    }

    public b d(CharSequence charsequence)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            d.setTicker(charsequence);
        }
        c.tickerText = charsequence;
        return this;
    }

    public void e()
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        Field field = android/app/Notification$Builder.getDeclaredField("mActions");
        field.setAccessible(true);
        field.set(d, field.get(d).getClass().newInstance());
        return;
        Exception exception;
        exception;
    }
}
