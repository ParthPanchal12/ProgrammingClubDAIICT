// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.net.mtop;

import android.content.Context;
import com.umeng.message.proguard.aX;

// Referenced classes of package org.android.agoo.net.mtop:
//            IMtopAsynClient, MtopRequestHelper, MtopResponseHandler, MtopRequest

public class MtopAsyncClientV3 extends aX
    implements IMtopAsynClient
{

    private String b;
    private String c;
    private String d;

    public MtopAsyncClientV3()
    {
    }

    public void getV3(Context context, MtopRequest mtoprequest, MtopResponseHandler mtopresponsehandler)
    {
        try
        {
            MtopRequestHelper.checkAppKeyAndAppSecret(mtoprequest, b, c);
            mtoprequest = MtopRequestHelper.getUrlWithRequestParams(context, mtoprequest);
            get(context, d, mtoprequest, mtopresponsehandler);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mtopresponsehandler.onFailure(context);
        }
    }

    public void setBaseUrl(String s)
    {
        d = s;
    }

    public void setDefaultAppSecret(String s)
    {
        c = s;
    }

    public void setDefaultAppkey(String s)
    {
        b = s;
    }
}
