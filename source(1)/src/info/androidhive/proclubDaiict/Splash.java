// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity
{

    static Activity a;

    public Splash()
    {
    }

    public static Activity getInstance()
    {
        return a;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = this;
        try
        {
            Thread.sleep(2L);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        startActivity(new Intent("info.androidhive.proclubDaiict.MAINACTIVITY"));
        finish();
    }
}
