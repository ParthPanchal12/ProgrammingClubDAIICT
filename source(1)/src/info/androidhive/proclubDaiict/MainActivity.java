// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import info.androidhive.proclubDaiict.adapter.NavDrawerListAdapter;
import info.androidhive.proclubDaiict.model.NavDrawerItem;
import java.util.ArrayList;

// Referenced classes of package info.androidhive.proclubDaiict:
//            BlogListView, Events, Announcements, Categories, 
//            PagesFragment, WhatsHotFragment, Splash

public class MainActivity extends Activity
{
    private class SlideMenuClickListener
        implements android.widget.AdapterView.OnItemClickListener
    {

        final MainActivity this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            displayView(i);
        }

        private SlideMenuClickListener()
        {
            this$0 = MainActivity.this;
            super();
        }

    }


    public static ArrayList listEvents;
    public static ArrayList timeList;
    private NavDrawerListAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mDrawerTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mTitle;
    private ArrayList navDrawerItems;
    private TypedArray navMenuIcons;
    private String navMenuTitles[];

    public MainActivity()
    {
    }

    private void displayView(int i)
    {
        Object obj = null;
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 100
    //                   1 111
    //                   2 122
    //                   3 133
    //                   4 144
    //                   5 155;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_155;
_L8:
        if (obj != null)
        {
            getFragmentManager().beginTransaction().replace(0x7f0a0004, ((android.app.Fragment) (obj))).commit();
            mDrawerList.setItemChecked(i, true);
            mDrawerList.setSelection(i);
            setTitle(navMenuTitles[i]);
            mDrawerLayout.closeDrawer(mDrawerList);
            return;
        } else
        {
            Log.e("MainActivity", "Error in creating fragment");
            return;
        }
_L2:
        obj = new BlogListView();
          goto _L8
_L3:
        obj = new Events();
          goto _L8
_L4:
        obj = new Announcements();
          goto _L8
_L5:
        obj = new Categories();
          goto _L8
_L6:
        obj = new PagesFragment();
          goto _L8
        obj = new WhatsHotFragment();
          goto _L8
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030001);
        listEvents = new ArrayList();
        timeList = new ArrayList();
        CharSequence charsequence = getTitle();
        mDrawerTitle = charsequence;
        mTitle = charsequence;
        navMenuTitles = getResources().getStringArray(0x7f060001);
        navMenuIcons = getResources().obtainTypedArray(0x7f060000);
        mDrawerLayout = (DrawerLayout)findViewById(0x7f0a0003);
        mDrawerList = (ListView)findViewById(0x7f0a0005);
        navDrawerItems = new ArrayList();
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
        navMenuIcons.recycle();
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
        adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
        mDrawerList.setAdapter(adapter);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0x7f020007, 0x7f080001, 0x7f080001) {

            final MainActivity this$0;

            public void onDrawerClosed(View view)
            {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View view)
            {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }

            
            {
                this$0 = MainActivity.this;
                super(activity, drawerlayout, i, j, k);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        if (bundle == null)
        {
            displayView(0);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f090000, menu);
        return true;
    }

    protected void onDestroy()
    {
        Splash.getInstance().finish();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (!mDrawerToggle.onOptionsItemSelected(menuitem)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        switch (menuitem.getItemId())
        {
        default:
            break; /* Loop/switch isn't completed */

        case 2131361815: 
            continue; /* Loop/switch isn't completed */

        case 2131361816: 
            startActivity(new Intent("info.androidhive.slidingmenu.ABOUT"));
            break;
        }
          goto _L3
_L5:
        return super.onOptionsItemSelected(menuitem);
_L3:
        if (true) goto _L5; else goto _L4
_L4:
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        mDrawerToggle.syncState();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean flag = mDrawerLayout.isDrawerOpen(mDrawerList);
        MenuItem menuitem = menu.findItem(0x7f0a0017);
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        menuitem.setVisible(flag);
        return super.onPrepareOptionsMenu(menu);
    }

    public void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        getActionBar().setTitle(mTitle);
    }



}
