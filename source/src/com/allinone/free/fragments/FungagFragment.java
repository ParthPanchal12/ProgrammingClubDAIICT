// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.allinone.free.adapter.FunAllAdapter;
import com.allinone.free.model.FunModel;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import java.util.ArrayList;

public class FungagFragment extends Fragment
    implements com.allinone.free.refresh.PullableListView.OnLoadListener, OnDismissCallback, ContentValue
{
    class Mya1 extends AsyncTask
    {

        private FunAllAdapter funlistviewadapter;
        final FungagFragment this$0;

        private void ShowResult(String s)
        {
            list.addAll(Myutils.funList(s));
            if (page == 1)
            {
                funlistviewadapter = new FunAllAdapter(getActivity(), list);
                swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(funlistviewadapter);
                swingBottomInAnimationAdapter.setListView(lv_fun_adult);
                lv_fun_adult.setAdapter(swingBottomInAnimationAdapter);
            }
            lv_fun_adult.setHasMoreData(true);
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl((new StringBuilder("http://welaf.com/fun/list.php?cat=gag&tab=new&page=")).append(page).toString());
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            Log.e("www", (new StringBuilder("result=")).append(s).toString());
            if (s == null)
            {
                return;
            } else
            {
                ShowResult(s);
                progress_wheel_fun.setVisibility(8);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel_fun.setVisibility(0);
        }

        Mya1()
        {
            this$0 = FungagFragment.this;
            super();
        }
    }


    private ArrayList list;
    private PullableListView lv_fun_adult;
    private int next;
    private int page;
    private ProgressWheel progress_wheel_fun;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

    public FungagFragment()
    {
        list = new ArrayList();
        page = 1;
        next = 1;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030048, null, false);
        lv_fun_adult = (PullableListView)layoutinflater.findViewById(0x7f06011d);
        progress_wheel_fun = (ProgressWheel)layoutinflater.findViewById(0x7f06011e);
        lv_fun_adult.setOnLoadListener(this);
        lv_fun_adult.setHasMoreData(false);
        (new Mya1()).execute(new Void[0]);
        return layoutinflater;
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onLoad(PullableListView pullablelistview)
    {
        Log.e("www", "onLoad");
        if (list.size() > 0)
        {
            next = ((FunModel)list.get(list.size() - 1)).getHas_next_page();
        }
        if (next == 1)
        {
            page = page + 1;
            (new Mya1()).execute(new Void[0]);
            return;
        } else
        {
            lv_fun_adult.setHasMoreData(false);
            return;
        }
    }






}
