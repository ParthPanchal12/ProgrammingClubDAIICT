// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.update;

import android.content.Context;
import com.umeng.update.util.DeltaUpdate;
import org.json.JSONObject;
import u.upd.a;
import u.upd.b;
import u.upd.h;
import u.upd.n;

// Referenced classes of package com.umeng.update:
//            UpdateConfig

public class d extends h
{

    private final String d = com/umeng/update/d.getName();
    private final String e = "update";
    private JSONObject f;

    public d(Context context)
    {
        super(null);
        f = a(context);
    }

    private JSONObject a(Context context)
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("type", "update");
        jsonobject.put("appkey", UpdateConfig.getAppkey(context));
        jsonobject.put("version_code", u.upd.a.c(context));
        jsonobject.put("package", u.upd.a.u(context));
        jsonobject.put("idmd5", n.b(u.upd.a.f(context)));
        jsonobject.put("channel", UpdateConfig.getChannel(context));
        jsonobject.put("proto_ver", "1.4");
        jsonobject.put("sdk_version", "2.4.2.20140520");
        jsonobject.put("old_md5", DeltaUpdate.b(context));
        boolean flag;
        if (DeltaUpdate.a() && UpdateConfig.isDeltaUpdate())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            jsonobject.put("delta", flag);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            u.upd.b.b(d, "exception in updateInternal", context);
            return null;
        }
        return jsonobject;
    }

    public JSONObject a()
    {
        return f;
    }

    public String b()
    {
        return c;
    }
}
