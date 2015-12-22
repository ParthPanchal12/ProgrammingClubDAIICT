// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.os.Handler;
import com.allinone.free.utils.MD5;
import com.allinone.free.utils.Myutils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.allinone.free.activity:
//            FunGifActivity

class this._cls0
    implements Runnable
{

    final FunGifActivity this$0;

    public void run()
    {
        File file = new File(new File(Myutils.cachePath), MD5.getMd5Name(FunGifActivity.access$4(FunGifActivity.this)));
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        FunGifActivity.access$5(FunGifActivity.this).sendMessage(FunGifActivity.access$5(FunGifActivity.this).obtainMessage(291, file));
_L4:
        return;
_L2:
        Object obj;
        obj = (HttpURLConnection)(new URL(FunGifActivity.access$4(FunGifActivity.this))).openConnection();
        ((HttpURLConnection) (obj)).setConnectTimeout(60000);
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        if (((HttpURLConnection) (obj)).getResponseCode() != 200) goto _L4; else goto _L3
_L3:
        FileOutputStream fileoutputstream;
        byte abyte0[];
        fileoutputstream = new FileOutputStream(file);
        obj = ((HttpURLConnection) (obj)).getInputStream();
        abyte0 = new byte[1024];
_L5:
        int i = ((InputStream) (obj)).read(abyte0);
        if (i == -1)
        {
            try
            {
                ((InputStream) (obj)).close();
                fileoutputstream.close();
                FunGifActivity.access$5(FunGifActivity.this).sendMessage(FunGifActivity.access$5(FunGifActivity.this).obtainMessage(291, file));
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            return;
        }
        fileoutputstream.write(abyte0, 0, i);
          goto _L5
    }

    ()
    {
        this$0 = FunGifActivity.this;
        super();
    }
}
