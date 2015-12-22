// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.MD5;
import com.allinone.free.utils.Myutils;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.activity:
//            MyMainActivity, PaidforFreeActivity

class this._cls0 extends Handler
{

    final MyMainActivity this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        message.what;
        JVM INSTR lookupswitch 4: default 52
    //                   1: 53
    //                   2: 67
    //                   3: 75
    //                   250: 168;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        Toast.makeText(MyMainActivity.this, "Failed to connect server.", 0).show();
        return;
_L3:
        MyMainActivity.access$14(MyMainActivity.this);
        return;
_L4:
        Toast.makeText(MyMainActivity.this, (new StringBuilder("'")).append(MyMainActivity.access$15(MyMainActivity.this).getTitle()).append("' is added to download queue.").toString(), 0).show();
        message = new Intent();
        message.setAction("homeapp");
        sendBroadcast(message);
        MyMainActivity.access$12(MyMainActivity.this).setVisibility(0);
        MyMainActivity.access$12(MyMainActivity.this).startAnimation(MyMainActivity.access$13(MyMainActivity.this));
        return;
_L5:
        message = message.obj.toString();
        Log.e("www", message);
        try
        {
            message = new JSONObject(message);
            message.getInt("has_next_page");
            if (message.getInt("status") == 1)
            {
                Object obj4 = message.getJSONArray("list");
                Object obj = ((JSONArray) (obj4)).getJSONObject(0);
                message = ((JSONObject) (obj)).getString("icon");
                obj = ((JSONObject) (obj)).getString("price");
                Object obj1 = ((JSONArray) (obj4)).getJSONObject(1);
                String s = ((JSONObject) (obj1)).getString("icon");
                obj1 = ((JSONObject) (obj1)).getString("price");
                Object obj2 = ((JSONArray) (obj4)).getJSONObject(2);
                String s1 = ((JSONObject) (obj2)).getString("icon");
                obj2 = ((JSONObject) (obj2)).getString("price");
                Object obj3 = ((JSONArray) (obj4)).getJSONObject(3);
                String s2 = ((JSONObject) (obj3)).getString("icon");
                obj3 = ((JSONObject) (obj3)).getString("price");
                Object obj5 = ((JSONArray) (obj4)).getJSONObject(4);
                String s3 = ((JSONObject) (obj5)).getString("icon");
                obj5 = ((JSONObject) (obj5)).getString("price");
                Object obj6 = ((JSONArray) (obj4)).getJSONObject(5);
                String s4 = ((JSONObject) (obj6)).getString("icon");
                obj6 = ((JSONObject) (obj6)).getString("price");
                Object obj7 = ((JSONArray) (obj4)).getJSONObject(6);
                String s5 = ((JSONObject) (obj7)).getString("icon");
                obj7 = ((JSONObject) (obj7)).getString("price");
                Object obj8 = ((JSONArray) (obj4)).getJSONObject(7);
                obj4 = ((JSONObject) (obj8)).getString("icon");
                ((JSONObject) (obj8)).getString("price");
                obj8 = new Notification();
                obj8.flags = 16;
                obj8.icon = 0x7f020115;
                Object obj9 = new Intent("android.intent.action.VIEW");
                ((Intent) (obj9)).setClass(getApplicationContext(), com/allinone/free/activity/PaidforFreeActivity);
                obj8.contentIntent = PendingIntent.getActivity(MyMainActivity.this, 54, ((Intent) (obj9)), 0x8000000);
                obj9 = new RemoteViews(getPackageName(), 0x7f03007c);
                ((RemoteViews) (obj9)).setTextViewText(0x7f0601ff, ((CharSequence) (obj)));
                ((RemoteViews) (obj9)).setImageViewBitmap(0x7f0601fe, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(message)).toString()));
                ((RemoteViews) (obj9)).setTextViewText(0x7f060201, ((CharSequence) (obj1)));
                ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060200, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s)).toString()));
                ((RemoteViews) (obj9)).setTextViewText(0x7f060203, ((CharSequence) (obj2)));
                ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060202, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s1)).toString()));
                ((RemoteViews) (obj9)).setTextViewText(0x7f060205, ((CharSequence) (obj3)));
                ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060204, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s2)).toString()));
                ((RemoteViews) (obj9)).setTextViewText(0x7f060207, ((CharSequence) (obj5)));
                ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060206, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s3)).toString()));
                ((RemoteViews) (obj9)).setTextViewText(0x7f060209, ((CharSequence) (obj6)));
                ((RemoteViews) (obj9)).setImageViewBitmap(0x7f060208, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s4)).toString()));
                ((RemoteViews) (obj9)).setTextViewText(0x7f06020b, ((CharSequence) (obj7)));
                ((RemoteViews) (obj9)).setImageViewBitmap(0x7f06020a, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s5)).toString()));
                ((RemoteViews) (obj9)).setTextViewText(0x7f06020d, ((CharSequence) (obj7)));
                ((RemoteViews) (obj9)).setImageViewBitmap(0x7f06020c, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(((String) (obj4)))).toString()));
                obj8.contentView = ((RemoteViews) (obj9));
                MyMainActivity.access$16(MyMainActivity.this).notify(54, ((Notification) (obj8)));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            message.printStackTrace();
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    ty()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
