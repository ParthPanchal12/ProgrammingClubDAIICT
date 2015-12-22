// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import com.umeng.fb.model.Store;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;

// Referenced classes of package com.umeng.fb.util:
//            b, Log

public class d
{

    public static final String a = System.getProperty("line.separator");
    private static final String b = com/umeng/fb/util/d.getName();

    public d()
    {
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

    public static JSONObject a(Context context)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("device_id", com.umeng.fb.util.b.f(context));
            jsonobject.put("idmd5", com.umeng.fb.util.b.g(context));
            jsonobject.put("device_model", Build.MODEL);
            jsonobject.put("appkey", com.umeng.fb.util.b.p(context));
            jsonobject.put("channel", com.umeng.fb.util.b.t(context));
            jsonobject.put("app_version", com.umeng.fb.util.b.d(context));
            jsonobject.put("version_code", com.umeng.fb.util.b.c(context));
            jsonobject.put("sdk_type", "Android");
            jsonobject.put("sdk_version", "5.1.0.20150115");
            jsonobject.put("os", "Android");
            jsonobject.put("os_version", android.os.Build.VERSION.RELEASE);
            jsonobject.put("country", com.umeng.fb.util.b.o(context)[0]);
            jsonobject.put("language", com.umeng.fb.util.b.o(context)[1]);
            jsonobject.put("timezone", com.umeng.fb.util.b.n(context));
            jsonobject.put("resolution", com.umeng.fb.util.b.r(context));
            jsonobject.put("access", com.umeng.fb.util.b.j(context)[0]);
            jsonobject.put("access_subtype", com.umeng.fb.util.b.j(context)[1]);
            jsonobject.put("carrier", com.umeng.fb.util.b.h(context));
            jsonobject.put("cpu", com.umeng.fb.util.b.a());
            jsonobject.put("package", com.umeng.fb.util.b.u(context));
            jsonobject.put("uid", Store.getInstance(context).getUid());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public static void a(Context context, String s)
    {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(s));
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
            Log.a(b, "getMD5 error", s);
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

    public static boolean c(String s)
    {
        return s == null || s.length() == 0;
    }

}
