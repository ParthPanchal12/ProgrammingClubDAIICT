// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

// Referenced classes of package com.umeng.message.proguard:
//            br, aN

static final class a
    implements Runnable
{

    final Context a;

    public void run()
    {
        Object obj;
        try
        {
            obj = a.getPackageManager();
            if (TextUtils.equals(br.a(), br.b().toLowerCase()) && ((PackageManager) (obj)).getPackageInfo("com.huawei.android.pushagent", 4) != null)
            {
                aN.i(a, "agoo_huawei");
            }
            if (!TextUtils.equals(br.c(), br.b().toLowerCase()))
            {
                break MISSING_BLOCK_LABEL_87;
            }
            obj = ((PackageManager) (obj)).getPackageInfo("com.xiaomi.xmsf", 4);
        }
        catch (Throwable throwable)
        {
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (((PackageInfo) (obj)).versionCode >= 105)
        {
            aN.i(a, "agoo_xiaomi");
        }
    }

    r(Context context)
    {
        a = context;
        super();
    }
}
