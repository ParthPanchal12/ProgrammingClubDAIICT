// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.content.Context;
import com.umeng.update.util.DeltaUpdate;
import u.upd.g;

// Referenced classes of package com.umeng.update:
//            d, UpdateResponse

public class b extends g
{

    private static final String c = com/umeng/update/b.getName();
    Context a;
    private final String b[] = {
        "http://au.umeng.com/api/check_app_update", "http://au.umeng.co/api/check_app_update"
    };

    public b(Context context)
    {
        a = context;
    }

    public boolean a()
    {
        return false;
    }

    public UpdateResponse b()
    {
        UpdateResponse updateresponse;
        d d1;
        int i;
        u.upd.b.c(c, String.format("is .so file ready: %b", new Object[] {
            Boolean.valueOf(DeltaUpdate.a())
        }));
        d1 = new d(a);
        updateresponse = null;
        i = 0;
_L5:
        if (i < b.length) goto _L2; else goto _L1
_L1:
        return updateresponse;
_L2:
        UpdateResponse updateresponse1;
        d1.a(b[i]);
        updateresponse1 = (UpdateResponse)a(d1, com/umeng/update/UpdateResponse);
        updateresponse = updateresponse1;
        if (updateresponse1 != null) goto _L1; else goto _L3
_L3:
        i++;
        updateresponse = updateresponse1;
        if (true) goto _L5; else goto _L4
_L4:
    }

}
