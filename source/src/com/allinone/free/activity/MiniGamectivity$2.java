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
//            MiniGamectivity

class this._cls0
    implements IMNativeListener
{

    final MiniGamectivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        MiniGamectivity.access$4(MiniGamectivity.this, false);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        MiniGamectivity.access$2(MiniGamectivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(MiniGamectivity.access$3(MiniGamectivity.this));
        }
        imnative = imnative.getContent();
        MiniGamectivity.access$4(MiniGamectivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            MiniGamectivity.access$5(MiniGamectivity.this, imnative.getString("landingURL"));
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
        this$0 = MiniGamectivity.this;
        super();
    }
}
