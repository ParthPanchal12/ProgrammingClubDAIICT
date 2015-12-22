// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Adler32;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.umeng.message.proguard:
//            ai, ap, ad, al, 
//            X, ab, Z, aq

public class ao
{

    static final String a = "dxCRMxhQkdGePGnp";
    static final String b = "mqBRboGZkQPcAkyk";
    private static final String c = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
    private static final Object e = new Object();
    private static ao f = null;
    private static final String l = ".DataStorage";
    private static final String m = "ContextData";
    private static final String o;
    private static final String p = "Alvin2";
    private Context d;
    private String g;
    private ap h;
    private String i;
    private String j;
    private ai k;
    private ai n;
    private Pattern q;

    public ao(Context context)
    {
        d = null;
        g = null;
        h = null;
        i = "xx_utdid_key";
        j = "xx_utdid_domain";
        k = null;
        n = null;
        q = Pattern.compile("[^0-9a-zA-Z=/+]+");
        d = context;
        n = new ai(context, o, "Alvin2", false, true);
        k = new ai(context, ".DataStorage", "ContextData", false, true);
        h = new ap();
        i = String.format("K_%d", new Object[] {
            Integer.valueOf(ad.b(i))
        });
        j = String.format("D_%d", new Object[] {
            Integer.valueOf(ad.b(j))
        });
    }

    static long a(al al1)
    {
        if (al1 != null)
        {
            al1 = String.format("%s%s%s%s%s", new Object[] {
                al1.f(), al1.e(), Long.valueOf(al1.b()), al1.d(), al1.c()
            });
            if (!ad.a(al1))
            {
                Adler32 adler32 = new Adler32();
                adler32.reset();
                adler32.update(al1.getBytes());
                return adler32.getValue();
            }
        }
        return 0L;
    }

