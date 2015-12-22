// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.util;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.umeng.fb.util:
//            Log

public class c
{

    private static final String a = com/umeng/fb/util/c.getName();

    public c()
    {
    }

    public static void a(Context context)
    {
        b(c(context));
    }

    public static void a(Context context, String s)
    {
        b((new StringBuilder()).append(b(context)).append(s).append(".opus").toString());
    }

    public static boolean a(String s)
    {
        com/umeng/fb/util/c;
        JVM INSTR monitorenter ;
        s = new File(s);
        if (!s.exists())
        {
            s.mkdirs();
        }
        com/umeng/fb/util/c;
        JVM INSTR monitorexit ;
        return true;
        s;
        throw s;
    }

    public static String b(Context context)
    {
        return (new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("/umeng/fb/audio/").toString();
    }

    public static void b(String s)
    {
        com/umeng/fb/util/c;
        JVM INSTR monitorenter ;
        (new Thread(new Runnable(s) {

            final String a;

            public void run()
            {
                File file = new File(a);
                if (file.exists()) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if (file.isFile())
                {
                    file.delete();
                    return;
                }
                if (file.isDirectory())
                {
                    File afile[] = file.listFiles();
                    int j = afile.length;
                    int i = 0;
                    while (i < j) 
                    {
                        afile[i].delete();
                        i++;
                    }
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                a = s;
                super();
            }
        })).start();
        com/umeng/fb/util/c;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static String c(Context context)
    {
        context = (new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("/umeng/fb/audio/cache/").toString();
        Log.c(a, (new StringBuilder()).append("getAudioCachePath=").append(context).toString());
        return context;
    }

    public static boolean c(String s)
    {
        return (new File(s)).exists();
    }

}
