// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class SpecialAdapter extends ArrayAdapter
{

    ArrayList arr;

    public SpecialAdapter(Context context, int i, int j, List list)
    {
        super(context, i, j, list);
        arr = new ArrayList();
    }

    public void getData(ArrayList arraylist)
    {
        arr = arraylist;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (TextView)super.getView(i, view, viewgroup);
        if (((Integer)arr.get(i)).intValue() == 0)
        {
            view.setBackgroundColor(0);
            return view;
        } else
        {
            view.setTypeface(null, 1);
            view.setBackgroundColor(Color.rgb(208, 208, 208));
            return view;
        }
    }
}
