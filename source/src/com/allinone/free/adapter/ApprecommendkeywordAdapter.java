// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.allinone.free.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.allinone.free.model.SearchkeywordModel;
import java.util.List;

public class ApprecommendkeywordAdapter extends BaseAdapter
{
    class ViewHolder
    {

        private TextView searchtitle;
        final ApprecommendkeywordAdapter this$0;
        private TextView xian;




        ViewHolder()
        {
            this$0 = ApprecommendkeywordAdapter.this;
            super();
        }
    }


    private Context ctx;
    private List list;

    public ApprecommendkeywordAdapter(Context context, List list1)
    {
        ctx = context;
        list = list1;
    }

    public int getCount()
    {
        if (list != null && list.size() > 0)
        {
            Log.v("sda", (new StringBuilder(String.valueOf(list.size()))).toString());
            return list.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        SearchkeywordModel searchkeywordmodel = (SearchkeywordModel)list.get(i);
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f03008c, null);
            viewgroup.searchtitle = (TextView)view.findViewById(0x7f06025c);
            viewgroup.xian = (TextView)view.findViewById(0x7f0600bc);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).searchtitle.setText(searchkeywordmodel.getKeyword());
        return view;
    }
}
