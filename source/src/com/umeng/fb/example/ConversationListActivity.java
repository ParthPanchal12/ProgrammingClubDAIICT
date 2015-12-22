// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.umeng.fb.fragment.FeedbackFragment;

// Referenced classes of package com.umeng.fb.example:
//            ConversationListFragment, ConversationDetailActivity

public class ConversationListActivity extends FragmentActivity
    implements ConversationListFragment.Callbacks
{

    private boolean mTwoPane;

    public ConversationListActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030019);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        if (findViewById(0x7f06005e) != null)
        {
            mTwoPane = true;
            ((ConversationListFragment)getFragmentManager().findFragmentById(0x7f06005f)).setActivateOnItemClick(true);
        }
    }

    public void onItemSelected(String s)
    {
        if (mTwoPane)
        {
            getSupportFragmentManager().beginTransaction().add(0x7f06005e, FeedbackFragment.newInstance(s)).commit();
            return;
        } else
        {
            Intent intent = new Intent(this, com/umeng/fb/example/ConversationDetailActivity);
            intent.putExtra("conversation_id", s);
            startActivity(intent);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            finish();
            break;
        }
        return true;
    }
}
