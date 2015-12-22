// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message.proguard;

import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.umeng.message.proguard:
//            aZ

public class ba extends aZ
{

    private String a[] = {
        "image/jpeg", "image/png"
    };

    public ba()
    {
    }

    public ba(String as[])
    {
        this();
        a = as;
    }

    void a(Message message)
    {
        switch (message.what)
        {
        default:
            super.a(message);
            return;

        case 0: // '\0'
            c((byte[])(byte[])message.obj);
            return;

        case 1: // '\001'
            message = ((Message) ((Object[])(Object[])message.obj));
            break;
        }
        c((Throwable)message[0], (byte[])(byte[])message[1]);
    }

    public void a(Throwable throwable, byte abyte0[])
    {
        b(a(1, ((Object) (new Object[] {
            throwable, abyte0
        }))));
    }

    void a(HttpResponse httpresponse)
    {
        Object obj;
        StatusLine statusline;
        obj = null;
        boolean flag = false;
        statusline = httpresponse.getStatusLine();
        Header aheader[] = httpresponse.getHeaders("Content-Type");
        if (aheader.length != 1)
        {
            a(((Throwable) (new HttpResponseException(statusline.getStatusCode(), "None, or more than one, Content-Type Header found!"))), null);
            return;
        }
        Header header = aheader[0];
        String as[] = a;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (as[i].equals(header.getValue()))
            {
                flag = true;
            }
        }

        if (!flag)
        {
            a(((Throwable) (new HttpResponseException(statusline.getStatusCode(), "Content-Type not allowed!"))), null);
            return;
        }
        httpresponse = httpresponse.getEntity();
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        httpresponse = new BufferedHttpEntity(httpresponse);
_L2:
        httpresponse = EntityUtils.toByteArray(httpresponse);
_L1:
        if (statusline.getStatusCode() >= 300)
        {
            a(((Throwable) (new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()))), ((byte []) (httpresponse)));
            return;
        } else
        {
            b(httpresponse);
            return;
        }
        httpresponse;
        a(((Throwable) (httpresponse)), (byte[])null);
        httpresponse = obj;
          goto _L1
        httpresponse = null;
          goto _L2
    }

    public void a(byte abyte0[])
    {
    }

    public void b(Throwable throwable, byte abyte0[])
    {
        onFailure(throwable);
    }

    public void b(byte abyte0[])
    {
        b(a(0, abyte0));
    }

    void c(Throwable throwable, byte abyte0[])
    {
        b(throwable, abyte0);
    }

    void c(byte abyte0[])
    {
        a(abyte0);
    }
}
