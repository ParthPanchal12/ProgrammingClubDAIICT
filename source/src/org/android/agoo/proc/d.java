// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.android.agoo.proc;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.umeng.message.proguard.bt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;

// Referenced classes of package org.android.agoo.proc:
//            c

public class d
{
    public static class a
    {

        private boolean a;
        private boolean b;

        public void a(boolean flag)
        {
            a = flag;
        }

        public boolean a()
        {
            return a;
        }

        public void b(boolean flag)
        {
            b = flag;
        }

        public boolean b()
        {
            return b;
        }

        public a()
        {
            a = false;
            b = false;
        }
    }


    public static String a;
    public static final String b = "android";
    public static final String c = "libcockroach.so";
    private static final boolean d = false;
    private static final String e = "SEProtect-";
    private static final String f = "test-";
    private static final String g = "1.3.3";
    private static String h;
    private static final String i = "cockroach";
    private static final String j[] = {
        "cc7adaf0aaeb510ee4a3d62fd4b2b12c99a9474bb52d879024482bff6c8e2e52"
    };
    private static final String k[] = {
        "2a10e0cdfb83ed0358321c09d0da1ce9f1d524060d8a19671580a599bcb9bcba"
    };
    private static final String l[] = {
        "8e5677fa96dc5dde287126c92487f6b29160799d5d4acfe4d7337adbf80e9f7f"
    };
    private static HashMap m;
    private Context n;
    private File o;

    private d(Context context)
    {
        n = null;
        o = null;
        n = context;
        try
        {
            o = n.getFilesDir();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    private static String a(Build build, String s)
    {
        try
        {
            build = android/os/Build.getField(s).get(build).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Build build)
        {
            return "Unknown";
        }
        return build;
    }

    private a a(String s)
    {
        a a1 = new a();
        s = c(s);
        if (s != null && s.exists())
        {
            try
            {
                System.load(s.getAbsolutePath());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return a1;
            }
            Log.i("SOManager", "Call System.load() by SOManager");
            a1.b(true);
            a1.a(true);
        }
        return a1;
    }

    public static d a(Context context)
    {
        if (context != null)
        {
            return new d(context.getApplicationContext());
        } else
        {
            return null;
        }
    }

    private boolean a(String s, FileInputStream fileinputstream)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L8:
        return flag;
_L2:
        s = (String[])m.get(s);
        if (fileinputstream == null) goto _L4; else goto _L3
_L3:
        if (fileinputstream.available() <= 0) goto _L4; else goto _L5
_L5:
        String s1 = bt.c(fileinputstream);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        flag = "".equals(s1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        int i1;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return false;
        i1 = 0;
_L6:
        if (i1 >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = s[i1].equals(s1);
        if (flag)
        {
            flag = true;
            if (fileinputstream != null)
            {
                try
                {
                    fileinputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return true;
                }
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        i1++;
        if (true) goto _L6; else goto _L4
_L4:
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return false;
        s;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        s;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (FileInputStream fileinputstream) { }
        }
        throw s;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean a(String s, byte abyte0[])
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        s = (String[])m.get(s);
        if (abyte0 != null && s != null)
        {
            abyte0 = bt.a(abyte0);
            if (abyte0 != null && !"".equals(abyte0))
            {
                int i1 = 0;
                while (i1 < s.length) 
                {
                    if (s[i1].equals(abyte0))
                    {
                        return true;
                    }
                    i1++;
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void b(String s)
    {
        c(s);
    }

    private File c(String s)
    {
        if (o != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        File file;
        if (!o.exists())
        {
            o.mkdir();
        }
        if (!o.exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        file = new File(o, s);
        if (!file.exists() || !a(s, new FileInputStream(file)))
        {
            break MISSING_BLOCK_LABEL_83;
        }
        Log.i("SOManager(LoadFile)", "validateSha256 libFile success.");
        return file;
        Object obj;
        File file1;
        byte abyte0[];
        try
        {
            Log.i("SOManager(LoadFile)", "validateSha256 exist libFile fail.We will re copy one.");
        }
        catch (FileNotFoundException filenotfoundexception) { }
        abyte0 = org.android.agoo.proc.c.a(s, a(new Build(), "CPU_ABI"));
        if (abyte0 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!a(s, abyte0))
        {
            Log.i("SOManager(LoadFile)", "validateSha256 sodata bytes fail");
            return null;
        }
        file1 = new File(o, s);
        if (file1 == null || !file1.getParentFile().canWrite())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (file1.exists())
        {
            file1.delete();
        }
        obj = new FileOutputStream(file1);
        ((FileOutputStream) (obj)).write(abyte0, 0, abyte0.length);
        if (!a(s, new FileInputStream(file1)))
        {
            break MISSING_BLOCK_LABEL_226;
        }
        Log.i("SOManager(LoadFile)", "validateSha256 libFile success.");
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return file1;
        if (file1.exists())
        {
            file1.delete();
            Log.i("SOManager(LoadFile)", "Delete libFile because validateSha256 libFile fail.");
        }
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return null;
        }
        if (true) goto _L1; else goto _L3
        s;
        s = null;
_L8:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return null;
        }
          goto _L4
        s;
        obj = null;
_L6:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw s;
_L3:
        Log.i("SOManager-LoadFile", "Sodata is null.");
        return null;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        s = ((String) (obj));
        if (true) goto _L8; else goto _L7
_L7:
_L4:
        if (true) goto _L1; else goto _L9
_L9:
    }

    public a a()
    {
        return a(a);
    }

    public a b()
    {
        return a("libcockroach.so");
    }

    public void c()
    {
        b("android");
    }

    static 
    {
        h = "SEProtect-1.3.3";
        a = null;
        m = new HashMap();
        a = (new StringBuilder()).append("lib").append(h).append(".so").toString();
        m.put(a, j);
        m.put("android", k);
        m.put("libcockroach.so", l);
    }
}
