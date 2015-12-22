// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.net.mtop;

import android.content.Context;
import com.umeng.message.proguard.bb;

// Referenced classes of package org.android.agoo.net.mtop:
//            MtopRequest, Result

public interface IMtopSynClient
{

    public abstract com.umeng.message.proguard.bd.a get(Context context, String s, bb bb)
        throws Throwable;

    public abstract Result getV3(Context context, MtopRequest mtoprequest);

    public abstract void setBaseUrl(String s);

    public abstract void setDefaultAppSecret(String s);

    public abstract void setDefaultAppkey(String s);
}
