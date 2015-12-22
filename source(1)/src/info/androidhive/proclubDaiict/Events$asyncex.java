// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package info.androidhive.proclubDaiict:
//            Events, Event

public class this._cls0 extends AsyncTask
{

    final Events this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        int i;
        arr = new ArrayList();
        as = new URL("https://www.hackerrank.com/calendar/feed.rss");
        Events.access$002(Events.this, XmlPullParserFactory.newInstance());
        Events.access$102(Events.this, Events.access$000(Events.this).newPullParser());
        Events.access$100(Events.this).setInput(as.openConnection().getInputStream(), "UTF_8");
        i = Events.access$100(Events.this).getEventType();
        boolean flag1;
        flag1 = false;
        as = null;
_L7:
        Events.access$100(Events.this);
        if (i == 1) goto _L2; else goto _L1
_L1:
        Events.access$100(Events.this);
        if (i != 2) goto _L4; else goto _L3
_L3:
        if (!Events.access$100(Events.this).getName().equalsIgnoreCase("item")) goto _L6; else goto _L5
_L5:
        boolean flag = true;
        Object obj = new Event();
_L11:
        i = Events.access$100(Events.this).next();
        as = ((String []) (obj));
        flag1 = flag;
          goto _L7
_L6:
        if (!Events.access$100(Events.this).getName().equalsIgnoreCase("title")) goto _L9; else goto _L8
_L8:
        obj = as;
        flag = flag1;
        if (!flag1) goto _L11; else goto _L10
_L10:
        as.setTitle(Events.access$100(Events.this).nextText());
        obj = as;
        flag = flag1;
          goto _L11
        as;
        as.printStackTrace();
_L2:
        return null;
_L9:
        if (!Events.access$100(Events.this).getName().equalsIgnoreCase("description"))
        {
            break MISSING_BLOCK_LABEL_296;
        }
        obj = as;
        flag = flag1;
        if (!flag1) goto _L11; else goto _L12
_L12:
        as.setDescription(Events.access$100(Events.this).nextText());
        obj = as;
        flag = flag1;
          goto _L11
        as;
        as.printStackTrace();
          goto _L2
        if (!Events.access$100(Events.this).getName().equalsIgnoreCase("url"))
        {
            break MISSING_BLOCK_LABEL_358;
        }
        obj = as;
        flag = flag1;
        if (!flag1) goto _L11; else goto _L13
_L13:
        as.setUrl(Events.access$100(Events.this).nextText());
        obj = as;
        flag = flag1;
          goto _L11
        as;
        as.printStackTrace();
          goto _L2
        if (!Events.access$100(Events.this).getName().equalsIgnoreCase("startTime"))
        {
            break MISSING_BLOCK_LABEL_412;
        }
        obj = as;
        flag = flag1;
        if (!flag1) goto _L11; else goto _L14
_L14:
        as.setStartTime(Events.access$100(Events.this).nextText());
        obj = as;
        flag = flag1;
          goto _L11
        obj = as;
        flag = flag1;
        if (!Events.access$100(Events.this).getName().equalsIgnoreCase("endTime")) goto _L11; else goto _L15
_L15:
        obj = as;
        flag = flag1;
        if (!flag1) goto _L11; else goto _L16
_L16:
        as.setEndTime(Events.access$100(Events.this).nextText());
        obj = as;
        flag = flag1;
          goto _L11
_L4:
        obj = as;
        flag = flag1;
        if (i != 3) goto _L11; else goto _L17
_L17:
        obj = as;
        flag = flag1;
        if (!Events.access$100(Events.this).getName().equalsIgnoreCase("item")) goto _L11; else goto _L18
_L18:
        flag = false;
        arr.add(0, as);
        obj = as;
          goto _L11
    }

    public ()
    {
        this$0 = Events.this;
        super();
    }
}
