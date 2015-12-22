// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.util.Log;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.activity:
//            FunActivity

class this._cls0
    implements IMNativeListener
{

    final FunActivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        FunActivity.access$2(FunActivity.this, false);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        FunActivity.access$1(FunActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        imnative = imnative.getContent();
        FunActivity.access$2(FunActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            FunActivity.access$3(FunActivity.this, imnative.getString("landingURL"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IMNative imnative)
        {
            imnative.printStackTrace();
        }
    }

    ()
    {
        this$0 = FunActivity.this;
        super();
    }
}
