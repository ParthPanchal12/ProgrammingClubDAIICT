// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.allinone.free.utils.ProgressWheel;
import com.ant.liao.GifView;
import java.io.File;

// Referenced classes of package com.allinone.free.activity:
//            FunGifActivity

class this._cls0 extends Handler
{

    final FunGifActivity this$0;

    public void handleMessage(Message message)
    {
        if (message.what == 291)
        {
            FunGifActivity.access$0(FunGifActivity.this).setVisibility(8);
            FunGifActivity.access$1(FunGifActivity.this).setVisibility(8);
            message = (File)message.obj;
            FunGifActivity.access$2(FunGifActivity.this).setGifImage(message.getAbsolutePath());
            FunGifActivity.access$3(FunGifActivity.this, FunGifActivity.access$2(FunGifActivity.this).getViewTreeObserver());
        }
    }

    ()
    {
        this$0 = FunGifActivity.this;
        super();
    }
}
