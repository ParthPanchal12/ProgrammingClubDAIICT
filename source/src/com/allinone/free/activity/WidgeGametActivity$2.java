// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.inmobi.monetization.IMNative;

// Referenced classes of package com.allinone.free.activity:
//            WidgeGametActivity

class this._cls0
    implements android.view.metActivity._cls2
{

    final WidgeGametActivity this$0;

    public void onClick(View view)
    {
        try
        {
            view = new Intent("android.intent.action.VIEW", Uri.parse(WidgeGametActivity.access$5(WidgeGametActivity.this)));
            startActivity(view);
            if (WidgeGametActivity.access$6(WidgeGametActivity.this) != null)
            {
                WidgeGametActivity.access$6(WidgeGametActivity.this).handleClick(null);
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
        this$0 = WidgeGametActivity.this;
        super();
    }
}
