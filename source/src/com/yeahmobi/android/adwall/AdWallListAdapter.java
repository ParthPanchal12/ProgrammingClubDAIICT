// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.yeahmobi.android.adwall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.yeahmobi.android.common.util.ImageLoader;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.yeahmobi.android.adwall:
//            AdWallItemRes

public class AdWallListAdapter extends BaseAdapter
{

    private static LayoutInflater inflater = null;
    private Context context;
    private List data;
    public ImageLoader imageLoader;
    private final AdWallItemRes itemRes;

    public AdWallListAdapter(Context context1, AdWallItemRes adwallitemres, List list)
    {
        context = context1;
        itemRes = adwallitemres;
        data = list;
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        imageLoader = new ImageLoader(context);
    }

    public int getCount()
    {
        return data.size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
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
            viewgroup = inflater.inflate(itemRes.getId(), null);
        }
        view = (TextView)viewgroup.findViewById(itemRes.getTitleRes());
        TextView textview = (TextView)viewgroup.findViewById(itemRes.getArtistRes());
        ImageView imageview = (ImageView)viewgroup.findViewById(itemRes.getThumbRes());
        new HashMap();
        HashMap hashmap = (HashMap)data.get(i);
        view.setText((CharSequence)hashmap.get("title"));
        textview.setText((CharSequence)hashmap.get("content"));
        imageLoader.DisplayImage((String)hashmap.get("thumb_url"), imageview);
        return viewgroup;
    }

}
