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
//            WidgePaidActivity

class this._cls0
    implements IMNativeListener
{

    final WidgePaidActivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        WidgePaidActivity.access$7(WidgePaidActivity.this, false);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        WidgePaidActivity.access$5(WidgePaidActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(WidgePaidActivity.access$6(WidgePaidActivity.this));
        }
        imnative = imnative.getContent();
        WidgePaidActivity.access$7(WidgePaidActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            WidgePaidActivity.access$8(WidgePaidActivity.this, imnative.getString("landingURL"));
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
        this$0 = WidgePaidActivity.this;
        super();
    }
}
