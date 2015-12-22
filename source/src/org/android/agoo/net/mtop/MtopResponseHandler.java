// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.net.mtop;

import com.umeng.message.proguard.aZ;

// Referenced classes of package org.android.agoo.net.mtop:
//            MtopResponseHelper, Result

public abstract class MtopResponseHandler extends aZ
{

    public static final String ERROR_SERVICE_NOT_AVAILABLE = "ERROR_SERVICE_NOT_AVAILABLE";
    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "SUCCESS";

    public MtopResponseHandler()
    {
    }

    protected void b(String s)
    {
        Result result;
        try
        {
            result = MtopResponseHelper.parse(s);
            if (result.isSuccess())
            {
                onSuccess(result.getData());
                return;
            }
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            onFailure(throwable, s);
            return;
        }
        onFailure(result.getRetCode(), result.getRetDesc());
        return;
    }

    public void onFailure(String s, String s1)
    {
    }

    public void onFailure(Throwable throwable, String s)
    {
        onFailure("ERROR_SERVICE_NOT_AVAILABLE", s);
    }
}
