// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package info.androidhive.proclubDaiict;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package info.androidhive.proclubDaiict:
//            Card

public class CardArrayAdapter extends ArrayAdapter
{
    static class CardViewHolder
    {

        TextView line1;
        TextView line2;

        CardViewHolder()
        {
        }
    }


    private static final String TAG = "CardArrayAdapter";
    private List cardList;

    public CardArrayAdapter(Context context, int i)
    {
        super(context, i);
        cardList = new ArrayList();
    }

    public void add(Card card)
    {
        cardList.add(0, card);
    }

    public volatile void add(Object obj)
    {
        add((Card)obj);
    }

    public Bitmap decodeToBitmap(byte abyte0[])
    {
        return BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
    }

    public int getCount()
    {
        return cardList.size();
    }

    public Card getItem(int i)
    {
        return (Card)cardList.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Card card;
        if (view == null)
        {
            view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03000d, viewgroup, false);
            viewgroup = new CardViewHolder();
            viewgroup.line1 = (TextView)view.findViewById(0x7f0a0015);
            viewgroup.line2 = (TextView)view.findViewById(0x7f0a0016);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (CardViewHolder)view.getTag();
        }
        card = getItem(i);
        ((CardViewHolder) (viewgroup)).line1.setTextColor(0xff000000);
        ((CardViewHolder) (viewgroup)).line1.setText(card.getLine1());
        ((CardViewHolder) (viewgroup)).line2.setTextColor(0xff000000);
        ((CardViewHolder) (viewgroup)).line2.setText(card.getLine2());
        return view;
    }
}
