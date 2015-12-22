// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.allinone.free.utils.ProgressWheel;

// Referenced classes of package com.allinone.free.fragments:
//            Ringtone_Popular_Fragment

class this._cls0 extends BroadcastReceiver
{

    final Ringtone_Popular_Fragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        Ringtone_Popular_Fragment.access$0(Ringtone_Popular_Fragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = Ringtone_Popular_Fragment.this;
        super();
    }
}
