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
//            AdultActivity

class this._cls0
    implements IMNativeListener
{

    final AdultActivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        AdultActivity.access$10(AdultActivity.this, false);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        AdultActivity.access$8(AdultActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(AdultActivity.access$9(AdultActivity.this));
        }
        imnative = imnative.getContent();
        AdultActivity.access$10(AdultActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            AdultActivity.access$11(AdultActivity.this, imnative.getString("landingURL"));
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
        this$0 = AdultActivity.this;
        super();
    }
}
