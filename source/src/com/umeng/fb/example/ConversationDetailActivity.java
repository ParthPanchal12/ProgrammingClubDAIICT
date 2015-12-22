// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.umeng.fb.fragment.FeedbackFragment;

public class ConversationDetailActivity extends FragmentActivity
{

    private FeedbackFragment mFeedbackFragment;

    public ConversationDetailActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001e);
        if (bundle == null)
        {
            mFeedbackFragment = FeedbackFragment.newInstance(getIntent().getStringExtra("conversation_id"));
            getSupportFragmentManager().beginTransaction().add(0x7f060078, mFeedbackFragment).commit();
        }
    }

    protected void onNewIntent(Intent intent)
    {
        mFeedbackFragment.onRefresh();
    }
}
