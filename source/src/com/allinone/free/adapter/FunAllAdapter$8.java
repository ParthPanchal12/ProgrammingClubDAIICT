// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.allinone.free.model.FunModel;
import com.allinone.free.utils.publicTools;
import java.util.List;

// Referenced classes of package com.allinone.free.adapter:
//            FunAllAdapter

class val.position
    implements android.view.ener
{

    final FunAllAdapter this$0;
    private final int val$position;

    public void onClick(View view)
    {
        String s = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getSerial()).append("&type=like").toString();
        Log.e("www", (new StringBuilder("url=+")).append(s).toString());
        publicTools.getUrl(s);
        ((RelativeLayout)view).setBackgroundResource(0x7f08002c);
    }

    ()
    {
        this$0 = final_funalladapter;
        val$position = I.this;
        super();
    }
}
