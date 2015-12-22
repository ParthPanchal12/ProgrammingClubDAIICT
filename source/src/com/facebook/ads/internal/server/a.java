// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.server;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.AdErrorType;
import com.facebook.ads.internal.dev.Debug;
import com.facebook.ads.internal.dto.b;
import com.facebook.ads.internal.dto.c;
import com.facebook.ads.internal.dto.e;
import com.facebook.ads.internal.util.d;
import com.facebook.ads.internal.util.p;
import com.facebook.ads.internal.util.s;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;

// Referenced classes of package com.facebook.ads.internal.server:
//            b, c, d, e

public class com.facebook.ads.internal.server.a
{
    public static interface a
    {

        public abstract void a(com.facebook.ads.internal.b b1);

        public abstract void a(com.facebook.ads.internal.server.d d1);
    }


    private static final p j;
    private static final ThreadPoolExecutor k;
    Map a;
    private final com.facebook.ads.internal.server.b b = com.facebook.ads.internal.server.b.a();
    private a c;
    private Context d;
    private com.facebook.ads.internal.dto.d e;
    private com.facebook.ads.internal.http.a f;
    private long g;
    private boolean h;
    private final String i;

    public com.facebook.ads.internal.server.a()
    {
        String s1 = AdSettings.getUrlPrefix();
        if (s.a(s1))
        {
            s1 = "https://graph.facebook.com/network_ads_common/";
        } else
        {
            s1 = String.format("https://graph.%s.facebook.com/network_ads_common/", new Object[] {
                s1
            });
        }
        i = s1;
    }

    static com.facebook.ads.internal.http.a a(com.facebook.ads.internal.server.a a1, com.facebook.ads.internal.http.a a2)
    {
        a1.f = a2;
        return a2;
    }

    static String a(com.facebook.ads.internal.server.a a1)
    {
        return a1.i;
    }

