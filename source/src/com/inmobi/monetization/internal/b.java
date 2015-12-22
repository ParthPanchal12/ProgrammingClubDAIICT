// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.inmobi.androidsdk.IMBrowserActivity;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.monetization.internal:
//            InvalidManifestConfigException

class b
{

    private static boolean a = false;

    public static Activity a(Activity activity)
    {
        for (; activity.getParent() != null; activity = activity.getParent()) { }
        return activity;
    }

    public static void a(Context context)
        throws InvalidManifestConfigException
    {
        Iterator iterator;
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
        {
            Log.e("[InMobi]-[Monetization]", "App does not have INTERNET permissions. Please provide INTERNET permissions");
            throw new InvalidManifestConfigException(-1);
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
        {
            Log.e("[InMobi]-[Monetization]", "App does not have ACCESS_NETWORK_STATE permissions. Please provide ACCESS_NETWORK_STATE permissions");
            throw new InvalidManifestConfigException(-9);
        }
        iterator = context.getPackageManager().queryIntentActivities(new Intent(context, com/inmobi/androidsdk/IMBrowserActivity), 0x10000).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        context = (ResolveInfo)iterator.next();
        if (!((ResolveInfo) (context)).activityInfo.name.contentEquals("com.inmobi.androidsdk.IMBrowserActivity")) goto _L4; else goto _L3
_L3:
        if (context == null)
        {
            Log.e("[InMobi]-[Monetization]", "IMBrowserActivity not declared in the manifest. Please declare it in the app manifest");
            throw new InvalidManifestConfigException(-2);
        }
        int i = ((ResolveInfo) (context)).activityInfo.configChanges;
        if (i == 0)
        {
            Log.e("[InMobi]-[Monetization]", "IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest");
            throw new InvalidManifestConfigException(-3);
        }
        if ((i & 0x10) == 0)
        {
            Log.e("[InMobi]-[Monetization]", "Missing Config keyboard from android:configChangesof IMBRowserActivity");
            throw new InvalidManifestConfigException(-4);
        }
        if ((i & 0x20) == 0)
        {
            Log.e("[InMobi]-[Monetization]", "Missing Config keyboardHidden from android:configChangesof IMBRowserActivity");
            throw new InvalidManifestConfigException(-5);
        }
        if ((i & 0x80) == 0)
        {
            Log.e("[InMobi]-[Monetization]", "Missing Config orientation from android:configChangesof IMBRowserActivity");
            throw new InvalidManifestConfigException(-6);
        }
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            if ((i & 0x400) == 0)
            {
                Log.e("[InMobi]-[Monetization]", "Missing Config screenSize from android:configChangesof IMBRowserActivity");
                throw new InvalidManifestConfigException(-7);
            }
            if ((i & 0x800) == 0)
            {
                Log.e("[InMobi]-[Monetization]", "Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity");
                throw new InvalidManifestConfigException(-8);
            }
        }
        return;
_L2:
        context = null;
        if (true) goto _L3; else goto _L5
_L5:
    }

}
