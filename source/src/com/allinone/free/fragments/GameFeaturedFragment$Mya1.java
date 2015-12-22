// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.os.AsyncTask;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;

// Referenced classes of package com.allinone.free.fragments:
//            GameFeaturedFragment

class this._cls0 extends AsyncTask
{

    final GameFeaturedFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=game&page=")).append(GameFeaturedFragment.access$1(GameFeaturedFragment.this)).toString());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if (s == null)
        {
            return;
        } else
        {
            GameFeaturedFragment.access$2(GameFeaturedFragment.this, s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        GameFeaturedFragment.access$0(GameFeaturedFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = GameFeaturedFragment.this;
        super();
    }
}
