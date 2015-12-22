// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.allinone.free.mydownload.MyApplcation;
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
        WidgePaidActivity.access$10(WidgePaidActivity.this).setVisibility(8);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        WidgePaidActivity.access$9(WidgePaidActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(WidgePaidActivity.access$10(WidgePaidActivity.this));
        }
        imnative = imnative.getContent();
        WidgePaidActivity.access$10(WidgePaidActivity.this).setVisibility(0);
        WidgePaidActivity.access$11(WidgePaidActivity.this).setVisibility(0);
        WidgePaidActivity.access$12(WidgePaidActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            WidgePaidActivity.access$13(WidgePaidActivity.this).setText(imnative.getString("title"));
            WidgePaidActivity.access$14(WidgePaidActivity.this, imnative.getString("landingURL"));
            imnative = imnative.getJSONObject("icon");
            WidgePaidActivity.access$15(WidgePaidActivity.this).asyncLoadImage(imnative.getString("url"), WidgePaidActivity.access$16(WidgePaidActivity.this));
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
