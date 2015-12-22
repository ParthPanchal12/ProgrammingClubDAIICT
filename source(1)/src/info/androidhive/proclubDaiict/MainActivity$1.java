// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

// Referenced classes of package info.androidhive.proclubDaiict:
//            MainActivity

class init> extends ActionBarDrawerToggle
{

    final MainActivity this$0;

    public void onDrawerClosed(View view)
    {
        getActionBar().setTitle(MainActivity.access$100(MainActivity.this));
        invalidateOptionsMenu();
    }

    public void onDrawerOpened(View view)
    {
        getActionBar().setTitle(MainActivity.access$200(MainActivity.this));
        invalidateOptionsMenu();
    }

    (Activity activity, DrawerLayout drawerlayout, int i, int j, int k)
    {
        this$0 = MainActivity.this;
        super(activity, drawerlayout, i, j, k);
    }
}
