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
//            AppDetailsActivity

class this._cls0
    implements IMNativeListener
{

    final AppDetailsActivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        AppDetailsActivity.access$47(AppDetailsActivity.this, false);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        AppDetailsActivity.access$45(AppDetailsActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(AppDetailsActivity.access$46(AppDetailsActivity.this));
        }
        imnative = imnative.getContent();
        AppDetailsActivity.access$47(AppDetailsActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            AppDetailsActivity.access$48(AppDetailsActivity.this, imnative.getString("landingURL"));
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
        this$0 = AppDetailsActivity.this;
        super();
    }
}
