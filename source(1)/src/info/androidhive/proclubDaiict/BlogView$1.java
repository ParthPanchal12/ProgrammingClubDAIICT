// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package info.androidhive.proclubDaiict:
//            BlogView

class this._cls0
    implements android.view.kListener
{

    final BlogView this$0;

    public void onClick(View view)
    {
        view = new Intent("info.androidhive.proclubDaiict.COMMENTVIEW");
        Bundle bundle = new Bundle();
        bundle.putString("comments", array);
        view.putExtras(bundle);
        startActivity(view);
    }

    ()
    {
        this$0 = BlogView.this;
        super();
    }
}
