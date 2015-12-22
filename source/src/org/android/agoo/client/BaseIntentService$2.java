// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.client;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.by;

// Referenced classes of package org.android.agoo.client:
//            BaseIntentService

class c
    implements Runnable
{

    final String a;
    final String b;
    final Context c;
    final BaseIntentService d;

    public void run()
    {
        if (!TextUtils.isEmpty(a) && TextUtils.equals(a, b))
        {
            aJ.c("BaseIntentService", (new StringBuilder()).append("restart---->[currentSudoPack:").append(a).append("]:[start]").toString());
            if (BaseIntentService.b(d))
            {
                aJ.c("BaseIntentService", (new StringBuilder()).append("enabledService---->[").append(b).append("/").append(d.getAgooService()).append("]").toString());
                bx.b(c, d.getAgooService());
            }
            by.a(c, d.getAgooService());
            return;
        }
        aJ.c("BaseIntentService", (new StringBuilder()).append("restart---->[currentSudoPack:").append(a).append("][currentPack:").append(b).append("]:[stop]").toString());
        if (BaseIntentService.b(d))
        {
            aJ.c("BaseIntentService", (new StringBuilder()).append("disableService---->[").append(b).append("/").append(d.getAgooService()).append("]").toString());
            bx.a(c, d.getAgooService());
        }
        by.b(c, d.getAgooService());
    }

    (BaseIntentService baseintentservice, String s, String s1, Context context)
    {
        d = baseintentservice;
        a = s;
        b = s1;
        c = context;
        super();
    }
}
