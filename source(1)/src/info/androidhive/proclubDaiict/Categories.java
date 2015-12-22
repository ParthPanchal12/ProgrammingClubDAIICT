// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.io.PrintStream;
import java.util.List;

// Referenced classes of package info.androidhive.proclubDaiict:
//            MySQLiteHelper, CardArrayAdapter, Card

public class Categories extends Fragment
{

    public Categories()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup list, Bundle bundle)
    {
        bundle = new MySQLiteHelper(getActivity());
        layoutinflater = layoutinflater.inflate(0x7f030007, list, false);
        list = (ListView)layoutinflater.findViewById(0x7f0a0011);
        bundle = bundle.getCategories();
        System.out.print(bundle.size());
        CardArrayAdapter cardarrayadapter = new CardArrayAdapter(getActivity().getApplicationContext(), 0x7f03000d);
        for (int i = 0; i < bundle.size(); i++)
        {
            Card card = new Card((String)bundle.get(i), "");
            System.out.println((new StringBuilder()).append(card.getLine1()).append("dfdfdsfff").toString());
            cardarrayadapter.add(card);
        }

        list.setAdapter(cardarrayadapter);
        list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Categories this$0;
            final ListView val$list;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                adapterview = new Intent("info.androidhive.proclubDaiict.CATEGORYLISTVIEW");
                view = new Bundle();
                view.putString("category", ((Card)list.getItemAtPosition(j)).getLine1());
                adapterview.putExtras(view);
                startActivity(adapterview);
            }

            
            {
                this$0 = Categories.this;
                list = listview;
                super();
            }
        });
        return layoutinflater;
    }
}
