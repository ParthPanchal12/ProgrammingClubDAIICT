// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.media.AudioRecord;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            AudioTriggerCallback

public class AudioTriggerer
{

    static boolean a;
    public static AudioRecord audioRecorder = null;
    static boolean b;
    static Timer c;
    public static List callbacks = new ArrayList();
    static long d = 0L;
    static long e = 50L;
    private static int f[] = {
        8000, 11025, 22050, 44100
    };

    public AudioTriggerer()
    {
    }

    static void a()
    {
        d();
    }

    private static void a(double d1)
    {
        for (Iterator iterator = callbacks.iterator(); iterator.hasNext();)
        {
            AudioTriggerCallback audiotriggercallback = (AudioTriggerCallback)iterator.next();
            try
            {
                audiotriggercallback.audioLevel(d1);
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "AudioTriggerer: One of the mic listeners has a problem.");
            }
        }

    }

    public static void addEventListener(AudioTriggerCallback audiotriggercallback)
    {
        callbacks.add(audiotriggercallback);
        if (callbacks.size() == 1)
        {
            b();
        }
    }

    private static void b()
    {
        a = true;
        audioRecorder = h();
        c = new Timer();
        c.scheduleAtFixedRate(new TimerTask() {

            public void run()
            {
                AudioTriggerer.a();
            }

        }, d, e);
    }

    private static void c()
    {
        a = false;
        if (audioRecorder == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        if (f())
        {
            g();
        }
        audioRecorder.stop();
        audioRecorder.release();
        c.cancel();
        c.purge();
        return;
        Object obj;
        obj;
        ((IllegalStateException) (obj)).printStackTrace();
        return;
        obj;
        ((RuntimeException) (obj)).printStackTrace();
        return;
    }

    private static void d()
    {
        while (audioRecorder == null || audioRecorder.getState() != 1) 
        {
            return;
        }
        short aword0[] = new short[512];
        float af[] = new float[3];
        b = true;
        float f1;
        int j;
        try
        {
            audioRecorder.startRecording();
        }
        catch (Exception exception)
        {
            return;
        }
        for (; f(); a(f1 / (float)j / 32F))
        {
            j = audioRecorder.read(aword0, 0, aword0.length);
            int i = 0;
            float f2;
            for (f1 = 0.0F; i < j; f1 = f2)
            {
                short word0 = (short)(aword0[i] | aword0[i + 1]);
                f2 = f1;
                if (word0 != 0)
                {
                    f2 = f1 + (float)(Math.abs(word0) / j);
                }
                i += 2;
            }

            af[0] = f1;
            i = 0;
            f1 = 0.0F;
            for (; i < 3; i++)
            {
                f1 += af[i];
            }

        }

        e();
    }

    private static void e()
    {
        if (audioRecorder == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        if (f())
        {
            g();
        }
        audioRecorder.stop();
        audioRecorder.release();
        return;
        Object obj;
        obj;
        ((IllegalStateException) (obj)).printStackTrace();
        return;
        obj;
        ((RuntimeException) (obj)).printStackTrace();
        return;
    }

    private static boolean f()
    {
        return b;
    }

    private static void g()
    {
        b = false;
    }

    private static AudioRecord h()
    {
        int ai[];
        int i;
        int l;
        ai = f;
        l = ai.length;
        i = 0;
_L8:
        if (i >= l) goto _L2; else goto _L1
_L1:
        short aword0[];
        int j;
        int i1;
        int j1;
        i1 = ai[i];
        aword0 = new short[2];
        aword0;
        aword0[0] = 3;
        aword0[1] = 2;
        j1 = aword0.length;
        j = 0;
_L7:
        short aword1[];
        int k;
        short word0;
        int k1;
        if (j >= j1)
        {
            continue; /* Loop/switch isn't completed */
        }
        word0 = aword0[j];
        aword1 = new short[2];
        aword1;
        aword1[0] = 16;
        aword1[1] = 12;
        k1 = aword1.length;
        k = 0;
_L5:
        if (k >= k1) goto _L4; else goto _L3
_L3:
        int l1 = aword1[k];
        int i2 = AudioRecord.getMinBufferSize(i1, l1, word0);
        if (i2 == -2)
        {
            continue; /* Loop/switch isn't completed */
        }
        AudioRecord audiorecord;
        audiorecord = new AudioRecord(0, i1, l1, word0, i2);
        l1 = audiorecord.getState();
        if (l1 == 1)
        {
            return audiorecord;
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        k++;
          goto _L5
_L4:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
        i++;
          goto _L8
_L2:
        return null;
    }

    public static void removeEventListener(AudioTriggerCallback audiotriggercallback)
    {
        callbacks.remove(audiotriggercallback);
        if (callbacks.size() == 0)
        {
            c();
        }
    }

}