    private void a(com.facebook.ads.internal.b b1)
    {
        Debug.i((new StringBuilder()).append("AdProvider failed in ").append(System.currentTimeMillis() - g).append("ms").toString());
        if (c != null)
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable(b1) {

                final com.facebook.ads.internal.b a;
                final com.facebook.ads.internal.server.a b;

                public void run()
                {
                    com.facebook.ads.internal.server.a.f(b).a(a);
                }

            
            {
                b = com.facebook.ads.internal.server.a.this;
                a = b1;
                super();
            }
            });
        }
        a();
    }

    static void a(com.facebook.ads.internal.server.a a1, com.facebook.ads.internal.b b1)
    {
        a1.a(b1);
    }

    static void a(com.facebook.ads.internal.server.a a1, String s1)
    {
        a1.a(s1);
    }

    private void a(com.facebook.ads.internal.server.d d1)
    {
        Debug.i((new StringBuilder()).append("AdProvider completed in ").append(System.currentTimeMillis() - g).append("ms").toString());
        if (c != null)
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable(d1) {

                final com.facebook.ads.internal.server.d a;
                final com.facebook.ads.internal.server.a b;

                public void run()
                {
                    com.facebook.ads.internal.server.a.f(b).a(a);
                }

            
            {
                b = com.facebook.ads.internal.server.a.this;
                a = d1;
                super();
            }
            });
        }
        a();
    }

    private void a(String s1)
    {
        Object obj = b.a(s1);
        static class _cls5
        {

            static final int a[];

            static 
            {
                a = new int[com.facebook.ads.internal.server.c.a.values().length];
                try
                {
                    a[com.facebook.ads.internal.server.c.a.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.facebook.ads.internal.server.c.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls5.a[((com.facebook.ads.internal.server.c) (obj)).a().ordinal()];
        JVM INSTR tableswitch 1 2: default 219
    //                   1 70
    //                   2 142;
           goto _L1 _L2 _L3
_L1:
        Debug.e("Facebook Ads SDK unknown response.");
        Debug.v(s1);
        a(AdErrorType.UNKNOWN_RESPONSE.getAdErrorWrapper(s1));
_L4:
        h = false;
        return;
_L2:
        AdErrorType aderrortype;
        try
        {
            obj = (com.facebook.ads.internal.server.d)obj;
            c c1 = ((com.facebook.ads.internal.server.d) (obj)).b().a();
            com.facebook.ads.internal.util.d.a(c1.c(), e);
            if (c1.d())
            {
                com.facebook.ads.internal.util.d.a(s1, e);
            }
            a(((com.facebook.ads.internal.server.d) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Debug.e("Failed to parse Facebook Ads SDK response");
            a(AdErrorType.PARSER_FAILURE.getAdErrorWrapper(s1.getMessage()));
            s1.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Debug.e("Failed to parse Facebook Ads SDK response");
            a(AdErrorType.PARSER_FAILURE.getAdErrorWrapper(s1.getMessage()));
            s1.printStackTrace();
            return;
        }
          goto _L4
_L3:
        obj = ((com.facebook.ads.internal.server.e)obj).b();
        Debug.e((new StringBuilder()).append("Facebook Ads SDK response error message. ").append(((String) (obj))).toString());
        aderrortype = AdErrorType.ERROR_MESSAGE;
        if (obj != null)
        {
            s1 = ((String) (obj));
        }
        a(aderrortype.getAdErrorWrapper(s1));
          goto _L4
    }

    private com.facebook.ads.internal.http.c b()
    {
        return new com.facebook.ads.internal.http.c() {

            final com.facebook.ads.internal.server.a a;

            public void a()
            {
                Debug.d((new StringBuilder()).append("Facebook Ads SDK req start delay=").append(System.currentTimeMillis() - com.facebook.ads.internal.server.a.d(a)).append("ms").toString());
            }

            public void a(int l, String s1)
            {
                com.facebook.ads.internal.util.d.b(com.facebook.ads.internal.server.a.e(a));
                Debug.i((new StringBuilder()).append("Facebook Ads SDK req complete ").append(System.currentTimeMillis() - com.facebook.ads.internal.server.a.d(a)).append("ms ").toString());
                com.facebook.ads.internal.server.a.a(a, null);
                com.facebook.ads.internal.server.a.a(a, s1);
            }

            public void a(Throwable throwable, String s1)
            {
                com.facebook.ads.internal.util.d.b(com.facebook.ads.internal.server.a.e(a));
                long l = System.currentTimeMillis();
                long l1 = com.facebook.ads.internal.server.a.d(a);
                Debug.e((new StringBuilder()).append("Facebook Ads SDK req failed ").append(l - l1).append("ms ").append(s1).append(" ").append(throwable).toString());
                com.facebook.ads.internal.server.a.a(a, null);
            }

            
            {
                a = com.facebook.ads.internal.server.a.this;
                super();
            }
        };
    }

    static com.facebook.ads.internal.http.c b(com.facebook.ads.internal.server.a a1)
    {
        return a1.b();
    }

    static com.facebook.ads.internal.http.a c(com.facebook.ads.internal.server.a a1)
    {
        return a1.f;
    }

    static long d(com.facebook.ads.internal.server.a a1)
    {
        return a1.g;
    }

    static com.facebook.ads.internal.dto.d e(com.facebook.ads.internal.server.a a1)
    {
        return a1.e;
    }

    static a f(com.facebook.ads.internal.server.a a1)
    {
        return a1.c;
    }

    public void a()
    {
        if (f != null)
        {
            Debug.v("AdProvider clean up Facebook Ads SDK client");
            f.a(true);
            f = null;
        }
        d = null;
    }

    public void a(Context context, com.facebook.ads.internal.dto.d d1)
    {
        a();
        g = System.currentTimeMillis();
        h = true;
        d = context;
        e = d1;
        if (com.facebook.ads.internal.util.d.a(d1))
        {
            context = com.facebook.ads.internal.util.d.c(d1);
            if (context != null)
            {
                a(((String) (context)));
                return;
            } else
            {
                a(AdErrorType.LOAD_TOO_FREQUENTLY.getAdErrorWrapper(null));
                return;
            }
        } else
        {
            k.submit(new Runnable(context, d1) {

                final Context a;
                final com.facebook.ads.internal.dto.d b;
                final com.facebook.ads.internal.server.a c;

                public void run()
                {
                    com.facebook.ads.internal.dto.e.b(a);
                    c.a = b.g();
                    Debug.d(c.a.toString());
                    try
                    {
                        com.facebook.ads.internal.server.a.a(c, new com.facebook.ads.internal.http.a(a, b.i));
                        com.facebook.ads.internal.server.a.c(c).a(com.facebook.ads.internal.server.a.a(c), new com.facebook.ads.internal.http.d(c.a), com.facebook.ads.internal.server.a.b(c));
                        return;
                    }
                    catch (Exception exception)
                    {
                        com.facebook.ads.internal.server.a.a(c, AdErrorType.AD_REQUEST_FAILED.getAdErrorWrapper(exception.getMessage()));
                    }
                }

            
            {
                c = com.facebook.ads.internal.server.a.this;
                a = context;
                b = d1;
                super();
            }
            });
            return;
        }
    }

    public void a(a a1)
    {
        c = a1;
    }

    static 
    {
        j = new p();
        k = (ThreadPoolExecutor)Executors.newCachedThreadPool(j);
    }
}
