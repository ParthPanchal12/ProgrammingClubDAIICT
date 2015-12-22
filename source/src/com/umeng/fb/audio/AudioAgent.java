// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.audio;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.fb.util.Log;
import com.umeng.fb.util.c;
import java.io.File;

// Referenced classes of package com.umeng.fb.audio:
//            b, c, a

public class AudioAgent
{
    class a
        implements c.a
    {

        final AudioAgent a;

        public void a(String s, int i1)
        {
            if (!(new File(s)).exists())
            {
                return;
            }
            try
            {
                AudioAgent.a(a, new com.umeng.fb.audio.a(s));
                if (com.umeng.fb.audio.AudioAgent.c(a) == null)
                {
                    AudioAgent.a(a, new Thread(a. new b()));
                }
                com.umeng.fb.audio.AudioAgent.c(a).start();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.b(AudioAgent.b(a), s.getMessage());
            }
        }

        a()
        {
            a = AudioAgent.this;
            super();
        }
    }

    class b
        implements Runnable
    {

        final AudioAgent a;

        public void run()
        {
            try
            {
                if (AudioAgent.a(a) != null)
                {
                    AudioAgent.a(a).a();
                }
                return;
            }
            catch (Exception exception)
            {
                Log.b(AudioAgent.b(a), exception.getMessage());
            }
        }

        b()
        {
            a = AudioAgent.this;
            super();
        }
    }


    protected static final int a = 16000;
    protected static final int b = 2;
    protected static final int c = 1;
    protected static final int d = 16;
    protected static final int e = 4;
    protected static final int f = 3;
    private static AudioAgent j;
    private final String g = com/umeng/fb/audio/AudioAgent.getName();
    private com.umeng.fb.audio.b h;
    private com.umeng.fb.audio.c i;
    private boolean k;
    private String l;
    private Context m;
    private Thread n;
    private com.umeng.fb.audio.a o;

    private AudioAgent(Context context)
    {
        m = context;
        h = new com.umeng.fb.audio.b();
        i = new com.umeng.fb.audio.c(m);
        i.a(new a());
    }

    static com.umeng.fb.audio.a a(AudioAgent audioagent)
    {
        return audioagent.o;
    }

    static com.umeng.fb.audio.a a(AudioAgent audioagent, com.umeng.fb.audio.a a1)
    {
        audioagent.o = a1;
        return a1;
    }

    static Thread a(AudioAgent audioagent, Thread thread)
    {
        audioagent.n = thread;
        return thread;
    }

    static String b(AudioAgent audioagent)
    {
        return audioagent.g;
    }

    static Thread c(AudioAgent audioagent)
    {
        return audioagent.n;
    }

    public static AudioAgent getInstance(Context context)
    {
        if (j == null)
        {
            j = new AudioAgent(context);
        }
        return j;
    }

    public float getAudioDuration()
    {
        if (h.c() <= 60L)
        {
            return (float)h.c();
        } else
        {
            return 60F;
        }
    }

    public boolean getAudioInitStatus()
    {
        return k;
    }

    public boolean getPlayStatus()
    {
        return n != null;
    }

    public boolean getRecordStatus()
    {
        return h.b();
    }

    public void recordShortStop()
    {
        h.a();
    }

    public boolean recordStart(String s)
    {
        if (!com.umeng.fb.util.c.a(com.umeng.fb.util.c.c(m)))
        {
            return false;
        } else
        {
            l = s;
            String s1 = (new StringBuilder()).append(com.umeng.fb.util.c.c(m)).append(s).append(".raw").toString();
            s = (new StringBuilder()).append(com.umeng.fb.util.c.c(m)).append(s).append(".wav").toString();
            k = h.a(s1, s);
            return k;
        }
    }

    public int recordStop()
    {
        int i1 = h.a();
        if (!(new File((new StringBuilder()).append(com.umeng.fb.util.c.c(m)).append(l).append(".raw").toString())).exists())
        {
            return -1;
        } else
        {
            i.a(l, i1);
            return i1;
        }
    }

    public void startPlay(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            i.a(s);
        }
    }

    public void stopPlayer()
    {
        try
        {
            if (n != null)
            {
                o.b();
                n.interrupt();
                n = null;
            }
            return;
        }
        catch (Exception exception)
        {
            Log.b(g, exception.getMessage());
        }
    }
}
