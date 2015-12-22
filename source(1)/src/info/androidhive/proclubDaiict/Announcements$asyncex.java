// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;

// Referenced classes of package info.androidhive.proclubDaiict:
//            Announcements

public class this._cls0 extends AsyncTask
{

    final Announcements this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        String as1[];
        as = "";
        as1 = as;
        Object obj = (HttpURLConnection)(new URL("https://public-api.wordpress.com/rest/v1.1/sites/proclubannouncementdaiict.wordpress.com/posts?number=30")).openConnection();
        as1 = as;
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        as1 = as;
        ((HttpURLConnection) (obj)).setRequestProperty("Accept", "text/json");
        as1 = as;
        ((HttpURLConnection) (obj)).getResponseCode();
        as1 = as;
        obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L2:
        as1 = as;
        String s = ((BufferedReader) (obj)).readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        as1 = as;
        as = (new StringBuilder()).append(as).append(s).toString();
        if (true) goto _L2; else goto _L1
_L1:
        as1 = as;
        try
        {
            ((BufferedReader) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            as = as1;
        }
        System.out.println("done");
        return as;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        System.out.println("post");
        super.onPostExecute(s);
        try
        {
            System.out.println("try");
            System.out.println((new StringBuilder()).append("yyyyyyyyy").append(jArray.length()).toString());
            u = 30;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public ()
    {
        this$0 = Announcements.this;
        super();
    }
}
