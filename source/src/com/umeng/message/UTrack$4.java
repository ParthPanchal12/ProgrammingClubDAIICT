// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import com.umeng.common.message.Log;
import com.umeng.message.proguard.aE;
import com.umeng.message.proguard.ax;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message:
//            UTrack, MsgConstant, UmengRegistrar

class a
    implements Runnable
{

    final UTrack a;

    public void run()
    {
        Object obj;
        obj = UTrack.b(a);
        Object obj2 = UTrack.c(a);
        if (!ax.d(((String) (obj2))))
        {
            Log.c(UTrack.a(), (new StringBuilder()).append("TestDevice sign =").append(((String) (obj2))).toString());
            ((JSONObject) (obj)).put("TD", obj2);
        }
        obj2 = new aE(UTrack.a(a));
        obj = ((aE) (obj2)).a(((aE) (obj2)).a(((JSONObject) (obj))), MsgConstant.REGISTER_ENDPOINT);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        if (((com.umeng.message.proguard.ER_ENDPOINT) (obj)).NT().uals(com.umeng.message.proguard.uals))
        {
            UmengRegistrar.a(UTrack.a(a), true);
        }
        UTrack.c(false);
        return;
        Object obj1;
        obj1;
        ((com.umeng.message.proguard.uals) (obj1)).tStackTrace();
        UTrack.c(false);
        return;
        obj1;
        ((Exception) (obj1)).printStackTrace();
        UTrack.c(false);
        return;
        obj1;
        UTrack.c(false);
        throw obj1;
    }

    aD.e(UTrack utrack)
    {
        a = utrack;
        super();
    }
}
