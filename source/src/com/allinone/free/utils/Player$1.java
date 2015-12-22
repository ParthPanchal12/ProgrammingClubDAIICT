// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.utils;

import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.SeekBar;
import java.util.TimerTask;

// Referenced classes of package com.allinone.free.utils:
//            Player

class this._cls0 extends TimerTask
{

    final Player this$0;

    public void run()
    {
        while (mediaPlayer == null || !mediaPlayer.isPlaying() || Player.access$0(Player.this).isPressed()) 
        {
            return;
        }
        handler.sendEmptyMessage(0);
    }

    ()
    {
        this$0 = Player.this;
        super();
    }
}
