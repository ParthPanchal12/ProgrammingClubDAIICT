// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.audio;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.umeng.fb.fragment.FeedbackFragment;
import com.umeng.fb.opus.OpusTool;
import com.umeng.fb.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class com.umeng.fb.audio.c
{
    public static interface a
    {

        public abstract void a(String s, int i);
    }

    class b extends AsyncTask
    {

        final com.umeng.fb.audio.c a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private int g;
        private c h;

        protected transient Integer a(Void avoid[])
        {
            int i = 0;
            static class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[c.values().length];
                    try
                    {
                        a[c.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[c.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[c.c.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1.a[h.ordinal()];
            JVM INSTR tableswitch 1 3: default 40
        //                       1 45
        //                       2 67
        //                       3 86;
               goto _L1 _L2 _L3 _L4
_L1:
            return Integer.valueOf(i);
_L2:
            com.umeng.fb.audio.c.a(a, b, c, g);
            continue; /* Loop/switch isn't completed */
_L3:
            i = com.umeng.fb.audio.c.a(a, c, e);
            continue; /* Loop/switch isn't completed */
_L4:
            i = a.a(e, d);
            if (true) goto _L1; else goto _L5
_L5:
        }

        protected void a(Integer integer)
        {
            switch (_cls1.a[h.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                com.umeng.fb.audio.c.a(a, f, integer.intValue());
                return;

            case 2: // '\002'
                com.umeng.fb.audio.c.a(a, c, e, f, integer.intValue());
                return;

            case 3: // '\003'
                com.umeng.fb.audio.c.b(a, d, integer.intValue());
                break;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Integer)obj);
        }

        public b(String s, int i, c c2)
        {
            a = com.umeng.fb.audio.c.this;
            super();
            b = (new StringBuilder()).append(com.umeng.fb.util.c.c(com.umeng.fb.audio.c.a(com.umeng.fb.audio.c.this))).append(s).append(".raw").toString();
            c = (new StringBuilder()).append(com.umeng.fb.util.c.c(com.umeng.fb.audio.c.a(com.umeng.fb.audio.c.this))).append(s).append(".wav").toString();
            d = (new StringBuilder()).append(com.umeng.fb.util.c.c(com.umeng.fb.audio.c.a(com.umeng.fb.audio.c.this))).append(s).append("cache.wav").toString();
            e = (new StringBuilder()).append(com.umeng.fb.util.c.b(com.umeng.fb.audio.c.a(com.umeng.fb.audio.c.this))).append(s).append(".opus").toString();
            f = s;
            g = i;
            h = c2;
            com.umeng.fb.audio.c.b(com.umeng.fb.audio.c.this);
            Log.c(com.umeng.fb.audio.c.c(com.umeng.fb.audio.c.this), "TranscodeTask create task");
        }
    }

    static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        private static final c d[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/umeng/fb/audio/c$c, s);
        }

        public static c[] values()
        {
            return (c[])d.clone();
        }

        static 
        {
            a = new c("PCM_TO_WAVE", 0);
            b = new c("WAVE_TO_OPUS", 1);
            c = new c("OPUS_TO_WAVE", 2);
            d = (new c[] {
                a, b, c
            });
        }

        private c(String s, int i)
        {
            super(s, i);
        }
    }


    private final String a = com/umeng/fb/audio/c.getName();
    private OpusTool b;
    private int c;
    private final int d = 5;
    private Context e;
    private a f;

    public com.umeng.fb.audio.c(Context context)
    {
        e = context;
        b = new OpusTool(context);
    }

    static int a(com.umeng.fb.audio.c c1, String s, String s1)
    {
        return c1.b(s, s1);
    }

    static Context a(com.umeng.fb.audio.c c1)
    {
        return c1.e;
    }

    static void a(com.umeng.fb.audio.c c1, String s, int i)
    {
        c1.c(s, i);
    }

    static void a(com.umeng.fb.audio.c c1, String s, String s1, int i)
    {
        c1.a(s, s1, i);
    }

    static void a(com.umeng.fb.audio.c c1, String s, String s1, String s2, int i)
    {
        c1.a(s, s1, s2, i);
    }

    private void a(FileOutputStream fileoutputstream, long l, long l1, long l2, 
            int i, long l3)
        throws IOException
    {
        fileoutputstream.write(new byte[] {
            82, 73, 70, 70, (byte)(int)(255L & l1), (byte)(int)(l1 >> 8 & 255L), (byte)(int)(l1 >> 16 & 255L), (byte)(int)(l1 >> 24 & 255L), 87, 65, 
            86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 
            1, 0, (byte)i, 0, (byte)(int)(255L & l2), (byte)(int)(l2 >> 8 & 255L), (byte)(int)(l2 >> 16 & 255L), (byte)(int)(l2 >> 24 & 255L), (byte)(int)(255L & l3), (byte)(int)(l3 >> 8 & 255L), 
            (byte)(int)(l3 >> 16 & 255L), (byte)(int)(l3 >> 24 & 255L), (byte)((i * 16) / 8), 0, 16, 0, 100, 97, 116, 97, 
            (byte)(int)(255L & l), (byte)(int)(l >> 8 & 255L), (byte)(int)(l >> 16 & 255L), (byte)(int)(l >> 24 & 255L)
        }, 0, 44);
    }

    private void a(String s, String s1, int i)
    {
        byte abyte0[];
        long l;
        l = 32000;
        abyte0 = new byte[i];
        Object obj;
        obj = new File(s);
        s1 = new File(s1);
        if (!((File) (obj)).exists())
        {
            return;
        }
        obj = new FileInputStream(((File) (obj)));
        s1 = new FileOutputStream(s1);
        long l1 = ((FileInputStream) (obj)).available();
        a(((FileOutputStream) (s1)), l1, 36L + l1, 16000L, 1, l);
        for (; ((FileInputStream) (obj)).read(abyte0) != -1; s1.write(abyte0)) { }
        try
        {
            ((FileInputStream) (obj)).close();
            s1.close();
            com.umeng.fb.util.c.b(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
    }

    private void a(String s, String s1, String s2, int i)
    {
label0:
        {
            if (i != -1)
            {
                File file = new File(s);
                s1 = new File(s1);
                if (file.length() / s1.length() <= 18L || c >= 5)
                {
                    break label0;
                }
                s1.delete();
                (new b(s2, -1, c.b)).execute(new Void[0]);
            }
            return;
        }
        s1 = new Message();
        s1.what = 0;
        FeedbackFragment.getHandler().sendMessage(s1);
        com.umeng.fb.util.c.b(s);
    }

    static int b(com.umeng.fb.audio.c c1)
    {
        int i = c1.c;
        c1.c = i + 1;
        return i;
    }

    private int b(String s, String s1)
    {
        if (!com.umeng.fb.util.c.c(s))
        {
            try
            {
                Thread.sleep(300L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
        return b.b(s, s1);
    }

    static void b(com.umeng.fb.audio.c c1, String s, int i)
    {
        c1.d(s, i);
    }

    static String c(com.umeng.fb.audio.c c1)
    {
        return c1.a;
    }

    private void c(String s, int i)
    {
        (new b(s, -1, c.b)).execute(new Void[0]);
    }

    private void d(String s, int i)
    {
        f.a(s, i);
    }

    public int a(String s, String s1)
    {
        if (!(new File(s1)).exists())
        {
            return b.a(s, s1);
        } else
        {
            return -1;
        }
    }

    public void a(a a1)
    {
        f = a1;
    }

    public void a(String s)
    {
        c = 0;
        (new b(s, -1, c.c)).execute(new Void[0]);
    }

    public void a(String s, int i)
    {
        c = 0;
        b(s, i);
    }

    public void b(String s, int i)
    {
        (new b(s, i, c.a)).execute(new Void[0]);
    }
}
