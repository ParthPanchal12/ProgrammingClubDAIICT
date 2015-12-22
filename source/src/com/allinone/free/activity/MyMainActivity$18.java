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
//            MyMainActivity

class this._cls0
    implements IMNativeListener
{

    final MyMainActivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        MyMainActivity.access$50(MyMainActivity.this, false);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        MyMainActivity.access$48(MyMainActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(MyMainActivity.access$49(MyMainActivity.this));
        }
        imnative = imnative.getContent();
        MyMainActivity.access$50(MyMainActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            MyMainActivity.access$51(MyMainActivity.this, imnative.getString("landingURL"));
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
        this$0 = MyMainActivity.this;
        super();
    }
}
