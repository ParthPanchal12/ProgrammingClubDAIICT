// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.allinone.free.activity.MiniGameDetails;
import com.allinone.free.adapter.MinigameListviewAdapter;
import com.allinone.free.model.MiniGameModel;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.utils.ASCIIutil;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

public class MiniGame_Popular_Fragment extends Fragment
    implements com.allinone.free.refresh.PullableListView.OnLoadListener, OnDismissCallback, ContentValue
{
    class MinigameRecentAs extends AsyncTask
    {

        private String myjson;
        final MiniGame_Popular_Fragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            avoid = publicTools.getUrl((new StringBuilder("http://app.loveitsomuch.com/game/h5/game_list.php?ucode=abc&version=1.0&order_type=new&page=")).append(page).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_43;
            }
            try
            {
                myjson = ASCIIutil.toparse(avoid);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            return myjson;
            myjson = null;
            break MISSING_BLOCK_LABEL_38;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (s == null)
            {
                return;
            }
            try
            {
                ShowResult(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            progressWheel.setVisibility(8);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        MinigameRecentAs()
        {
            this$0 = MiniGame_Popular_Fragment.this;
            super();
            myjson = null;
        }
    }


    private MinigameListviewAdapter adapter;
    private ArrayList list;
    private PullableListView listView;
    private int next;
    private int page;
    private ProgressWheel progressWheel;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

    public MiniGame_Popular_Fragment()
    {
        progressWheel = null;
        page = 1;
        next = 1;
        list = new ArrayList();
    }

    private void ApppopulistViewbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)listView.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50F));
        listView.setLayoutParams(layoutparams);
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parseminigamelist(s));
        if (page == 1)
        {
            adapter = new MinigameListviewAdapter(getActivity(), list);
            listView.setAdapter(adapter);
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void init(View view)
    {
        progressWheel = (ProgressWheel)view.findViewById(0x7f060075);
        listView = (PullableListView)view.findViewById(0x7f060073);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030024, null, false);
        init(layoutinflater);
        (new MinigameRecentAs()).execute(new Void[0]);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final MiniGame_Popular_Fragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/allinone/free/activity/MiniGameDetails);
                adapterview.putExtra("pos", i);
                adapterview.putExtra("list", list);
                getActivity().startActivity(adapterview);
            }

            
            {
                this$0 = MiniGame_Popular_Fragment.this;
                super();
            }
        });
        ApppopulistViewbottom();
        return layoutinflater;
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onLoad(PullableListView pullablelistview)
    {
        if (list.size() > 0)
        {
            next = ((MiniGameModel)list.get(list.size() - 1)).getNext();
        }
        if (next == 1)
        {
            page = page + 1;
            (new MinigameRecentAs()).execute(new Void[0]);
            return;
        } else
        {
            listView.setHasMoreData(false);
            return;
        }
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
