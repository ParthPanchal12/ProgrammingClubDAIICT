// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.adapter.Mp3ListviewAdapter;
import com.allinone.free.model.Model;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.Player;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.fragments:
//            Mp3_Popular_Fragment

class val.arg2 extends AsyncTask
{

    final is._cls0 this$1;
    private final int val$arg2;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = publicTools.getUrl((new StringBuilder("http://mp3box.to/user/download/?song=")).append(((DownloadMovieItem)Mp3_Popular_Fragment.access$9(_fld0).get(val$arg2)).getId()).toString());
        HashMap hashmap = new HashMap();
        hashmap.put("content", avoid);
        avoid = publicTools.doHttpPost((new StringBuilder("http://android.downloadatoz.com/_201409/market/mp3_pdt_parser.php?id=")).append(((DownloadMovieItem)Mp3_Popular_Fragment.access$9(_fld0).get(val$arg2)).getId()).toString(), hashmap);
        try
        {
            avoid = new JSONObject(avoid);
            if (avoid.getInt("status") == 1)
            {
                Mp3_Popular_Fragment.access$11(_fld0, new Model());
                Mp3_Popular_Fragment.access$12(_fld0).setMp3url(avoid.getString("url"));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        try
        {
            Mp3_Popular_Fragment.access$2(_fld0).playUrl(Mp3_Popular_Fragment.access$12(_fld0).getMp3url());
            Mp3_Popular_Fragment.access$13(_fld0, new Timer());
            Mp3_Popular_Fragment.access$14(_fld0, new TimerTask() {

                final Mp3_Popular_Fragment._cls6._cls1 this$2;

                public void run()
                {
                    Message message = new Message();
                    message.what = 200;
                    handler.sendMessage(message);
                }

            
            {
                this$2 = Mp3_Popular_Fragment._cls6._cls1.this;
                super();
            }
            });
            Mp3_Popular_Fragment.access$15(_fld0).schedule(Mp3_Popular_Fragment.access$16(_fld0), 0L, 1000L);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        Mp3_Popular_Fragment.access$0(_fld0).setVisibility(8);
        if (void1 != null);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Mp3_Popular_Fragment.access$0(_fld0).setVisibility(0);
    }


    is._cls0()
    {
        this$1 = final__pcls0;
        val$arg2 = I.this;
        super();
    }

    // Unreferenced inner class com/allinone/free/fragments/Mp3_Popular_Fragment$6

/* anonymous class */
    class Mp3_Popular_Fragment._cls6
        implements android.widget.AdapterView.OnItemClickListener
    {

        final Mp3_Popular_Fragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = getActivity().getSharedPreferences("mp3_popular_data", 0).edit();
            adapterview.putInt("mp3_popular_selector", i);
            adapterview.commit();
            Mp3_Popular_Fragment.access$3(Mp3_Popular_Fragment.this).setVisibility(0);
            Mp3_Popular_Fragment.access$8(Mp3_Popular_Fragment.this).setText(((DownloadMovieItem)Mp3_Popular_Fragment.access$9(Mp3_Popular_Fragment.this).get(i)).getTitle());
            Mp3_Popular_Fragment.access$10(Mp3_Popular_Fragment.this).setBackgroundResource(0x7f020179);
            (i. new Mp3_Popular_Fragment._cls6._cls1()).execute(new Void[0]);
            Mp3_Popular_Fragment.access$17(Mp3_Popular_Fragment.this).notifyDataSetChanged();
        }


            
            {
                this$0 = Mp3_Popular_Fragment.this;
                super();
            }
    }

}
