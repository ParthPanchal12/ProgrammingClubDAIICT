// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.upd;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package u.upd:
//            b, n, m, h, 
//            i

public class g
{

    private static final String a = u/upd/g.getName();
    private Map b;

    public g()
    {
    }

    private static String a(InputStream inputstream)
    {
        BufferedReader bufferedreader;
        StringBuilder stringbuilder;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream), 8192);
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            Object obj;
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                u.upd.b.b(a, "Caught IOException in convertStreamToString()", inputstream);
                return null;
            }
            return stringbuilder.toString();
        }
        stringbuilder.append((new StringBuilder(String.valueOf(s))).append("\n").toString());
          goto _L1
        obj;
        u.upd.b.b(a, "Caught IOException in convertStreamToString()", ((Exception) (obj)));
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            u.upd.b.b(a, "Caught IOException in convertStreamToString()", inputstream);
            return null;
        }
        return null;
        obj;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            u.upd.b.b(a, "Caught IOException in convertStreamToString()", inputstream);
            return null;
        }
        throw obj;
    }

    private JSONObject a(String s)
    {
        int j = (new Random()).nextInt(1000);
        String s1;
        s1 = System.getProperty("line.separator");
        if (s.length() > 1)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        u.upd.b.b(a, (new StringBuilder(String.valueOf(j))).append(":\tInvalid baseUrl.").toString());
        return null;
        Object obj;
        u.upd.b.a(a, (new StringBuilder(String.valueOf(j))).append(":\tget: ").append(s).toString());
        obj = new HttpGet(s);
        if (b == null || b.size() <= 0) goto _L2; else goto _L1
_L1:
        Object obj1 = b.keySet().iterator();
_L16:
        if (((Iterator) (obj1)).hasNext()) goto _L3; else goto _L2
_L2:
        obj1 = (new DefaultHttpClient(b())).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        if (((HttpResponse) (obj1)).getStatusLine().getStatusCode() != 200) goto _L5; else goto _L4
_L4:
        obj = ((HttpResponse) (obj1)).getEntity();
        if (obj == null) goto _L7; else goto _L6
_L6:
        try
        {
            obj = ((HttpEntity) (obj)).getContent();
            obj1 = ((HttpResponse) (obj1)).getFirstHeader("Content-Encoding");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            u.upd.b.c(a, (new StringBuilder(String.valueOf(j))).append(":\tClientProtocolException,Failed to send message.").append(s).toString(), ((Exception) (obj)));
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            u.upd.b.c(a, (new StringBuilder(String.valueOf(j))).append(":\tIOException,Failed to send message.").append(s).toString(), ((Exception) (obj)));
            return null;
        }
        if (obj1 == null) goto _L9; else goto _L8
_L8:
        if (!((Header) (obj1)).getValue().equalsIgnoreCase("gzip")) goto _L9; else goto _L10
_L10:
        u.upd.b.a(a, (new StringBuilder(String.valueOf(j))).append("  Use GZIPInputStream get data....").toString());
        obj = new GZIPInputStream(((InputStream) (obj)));
_L13:
        obj = a(((InputStream) (obj)));
        u.upd.b.a(a, (new StringBuilder(String.valueOf(j))).append(":\tresponse: ").append(s1).append(((String) (obj))).toString());
        if (obj == null)
        {
            return null;
        }
          goto _L11
_L3:
        String s2 = (String)((Iterator) (obj1)).next();
        ((HttpGet) (obj)).addHeader(s2, (String)b.get(s2));
        continue; /* Loop/switch isn't completed */
_L9:
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        if (!((Header) (obj1)).getValue().equalsIgnoreCase("deflate")) goto _L13; else goto _L14
_L14:
        u.upd.b.a(a, (new StringBuilder(String.valueOf(j))).append("  Use InflaterInputStream get data....").toString());
        obj = new InflaterInputStream(((InputStream) (obj)));
          goto _L13
_L11:
        return new JSONObject(((String) (obj)));
_L5:
        u.upd.b.c(a, (new StringBuilder(String.valueOf(j))).append(":\tFailed to send message. StatusCode = ").append(((HttpResponse) (obj1)).getStatusLine().getStatusCode()).append(n.a).append(s).toString());
_L7:
        return null;
        if (true) goto _L16; else goto _L15
_L15:
    }

    private JSONObject a(String s, JSONObject jsonobject)
    {
        Object obj;
        String s1;
        int j;
        s1 = jsonobject.toString();
        j = (new Random()).nextInt(1000);
        u.upd.b.c(a, (new StringBuilder(String.valueOf(j))).append(":\trequest: ").append(s).append(n.a).append(s1).toString());
        jsonobject = new HttpPost(s);
        obj = new DefaultHttpClient(b());
        if (!a())
        {
            break MISSING_BLOCK_LABEL_276;
        }
        s1 = m.a((new StringBuilder("content=")).append(s1).toString(), Charset.defaultCharset().toString());
        jsonobject.addHeader("Content-Encoding", "deflate");
        jsonobject.setEntity(new InputStreamEntity(new ByteArrayInputStream(s1), s1.length));
_L1:
        obj = ((HttpClient) (obj)).execute(jsonobject);
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        jsonobject = ((HttpResponse) (obj)).getEntity();
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_491;
        }
        ArrayList arraylist;
        try
        {
            jsonobject = jsonobject.getContent();
            obj = ((HttpResponse) (obj)).getFirstHeader("Content-Encoding");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            u.upd.b.c(a, (new StringBuilder(String.valueOf(j))).append(":\tClientProtocolException,Failed to send message.").append(s).toString(), jsonobject);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            u.upd.b.c(a, (new StringBuilder(String.valueOf(j))).append(":\tIOException,Failed to send message.").append(s).toString(), jsonobject);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            u.upd.b.c(a, (new StringBuilder(String.valueOf(j))).append(":\tIOException,Failed to send message.").append(s).toString(), jsonobject);
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        if (((Header) (obj)).getValue().equalsIgnoreCase("deflate"))
        {
            jsonobject = new InflaterInputStream(jsonobject);
        }
        jsonobject = a(((InputStream) (jsonobject)));
        u.upd.b.a(a, (new StringBuilder(String.valueOf(j))).append(":\tresponse: ").append(n.a).append(jsonobject).toString());
        if (jsonobject == null)
        {
            return null;
        }
        break MISSING_BLOCK_LABEL_359;
        arraylist = new ArrayList(1);
        arraylist.add(new BasicNameValuePair("content", s1));
        jsonobject.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
          goto _L1
        return new JSONObject(jsonobject);
        u.upd.b.c(a, (new StringBuilder(String.valueOf(j))).append(":\tFailed to send message. StatusCode = ").append(((HttpResponse) (obj)).getStatusLine().getStatusCode()).append(n.a).append(s).toString());
        return null;
        return null;
    }

    private HttpParams b()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        HttpProtocolParams.setUserAgent(basichttpparams, System.getProperty("http.agent"));
        return basichttpparams;
    }

    private void b(String s)
    {
        if (n.d(s) || !(h.b.equals(s.trim()) ^ h.a.equals(s.trim())))
        {
            throw new RuntimeException((new StringBuilder("\u9A8C\u8BC1\u8BF7\u6C42\u65B9\u5F0F\u5931\u8D25[")).append(s).append("]").toString());
        } else
        {
            return;
        }
    }

    public g a(Map map)
    {
        b = map;
        return this;
    }

    public i a(h h1, Class class1)
    {
        String s = h1.c().trim();
        b(s);
        if (h.b.equals(s))
        {
            h1 = a(h1.b());
        } else
        if (h.a.equals(s))
        {
            h1 = a(h1.c, h1.a());
        } else
        {
            h1 = null;
        }
        if (h1 == null)
        {
            return null;
        }
        h1 = (i)class1.getConstructor(new Class[] {
            org/json/JSONObject
        }).newInstance(new Object[] {
            h1
        });
        return h1;
        h1;
        u.upd.b.b(a, "SecurityException", h1);
_L2:
        return null;
        h1;
        u.upd.b.b(a, "NoSuchMethodException", h1);
        continue; /* Loop/switch isn't completed */
        h1;
        u.upd.b.b(a, "IllegalArgumentException", h1);
        continue; /* Loop/switch isn't completed */
        h1;
        u.upd.b.b(a, "InstantiationException", h1);
        continue; /* Loop/switch isn't completed */
        h1;
        u.upd.b.b(a, "IllegalAccessException", h1);
        continue; /* Loop/switch isn't completed */
        h1;
        u.upd.b.b(a, "InvocationTargetException", h1);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean a()
    {
        return false;
    }

}
