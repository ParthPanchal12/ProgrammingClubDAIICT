// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update.net;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.umeng.update.util.b;
import u.upd.c;
import u.upd.j;
import u.upd.l;

// Referenced classes of package com.umeng.update.net:
//            c

static class init> extends b
{

    public init> a()
    {
        c.contentView.setViewVisibility(j.e(b), 8);
        c.contentView.setViewVisibility(j.g(b), 8);
        return this;
    }

    public b a(int i, int k, boolean flag)
    {
        if (android.os.d.VERSION.SDK_INT >= 14)
        {
            d.setProgress(i, k, flag);
        }
        c.contentView.setProgressBar(j.c(b), 100, k, false);
        return this;
    }

    public  a(PendingIntent pendingintent, PendingIntent pendingintent1)
    {
        c.contentView.setOnClickPendingIntent(j.e(b), pendingintent);
        c.contentView.setViewVisibility(j.e(b), 0);
        c.contentView.setViewVisibility(j.g(b), 0);
        c.contentView.setOnClickPendingIntent(j.g(b), pendingintent1);
        return this;
    }

    public s a(RemoteViews remoteviews)
    {
        c.contentView = remoteviews;
        return this;
    }

    public contentView a(CharSequence charsequence)
    {
        if (android.os.d.VERSION.SDK_INT >= 14)
        {
            d.setContentText(charsequence);
        }
        c.contentView.setTextViewText(j.a(b), charsequence);
        return this;
    }

    public void a(int i, String s, PendingIntent pendingintent)
    {
        if (android.os.d.VERSION.SDK_INT >= 16)
        {
            d.addAction(i, s, pendingintent);
        }
    }

    public  b()
    {
        int i = j.e(b);
        c.contentView.setTextViewText(i, b.getResources().getString(l.e(b.getApplicationContext())));
        c.contentView.setInt(i, "setBackgroundResource", u.upd.c.a(b).c("umeng_common_gradient_green"));
        return this;
    }

    public b b(CharSequence charsequence)
    {
        if (android.os.d.VERSION.SDK_INT >= 14)
        {
            d.setContentTitle(charsequence);
        }
        c.contentView.setTextViewText(j.d(b), charsequence);
        return this;
    }

    public b c()
    {
        int i = j.e(b);
        c.contentView.setTextViewText(i, b.getResources().getString(l.d(b.getApplicationContext())));
        c.contentView.setInt(i, "setBackgroundResource", u.upd.c.a(b).c("umeng_common_gradient_orange"));
        return this;
    }

    public Notification d()
    {
        if (android.os.d.VERSION.SDK_INT >= 16)
        {
            return d.build();
        }
        if (android.os.d.VERSION.SDK_INT >= 14)
        {
            return d.getNotification();
        } else
        {
            return c;
        }
    }

    public (Context context)
    {
        super(context);
    }
}
