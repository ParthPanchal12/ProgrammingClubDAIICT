// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.umeng.message.entity.UMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.umeng.message:
//            UmengDownloadResourceService, MessageSharedPrefs

public class c extends AsyncTask
{

    UMessage a;
    ArrayList b;
    int c;
    final UmengDownloadResourceService d;

    protected transient Boolean a(Void avoid[])
    {
        avoid = b.iterator();
        boolean flag;
        for (flag = true; avoid.hasNext(); flag = download((String)avoid.next()) & flag) { }
        return Boolean.valueOf(flag);
    }

    protected void a(Boolean boolean1)
    {
        super.onPostExecute(boolean1);
        d.c.remove(a.msg_id);
        if (boolean1.booleanValue() || c <= 0)
        {
            MessageSharedPrefs.getInstance(d.b).c(a.msg_id);
            boolean1 = a.getRaw().toString();
            Intent intent = new Intent(d.b, com/umeng/message/UmengDownloadResourceService);
            intent.putExtra("body", boolean1);
            intent.putExtra("OPERATIOIN", 1);
            intent.putExtra("RETRY_TIME", c);
            d.startService(intent);
        } else
        if (d.c.size() == 0)
        {
            d.stopSelf();
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public boolean download(String s)
    {
        Object obj;
        Exception exception = null;
        Object obj1 = null;
        if (TextUtils.isEmpty(s))
        {
            return true;
        }
        Exception exception1;
        File file;
        Object obj2;
        int i;
        boolean flag;
        try
        {
            obj2 = (new StringBuilder()).append(s.hashCode()).append("").toString();
            obj = UmengDownloadResourceService.getMessageResourceFolder(d.b, a);
            file = new File(((String) (obj)), (new StringBuilder()).append(((String) (obj2))).append(".tmp").toString());
            obj2 = new File(((String) (obj)), ((String) (obj2)));
            flag = ((File) (obj2)).exists();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            s = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            s = null;
            obj1 = exception;
        }
_L4:
        if (flag)
        {
            d.close(null);
            d.close(null);
            return true;
        }
        obj = new File(((String) (obj)));
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdirs();
        }
        if (file.exists())
        {
            file.delete();
        }
        s = (new URL((new URI(s)).toASCIIString())).openStream();
        obj = new FileOutputStream(file);
        obj1 = new byte[10240];
_L3:
        i = s.read(((byte []) (obj1)));
        if (i <= 0) goto _L2; else goto _L1
_L1:
        ((FileOutputStream) (obj)).write(((byte []) (obj1)), 0, i);
          goto _L3
        exception;
        obj1 = obj;
        obj = exception;
_L7:
        ((Exception) (obj)).printStackTrace();
        d.close(s);
        d.close(((java.io.Closeable) (obj1)));
        return false;
_L2:
        file.renameTo(((File) (obj2)));
        d.close(s);
        d.close(((java.io.Closeable) (obj)));
        return true;
_L5:
        d.close(s);
        d.close(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        obj1 = exception;
        continue; /* Loop/switch isn't completed */
        exception1;
        obj1 = obj;
        obj = exception1;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L5; else goto _L4
        obj;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    public I(UmengDownloadResourceService umengdownloadresourceservice, UMessage umessage, int i)
    {
        d = umengdownloadresourceservice;
        super();
        a = umessage;
        b = new ArrayList();
        if (umessage.isLargeIconFromInternet())
        {
            b.add(umessage.img);
        }
        if (umessage.isSoundFromInternet())
        {
            b.add(umessage.sound);
        }
        c = i;
    }
}
