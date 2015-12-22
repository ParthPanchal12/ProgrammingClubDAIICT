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
//            PaidforFreeActivity

class this._cls0
    implements IMNativeListener
{

    final PaidforFreeActivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        PaidforFreeActivity.access$10(PaidforFreeActivity.this, false);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        PaidforFreeActivity.access$8(PaidforFreeActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(PaidforFreeActivity.access$9(PaidforFreeActivity.this));
        }
        imnative = imnative.getContent();
        PaidforFreeActivity.access$10(PaidforFreeActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            PaidforFreeActivity.access$11(PaidforFreeActivity.this, imnative.getString("landingURL"));
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
        this$0 = PaidforFreeActivity.this;
        super();
    }
}
