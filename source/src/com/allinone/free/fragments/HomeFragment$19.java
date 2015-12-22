// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.allinone.free.model.GameInfosVersionModel;
import com.allinone.free.utils.Myutils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.fragments:
//            HomeFragment

class this._cls0
    implements Runnable
{

    final HomeFragment this$0;

    public void run()
    {
        Log.v("version", "11111111getversion");
        Object obj;
        Object obj1;
        obj = (new StringBuilder("http://app.loveitsomuch.com/gonglue_xilie/ping.php?id=")).append(Myutils.packagename2).append("&version=").append("3.0.9").toString();
        Log.v("path", ((String) (obj)));
        obj1 = (HttpURLConnection)(new URL(((String) (obj)))).openConnection();
        ((HttpURLConnection) (obj1)).setConnectTimeout(60000);
        ((HttpURLConnection) (obj1)).setRequestMethod("GET");
        if (((HttpURLConnection) (obj1)).getResponseCode() != 200)
        {
            break MISSING_BLOCK_LABEL_677;
        }
        obj = new StringBuffer();
        obj1 = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getInputStream()));
_L1:
        Object obj2 = ((BufferedReader) (obj1)).readLine();
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_656;
        }
        JSONObject jsonobject;
        GameInfosVersionModel gameinfosversionmodel;
        jsonobject = new JSONObject(((StringBuffer) (obj)).toString());
        status = jsonobject.getInt("status");
        in_control = jsonobject.getInt("in_control");
        HomeFragment.access$32(HomeFragment.this, jsonobject.getString("ad_banner"));
        if (HomeFragment.access$33(HomeFragment.this).equals("admob"))
        {
            obj = new Message();
            obj.what = 10;
            handlertimer.sendMessage(((Message) (obj)));
        }
        HomeFragment.access$34(HomeFragment.this).edit().putString("banner_type", HomeFragment.access$33(HomeFragment.this)).commit();
        Log.v("aaaa", (new StringBuilder("22222222status:")).append(status).toString());
        Log.v("aaaa", (new StringBuilder("3333333in_control")).append(in_control).toString());
        if (status != 1 || in_control != 0)
        {
            break MISSING_BLOCK_LABEL_677;
        }
        gameinfosversionmodel = new GameInfosVersionModel();
        gameinfosversionmodel.setUpdatePath(jsonobject.getString("update_url"));
        Myutils.big_ad_interval = Integer.parseInt(jsonobject.getString("big_ad_interval")) * 1000;
        Log.v("fdfd", (new StringBuilder("dd")).append(Myutils.big_ad_interval).toString());
        if (!jsonobject.getString("big_ad_interval").equals("0"))
        {
            (new Timer()).schedule(new TimerTask() {

                final HomeFragment._cls19 this$1;

                public void run()
                {
                    Message message = new Message();
                    message.what = 20;
                    handlertimer.sendMessage(message);
                }

            
            {
                this$1 = HomeFragment._cls19.this;
                super();
            }
            }, 0L, Myutils.big_ad_interval);
        }
        obj2 = Boolean.valueOf(false);
        Boolean boolean1;
        boolean1 = Boolean.valueOf(false);
        obj = obj2;
        JSONArray jsonarray = jsonobject.getJSONArray("neitui_list");
        obj1 = obj2;
        obj = obj2;
        if (jsonarray.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_551;
        }
        obj = obj2;
        obj1 = Boolean.valueOf(true);
        obj = obj1;
        obj2 = jsonarray.getJSONObject(0);
        obj = obj1;
        gameinfosversionmodel.setNtTitle(((JSONObject) (obj2)).getString("headline"));
        obj = obj1;
        gameinfosversionmodel.setNtMsg(((JSONObject) (obj2)).getString("description"));
        obj = obj1;
        gameinfosversionmodel.setPicPath(((JSONObject) (obj2)).getString("thumb_url"));
        obj = obj1;
        gameinfosversionmodel.setNtPath(((JSONObject) (obj2)).getString("url"));
        obj = obj1;
        gameinfosversionmodel.setNtId(((JSONObject) (obj2)).getString("url_scheme"));
        obj = obj1;
        try
        {
            Log.v("version", "44444");
        }
        catch (Exception exception)
        {
            exception = ((Exception) (obj));
        }
        obj = boolean1;
        if (((Boolean) (obj1)).booleanValue())
        {
            break MISSING_BLOCK_LABEL_606;
        }
        obj = boolean1;
        if (!jsonobject.getString("update_url").equals(""))
        {
            obj = Boolean.valueOf(true);
            gameinfosversionmodel.setNtPath(jsonobject.getString("update_url"));
            Log.v("version", "55555");
        }
        if (((Boolean) (obj1)).booleanValue() || ((Boolean) (obj)).booleanValue())
        {
            handlerversoin.sendMessage(handlerversoin.obtainMessage(564, gameinfosversionmodel));
            Log.v("version", "66666");
            return;
        }
        break MISSING_BLOCK_LABEL_677;
        try
        {
            ((StringBuffer) (obj)).append(((String) (obj2)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return;
        }
          goto _L1
    }


    _cls1.this._cls1()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
