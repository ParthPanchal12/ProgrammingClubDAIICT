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
//            WidgeGametActivity

class this._cls0
    implements IMNativeListener
{

    final WidgeGametActivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        WidgeGametActivity.access$9(WidgeGametActivity.this, false);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        WidgeGametActivity.access$7(WidgeGametActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(WidgeGametActivity.access$8(WidgeGametActivity.this));
        }
        imnative = imnative.getContent();
        WidgeGametActivity.access$9(WidgeGametActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            WidgeGametActivity.access$10(WidgeGametActivity.this, imnative.getString("landingURL"));
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
        this$0 = WidgeGametActivity.this;
        super();
    }
}
