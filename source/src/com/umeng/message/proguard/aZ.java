// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class aZ
{

    protected static final int b = 0;
    protected static final int c = 1;
    protected static final int d = 2;
    protected static final int e = 3;
    private volatile Handler a;

    public aZ()
    {
        if (Looper.myLooper() != null)
        {
            a = new Handler() {

                final aZ a;

                public void handleMessage(Message message)
                {
                    a.a(message);
                }

            
            {
                a = aZ.this;
                super();
            }
            };
        }
    }

    Message a(int i, Object obj)
    {
        if (a != null)
        {
            return a.obtainMessage(i, obj);
        } else
        {
            Message message = new Message();
            message.what = i;
            message.obj = obj;
            return message;
        }
    }

    void a()
    {
        b(a(2, null));
    }

    void a(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            b((String)message.obj);
            return;

        case 1: // '\001'
            message = ((Message) ((Object[])(Object[])message.obj));
            b((Throwable)message[0], (String)message[1]);
            return;

        case 2: // '\002'
            onStart();
            return;

        case 3: // '\003'
            onFinish();
            break;
        }
    }

    void a(String s)
    {
        b(a(0, s));
    }

    void a(Throwable throwable, String s)
    {
        b(a(1, ((Object) (new Object[] {
            throwable, s
        }))));
    }

    void a(Throwable throwable, byte abyte0[])
    {
        b(a(1, ((Object) (new Object[] {
            throwable, abyte0
        }))));
    }

    void a(HttpResponse httpresponse)
    {
        StatusLine statusline = httpresponse.getStatusLine();
        httpresponse = httpresponse.getEntity();
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        httpresponse = EntityUtils.toString(new BufferedHttpEntity(httpresponse), "UTF-8");
_L1:
        if (statusline.getStatusCode() >= 300)
        {
            a(((Throwable) (new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()))), ((String) (httpresponse)));
            return;
        }
        try
        {
            a(((String) (httpresponse)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            a(((Throwable) (httpresponse)), (String)null);
        }
        return;
        httpresponse = null;
          goto _L1
    }

    void b()
    {
        b(a(3, null));
    }

    void b(Message message)
    {
        if (a != null)
        {
            a.sendMessage(message);
            return;
        } else
        {
            a(message);
            return;
        }
    }

    protected void b(String s)
    {
        onSuccess(s);
    }

    protected void b(Throwable throwable, String s)
    {
        onFailure(throwable, s);
    }

    public void onFailure(Throwable throwable)
    {
    }

    public void onFailure(Throwable throwable, String s)
    {
        onFailure(throwable);
    }

    public void onFinish()
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(String s)
    {
    }
}
