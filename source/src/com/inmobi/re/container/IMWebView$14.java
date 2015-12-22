// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.FrameLayout;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class a
    implements android.media.nCompletionListener
{

    final IMWebView a;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        try
        {
            mediaplayer.stop();
            IMWebView.j(a).setVisibility(8);
            IMWebView.m(a);
            IMWebView.i(a).setContentView(IMWebView.o(a));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Media Player onCompletion", mediaplayer);
        }
    }

    nListener(IMWebView imwebview)
    {
        a = imwebview;
        super();
    }
}
