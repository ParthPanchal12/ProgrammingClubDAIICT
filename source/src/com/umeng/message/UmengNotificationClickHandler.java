// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.common.message.Log;
import com.umeng.message.entity.UMessage;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.umeng.message:
//            UHandler, PushAgent

public class UmengNotificationClickHandler
    implements UHandler
{

    private static final String a = com/umeng/message/UmengNotificationClickHandler.getName();

    public UmengNotificationClickHandler()
    {
    }

    private Intent a(Intent intent, UMessage umessage)
    {
        if (intent != null && umessage != null && umessage.extra != null)
        {
            umessage = umessage.extra.entrySet().iterator();
            while (umessage.hasNext()) 
            {
                Object obj = (java.util.Map.Entry)umessage.next();
                String s = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (String)((java.util.Map.Entry) (obj)).getValue();
                if (s != null)
                {
                    intent.putExtra(s, ((String) (obj)));
                }
            }
        }
        return intent;
    }

    public void dealWithCustomAction(Context context, UMessage umessage)
    {
    }

    public void handleMessage(Context context, UMessage umessage)
    {
        Class class1;
        Class class2;
        Method method;
        if (!TextUtils.equals("autoupdate", umessage.display_type) || !PushAgent.getInstance(context).isIncludesUmengUpdateSDK())
        {
            break MISSING_BLOCK_LABEL_94;
        }
        umessage = ((UMessage) (PushAgent.getInstance(context).getUpdateResponse()));
        class1 = Class.forName("com.umeng.update.UmengUpdateAgent");
        class2 = Class.forName("com.umeng.update.UpdateResponse");
        method = class1.getMethod("showUpdateDialog", new Class[] {
            android/content/Context, class2
        });
        if (umessage != null)
        {
            try
            {
                method.invoke(class1, new Object[] {
                    context, class2.cast(umessage)
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_128;
        if (TextUtils.isEmpty(umessage.after_open))
        {
            break MISSING_BLOCK_LABEL_186;
        }
        if (TextUtils.equals("go_url", umessage.after_open))
        {
            openUrl(context, umessage);
            return;
        }
        break MISSING_BLOCK_LABEL_129;
        return;
        if (TextUtils.equals("go_activity", umessage.after_open))
        {
            openActivity(context, umessage);
            return;
        }
        if (TextUtils.equals("go_custom", umessage.after_open))
        {
            dealWithCustomAction(context, umessage);
            return;
        }
        if (TextUtils.equals("go_app", umessage.after_open))
        {
            launchApp(context, umessage);
            return;
        }
        if (umessage.url != null && !TextUtils.isEmpty(umessage.url.trim()))
        {
            openUrl(context, umessage);
            return;
        }
        if (umessage.activity != null && !TextUtils.isEmpty(umessage.activity.trim()))
        {
            openActivity(context, umessage);
            return;
        }
        if (umessage.custom != null && !TextUtils.isEmpty(umessage.custom.trim()))
        {
            dealWithCustomAction(context, umessage);
            return;
        }
        launchApp(context, umessage);
        return;
    }

    public void launchApp(Context context, UMessage umessage)
    {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (intent == null)
        {
            Log.b(a, (new StringBuilder()).append("handleMessage(): cannot find app: ").append(context.getPackageName()).toString());
            return;
        } else
        {
            intent.setPackage(null);
            intent.addFlags(0x10000000);
            a(intent, umessage);
            context.startActivity(intent);
            Log.c(a, (new StringBuilder()).append("handleMessage(): lunach app: ").append(context.getPackageName()).toString());
            return;
        }
    }

    public void openActivity(Context context, UMessage umessage)
    {
        if (umessage.activity == null || TextUtils.isEmpty(umessage.activity.trim()))
        {
            return;
        } else
        {
            Intent intent = new Intent();
            a(intent, umessage);
            intent.setClassName(context, umessage.activity);
            intent.addFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
    }

    public void openUrl(Context context, UMessage umessage)
    {
        if (umessage.url == null || TextUtils.isEmpty(umessage.url.trim()))
        {
            return;
        } else
        {
            Log.c(a, (new StringBuilder()).append("handleMessage(): open url: ").append(umessage.url).toString());
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(umessage.url));
            a(intent, umessage);
            intent.addFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
    }

}
