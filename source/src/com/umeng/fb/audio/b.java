// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.audio;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class b
{
    class a
        implements Runnable
    {

        final b a;

        public void run()
        {
            if (b.a(a) != null)
            {
                b.b(a);
            }
        }

        a()
        {
            a = b.this;
            super();
        }
    }


    private static String e;
    private static String f;
    private final String a = com/umeng/fb/audio/b.getName();
    private int b;
    private AudioRecord c;
    private boolean d;
    private long g;

    public b()
    {
        b = 0;
        d = false;
    }

    static AudioRecord a(b b1)
    {
        return b1.c;
    }

    static void b(b b1)
    {
        b1.e();
    }

    private boolean d()
    {
        boolean flag = true;
        b = AudioRecord.getMinBufferSize(16000, 16, 2) * 2;
        if (-2 == b)
        {
            flag = false;
        } else
        {
            c = new AudioRecord(1, 16000, 16, 2, b);
            if (c.getState() != 1)
            {
                return false;
            }
        }
        return flag;
    }

    private void e()
    {
        Object obj;
        byte abyte0[];
        if (c == null)
        {
            return;
        }
        abyte0 = new byte[b];
        try
        {
            obj = new File(e);
            if (((File) (obj)).exists())
            {
                ((File) (obj)).delete();
            }
            obj = new FileOutputStream(((File) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            obj = null;
        }
        c.startRecording();
_L3:
        if (d && -3 != c.read(abyte0, 0, b)) goto _L2; else goto _L1
_L1:
        a();
        try
        {
            ((FileOutputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
        return;
_L2:
        ((FileOutputStream) (obj)).write(abyte0);
        g = g + (long)b;
          goto _L3
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
          goto _L1
    }

    protected int a()
    {
        this;
        JVM INSTR monitorenter ;
        d = false;
        if (c == null) goto _L2; else goto _L1
_L1:
        int i = c.getRecordingState();
        if (1 != i) goto _L4; else goto _L3
_L3:
        i = -1;
_L6:
        this;
        JVM INSTR monitorexit ;
        return i;
_L4:
        c.stop();
        c.release();
        c = null;
_L2:
        i = b;
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    protected boolean a(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        e = s;
        f = s1;
        flag = d();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        d = true;
        g = 0L;
        (new Thread(new a())).start();
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    protected boolean b()
    {
        boolean flag = true;
        if (c.getRecordingState() == 1)
        {
            flag = false;
        }
        return flag;
    }

    public long c()
    {
        return g / 16000L / 2L;
    }
}
