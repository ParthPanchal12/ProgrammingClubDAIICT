// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.inmobi.monetization.IMNative;

// Referenced classes of package com.allinone.free.activity:
//            WidgePaidActivity

class this._cls0
    implements android.view.
{

    final WidgePaidActivity this$0;

    public void onClick(View view)
    {
        try
        {
            view = new Intent("android.intent.action.VIEW", Uri.parse(WidgePaidActivity.access$3(WidgePaidActivity.this)));
            startActivity(view);
            if (WidgePaidActivity.access$4(WidgePaidActivity.this) != null)
            {
                WidgePaidActivity.access$4(WidgePaidActivity.this).handleClick(null);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    ()
    {
        this$0 = WidgePaidActivity.this;
        super();
    }
}
