// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;
import com.allinone.free.activity.AppDetailsActivity;
import com.allinone.free.activity.MyMainActivity;
import com.allinone.free.activity.TodaysPickActivity;
import com.allinone.free.utils.Myutils;
import com.umeng.fb.example.CustomActivity;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.allinone.free.jpush:
//            JpushMainActivity

public class MyReceiver extends BroadcastReceiver
{

    private static final String TAG = "JPush";

    public MyReceiver()
    {
    }

    private static String printBundle(Bundle bundle)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return stringbuilder.toString();
            }
            String s = (String)iterator.next();
            if (s.equals(JPushInterface.EXTRA_NOTIFICATION_ID))
            {
                stringbuilder.append((new StringBuilder("\nkey:")).append(s).append(", value:").append(bundle.getInt(s)).toString());
            } else
            {
                stringbuilder.append((new StringBuilder("\nkey:")).append(s).append(", value:").append(bundle.getString(s)).toString());
            }
        } while (true);
    }

    private void processCustomMessage(Context context, Bundle bundle)
    {
        if (JpushMainActivity.isForeground)
        {
            String s = bundle.getString(JPushInterface.EXTRA_MESSAGE);
            bundle.getString(JPushInterface.EXTRA_EXTRA);
            bundle = new Intent("com.example.jpushdemo.MESSAGE_RECEIVED_ACTION");
            bundle.putExtra("message", s);
            context.sendBroadcast(bundle);
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj = intent.getExtras();
        if (!JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        context = ((Bundle) (obj)).getString(JPushInterface.EXTRA_REGISTRATION_ID);
        Log.v("kiki", (new StringBuilder("[MyReceiver] \u63A5\u6536Registration Id : ")).append(context).toString());
_L4:
        return;
_L2:
        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction()))
        {
            Log.d("JPush", (new StringBuilder("[MyReceiver] \u63A5\u6536\u5230\u63A8\u9001\u4E0B\u6765\u7684\u81EA\u5B9A\u4E49\u6D88\u606F: ")).append(((Bundle) (obj)).getString(JPushInterface.EXTRA_MESSAGE)).toString());
            processCustomMessage(context, ((Bundle) (obj)));
            return;
        }
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction()))
        {
            Log.d("JPush", "[MyReceiver] \u63A5\u6536\u5230\u63A8\u9001\u4E0B\u6765\u7684\u901A\u77E5");
            int i = ((Bundle) (obj)).getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            Log.d("JPush", (new StringBuilder("[MyReceiver] \u63A5\u6536\u5230\u63A8\u9001\u4E0B\u6765\u7684\u901A\u77E5\u7684ID: ")).append(i).toString());
            return;
        }
        if (!JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_511;
        }
        Log.d("JPush", "[MyReceiver] \u7528\u6237\u70B9\u51FB\u6253\u5F00\u4E86\u901A\u77E5");
        JPushInterface.reportNotificationOpened(context, ((Bundle) (obj)).getString(JPushInterface.EXTRA_MSG_ID));
        intent = new JSONObject(((Bundle) (obj)).getString(JPushInterface.EXTRA_EXTRA));
        if (intent.isNull("key"))
        {
            obj = new Intent(context, com/umeng/fb/example/CustomActivity);
            ((Intent) (obj)).setFlags(0x10000000);
            context.startActivity(((Intent) (obj)));
        }
        intent = new JSONObject(intent.getString("key"));
        if (!intent.getString("type").equals("base")) goto _L4; else goto _L3
_L3:
        obj = intent.getString("page");
        if (((String) (obj)).equals("home"))
        {
            intent = new Intent(context, com/allinone/free/activity/MyMainActivity);
            intent.setFlags(0x10000000);
            intent.putExtra("jpush", "jpushfan");
            context.startActivity(intent);
            return;
        }
        if (!((String) (obj)).equals("recommendid"))
        {
            break MISSING_BLOCK_LABEL_383;
        }
        intent = intent.getString("id");
        obj = new Intent();
        ((Intent) (obj)).putExtra("myid", intent);
        if (!Myutils.detail_save)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        ((Intent) (obj)).setClass(context, com/allinone/free/activity/AppDetailsActivity);
_L5:
        ((Intent) (obj)).setFlags(0x10000000);
        context.startActivity(((Intent) (obj)));
        return;
        try
        {
            ((Intent) (obj)).setClass(context, com/allinone/free/activity/MyMainActivity);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
          goto _L5
        if (!((String) (obj)).equals("todaypickid"))
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = intent.getString("todayid");
        obj = new Intent();
        ((Intent) (obj)).putExtra("todayid", intent);
        if (!Myutils.today_save)
        {
            break MISSING_BLOCK_LABEL_442;
        }
        ((Intent) (obj)).setClass(context, com/allinone/free/activity/TodaysPickActivity);
_L7:
        ((Intent) (obj)).setFlags(0x10000000);
        context.startActivity(((Intent) (obj)));
        return;
        ((Intent) (obj)).setClass(context, com/allinone/free/activity/MyMainActivity);
        if (true) goto _L7; else goto _L6
_L6:
        if (!((String) (obj)).equals("googleid")) goto _L4; else goto _L8
_L8:
        intent = intent.getString("google_id");
        intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(intent).toString()));
        intent.setFlags(0x10000000);
        context.startActivity(intent);
        return;
        if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction()))
        {
            Log.d("JPush", (new StringBuilder("[MyReceiver] \u7528\u6237\u6536\u5230\u5230RICH PUSH CALLBACK: ")).append(((Bundle) (obj)).getString(JPushInterface.EXTRA_EXTRA)).toString());
            return;
        } else
        {
            Log.d("JPush", (new StringBuilder("[MyReceiver] Unhandled intent - ")).append(intent.getAction()).toString());
            return;
        }
    }
}
