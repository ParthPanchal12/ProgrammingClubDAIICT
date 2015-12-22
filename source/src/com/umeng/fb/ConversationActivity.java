// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import com.umeng.fb.fragment.FeedbackFragment;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.res.e;
import com.umeng.fb.res.f;

// Referenced classes of package com.umeng.fb:
//            FeedbackAgent

public class ConversationActivity extends FragmentActivity
{

    private final String a = com/umeng/fb/ConversationActivity.getName();
    private FeedbackFragment b;

    public ConversationActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (android.os.Build.VERSION.SDK_INT >= 11 && getActionBar() != null)
        {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setContentView(f.a(this));
        if (bundle == null)
        {
            String s = getIntent().getStringExtra("conversation_id");
            bundle = s;
            if (s == null)
            {
                bundle = (new FeedbackAgent(this)).getDefaultConversation().getId();
            }
            b = FeedbackFragment.newInstance(bundle);
            getSupportFragmentManager().beginTransaction().add(e.q(this), b).commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    protected void onNewIntent(Intent intent)
    {
        b.refresh();
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
