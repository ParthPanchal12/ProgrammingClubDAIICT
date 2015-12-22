// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.umeng.message.proguard:
//            U, aF, Y, V

class f extends Thread
{

    HttpPost a;
    String b;
    aF c;
    String d;
    String e;
    String f;
    final U g;

    public String a()
    {
        return b;
    }

    public void run()
    {
        Object obj1;
        obj1 = null;
        if (c != null)
        {
            c.a(1000, d);
        }
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        try
        {
            obj = defaulthttpclient.execute(a);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (c != null)
            {
                c.a(1002, d);
            }
            Log.e(U.a(), ((Exception) (obj)).toString());
            obj = null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        try
        {
            obj = new BufferedReader(new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent(), Charset.forName("UTF-8")));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (c != null)
            {
                c.a(1002, d);
            }
            Log.e(U.a(), ((Exception) (obj)).toString());
            obj = obj1;
        }
_L7:
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj1 = ((BufferedReader) (obj)).readLine();
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Y.a)
        {
            Log.d(U.a(), ((String) (obj1)));
        }
        b = ((String) (obj1));
        if (true) goto _L3; else goto _L5
_L5:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
                if (Y.a)
                {
                    Log.d(U.a(), "close the bufferreader");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(U.a(), ((IOException) (obj)).toString());
            }
        }
        if (c == null)
        {
            synchronized (U.a(g))
            {
                U.a(g).notifyAll();
            }
            return;
        } else
        {
            String s = U.a(b, d);
            c.a(1001, s);
            V.a(U.b(g), e, s, f);
            return;
        }
_L2:
        Log.e(U.a(), "response is null!");
        obj = obj1;
        continue; /* Loop/switch isn't completed */
_L4:
        try
        {
            Log.e(U.a(), "BufferredReader is null!");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (c != null)
            {
                c.a(1002, d);
            }
            Log.e(U.a(), ((Exception) (obj1)).toString());
        }
          goto _L5
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public HttpPost(U u, HttpPost httppost)
    {
        g = u;
        super();
        b = "";
        f = "";
        a = httppost;
    }

    public HttpPost(U u, HttpPost httppost, aF af, String s, String s1, String s2)
    {
        g = u;
        super();
        b = "";
        f = "";
        a = httppost;
        c = af;
        d = s;
        e = s1;
        f = s2;
    }
}
