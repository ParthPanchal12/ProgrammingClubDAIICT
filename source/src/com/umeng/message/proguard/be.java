// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpException;

// Referenced classes of package com.umeng.message.proguard:
//            bi, bf, aU, bh, 
//            aJ

abstract class be
    implements bi
{

    protected static final int g = 8192;
    private static final char l = 13;
    private static final char m = 10;
    private static final String n = "UTF-8";
    private static final String o = "HttpChunked";
    private static final char x[] = {
        ' '
    };
    protected volatile bf a;
    protected volatile InputStream b;
    protected volatile int c;
    protected volatile boolean d;
    protected volatile String e;
    protected volatile Map f;
    private volatile ThreadPoolExecutor p;
    private volatile bh q;
    private volatile Future r;
    private volatile Future s;
    private volatile String t;
    private volatile int u;
    private volatile int v;
    private AtomicBoolean w;

    public be()
    {
        r = null;
        s = null;
        a = bf.d;
        b = null;
        c = -1;
        d = true;
        v = -1;
        f = new HashMap();
        p = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
        w = new AtomicBoolean(false);
    }

    private void a(Context context)
    {
        try
        {
            context = new aU(context);
            if (context.a())
            {
                t = context.d();
                u = context.e();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        t = null;
        u = -1;
        return;
    }

    static void a(be be1)
    {
        be1.l();
    }

    public static char byteToChar(byte abyte0[])
    {
        return (char)((abyte0[0] & 0xff) << 8 | abyte0[1] & 0xff);
    }

    private void l()
    {
        v = -1;
    }

    private boolean m()
    {
        return a == bf.c || a == bf.d;
    }

    protected void a()
    {
        callError(false);
        v = (new Random()).nextInt(10000);
    }

    protected final void a(int i1, Throwable throwable)
    {
        disconnect(b());
        if (q != null)
        {
            q.a(i1, new HashMap(), throwable);
        }
    }

    protected final void a(int i1, Map map)
    {
        disconnect(b());
        if (q != null)
        {
            q.a(i1, map, new HttpException((new StringBuilder()).append("http chunked connectId:[").append(b()).append("] http Status code==").append(i1).toString()));
        }
    }

    protected abstract void a(String s1);

    protected final void a(Map map)
    {
        if (q != null)
        {
            a = bf.b;
            q.a(b(), map);
        }
    }

    protected final void a(char ac[])
    {
        if (q != null)
        {
            q.a(ac);
        }
    }

    public void addHeader(String s1, String s2)
    {
        f.put(s1, s2);
    }

    protected int b()
    {
        return v;
    }

    protected final void b(String s1)
    {
        q.a(s1);
    }

    protected abstract void c();

    public void callError(boolean flag)
    {
        w.set(flag);
    }

    public final void close()
    {
        try
        {
            p.submit(new Runnable() {

                final be a;

                public void run()
                {
                    try
                    {
                        a.disconnect(a.b());
                        aJ.c("HttpChunked", "http chunked closing");
                        a.d();
                        aJ.c("HttpChunked", "http chunked closed");
                        be.a(a);
                        return;
                    }
                    catch (Throwable throwable1)
                    {
                        return;
                    }
                }

            
            {
                a = be.this;
                super();
            }
            });
            if (p != null && p.isShutdown())
            {
                p.shutdownNow();
            }
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    public final void connect(Context context, String s1, long l1, bh bh1)
    {
        if (bh1 == null)
        {
            aJ.c("HttpChunked", "eventHandler == null ");
            return;
        }
        e = s1;
        if (a == bf.b || a == bf.a)
        {
            aJ.c("HttpChunked", (new StringBuilder()).append("http chunked connect url: [").append(s1).append("] connectId:[").append(b()).append("] connecting......").toString());
            return;
        } else
        {
            a(context);
            q = bh1;
            a = bf.a;
            r = p.submit(new Runnable(s1) {

                final String a;
                final be b;

                public void run()
                {
                    try
                    {
                        b.a();
                        b.a(a);
                        return;
                    }
                    catch (Throwable throwable)
                    {
                        return;
                    }
                }

            
            {
                b = be.this;
                a = s1;
                super();
            }
            });
            s = p.submit(new Runnable(l1, s1) {

                final long a;
                final String b;
                final be c;

                public void run()
                {
                    try
                    {
                        SystemClock.sleep(a);
                    }
                    catch (Throwable throwable) { }
                    if (c.a == bf.a && !c.hasCallError())
                    {
                        c.callError(true);
                        aJ.e("HttpChunked", (new StringBuilder()).append("http chunked connect url: [").append(b).append("] connectId:[").append(c.b()).append("] http Status code==").append(408).toString());
                        c.a(408, new HttpException((new StringBuilder()).append("connectId:[").append(c.b()).append("] http Status code==").append(408).toString()));
                        be.a(c);
                        c.g();
                    }
                }

            
            {
                c = be.this;
                a = l1;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    protected abstract void d();

    public final void disconnect(int i1)
    {
        aJ.c("HttpChunked", (new StringBuilder()).append("http chunked disconnect(").append(i1).append(")").toString());
        if (b() != i1)
        {
            aJ.c("HttpChunked", (new StringBuilder()).append("http chunked connect cId[").append(i1).append("] != mCId[").append(b()).append("]").toString());
            a = bf.d;
            return;
        }
        if (m())
        {
            aJ.c("HttpChunked", (new StringBuilder()).append("http chunked connect[").append(i1).append("] connection has been closed").toString());
            return;
        } else
        {
            a = bf.c;
            p.submit(new Runnable(i1) {

                final int a;
                final be b;

                public void run()
                {
                    try
                    {
                        b.f();
                        b.g();
                        aJ.c("HttpChunked", (new StringBuilder()).append("http chunked connect[").append(a).append("] connection disconnecting").toString());
                        b.c();
                        aJ.c("HttpChunked", (new StringBuilder()).append("http chunked connect[").append(a).append("] connection disconnected").toString());
                        b.h();
                        return;
                    }
                    catch (Throwable throwable)
                    {
                        return;
                    }
                }

            
            {
                b = be.this;
                a = i1;
                super();
            }
            });
            a = bf.d;
            return;
        }
    }

    protected final void e()
    {
        Object obj;
        InputStreamReader inputstreamreader;
        StringBuffer stringbuffer;
        obj = new char[6];
        inputstreamreader = new InputStreamReader(b, "UTF-8");
        stringbuffer = new StringBuffer(8192);
        int k1 = 0;
_L5:
        int j1 = inputstreamreader.read();
        if (j1 == -1) goto _L2; else goto _L1
_L1:
        int i1 = j1;
        if (j1 != 32) goto _L4; else goto _L3
_L3:
        a(x);
          goto _L5
        obj;
        if (!w.get())
        {
            w.set(true);
            aJ.d("HttpChunked", (new StringBuilder()).append("Throwable connectId:[").append(b()).append("]==>").toString(), ((Throwable) (obj)));
            a(504, ((Throwable) (obj)));
        }
_L18:
        return;
_L11:
        int l1;
        i1 = k1;
        l1 = j1;
        if (j1 != 64) goto _L7; else goto _L6
_L6:
        char c1 = (char)j1;
        obj[0] = c1;
        i1 = j1;
        j1 = 0;
_L19:
        if (j1 >= 6) goto _L4; else goto _L8
_L8:
        i1 = inputstreamreader.read();
        obj[j1 + 1] = (char)i1;
        if (j1 < 5) goto _L10; else goto _L9
_L9:
        a(((char []) (obj)));
        j1 = i1;
          goto _L11
_L7:
        j1 = i1;
        if (l1 == 10)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = i1;
        if (i1 == 0) goto _L13; else goto _L12
_L12:
        stringbuffer.append('\r');
        j1 = 0;
          goto _L13
_L16:
        k1 = inputstreamreader.read();
        i1 = j1;
        l1 = k1;
        if (k1 >= 0) goto _L7; else goto _L14
_L14:
        k1 = j1;
        if (TextUtils.isEmpty(stringbuffer.toString())) goto _L5; else goto _L15
_L15:
        b(stringbuffer.toString());
        stringbuffer.setLength(0);
        k1 = j1;
          goto _L5
_L21:
        stringbuffer.append((char)l1);
          goto _L16
_L2:
        if (a != bf.b) goto _L18; else goto _L17
_L17:
        aJ.c("HttpChunked", (new StringBuilder()).append("connectId:[").append(b()).append("]==>server data is abort").toString());
        if (!hasCallError())
        {
            callError(true);
            a(504, new IOException((new StringBuilder()).append("connectId:[").append(b()).append("] server data is abort").toString()));
        }
        disconnect(b());
        return;
_L4:
        j1 = i1;
          goto _L11
_L10:
        j1++;
          goto _L19
_L13:
        if (l1 != 13) goto _L21; else goto _L20
_L20:
        j1 = 1;
          goto _L16
    }

    protected final void f()
    {
        if (s != null)
        {
            s.cancel(true);
        }
    }

    protected final void g()
    {
        if (r != null)
        {
            r.cancel(true);
        }
    }

    protected final void h()
    {
        while (q == null && m() || a != bf.b) 
        {
            return;
        }
        q.a();
    }

    public boolean hasCallError()
    {
        return w.get();
    }

    protected final String i()
    {
        return t;
    }

    protected final int j()
    {
        return u;
    }

    protected final boolean k()
    {
        return t != null && u != -1;
    }

    public final bf readyState()
    {
        return a;
    }

}
