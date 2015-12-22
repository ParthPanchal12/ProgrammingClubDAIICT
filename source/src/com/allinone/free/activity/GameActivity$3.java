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
//            GameActivity

class this._cls0
    implements IMNativeListener
{

    final GameActivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        GameActivity.access$10(GameActivity.this, false);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        GameActivity.access$8(GameActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(GameActivity.access$9(GameActivity.this));
        }
        imnative = imnative.getContent();
        GameActivity.access$10(GameActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            GameActivity.access$11(GameActivity.this, imnative.getString("landingURL"));
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
        this$0 = GameActivity.this;
        super();
    }
}
