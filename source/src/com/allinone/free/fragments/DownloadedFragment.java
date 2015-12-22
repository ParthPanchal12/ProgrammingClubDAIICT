// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.allinone.free.activity.AppDownloadedActivity;
import com.allinone.free.activity.Mp3DownloadedActivity;
import com.allinone.free.activity.RingtoneDownloadedActivity;
import com.allinone.free.activity.VideoDownloadedActivity;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.utils.publicTools;
import com.allinone.free.views.BadgeView;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DownloadedFragment extends Fragment
    implements android.view.View.OnClickListener
{

    private ImageView appicon;
    private BadgeView badgedownimg;
    private TypeDbUtils dbUtils;
    private LinearLayout downloadedapp;
    private LinearLayout downloadedmusic;
    private LinearLayout downloadedringtone;
    private LinearLayout downloadedvideo;
    Handler handler;
    private List listdd;

    public DownloadedFragment()
    {
        handler = new Handler() {

            final DownloadedFragment this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR tableswitch 5656 5656: default 28
            //                           5656 29;
                   goto _L1 _L2
_L1:
                return;
_L2:
                listdd = dbUtils.queryApk("app", "timesort");
                if (listdd == null)
                {
                    listdd = new ArrayList();
                }
                publicTools.noticomplete = listdd.size();
                badgedownimg.setText(String.valueOf(listdd.size()));
                badgedownimg.show();
                if (listdd.size() == 0)
                {
                    badgedownimg.toggle();
                    return;
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = DownloadedFragment.this;
                super();
            }
        };
        dbUtils = null;
    }

    private void buildListener()
    {
        downloadedapp.setOnClickListener(this);
        downloadedmusic.setOnClickListener(this);
        downloadedringtone.setOnClickListener(this);
        downloadedvideo.setOnClickListener(this);
    }

    private void init(View view)
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(getActivity());
        }
        appicon = (ImageView)view.findViewById(0x7f0600b6);
        badgedownimg = new BadgeView(getActivity(), appicon);
        downloadedapp = (LinearLayout)view.findViewById(0x7f060104);
        downloadedmusic = (LinearLayout)view.findViewById(0x7f060105);
        downloadedringtone = (LinearLayout)view.findViewById(0x7f060106);
        downloadedvideo = (LinearLayout)view.findViewById(0x7f060107);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131099908: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/AppDownloadedActivity));
            return;

        case 2131099909: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/Mp3DownloadedActivity));
            return;

        case 2131099910: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/RingtoneDownloadedActivity));
            return;

        case 2131099911: 
            startActivity(new Intent(getActivity(), com/allinone/free/activity/VideoDownloadedActivity));
            break;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003d, null, false);
        init(layoutinflater);
        buildListener();
        (new Timer()).schedule(new TimerTask() {

            final DownloadedFragment this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 5656;
                handler.sendMessage(message);
            }

            
            {
                this$0 = DownloadedFragment.this;
                super();
            }
        }, 0L, 1000L);
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }




}
