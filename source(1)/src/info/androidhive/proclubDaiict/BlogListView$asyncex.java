// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package info.androidhive.proclubDaiict:
//            BlogListView

public class this._cls0 extends AsyncTask
{

    final BlogListView this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        String s = "";
        as = as[0];
        Object obj = s;
        BufferedReader bufferedreader;
        try
        {
            as = (HttpURLConnection)(new URL(as)).openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            return ((String) (obj));
        }
        obj = s;
        as.setRequestMethod("GET");
        obj = s;
        as.setRequestProperty("Accept", "text/json");
        obj = s;
        as.getResponseCode();
        obj = s;
        bufferedreader = new BufferedReader(new InputStreamReader(as.getInputStream()));
        as = s;
_L2:
        obj = as;
        s = bufferedreader.readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = as;
        as = (new StringBuilder()).append(as).append(s).toString();
        if (true) goto _L2; else goto _L1
_L1:
        obj = as;
        bufferedreader.close();
        return as;
    }

    public _cls9()
    {
        this$0 = BlogListView.this;
        super();
    }
}
