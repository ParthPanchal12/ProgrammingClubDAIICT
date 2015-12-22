// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.ViewGroup;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayerListener;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDAudioVideoController

class a
    implements AVPlayerListener
{

    final com.inmobi.re.controller.s a;
    final MRAIDAudioVideoController b;

    public void onComplete(AVPlayer avplayer)
    {
        ViewGroup viewgroup;
        if (!a.isFullScreen())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        viewgroup = (ViewGroup)avplayer.getBackGroundLayout().getParent();
        if (viewgroup != null)
        {
            try
            {
                viewgroup.removeView(avplayer.getBackGroundLayout());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AVPlayer avplayer)
            {
                Log.debug("[InMobi]-[RE]-4.5.5", "Problem removing the audio relativelayout", avplayer);
            }
        }
        break MISSING_BLOCK_LABEL_61;
        viewgroup = (ViewGroup)avplayer.getParent();
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        viewgroup.removeView(avplayer);
        return;
    }

    public void onError(AVPlayer avplayer)
    {
        onComplete(avplayer);
    }

    public void onPrepared(AVPlayer avplayer)
    {
    }

    (MRAIDAudioVideoController mraidaudiovideocontroller, com.inmobi.re.controller.s s)
    {
        b = mraidaudiovideocontroller;
        a = s;
        super();
    }
}
