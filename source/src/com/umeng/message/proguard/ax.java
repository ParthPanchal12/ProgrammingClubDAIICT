// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.umeng.common.message.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ax
{

    public static final String a = System.getProperty("line.separator");
    private static final String b = "helper";

    public ax()
    {
    }

    public static String a()
    {
        return a(new Date());
    }

    public static String a(Context context, long l)
    {
        if (l < 1000L)
        {
            return (new StringBuilder()).append((int)l).append("B").toString();
        }
        if (l < 0xf4240L)
        {
            return (new StringBuilder()).append(Math.round((double)(float)l / 1000D)).append("K").toString();
        }
        if (l < 0x3b9aca00L)
        {
            context = new DecimalFormat("#0.0");
            return (new StringBuilder()).append(context.format((double)(float)l / 1000000D)).append("M").toString();
        } else
        {
            context = new DecimalFormat("#0.00");
            return (new StringBuilder()).append(context.format((double)(float)l / 1000000000D)).append("G").toString();
        }
    }

    public static String a(File file)
    {
        byte abyte0[] = new byte[1024];
        if (!file.isFile())
        {
            return "";
        }
        MessageDigest messagedigest;
        messagedigest = MessageDigest.getInstance("MD5");
        file = new FileInputStream(file);
_L1:
        int i = file.read(abyte0, 0, 1024);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                messagedigest.update(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                file.printStackTrace();
                return null;
            }
        }
          goto _L1
        file.close();
        return String.format("%1$032x", new Object[] {
            new BigInteger(1, messagedigest.digest())
        });
    }

    public static String a(String s)
    {
        int i;
        i = 0;
        if (s == null)
        {
            return null;
        }
        byte abyte0[];
        Object obj;
        abyte0 = s.getBytes();
        obj = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj)).reset();
        ((MessageDigest) (obj)).update(abyte0);
        abyte0 = ((MessageDigest) (obj)).digest();
        obj = new StringBuffer();
_L1:
        if (i >= abyte0.length)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        ((StringBuffer) (obj)).append(String.format("%02X", new Object[] {
            Byte.valueOf(abyte0[i])
        }));
        i++;
          goto _L1
        String s1;
        try
        {
            s1 = ((StringBuffer) (obj)).toString();
        }
        catch (Exception exception)
        {
            return s.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
        return s1;
    }

    public static String a(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
        }
    }

    public static void a(Context context, String s)
    {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(s));
    }

    public static void a(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        outputstream.close();
        return;
        outputstream;
    }

    public static boolean a(Context context)
    {
        Object obj = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
        if (obj == null)
        {
            return false;
        }
        context = context.getPackageName();
        obj = ((List) (obj)).iterator();
        boolean flag;
        do
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break MISSING_BLOCK_LABEL_79;
                }
                runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
            } while (runningappprocessinfo.importance != 100);
            flag = runningappprocessinfo.processName.equals(context);
        } while (!flag);
        return true;
        context;
        context.printStackTrace();
        return false;
    }

    public static byte[] a(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (-1 != i)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return bytearrayoutputstream.toByteArray();
            }
        } while (true);
    }

    public static String b(String s)
    {
        Object obj;
        int i;
        try
        {
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).update(s.getBytes());
            s = ((MessageDigest) (obj)).digest();
            obj = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.a("helper", "getMD5 error", s);
            return "";
        }
        i = 0;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuffer) (obj)).append(Integer.toHexString(s[i] & 0xff));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_29;
_L1:
        s = ((StringBuffer) (obj)).toString();
        return s;
    }

    public static void b(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
    }

    public static boolean b(Context context, String s)
    {
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return true;
    }

    public static String c(String s)
    {
        long l;
        try
        {
            l = Long.valueOf(s).longValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            return s;
        }
        if (l < 1024L)
        {
            return (new StringBuilder()).append((int)l).append("B").toString();
        }
        if (l < 0x100000L)
        {
            s = new DecimalFormat("#0.00");
            return (new StringBuilder()).append(s.format((double)(float)l / 1024D)).append("K").toString();
        }
        if (l < 0x40000000L)
        {
            s = new DecimalFormat("#0.00");
            return (new StringBuilder()).append(s.format((double)(float)l / 1048576D)).append("M").toString();
        } else
        {
            s = new DecimalFormat("#0.00");
            return (new StringBuilder()).append(s.format((double)(float)l / 1073741824D)).append("G").toString();
        }
    }

    public static boolean d(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean e(String s)
    {
        if (!d(s))
        {
            if ((s = s.trim().toLowerCase(Locale.US)).startsWith("http://") || s.startsWith("https://"))
            {
                return true;
            }
        }
        return false;
    }

}
