// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.utils.Player;

// Referenced classes of package com.allinone.free.fragments:
//            Mp3_Recent_Fragment

class this._cls0 extends Handler
{

    final Mp3_Recent_Fragment this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 100: // 'd'
            break;
        }
        try
        {
            Mp3_Recent_Fragment.access$1(Mp3_Recent_Fragment.this).setText((new StringBuilder(String.valueOf(Player.formatTime(Mp3_Recent_Fragment.access$2(Mp3_Recent_Fragment.this).mediaPlayer.getCurrentPosition())))).toString());
            if (Mp3_Recent_Fragment.access$3(Mp3_Recent_Fragment.this).getVisibility() == 8)
            {
                Mp3_Recent_Fragment.access$2(Mp3_Recent_Fragment.this).pause();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            return;
        }
    }

    ()
    {
        this$0 = Mp3_Recent_Fragment.this;
        super();
    }
}
