// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.net.mtop;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.proguard.bd;

// Referenced classes of package org.android.agoo.net.mtop:
//            IMtopSynClient, MtopRequestHelper, Result, MtopResponseHelper, 
//            MtopRequest

public class MtopSyncClientV3 extends bd
    implements IMtopSynClient
{

    private volatile String a;
    private volatile String b;
    private volatile String c;

    public MtopSyncClientV3()
    {
    }

    public Result getV3(Context context, MtopRequest mtoprequest)
    {
        MtopRequestHelper.checkAppKeyAndAppSecret(mtoprequest, a, b);
        mtoprequest = MtopRequestHelper.getUrlWithRequestParams(context, mtoprequest);
        context = get(context, c, mtoprequest).b;
        if (!TextUtils.isEmpty(context))
        {
            break MISSING_BLOCK_LABEL_60;
        }
        context = new Result();
        context.setSuccess(false);
        context.setRetDesc("request result is null");
        return context;
        try
        {
            context = MtopResponseHelper.parse(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mtoprequest = new Result();
            mtoprequest.setSuccess(false);
            mtoprequest.setRetDesc(context.getMessage());
            return mtoprequest;
        }
        return context;
    }

    public void setBaseUrl(String s)
    {
        c = s;
    }

    public void setDefaultAppSecret(String s)
    {
        b = s;
    }

    public void setDefaultAppkey(String s)
    {
        a = s;
    }
}
