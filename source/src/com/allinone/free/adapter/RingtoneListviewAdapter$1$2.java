// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.model.Model;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.publicTools;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.adapter:
//            RingtoneListviewAdapter

class val.in_fo extends AsyncTask
{

    private Model model;
    final is._cls0 this$1;
    private final DownloadMovieItem val$in_fo;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = publicTools.getUrl((new StringBuilder("http://t.zedge.net/ringtone/")).append(val$in_fo.getId()).append("/?page=1").toString());
        HashMap hashmap = new HashMap();
        hashmap.put("content", avoid);
        avoid = publicTools.doHttpPost((new StringBuilder("http://android.downloadatoz.com/_201409/market/ringtone_pdt_parser.php?content=")).append(val$in_fo.getId()).toString(), hashmap);
        try
        {
            avoid = new JSONObject(avoid);
            if (avoid.getInt("status") == 1)
            {
                model = new Model();
                model.setRingtoneurl(avoid.getString("url"));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            MydownloadMp3AndRingtone(val$in_fo.getId(), val$in_fo.getTitle(), model.getRingtoneurl());
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            Toast.makeText(RingtoneListviewAdapter.access$1(_fld0), RingtoneListviewAdapter.access$1(_fld0).getString(0x7f0b006e), 1).show();
        }
        void1 = new Intent();
        if (!RingtoneListviewAdapter.access$4(_fld0).equals("ringtonerecent")) goto _L2; else goto _L1
_L1:
        void1.setAction("hiderecentringtone");
_L4:
        RingtoneListviewAdapter.access$1(_fld0).sendBroadcast(void1);
        return;
_L2:
        if (RingtoneListviewAdapter.access$4(_fld0).equals("ringtonepopular"))
        {
            void1.setAction("hidepopularringtone");
        } else
        if (RingtoneListviewAdapter.access$4(_fld0).equals("ringtonesearch"))
        {
            void1.setAction("hidesearchringtone");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onPreExecute()
    {
        Intent intent;
        super.onPreExecute();
        intent = new Intent();
        if (!RingtoneListviewAdapter.access$4(_fld0).equals("ringtonerecent")) goto _L2; else goto _L1
_L1:
        intent.setAction("showrecentringtone");
_L4:
        RingtoneListviewAdapter.access$1(_fld0).sendBroadcast(intent);
        return;
_L2:
        if (RingtoneListviewAdapter.access$4(_fld0).equals("ringtonepopular"))
        {
            intent.setAction("showpopularringtone");
        } else
        if (RingtoneListviewAdapter.access$4(_fld0).equals("ringtonesearch"))
        {
            intent.setAction("showsearchringtone");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    l.in_fo()
    {
        this$1 = final_in_fo1;
        val$in_fo = DownloadMovieItem.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/adapter/RingtoneListviewAdapter$1

/* anonymous class */
    class RingtoneListviewAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final RingtoneListviewAdapter this$0;
        private final DownloadMovieItem val$in_fo;

        public void onClick(View view)
        {
            (new Thread(new RingtoneListviewAdapter._cls1._cls1())).start();
            if (RingtoneListviewAdapter.access$0(RingtoneListviewAdapter.this).getBoolean("isopen", false) && NetWorkUtil.getAPNType(RingtoneListviewAdapter.access$1(RingtoneListviewAdapter.this)) != 1)
            {
                RingtoneListviewAdapter.access$2(RingtoneListviewAdapter.this);
                return;
            }
            if (RingtoneListviewAdapter.access$3(RingtoneListviewAdapter.this).queryfile(in_fo.getId()) == null)
            {
                (in_fo. new RingtoneListviewAdapter._cls1._cls2()).execute(new Void[0]);
                return;
            } else
            {
                RingtoneListviewAdapter.access$5(RingtoneListviewAdapter.this);
                return;
            }
        }


            
            {
                this$0 = final_ringtonelistviewadapter;
                in_fo = DownloadMovieItem.this;
                super();
            }

        // Unreferenced inner class com/allinone/free/adapter/RingtoneListviewAdapter$1$1

/* anonymous class */
        class RingtoneListviewAdapter._cls1._cls1
            implements Runnable
        {

            final RingtoneListviewAdapter._cls1 this$1;
            private final DownloadMovieItem val$in_fo;

            public void run()
            {
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=ringtone&id=")).append(in_fo.getId()).append("&title=").append(in_fo.getTitle()).append("&cat=").append(in_fo.getCat()).append("&downloads=").append(in_fo.getDownloads()).toString());
            }

                    
                    {
                        this$1 = RingtoneListviewAdapter._cls1.this;
                        in_fo = downloadmovieitem;
                        super();
                    }
        }

    }

}
