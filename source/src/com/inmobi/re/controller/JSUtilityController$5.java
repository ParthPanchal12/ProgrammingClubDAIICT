// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.ImageProcessing;
import com.inmobi.re.controller.util.StartActivityForResultCallback;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class a
    implements StartActivityForResultCallback
{

    final Uri a;
    final JSUtilityController b;

    public void onActivityResult(int i, Intent intent)
    {
        if (i == -1)
        {
            int j;
            if (intent == null)
            {
                intent = ImageProcessing.convertMediaUriToPath(a, b.mContext);
            } else
            {
                intent = ImageProcessing.convertMediaUriToPath(intent.getData(), b.mContext);
            }
            intent = ImageProcessing.getCompressedBitmap(intent, b.mContext);
            i = intent.getWidth();
            j = intent.getHeight();
            intent = ImageProcessing.getBase64EncodedImage(intent, b.mContext);
            b.imWebView.raiseCameraPictureCapturedEvent(intent, i, j);
            return;
        } else
        {
            b.imWebView.raiseError("User did not take a picture", "takeCameraPicture");
            return;
        }
    }

    esultCallback(JSUtilityController jsutilitycontroller, Uri uri)
    {
        b = jsutilitycontroller;
        a = uri;
        super();
    }
}
