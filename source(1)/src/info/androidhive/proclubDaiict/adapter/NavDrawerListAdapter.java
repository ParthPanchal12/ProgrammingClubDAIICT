// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import info.androidhive.proclubDaiict.model.NavDrawerItem;
import java.util.ArrayList;

public class NavDrawerListAdapter extends BaseAdapter
{

    private Context context;
    private ArrayList navDrawerItems;

    public NavDrawerListAdapter(Context context1, ArrayList arraylist)
    {
        context = context1;
        navDrawerItems = arraylist;
    }

    public int getCount()
    {
        return navDrawerItems.size();
    }

    public Object getItem(int i)
    {
        return navDrawerItems.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030006, null);
        }
        view = (ImageView)viewgroup.findViewById(0x7f0a000e);
        TextView textview = (TextView)viewgroup.findViewById(0x7f0a000f);
        TextView textview1 = (TextView)viewgroup.findViewById(0x7f0a0010);
        view.setImageResource(((NavDrawerItem)navDrawerItems.get(i)).getIcon());
        textview.setText(((NavDrawerItem)navDrawerItems.get(i)).getTitle());
        if (((NavDrawerItem)navDrawerItems.get(i)).getCounterVisibility())
        {
            textview1.setText(((NavDrawerItem)navDrawerItems.get(i)).getCount());
            return viewgroup;
        } else
        {
            textview1.setVisibility(8);
            return viewgroup;
        }
    }
}