    public static ao a(Context context)
    {
        if (context != null && f == null)
        {
            synchronized (e)
            {
                if (f == null)
                {
                    f = new ao(context);
                }
            }
        }
        return f;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static String a(byte abyte0[])
        throws Exception
    {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), mac.getAlgorithm()));
        return X.b(mac.doFinal(abyte0), 2);
    }

    private void a(String s)
    {
        if (f(s))
        {
            String s1 = s;
            if (s.endsWith("\n"))
            {
                s1 = s.substring(0, s.length() - 1);
            }
            if (s1.length() == 24 && n != null)
            {
                String s5 = n.b("UTDID");
                String s2 = n.b("EI");
                s = s2;
                if (ad.a(s2))
                {
                    s = ab.a(d);
                }
                String s3 = n.b("SI");
                s2 = s3;
                if (ad.a(s3))
                {
                    s2 = ab.b(d);
                }
                String s4 = n.b("DID");
                s3 = s4;
                if (ad.a(s4))
                {
                    s3 = s;
                }
                if (s5 == null || !s5.equals(s1))
                {
                    al al1 = new al();
                    al1.a(s);
                    al1.b(s2);
                    al1.d(s1);
                    al1.c(s3);
                    al1.b(System.currentTimeMillis());
                    n.a("UTDID", s1);
                    n.a("EI", al1.c());
                    n.a("SI", al1.d());
                    n.a("DID", al1.e());
                    n.a("timestamp", al1.b());
                    n.a("S", a(al1));
                    n.c();
                }
            }
        }
    }

    private String b()
    {
        if (n != null)
        {
            String s = n.b("UTDID");
            if (!ad.a(s) && h.a(s) != null)
            {
                return s;
            }
        }
        return null;
    }

    private void b(String s)
    {
        if (s != null && k != null && !s.equals(k.b(i)))
        {
            k.a(i, s);
            k.c();
        }
    }

    private void c(String s)
    {
        if (d.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && f(s))
        {
            String s1 = s;
            if (s.endsWith("\n"))
            {
                s1 = s.substring(0, s.length() - 1);
            }
            if (24 == s1.length() && !f(android.provider.Settings.System.getString(d.getContentResolver(), "mqBRboGZkQPcAkyk")))
            {
                android.provider.Settings.System.putString(d.getContentResolver(), "mqBRboGZkQPcAkyk", s1);
            }
        }
    }

    private final byte[] c()
        throws Exception
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        int i1 = (int)(System.currentTimeMillis() / 1000L);
        int j1 = (new Random()).nextInt();
        byte abyte0[] = Z.a(i1);
        byte abyte1[] = Z.a(j1);
        bytearrayoutputstream.write(abyte0, 0, 4);
        bytearrayoutputstream.write(abyte1, 0, 4);
        bytearrayoutputstream.write(3);
        bytearrayoutputstream.write(0);
        String s;
        try
        {
            s = ab.a(d);
        }
        catch (Exception exception)
        {
            exception = (new StringBuilder()).append("").append((new Random()).nextInt()).toString();
        }
        bytearrayoutputstream.write(Z.a(ad.b(s)), 0, 4);
        bytearrayoutputstream.write(Z.a(ad.b(a(bytearrayoutputstream.toByteArray()))));
        return bytearrayoutputstream.toByteArray();
    }

    private void d(String s)
    {
        if (!s.equals(android.provider.Settings.System.getString(d.getContentResolver(), "dxCRMxhQkdGePGnp")))
        {
            android.provider.Settings.System.putString(d.getContentResolver(), "dxCRMxhQkdGePGnp", s);
        }
    }

    private void e(String s)
    {
        if (d.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && s != null)
        {
            d(s);
        }
    }

    private boolean f(String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (s != null)
        {
            String s1 = s;
            if (s.endsWith("\n"))
            {
                s1 = s.substring(0, s.length() - 1);
            }
            flag = flag1;
            if (24 == s1.length())
            {
                flag = flag1;
                if (!q.matcher(s1).find())
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public String a()
    {
        this;
        JVM INSTR monitorenter ;
        if (g == null) goto _L2; else goto _L1
_L1:
        Object obj = g;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L2:
        String s = android.provider.Settings.System.getString(d.getContentResolver(), "mqBRboGZkQPcAkyk");
        obj = s;
        if (f(s)) goto _L4; else goto _L3
_L3:
        aq aq1 = new aq();
        boolean flag = false;
        obj = android.provider.Settings.System.getString(d.getContentResolver(), "dxCRMxhQkdGePGnp");
        if (ad.a(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_425;
        }
        s = aq1.b(((String) (obj)));
        if (!f(s))
        {
            break MISSING_BLOCK_LABEL_101;
        }
        c(s);
        obj = s;
          goto _L4
        obj;
        throw obj;
label0:
        {
            s = aq1.a(((String) (obj)));
            if (f(s))
            {
                s = h.a(s);
                if (!ad.a(s))
                {
                    e(s);
                    obj = android.provider.Settings.System.getString(d.getContentResolver(), "dxCRMxhQkdGePGnp");
                }
            }
            s = h.b(((String) (obj)));
            if (!f(s))
            {
                break label0;
            }
            g = s;
            a(s);
            b(((String) (obj)));
            c(g);
            obj = g;
        }
          goto _L4
_L5:
        obj = b();
        if (!f(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_247;
        }
        s = h.a(((String) (obj)));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        e(s);
        c(((String) (obj)));
        b(s);
        g = ((String) (obj));
          goto _L4
        String s1;
        s1 = k.b(i);
        if (ad.a(s1))
        {
            break MISSING_BLOCK_LABEL_350;
        }
        s = aq1.a(s1);
        obj = s;
        if (!f(s))
        {
            obj = h.b(s1);
        }
        if (!f(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_350;
        }
        s = h.a(((String) (obj)));
        if (ad.a(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_350;
        }
        g = ((String) (obj));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_334;
        }
        e(s);
        a(g);
        obj = g;
          goto _L4
        obj = c();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_417;
        }
        g = X.b(((byte []) (obj)), 2);
        a(g);
        obj = h.a(((byte []) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_404;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        e(((String) (obj)));
        b(((String) (obj)));
        obj = g;
          goto _L4
        obj;
        ((Exception) (obj)).printStackTrace();
        obj = null;
          goto _L4
        flag = true;
          goto _L5
    }

    static 
    {
        o = (new StringBuilder()).append(".UTSystemConfig").append(File.separator).append("Global").toString();
    }
}
