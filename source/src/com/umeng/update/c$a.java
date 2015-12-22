// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.app.Notification;
import android.content.Context;
import com.umeng.update.util.b;

// Referenced classes of package com.umeng.update:
//            c

class f extends b
{

    final c a;
    private String e;
    private String f;

    public Notification a()
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
            c.setLatestEventInfo(b, e, f, c.contentIntent);
            return c;
        }
    }

    public e a(CharSequence charsequence)
    {
        if (android.os.d.VERSION.SDK_INT >= 14)
        {
            d.setContentText(charsequence);
        }
        f = charsequence.toString();
        return this;
    }

    public e b(CharSequence charsequence)
    {
        if (android.os.d.VERSION.SDK_INT >= 14)
        {
            d.setContentTitle(charsequence);
        }
        e = charsequence.toString();
        return this;
    }

    public e c(CharSequence charsequence)
    {
        if (android.os.d.VERSION.SDK_INT >= 16)
        {
            d.setStyle((new android.app.fication.BigTextStyle()).bigText(charsequence));
        }
        return this;
    }

    public xt(c c1, Context context)
    {
        a = c1;
        super(context);
        e = "";
        f = "";
    }
}
