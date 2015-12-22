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
//            WidgeGametActivity

class this._cls0
    implements IMNativeListener
{

    final WidgeGametActivity this$0;

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        WidgeGametActivity.access$12(WidgeGametActivity.this).setVisibility(8);
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        WidgeGametActivity.access$11(WidgeGametActivity.this, imnative);
        Log.e("frfr", (new StringBuilder()).append(imnative).append("//////////").toString());
        if (imnative != null)
        {
            imnative.attachToView(WidgeGametActivity.access$12(WidgeGametActivity.this));
        }
        imnative = imnative.getContent();
        WidgeGametActivity.access$12(WidgeGametActivity.this).setVisibility(0);
        WidgeGametActivity.access$13(WidgeGametActivity.this).setVisibility(0);
        WidgeGametActivity.access$14(WidgeGametActivity.this, true);
        try
        {
            imnative = new JSONObject(imnative);
            WidgeGametActivity.access$15(WidgeGametActivity.this).setText(imnative.getString("title"));
            WidgeGametActivity.access$16(WidgeGametActivity.this, imnative.getString("landingURL"));
            imnative = imnative.getJSONObject("icon");
            WidgeGametActivity.access$17(WidgeGametActivity.this).asyncLoadImage(imnative.getString("url"), WidgeGametActivity.access$18(WidgeGametActivity.this));
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
