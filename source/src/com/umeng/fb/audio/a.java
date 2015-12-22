// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.audio;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;

class a
{

    private final String a = com/umeng/fb/audio/a.getName();
    private AudioTrack b;
    private String c;

    public a(String s)
    {
        c = s;
    }

    protected void a()
    {
        Object obj = new File(c);
        int i = AudioTrack.getMinBufferSize(16000, 4, 2);
        byte abyte0[] = new byte[i];
        b = new AudioTrack(3, 16000, 4, 2, i * 2, 1);
        try
        {
            obj = new FileInputStream(((File) (obj)));
            b.play();
            ((FileInputStream) (obj)).read(abyte0);
            for (; ((FileInputStream) (obj)).read(abyte0) != -1; b.write(abyte0, 0, i)) { }
        }
        catch (Throwable throwable)
        {
            Log.d(a, "Playback Failed");
            return;
        }
        Message message = new Message();
        message.what = 0;
        com.umeng.fb.adapter.a.a().sendMessage(message);
        return;
    }

    protected void b()
    {
        if (b != null)
        {
            b.release();
            b = null;
        }
    }

    protected Boolean c()
    {
        boolean flag;
        if (b.getPlayState() == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }
}
